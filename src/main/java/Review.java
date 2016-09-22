import org.skife.jdbi.v2.DBI;
import java.util.ArrayList;
import java.util.List;
//represents comments given for a book
public class Review {

    Book book;
    List<String> allReviews = new ArrayList<>();

    public Review(Book book) {
        this.book=book;
    }

    public void add(String text) {
        DBI dbi = new DBI("jdbc:postgresql://localhost/librarydb", "kiran", "");
        ReviewDAO reviewDao = dbi.onDemand(ReviewDAO.class);
        LibraryDAO libraryDao = dbi.onDemand(LibraryDAO.class);

        Integer id = libraryDao.getBookID(book.title, book.author);
        reviewDao.addReview(id, text);
        allReviews= reviewDao.getReviews(id);
    }

    public Review getReviews() {
        DBI dbi = new DBI("jdbc:postgresql://localhost/librarydb", "kiran", "");
        ReviewDAO reviewDao = dbi.onDemand(ReviewDAO.class);
        LibraryDAO libraryDao = dbi.onDemand(LibraryDAO.class);

        Integer id = libraryDao.getBookID(book.title, book.author);
        allReviews = reviewDao.getReviews(id);
        return this;
    }

    @Override
    public String toString() {
        return "Review{" +
                "book=" + book +
                ", allReviews=" + allReviews +
                '}';
    }
}
