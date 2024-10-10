public class Contacto <Contacto> {
    protected String nombre;
    protected String apellido;
    protected String telefono;

    public Contacto(String nombre, String apellido, String telefono) {
        // Verifica que ningun dato este vacio para poder crear el contacto
        if (nombre.trim().isEmpty() || apellido.trim().isEmpty() || telefono.trim().isEmpty()) {
            System.out.println("No se puede crear el contacto con datos vacios");
            return;
        }
        System.out.println("hola");
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // metodo para capitalizar las letras
    public static String capitalize(String inputString) {
        // Extrae la primera letra y la convierte a mayuscula
        // Extra el resto de letras y las convierte en minuscula
        return inputString.substring(0,1).toUpperCase() + inputString.substring(1).toLowerCase();
    }

    // Metodo para mostrar el contacto con formato especifico
    public String mostrarDatos() {
        return capitalize(nombre) + " " + capitalize(apellido) + " - " + telefono;
    }

}

