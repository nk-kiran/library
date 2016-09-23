import org.json.JSONObject;

import static spark.Spark.*;

public class LibraryController {

    public LibraryController(final Library library) {

        get("/books", (req, res) -> {
            String id = req.queryParams("id");
            return library.getBook(Integer.parseInt(id));
        }, new JsonTransformer());

        post("/book", (req, res) -> {
            JSONObject obj = new JSONObject(req.body());
            String title = obj.getString("title");
            String author = obj.getString("author");
            Book book = new Book(title,author);
            return library.addBook(book);
        }, new JsonTransformer());

        after((req, res) -> res.type("application/json"));
    }
}
