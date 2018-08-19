package entity;

public class Book {
    private int Id;
    private String name;
    private double price;
    private String author;
    private String press;

    public Book() {

    }

    public Book(int id, String name, double price, String author, String press) {
        Id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.press = press;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }
}
