package view.main;


import controller.Controller;
import view.admin.AdminMainPanel;
import view.user.UserMainPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private Controller controller;
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


    public void openCreateAccountWindow() {
        controller.openCreateAccountWindow();
    }

    public void openAddSupplierFrame() {
        controller.openAddSupplierFrame();
    }

    public void openAddProductFrame() {
        controller.openAddProductFrame();
    }

    public void openAddDiscountFrame() {
        controller.openAddDiscountFrame();
    }

    public void openDeleteProductFrame() {
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

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public LogInPanel getPnlLogIn() {
        return pnlLogIn;
    }

    public void setPnlLogIn(LogInPanel pnlLogIn) {
        this.pnlLogIn = pnlLogIn;
    }

    public StorePanel getPnlStore() {
        return pnlStore;
    }

    public void setPnlStore(StorePanel pnlStore) {
        this.pnlStore = pnlStore;
    }

    public AdminMainPanel getPnlAdminMain() {
        return pnlAdminMain;
    }

    public void setPnlAdminMain(AdminMainPanel pnlAdminMain) {
        this.pnlAdminMain = pnlAdminMain;
    }

    public UserMainPanel getPnlUserMain() {
        return pnlUserMain;
    }

    public void setPnlUserMain(UserMainPanel pnlUserMain) {
        this.pnlUserMain = pnlUserMain;
    }
}
