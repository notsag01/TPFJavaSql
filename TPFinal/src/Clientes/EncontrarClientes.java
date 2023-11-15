
package Clientes;

import Seguros.Gestor;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class EncontrarClientes {
    String id,nombre,apellido;
    boolean encontrado=false;
    
    public EncontrarClientes(String id){
        this.id=id;
    }

    public boolean isEncontrado() {
        return encontrado;
    }
    
    public void buscarCliente(){
        String rutaArchivo="archivoClientes.txt";
        String id=this.id;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            int numeroLinea=0;
                        
            try {
                while((linea = br.readLine()) != null){
                    numeroLinea++;
                    String[] datos=linea.split(",");
                    
                    
                    if(datos.length>=2){
                        String idCliente=datos[0].trim();
                        String nombreCliente=datos[1].trim();
                        String apellidoCliente=datos[2].trim();
                        
                        if(idCliente.equals(id)){
                            System.out.println(idCliente);
                            System.out.println(nombreCliente);
                            nombre=nombreCliente;
                            apellido=apellidoCliente;
                            encontrado=true;
                            break;
                        }
                    }
                    if(!encontrado){
                        JOptionPane.showMessageDialog(null, "El componente no fue encontrado");
                        break;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(EncontrarClientes.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EncontrarClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
    
}
