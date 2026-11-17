public class AuthOAuthProveedor implements MecanismoAutenticacion {

    @Override
    public boolean validarIdentidad(String identificador, String credencial) {

        if (identificador.equals("usuario@gmail.com") && credencial.equals("OAUTH_VALIDO")) {
            return true;
        }

        return false;
    }
}