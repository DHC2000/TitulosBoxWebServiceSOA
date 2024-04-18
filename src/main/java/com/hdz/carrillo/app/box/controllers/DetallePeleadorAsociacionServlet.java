package com.hdz.carrillo.app.box.controllers;

import com.hdz.carrillo.app.box.models.Peleador;
import com.hdz.carrillo.app.box.models.PeleadorAsociacion;
import com.hdz.carrillo.app.box.services.IService;
import com.hdz.carrillo.app.box.services.PeleadorAsociacionService;
import com.hdz.carrillo.app.box.services.PeleadoresService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;

@WebServlet("/peleadorAsociacion/detalles")
public class DetallePeleadorAsociacionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<PeleadorAsociacion> service = new PeleadorAsociacionService(conn);

        long id;

        try{
            id= Long.parseLong(req.getParameter("id"));

        }catch (NumberFormatException e){
            id = 0L;
        }

        PeleadorAsociacion peleadorAs = new PeleadorAsociacion();
        if(id > 0){
            Optional<PeleadorAsociacion> o = service.getById(id);
            if (o.isPresent()){
                peleadorAs = o.get();
                req.setAttribute("peleadorAs",peleadorAs);
                getServletContext().getRequestDispatcher("/detallePeleadorAsociacion.jsp").forward(req,resp);
            }else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND,"No existe el registro en la base de datos");
            }
        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"ERROR: Id es nulo, se debe enviar como parametro en la URL");
        }
    }

}
