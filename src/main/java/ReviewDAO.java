import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

import java.util.List;

public interface ReviewDAO {

    @SqlUpdate("INSERT INTO REVIEW(ID, REVIEWS) values( :id , :review)")
    void addReview(@Bind("id") Integer id, @Bind("review") String review);

    @SqlQuery("SELECT REVIEWS FROM REVIEW WHERE ID= :id")
    List<String> getReviews(@Bind("id") Integer id);
}
