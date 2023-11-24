
package Clientes;

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



public class ArchivoClientes {
    
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
            Connection conexion = Conexion.obtenerConexion();
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
    public static Clientes modificarCliente(
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
            Connection conexion = Conexion.obtenerConexion();
            String query="UPDATE clientes SET ClienteID=?, Nombre=?, Apellido=?, fechaNacimiento=?, genero=?,domicilio=?, localidad=?, provincia=?, estadoCivil=?,CantHijos=?, mail=? WHERE cuil=?";
            PreparedStatement sq = conexion.prepareStatement(query);
                            
                sq.setInt(1,Integer.parseInt(cliente.getId()));
                sq.setString(2, cliente.getNombre());
                sq.setString(3, cliente.getApellido());
                sq.setString(4, cliente.getFechaNacimiento());
                sq.setString(5, cliente.getGenero());
                sq.setString(6, cliente.getDomicilio());
                sq.setString(7, cliente.getLocalidad());
                sq.setString(8, cliente.getProvincia());
                sq.setString(9, cliente.getEstadoCivil());
                sq.setInt(10,Integer.parseInt( cliente.getHijos()));
                sq.setString(11, cliente.getMail());
                sq.setString(12, cliente.getCuil());

            sq.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArchivoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return null;
    }
    public static String buscarCliente(String cuil){

        try {
            Connection conexion = Conexion.obtenerConexion();
            String query="SELECT Nombre, Apellido FROM clientes WHERE Cuil=?";
            PreparedStatement sq = conexion.prepareStatement(query);
            
            sq.setString(1, cuil);
            ResultSet rs = sq.executeQuery();
            
            if(rs.next()){
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                return nombre + " " + apellido;
            }
            

            
            sq.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArchivoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static String buscarIdCliente(String cuil){

        try {
            Connection conexion = Conexion.obtenerConexion();
            String query="SELECT ClienteID FROM clientes WHERE Cuil=?";
            PreparedStatement sq = conexion.prepareStatement(query);
            
            sq.setString(1, cuil);
            ResultSet rs = sq.executeQuery();
            
            if(rs.next()){
                String idCliente = rs.getString("ClienteID");
                return idCliente;
            }            
            sq.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArchivoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static Clientes obtenerDatosCliente(String cuil){
        Clientes cliente = null;
        try {
            Connection conexion = Conexion.obtenerConexion();
            String query="SELECT * FROM clientes WHERE Cuil=?";
            PreparedStatement sq = conexion.prepareStatement(query);
            
            sq.setString(1, cuil);
            ResultSet rs = sq.executeQuery();
            
            if(rs.next()){
                 cliente = new Clientes(
                        rs.getString("ClienteID"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("FechaNacimiento"),
                        rs.getString("Genero"),
                        rs.getString("Cuil"),
                        rs.getString("Domicilio"),
                        rs.getString("Localidad"),
                        rs.getString("Provincia"),
                        rs.getString("EstadoCivil"),
                        rs.getString("CantHijos"),
                        rs.getString("Mail")
                 );
                        
                return cliente;
            }            
            sq.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArchivoClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cliente;
    }
    
}
