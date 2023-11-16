
package Usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexionUsuarios {
    private static final String url="jdbc:mysql://localhost:3307/tpfinalsql";
    private static final String usser="root";
    private static final String pw="Notsag10";
    
    public static Usuarios crearUsuario(String nombre, String apellido, String userName, String contrasenia){
        Usuarios usuario = new Usuarios(nombre,apellido,userName,contrasenia);
        try {
            Connection conexion = DriverManager.getConnection(url,usser,pw);
            String query = "INSERT INTO usuarios VALUES (?,?,?,?,?)";
            PreparedStatement sq = conexion.prepareStatement(query);

            sq.setString(1, "0");
            sq.setString(2, usuario.getNombre() );
            sq.setString(3, usuario.getApellido() );
            sq.setString(4, usuario.getUserName());
            sq.setString(5, usuario.getContrasenia());
            
            sq.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }
      
}
