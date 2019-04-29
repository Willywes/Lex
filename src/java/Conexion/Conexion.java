package Conexion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static final String driverClass = "oracle.jdbc.driver.OracleDriver";
    private static Connection con;
    private static final String url = "jdbc:oracle:thin:@168.232.165.127:1521:XE";
    private static final String userName = "ALE";
    private static final String password = "duoc2019";

    public void init() throws IOException, ClassNotFoundException {
        Class.forName(driverClass);
    }

    public static Connection open() throws SQLException, IOException {
       return  con = DriverManager.getConnection(url, userName, password);
    }

    public static void close() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
