package org.example;

public class PedidoEstadoRealizado extends PedidoEstado {
    private static PedidoEstadoRealizado instance = new PedidoEstadoRealizado();

    private PedidoEstadoRealizado() {
    }

    public static PedidoEstadoRealizado getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Realizado";
    }

    public boolean pagar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        return true;
    }

    public boolean cancelar(Pedido pedido) {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        return true;
    }
}