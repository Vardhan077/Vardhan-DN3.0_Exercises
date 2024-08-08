package WEEK1_DSA.DSA;

import java.util.Arrays;
import java.util.Comparator;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        BookManager library = new BookManager(10);
        library.addBook(new Book(1, "Effective Java", "Joshua Bloch"));
        library.addBook(new Book(2, "Clean Code", "Robert C. Martin"));
        library.addBook(new Book(3, "Design Patterns", "Erich Gamma"));
        library.addBook(new Book(4, "Refactoring", "Martin Fowler"));

        System.out.println("All books in the library:");
        for (int i = 0; i < 4; i++) {
            System.out.println(library.findBookByTitleLinear("Effective Java"));
        }

        System.out.println("\nSearching for 'Design Patterns' using linear search:");
        Book book = library.findBookByTitleLinear("Design Patterns");
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }

        library.sortBooksByName();

        System.out.println("\nSearching for 'Clean Code' using binary search:");
        book = library.findBookByTitleBinary("Clean Code");
        if (book != null) {
            System.out.println("Found: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }
}



class Book {
    private int id;
    private String name;
    private String authorName;

    public Book(int id, String name, String authorName) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthorName() {
        return authorName;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + name + ", Author: " + authorName;
    }
}



class BookManager {
    private Book[] collection;
    private int size;

    public BookManager(int capacity) {
        collection = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size < collection.length) {
            collection[size++] = book;
        } else {
            System.out.println("Array is full. Cannot add more books.");
        }
    }

    public Book findBookByTitleLinear(String title) {
        for (int i = 0; i < size; i++) {
            if (collection[i].getName().equalsIgnoreCase(title)) {
                return collection[i];
            }
        }
        return null;
    }

    public void sortBooksByName() {
        Arrays.sort(collection, 0, size, Comparator.comparing(Book::getName, String.CASE_INSENSITIVE_ORDER));
    }

    public Book findBookByTitleBinary(String title) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = collection[mid].getName().compareToIgnoreCase(title);
            if (comparison == 0) {
                return collection[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}