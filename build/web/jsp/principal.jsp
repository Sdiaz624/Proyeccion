<%-- 
    Document   : principal
    Created on : 13/11/2014, 09:16:43 PM
    Author     : DiWen
--%>

<%@page import="Facade.ConsultasFacade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>

        <meta charset="utf-8">
        <title>Principal</title>
        <script type="text/javascript" src="../js/procesarMenu.js"></script>
        <script type="text/javascript" src="../js/general.js"></script>
        <link href="../css/bootstrap.css" rel="stylesheet" type="text/css" >
        <link rel="stylesheet" href="../css/styles.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <link href="../css/boostrap/bootstrap.min.css" rel="stylesheet">
        <link href="../css/boostrap/bootstrap-responsive.min.css" rel="stylesheet">

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Icons -->
        <link href="../css/icons/general/stylesheets/general_foundicons.css" media="screen" rel="stylesheet" type="text/css" />  
        <link href="../css/icons/social/stylesheets/social_foundicons.css" media="screen" rel="stylesheet" type="text/css" />

        <link rel="stylesheet" href="../css/fonts/font-awesome.min.css">
        <!--[if IE 7]>
            <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome-ie7.min.css">
        <![endif]-->


        <link href="scripts/camera/css/camera.css" rel="stylesheet" type="text/css" />

        <link href="http://fonts.googleapis.com/css?family=Allura" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Aldrich" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css">
        <link href="http://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet" type="text/css">

        <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <link href="../css/toastr.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="../js/toastr.js"></script>
        <script type="text/javascript" src="../js/validacion.js"></script>
        <link href="../css/styles/custom.css" rel="stylesheet" type="text/css" />

        <link href="../css/modal.css" rel="stylesheet" type="text/css" />
        <link href="../css/bootstrapp2.css" rel="stylesheet" type="text/css" />
        <link href="../css/datepicker.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap-datepicker.js"></script>


    <body id="pageBody">

        <div id="decorative2">
            <div class="container">

                <div class="divPanel topArea notop nobottom">
                    <div class="row-fluid">
                        <div class="span12">

                            <div id="divLogo" class="pull-left">
                                <div class="span2">
                                    <img class="ex2" src="../images/logo_is.png">
                                </div>
                                <a href="index.html" id="divSiteTitle">PROYECCION SOCIAL</a><br />
                                <a href="index.html" id="divTagLine">Ingenieria de Sistemas -UFPS</a>


                                <br>		
                            </div>

                            <div id="divMain" class="pull-right">

                                <div id="container"> 

                                    <button class="usuario"><img src="../images/punto.png">Usuario Admin</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>



        <div id="footerInnerSeparator"><br><br></div>

        <div class="container">

            <div class="divPanel page-content">

                <!--Edit Main Content Area here-->
                <div class="row-fluid">

                    <!--Edit Sidebar Content Area here-->
                    <div class="span4 sidebar">
                        <div id="menu" >
                            <div id='cssmenu'>

                                <!--onclick="cargar('#divcontenedor', 'pag/principal/principal.html')-->
                                <ul>
                                    <% ConsultasFacade f = new ConsultasFacade();
                                        HttpSession sesion = request.getSession();
                                    %>

                                    <li><a href='#index' onclick="cargarDivInicio()" ><span class="glyphicon glyphicon-home" aria-hidden="true"></span>  Inicio</a></li>
                                    <li><a href='#organizacion' onclick="cargarDivOrganizacion()" ><span class="glyphicon glyphicon-stats" aria-hidden="true"></span>Organizaciones</a>
                                        <ul>
                                            <li><a href='#organizacion' onclick="cargarDivOrganizacion()"><span class="glyphicon glyphicon-stats" aria-hidden="true"></span>Principal</a>
                                                <ul><%
                                                    String men = "";
                                                    String[][] m = f.cargarFundaciones();
                                                    sesion.setAttribute("fundacion", m);
                                                    if (!m.equals(null)) {
                                                        for (int i = 0; i < m.length; i++) {
                                                            men += " <li class='has-sub'> <a href='#' onclick='cargarIdOrg(" + m[i][0] + ")' > <span> " + m[i][1] + " </span> </a> </li> ";
                                                        }
                                                    }
                                                    %>
                                                    <%=men%>
                                                </ul>
                                            </li>
                                            <li><a href='#regO' onclick="registroOrganizacion()"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Registrar Nueva</a></li>


                                        </ul>
                                    </li>
                                    <li> <a href='#convenio' onclick="cargarDivConvenio()"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>Convenios</a>
                                        <ul>
                                            <li><a href='#convenio' onclick="cargarDivConvenio()"><span class="glyphicon glyphicon-file" aria-hidden="true"></span>Principal</a>
                                                <ul>  <%
                                                    String men2 = "";
                                                    String[][] m2 = f.cargarConvenios();
                                                    sesion.setAttribute("convenio", m2);
                                                    if (!m2.equals(null)) {
                                                        for (int i = 0; i < m2.length; i++) {
                                                            men2 += " <li class='has-sub'> <a href='#' onclick='cargarIdCon(" + m2[i][0] + ")'> <span> " + m2[i][1] + " </span> </a> </li> ";
                                                        }
                                                    }
                                                    %>
                                                    <%=men2%>
                                                </ul></li>
                                            <li><a href='#regC' onclick="registroCon()"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Registrar Nueva</a></li>

                                        </ul>
                                    </li>
                                    <li><a href='#proyecto' onclick="cargarDivProyecto()"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>Proyectos</a>
                                        <ul>
                                            <li><a href='#proyecto' onclick="cargarDivProyecto()"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>Principal</a>
                                                <ul><%
                                                    String men3 = "";
                                                    String[][] m3 = f.cargarProyectos();
                                                    sesion.setAttribute("proyecto", m3);
                                                    if (!m3.equals(null)) {
                                                        for (int i = 0; i < m3.length; i++) {
                                                            men3 += " <li class='has-sub'> <a href='#' onclick='cargarIdPro(" + m3[i][0] + ")' > <span> " + m3[i][1] + " </span> </a> </li> ";
                                                        }
                                                    }
                                                    %>
                                                    <%=men3%></ul></li>
                                            <li><a href='#regP' onclick="registroPro()"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>Registrar Nueva</a></li>

                                        </ul>
                                    </li>        
                                    <li><a href='#actividad' onclick="cargarDivActividad()"><span class="glyphicon glyphicon-th" aria-hidden="true"></span>Actividades</a></li>
                                    <li><a href='#persona' onclick="cargarDivPersona()"><span class="glyphicon glyphicon-user" aria-hidden="true"> </span> Personas</a></li>
                                    <li ><a href='#resultados' onclick="cargarDivResultados()"><span class="glyphicon glyphicon-tasks" aria-hidden="true"> </span>Analisis de Resultados</a>
                                        <ul>
                                            <li > <a href='#presupuesto' onclick="cargarDivPresupuesto()" > <span>Control Presupuesto</span> </a> </li> 
                                            <li > <a href='#evaluacion' onclick="cargarDivEvaluacion()" > <span>Control Evaluacion</span> </a> </li> 
                                            <li > <a href='./Reporte/generadorResporte.jsp' > <span>Generar Reporte PDF </span> </a> </li>
                                        </ul>
                                    </li>
                                    <li><a href='#' onclick="cerrarSesion()"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"> </span>Cerrar Sesion</a></li>
                            </div>
                        </div>    
                    </div> 
                    <div class="span8" id="mostrar">
                    </div>


                    <!--End Main Content Area here-->

                    <div id="footerInnerSeparator"></div>
                </div>

            </div>
        </div>
        <div id="footerOuterSeparator"></div>

        <div id="divFooter" class="footerArea">

            <div class="container">

                <div class="divPanel">

                    <div class="row-fluid">
                        <div class="span3" id="footerArea1">
                            <A NAME="PRES"></A>
                            <h3>Contacto</h3>  

                            <ul id="contact-info">
                                <li>                                    
                                    <i class="general foundicon-phone icon"></i>
                                    <span class="field">Telefono:</span>
                                    <br />
                                    (057) 5776655 ext 201-203                                                                   
                                </li>

                            </ul>

                        </div>
                        <div class="span4" id="footerArea1">
                            <A NAME="PRES"></A>

                            <br/><br/>
                            <ul id="contact-info">

                                <li>
                                    <i class="general foundicon-home icon" style="margin-bottom:50px"></i>
                                    <span class="field">Direccion:</span>
                                    Av Gran Colombia No. 12E-96 Barrio Colsag. Cúcuta - Colombia (Aula Sur 4Piso)
                                </li>
                            </ul>

                        </div>
                        <div class="span2"></div>
                        <div class="span3">

                        </div>
                    </div>

                    <br /><br />


                </div>

            </div>

        </div>

        <script src="scripts/jquery.min.js" type="text/javascript"></script> 
        <script src="scripts/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="scripts/default.js" type="text/javascript"></script>
        <!--
        <script>
        function cargar(div, desde)
        {
             $(div).load(desde);
        }
        </script>
        -->






        <script type="text/javascript">
                                        function formReset(formulario, campo)
                                        {
                                            document.getElementById(formulario).reset();
                                            document.getElementById(campo).innerHTML = "<br/><br/>";
                                        }
        </script>

        <script language="javascript">
            window.onload = function () {

                var jash = window.location.hash;
                if (<%=sesion.getAttribute("sesion")%> == null ||<%=sesion.getAttribute("sesion")%> == "null") {
                    location.href = "Error/paginaError.html";

                } else {
                    if (jash == "#index1") {
                        cargarDivInicio();
                        toastr.success("Bienvenido.! Usuario: Admin");
                    } else
                    if (jash == "#index") {
                        cargarDivInicio();
                    } else
                    if (jash == "#organizacion") {
                        cargarDivOrganizacion();
                    } else
                    if (jash == "#convenio") {
                        cargarDivConvenio();
                    } else
                    if (jash == "#proyecto") {
                        cargarDivProyecto();
                    } else
                    if (jash == "#actividad") {
                        cargarDivActividad();
                    } else
                    if (jash == "#persona") {
                        cargarDivPersona();
                    } else
                    if (jash == "#resultados") {
                        cargarDivResultados();
                    } else
                    if (jash == "#regO") {
                        registroOrganizacion();
                    } else
                    if (jash == "#") {
                        cargarDivInicio();
                    } else
                    if (jash == "#regP") {
                        registroPro();
                    } else
                    if (jash == "#regPer") {
                        registroPer()
                    } else
                    if (jash == "#regC") {
                        registroCon();
                    } else
                    if (jash == "#presupuesto") {
                        cargarDivPresupuesto();
                    } else
                    if (jash == "#resultados") {
                        cargarDivResultados();
                    } else
                    if (jash == "#evaluacion") {
                        cargarDivEvaluacion()
                    } else
                    if (jash == "#co") {
                        cargarIdCon(<%=request.getParameter("id")%>);
                    } else
                    if (jash == "#convenio2") {
                        cargarDivConvenio();
                        toastr.success("Archivo Convenio Exitoso");
                    }
                }
            }
        </script>



    </body>
</html>