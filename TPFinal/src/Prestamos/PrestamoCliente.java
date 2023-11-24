
package Prestamos;


public class PrestamoCliente {
    String usuarioId,clienteId,servicioId;
    int capital,meses,interes,monto;
    
    public PrestamoCliente(
            String usuarioId,
            String clienteId,
            String servicioId,
            int capital,
            int meses,
            int intereses,
            int monto
    ){
        this.usuarioId=usuarioId;
        this.clienteId=clienteId;
        this.servicioId=servicioId;
        this.capital=capital;
        this.meses=meses;
        this.interes=intereses;
        this.monto=monto;
    }
}
