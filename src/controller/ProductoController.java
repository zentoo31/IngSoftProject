package controller;

import java.util.List;
import model.Producto;
import services.ProductoService;

public class ProductoController {
    private ProductoService productoService;
    
     public ProductoController() {
        this.productoService = new ProductoService();
    }

    public boolean registrarProducto(Producto producto) {
        return productoService.registrarProducto(producto);
    }

    public Producto consultarProducto(int idProducto) {
        return productoService.consultarProducto(idProducto);
    }

    public boolean actualizarProducto(Producto producto, int idProd) {
        return productoService.actualizarProducto(producto,idProd);
    }

    public boolean eliminarProducto(int idProducto) {
        return productoService.eliminarProducto(idProducto);
    }

    public List<Producto> listarProductos() {
        return productoService.listarProductos();
    }
}
