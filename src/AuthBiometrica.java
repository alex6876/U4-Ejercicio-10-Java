public class AuthBiometrica implements MecanismoAutenticacion {

    @Override
    public boolean validarIdentidad(String identificador, String credencial) {

        if (identificador.equals("usuario1") && credencial.equals("HUELLA123")) {
            return true;
        }

        return false;
    }
}