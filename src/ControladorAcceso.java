public class ControladorAcceso {

    public void iniciarSesion(MecanismoAutenticacion mecanismo, String identificador, String credencial) {

        boolean acceso = mecanismo.validarIdentidad(identificador, credencial);

        if (acceso) {
            System.out.println("Acceso concedido. Bienvenido " + identificador);
        } else {
            System.out.println("Acceso denegado. Credenciales incorrectas.");
        }
    }
}