
package Cambio;


public class CambioClientes {
    String usuario,clienteId,servicioId;
    int idUsuario,tipoMoneda;
    Double cotizacion, cantPesos, impPais,impGcias, cambio;
    
    public CambioClientes(
            String usuario,
            int idUsuario, 
            String clienteId, 
            String servicioId,
            int tipoMoneda,
            Double cotizacion,
            Double cantPesos,
            Double impPais,
            Double impGcias,
            Double cambio
    ){
        this.usuario=usuario;
        this.idUsuario=idUsuario;
        this.clienteId=clienteId;
        this.servicioId=servicioId;
        this.tipoMoneda=tipoMoneda;
        this.cotizacion=cotizacion;
        this.cantPesos=cantPesos;
        this.impPais=impPais;
        this.impGcias=impGcias;
        this.cambio=cambio;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getClienteId() {
        return clienteId;
    }

    public String getServicioId() {
        return servicioId;
    }

    public int getTipoMoneda() {
        return tipoMoneda;
    }

    public Double getCotizacion() {
        return cotizacion;
    }

    public Double getCantPesos() {
        return cantPesos;
    }

    public Double getImpPais() {
        return impPais;
    }

    public Double getImpGcias() {
        return impGcias;
    }

    public Double getCambio() {
        return cambio;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setServicioId(String servicioId) {
        this.servicioId = servicioId;
    }

    public void setTipoMoneda(int tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }

    public void setCotizacion(Double cotizacion) {
        this.cotizacion = cotizacion;
    }

    public void setCantPesos(Double cantPesos) {
        this.cantPesos = cantPesos;
    }

    public void setImpPais(Double impPais) {
        this.impPais = impPais;
    }

    public void setImpGcias(Double impGcias) {
        this.impGcias = impGcias;
    }

    public void setCambio(Double cambio) {
        this.cambio = cambio;
    }
    
}
