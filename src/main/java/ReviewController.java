import static spark.Spark.after;
import static spark.Spark.get;

public class ReviewController {

    public ReviewController() {
        get("/review/:id", (req, res) -> {
            String id = req.params(":id");
            Library library = new Library();
            Book book = library.getBook(Integer.parseInt(id));
            return new Review(book).getReviews();
        }, new JsonTransformer());

        after((req, res) -> res.type("application/json"));
    }
}
