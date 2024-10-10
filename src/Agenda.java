import java.util.HashSet;
import java.util.Set;

public class Agenda {
    protected Set<Contacto> agenda;
    protected int tamanio;

    public Agenda() {
        this.tamanio=10;
        agenda= new HashSet<>(this.tamanio);
    }

    public Agenda( int tamanio ) {
        this.tamanio=tamanio;
        agenda= new HashSet<>(this.tamanio);
    }

    public Set<Contacto> getAgenda() {
        return agenda;
    }

    public void setAgenda(Set<Contacto> agenda) {
        this.agenda = agenda;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

   public void aniadirContacto( Contacto c){

   }
   public boolean agendaLlena(){
    if(agenda.size() == tamanio ){
        System.out.println("No hay espacio para nuevos contactos");
        return true;
    }else{
        return false;
    }
   }
   public int espaciosLibres(){
     if(agendaLlena()) {
       return 0;
     }

       return tamanio- agenda.size();
   }

}
