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
import java.util.List;

@WebServlet("/peleadores/listar")
public class ListaPeleadoresServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");

        IService<Peleador> service = new PeleadoresService(conn);
        List<Peleador> peleadores = service.listar();
        req.setAttribute("peleadores",peleadores);
        getServletContext().getRequestDispatcher("/listaPeleadores.jsp").forward(req,resp);

    }
}
