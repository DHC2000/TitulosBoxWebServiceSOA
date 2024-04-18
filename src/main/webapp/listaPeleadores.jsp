<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.hdz.carrillo.app.box.models.*" %>

<%
 //recuperamos la lista de choferes que seteamos en el request desde el servlet
 List<Peleador> peleadores =  (List<Peleador>) request.getAttribute("peleadores");
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
    <title>Peleadores</title>
</head>
<body>
    <%@ include file="navBar.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-6">
                <h2>Peleadores</h2>
            </div>

            <div class="col-6">
                <a href="<%=request.getContextPath()%>/peleadores/alta" class="btn btn-success">Alta Peleador</a>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-12">
                <div class="table-responsive">
                    <table class="table table-bordered table-striped" width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nombre</th>
                                <th>Apellido paterno</th>
                                <th>Apellido Materno</th>
                                <th>Fecha de Nacimiento</th>
                                <th>Nacionalidad</th>
                                <th>Alcance</th>
                                <th>...</th>
                                <th>...</th>
                                <th>...</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for(Peleador c: peleadores) { %>
                                <tr>
                                    <td> <%=c.getId()%> </td>
                                    <td> <%=c.getNombre()%> </td>
                                    <td> <%=c.getApPaterno()%> </td>
                                    <td> <%=c.getApMaterno()%> </td>
                                    <td> <%=c.getFechaNacimiento()%></td>
                                    <td> <%=c.getNacionalidad()%></td>
                                    <td> <%=c.getAlcance()%></td>
                                    <td><a href="<%=request.getContextPath()%>/peleador/detalles?id=<%=c.getId()%>" class="btn btn-primary">detalle</a></td>
                                    <td><a href="<%=request.getContextPath()%>/peleador/editar?id=<%=c.getId()%>" class="btn btn-warning">editar</a></td>
                                    <td><a href="<%=request.getContextPath()%>/peleadores/eliminar?id=<%=c.getId()%>" class="btn btn-danger">eliminar</a></td>
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