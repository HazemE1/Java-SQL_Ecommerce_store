package View.Admin;

import View.Main.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AdminMainPanel extends JPanel {
    private final MainPanel mainPanel;
    private OptionsPanel optionsPanel;
    private AdminStorePanel adminStorePanel;

    public AdminMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;

        initializeComponents();
        initializeGUI();
    }

    private void initializeComponents() {
        this.optionsPanel = new OptionsPanel(this);
        this.adminStorePanel = new AdminStorePanel(this);
    }

    private void initializeGUI() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(600, 600));
        setMaximumSize(new Dimension(600, 600));
        setMinimumSize(new Dimension(600, 600));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridy = 0;
        gbc.gridx = 0;
        add(optionsPanel, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        add(adminStorePanel, gbc);
    }

    public void openAddSupplierFrame() {
        MainPanel.openAddSupplierFrame();
    }
    public void openAddProductFrame() {
        MainPanel.openAddProductFrame();
    }
    public void openAddDiscountFrame() {
        MainPanel.openAddDiscountFrame();
    }
    public void openDeleteProductFrame() {
        MainPanel.openDeleteProductFrame();
    }
    public void openHandleProductFrame() {
        mainPanel.openHandleProductFrame();
    }
    public void openHandleOrdersFrame() {
        mainPanel.openHandleOrdersFrame();
    }
    public void openViewUsedDiscountsFrame() {
        mainPanel.openViewUsedDiscountsFrame();
    }

    public void updateProductList() {
        adminStorePanel.updateProductList();
    }

    public ArrayList<String> getAllProducts(){
        return mainPanel.getAllProducts();
    }
}