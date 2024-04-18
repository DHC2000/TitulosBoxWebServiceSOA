package com.hdz.carrillo.app.box.controllers;

import com.hdz.carrillo.app.box.models.Organizacion;
import com.hdz.carrillo.app.box.models.Peleador;
import com.hdz.carrillo.app.box.services.IService;
import com.hdz.carrillo.app.box.services.OrganizacionesService;
import com.hdz.carrillo.app.box.services.PeleadoresService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/organizaciones/listar")
public class ListaOrganizacionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<Organizacion> service = new OrganizacionesService(conn);
        List<Organizacion> organizaciones = service.listar();
        req.setAttribute("organizaciones",organizaciones);
        getServletContext().getRequestDispatcher("/listaOrganizaciones.jsp").forward(req,resp);
    }
}
