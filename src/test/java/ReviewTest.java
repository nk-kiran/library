import org.junit.Assert;
import org.junit.Test;

public class ReviewTest {

    @Test
    public void addReviewToABook() {
        Review newReview = new Review(new Book("Book1", "Author1"));
        newReview.add("Good");
        Assert.assertTrue(newReview.allReviews.contains("Good"));
    }

    @Test
    public void getAllReviewsOfABook() {
        Review review = new Review(new Book("Book1","Author1"));
        review = review.getReviews();
        Assert.assertTrue(review.allReviews.contains("Good"));
    }
}
