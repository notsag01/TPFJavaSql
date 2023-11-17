
package Clientes;


public class Clientes {
    private String id,nombre,apellido,fechaNacimiento,genero,cuil,domicilio,localidad,provincia,estadoCivil,hijos,mail;
    
    Clientes(){};
    
    public Clientes(
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
            String mail){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.fechaNacimiento=fechaNacimiento;
        this.genero=genero;
        this.cuil=cuil;
        this.domicilio=domicilio;
        this.localidad=localidad;
        this.provincia=provincia;
        this.estadoCivil=estadoCivil;
        this.hijos=hijos;
        this.mail=mail;
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

    public String getMail() {
        return mail;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }
    
    public String getDomicilio() {
        return domicilio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public String getHijos() {
        return hijos;
    }

    public String getCuil() {
        return cuil;
    }
    
}
