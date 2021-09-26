package View.Main;


import Controller.Controller;
import View.Admin.AdminMainPanel;
import View.User.UserMainPanel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {

    private static Controller controller;
    private LogInPanel pnlLogIn;
    private StorePanel pnlStore;
    private AdminMainPanel pnlAdminMain;
    private UserMainPanel pnlUserMain;

    public MainPanel(Controller controller) {
        this.controller = controller;
        initializeComponents();
        initializeGUI();
    }

    private void initializeComponents() {
        pnlLogIn = new LogInPanel(this);
        pnlStore = new StorePanel(this);
        pnlAdminMain = new AdminMainPanel(this);
        pnlUserMain = new UserMainPanel(this);
    }

    private void initializeGUI() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(600, 600));
        setMaximumSize(new Dimension(600, 600));
        setMinimumSize(new Dimension(600, 600));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(pnlLogIn, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(pnlStore, gbc);
    }

    public void updateAdminView() {
        remove(pnlLogIn);
        remove(pnlStore);

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(600, 600));
        setMaximumSize(new Dimension(600, 600));
        setMinimumSize(new Dimension(600, 600));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(pnlAdminMain, gbc);

        revalidate();
        repaint();
    }

    public void updateUserView() {
        remove(pnlLogIn);
        remove(pnlStore);

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(600, 600));
        setMaximumSize(new Dimension(600, 600));
        setMinimumSize(new Dimension(600, 600));

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(pnlUserMain, gbc);

        revalidate();
        repaint();
    }

    public ArrayList<String> getProducts() {
        return controller.getProducts();
    }

    public ArrayList<String> getSearchedProducts(String searchedCode, String searchedSupplier, String searchedProduct) {
        return controller.getSearchedProducts(searchedCode, searchedSupplier, searchedProduct);
    }

    public ArrayList<String> getAllProducts() {
        return controller.getAllProducts();
    }

    public ArrayList<String> getProductsForCustomers() {
        return controller.getProductsForCustomers();
    }

    public void openCreateAccountWindow() {
        controller.openCreateAccountWindow();
    }

    public boolean isUserCostumer(String userNameLogin, String passwordLogin) {
        controller.isUserCostumer(userNameLogin, passwordLogin);
        return controller.isUserCostumer(userNameLogin, passwordLogin);
    }

    public boolean isUserAdmin(String userNameLogin, String passwordLogin) {
        controller.isUserAdmin(userNameLogin, passwordLogin);
        return controller.isUserAdmin(userNameLogin, passwordLogin);
    }

    public static void openAddSupplierFrame() {
        controller.openAddSupplierFrame();
    }
    public static void openAddProductFrame() {
        controller.openAddProductFrame();
    }
    public static void openAddDiscountFrame() {
        controller.openAddDiscountFrame();
    }
    public static void openDeleteProductFrame() {
        controller.openDeleteProductFrame();
    }
    public void openHandleProductFrame() {
        controller.openHandleProductFrame();
    }
    public void openHandleOrdersFrame() {
        controller.openHandleOrdersFrame();
    }
    public void openViewUsedDiscountsFrame() {
        controller.openViewUsedDiscountsFrame();
    }
    public void updateProductList() {
        pnlAdminMain.updateProductList();
    }
    public void openShoppingcart() {
        controller.openShoppingCart();
    }

    public boolean checkQuantity(int nbrOfItems, int productID) {
        return controller.checkQuantity(nbrOfItems, productID);
    }

    public void getOrderedProducts(int productID, int nbrOfItems) {
        controller.getOrderedProduct(productID, nbrOfItems);
    }
}
