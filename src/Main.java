public class Main {

    public static void main(String[] args) {

        ControladorAcceso controlador = new ControladorAcceso();

        MecanismoAutenticacion password = new AuthPasswordTradicional();

        MecanismoAutenticacion biometrica = new AuthBiometrica();

        MecanismoAutenticacion oauth = new AuthOAuthProveedor();


        System.out.println("===== AUTENTICACION TRADICIONAL =====");

        controlador.iniciarSesion(password, "admin", "1234");


        System.out.println("\n===== AUTENTICACION BIOMETRICA =====");

        controlador.iniciarSesion(biometrica, "usuario1", "HUELLA123");


        System.out.println("\n===== AUTENTICACION OAUTH =====");

        controlador.iniciarSesion(oauth, "usuario@gmail.com", "OAUTH_VALIDO");


        System.out.println("\n===== INTENTO FALLIDO =====");

        controlador.iniciarSesion(password, "admin", "incorrecta");
    }
}