import org.skife.jdbi.v2.DBI;

public class MainApplication {
    public static void main(String[] args) {

        DBI dbi = new DBI("jdbc:postgresql://localhost/librarydb", "kiran", "");
        LibraryDAO libraryDao = dbi.onDemand(LibraryDAO.class);
        ReviewDAO  reviewDao = dbi.onDemand(ReviewDAO.class);
        libraryDao.createTableBook();
        reviewDao.createTableReview();

        new LibraryController(new Library());
        new ReviewController();
    }
}
