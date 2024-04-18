<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.hdz.carrillo.app.box.models.*" %>
<%
    List<Organizacion> organizaciones =  (List<Organizacion>) request.getAttribute("organizaciones");
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"
      integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
      crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">
    <script src="//cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>
    <title>Lista de Organizaciones</title>
</head>
<body>
    <%@ include file="navBar.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-6">
                <h2>Listado de peleadores</h2>
            </div>

            <div class="col-6">
                <a href="<%=request.getContextPath()%>/peleadores/alta" class="btn btn-success">Alta Organización</a>
            </div>
        </div>

        <div class="row">
            <div class="col-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-striped" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nombre</th>
                                <th>Iniciales</th>
                                <th>...</th>
                                <th>...</th>
                                <th>...</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(Organizacion c: organizaciones) { %>
                                <tr>
                                    <td> <%=c.getId()%> </td>
                                    <td> <%=c.getNombre()%> </td>
                                    <td> <%=c.getIniciales()%> </td>
                                    <td><a href="<%=request.getContextPath()%>/organizaciones/detalle?id=<%=c.getId()%>" class="btn btn-success">detalle</a></td>
                                    <td><a href="<%=request.getContextPath()%>/organizaciones/editar?id=<%=c.getId()%>" class="btn btn-primary">editar</a></td>
                                    <td><a href="<%=request.getContextPath()%>/organizaciones/eliminar?id=<%=c.getId()%>" class="btn btn-danger">eliminar</a></td>
                                </tr>
                            <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</body>
</html>