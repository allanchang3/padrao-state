package org.example;

public class PedidoEstadoEntregue extends PedidoEstado {
    private static PedidoEstadoEntregue instance = new PedidoEstadoEntregue();

    private PedidoEstadoEntregue() {
    }

    public static PedidoEstadoEntregue getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Entregue";
    }

    public boolean devolver(Pedido pedido) {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        return true;
    }
}