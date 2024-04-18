package com.hdz.carrillo.app.box.services;

import com.hdz.carrillo.app.box.models.Peleador;
import com.hdz.carrillo.app.box.repositories.IRepository;
import com.hdz.carrillo.app.box.repositories.PeleadoresRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class PeleadoresService implements IService<Peleador>{

    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    private IRepository<Peleador> peleadorRepo;

    public PeleadoresService(Connection conn){
        peleadorRepo = new PeleadoresRepository(conn);
    }
    @Override
    public List<Peleador> listar() {
        try{
            return  peleadorRepo.listar();
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Optional getById(Long id) {
        try{
            return  Optional.ofNullable(peleadorRepo.getById(id));
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Peleador getByIdObj(Long id) throws SQLException {
        try{
            return  peleadorRepo.getById(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
        //Peleador peleador = null;
        /*try (PreparedStatement stmt =
                     conn.prepareStatement("SELECT * FROM PELEADORES WHERE ID_PELEADOR = ?")){
            stmt.setLong(1,id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()){
                    peleador =  this.getPeleador(rs);
                }
            }
        }*/
       // return peleador;
    }

    @Override
    public void guardar(Peleador peleador) {
        try{
            peleadorRepo.guardar(peleador);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void eliminar(Long id) {
        try{
            peleadorRepo.eliminar(id);
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
