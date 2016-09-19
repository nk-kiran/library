import org.junit.Assert;
import org.junit.Test;

public class LibraryTest {

    @Test
    public void shouldReturnAllTheBooksInLibrary() {
        Library library = new Library();
        Book firstBook = library.addBook("Title", "Author");
        Assert.assertEquals(firstBook.title, "Title");
        Assert.assertEquals(firstBook.author, "Author");
    }
}
