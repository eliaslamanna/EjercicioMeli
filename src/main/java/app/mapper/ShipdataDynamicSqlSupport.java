package app.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ShipdataDynamicSqlSupport {
    public static final Shipdata shipdata = new Shipdata();

    public static final SqlColumn<Integer> id = shipdata.id;

    public static final SqlColumn<String> name = shipdata.name;

    public static final SqlColumn<Float> distance = shipdata.distance;

    public static final SqlColumn<String> message = shipdata.message;

    public static final class Shipdata extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("`name`", JDBCType.VARCHAR);

        public final SqlColumn<Float> distance = column("distance", JDBCType.REAL);

        public final SqlColumn<String> message = column("message", JDBCType.VARCHAR);

        public Shipdata() {
            super("shipdata");
        }
    }
}