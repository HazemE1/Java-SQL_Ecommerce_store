package View.User;

import Controller.*;
import View.Admin.AdminFrames.AddDiscountPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCartPanel extends JPanel {
    private Controller controller;
    private ShoppingCartFrame shoppingCartFrame;

    private JList<String> listOrderContent;
    private JScrollPane scrollPane;

    private DefaultListModel<String> defaultListModel;

    private JButton btnExit;
    private JButton btnPlaceOrder;
    private JLabel lblPrice;
    private JLabel lblOrder;


    public ShoppingCartPanel(Controller controller, ShoppingCartFrame shoppingCartFrame){
        this.controller = controller;
        this.shoppingCartFrame = shoppingCartFrame;
        initializeComponents();
        initializeGUI();
        registerListeners();
    }

    private void initializeComponents() {
        defaultListModel = new DefaultListModel<>();

        listOrderContent = new JList<>(defaultListModel);
        if(defaultListModel.isEmpty()){
            defaultListModel.addElement("No products added");
        }
        listOrderContent.setSize(new Dimension(400, 300));
        listOrderContent.setPreferredSize(new Dimension(500, 300));
        listOrderContent.setMinimumSize(new Dimension(500, 300));

        scrollPane = new JScrollPane(listOrderContent, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setSize(new Dimension(300, 200));
        scrollPane.setPreferredSize(new Dimension(300, 200));
        scrollPane.setMinimumSize(new Dimension(300, 200));

        lblPrice = new JLabel("Price: ");

        lblOrder = new JLabel("Your order");

        btnExit = new JButton("Exit");
        btnExit.setSize(new Dimension(100, 25));
        btnExit.setPreferredSize(new Dimension(100, 25));
        btnExit.setFont(new Font("Helvetica", Font.PLAIN, 12));
        btnExit.setOpaque(true);
        btnExit.setBorderPainted(false);


        btnPlaceOrder = new JButton("Place Order");
        btnPlaceOrder.setSize(new Dimension(100, 25));
        btnPlaceOrder.setPreferredSize(new Dimension(100, 25));
        btnPlaceOrder.setFont(new Font("Helvetica", Font.PLAIN, 12));
        btnPlaceOrder.setOpaque(true);
        btnPlaceOrder.setBorderPainted(false);
    }

    private void initializeGUI() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(500, 500));
        setMaximumSize(new Dimension(500,500));
        setMinimumSize(new Dimension(500,500));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblOrder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        add(btnPlaceOrder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblPrice, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(lblOrder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(btnExit, gbc);
    }

    private void registerListeners(){
        btnPlaceOrder.addActionListener(new ShoppingCartPanel.btnPlaceOrderListener());
        btnExit.addActionListener(new BtnExitListener());
    }

    private class BtnExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            shoppingCartFrame.dispose();
        }
    }


    public class btnPlaceOrderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(null, "Your order is placed!");
        }
    }
}
