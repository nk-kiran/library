
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

@RegisterMapper(BookMapper.class)
public interface LibraryDAO {

    @SqlUpdate(("CREATE TABLE IF NOT EXISTS BOOK(" +
            "ID INT PRIMARY KEY     NOT NULL, "+
            "TITLE        VARCHAR(50)    NOT NULL,"+
            "AUTHOR       VARCHAR(50)     NOT NULL) "))
    void createTableBook();

    @SqlUpdate("INSERT INTO BOOK(ID, TITLE, AUTHOR) values(:id, :title, :author)")
    void addBook(@Bind("id") Integer id, @Bind("title") String title ,@Bind("author") String author);

    @SqlQuery("SELECT COUNT(*) FROM BOOK")
    Integer getRowCount();

    @SqlQuery("SELECT * FROM BOOK WHERE ID = :id")
    @Mapper(BookMapper.class)
    Book getBook(@Bind("id") Integer id);
}
