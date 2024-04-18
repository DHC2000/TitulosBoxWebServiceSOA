package com.hdz.carrillo.app.box.services;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IService<T>{

    List<T> listar();
    Optional<T> getById(Long id);
    //T getById(Long id);
    T getByIdObj(Long id) throws SQLException;

    void guardar(T t);

    void eliminar(Long id);
}
