package services;

import dao.PedidoDAO;
import java.util.List;
import model.Pedido;

public class PedidoService {

    private PedidoDAO pedidoDAO;

    public PedidoService() {
        pedidoDAO = new PedidoDAO();
    }

    public List<Pedido> obtenerPedidos() {
        return pedidoDAO.obtenerPedidos();
    }

    public List<Pedido> obtenerLista(int idPedido) {
        return pedidoDAO.obtenerLista(idPedido);
    }

}
