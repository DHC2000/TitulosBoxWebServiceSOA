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

@WebServlet("/peleas/alta")
public class AltaPeleaServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/altaPelea.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Peleador> service = new PeleadoresService(conn);

        String nombre = req.getParameter("peleador1");
        String apPaterno = req.getParameter("peleador2");
        String apMaterno = req.getParameter("division");
        String fechaNacimiento = req.getParameter("cede");
        LocalDate fecha;

        try {
            //fecha = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            fecha = LocalDate.parse(fechaNacimiento, DateTimeFormatter.ofPattern("yyyy-dd-MM"));

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
        if (errores.isEmpty()){
            Peleador peleador = new Peleador();
            peleador.setId(0L);
            peleador.setNombre(nombre);
            peleador.setApPaterno(apPaterno);
            peleador.setApMaterno(apMaterno);
            peleador.setFechaNacimiento(fecha);
            service.guardar(peleador);
            resp.sendRedirect(req.getContextPath()+"/peleadores/listar");
        }
        else {
            req.setAttribute("errores",errores);
            getServletContext().getRequestDispatcher("/altaPeleador.jsp").forward(req,resp);
        }
    }

}
