
package Prestamos;


public class PrestamoCliente {
    String clienteId,servicioId;
    int usuarioId, capital,meses,interes;
    double cuota,monto;
    
    public PrestamoCliente(
            int usuarioId,
            String clienteId,
            String servicioId,
            int capital,
            int meses,
            int intereses,
            double monto,
            double cuota
    ){
        this.usuarioId=usuarioId;
        this.clienteId=clienteId;
        this.servicioId=servicioId;
        this.capital=capital;
        this.meses=meses;
        this.interes=intereses;
        this.monto=monto;
        this.cuota=cuota;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getServicioId() {
        return servicioId;
    }

    public int getCapital() {
        return capital;
    }

    public int getMeses() {
        return meses;
    }

    public int getInteres() {
        return interes;
    }

    public Double getMonto() {
        return monto;
    }
    
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getCuota() {
        return cuota;
    }
    
    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setServicioId(String servicioId) {
        this.servicioId = servicioId;
    }

    public void setCapital(int capital) {
        this.capital = capital;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public void setInteres(int interes) {
        this.interes = interes;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }
    
}
