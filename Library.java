import java.io.*;
import java.util.*;

public class Library implements Serializable {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (int i = 0; i < books.size(); i++) {
            System.out.println((i + 1) + ". " + books.get(i));
        }
    }

    public void borrowBook(int index) {
        if (index < 1 || index > books.size()) {
            System.out.println("Invalid book index.");
            return;
        }
        Book book = books.get(index - 1);
        if (book.isBorrowed()) {
            System.out.println("Book already borrowed.");
        } else {
            book.borrow();
            System.out.println("Book borrowed.");
        }
    }

    public void returnBook(int index) {
        if (index < 1 || index > books.size()) {
            System.out.println("Invalid book index.");
            return;
        }
        Book book = books.get(index - 1);
        if (!book.isBorrowed()) {
            System.out.println("Book is not borrowed.");
        } else {
            book.returnBook();
            System.out.println("Book returned.");
        }
    }

    public void saveToFile(String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
        }
    }

    public static Library loadFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Library) ois.readObject();
        }
    }
}
