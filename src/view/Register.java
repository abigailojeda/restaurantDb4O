package view;

import javax.swing.*;

public class Register extends JFrame {

    private JPanel panel1;
    private JTextField passConfirmRegister;
    private JTextField userPassRegister;
    private JTextField userNameRegister;
    private JButton crearUsuarioButton;

    public Register(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 700);
        setResizable(false);
        setContentPane(panel1);
        setLocationRelativeTo(null);
    }

    public JTextField getPassConfirmRegister() {
        return passConfirmRegister;
    }

    public void setPassConfirmRegister(JTextField passConfirmRegister) {
        this.passConfirmRegister = passConfirmRegister;
    }

    public JTextField getUserPassRegister() {
        return userPassRegister;
    }

    public void setUserPassRegister(JTextField userPassRegister) {
        this.userPassRegister = userPassRegister;
    }

    public JTextField getUserNameRegister() {
        return userNameRegister;
    }

    public void setUserNameRegister(JTextField userNameRegister) {
        this.userNameRegister = userNameRegister;
    }

    public JButton getCrearUsuarioButton() {
        return crearUsuarioButton;
    }

    public void setCrearUsuarioButton(JButton crearUsuarioButton) {
        this.crearUsuarioButton = crearUsuarioButton;
    }
}
