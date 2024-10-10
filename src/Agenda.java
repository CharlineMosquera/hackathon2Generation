import java.util.*;


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
   public void aniadirContacto(Contacto c){
        // si hay espacios libres y no existe el contacto-
        if (espaciosLibres() != 0 && !existeContacto(c)){
            agenda.add(c);
            System.out.println("Se añadió el contacto con exito!");
        } else {
            System.out.println("El contacto ya existe");
        }
   }

   // verifica si existe o no un contacto en la agenda
   public boolean existeContacto(Contacto c){
        // retorna True o False
       for(Contacto contacto : agenda) {
           if (contacto.getNombre().equalsIgnoreCase(c.getNombre()) &&
                   contacto.getApellido().equalsIgnoreCase(c.getApellido())) {
               return true;
           }
       }
       return false;
   }

   public void listarContactos(){
        // Implementa metodo compare de la interfaz Comparator
       Collections.sort(agenda, new Comparator<Contacto>() {
           @Override
           public int compare(Contacto c1, Contacto c2) {
               // compara por nombre
               int nombreComparison = c1.nombre.compareTo(c2.nombre);
               if (nombreComparison != 0) {
                   return nombreComparison; // Si los nombres son diferentes, ordenamos por nombre
               }
               // Si los nombres son iguales, comparar por apellido
               return c1.apellido.compareTo(c2.apellido);
           }
       });
        for(Contacto c : agenda ){
            System.out.println(c.mostrarDatos());
        }
   }

    // Busca el contacto en la agenda
   public Contacto buscaContacto(String nombre, String apellido){
        for (Contacto buscado : agenda) {
            if (buscado.getNombre().equalsIgnoreCase(nombre) && buscado.getApellido().equalsIgnoreCase(apellido)){
                return buscado;
            }
        }
       return null;
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

    public void modificarTelefono(String nombre, String apellido, String nuevoTelefono){
        Contacto modificar = buscaContacto(nombre, apellido);
        if (modificar != null){
            modificar.setTelefono(nuevoTelefono);
            System.out.println("El telefono se ha modificado, el nuevo telefono es " + nuevoTelefono);
        } else {
            System.out.println("El contacto no se ha encontrado en la agenda");
        }
    }


    // Valida si la agenda está llena
   public boolean agendaLlena(){
        if(agenda.size() == tamanio ){
        System.out.println("Agenda llena - No hay espacio para nuevos contactos");
        return true;
        } else {
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
