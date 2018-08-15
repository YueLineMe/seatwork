package dao;

import entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private static List<Book> booklist = new ArrayList<>();

    static {
        Book b = new Book(1, "东明之帅", 999, "dz", "dz147出版社");
        booklist.add(b);
        b = new Book(2, "Javaee", 998, "dz", "dz147出版社");
        booklist.add(b);
        b = new Book(3, "javascript", 13, "dz", "dz147出版社");
        booklist.add(b);
        b = new Book(4, "jquery", 12, "dz", "dz147出版社");
        booklist.add(b);
    }

    public List<Book> getAll() {
        return booklist;
    }

    public List<Book> getBookByName(String Name) {
        List<Book> newlist = new ArrayList<>();

        for (Book book : booklist) {
            String name = book.getName().toLowerCase();
            if (name.equals(Name.toLowerCase())) {
                newlist.add(book);
            }
        }
        return newlist;
    }

    public Book getBookById(int Id) {
        for (Book book : booklist) {

            if (book.getId() == Id) {
                return book;
            }
        }
        return null;
    }

    public boolean update(Book newbook) {
        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).getId() == newbook.getId()) {
                booklist.set(i, newbook);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Book book) {
        for (int i = 0; i < booklist.size(); i++) {
            if (booklist.get(i).getId() == book.getId()) {
                booklist.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean add(Book book) {
        return booklist.add(book);
    }


}
