package com.vvvxdd.project_management_java.servise.implementation;

import com.vvvxdd.project_management_java.entity.ProjectEntity;
import com.vvvxdd.project_management_java.entity.ReleaseEntity;
import com.vvvxdd.project_management_java.entity.TaskEntity;
import com.vvvxdd.project_management_java.entity.UserEntity;
import com.vvvxdd.project_management_java.exception.*;
import com.vvvxdd.project_management_java.mapper.TasksMapper;
import com.vvvxdd.project_management_java.repository.ProjectsRepository;
import com.vvvxdd.project_management_java.repository.ReleasesRepository;
import com.vvvxdd.project_management_java.repository.TasksRepository;
import com.vvvxdd.project_management_java.repository.UsersRepository;
import com.vvvxdd.project_management_java.rest.dto.TaskStatus;
import com.vvvxdd.project_management_java.rest.dto.TasksRequestDto;
import com.vvvxdd.project_management_java.rest.dto.TasksResponseDto;
import com.vvvxdd.project_management_java.servise.TasksService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksServiceImpl implements TasksService {
    private final TasksRepository tasksRepository;
    private final ProjectsRepository projectsRepository;
    private final ReleasesRepository releasesRepository;
    private final UsersRepository usersRepository;

    public TasksServiceImpl(TasksRepository tasksRepository, ProjectsRepository projectsRepository, ReleasesRepository releasesRepository, UsersRepository usersRepository) {
        this.tasksRepository = tasksRepository;
        this.projectsRepository = projectsRepository;
        this.releasesRepository = releasesRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public TasksResponseDto getById(Long id) {
        TaskEntity taskEntity = tasksRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException(String.format("There is no task with id = %d", id))
        );
        return TasksMapper.INSTANCE.toDto(tasksRepository.getById(id));
    }

    @Override
    public List<TasksResponseDto> getAll() {
        List<TasksResponseDto> responseDtos = tasksRepository.findAll().stream().map(TasksMapper.INSTANCE::toDto).collect(Collectors.toList());
        return responseDtos;
    }

    @Override
    public Long save(TasksRequestDto task) {
        TaskEntity taskEntity = TasksMapper.INSTANCE.toEntity(task);
        taskEntity = tasksRepository.save(taskEntity);
        return taskEntity.getTaskId();
    }

    @Override
    public void update(TasksRequestDto tasksRequestDto, Long id) {
        TaskEntity taskEntity = tasksRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException(String.format("There is no task with id = %d", id))
        );
        if (taskEntity.getStatus() == TaskStatus.DONE || taskEntity.getStatus() == TaskStatus.BACKLOG) {
            throw new IncorrectArgumentException("Task in DONE or BACKLOG state  can't be modified");
        }
        Long  newProject = tasksRequestDto.getProjectId();
        if (newProject!= null && newProject != taskEntity.getProjectId()){
            ProjectEntity projectEntity = projectsRepository.findById(id).orElseThrow(
                    () -> new ProjectNotFoundException(String.format("There is no project with id = %d", id))
            );
            taskEntity.setProjectId(newProject);
        }
        Long  newRelease = tasksRequestDto.getReleaseId();
        if (newRelease!= null && newRelease != taskEntity.getReleaseId()){
            ReleaseEntity releaseEntity = releasesRepository.findById(id).orElseThrow(
                    () -> new ReleaseNotFoundException(String.format("There is no release with id = %d", id))
            );
            taskEntity.setReleaseId(newRelease);
        }
        Long  newExecutor = tasksRequestDto.getExecutorId();
        if (newExecutor!= null && newExecutor != taskEntity.getExecutorId()){
            UserEntity userEntity = usersRepository.findById(id).orElseThrow(
                    () -> new UserNotFoundException(String.format("There is no user with id = %d", id))
            );
            taskEntity.setExecutorId(newExecutor);
        }
        Long  newCustomer = tasksRequestDto.getCustomerId();
        if (newCustomer!= null && newCustomer!=taskEntity.getCustomerId()){
            UserEntity userEntity = usersRepository.findById(id).orElseThrow(
                    () -> new UserNotFoundException(String.format("There is no user with id = %d", id))
            );
            taskEntity.setCustomerId(newCustomer);
        }
        taskEntity.setStatus(tasksRequestDto.getStatus());

        tasksRepository.save(taskEntity);
    }

    @Override
    public void deleteById(Long id) {
        TaskEntity taskEntity = tasksRepository.findById(id).orElseThrow(
                () -> new TaskNotFoundException(String.format("There is no task with id = %d", id))
        );
        tasksRepository.deleteById(id);
    }
    public long add(MultipartFile file) {

        String filepath = storageService.store(file);

        try (Reader in = new FileReader(filepath)){
            CSVFormat format = CSVFormat.Builder
                    .create(CSVFormat.RFC4180)
                    .setHeader(TaskCreateDto.fields)
                    .build();

            Iterable<CSVRecord> records = format.parse(in);
            Iterator<CSVRecord> iterator = records.iterator();
            if (iterator.hasNext()) {
                CSVRecord record = iterator.next();

                String name = record.get("name");
                if (name == null || name.isEmpty()) {
                    throw new IllegalArgumentException("Task name can't be an empty string");
                }

                String description = record.get("description");
                if (description == null || description.isEmpty()) {
                    throw new IllegalArgumentException("Task description can't be an empty string");
                }

                long authorId;
                String authorIdString = record.get("authorId");
                if (authorIdString == null || authorIdString.isEmpty()) {
                    throw new IllegalArgumentException("Task should have an author defined");
                } else {
                    try {
                        authorId = Long.parseLong(authorIdString);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Author id should have a valid number format.");
                    }
                }

                long releaseId;
                String releaseIdString = record.get("releaseId");
                if (releaseIdString == null || releaseIdString.isEmpty()) {
                    throw new IllegalArgumentException("Task should have a release defined");
                } else {
                    try {
                        releaseId = Long.parseLong(releaseIdString);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Release id should have a valid number format.");
                    }
                }

                Long executorId;
                String executorIdString = record.get("executorId");
                if (executorIdString == null || executorIdString.isEmpty()) {
                    executorId = null;
                } else {
                    try {
                        executorId = Long.parseLong(executorIdString);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Executor id should have a valid number format.");
                    }
                }

                return this.add(new TaskCreateDto(name, description, authorId, executorId, releaseId));
            } else {
                throw new IllegalArgumentException("There are no records in CSV file");
            }
        } catch (FileNotFoundException ex) {
            throw new BoardAppStorageException("Uploaded file can't be founded.");
        } catch (IOException ex) {
            throw new BoardAppStorageException("Uploaded file can't be read.");
        }
    }


}
