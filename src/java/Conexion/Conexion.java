package Conexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String driverClass = "oracle.jdbc.driver.OracleDriver";

    private Connection con;

    private final String url = "jdbc:oracle:thin:@168.232.165.127:1521:XE";
    private final String userName = "ALE";
    private final String password = "duoc2019";

    public void init() throws IOException, ClassNotFoundException {
        Class.forName(driverClass);
    }

    public void open() throws SQLException, IOException {
        con = DriverManager.getConnection(url, userName, password);
    }

    public void close() throws SQLException {
        if (con != null) {
            con.close();
        }
    }
    
    public Connection getCon(){
        return con;
    }

}
