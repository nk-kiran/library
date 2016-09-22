import static spark.Spark.after;
import static spark.Spark.get;
public class LibraryController {

    public LibraryController(final Library library){

        get("/books/:id", (req, res) -> {
            String id = req.params(":id");
            return library.getBook(Integer.parseInt(id));
        },new JsonTransformer());

        get("/review/:id", (req, res) -> {
            String id = req.params(":id");
            Book book= library.getBook(Integer.parseInt(id));
            return new Review(book).getReviews();
        }, new JsonTransformer());

        after((req, res) -> {
            res.type("application/json");
        });
    }
}
