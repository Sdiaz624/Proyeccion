/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Valiadr cuando es un select o combo box
function validarOption(id) {
    var selectOrigen = document.getElementById(id);

    // Obtengo la opcion que el usuario selecciono
    var opcionSeleccionada = selectOrigen.options[selectOrigen.selectedIndex].value;

    // Si el usuario eligio la opcion "Elige", no voy al servidor y pongo los selects siguientes en estado "Selecciona opcion..."
    if (opcionSeleccionada === "0")
    {
        document.getElementById(id).style.borderColor = "#f56954";
        toastr.error("Complete datos");

    } else {
        document.getElementById(id).style.borderColor = "#848889";
    }
}

//Valiadr cuando es un input
// este metodo pienso que es mejor si usas el onchange en el input o el onblur
function validarCampo(id) {
    //Obtengo el value
    var valor = document.getElementById(id).value; 
    
    if (valor === "" || valor === null)
    {
        //pone el borde color rojo
        document.getElementById(id).style.borderColor = "#DF0101";
        toastr.warning("Complete el dato");

    } else {
        //borde color verde
        document.getElementById(id).style.borderColor = "#848889";
    }
}

