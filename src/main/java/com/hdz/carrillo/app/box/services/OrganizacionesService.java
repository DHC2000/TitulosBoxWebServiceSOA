package com.hdz.carrillo.app.box.services;

import com.hdz.carrillo.app.box.models.Organizacion;
import com.hdz.carrillo.app.box.models.Peleador;
import com.hdz.carrillo.app.box.repositories.IRepository;
import com.hdz.carrillo.app.box.repositories.OrganizacionesRepository;
import com.hdz.carrillo.app.box.repositories.PeleadoresRepository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class OrganizacionesService implements IService<Organizacion>{

    private IRepository<Organizacion> organizacionRepo;

    public OrganizacionesService(Connection conn){
       organizacionRepo = new OrganizacionesRepository(conn);
    }
    @Override
    public List<Organizacion> listar() {
        try{
            return  organizacionRepo.listar();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional<Organizacion> getById(Long id) {
        return Optional.empty();
    }

    @Override
    public Organizacion getByIdObj(Long id) throws SQLException {
        return null;
    }


    @Override
    public void guardar(Organizacion organizacion) {

    }

    @Override
    public void eliminar(Long id) {

    }
}
