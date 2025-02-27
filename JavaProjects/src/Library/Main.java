package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        library.setBooks(new ArrayList<>());
        library.setUsers(new ArrayList<>());
        library.setLoans(new ArrayList<>());

        while (true) {
            System.out.println("\n--- Biblioteca ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Agregar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Mostrar libros disponibles");
            System.out.println("5. Mostrar préstamos de un usuario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String title = scanner.nextLine();
                    System.out.print("Ingrese el autor: ");
                    String author = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación: ");
                    int year = scanner.nextInt();

                    Book newBook = new Book(title, author, year, true);
                    if (library.addBook(newBook)) {
                        System.out.println("Libro agregado correctamente.");
                    } else {
                        System.out.println("El libro ya existe en la biblioteca.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el ID del usuario: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el nombre del usuario: ");
                    String name = scanner.nextLine();

                    User newUser = new User(userId, name);
                    if (library.addUser(newUser)) {
                        System.out.println("Usuario registrado correctamente.");
                    } else {
                        System.out.println("El usuario ya existe.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el ID del usuario: ");
                    int loanUserId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el título del libro: ");
                    String loanBookTitle = scanner.nextLine();

                    if (library.lendBook(loanUserId, loanBookTitle)) {
                        System.out.println("Libro prestado con éxito.");
                    } else {
                        System.out.println("No se pudo realizar el préstamo.");
                    }
                    break;

                case 4:
                    List<Book> availableBooks = library.getAvailableBooks();
                    if (availableBooks.isEmpty()) {
                        System.out.println("No hay libros disponibles.");
                    } else {
                        System.out.println("Libros disponibles:");
                        availableBooks.forEach(book -> System.out.println(" - " + book.getTitle()));
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el ID del usuario: ");
                    int userLoansId = scanner.nextInt();
                    List<Loan> userLoans = library.getLoansByUser(userLoansId);

                    if (userLoans.isEmpty()) {
                        System.out.println("El usuario no tiene préstamos.");
                    } else {
                        System.out.println("Préstamos del usuario:");
                        userLoans.forEach(loan ->
                            System.out.println(" - " + loan.getBook().getTitle() + " (Prestado el: " + loan.getLoanDate() + ")")
                        );
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
