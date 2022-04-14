package domain;

import java.util.List;

public class Pedido {

    private List<Plato> Platos;
    private String clientePedido;
    private String importePedido;

    public Pedido(List<Plato> platos, String clientePedido, String importePedido) {
        Platos = platos;
        this.clientePedido = clientePedido;
        this.importePedido = importePedido;
    }

    public Pedido() {

    }

    public List<Plato> getPlatos() {
        return Platos;
    }

    public void setPlatos(List<Plato> platos) {
        Platos = platos;
    }

    public String getClientePedido() {
        return clientePedido;
    }

    public void setClientePedido(String clientePedido) {
        this.clientePedido = clientePedido;
    }

    public String getImportePedido() {
        return importePedido;
    }

    public void setImportePedido(String importePedido) {
        this.importePedido = importePedido;
    }
}
