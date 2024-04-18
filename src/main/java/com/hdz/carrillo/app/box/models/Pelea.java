package com.hdz.carrillo.app.box.models;

import java.time.LocalDate;

public class Pelea {

    private Long idPelea;
    private String nombreP1;
    private String apPaternoP1;
    private String apMaternoP1;
    private Long idP1;
    private Long idP2;
    private String nombreP2;
    private String apPaternoP2;
    private String apMaternoP2;
    private LocalDate fecha;
    private String sede;
    private String division;

    public Long getIdPelea() {
        return idPelea;
    }

    public void setIdPelea(Long idPelea) {
        this.idPelea = idPelea;
    }

    public String getNombreP1() {
        return nombreP1;
    }

    public void setNombreP1(String nombreP1) {
        this.nombreP1 = nombreP1;
    }

    public String getApPaternoP1() {
        return apPaternoP1;
    }

    public void setApPaternoP1(String apPaternoP1) {
        this.apPaternoP1 = apPaternoP1;
    }

    public String getApMaternoP1() {
        return apMaternoP1;
    }

    public void setApMaternoP1(String apMaternoP1) {
        this.apMaternoP1 = apMaternoP1;
    }

    public Long getIdP1() {
        return idP1;
    }

    public void setIdP1(Long idP1) {
        this.idP1 = idP1;
    }

    public Long getIdP2() {
        return idP2;
    }

    public void setIdP2(Long idP2) {
        this.idP2 = idP2;
    }

    public String getNombreP2() {
        return nombreP2;
    }

    public void setNombreP2(String nombreP2) {
        this.nombreP2 = nombreP2;
    }

    public String getApPaternoP2() {
        return apPaternoP2;
    }

    public void setApPaternoP2(String apPaternoP2) {
        this.apPaternoP2 = apPaternoP2;
    }

    public String getApMaternoP2() {
        return apMaternoP2;
    }

    public void setApMaternoP2(String apMaternoP2) {
        this.apMaternoP2 = apMaternoP2;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
