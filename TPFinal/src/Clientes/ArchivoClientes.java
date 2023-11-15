
package Clientes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ArchivoClientes {

    public void escribirArchivo(Clientes cliente){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("archivoClientes.txt",true));
            bw.write(
                    cliente.getId() + "," +
                    cliente.getNombre()+ "," +
                    cliente.getApellido()+ "," +
                    cliente.getMail()+ "," +
                    cliente.getFechaNacimiento()+ "," +
                    cliente.getGenero()+ "," +
                    cliente.getDomicilio()+ "," +
                    cliente.getLocalidad()+ "," +
                    cliente.getProvincia()+ "," +
                    cliente.getEstadoCivil()+ "," +
                    cliente.getHijos()
            );
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
