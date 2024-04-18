package com.hdz.carrillo.app.box.services;

import com.hdz.carrillo.app.box.models.Organizacion;
import com.hdz.carrillo.app.box.models.Peleador;
import com.hdz.carrillo.app.box.models.PeleadorAsociacion;
import com.hdz.carrillo.app.box.repositories.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PeleadorAsociacionService implements IPeleadorAsociacionService{

    private IRepository<Peleador> peleadorRepo;
    private IRepository<Organizacion> organizacionRepo;

    private IRepository<PeleadorAsociacion> peleadorAsRepo;

    private IPeleadorAsociacionRepository peleadorAsociacionRepo;

    Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public PeleadorAsociacionService(Connection conn){
        this.peleadorRepo = new PeleadoresRepository(conn);
        this.organizacionRepo = new OrganizacionesRepository(conn);
        this.peleadorAsRepo = new PeleadorAsociacionRepository(conn);
        this.peleadorAsociacionRepo = new PeleadorAsociacionRepository(conn);
    }
    @Override
    public List<Peleador> listaPeleador() {
        try{
            return  peleadorRepo.listar();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Organizacion> listaOrganizacion() {
        try{
            return  organizacionRepo.listar();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Long guardarReturnId(PeleadorAsociacion peleadorAs) {
        try {
            return peleadorAsociacionRepo.guardarReturnId(peleadorAs);
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(),e.getCause());
        }
    }

    @Override
    public List<PeleadorAsociacion> listar() {
        try{
            return  peleadorAsociacionRepo.listar();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional getById(Long id) {
        try{
            return  Optional.ofNullable(peleadorAsRepo.getById(id));
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public PeleadorAsociacion getByIdObj(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(PeleadorAsociacion peleadorAsociacion) {
        try{
            peleadorAsRepo.guardar(peleadorAsociacion);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void eliminar(Long id) {

    }

    /*private Peleador getPeleador(ResultSet rs) throws SQLException{
        Peleador a = new Peleador();
        a.setId(rs.getLong("id_peleador"));
        a.setNombre(rs.getString("nombre"));
        a.setApPaterno(rs.getString("ap_paterno"));
        a.setApMaterno(rs.getString("ap_materno"));
        a.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
        return a;
    };*/
}
