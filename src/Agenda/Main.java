package Agenda;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();

        String menu = "===== Agenda.Agenda de Contactos =====\n" +
                "1. Agregar contacto\n" +
                "2. Mostrar todos los contactos\n" +
                "3. Buscar contacto por nombre\n" +
                "4. Eliminar contacto\n" +
                "5. Salir";


        while (true) {
            System.out.println(menu);

            int opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1:
                    boolean noAdded = true;
                    while (noAdded) {
                        System.out.println("Ingrese el nombre del contacto: ");
                        String contactName = sc.nextLine();
                        System.out.println("Ingrese el telefono del contacto: ");
                        String contactPhone = sc.nextLine();
                        System.out.println("Ingrese el email del contacto: ");
                        String contactEmail = sc.nextLine();

                        Contact contact = new Contact(contactName, contactPhone, contactEmail);
                        if (agenda.addContact(contact)) {
                            System.out.println("Contacto agregado");
                            noAdded = false;
                        } else {
                            System.out.println("Contacto no agregado, ya existe un contacto con este nombre");
                        }
                    }
                    break;
                case 2:
                    List<Contact> contactList = agenda.showContacts();
                    if (contactList.isEmpty()) {
                        System.out.println("Noy hay contactos por mostrar");
                    } else {
                        contactList.forEach(contact -> {
                            System.out.println(contact.getName());
                            System.out.println(contact.getPhone());
                            System.out.println(contact.getEmail());});
                    }
                    break;
                case 3:
                    System.out.println("Qué contacto desea encontrar?");
                    String contactName = sc.nextLine();
                    Contact contact = agenda.searchByName(contactName);
                    if (contact == null) {
                        System.out.println("Contacto no encontrado");
                    } else {
                        System.out.println("Contacto hallado: " + contact.getName() + " " + contact.getPhone() + " " + contact.getEmail());
                    }
                    break;
                case 4:
                    System.out.println("Qué contacto desea eliminar?");
                    String contactToDelete = sc.nextLine();
                    boolean deleted = agenda.deleteByName(contactToDelete);
                    if (deleted) {
                        System.out.println("Contacto eliminado");
                    } else {
                        System.out.println("Contacto no existe");
                    }
                    break;
                case 5:
                    break;
            }
        }
    }
}
