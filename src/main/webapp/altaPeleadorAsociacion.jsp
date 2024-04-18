<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<%@page import="com.hdz.carrillo.app.box.models.enums.*" %>
<%@page import="com.hdz.carrillo.app.box.models.*" %>

<%
    Map<String,String> errores = (Map<String,String>) request.getAttribute("errores");
    List<Peleador> peleadores =  (List<Peleador>) request.getAttribute("peleadores");
    List<Organizacion> organizaciones =  (List<Organizacion>) request.getAttribute("organizaciones");
    List<PeleadorAsociacion> peleadoresOrganizaciones =  (List<PeleadorAsociacion>) request.getAttribute("peleadoresOrganizaciones");
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
    <title>Peleador-Organización</title>
</head>
<body>
    <%@ include file="navBar.jsp" %>
    <div class="modal fade" id="myModal" rol="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <div class="row">
                            <div class="col-md-12">
                                <h4>Editar Registro</h4>
                            </div>
                        </div>
                    </div>

                    <div class="modal-body">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="">Organismo</label>
                                    <select name="organizacion" id="organizacion" class="form-control">
                                        <option value="">Seleccionar Organismo</option>
                                        <% for(Organizacion o: organizaciones){ %>
                                        <option value="<%=o.getId() %>"><%=o.getNombre()%> (<%=o.getIniciales()%>)</option>
                                        <% } %>
                                    </select>
                                    <%
                                        if(errores != null && errores.containsKey("organizacion")){
                                            out.println("<span class='text-danger'>"+errores.get("organizacion")+"</span>");
                                        }
                                    %>
                                </div>

                                <div class="form-group">
                                    <label for="">Peleador</label>
                                    <select name="peleador" id="peleador" class="form-control">
                                        <option value="">Seleccionar peleador</option>
                                        <% for(Peleador p: peleadores){ %>
                                        <option value="<%=p.getId()%>"><%=p.getNombre()%> <%=p.getApPaterno()%> <%=p.getApMaterno()%> </option>
                                        <% } %>
                                    </select>
                                    <%
                                        if(errores != null && errores.containsKey("peleador")){
                                            out.println("<span class='text-danger'>"+errores.get("peleador")+"</span>");
                                        }
                                    %>
                                </div>

                            </div>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <div class="row">
                            <div class="col-md-10">
                                <div class="col-md-10 col-md-offset-1">

                                    <div class="col-md-4">
                                        <button class="btn btn-success" onclick="">Guardar</button>
                                    </div>
                                    <div class="col-md-4 col-md-offset-2">
                                        <button class="btn btn-default" data-dismiss="modal">Cerrar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2>Peledor por Organizacion</h2>
            </div>
        </div>
        <br>
        <% if(errores != null && errores.size()>0) { %>
            <ul class="alert alert-danger mx-5 px-5">
                <% for(String error: errores.values()) { %>)
                <li> <%= error %></li>
                <%}%>
            </ul>
        <%}%>
        <div class="row">
            <form action="<%=request.getContextPath()%>/peleadorAsociacion/alta" method="post" id="peleadorAsForm">
                <div class="col-md-12">
                                <div class="form-group">
                                    <label for="">Organismo</label>
                                    <select name="organizacion" id="organizacion" class="form-control">
                                        <option value="">Seleccionar Organismo</option>
                                        <% for(Organizacion o: organizaciones){ %>
                                        <option value="<%=o.getId() %>"><%=o.getNombre()%> (<%=o.getIniciales()%>)</option>
                                        <% } %>
                                    </select>
                                    <%
                                        if(errores != null && errores.containsKey("organizacion")){
                                            out.println("<span class='text-danger'>"+errores.get("organizacion")+"</span>");
                                        }
                                    %>
                                </div>

                                <div class="form-group">
                                    <label for="">Peleador</label>
                                    <select name="peleador" id="peleador" class="form-control">
                                        <option value="">Seleccionar peleador</option>
                                        <% for(Peleador p: peleadores){ %>
                                        <option value="<%=p.getId()%>"><%=p.getNombre()%> <%=p.getApPaterno()%> <%=p.getApMaterno()%> </option>
                                        <% } %>
                                    </select>
                                    <%
                                        if(errores != null && errores.containsKey("peleador")){
                                            out.println("<span class='text-danger'>"+errores.get("peleador")+"</span>");
                                        }
                                    %>
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-success">Guardar</button>
                                </div>

                            </div>
            </form>
        </div>

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
                                        <th>Organización</th>
                                        <th>Iniciales</th>
                                        <th>...</th>
                                        <th>...</th>
                                        <th>...</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <% for(PeleadorAsociacion p: peleadoresOrganizaciones) { %>
                                        <tr>
                                            <td> <%=p.getId()%> </td>
                                            <td> <%=p.getNombre()%> </td>
                                            <td> <%=p.getApPaterno()%> </td>
                                            <td> <%=p.getApMaterno()%> </td>
                                            <td> <%=p.getOrganismo()%> </td>
                                            <td> <%=p.getIniciales()%></td>
                                            <td><a href="<%=request.getContextPath()%>/peleadorAsociacion/detalles?id=<%=p.getId()%>" class="btn btn-primary">Detalles</a></td>
                                            <td><button type="button" onclick="mostrar()" class="btn btn-warning">Editar</button></td>
                                            <td><a href="<%=request.getContextPath()%>/peleadorAsociacion/eliminar?id=<%=p.getId()%>" class="btn btn-danger">Eliminar</a></td>
                                        </tr>
                                    <% } %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
    </div>

     <script>
            document.getElementById("peleadorAsForm").addEventListener("submit", function(event) {
            event.preventDefault();

            var peleador = document.getElementsByName("peleador")[0].value;
            var organizacion = document.getElementsByName("organizacion")[0].value;
            console.log("verifica los campos");

            if (peleador.trim() === "" || organizacion.trim() === "") {
                alert("Por favor, completa todos los campos requeridos.");
            } else {
                console.log("debería enviarse");
                // Si todos los campos requeridos están llenos, envía el formulario
                event.target.submit();
            }
            }) ;
            function mostrar() {
              $('#myModal').modal('show');
            }
     </script>
</body>
</html>