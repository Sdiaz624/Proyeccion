
function loading(rta) {
    $(rta).html("<div class='row'><div class=' col-md-offset-3'><img src='../images/cargando1.gif' width='500' height='500' /></div>");
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
function cargarDivInicio(){
    
    var url = "./Principal/principalInicio.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarDivOrganizacion(){
   
    var url = "./Principal/principalOrganizacion.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarDivConvenio(){
   
    var url = "./Principal/principalConvenio.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}

function cargarDivProyecto(){
   
    var url = "./Principal/principalProyectos.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarDivActividad(){
   
    var url = "./Principal/principalActividad.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarDivPersona(){
   
    var url = "./Principal/principalPersona.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}

function cargarDivResultados(){
   
    var url = "./Principal/principalResultados.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}

/* Reporte  ------------------------------------------------------------------*/
function cargarDivPresupuesto(){
    var url = "./Reporte/controlPresupuesto.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarDivEvaluacion(){
    var url = "./Reporte/controlEvaluacion.jsp";
    var datos = {idAspirante:"dfg"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarpresupuesto3(){
      var id=frmcontrolp.combo.value;
    var url = "./procesarJavaScript/procesarPresupuesto.jsp";
    var datos = {f:id};
    var rta = "#cargar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarEvaluacion3(){
     var id=frmcontrolp2.combo.value;
    var url = "./procesarJavaScript/procesarEvaluacion.jsp";
    var datos = {f:id};
    var rta = "#cargar";
    loading(rta);
    ajax2(url, datos, rta);
}


/* Registro ------------------------------------------------------------------*/
function registroOrganizacion(){
   
    var url = "./Registro/registroOrganizacion.jsp";
    var datos = {id:"idO"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function registroCon(){
   
    var url = "./Registro/registroConvenio.jsp";
    var datos = {id:"idO"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function registroPro(){
   
    var url = "./Registro/registroProyecto.jsp";
    var datos = {id:"idO"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function registroPer(){
   
    var url = "./Registro/registroPersona.jsp";
    var datos = {id:"idO"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function registroAct(idO){
   
    var url = "./Registro/registroActividad.jsp";
    var datos = {idf:idO};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function registroCoo(){
   
    var url = "./Registro/registroCoordinadorActividad.jsp";
    var datos = {idf:"h"};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}


/* ID ----------------------------------------------------------------------- */
function cargarIdOrg(idO){
   
    var url = "./Id/idOrganizacion.jsp";
    var datos = {idf:idO};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}

function cargarIdCon(idO){
   
    var url = "./Id/idConvenio.jsp";
    var datos = {idf:idO};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarIdPro(idO){
   
    var url = "./Id/idProyecto.jsp";
    var datos = {idf:idO};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarIdAct(idA,idP){
  
    var url = "Id/IdActividad.jsp";
    var datos = {idact:idA , idpro:idP};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarIdPer(idA){
  
    var url = "Id/IdPersona.jsp";
    var datos = {id:idA};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}




/* Actualizar ----------------------------------------------------------------*/
function cargarActOrg(idO){
   
    var url = "./Actualizar/actualizarOrganizacion.jsp";
    var datos = {idf:idO};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}

function cargarActCon(idO){
   
    var url = "./Actualizar/actualizarConvenio.jsp";
    var datos = {idf:idO};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarActAct(idO, idp){
  
    var url = "./Actualizar/actualizarActividad.jsp";
    var datos = {idact:idO, idpro:idp};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarActPro(idO){
  
    var url = "./Actualizar/actualizarProyecto.jsp";
    var datos = {idf:idO};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}
function cargarActPer(idO){
  
    var url = "./Actualizar/actualizarPersona.jsp";
    var datos = {id:idO};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}


/* Asignar -------------------------------------------------------------------*/
function asignarPersonaAct(idO2){
   
    var url = "./Asignar/asignarPersonaActividad.jsp";
    var datos = {idact:idO2};
    var rta = "#mostrar";
    loading(rta);
    ajax2(url, datos, rta);
}

