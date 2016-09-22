import org.skife.jdbi.v2.DBI;

import java.util.ArrayList;
import java.util.List;
public class Book {
    //represents a bound set of pages

    String title;
    String author;
    List<String> reviews=new ArrayList<>();

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void addReview(String review){
        DBI dbi = new DBI("jdbc:postgresql://localhost/librarydb", "kiran", "");
        ReviewDAO reviewDao = dbi.onDemand(ReviewDAO.class);
        LibraryDAO libraryDao = dbi.onDemand(LibraryDAO.class);

        Integer id = libraryDao.getBookID(title,author);
        reviewDao.addReview(id,review);
    }

    public Book getReviews(){
        DBI dbi = new DBI("jdbc:postgresql://localhost/librarydb", "kiran", "");
        ReviewDAO reviewDao = dbi.onDemand(ReviewDAO.class);
        LibraryDAO libraryDao = dbi.onDemand(LibraryDAO.class);

        Integer id = libraryDao.getBookID(title,author);
        reviews = reviewDao.getReviews(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book other = (Book) o;

        if (!title.equals(other.title)) return false;
        return (author.equals(other.author));
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", reviews=" + reviews +
                '}';
    }
}
