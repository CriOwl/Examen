package CCDAC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class CCDataHelperSqlite {
    private final static String CCBdPath = "jdbc:sqlite:CCDatabase\\CCEcuAnt.sqlite";
    private static Connection conexion = null;

    protected CCDataHelperSqlite() {
    }

    protected static synchronized Connection opConnection() throws SQLException {
        try {
            if (conexion == null) {
                conexion = DriverManager.getConnection(CCBdPath);
            }
        } catch (SQLException e) {
            throw e;
        }
        return conexion;
    }

    protected static void closeConnection() throws SQLException {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException es) {
            throw es;
        }
    }
}