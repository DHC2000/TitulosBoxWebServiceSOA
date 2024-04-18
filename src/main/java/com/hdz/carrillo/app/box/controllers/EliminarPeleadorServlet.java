package com.hdz.carrillo.app.box.controllers;

import com.hdz.carrillo.app.box.models.Peleador;
import com.hdz.carrillo.app.box.services.IService;
import com.hdz.carrillo.app.box.services.PeleadoresService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@WebServlet("/peleadores/eliminar")
public class EliminarPeleadorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Peleador> service = new PeleadoresService(conn);
        //Map<String,String> errores = new HashMap<>();

        long id;
        try{
            id= Long.parseLong(req.getParameter("id"));

        }catch (NumberFormatException e){
            id = 0L;
        }

        // Camion camion = new Camion();
        if(id > 0){
            Optional<Peleador> o = service.getById(id);
            if (o.isPresent()){
                service.eliminar(id);
                resp.sendRedirect(req.getContextPath()+"/peleadores/listar");
            }else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND,"No existe el peleador en la base de datos");
            }
        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"ERROR: Id es nulo, se debe enviar como parametro en la URL");
        }
    }

}
