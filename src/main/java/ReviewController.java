import org.json.JSONObject;

import static spark.Spark.after;
import static spark.Spark.get;
import static spark.Spark.post;

public class ReviewController {

    public ReviewController() {
        get("/reviews/:title/:author", (req, res) -> {
            String title = req.params(":title");
            String author = req.params(":author");
            return new Review(new Book(title, author)).getReviews();
        }, new JsonTransformer());

        post("/review", (req, res) -> {
            JSONObject obj = new JSONObject(req.body());
            String title = obj.getString("title");
            String author = obj.getString("author");
            String text = obj.getString("review");
            Review review = new Review(new Book(title, author));
            review.add(text);
            return review.getReviews();
        }, new JsonTransformer());

        after((req, res) -> res.type("application/json"));
    }
}
