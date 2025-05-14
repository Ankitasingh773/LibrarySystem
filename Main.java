import  java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library;

        try {
            library = Library.loadFromFile("library.dat");
            System.out.println("Library data loaded.");
        } catch (Exception e) {
            library = new Library();
            System.out.println("New library created.");
        }

        while (true) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Save & Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    library.viewBooks();
                    break;
                case 3:
                    System.out.print("Enter book number to borrow: ");
                    library.borrowBook(Integer.parseInt(sc.nextLine()));
                    break;
                case 4:
                    System.out.print("Enter book number to return: ");
                    library.returnBook(Integer.parseInt(sc.nextLine()));
                    break;
                case 5:
                    try {
                        library.saveToFile("library.dat");
                        System.out.println("Library saved. Exiting...");
                        return;
                    } catch (Exception e) {
                        System.out.println("Error saving library: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
