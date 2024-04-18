package com.hdz.carrillo.app.box.services;

import com.hdz.carrillo.app.box.models.Organizacion;
import com.hdz.carrillo.app.box.models.Peleador;
import com.hdz.carrillo.app.box.models.PeleadorAsociacion;

import java.util.List;

public interface IPeleadorAsociacionService extends IService<PeleadorAsociacion> {

    List<Peleador> listaPeleador();
    List<Organizacion> listaOrganizacion();

    Long guardarReturnId(PeleadorAsociacion peleadorAs);
}
