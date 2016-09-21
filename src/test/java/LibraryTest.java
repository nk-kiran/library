import org.junit.Assert;
import org.junit.Test;

public class LibraryTest {

    @Test
    public void shouldAddBookToLibrary() {
        Library library = new Library();
        Book firstBook = library.addBook("Book1", "Author1");
        Book expectedBook = new Book("Book1", "Author1");
        Assert.assertEquals(expectedBook, firstBook);
    }

    @Test
    public void ShouldReturnBookUsingID() {
        Library library = new Library();
        Book secondBook = library.addBook("Book2", "Author2");
        Book expectedBook = library.getBook(2);
        Assert.assertEquals(expectedBook, secondBook);
    }
}
