package Archivo;



import Cambio.CambioClientes;
import ConexionSQL.Conexion;
import Seguros.Personas;
import java.sql.PreparedStatement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Archivo {
    
    
    public void crearArchivo(){
    
    }
    
    public void escribirArchivo(Personas persona){
        switch(persona.getTipoSeguro()){
            case "Seguro Hogar":
            {
                try {
                    Connection conexion = Conexion.obtenerConexion();
                    String query="INSERT INTO segurohogar VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement sq = conexion.prepareStatement(query);
                    
                    sq.setString(1, "0");
                    sq.setInt(2, persona.getIdUsuario());
                    sq.setInt(3, Integer.parseInt(persona.getClienteId()));
                    sq.setInt(4, Integer.parseInt("5"));
                    sq.setBoolean(5, persona.getIncendio());
                    sq.setBoolean(6, persona.getRobo());
                    sq.setBoolean(7, persona.getInundacion());
                    sq.setBoolean(8, persona.getHeladera());
                    sq.setBoolean(9, persona.getLavarropas());
                    sq.setBoolean(10, persona.getCocina());
                    sq.setBoolean(11, persona.getNotebook());
                    sq.setInt(12, persona.getNotebookCantidad());
                    sq.setBoolean(13, persona.getConsola());
                    sq.setBoolean(14, persona.getTelevisor());
                    sq.setInt(15, persona.getTelevisorCantidad());
                    
                    sq.executeUpdate();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
//            try {
//                BufferedWriter escribir = new BufferedWriter(new FileWriter("seguros.txt",true));
//                BufferedWriter escribirHogar = new BufferedWriter(new FileWriter("segurosHogar.txt",true));
//                escribir.write(persona.getTipoSeguro() + "," +
//                                persona.getCuit() + "," +
//                                persona.getNombre() + "," +
//                                persona.getTelefono() + "," +
//                                persona.getMail()+ "," +
//                                persona.getIncendio() + "," +
//                                persona.getRobo() + "," +
//                                persona.getInundacion() + "," +
//                                persona.getHeladera()+ "," +
//                                persona.getLavarropas()+ "," +
//                                persona.getCocina()+ "," +
//                                persona.getNotebook()+ "," +
//                                persona.getNotebookCantidad()+ "," +
//                                persona.getConsola()+ "," +
//                                persona.getTelevisor()+ "," +
//                                persona.getTelevisorCantidad()
//                );
//
//                escribir.newLine();
//                escribir.close();
//                escribirHogar.write(persona.getTipoSeguro() + "," +
//                                persona.getCuit() + "," +
//                                persona.getNombre() + "," +
//                                persona.getTelefono() + "," +
//                                persona.getMail()+ "," +
//                                persona.getIncendio() + "," +
//                                persona.getRobo() + "," +
//                                persona.getInundacion() + "," +
//                                persona.getHeladera()+ "," +
//                                persona.getLavarropas()+ "," +
//                                persona.getCocina()+ "," +
//                                persona.getNotebook()+ "," +
//                                persona.getNotebookCantidad()+ "," +
//                                persona.getConsola()+ "," +
//                                persona.getTelevisor()+ "," +
//                                persona.getTelevisorCantidad()
//                );
//
//                escribirHogar.newLine();
//                escribirHogar.close();
//
//            } catch (IOException ex) {
//                System.out.println(ex);
//            }
            break;

            case "Seguro Vida":
            {   
                try {
                    Connection conexion = Conexion.obtenerConexion();
                    String query="INSERT INTO segurovida VALUES(?,?,?,?,?,?,?,?)";
                    PreparedStatement sq = conexion.prepareStatement(query);
                    
                    sq.setString(1, "0");
                    sq.setInt(2, persona.getIdUsuario());
                    sq.setInt(3, Integer.parseInt(persona.getClienteId()));
                    sq.setInt(4, Integer.parseInt("3"));
                    sq.setBoolean(5, persona.getMuerte());
                    sq.setBoolean(6, persona.getMuerteAccidental());
                    sq.setBoolean(7, persona.getInternacion());
                    sq.setBoolean(8, persona.getParalisis());
                    
                    
                    sq.executeUpdate();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                }
//                try {
//                    BufferedWriter escribir = new BufferedWriter(new FileWriter("seguros.txt",true));
//                    BufferedWriter escribirVida = new BufferedWriter(new FileWriter("segurosVida.txt",true));
//                    escribir.write(persona.getTipoSeguro()+ "," +
//                            persona.getCuit() + "," +
//                            persona.getNombre() + "," +
//                            persona.getTelefono() + "," +
//                            persona.getMail() + "," +
//                            persona.getMuerte() + "," +
//                            persona.getMuerteAccidental() + "," +
//                            persona.getInternacion()+ "," +
//                            persona.getInternacionDias()+ "," +
//                            persona.getParalisis()+ "," +
//                            persona.getBeneficiario1()+ "," +
//                            persona.getBeneficiario1_parentesco()+ "," +
//                            persona.getBeneficiario2()+ "," +
//                            persona.getBeneficiario2_parentesco()+ "," +
//                            persona.getBeneficiario3()+ "," +
//                            persona.getBeneficiario3_parentesco()+ "," +
//                            persona.getBeneficiario4()+ "," +
//                            persona.getBeneficiario4_parentesco()
//                    );
//
//                escribir.newLine();
//                escribir.close();
//                    escribirVida.write(persona.getTipoSeguro()+ "," +
//                            persona.getCuit() + "," +
//                            persona.getNombre() + "," +
//                            persona.getTelefono() + "," +
//                            persona.getMail() + "," +
//                            persona.getMuerte() + "," +
//                            persona.getMuerteAccidental() + "," +
//                            persona.getInternacion()+ "," +
//                            persona.getInternacionDias()+ "," +
//                            persona.getParalisis()+ "," +
//                            persona.getBeneficiario1()+ "," +
//                            persona.getBeneficiario1_parentesco()+ "," +
//                            persona.getBeneficiario2()+ "," +
//                            persona.getBeneficiario2_parentesco()+ "," +
//                            persona.getBeneficiario3()+ "," +
//                            persona.getBeneficiario3_parentesco()+ "," +
//                            persona.getBeneficiario4()+ "," +
//                            persona.getBeneficiario4_parentesco()
//                    );
//
//                escribirVida.newLine();
//                escribirVida.close();
//                } catch (IOException ex) {
//                    System.out.println(ex);
//                }
            }
            break;
            case "Seguro Automotor":
            {   
                try {
                    Connection conexion = Conexion.obtenerConexion();
                    String query="INSERT INTO segurovehiculo VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    PreparedStatement sq = conexion.prepareStatement(query);
                    
                    sq.setString(1, "0");
                    sq.setInt(2, persona.getIdUsuario());
                    sq.setInt(3, Integer.parseInt(persona.getClienteId()));
                    sq.setInt(4, 4);
                    sq.setString(5, persona.getDominio());
                    sq.setString(6, persona.getMarcaSelec());
                    sq.setString(7, persona.getModeloSelec());
                    sq.setInt(8, Integer.parseInt(persona.getAnio()));
                    sq.setBoolean(9, persona.getTerceroCompleto());
                    sq.setBoolean(10, persona.getResponsabilidadCivil());
                    sq.setBoolean(11, persona.getTodoRiesgoSF());
                    sq.setBoolean(12, persona.getTodoRiesgoCF());
                    sq.setBoolean(13, persona.getGranizo());                    
                    
                    sq.executeUpdate();

                    
                }catch (SQLException ex) {
                    Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//                try {
//                    BufferedWriter escribir = new BufferedWriter(new FileWriter("seguros.txt",true));
//                    BufferedWriter escribirAutomotor = new BufferedWriter(new FileWriter("segurosAutomotor.txt",true));
//                    escribir.write(persona.getTipoSeguro()+ "," +
//                            persona.getCuit() + "," +
//                            persona.getNombre() + "," +
//                            persona.getTelefono() + "," +
//                            persona.getMail() + "," +
//                            persona.getDominio()+ "," +
//                            persona.getMarcaSelec()+ "," +
//                            persona.getModeloSelec()+ "," +
//                            persona.getAnio()+ "," +
//                            persona.getTerceroCompleto() + "," +
//                            persona.getResponsabilidadCivil()+ "," +
//                            persona.getTodoRiesgoCF()+ "," +
//                            persona.getTodoRiesgoSF()+ "," +
//                            persona.getGranizo()+ "," +
//                            persona.getFranquicia()
//                            
//                    );
//
//                escribir.newLine();
//                escribir.close();
//                    escribirAutomotor.write(persona.getTipoSeguro()+ "," +
//                            persona.getCuit() + "," +
//                            persona.getNombre() + "," +
//                            persona.getTelefono() + "," +
//                            persona.getMail() + "," +
//                            persona.getDominio()+ "," +
//                            persona.getMarcaSelec()+ "," +
//                            persona.getModeloSelec()+ "," +
//                            persona.getAnio()+ "," +
//                            persona.getTerceroCompleto() + "," +
//                            persona.getResponsabilidadCivil()+ "," +
//                            persona.getTodoRiesgoCF()+ "," +
//                            persona.getTodoRiesgoSF()+ "," +
//                            persona.getGranizo()+ "," +
//                            persona.getFranquicia()
//                            
//                    );
//
//                escribirAutomotor.newLine();
//                escribirAutomotor.close();
//                } catch (IOException ex) {
//                    System.out.println(ex);
//                }
//            }
            break;
        }    
    }
//        public void guardarInfo(CambioClientes cambioClientes){    
//            try {
//                BufferedWriter bw = new BufferedWriter(new FileWriter("ArchivoCambio.txt",true));
//                bw.write(
//                        cambioClientes.getUsuario() + "," +
//                        cambioClientes.getId() + "," +
//                        cambioClientes.getNombre() + "," +
//                        cambioClientes.getApellido()
//                );
//                bw.newLine();
//                bw.close();
//            } catch (IOException ex) {
//                System.out.println(ex);
//            }
//        }
    
    
}
