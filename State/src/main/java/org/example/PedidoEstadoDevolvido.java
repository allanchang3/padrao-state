package org.example;

public class PedidoEstadoDevolvido extends PedidoEstado {
    private static PedidoEstadoDevolvido instance = new PedidoEstadoDevolvido();

    private PedidoEstadoDevolvido() {
    }

    public static PedidoEstadoDevolvido getInstance() {
        return instance;
    }

    public String getEstado() {
        return "Devolvido";
    }
}