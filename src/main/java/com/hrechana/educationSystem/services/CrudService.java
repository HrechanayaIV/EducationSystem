package com.hrechana.educationSystem.services;

import java.util.List;

public interface CrudService<E, K> {
    E getById(K id);

    E create(E entity);

    E update(E entity);

    K deleteById(K id);

    List<E> getAll();
}
