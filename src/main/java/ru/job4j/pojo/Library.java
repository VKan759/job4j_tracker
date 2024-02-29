package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book firstBook = new Book("Clean code", 123);
        Book secondBook = new Book("Java Manual", 700);
        Book notes = new Book("Заметки путешественника", 345);
        Book dictionary = new Book("Словарь", 1000);

        Book[] books = new Book[4];
        books[0] = firstBook;
        books[1] = secondBook;
        books[2] = notes;
        books[3] = dictionary;

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName() + " - " + books[i].getPagesCount());
        }
        System.out.println();

        Book example = books[0];
        books[0] = books[3];
        books[3] = example;
        for (int i = 0; i < books.length; i++) {
            if ("Clean code".equals(books[i].getName())) {
                System.out.println(books[i].getName() + " - " + books[i].getPagesCount());
            }
        }
    }
}
