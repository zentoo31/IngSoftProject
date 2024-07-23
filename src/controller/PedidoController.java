package controller;

import java.util.List;
import model.Pedido;
import services.PedidoService;

public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController() {
        pedidoService = new PedidoService();
    }

    public List<Pedido> obtenerPedidos() {
        return pedidoService.obtenerPedidos();
    }

    public List<Pedido> obtenerLista(int idPedido) {
        return pedidoService.obtenerLista(idPedido);
    }

}
