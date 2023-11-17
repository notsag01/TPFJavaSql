
package Clientes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class ArchivoClientes {

    private static final String url="jdbc:mysql://localhost:3307/tpfinalsql";
    private static final String usser="root";
    private static final String pw="Notsag10";
    
    public static Clientes nuevoCliente(
            String id,
            String nombre, 
            String apellido, 
            String fechaNacimiento, 
            String genero, 
            String cuil,
            String domicilio, 
            String localidad, 
            String provincia, 
            String estadoCivil, 
            String hijos,
            String mail            
        ){
        Clientes cliente = new Clientes(
                id,
                nombre,
                apellido,
                fechaNacimiento,
                genero,
                cuil,
                domicilio,
                localidad,
                provincia,
                estadoCivil,
                hijos,
                mail
        );
        try {
            Connection conexion = DriverManager.getConnection(url,usser,pw);
            String query="INSERT INTO clientes VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement sq = conexion.prepareStatement(query);
            
            sq.setString(1, "0");
            sq.setString(2, cliente.getNombre());
            sq.setString(3, cliente.getApellido());
            sq.setString(4, cliente.getFechaNacimiento());
            sq.setString(5, cliente.getGenero());
            sq.setString(6, cliente.getCuil());
            sq.setString(7, cliente.getDomicilio());
            sq.setString(8, cliente.getLocalidad());
            sq.setString(9, cliente.getProvincia());
            sq.setString(10, cliente.getEstadoCivil());
            sq.setString(11, cliente.getHijos());
            sq.setString(12, cliente.getMail());
            
            sq.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArchivoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    
}
