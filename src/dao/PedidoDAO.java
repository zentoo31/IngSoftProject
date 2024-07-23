package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Pedido;

public class PedidoDAO {

    String url = "jdbc:sqlserver://localhost:1433;databaseName=Florinvent;user=sa;password=12345678;encrypt=true;trustServerCertificate=true";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public List<Pedido> obtenerPedidos() {
        List<Pedido> pedidos = new ArrayList<>();
        String query = "EXEC sp_VerPedidosPendientes";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("idPedido"),
                        rs.getString("fecha"),
                        rs.getString("estado"),
                        rs.getDouble("total"),
                        rs.getString("nombreProveedor"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return pedidos;
    }

    public List<Pedido> obtenerLista(int idPedido) {
        List<Pedido> lista = new ArrayList<>();
        String query = "EXEC sp_VerDetallePedido ?";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, idPedido);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Pedido pedido = new Pedido(
                        rs.getInt("idPedido"), 
                        rs.getString("nombreProveedor"), 
                        rs.getString("nombreProducto"), 
                        rs.getDouble("precio"), 
                        String.valueOf(rs.getInt("cantidad")));
                lista.add(pedido);
            }
        } catch (SQLException e) {
            handleSQLException(e);
        }
        return lista;
    }

    private void handleSQLException(SQLException e) {
        e.printStackTrace();
    }
}
