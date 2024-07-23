package model;

public class GestUbicacion {
    private String nombre;
    private String nombreAlmacen;
    private String fechaRegistro;

    public GestUbicacion(String nombre, String nombreAlmacen) {
        this.nombre = nombre;
        this.nombreAlmacen = nombreAlmacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }

    public void setNombreAlmacen(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}
