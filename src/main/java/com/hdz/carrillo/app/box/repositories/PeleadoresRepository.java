package com.hdz.carrillo.app.box.repositories;

import com.hdz.carrillo.app.box.models.Peleador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeleadoresRepository implements IRepository <Peleador>{

    private Connection conn;
    private IRepository<Peleador> peleadorRepo;

    public PeleadoresRepository(Connection conn){
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Peleador> listar() throws SQLException {
        List<Peleador> peleador = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM peleadores");
            while (rs.next()) {
                Peleador a = this.getPeleador(rs);
                peleador.add(a);
            }
            return peleador;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Peleador getById(Long id) throws SQLException {
        Peleador peleador = null;
         try (PreparedStatement stmt =
                     conn.prepareStatement("SELECT * FROM PELEADORES WHERE ID_PELEADOR = ?")){
            stmt.setLong(1,id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()){
                    peleador =  this.getPeleador(rs);
                }
            }
        }
        return peleador;
    }

   /* @Override
    public Optional getById(Long id) {
        try{
            return  Optional.ofNullable(peleadorRepo.getById(id));
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }*/


    @Override
    public void guardar(Peleador peleador) throws SQLException {
        String sql ="";

        if (peleador.getId() != null && peleador.getId() > 0){
            sql = "UPDATE peleadores SET nombre=?, ap_paterno=?, "+
                    "ap_materno=?,fecha_nacimiento=?, "+
                    "nacionalidad=?,alcance=? "+
                    "WHERE id_peleador=?";
        }else {
            sql = "INSERT INTO peleadores(id_peleador, nombre, "+
                    "ap_paterno, ap_materno,fecha_nacimiento, "+
                    "nacionalidad,alcance) "+
                    "VALUES(sequence_1.NEXTVAL,?,?,?,?,?,?)";
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            if(peleador.getId() != null && peleador.getId() > 0){
                stmt.setString(1, peleador.getNombre());
                stmt.setString(2, peleador.getApPaterno());
                stmt.setString(3, peleador.getApMaterno());
                stmt.setDate(4, Date.valueOf(peleador.getFechaNacimiento()));
                stmt.setString(5, peleador.getNacionalidad());
                stmt.setFloat(6, peleador.getAlcance());
                stmt.setLong(7, peleador.getId());
            }else{
                stmt.setString(1, peleador.getNombre());
                stmt.setString(2, peleador.getApPaterno());
                stmt.setString(3, peleador.getApMaterno());
                stmt.setDate(4, Date.valueOf(peleador.getFechaNacimiento()));
                stmt.setString(5, peleador.getNacionalidad());
                stmt.setFloat(6, peleador.getAlcance());
            }
            stmt.executeUpdate();
        }
    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "delete from peleadores where id_peleador =?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1,id);
            stmt.executeUpdate();
        }
    }

    private Peleador getPeleador(ResultSet rs) throws SQLException{
        Peleador a = new Peleador();
        a.setId(rs.getLong("id_peleador"));
        a.setNombre(rs.getString("nombre"));
        a.setApPaterno(rs.getString("ap_paterno"));
        a.setApMaterno(rs.getString("ap_materno"));
        a.setFechaNacimiento(rs.getDate("fecha_nacimiento").toLocalDate());
        a.setNacionalidad(rs.getString("nacionalidad"));
        a.setAlcance(rs.getFloat("alcance"));
        return a;
    };
}
