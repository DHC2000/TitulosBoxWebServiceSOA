package com.hdz.carrillo.app.box.repositories;

import com.hdz.carrillo.app.box.models.Peleador;
import com.hdz.carrillo.app.box.models.PeleadorAsociacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeleadorAsociacionRepository implements IPeleadorAsociacionRepository {
    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public PeleadorAsociacionRepository(Connection conn){
        this.conn = conn;
    }

    @Override
    public List<PeleadorAsociacion> listar() throws SQLException {
        List<PeleadorAsociacion> peleadorAs = new ArrayList<>();
        try {
            String sql ="SELECT p.nombre, p.ap_paterno, p.ap_materno, o.nombre as organismo, o.iniciales,  po.id_peleador_organizacion as idRel\n" +
                    "FROM peleadores p\n" +
                    "INNER JOIN peleadores_organizaciones po ON p.id_peleador = po.peleador\n" +
                    "INNER JOIN organizaciones o ON po.organizacion = o.id_organizacion";
            Statement stmt = conn.createStatement();
            //sql = "SELECT * FROM peleadores;";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                PeleadorAsociacion a = this.getPeleadorAsociacion(rs);
                peleadorAs.add(a);
            }
            return peleadorAs;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public PeleadorAsociacion getById(Long id) throws SQLException {
        PeleadorAsociacion peleadorAs = null;
        String sql ="SELECT p.nombre, p.ap_paterno, p.ap_materno, o.nombre as organismo, o.iniciales,  po.id_peleador_organizacion as idRel\n" +
                "FROM peleadores p\n" +
                "INNER JOIN peleadores_organizaciones po ON p.id_peleador = po.peleador\n" +
                "INNER JOIN organizaciones o ON po.organizacion = o.id_organizacion  WHERE id_peleador_organizacion = ?";
        try (PreparedStatement stmt =
                     conn.prepareStatement(sql)){
            stmt.setLong(1,id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()){
                    peleadorAs =  this.getPeleadorAsociacion(rs);
                }
            }
        }
       return peleadorAs;
    }

    @Override
    public void guardar(PeleadorAsociacion peleadorA) throws SQLException {
        String sql ="";

        if (peleadorA.getId() != null && peleadorA.getId() > 0){
            sql = "update peleadores_organizaciones"+
                    " set peleador=?, organizacion=?, "+
                    "where id_peleador_organizacion=?";
        }else {
            sql = "insert into peleadores_organizaciones" +
                    "(id_peleador_organizacion,peleador,organizacion)"+
                    "values (sequence_3.NEXTVAL,?,?)";
        }

        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            if(peleadorA.getId() != null && peleadorA.getId() > 0){
                stmt.setInt(1, peleadorA.getPeleadorId());
                stmt.setInt(2, peleadorA.getAsociacionId());
                stmt.setInt(3, peleadorA.getId());
            }else{
                stmt.setInt(1, peleadorA.getPeleadorId());
                stmt.setInt(2, peleadorA.getAsociacionId());
            }
            stmt.executeUpdate();
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    @Override
    public Long guardarReturnId(PeleadorAsociacion peleadorAs) throws SQLException {
        return null;
    }

    private PeleadorAsociacion getPeleadorAsociacion(ResultSet rs) throws SQLException{
        PeleadorAsociacion a = new PeleadorAsociacion();
        a.setId(rs.getInt("idRel"));
        a.setNombre(rs.getString("nombre"));
        a.setApPaterno(rs.getString("ap_paterno"));
        a.setApMaterno(rs.getString("ap_materno"));
        a.setOrganismo(rs.getString("organismo"));
        a.setIniciales(rs.getString("iniciales"));
        return a;
    };
}
