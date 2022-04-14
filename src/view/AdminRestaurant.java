package view;

import javax.swing.*;

public class AdminRestaurant extends JFrame {
    private JPanel panel1;
    private JTable adminPedidos;
    private JButton verDetallesBtn;
    private JButton eliminarPedidoButton;
    private JTable detallePedido;
    private JLabel infoPedidos;

    public AdminRestaurant(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 700);
        setResizable(false);
        setContentPane(panel1);
        setLocationRelativeTo(null);
    }

    public JTable getAdminPedidos() {
        return adminPedidos;
    }

    public void setAdminPedidos(JTable adminPedidos) {
        this.adminPedidos = adminPedidos;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JButton getVerDetallesBtn() {
        return verDetallesBtn;
    }

    public void setVerDetallesBtn(JButton button1) {
        this.verDetallesBtn = button1;
    }

    public JButton getEliminarPedidoButton() {
        return eliminarPedidoButton;
    }

    public void setEliminarPedidoButton(JButton eliminarPedidoButton) {
        this.eliminarPedidoButton = eliminarPedidoButton;
    }

    public JTable getDetallePedido() {
        return detallePedido;
    }

    public void setDetallePedido(JTable detallePedido) {
        this.detallePedido = detallePedido;
    }

    public JLabel getInfoPedidos() {
        return infoPedidos;
    }

    public void setInfoPedidos(JLabel infoPedidos) {
        this.infoPedidos = infoPedidos;
    }
}
