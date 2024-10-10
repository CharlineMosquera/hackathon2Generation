import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Agenda agenda;

        boolean salir = false;
        Scanner scanner = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);

        System.out.println("\n** BIENVENIDO A SU AGENDA TELEFONICA **");
        System.out.println("¿Desea personalizar el tamaño de su agenda? si/no");
        String personalizarTam = scanner.nextLine();

        if (personalizarTam.equalsIgnoreCase("si")) {
            System.out.println("¿Cuantos espacios desea tener en su agenda?");
            int tamnioAgenda = scannerNum.nextInt();
            agenda = new Agenda(tamnioAgenda);
            System.out.println("Se creo su agenda con espacio para " + agenda.getTamanio() + " contactos.");
        } else {
            agenda = new Agenda();
            System.out.println("Se creo su agenda con el tamaño predeterminado.");
        }

        while (!salir) {
            System.out.println("\n1 => Añadir nuevo contacto");
            System.out.println("2 => Buscar un contacto");
            System.out.println("3 => Mostrar todos los contactos");
            System.out.println("4 => Eliminar un contacto");
            System.out.println("5 => Modificar telefono de un contacto");
            System.out.println("6 => Verificar espacios disponibles en la agenda");
            System.out.println("7 => Salir");
            System.out.print("Ingrese la opcion deseada: ");
            String opcion = scanner.nextLine();

            String nombre;
            String apellido;
            String telefono;

            switch (opcion) {
                case "1":
                    System.out.print("Ingrese el nombre del nuevo contacto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del nuevo contacto: ");
                    apellido = scanner.nextLine();
                    System.out.print("Ingrese el telefono del nuevo contacto: ");
                    telefono = scanner.nextLine();
                    Contacto nuevoContacto = new Contacto(nombre, apellido, telefono);
                    agenda.aniadirContacto(nuevoContacto);
                    break;
                case "2":
                    System.out.print("Ingrese el nombre del contacto a buscar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del contacto a buscar: ");
                    apellido = scanner.nextLine();
                    Contacto contactoBuscado = agenda.buscaContacto(nombre, apellido);
                    if (contactoBuscado != null) {
                        System.out.println("El telefono del contacto es: " + contactoBuscado.getTelefono());
                    } else {
                        System.out.println("El contacto no se ha encontrado en la agenda");
                    };
                    break;
                case "3":
                    System.out.println("LISTA DE CONTACTOS");
                    agenda.listarContactos();
                    break;
                case "4":
                    System.out.print("Ingrese el nombre del contacto a eliminar: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del contacto a eliminar: ");
                    apellido = scanner.nextLine();
                    Contacto contactoEliminar = agenda.buscaContacto(nombre, apellido);
                    if (contactoEliminar != null) {
                        agenda.eliminarContacto(contactoEliminar);
                    }
                    break;
                case "5":
                    System.out.print("Ingrese el nombre del contacto: ");
                    nombre = scanner.nextLine();
                    System.out.print("Ingrese el apellido del contacto: ");
                    apellido = scanner.nextLine();
                    System.out.print("Ingrese el nuevo telefono: ");
                    telefono = scanner.nextLine();
                    agenda.modificarTelefono(nombre, apellido, telefono);
                    break;
                case "6":
                    System.out.println("Tiene " + agenda.espaciosLibres() + " espacios disponibles en su agenda");
                    break;
                case "7":
                    System.out.println("Ha salido de su agenda telefonica");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción invalida");
                    break;
            }
        }
    }
}
