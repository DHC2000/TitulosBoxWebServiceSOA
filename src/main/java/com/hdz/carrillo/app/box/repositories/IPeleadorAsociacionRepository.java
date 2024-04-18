package com.hdz.carrillo.app.box.repositories;

import com.hdz.carrillo.app.box.models.PeleadorAsociacion;

import java.sql.SQLException;

public interface IPeleadorAsociacionRepository extends IRepository<PeleadorAsociacion>{
    Long guardarReturnId (PeleadorAsociacion peleadorAs) throws SQLException;

}
