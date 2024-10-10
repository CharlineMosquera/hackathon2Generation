public class Contacto <Contacto> {
    protected String nombre;
    protected String apellido;
    protected double telefono;

    public Contacto(String nombre, String apellido, double telefono) {
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

    public double getTelefono() {
        return telefono;
    }

    public void setTelefono(double telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono=" + telefono +
                '}';
    }

  //  @Override
   // public int compareTo(Contacto other) {
     //   return this.nombre.compareTo(other.nombre); // Or another attribute

}

