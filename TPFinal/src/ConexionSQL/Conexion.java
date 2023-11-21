
package ConexionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    private static final String url="jdbc:mysql://localhost:3307/tpfinalsql";
    private static final String usser="root";
    private static final String pw="Notsag10";
    
    public static Connection obtenerConexion() throws SQLException{
        return DriverManager.getConnection(url,usser,pw);
    }
    
}
