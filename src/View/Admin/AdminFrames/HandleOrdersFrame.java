package View.Admin.AdminFrames;

import Controller.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HandleOrdersFrame extends JFrame {
    private Controller controller;
    private DBController dbController;
    private HandleOrdersPanel handleOrdersPanel;

    public HandleOrdersFrame(Controller controller, DBController dbController) {
        this.controller = controller;
        this.dbController = dbController;
        initializeComponents();
        initializeGUI();
    }

    private void initializeComponents() {
        //Default JFrame initializations
        setTitle("Handle product");
        setSize(new Dimension(600,450));
        setMinimumSize(new Dimension(600, 450));
        setPreferredSize(new Dimension(600,450));
        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setBackground(Color.WHITE);
        setLayout(new GridLayout(1,2, 1, 0));

        handleOrdersPanel = new HandleOrdersPanel(controller, this);
    }

    private void initializeGUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(handleOrdersPanel, gbc);

        pack();
        setLocation(new Point(300, 100));
    }

    public ArrayList<String> getOrdersList() {
        return controller.getOrdersList();
    }
}
