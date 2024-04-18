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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@WebServlet("/peleador/editar")
public class EdicionPeleadorServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // getServletContext().getRequestDispatcher("/edicionPeleador.jsp").forward(req,resp);
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Peleador> service = new PeleadoresService(conn);

        long id;
        try{
            id= Long.parseLong(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0L;
        }
        Peleador peleador = new Peleador();
        if(id > 0){
            Optional<Peleador> o = service.getById(id);
            if (o.isPresent()){
                peleador = o.get();
                req.setAttribute("peleador",peleador);
                getServletContext().getRequestDispatcher("/edicionPeleador.jsp").forward(req,resp);
            }else {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND,"No existe el peleador en la base de datos");
            }
        }else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND,"ERROR: Id es nulo, se debe enviar como parametro en la URL");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Peleador> service = new PeleadoresService(conn);

        String nombre = req.getParameter("nombre");
        String apPaterno = req.getParameter("apPaterno");
        String apMaterno = req.getParameter("apMaterno");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String nacionalidad = req.getParameter("nacionalidad");
        String alcance = req.getParameter("alcance");

        LocalDate fecha;

        try {
            fecha = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }catch (DateTimeParseException e){
            fecha = null;
        }

        Map<String,String> errores = new HashMap<>();

        if (nombre == null || nombre.isBlank()){
            errores.put("nombre","el nombre es requerido!");
        }
        if (apPaterno == null || apPaterno.isBlank()){
            errores.put("apPaterno","el apellido paterno es requerido!");
        }
        if (apMaterno == null || apMaterno.isBlank()){
            errores.put("apPaterno","el apellido materno es requerido!");
        }
        if (fechaNacimiento == null || fechaNacimiento.isBlank()){
            errores.put("fechaNacimiento","la fecha de nacimiento es requerida!");
        }
        if (nacionalidad == null || nacionalidad.isBlank()){
            errores.put("nacionalidad","la nacionalidad es requerida!");
        }
        if (alcance == null || alcance.isBlank()){
            errores.put("alcance","el alcance es requerido!");
        }
        long id;
        id = Long.parseLong(req.getParameter("id"));

        Peleador peleador = new Peleador();
        peleador.setId(id);
        peleador.setNombre(nombre);
        peleador.setApPaterno(apPaterno);
        peleador.setApMaterno(apMaterno);
        peleador.setFechaNacimiento(fecha);
        peleador.setNacionalidad(nacionalidad);
        peleador.setAlcance(Float.parseFloat(alcance));

        if (errores.isEmpty()){

            service.guardar(peleador);
            resp.sendRedirect(req.getContextPath()+"/peleadores/listar");
        }
        else {
            req.setAttribute("errores",errores);
            getServletContext().getRequestDispatcher("/edicionPeleador.jsp").forward(req,resp);
        }
    }

}
