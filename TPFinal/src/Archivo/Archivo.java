package Archivo;



import Cambio.CambioClientes;
import Seguros.Personas;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Archivo {
    
    
    public void crearArchivo(){
    
    }
    
    public void escribirArchivo(Personas persona){
        switch(persona.getTipoSeguro()){
            case "Seguro Hogar":
            try {
                BufferedWriter escribir = new BufferedWriter(new FileWriter("seguros.txt",true));
                BufferedWriter escribirHogar = new BufferedWriter(new FileWriter("segurosHogar.txt",true));
                escribir.write(persona.getTipoSeguro() + "," +
                                persona.getCuit() + "," +
                                persona.getNombre() + "," +
                                persona.getTelefono() + "," +
                                persona.getMail()+ "," +
                                persona.getIncendio() + "," +
                                persona.getRobo() + "," +
                                persona.getInundacion() + "," +
                                persona.getHeladera()+ "," +
                                persona.getLavarropas()+ "," +
                                persona.getCocina()+ "," +
                                persona.getNotebook()+ "," +
                                persona.getNotebookCantidad()+ "," +
                                persona.getConsola()+ "," +
                                persona.getTelevisor()+ "," +
                                persona.getTelevisorCantidad()
                );

                escribir.newLine();
                escribir.close();
                escribirHogar.write(persona.getTipoSeguro() + "," +
                                persona.getCuit() + "," +
                                persona.getNombre() + "," +
                                persona.getTelefono() + "," +
                                persona.getMail()+ "," +
                                persona.getIncendio() + "," +
                                persona.getRobo() + "," +
                                persona.getInundacion() + "," +
                                persona.getHeladera()+ "," +
                                persona.getLavarropas()+ "," +
                                persona.getCocina()+ "," +
                                persona.getNotebook()+ "," +
                                persona.getNotebookCantidad()+ "," +
                                persona.getConsola()+ "," +
                                persona.getTelevisor()+ "," +
                                persona.getTelevisorCantidad()
                );

                escribirHogar.newLine();
                escribirHogar.close();

            } catch (IOException ex) {
                System.out.println(ex);
            }
            break;
            case "Seguro Vida":
            {
                try {
                    BufferedWriter escribir = new BufferedWriter(new FileWriter("seguros.txt",true));
                    BufferedWriter escribirVida = new BufferedWriter(new FileWriter("segurosVida.txt",true));
                    escribir.write(persona.getTipoSeguro()+ "," +
                            persona.getCuit() + "," +
                            persona.getNombre() + "," +
                            persona.getTelefono() + "," +
                            persona.getMail() + "," +
                            persona.getMuerte() + "," +
                            persona.getMuerteAccidental() + "," +
                            persona.getInternacion()+ "," +
                            persona.getInternacionDias()+ "," +
                            persona.getParalisis()+ "," +
                            persona.getBeneficiario1()+ "," +
                            persona.getBeneficiario1_parentesco()+ "," +
                            persona.getBeneficiario2()+ "," +
                            persona.getBeneficiario2_parentesco()+ "," +
                            persona.getBeneficiario3()+ "," +
                            persona.getBeneficiario3_parentesco()+ "," +
                            persona.getBeneficiario4()+ "," +
                            persona.getBeneficiario4_parentesco()
                    );

                escribir.newLine();
                escribir.close();
                    escribirVida.write(persona.getTipoSeguro()+ "," +
                            persona.getCuit() + "," +
                            persona.getNombre() + "," +
                            persona.getTelefono() + "," +
                            persona.getMail() + "," +
                            persona.getMuerte() + "," +
                            persona.getMuerteAccidental() + "," +
                            persona.getInternacion()+ "," +
                            persona.getInternacionDias()+ "," +
                            persona.getParalisis()+ "," +
                            persona.getBeneficiario1()+ "," +
                            persona.getBeneficiario1_parentesco()+ "," +
                            persona.getBeneficiario2()+ "," +
                            persona.getBeneficiario2_parentesco()+ "," +
                            persona.getBeneficiario3()+ "," +
                            persona.getBeneficiario3_parentesco()+ "," +
                            persona.getBeneficiario4()+ "," +
                            persona.getBeneficiario4_parentesco()
                    );

                escribirVida.newLine();
                escribirVida.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            break;
            case "Seguro Automotor":
            {
                try {
                    BufferedWriter escribir = new BufferedWriter(new FileWriter("seguros.txt",true));
                    BufferedWriter escribirAutomotor = new BufferedWriter(new FileWriter("segurosAutomotor.txt",true));
                    escribir.write(persona.getTipoSeguro()+ "," +
                            persona.getCuit() + "," +
                            persona.getNombre() + "," +
                            persona.getTelefono() + "," +
                            persona.getMail() + "," +
                            persona.getDominio()+ "," +
                            persona.getMarcaSelec()+ "," +
                            persona.getModeloSelec()+ "," +
                            persona.getAnio()+ "," +
                            persona.getTerceroCompleto() + "," +
                            persona.getResponsabilidadCivil()+ "," +
                            persona.getTodoRiesgoCF()+ "," +
                            persona.getTodoRiesgoSF()+ "," +
                            persona.getGranizo()+ "," +
                            persona.getFranquicia()
                            
                    );

                escribir.newLine();
                escribir.close();
                    escribirAutomotor.write(persona.getTipoSeguro()+ "," +
                            persona.getCuit() + "," +
                            persona.getNombre() + "," +
                            persona.getTelefono() + "," +
                            persona.getMail() + "," +
                            persona.getDominio()+ "," +
                            persona.getMarcaSelec()+ "," +
                            persona.getModeloSelec()+ "," +
                            persona.getAnio()+ "," +
                            persona.getTerceroCompleto() + "," +
                            persona.getResponsabilidadCivil()+ "," +
                            persona.getTodoRiesgoCF()+ "," +
                            persona.getTodoRiesgoSF()+ "," +
                            persona.getGranizo()+ "," +
                            persona.getFranquicia()
                            
                    );

                escribirAutomotor.newLine();
                escribirAutomotor.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            }
            break;
        }    
    }
        public void guardarInfo(CambioClientes cambioClientes){    
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("ArchivoCambio.txt",true));
                bw.write(
                        cambioClientes.getUsuario() + "," +
                        cambioClientes.getId() + "," +
                        cambioClientes.getNombre() + "," +
                        cambioClientes.getApellido()
                );
                bw.newLine();
                bw.close();
            } catch (IOException ex) {
                System.out.println(ex);
            }
        }
    
    
}
