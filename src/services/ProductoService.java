
package services;

import dao.ProductoDAO;
import java.util.List;
import model.Producto;

public class ProductoService {
    private ProductoDAO productoDAO;
    
    public ProductoService() {
        this.productoDAO = new ProductoDAO();
    }

    public boolean registrarProducto(Producto producto) {
        return productoDAO.registrarProducto(producto);
    }

    public Producto consultarProducto(int idProducto) {
        return productoDAO.consultarProducto(idProducto);
    }

    public boolean actualizarProducto(Producto producto, int idProd) {
        return productoDAO.actualizarProducto(producto,idProd);
    }

    public boolean eliminarProducto(int idProducto) {
        return productoDAO.eliminarProducto(idProducto);
    }

    public List<Producto> listarProductos() {
        return productoDAO.listarProductos();
    }
}
