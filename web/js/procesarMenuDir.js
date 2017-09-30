
function loading(rta) {
   $(rta).html("<div class='row'><div class=' col-md-offset-5'><img src='../../images/cargando1.gif' width='500' height='500' /></div>");
}

function ajax2(url, datos, rta) {
    var ajax = $.get(url, datos, function(respuesta) {
        $(rta).html(respuesta);
    });
    return ajax;
}
function ajax(url, datos, rta) {
    var ajax = $.get(url, datos, function(respuesta) {
        $(rta).html(respuesta);
    });
    return ajax;
}

/* Principal -----------------------------------------------------------------*/
function cargarDivInicio2(){
    
    var url = "./Principal/principalInicio.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarDivOrganizacion2(){
   
    var url = "./Principal/principalOrganizacion.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarDivConvenio2(){
   
    var url = "./Principal/principalConvenio.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}

function cargarDivProyecto2(){
   
    var url = "./Principal/principalProyectos.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarDivActividad2(){
   
    var url = "./Principal/principalActividad.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarDivPersona2(){
   
    var url = "./Principal/principalPersona.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}

function cargarDivResultados2(){
   
    var url = "./Principal/principalResultados.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}

/* Reporte  ------------------------------------------------------------------*/
function cargarDivPresupuesto2(){
    var url = "./Reporte/controlPresupuesto.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarDivEvaluacion2(){
    var url = "./Reporte/controlEvaluacion.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarpresupuesto22(){
    var id=frmcontrolp.combo.value;
    var url = "./procesarJavaScript/procesarPresupuesto.jsp";
    var datos = {f:id};
    var rta = "#cargar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarEvaluacion22(){
    var id=frmcontrolp2.combo.value;
    var url = "./procesarJavaScript/procesarEvaluacion.jsp";
    var datos = {f:id};
    var rta = "#cargar";
    loading(rta);
    ajax2(url, datos, rta);
}

/* ID ----------------------------------------------------------------------- */
function cargarIdOrg2(idO){
   
    var url = "./Id/idOrganizacion.jsp";
    var datos = {idf:idO};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}

function cargarIdCon2(idO){
   
    var url = "./Id/idConvenio.jsp";
    var datos = {idf:idO};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarIdPro2(idO){
   
    var url = "./Id/idProyecto.jsp";
    var datos = {idf:idO};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarIdAct2(idA,idP){
  
    var url = "Id/IdActividad.jsp";
    var datos = {idact:idA , idpro:idP};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarIdPer2(idA){
  
    var url = "Id/IdPersona.jsp";
    var datos = {id:idA};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}

