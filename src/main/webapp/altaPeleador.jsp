<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>

<%
    Map<String,String> errores = (Map<String,String>) request.getAttribute("errores");
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
    <title>Nuevo Peleador</title>
</head>
<body>
    <%@ include file="navBar.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2>Formulario alta Peleador</h2>
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
            <form action="<%=request.getContextPath()%>/peleadores/alta" method="post">
                <div class="col-md-12">
                                <div class="form-group">
                                    <label for="">Nombre</label>
                                    <input type="text" name="nombre" id="nombre" class="form-control" value="${param.nombre}"></input>
                                    <%
                                        if(errores != null && errores.containsKey("nombre")){
                                            out.println("<span class='text-danger'>"+errores.get("nombre")+"</span>");
                                        }
                                    %>
                                </div>

                                <div class="form-group">
                                    <label for="">Apellido Paterno</label>
                                    <input type="text" name="apPaterno" id="apPaterno" class="form-control" value="${param.apPaterno}"></input>
                                    <%
                                        if(errores != null && errores.containsKey("apPaterno")){
                                            out.println("<span class='text-danger'>"+errores.get("apPaterno")+"</span>");
                                        }
                                    %>
                                </div>

                                <div class="form-group">
                                    <label for="">Apellido Materno</label>
                                    <input type="text" name="apMaterno" id="apMaterno" class="form-control" value="${param.apMaterno}"></input>
                                    <%
                                        if(errores != null && errores.containsKey("apMaterno")){
                                            out.println("<span class='text-danger'>"+errores.get("apMaterno")+"</span>");
                                        }
                                    %>
                                </div>

                                <div class="form-group">
                                    <label for="">Fecha Nacimiento</label>
                                    <input type="date" name="fechaNacimiento" id="fechaNacimiento" class="form-control" value="${param.fechaNacimiento}"></input>
                                    <%
                                        if(errores != null && errores.containsKey("fechaNacimiento")){
                                            out.println("<span class='text-danger'>"+errores.get("fechaNacimiento")+"</span>");
                                        }
                                    %>
                                </div>

                                <div class="form-group">
                                    <label for="">Nacionalidad</label>
                                    <select name="nacionalidad" id="nacionalidad" class="form-control">
                                        <option value="">--- Seleccionar Pais ---</option>
                                    </select>
                                    <%
                                        if(errores != null && errores.containsKey("nacionalidad")){
                                            out.println("<span class='text-danger'>"+errores.get("nacionalidad")+"</span>");
                                        }
                                    %>
                                </div>

                                <div class="form-group">
                                    <label for="">Alcance</label>
                                    <input type="text" name="alcance" id="alcance" class="form-control" value="${param.alcance}"></input>
                                    <%
                                        if(errores != null && errores.containsKey("alcance")){
                                            out.println("<span class='text-danger'>"+errores.get("alcance")+"</span>");
                                        }
                                    %>
                                </div>

                                <div class="form-group">
                                    <button type="submit" class="btn btn-success">Guardar</button>
                                </div>

                            </div>
            </form>

        </div>
    </div>
<script>
        var paisesArr = new Array();
        window.onload = function(){
            paises();
            alert("Bienvenido");
        }
        function paises() {
            fetch('https://restcountries.com/v3.1/all').then(res=>{
                if (res.ok) {
                    res.json().then(listarPaises=>{
                        console.log(listarPaises);
                        for (let index = 0; index < listarPaises.length; index++) {
                            var pais = listarPaises[index].name.common;
                            paisesArr.push(pais)
                            console.log(pais);
                        }
                        //console.log(paisesArr);

                        var select = document.getElementById("nacionalidad");

                        // Recorre el array
                        for(var i = 0; i < paisesArr.length; i++) {
                            // Crea un nuevo elemento option
                            var option = document.createElement("option");

                            // Ajusta el valor y el texto del option
                            //option.value = i;
                            option.value = paisesArr[i];
                            option.text = paisesArr[i];

                            // Añade el option al select
                            select.appendChild(option);
                        }
                        //pais = listarPaises[0].name.common;
                        //var bandera = listarPaises
                    })
                }
                //console.log(res);
            })
        }

        function mostrar() {
            $('#myModal').modal('show');
        }
    </script>
</body>
</html>