package org.example;

public class Pedido {
    private String descricao;
    private PedidoEstado estado = PedidoEstadoRealizado.getInstance();

    public Pedido() {
    }

    public void setEstado(PedidoEstado estado) {
        this.estado = estado;
    }

    public boolean pagar() {
        return this.estado.pagar(this);
    }

    public boolean enviar() {
        return this.estado.enviar(this);
    }

    public boolean entregar() {
        return this.estado.entregar(this);
    }

    public boolean cancelar() {
        return this.estado.cancelar(this);
    }

    public boolean devolver() {
        return this.estado.devolver(this);
    }

    public String getNomeEstado() {
        return this.estado.getEstado();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PedidoEstado getEstado() {
        return estado;
    }
}
