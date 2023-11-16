
package Usuarios;


public class Usuarios {
    private String nombre, apellido, userName,contrasenia;
    
    public Usuarios(String nombre, String apellido, String userName, String contrasenia){
        this.nombre= nombre;
        this.apellido=apellido;
        this.userName=userName;
        this.contrasenia=contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUserName() {
        return userName;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}
