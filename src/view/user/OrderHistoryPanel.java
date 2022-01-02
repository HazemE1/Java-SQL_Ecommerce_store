package view.user;

import controller.Controller;
import model.Order;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderHistoryPanel extends JPanel {
    private Controller controller;
    private OrderHistoryFrame orderHistoryFrame;

    private JList<Order> orderHistoryContent;
    private JScrollPane scrollPane;

    private JButton btnExit;
    private JLabel lblHistory;


    public OrderHistoryPanel(Controller controller, OrderHistoryFrame orderHistoryFrame) {
        this.controller = controller;
        this.orderHistoryFrame = orderHistoryFrame;
        initializeComponents();
        initializeGUI();
        registerListeners();
    }

    private void initializeComponents() {

        orderHistoryContent = new JList(Controller.getInstance().getUser().getOrderHistory().toArray());

        orderHistoryContent.setSize(new Dimension(500, 300));
        orderHistoryContent.setPreferredSize(new Dimension(500, 300));
        orderHistoryContent.setMinimumSize(new Dimension(500, 300));

        scrollPane = new JScrollPane(orderHistoryContent, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setSize(new Dimension(520, 300));
        scrollPane.setPreferredSize(new Dimension(520, 300));
        scrollPane.setMinimumSize(new Dimension(520, 300));

        lblHistory = new JLabel("Order History");


        btnExit = new JButton("Exit");
        btnExit.setSize(new Dimension(100, 25));
        btnExit.setPreferredSize(new Dimension(100, 25));
        btnExit.setFont(new Font("Helvetica", Font.PLAIN, 12));
        btnExit.setOpaque(true);
        btnExit.setBorderPainted(false);

    }

    private void initializeGUI() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(700, 500));
        setMaximumSize(new Dimension(700, 500));
        setMinimumSize(new Dimension(700, 500));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblHistory, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;

        add(scrollPane, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        add(btnExit, gbc);
    }

    private void registerListeners() {
        btnExit.addActionListener(new BtnExitListener());
    }

    private class BtnExitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            orderHistoryFrame.dispose();
        }
    }

}
