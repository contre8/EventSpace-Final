function validarEdad() {
    var fechaNacimiento = document.getElementById("form:fechaNacimiento").value;
    var hoy = new Date();
    var fechaNac = new Date(fechaNacimiento);
    var edad = hoy.getFullYear() - fechaNac.getFullYear();
    var m = hoy.getMonth() - fechaNac.getMonth();

    var mesesAbsolutos = edad * 12 + m;

    if (mesesAbsolutos < 0 || (mesesAbsolutos === 0 && hoy.getDate() < fechaNac.getDate())) {
        edad--;
    }

    if (edad < 18) {
        alert("Debe ser mayor de edad para registrarse.");
        return false;
    }
    return true;
}