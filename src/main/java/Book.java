public class Book {
    //represents a bound set of pages

    String title;
    String author;
    String[] reviews = new String[10];

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}
