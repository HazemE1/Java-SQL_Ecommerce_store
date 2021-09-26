package View.User;


import View.Main.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UserMainPanel extends JPanel {
    private MainPanel mainPanel;
    private UserOptionsPanel optionsPanel;
    private UserStorePanel userStorePanel;

    public UserMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
        initializeComponents();
        initializeGUI();
    }

    private void initializeComponents() {
        this.optionsPanel = new UserOptionsPanel(this);
        this.userStorePanel = new UserStorePanel(this);
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
        add(userStorePanel, gbc);
    }

    public ArrayList<String> getAllProducts() {
        return mainPanel.getAllProducts();
    }

    public ArrayList<String> getSearchedProducts(String searchedCode, String searchedSupplier, String searchedProduct) {
        return mainPanel.getSearchedProducts(searchedCode, searchedSupplier, searchedProduct);
    }

    public ArrayList<String> getProductsForCustomers() {
        return mainPanel.getProductsForCustomers();
    }

    public void openShoppingCart() {
        mainPanel.openShoppingcart();
    }

    public boolean checkQuantity(int nbrOfItems, int productID) {
        return mainPanel.checkQuantity(nbrOfItems, productID);
    }

    public void updateShoppingCartBtn(int productsAdded) {
        optionsPanel.updateShoppingCartBtn(productsAdded);
    }

    public void getOrderedProducts(int productID, int nbrOfItems) {
        mainPanel.getOrderedProducts(productID,nbrOfItems);
    }
}
