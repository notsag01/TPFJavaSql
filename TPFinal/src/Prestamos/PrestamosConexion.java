
package Prestamos;

import ConexionSQL.Conexion;
import Usuarios.ConexionUsuarios;
import Usuarios.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PrestamosConexion {
    
    public static PrestamoCliente solicitarPrestamo(
        String clienteId,String servicioId,
        int usuarioId, int capital,int meses,int interes,double monto,
        double cuota
    ){
        PrestamoCliente pc = new PrestamoCliente(
            usuarioId,clienteId,servicioId,capital,meses,interes,monto,cuota
        );
        try {
            Connection conexion = Conexion.obtenerConexion();
            String query = "INSERT INTO prestamos VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement  sq = conexion.prepareStatement(query);
            
            sq.setString(1, "0");
            sq.setInt(2, pc.getUsuarioId());
            sq.setInt(3, Integer.parseInt(pc.getClienteId()));
            sq.setInt(4, Integer.parseInt(pc.getServicioId()));
            sq.setInt(5, pc.getCapital());
            sq.setInt(6, pc.getMeses());
            sq.setInt(7, pc.getInteres());
            sq.setDouble(8, pc.getCuota());
            sq.setDouble(9, pc.getMonto());
            
            int resultado=sq.executeUpdate();
            
            if(resultado>0){
                JOptionPane.showMessageDialog(null, "La transacción fue exitos");
            }else{
                JOptionPane.showMessageDialog(null, "La transacción no se pudo llevar a cabo \n "
                        + "Revise los datos ingresados o contactese con el administrador");
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PrestamosConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        return null;
    }
}
