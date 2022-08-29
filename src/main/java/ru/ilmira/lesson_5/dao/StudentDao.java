package ru.ilmira.lesson_5.dao;

import java.util.List;
import java.util.Optional;

public interface StudentDao<S> {

    Optional<S> findById(long id);

    List<S> findAll();

    void save(S s);

    void update(S s);

    void deleteById(long id);

    void deleteAll();
}


