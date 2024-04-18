package com.hdz.carrillo.app.box.repositories;

import com.hdz.carrillo.app.box.models.Organizacion;
import com.hdz.carrillo.app.box.models.Peleador;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrganizacionesRepository implements IRepository<Organizacion>{

    private Connection conn;

    public OrganizacionesRepository(Connection conn){
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Organizacion> listar() throws SQLException {
        List<Organizacion> organizacion = new ArrayList<>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM organizaciones");
            while (rs.next()) {
                Organizacion a = this.getOrganizacion(rs);
                organizacion.add(a);
            }
            return organizacion;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Organizacion getById(Long id) throws SQLException {
        return null;
    }


    @Override
    public void guardar(Organizacion r) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    private Organizacion getOrganizacion(ResultSet rs) throws SQLException{
        Organizacion a = new Organizacion();
        a.setId(rs.getLong("id_organizacion"));
        a.setNombre(rs.getString("nombre"));
        a.setIniciales(rs.getString("iniciales"));
        return a;
    };
}
