import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.List;

public interface ReviewDAO {

    @SqlUpdate(("CREATE TABLE IF NOT EXISTS REVIEW(" +
            "ID INT     NOT NULL, "+
            "REVIEWS   VARCHAR(50)    NOT NULL)"))
    void createTableReview();

    @SqlUpdate("INSERT INTO REVIEW(ID, REVIEWS) values( :id , :review)")
    void addReview(@Bind("id") Integer id, @Bind("review") String review);

    @SqlQuery("SELECT REVIEWS FROM REVIEW WHERE ID= :id")
    List<String> getReviews(@Bind("id") Integer id);
}
