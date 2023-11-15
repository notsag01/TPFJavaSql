
package Cambio;


public class CambioClientes {
    String usuario,id,nombre,apellido;
    
    public CambioClientes(
            String usuario,
            String id,
            String nombre,
            String apellido
    ){
        this.usuario=usuario;
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
    }
    public void testigo(){
        System.out.println(
                this.usuario + "," +
                this.id + "," +
                this.nombre + "," +
                this.apellido
        );
    }

    public String getUsuario() {
        return usuario;
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
