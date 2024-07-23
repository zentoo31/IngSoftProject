package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Producto;

public class ProductoDAO {

    String url = "jdbc:sqlserver://localhost:1433;databaseName=Florinvent;user=sa;password=12345678;encrypt=true;trustServerCertificate=true";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public boolean registrarProducto(Producto producto) {
        String query = "INSERT INTO Producto (idProducto, nombre, precio,descripcion, cantidad) VALUES (?, ?, ?, ?,?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, producto.getIdProducto());
            stmt.setString(2, producto.getNombre());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setString(4, producto.getDescripcion());
            stmt.setInt(5, producto.getCantidad());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    public Producto consultarProducto(int idProducto) {
        String query = "SELECT p.idProducto, p.nombre, p.precio,p.descripcion, p.cantidad, a.nombre AS nombreAlmacen FROM  Producto p JOIN Almacen a ON p.idAlmacen = a.idAlmacen WHERE idProducto = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idProducto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Producto producto = new Producto(
                            rs.getInt("idProducto"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getInt("cantidad"),
                            rs.getString("descripcion")
                    );
                    producto.setIdAlmacen(rs.getString("nombreAlmacen"));
                    return producto;

                }
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return null;
    }

    public boolean actualizarProducto(Producto producto, int idProd) {
        String query = "UPDATE Producto SET idProducto = ?, nombre = ?, precio = ?, descripcion = ?, cantidad = ? WHERE idProducto = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idProd);
            stmt.setString(2, producto.getNombre());
            stmt.setDouble(3, producto.getPrecio());
            stmt.setString(4, producto.getDescripcion());
            stmt.setInt(5, producto.getCantidad());
            stmt.setInt(6, producto.getIdProducto());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    public boolean eliminarProducto(int idProducto) {
        String query = "DELETE FROM Producto WHERE idProducto = ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idProducto);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            handleSQLException(e);
            return false;
        }
    }

    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        String query = "SELECT p.idProducto, p.nombre, p.precio, p.descripcion, p.cantidad, ISNULL(a.nombre, 'Sin almacen') AS nombreAlmacen FROM Producto p LEFT JOIN Almacen a ON p.idAlmacen = a.idAlmacen";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Producto producto = new Producto(
                        rs.getInt("idProducto"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getInt("cantidad"),
                        rs.getString("descripcion")
                );
                producto.setIdAlmacen(rs.getString("nombreAlmacen"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return productos;
    }

    private void handleSQLException(SQLException e) {
        e.printStackTrace();
    }
}
