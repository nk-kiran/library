
import org.skife.jdbi.v2.DBI;
//represents a collection of books  
public class Library {

    Integer id = 0;

    public Library() {
    }

    public Book addBook(Book book) {
        DBI dbi = new DBI("jdbc:postgresql://localhost/librarydb", "kiran", "");
        LibraryDAO dao = dbi.onDemand(LibraryDAO.class);
        id = dao.getRowCount() + 1;
        dao.addBook(id, book.title, book.author);
        return dao.getBook(id);
    }

    public Book getBook(Integer id) {
        DBI dbi = new DBI("jdbc:postgresql://localhost/librarydb", "kiran", "");
        LibraryDAO dao = dbi.onDemand(LibraryDAO.class);
        Book book = dao.getBook(id);
        return book;
    }

    public Integer getBookID(Book book){
        DBI dbi = new DBI("jdbc:postgresql://localhost/librarydb", "kiran", "");
        LibraryDAO dao = dbi.onDemand(LibraryDAO.class);
        return dao.getBookID(book.title,book.author);
    }
}
