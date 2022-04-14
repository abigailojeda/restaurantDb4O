package view;

import com.db4o.ObjectContainer;
import com.db4o.query.Predicate;
import data.DataConnection;
import domain.Cliente;
import domain.Pedido;
import domain.Plato;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Home extends JFrame {
    private static ObjectContainer db = DataConnection.getInstance();
    private JPanel panel1;
    private JButton entrarbtn;
    private JTextField user;
    private JTextField pass;
    private JButton registerbtn;
    private String nombrePlato ="";
    Object  [] [] data = {};
    AdminRestaurant admin;
    ClientRestaurant client;
    DefaultTableModel ml;
    DefaultTableModel ml2;
    public double cantidad;



    public Home() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 700);
        setResizable(false);
        setContentPane(panel1);
        setLocationRelativeTo(null);

        //btn
        entrarbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        registerbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });

    }

//*******iniciar con un usuario y admin por defecto**********************************************************************************************/
    public static void main(String[] args) {
        Home home = new Home();
        home.setVisible(true);

        Cliente p = new Cliente("admin", "admin", true);
        Cliente p2 = new Cliente("user", "user", false);
        db.store(p);
        db.store(p2);
    }
    //register****************************************************************************************************************************************************/
    public void register(){

        Register registerView = new Register();
        registerView.setVisible(true);


        registerView.getCrearUsuarioButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                var user = "";
                var password= "";
                var checkPassword = "";
                user = registerView.getUserNameRegister().getText();
                password = registerView.getUserPassRegister().getText();
                checkPassword = registerView.getPassConfirmRegister().getText();

                if(!user.equals("") && !password.equals("")){

                    if(checkPassword.equals(password)){
                        Cliente cliente = new Cliente(user,password , false);
                        db.store(cliente);
                        Component contentPane = null;
                        JOptionPane.showMessageDialog(contentPane,"Usuario: " + user + " Contraseña: " + password);
                        registerView.dispose();
                    }else{
                        Component contentPane = null;
                        JOptionPane.showMessageDialog(contentPane,"Los datos deben ser correctos");
                        System.out.println(user+"/"+password +"/"+checkPassword);
                    }

                }else{
                    Component contentPane = null;
                    JOptionPane.showMessageDialog(contentPane,"Los datos deben ser correctos");
                    System.out.println("nothing");
                }


            }
        });
    }

//login*********************************************************************/
      public void login(){
        List<Cliente> personas = db.query(new Predicate<Cliente>() {
            public boolean match(Cliente o) {
                return o.getNombre().equals(user.getText()) && o.getPassword().equals(new String(pass.getText()));
            }
        });

        if(personas.size()>0){
            if(personas.get(0).isAdmin()){
                //admin
                 admin = new AdminRestaurant();
                 admin.setVisible(true);
                 admin.getAdminPedidos().setModel(new DefaultTableModel(data,new String []{"Cliente", "Importe pedido" }));
                admin.getDetallePedido().setModel(new DefaultTableModel(data,new String []{"Plato", "Precio" }));
                System.out.println("admin");
  //mostrar los pedidos guardados en la bbdd en la vista del administrador*****************************************************************************************************************/
        List<Pedido> pedidosBbdd = db.query(new Predicate<Pedido>() {
            @Override
            public boolean match(Pedido pedido) {
                return true;
            }
        });
                ml = (DefaultTableModel)admin.getAdminPedidos().getModel();

                for(Pedido pedido : pedidosBbdd ){
                    ml.addRow(new Object[]{pedido.getClientePedido(),pedido.getImportePedido()});
                }

                if(ml.getRowCount() > 0){
                   admin.getInfoPedidos().setText("¡Hay "+ ml.getRowCount()+ " pedidos pendientes!");
                }else{
                    admin.getInfoPedidos().setText("Aún no hay pedidos");
                }
   //ver detalles pedido********************************************************************************************************************************************************************/
                admin.getVerDetallesBtn().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int fila = admin.getAdminPedidos().getSelectedRow();
                        ml2 = (DefaultTableModel)admin.getDetallePedido().getModel();

                        Pedido pedido2 = pedidosBbdd.get(fila);
                        ml2.setRowCount(0);
                        for(Plato plato: pedido2.getPlatos()){
                            ml2.addRow(new Object[]{plato.getNombrePlato(),plato.getPrecioPlato()});
                           // System.out.println(plato.getNombrePlato() + ", " + plato.getPrecioPlato() + " €");
                        }

                    }
                });
    //eliminar pedido***********************************************************************************************************************************************************************/
                admin.getEliminarPedidoButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int fila = admin.getAdminPedidos().getSelectedRow();
                        db.delete(pedidosBbdd.get(fila));
                        ml.removeRow(fila);
                        if(ml.getRowCount() > 0){
                            admin.getInfoPedidos().setText("¡Hay "+ ml.getRowCount()+ " pedidos pendientes!");
                        }else{
                            admin.getInfoPedidos().setText("Aún no hay pedidos");
                        }
                    }
                });


            }else{
  //iniciar vista usuario y añadir platos***************************************************************************************************************************************************/

                client = new ClientRestaurant();
               client.setVisible(true);
               client.getPedidosTable().setModel(new DefaultTableModel(data,new String []{"Plato", "Precio" }));
               System.out.println("user");
               client.getUserLabel().setText("¡Hola " + personas.get(0).getNombre() + "!");
                ml = (DefaultTableModel)client.getPedidosTable().getModel();
                ml.setRowCount(0);

                //platos
                client.getEnsalada1().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nombrePlato="ensalada1";
                        ml.addRow(new Object[]{nombrePlato,"6.8"});
                        addPrice( 6.8);
                    }

                });
                client.getEnsalada2().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nombrePlato="ensalada2";

                        ml.addRow(new Object[]{nombrePlato,"5.3"});
                        addPrice( 5.3);
                    }
                });
                client.getEnsalada3().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        nombrePlato="ensalada3";

                        ml.addRow(new Object[]{nombrePlato, "7.2"});
                        addPrice( 7.2);
                    }
                });
      //eliminar plato*****************************************************************************************************************************/
                client.getDeletePlato().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int fila = client.getPedidosTable().getSelectedRow();
                        String str =client.getPedidosTable().getValueAt(fila,1).toString().substring(0,3);
                        deletePrice(Double.parseDouble(str));
                        ml.removeRow(fila);
                    }
                });
      //generar pedido*****************************************************************************************************************************/
                client.getGenerarPedidoButton().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //generar nuevo pedido:
                        Pedido pedido = new Pedido();
                        ArrayList<Plato> platos = new ArrayList<Plato>();
                        //guardar todos los platos en List "platos" de Pedido:
                        for(int i = 0; i < ml.getRowCount(); i++){
                            Plato plato = new Plato();
                            plato.setNombrePlato((String) ml.getValueAt(i, 0));
                            String precio = ((String)ml.getValueAt(i, 1));
                            plato.setPrecioPlato(Double.parseDouble(precio));
                            platos.add(plato);
                        }
                        pedido.setPlatos(platos);
                        //guardar el importe total:
                        pedido.setImportePedido(client.getTotalPrice().getText());
                        //guardar usuario del pedido:
                        pedido.setClientePedido(String.valueOf(personas.get(0).getNombre()));
                        //guardar en la bbdd:
                        db.store(pedido);

                        System.out.println("importe total:"+pedido.getImportePedido());
                        System.out.println("usuario: " + pedido.getClientePedido());

                        for(Plato plato: pedido.getPlatos()){
                            System.out.println(plato.getNombrePlato() + ", " + plato.getPrecioPlato() + " €");
                        }
                        Component contentPane = null;
                        JOptionPane.showMessageDialog(contentPane,"¡" + personas.get(0).getNombre() +", gracias por su pedido!:\n En breve llegará a su mesa");
                        client.dispose();

                    }
                });
            }
        }else{
            Component contentPane = null;
            JOptionPane.showMessageDialog(contentPane,"Login incorrecto");
            System.out.println("nobody");
        }
    }


    //cambiar precio total platos******************************************************************************************************************************/

    public double a;
    public double b;
    public void addPrice(double cantidad){
        if(client.getTotalPrice().getText() == "0.00"){
            client.getTotalPrice().setText(String.valueOf(cantidad));
        }else{
            a= Double.parseDouble(String.valueOf(client.getTotalPrice().getText())) + cantidad;
           double c =Math.round(a * 100) / 100d;
           // System.out.println(a + "/" + cantidad + "/" +c);
           // System.out.println( (String.valueOf(client.getTotalPrice().getText().substring(0,3))));
            client.getTotalPrice().setText(String.valueOf(c));
        }

    }
    public void deletePrice(double cantidad){
       // System.out.println("cantidad para restar: " + cantidad);
        b= Double.parseDouble(String.valueOf(client.getTotalPrice().getText())) - cantidad;
        double d =Math.round(b * 100) / 100d;
        //System.out.println( (String.valueOf(client.getTotalPrice().getText().substring(0,3))));
        client.getTotalPrice().setText(String.valueOf(d));
    }



}
