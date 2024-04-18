package com.hdz.carrillo.app.box.controllers;
import com.hdz.carrillo.app.box.models.PeleadorAsociacion;
import com.hdz.carrillo.app.box.services.IPeleadorAsociacionService;
import com.hdz.carrillo.app.box.services.IService;
import com.hdz.carrillo.app.box.services.PeleadorAsociacionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/peleadorAsociacion/alta")
public class AltaPeleadorAsociacionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IPeleadorAsociacionService service = new PeleadorAsociacionService(conn);
        req.setAttribute("peleadores", service.listaPeleador());
        req.setAttribute("organizaciones", service.listaOrganizacion());
        req.setAttribute("peleadoresOrganizaciones", service.listar());

        getServletContext().getRequestDispatcher("/altaPeleadorAsociacion.jsp").forward(req,resp);
        //  HttpSession session = req.getSession();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = (Connection) req.getAttribute("conn");
        IService<PeleadorAsociacion> service = new PeleadorAsociacionService(conn);

        String organismo = req.getParameter("organizacion");
        String peleador = req.getParameter("peleador");

        Map<String,String> errores = new HashMap<>();
        //System.out.println("LLegó al doPost");
        if (organismo == null || organismo.isBlank()){
            errores.put("organizacion","el organizacion es requerido!");
        }
        if (peleador == null || peleador.isBlank()){
            errores.put("peleador","el peleador es requerido!");
       }
        if (errores.isEmpty()){
            System.out.println("no hay erros");
            PeleadorAsociacion peleadorAs = new PeleadorAsociacion();
            peleadorAs.setId(0);
            peleadorAs.setAsociacionId(Integer.parseInt(organismo));
            peleadorAs.setPeleadorId(Integer.parseInt(peleador));
            service.guardar(peleadorAs);
            resp.sendRedirect(req.getContextPath()+"/peleadorAsociacion/alta");
        }
        else {
            System.out.println("SI hay erros");
            req.setAttribute("errores",errores);
            getServletContext().getRequestDispatcher("/altaPeleadorAsociacion.jsp").forward(req,resp);
        }
    }
}
