package com.hrechana.educationSystem.repositories;

import java.util.List;

public interface CrudDAO <E,K>{
    E getById(K id);
    E create(E entity);
    E update(E entity);
    K deleteById(K id);
    List<E> getAll();
}
