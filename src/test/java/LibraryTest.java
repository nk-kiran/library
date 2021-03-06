import org.junit.Assert;
import org.junit.Test;

public class LibraryTest {

    @Test
    public void shouldAddBookToLibrary() {
        Library library = new Library();
        Book firstBook = library.addBook(new Book("Book1","Author1"));
        Book expectedBook = new Book("Book1", "Author1");

        Assert.assertEquals(expectedBook, firstBook);
    }

    @Test
    public void ShouldReturnBookUsingID() {
        Library library = new Library();
        Book secondBook = library.addBook(new Book("Book2", "Author2"));
        Integer id = library.getBookID(secondBook);
        Book expectedBook = library.getBook(id);

        Assert.assertEquals(expectedBook, secondBook);
    }
}
