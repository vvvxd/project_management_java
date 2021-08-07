package com.vvvxdd.project_management_java.servise;

import java.util.List;

public interface StandardService<T, K, ID> {

    K getById(ID id);

    List<K> getAll();

    K save(T s);

    K update(T s, ID e);

    K deleteById(ID id);
}
