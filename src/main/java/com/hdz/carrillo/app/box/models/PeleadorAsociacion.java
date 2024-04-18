package com.hdz.carrillo.app.box.models;

public class PeleadorAsociacion {

    private Integer id;
    private Integer peleadorId;
    private Integer asociacionId;
    private String nombre;
    private String apPaterno;
    private String apMaterno;
    private String organismo;
    private String iniciales;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPeleadorId() {
        return peleadorId;
    }

    public void setPeleadorId(Integer peleadorId) {
        this.peleadorId = peleadorId;
    }

    public Integer getAsociacionId() {
        return asociacionId;
    }

    public void setAsociacionId(Integer asociacionId) {
        this.asociacionId = asociacionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getOrganismo() {
        return organismo;
    }

    public void setOrganismo(String organismo) {
        this.organismo = organismo;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }
}
