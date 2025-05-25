package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {

    Pedido pedido;

    @BeforeEach
    public void setUp() {
        this.pedido = new Pedido();
    }

    @Test
    public void devePagarPedidoRealizado() {
        pedido.setEstado(PedidoEstadoRealizado.getInstance());
        Assertions.assertTrue(pedido.pagar());
        Assertions.assertEquals(PedidoEstadoPago.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoRealizado() {
        pedido.setEstado(PedidoEstadoRealizado.getInstance());
        Assertions.assertTrue(pedido.cancelar());
        Assertions.assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEnviarPedidoRealizado() {
        pedido.setEstado(PedidoEstadoRealizado.getInstance());
        Assertions.assertFalse(pedido.enviar());
    }

    @Test
    public void deveEnviarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        Assertions.assertTrue(pedido.enviar());
        Assertions.assertEquals(PedidoEstadoEnviado.getInstance(), pedido.getEstado());
    }

    @Test
    public void deveCancelarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        Assertions.assertTrue(pedido.cancelar());
        Assertions.assertEquals(PedidoEstadoCancelado.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveEntregarPedidoPago() {
        pedido.setEstado(PedidoEstadoPago.getInstance());
        Assertions.assertFalse(pedido.entregar());
    }

    @Test
    public void deveEntregarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        Assertions.assertTrue(pedido.entregar());
        Assertions.assertEquals(PedidoEstadoEntregue.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveCancelarPedidoEnviado() {
        pedido.setEstado(PedidoEstadoEnviado.getInstance());
        Assertions.assertFalse(pedido.cancelar());
    }

    @Test
    public void deveDevolverPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        Assertions.assertTrue(pedido.devolver());
        Assertions.assertEquals(PedidoEstadoDevolvido.getInstance(), pedido.getEstado());
    }

    @Test
    public void naoDeveCancelarPedidoEntregue() {
        pedido.setEstado(PedidoEstadoEntregue.getInstance());
        Assertions.assertFalse(pedido.cancelar());
    }

    @Test
    public void naoDevePagarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        Assertions.assertFalse(pedido.pagar());
    }

    @Test
    public void naoDeveEnviarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        Assertions.assertFalse(pedido.enviar());
    }

    @Test
    public void naoDeveEntregarPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        Assertions.assertFalse(pedido.entregar());
    }

    @Test
    public void naoDeveDevolverPedidoCancelado() {
        pedido.setEstado(PedidoEstadoCancelado.getInstance());
        Assertions.assertFalse(pedido.devolver());
    }

    @Test
    public void naoDevePagarPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        Assertions.assertFalse(pedido.pagar());
    }

    @Test
    public void naoDeveEnviarPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        Assertions.assertFalse(pedido.enviar());
    }

    @Test
    public void naoDeveEntregarPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        Assertions.assertFalse(pedido.entregar());
    }

    @Test
    public void naoDeveCancelarPedidoDevolvido() {
        pedido.setEstado(PedidoEstadoDevolvido.getInstance());
        Assertions.assertFalse(pedido.cancelar());
    }
}