<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.hdz.carrillo.app.box.models.*" %>
<%@page import="java.time.format.*" %>

<%
    Peleador peleador = (Peleador) request.getAttribute("peleador");
    String fecha = peleador.getFechaNacimiento() != null ? peleador.getFechaNacimiento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
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
    <title>Detalles-Peleador</title>
</head>
<body>
    <%@ include file="navBar.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-12">

                <div class="card border">
                    <div class="card-header">
                        <h3><strong>Detalles del Peleador</strong></h3>
                    </div>
                </div>

                <div class="card-body">
                    <ul class="card-body">
                        <li class="list-group-item"><strong>Nombre: </strong> <%=peleador.getNombre() %></li>
                        <li class="list-group-item"><strong>Ap.Paterno: </strong><%=peleador.getApPaterno() %></li>
                        <li class="list-group-item"><strong>Ap.Materno: </strong> <%=peleador.getApMaterno() %> </li>
                        <li class="list-group-item"><strong>Fecha de Nacimiento</strong> <%=fecha %> </li>
                        <li class="list-group-item"><strong>Nacionalidad</strong> <%=peleador.getNacionalidad() %> </li>
                        <li class="list-group-item"><strong>Alcance</strong> <%=peleador.getAlcance() %> </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>