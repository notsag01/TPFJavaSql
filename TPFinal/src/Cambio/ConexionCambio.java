
package Cambio;

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


public class ConexionCambio {
    
    public static CambioClientes cargar(
            String usuario,
            int idUsuario, 
            String clienteId, 
            String servicioId,
            int tipoMoneda,
            Double cotizacion,
            Double cantPesos,
            Double impPais,
            Double impGcias,
            Double cambio){
        CambioClientes cc = new CambioClientes(
            usuario,
            idUsuario, 
            clienteId, 
            servicioId,
            tipoMoneda,
            cotizacion,
            cantPesos,
            impPais,
            impGcias,
            cambio                
        );
        try {
            Connection conexion = Conexion.obtenerConexion();
            String query = "INSERT INTO cambiomoneda VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement sq = conexion.prepareStatement(query);

            sq.setString(1, "0");
            sq.setInt(2,cc.getIdUsuario());
            sq.setString(3,cc.getClienteId());
            sq.setString(4,cc.getServicioId());
            sq.setDouble(5,cc.getCantPesos());
            sq.setInt(6,cc.getTipoMoneda());
            sq.setDouble(7,cc.getImpPais());
            sq.setDouble(8,cc.getImpGcias());
            sq.setDouble(9,cc.getCambio());

            
            int resultado = sq.executeUpdate();
            
            if(resultado>0){
                JOptionPane.showMessageDialog(null, "La transacción fue realizada \n Existosamente");          
            }else{
                JOptionPane.showMessageDialog(null, "El Usuario no a podido ser registrado Correctamente");
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cc;
    }
}
