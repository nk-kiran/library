import static spark.Spark.get;
public class LibraryController {

    public LibraryController(final Library library){

        get("/books/:id", (req, res) -> {
            String id = req.params(":id");
            return library.getBook(Integer.parseInt(id));
        });

        get("/review/:id", (req, res) -> {
            String id = req.params(":id");
            Book book= library.getBook(Integer.parseInt(id));
            return book.getReviews();
        });

    }
}
