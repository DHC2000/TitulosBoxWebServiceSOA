package com.hdz.carrillo.app.box.models.enums;

public enum Asociaciones {

    OMB("Organización Mundial de Boxeo"),
    AMB("Asociación Mundial de Boxeo"),
    FIB("Federación Internacional de Boxeo"),
    CMB("Consejo Mndial de Boxeo");
   // WMB("Consejo Mndial de Boxeo"),
   // WBA("Asociación Mundial de Boxeo");

    private final String name;
    Asociaciones(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}
