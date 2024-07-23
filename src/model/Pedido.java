package model;

public class Pedido {

    private int idPedido;
    private String nombreProveedor;
    private double total;
    private String estado;
    private String Fecha;
    private String nombreProducto;

    public Pedido(int idPedido, String Fecha, String estado, double total, String nombreProveedor) {
        this.idPedido = idPedido;
        this.Fecha = Fecha;
        this.estado = estado;
        this.total = total;
        this.nombreProveedor = nombreProveedor;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

}
