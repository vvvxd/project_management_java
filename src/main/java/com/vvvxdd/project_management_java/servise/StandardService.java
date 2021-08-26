package com.vvvxdd.project_management_java.servise;

import java.util.List;
/**
 * Стандартный сервис
 */
public interface StandardService<T, K, ID> {
    /**
     * Метод получения по ID
     *
     * @param id - ID
     * @return - K
     */
    K getById(ID id);
    /**
     * Метод получения
     *
     * @return List К
     */
    List<K> getAll();
    /**
     * Метод создания
     *
     * @param s - DTO с заполненными полями без ID
     * @return - ID
     */
    ID save(T s);
    /**
     * Метод обновления
     *
     * @param e - первичный ключ
     * @param s  - DTO  с полями для измениний
     */
    void update(T s, ID e);

    /**
     * Метод удаления
     *
     * @param id - первичный ключ
     */
    void deleteById(ID id);
}
