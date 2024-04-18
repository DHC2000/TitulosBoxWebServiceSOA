<nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header" id="div1">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                    <a class="navbar-brand" href="#" id="enlace1">Box App</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-haspopup="true" aria-expanded="false">Peleadores<span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/peleadores/listar">Lista peleadores</a></li>
                            <li><a href="<%=request.getContextPath()%>/peleadores/alta">Alta Peleador</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-haspopup="true" aria-expanded="false">Organizaciones<span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="<%=request.getContextPath()%>/organizaciones/listar">Lista de Organizaciones</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button"
                            aria-haspopup="true" aria-expanded="false">Titulos<span
                                class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="http://localhost:8080/API-Proyecto3/api/titulos">API titulos</a></li>
                        </ul>
                    </li>

                    <li class="dropdown">
                        <a href="<%=request.getContextPath()%>/peleadorAsociacion/alta">Peleadores por Organismo</a>
                    </li>

                </ul>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
      </nav>
