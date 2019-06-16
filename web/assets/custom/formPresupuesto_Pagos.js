/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var formulario = document.getElementsByName("form")[0];

//false : fecha anterior a la de hoy 
function validarFecha(elemento) {
    var fecha = document.getElementById(elemento.id).value;
    var hoy = new Date();
    var fechaFormulario = new Date(fecha);

    // Comparamos solo las fechas => no las horas!!
    hoy.setHours(0, 0, 0, 0);  // Lo iniciamos a 00:00 horas
    fechaFormulario.setHours(24, 0, 0, 0);

    if (hoy <= fechaFormulario) {
        return false;
    } else {
        return true;
    }
}


var validar = function (e) {
    for (var i = 0, max = formulario.elements.length; i < max; i++) {

        //validar password
        if (formulario.elements[i].type == "date") {
            console.log(validarFecha(formulario.elements[i]));
            if (validarFecha(formulario.elements[i])) {
                formulario.elements[i].setCustomValidity("Fecha debe ser mayor o igual que hoy");
                e.preventDefault();
            } else {
                formulario.elements[i].setCustomValidity('');
            }
        }

    }
};


formulario.addEventListener("change", validar);
//Evento de envio de formulario
formulario.addEventListener("submit", validar);


    