
package Usuarios;

import ConexionSQL.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexionUsuarios {
    
    public static Usuarios crearUsuario(String nombre, String apellido, String userName, String contrasenia){
        Usuarios usuario = new Usuarios(nombre,apellido,userName,contrasenia);
        try {
            Connection conexion = Conexion.obtenerConexion();
            String query = "INSERT INTO usuarios VALUES (?,?,?,?,?)";
            PreparedStatement sq = conexion.prepareStatement(query);

            sq.setString(1, "0");
            sq.setString(2, usuario.getNombre() );
            sq.setString(3, usuario.getApellido() );
            sq.setString(4, usuario.getUserName());
            sq.setString(5, usuario.getContrasenia());
            
            int resultado = sq.executeUpdate();
            
            if(resultado>0){
                JOptionPane.showMessageDialog(null, "El Usuario fue registrado Correctamente");                
            }else{
                JOptionPane.showMessageDialog(null, "El Usuario no a podido ser registrado Correctamente");
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
    }
    
    public static String[] obtenerUsuarios(){
        ArrayList<String> listaUsuarios = new ArrayList<>();
        
        try {
            Connection conexion = Conexion.obtenerConexion();
            String query="SELECT UserName FROM usuarios";
            PreparedStatement sq = conexion.prepareStatement(query);
            
            ResultSet rs = sq.executeQuery();
            
            while(rs.next()){
                String usuarios = rs.getString("UserName");
                listaUsuarios.add(usuarios);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaUsuarios.toArray(new String[0]);
    }
     
    public static boolean verificarCredenciales(String usuario, String contrasenia){
        try {
            Connection conexion = Conexion.obtenerConexion();
            String query="SELECT contraseña FROM usuarios WHERE UserNAme=?";
            PreparedStatement sq = conexion.prepareStatement(query);
            
            sq.setString(1,usuario);
            ResultSet rs = sq.executeQuery();
            
            if(rs.next()){
                String contraseniaEncontrada = rs.getString("Contraseña");
                
                return contrasenia.equals(contraseniaEncontrada);
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return false;
    }
}
