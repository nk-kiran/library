import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements ResultSetMapper<Book> {
    public Book map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Book(r.getString("title"), r.getString("author"));
    }
}
