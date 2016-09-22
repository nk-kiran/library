
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface LibraryDAO {

    @SqlUpdate(("CREATE TABLE IF NOT EXISTS BOOK(" +
            "ID INT PRIMARY KEY     NOT NULL, "+
            "TITLE        VARCHAR(50)    NOT NULL,"+
            "AUTHOR       VARCHAR(50)     NOT NULL) "))
    void createTableBook();

    @SqlUpdate(("CREATE TABLE IF NOT EXISTS REVIEW(" +
            "ID INT     NOT NULL, "+
            "REVIEWS   VARCHAR(50)    NOT NULL)"))
    void createTableReview();

    @SqlUpdate("INSERT INTO BOOK(ID, TITLE, AUTHOR) values(:id, :title, :author)")
    void addBook(@Bind("id") Integer id, @Bind("title") String title ,@Bind("author") String author);

    @SqlQuery("SELECT COUNT(*) FROM BOOK")
    Integer getRowCount();

    @SqlQuery("SELECT ID FROM BOOK WHERE TITLE = :title and AUTHOR= :author")
    Integer getBookID(@Bind("title") String title, @Bind("author") String author);

    @SqlQuery("SELECT * FROM BOOK WHERE ID = :id")
    @Mapper(BookMapper.class)
    Book getBook(@Bind("id") Integer id);

}
