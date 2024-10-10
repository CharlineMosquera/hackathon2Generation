import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Agenda {
    protected List<Contacto> agenda;
    protected int tamanio;

    public Agenda() {
        this.tamanio=10;
        agenda= new ArrayList<>(this.tamanio);
    }



    public Agenda( int tamanio ) {
        this.tamanio=tamanio;
        agenda= new ArrayList<>(this.tamanio);
    }

    public List<Contacto> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Contacto> agenda) {
        this.agenda = agenda;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    // Añade un nuevo contacto
   public void aniadirContacto( Contacto c){
        // si hay espacios libres y no existe el contacto
        if (espaciosLibres() != 0 && !existeContacto(c)){
            agenda.add(c);
            System.out.println("Se añadió el contacto con exito!");
        } else {
            System.out.println("el contacto ya existe");
        }
   }

   // verifica si existe o no un contacto en la agenda
   public boolean existeContacto(Contacto c){
        // retorna True o False
        return agenda.contains(c);
   }

   public void listarContactos(){
        for(Contacto c : agenda ){
            System.out.println(c.toString());



        }
   }

    // Busca el contacto en la agenda
   public void buscaContacto(String nombre, String apellido){
        for (Contacto buscado : agenda) {
            if (Objects.equals(buscado.nombre, nombre) && Objects.equals(buscado.apellido, apellido)){
                System.out.println("el numero del contacto es: " + buscado.getTelefono());
            } else {
                System.out.println("El contacto no se ha encontrado en la agenda");
            }
        }
   }

    // Elimina ell contacto de la agenda
    public void eliminarContacto(Contacto c){
        if (existeContacto(c)){
            agenda.remove(c);
            System.out.println("El contacto " + c.nombre + " ha sido eliminado de la agenda" );
        } else {
            System.out.println("el contacto no existe en la agenda");
        }
    }

    public void modificarTelefono(String nombre, String apellido, double nuevoTelefono){
        for (Contacto buscado : agenda) {
            if (Objects.equals(buscado.nombre, nombre) && Objects.equals(buscado.apellido, apellido)){
               buscado.setTelefono(nuevoTelefono);
                System.out.println("El telefono se ha modificado, el nuevo telefono es " + nuevoTelefono);
            } else {
                System.out.println("El contacto no se ha encontrado en la agenda");
            }
        }
    }


    // Valida si la agenda está llena
   public boolean agendaLlena(){
    if(agenda.size() == tamanio ){
        System.out.println("No hay espacio para nuevos contactos");
        return true;
    }else{
        return false;
    }
   }



    // Valida si hay espacios libres
   public int espaciosLibres(){
     if(agendaLlena()) {
       return 0;
     }

       return tamanio- agenda.size();
   }

}
