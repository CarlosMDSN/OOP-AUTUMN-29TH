package com.example;

import java.util.List;

public interface CRUDOperations<T> {
    void create(T obj);
    List<T> read();
    void update(T obj);
    void delete(int id);
}
