package view;

import javax.swing.*;

public class ClientRestaurant extends JFrame {

    private JPanel panel1;
    private JTable pedidosTable;
    private JButton ensalada1;
    private JButton ensalada2;
    private JButton deletePlato;
    private JLabel userLabel;
    private JLabel totalPrice;
    private JButton generarPedidoButton;
    private JButton ensalada3;

    public ClientRestaurant(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 700);
        setResizable(false);
        setContentPane(panel1);
        setLocationRelativeTo(null);
    }

    public JTable getPedidosTable() {
        return pedidosTable;
    }

    public void setPedidosTable(JTable pedidosTable) {
        this.pedidosTable = pedidosTable;
    }

    public JLabel getUserLabel() {
        return userLabel;
    }

    public void setUserLabel(JLabel userLabel) {
        this.userLabel = userLabel;
    }

    public JButton getEnsalada1() {
        return ensalada1;
    }

    public void setEnsalada1(JButton ensalada1) {
        this.ensalada1 = ensalada1;
    }

    public JButton getEnsalada2() {
        return ensalada2;
    }

    public void setEnsalada2(JButton ensalada2) {
        this.ensalada2 = ensalada2;
    }

    public JButton getDeletePlato() {
        return deletePlato;
    }

    public void setDeletePlato(JButton savePlato) {
        this.deletePlato = savePlato;
    }

    public JLabel getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(JLabel totalPrice) {
        this.totalPrice = totalPrice;
    }

    public JButton getGenerarPedidoButton() {
        return generarPedidoButton;
    }

    public void setGenerarPedidoButton(JButton generarPedidoButton) {
        this.generarPedidoButton = generarPedidoButton;
    }

    public JButton getEnsalada3() {
        return ensalada3;
    }

    public void setEnsalada3(JButton ensalada3) {
        this.ensalada3 = ensalada3;
    }


}
