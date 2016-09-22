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
        Book expectedBook = library.getBook(2);
        Assert.assertEquals(expectedBook, secondBook);
    }

    @Test
    public void addReviewToABook() {
        Book firstBook = new Book("Book1","Author1");
        firstBook.addReview("good");
    }

    @Test
    public void getReviewsToABook() {
        Book firstBook = new Book("Book1","Author1");
        Book reviewedBook = firstBook.getReviews();
        Assert.assertTrue(reviewedBook.reviews.contains("Good"));
    }
}
