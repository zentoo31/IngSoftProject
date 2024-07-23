package model;

public class Producto {
    private int idProducto;
    private String nombre;
    private double precio;
    private int cantidad;
    private String descripcion;
    private String almacen;

    public Producto() {
    }

    public Producto(int idProducto, String nombre, double precio, int cantidad, String descripcion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.almacen = almacen;
    }
    
    public String getIdAlmacen() {
        return almacen;
    }

    public void setIdAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
