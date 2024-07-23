package model;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String correo;
    private String contraseña;
    private String username;
    private String rol;

    // Constructor con parámetros
    public Usuario( String nombre, String correo, String contraseña, String username, String rol) {
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.username = username;
        this.rol = rol;
    }

    // Getters y Setters (métodos para acceder y modificar los campos)
    // Los puedes generar automáticamente en tu IDE o escribirlos manualmente

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
