package com.hdz.carrillo.app.box.repositories;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IRepository <T>{

    List<T> listar() throws SQLException;
    //Optional<T> getById(Long id) throws SQLException;

   T getById(Long id) throws SQLException;
    void guardar(T r) throws SQLException;

    void eliminar(Long id) throws SQLException;
}
