public class AuthPasswordTradicional implements MecanismoAutenticacion {

    @Override
    public boolean validarIdentidad(String identificador, String credencial) {

        if (identificador.equals("admin") && credencial.equals("1234")) {
            return true;
        }

        return false;
    }
}