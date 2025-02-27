package Library;

import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<User> users;
    private List<Loan> loans;

    public Library() {
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public boolean addBook(Book book) {
        if (books.contains(book)) {
            return false;
        } else {
            books.add(book);
            return true;
        }
    }

    public boolean addUser(User user) {
        if (users.contains(user)) {
            return false;
        } else {
            users.add(user);
            return true;
        }
    }

    public boolean lendBook(int userId, String bookTitle) {
        User user = users.stream().filter(u -> u.getId() == userId).findFirst().orElse(null);
        Book book = books.stream().filter(b -> b.getTitle().equalsIgnoreCase(bookTitle) && b.isAvailable()).findFirst().orElse(null);
        if (user != null && book != null) {
            Loan loan = new Loan(user, book);
            loans.add(loan);
            book.setAvailable(false);
            return true;
        }
    return false;
}


    public List<Book> getAvailableBooks() {
        return books.stream().filter(Book::isAvailable).collect(Collectors.toList());
    }

    public List<Loan> getLoansByUser(int userId) {
        return loans.stream().filter(loan -> loan.getUser().getId() == userId).collect(Collectors.toList());
    }
}
