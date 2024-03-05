package com.example.minitest1.service;

import java.util.Optional;

public interface IGenerateRepository<T> {
    Iterable<T> findAll();

    void save(T t);

    Optional<T> findById(Integer id);
    void remove(Integer id);
}
