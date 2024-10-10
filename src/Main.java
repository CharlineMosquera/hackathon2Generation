public class Main {
    public static void main(String[] args) {
        Contacto contacto1 = new Contacto("jose", "Ramirez", 3333);
        Contacto contacto2 = new Contacto("luisa", "Ramirez", 686854);
        Contacto contacto3 = new Contacto("ana", "Ramirez", 2554);

        Agenda agenda = new Agenda();
        agenda.aniadirContacto(contacto1);
        agenda.aniadirContacto(contacto2);
        agenda.aniadirContacto(contacto2);
        agenda.aniadirContacto(contacto3);

        agenda.listarContactos();

    }
}
