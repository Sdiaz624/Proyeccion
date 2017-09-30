// JavaScript Document

/* Crea el objeto AJAX. Esta funcion es generica para cualquier utilidad de este tipo, por
	lo que se puede copiar tal como esta aqui */
function nuevoAjax()
{ 
	var xmlhttp=false;
	try	{
		// Creacion del objeto AJAX para navegadores no IE Ejemplo:Mozilla, Safari 
		xmlhttp=new ActiveXObject("Msxml2.XMLHTTP");
	}catch(e){
		try	{
			// Creacion del objet AJAX para IE
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}catch(E){
			if (!xmlhttp && typeof XMLHttpRequest!='undefined') xmlhttp=new XMLHttpRequest();
		}
	}
	return xmlhttp; 
}
function cerrarSesion2(){
        aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	parametros = "usuario="+""+"&clave="+"password"+"&aleatorio="+aleatorio;  
	url = "procesarJavaScript/procesarCerrar.jsp";  
        ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
        location.href="../../index.html";	
}

function cerrarSesion(){
        aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	parametros = "usuario="+""+"&clave="+"password"+"&aleatorio="+aleatorio;  
	url = "procesarJavaScript/procesarCerrar.jsp";  
        ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
        location.href="../index.html";	
}
function validarUsuario()
{
    	var codigo = frmIngreso.codigo.value;
        var password = frmIngreso.clave.value;
	validarUsuarioAjax(codigo, password, "divError");
	
}


function validarUsuarioAjax(codigo,password, campo)
{
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	parametros = "usuario="+codigo+"&clave="+password+"&aleatorio="+aleatorio;  
	url = "jsp/procesarJavaScript/procesarSesion.jsp";  
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) { 
                         toastr.error(ajax.responseText);
	         	
                        
	         }else{
                     if(codigo==="Admin"){
                     location.href="./jsp/principal.jsp#index1";
                     }else{
                     location.href="./jsp/RolDirector/principalDir.jsp#index1";
                 }
                 }
	         	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
                     toastr.error(ajax.responseText);
	         	
	         }else{
                     location.href="./jsp/RolDirector/principal.jsp#index1"
                 }
	         
	    }
	  } 
	  else
	  {
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}


function regitrarFundacion()
{       
            
            var nitf=frmIngreso3.txtnitf.value;   
            var nomf=frmIngreso3.txtnomf.value;
            var telf=frmIngreso3.txttelf.value;
            var dirf=frmIngreso3.txtdirf.value;
            var corf=frmIngreso3.txtcorf.value;
            var desf=frmIngreso3.txtdesf.value;
            var nomr=frmIngreso3.txtnomr.value;
            var cedr=frmIngreso3.txtcedr.value;
            var telr=frmIngreso3.txttelr.value;
            var corr=frmIngreso3.txtcorr.value;
            
	regitrarFundacionAjax(cedr, nomr,  telr, corr, nitf, nomf, telf, dirf, corf, desf,"Error");
    
}

function regitrarFundacionAjax(cedr, nomr,  telr, corr, nitf, nomf, telf, dirf, corf, desf,campo)
{
	
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "tipo="+"2"+"&txtnitf="+nitf+"&txtnomf="+nomf+"&txttelf="+telf+"&txtdirf="+dirf+"&txtcorf="+corf+"&txtdesf="+desf+"&txtnomr="+nomr+"&txtcedr="+cedr+"&txttelr="+telr+"&txtcorr="+corr+"&aleatorio="+aleatorio;  
	url = "../jsp/procesarJavaScript/procesarRegistro.jsp";  
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
        ajax.onreadystatechange=function()
	{
           
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) {                                   
	         	 toastr.error(ajax.responseText);
	         }
	         else {	   
                                toastr.success("Registro Exitoso");
				frmIngreso3.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
                       toastr.error(ajax.responseText);
                        
	         }
	         else {	        
                                toastr.success("Registro Exitoso");
				frmIngreso3.submit();
			 }
	    }
	  } 
	  else
	  {
              
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
        
}

function cargarpresupuesto(f)
{
	
	cargarpresupuestoAjax(f, "cargar");
	
}


function cargarpresupuestoAjax(f, campo)
{
	
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "f="+f+"&aleatorio="+aleatorio;  
	url = "../jsp/procesarJavaScript/procesarPresupuesto.jsp";  
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) { 
	         	document.getElementById(campo).innerHTML = ajax.responseText;
	         }
	         else {	   
	        	
				frmcontrolp.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
	         	document.getElementById(campo).innerHTML = ajax.responseText;
	         }
	         else {	        		         	
				frmcontrolp.submit();
			 }
	    }
	  } 
	  else
	  {
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}

function cargarEvaluacion(f)
{
	
	cargarEvaluacionAjax(f, "cargar2");
	
}


function cargarEvaluacionAjax(f, campo)
{
	
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "f="+f+"&aleatorio="+aleatorio;  
      
	url = "procesarEvaluacion.jsp";  
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) { 
	         	document.getElementById(campo).innerHTML = ajax.responseText;
	         }
	         else {	   
	        	
				frmcontrolp2.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
	         	document.getElementById(campo).innerHTML = ajax.responseText;
	         }
	         else {	        		         	
				frmcontrolp2.submit();
			 }
	    }
	  } 
	  else
	  {
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}
function regitrarConvenio()
{       
	var id=frmIngreso2.txtidc.value;
        var nombre=frmIngreso2.txtnomc.value;
        var objetivo=frmIngreso2.txtobjc.value;
        var Des=frmIngreso2.txtdesc.value;
        var fundacionc=frmIngreso2.fundacionc.value;
        var fic=frmIngreso2.fic.value;
        var ffc=frmIngreso2.ffc.value;
        
	regitrarConvenioAjax(id,nombre,objetivo,Des,fundacionc,fic,ffc,"divErrorC");
	
}


function regitrarConvenioAjax(id,nombre,objetivo,Des,fundacionc,fic,ffc, campo)
{
	
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "txtidc="+id+"&tipo="+"3"+"&txtnomc="+nombre+"&txtobjc="+objetivo+"&txtdesc="+Des+"&fundacionc="+fundacionc+"&fic="+fic+"&ffc="+ffc+"&aleatorio="+aleatorio;  
	url = "../jsp/procesarJavaScript/procesarRegistro.jsp";   
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) {                                   
	         	 toastr.error(ajax.responseText);
	         }
	         else {	   
                                toastr.success("Registro Exitoso");
				frmIngreso2.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
                       toastr.error(ajax.responseText);
                        
	         }
	         else {	        
                                toastr.success("Registro Exitoso");
				frmIngreso2.submit();
			 }
	    }
	  } 
	  else
	  {
              
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}



function regitrarPersona()
{          
           var cedula=frmIngreso41.txtcedp1.value;
           var nombre=frmIngreso41.txtnomp1.value;
           var codigo=frmIngreso41.txtcodp1.value;
           var telefono=frmIngreso41.txttelp1.value;
           var correo=frmIngreso41.txtcorp1.value;
           var tipo=frmIngreso41.tipop1.value;
           
	   regitrarPersonaAjax(cedula, nombre, codigo, telefono, correo, tipo,"divErrorPersona");
	
}
      function regitrarPersonaAjax(cedula, nombre, codigo, telefono, correo, tipo,campo) {
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "txtcedp="+cedula+"&txtnomp="+nombre+"&tipo="+"6"+"&txtcodp="+codigo+"&txttelp="+telefono+
                "&txtcorp="+correo+"&tipop="+tipo+"&aleatorio="+aleatorio;  
       
	url = "../jsp/procesarJavaScript/procesarRegistro.jsp";   
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) {                                   
	         	 toastr.error(ajax.responseText);
	         }
	         else {	   
                                toastr.success("Registro Exitoso");
				frmIngreso2.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
                       toastr.error(ajax.responseText);
                        
	         }
	         else {	        
                                toastr.success("Registro Exitoso");
				frmIngreso2.submit();
			 }
	    }
	  } 
	  else
	  {
              
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}
function regitrarPersona2()
{          
           var cedula=frmIngreso412.txtcedp12.value;
           var nombre=frmIngreso412.txtnomp12.value;
           var codigo=frmIngreso412.txtcodp12.value;
           var telefono=frmIngreso412.txttelp12.value;
           var correo=frmIngreso412.txtcorp12.value;
           var tipo=frmIngreso412.tipop12.value;
           
	   regitrarPersona2Ajax(cedula, nombre, codigo, telefono, correo, tipo,"divErrorPersona2");
	
}
      function regitrarPersona2Ajax(cedula, nombre, codigo, telefono, correo, tipo,campo) {
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "txtcedp="+cedula+"&txtnomp="+nombre+"&tipo="+"6"+"&txtcodp="+codigo+"&txttelp="+telefono+
                "&txtcorp="+correo+"&tipop="+tipo+"&aleatorio="+aleatorio;  
       
	url = "procesarRegistro.jsp";  
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) { 
	         	document.getElementById(campo).innerHTML = ajax.responseText;
	         }
	         else {	   
                                alert("RegistroExitoso!!");
				frmIngreso412.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
	         	document.getElementById(campo).innerHTML = ajax.responseText;
	         }
	         else {	        
                                alert("RegistroExitoso!!");
				frmIngreso412.submit();
			 }
	    }
	  } 
	  else
	  {
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}
function regitrarActividad()
{     
   
            var id=frmIngresoac.idac.value;
            var nombre=frmIngresoac.txtnomac.value;
            var descripcion=frmIngresoac.txtdesac.value;
            var presupuesto=frmIngresoac.txtpreac.value;
            var tipo=frmIngresoac.txttipac.value;
            var coor=frmIngresoac.coordinadorac.value;
            var fi=frmIngresoac.fiac.value;
            var ff=frmIngresoac.ffac.value;
    
           
        
	   regitrarActividadAjax(id,nombre, descripcion, presupuesto, fi, ff, coor,tipo,"divError2");
	
}
      function regitrarActividadAjax(id,nombre, descripcion, presupuesto, fi, ff,coor,tipo ,campo) {
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "txtnomac="+nombre+"&idac="+id+"&tipo="+"5"+"&txtdesac="+descripcion+"&txtpreac="+presupuesto+"&txttipac="+tipo+
                "&fiac="+fi+"&ffac="+ff+"&coordinadorac="+coor+"&aleatorio="+aleatorio;  
        url = "../jsp/procesarJavaScript/procesarRegistro.jsp";  
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) { 
	         	toastr.error(ajax.responseText);
	         }
	         else {	   
                                toastr.success("RegistroExitoso!!");
				frmIngresoac.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
	         	toastr.error(ajax.responseText);
	         }
	         else {	        
                                toastr.success("RegistroExitoso!!");
				frmIngresoac.submit();
			 }
	    }
	  } 
	  else
	  {
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}
function regitrarProyecto(){  
     
            
            var nombre=frmIngreso5.txtnompr.value;
            var descripcion=frmIngreso5.txtdespr.value;
            var fundacion=frmIngreso5.fundacionpr.value;
            var fi=frmIngreso5.dp2.value;
            var ff=frmIngreso5.dp1.value;
   
           
          
	   regitrarProyectoAjax(nombre, descripcion, fi, ff, fundacion,"divError1");
	
}
      function regitrarProyectoAjax(nombre, descripcion,  fi, ff, fundacion,campo) {
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "txtnompr="+nombre+"&txtdespr="+descripcion+"&tipo="+"4"+"&fundacionpr="+fundacion+
                "&fipr="+fi+"&ffpr="+ff+"&aleatorio="+aleatorio; 
        
        url = "../jsp/procesarJavaScript/procesarRegistro.jsp";   
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) {                                   
	         	 toastr.error(ajax.responseText);
	         }
	         else {	   
                                toastr.success("Registro Exitoso");
				frmIngreso5.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
                       toastr.error(ajax.responseText);
                        
	         }
	         else {	        
                                toastr.success("Registro Exitoso");
				frmIngreso5.submit();
			 }
	    }
	  } 
	  else
	  {
              
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}

function actualizarConvenio(){
           
	    var idC=frmIngresocon.idC.value; 
            var idCon=frmIngresocon.txtidc.value;
            var nombre=frmIngresocon.txtnomc.value;            
            var objetivo=frmIngresocon.txtobjc.value;            
            var Des=frmIngresocon.txtdesc.value;           
            var estado=frmIngresocon.txtest.value;
            var fundacion=frmIngresocon.fundacion.value;
            var fic=frmIngresocon.fic.value;
            var ffc=frmIngresocon.ffc.value;           
	actualizarConvenioAjax(idC,idCon,nombre,estado,objetivo,Des,fundacion,fic,ffc,"divErrorCon");
	
}


function actualizarConvenioAjax(idC,idCon,nombre,estado,objetivo,Des,fundacion,fic,ffc, campo){
	
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "id="+idC+"&txtnomc="+nombre+"&txtidc="+idCon+"&tip="+"3"+"&txtest="+estado+"&txtobjc="+objetivo+"&txtdesc="+Des+"&fundacion="+fundacion+"&fic="+fic+"&ffc="+ffc+"&aleatorio="+aleatorio;  
	url = "../jsp/procesarJavaScript/procesarActualizacion.jsp" 
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) { 
	         	toastr.error(ajax.responseText);
	         }
	         else {	   
                                toastr.success("Modificacion Exitosa");
				frmIngresocon.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
	         	toastr.error(ajax.responseText);
	         }
	         else {	        
                                toastr.success("Modificacion Exitosa");
				frmIngresocon.submit();
			 }
	    }
	  } 
	  else
	  {
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}
function actualizarProyecto()
{           var id=frmIngresopr.idpr.value;
            var nombre=frmIngresopr.txtnompr.value;
            var descripcion=frmIngresopr.txtdespr.value;
            
            var fundacion=frmIngresopr.fundacionpr.value;
            var fi=frmIngresopr.dp2.value;
            var ff=frmIngresopr.dp1.value;
            var estado=frmIngresopr.estadopr.value;
            
            actualizarProyectoAjax(id,nombre, descripcion, fi, ff, fundacion,estado,"divError");
	
}
      function actualizarProyectoAjax(id,nombre, descripcion, fi, ff, fundacion,estado,campo) {
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();  
  	 
	parametros = "txtnompr="+nombre+"&txtdespr="+descripcion+"&estadopr="+estado+"&idpr="+id+"&tip="+"4"+"&fundacionpr="+fundacion+
                "&fipr="+fi+"&ffpr="+ff+"&aleatorio="+aleatorio;   
        url = "../jsp/procesarJavaScript/procesarActualizacion.jsp";  
        
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) {                                   
	         	 toastr.error(ajax.responseText);
	         }
	         else {	   
                                toastr.success("Modificacion Exitosa");
				frmIngresopr.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
                       toastr.error(ajax.responseText);
                        
	         }
	         else {	        
                                toastr.success("Modificacion Exitosa");
				frmIngresopr.submit();
			 }
	    }
	  } 
	  else
	  {
              
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}

function actualizarActividad()
{           var id=frmIngresoact.idpro.value;
            var ida=frmIngresoact.idact.value;
            var nombre=frmIngresoact.txtnomact.value;
            var descripcion=frmIngresoact.txtdesact.value;
            var presupuesto=frmIngresoact.txtpreact.value;
            var tipo=frmIngresoact.txttipact.value;
            var coor=frmIngresoact.txtcooact.value;
            var fi=frmIngresoact.fiact.value;
            var ff=frmIngresoact.ffact.value;
            var est=frmIngresoact.txtestact.value;
            var eva=frmIngresoact.txtevaact.value;
           var r=frmIngresoact.txtrecact.value;
           
	   actualizarActividadAjax(r,id,ida,nombre, descripcion, presupuesto, fi, ff, coor,tipo,est,eva,"divError2");
	
}
      function actualizarActividadAjax(r,id,ida,nombre, descripcion, presupuesto, fi, ff,coor,tipo ,est,eva,campo) {
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "txtnomact="+nombre+"&tip="+"5"+"&txtrecact="+r+"&txtestact="+est+"&txtevaact="+eva+"&idpro="+id+"&idact="+ida+"&txtdesact="+descripcion+"&txtpreact="+presupuesto+"&txttipact="+tipo+
                "&fiact="+fi+"&ffact="+ff+"&txtcooact="+coor+"&aleatorio="+aleatorio;  
        url = "../jsp/procesarJavaScript/procesarActualizacion.jsp"; 
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) { 
	         	toastr.error(ajax.responseText);
	         }
	         else {	   
                                  toastr.success("Modificacion Exitoso!!");
				frmIngresoact.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
	         	toastr.error(ajax.responseText);
	         }
	         else {	        
                                 toastr.success("Modificacion Exitoso!!");
				frmIngresoact.submit();
			 }
	    }
	  } 
	  else
	  {
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}


function actualizarFundacion()
{           var rep=frmIngresof.rep.value;
            var id=frmIngresof.id.value;
            var nitf=frmIngresof.txtnitf.value;   
            var nomf=frmIngresof.txtnomf.value;
            var telf=frmIngresof.txttelf.value;
            var dirf=frmIngresof.txtdirf.value;
            var corf=frmIngresof.txtcorf.value;
            var desf=frmIngresof.txtdesf.value;
            var nomr=frmIngresof.txtnomr.value;
            var cedr=frmIngresof.txtcedr.value;
            var telr=frmIngresof.txttelr.value;
            var corr=frmIngresof.txtcorr.value;
          
	actualizarFundacionAjax(cedr,id, nomr,rep,  telr, corr, nitf, nomf, telf, dirf, corf, desf,"divErrorf");
	
}


function actualizarFundacionAjax(cedr,id, nomr, rep, telr, corr, nitf, nomf, telf, dirf, corf, desf,campo)
{
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "txtnitf="+nitf+"&id="+id+"&tip="+"2"+"&rep="+rep+"&txtnomf="+nomf+"&txttelf="+telf+"&txtdirf="+dirf+"&txtcorf="+corf+"&txtdesf="+desf+"&txtnomr="+nomr+"&txtcedr="+cedr+"&txttelr="+telr+"&txtcorr="+corr+"&aleatorio="+aleatorio;  
        
	url = "../jsp/procesarJavaScript/procesarActualizacion.jsp"; 
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) { 
	         	toastr.error(ajax.responseText);
	         }
	         else {	   
                                toastr.success("Modificacion Exitoso!!");
				frmIngresof.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
	         	toastr.error(ajax.responseText);
	         }
	         else {	        
                                toastr.success("Modificacion Exitoso!!");
				frmIngresof.submit();
			 }
	    }
	  } 
	  else
	  {
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}
function actualizarPersona()
{          var cedA=frmIngresoact.cedAnterior.value;
           var cedula=frmIngresoact.txtcedp.value;
           var nombre=frmIngresoact.txtnomp.value;
           var codigo=frmIngresoact.txtcodp.value;
           var telefono=frmIngresoact.txttelp.value;
           var correo=frmIngresoact.txtcorp.value;
           var tipo=frmIngresoact.tipop.value;
          
	   actualizarPersonaAjax(cedA,cedula, nombre, codigo, telefono, correo, tipo,"divError");
	
}
      function actualizarPersonaAjax(cedA,cedula, nombre, codigo, telefono, correo, tipo,campo) {
	aleatorio=Math.random(); 
  	ajax = nuevoAjax();   
  	
	parametros = "txtcedp="+cedula+"&txtnomp="+nombre+"&tip="+"6"+"&cedAnterior="+cedA+"&txtcodp="+codigo+"&txttelp="+telefono+
                "&txtcorp="+correo+"&tipop="+tipo+"&aleatorio="+aleatorio;  
       
	url = "../jsp/procesarJavaScript/procesarActualizacion.jsp";  
	ajax.open("POST",url,true);
	ajax.setRequestHeader('Content-Type','application/x-www-form-urlencoded');   
	ajax.send(parametros);
	
	ajax.onreadystatechange=function()
	{
	  if (ajax.readyState==4)
	  {
	    if (ajax.status == 200)
	    {          	       	 
	       	 var rta= ajax.responseText;	       	         
	         if (rta.indexOf("Ok")<0) { 
	         	toastr.error(ajax.responseText);
	         }
	         else {	   
                                toastr.success("Modificacion Exitoso!!");
				frmIngresoact.submit();
				
			 }	             
	    }
	    else
	    {    
	         var rta= ajax.responseText;         
	         if (rta.indexOf("Ok")<0) { 
	         	toastr.error(ajax.responseText);
	         }
	         else {	        
                                toastr.success("Modificacion Exitoso!!");
				frmIngresoact.submit();
			 }
	    }
	  } 
	  else
	  {
	    document.getElementById(campo).value = "Verificando Usuario...";
	  }
	}
}
