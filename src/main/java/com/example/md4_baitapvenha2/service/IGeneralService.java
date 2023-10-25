package com.example.md4_baitapvenha2.service;
import java.util.Iterator;
import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save (T t);
    void delete (Long id);
}
