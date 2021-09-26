package controller;

import model.*;
import view.admin.AdminFrames.*;
import view.main.MainFrame;
import view.main.MainPanel;
import view.user.CreateAccountFrame;
import view.user.ShoppingCartFrame;

public class Controller {

    private DBController DBController;
    private MainFrame mainFrame;
    private MainPanel mainPanel;
    private CreateAccountFrame createAccountFrame;
    private AddDiscountFrame addDiscountFrame;
    private AddSupplierFrame addSupplierFrame;
    private AddProductFrame addProductFrame;
    private DeleteProductFrame deleteProductFrame;
    private HandleProductFrame handleProductFrame;
    private HandleOrdersFrame handleOrdersFrame;
    private ViewUsedDiscountsFrame viewUsedDiscountsFrame;
    private ShoppingCartFrame shoppingCartFrame;

    private User user;

    public Controller() {
        this.DBController = controller.DBController.getInstance();
        mainFrame = new MainFrame(this);
        mainPanel = new MainPanel(this);
    }


    public void createNormalUser(User regularUser) {
        user = regularUser;
        DBController.createNormalUser(regularUser);
        createAccountFrame.dispose();
    }

    public void loginUser(User user) {
        this.user = user;
        loginUser();
    }

    public void loginUser() {
        mainPanel.updateUserView();
    }

    public void sendSupplierCredentials(String supplierName, String supplierAddress, String supplierPhone) {
        Supplier supplier = new Supplier(supplierName, supplierAddress, supplierPhone);
        DBController.addSupplier(supplier);
    }

    public void sendProductInformation(String productName, int productQuantity, int productPrice, String productSupplier) {
        Product product = new Product(productName, productQuantity, productPrice, productSupplier);
        DBController.addProduct(product);
    }

    public void sendDiscountInformation(int discountCode, double discountPercentage, String discountReason) {
        Discount discount = new Discount(discountCode, discountPercentage, discountReason);
        DBController.addDiscount(discount);
    }

    public void sendToDelete(String productNameToDelete) {
        DBController.deleteProduct(productNameToDelete);
    }

    public void sendToUpdateQuantity(int newQuantity, String productNameToUpdate) {
        DBController.updateQuantity(newQuantity, productNameToUpdate);
    }

    public void sendToAddDiscountPeriod(String startDate, String endDate, String productNameToUpdate, String discountToSetDate) {
        DBController.AddDiscountUnusedPeriod(startDate, endDate, productNameToUpdate, discountToSetDate);
    }

    public boolean checkQuantity(int nbrOfItems, int productID) {
        return DBController.checkQuantity(nbrOfItems, productID);
    }

    public void updateProductList() {
        mainPanel.updateProductList();
    }


    public void openCreateAccountWindow() {
        createAccountFrame = new CreateAccountFrame(this, DBController);
    }

    public void openAddSupplierFrame() {
        addSupplierFrame = new AddSupplierFrame(this, DBController);
    }

    public void openAddProductFrame() {
        addProductFrame = new AddProductFrame(this, DBController);
    }

    public void openAddDiscountFrame() {
        addDiscountFrame = new AddDiscountFrame(this, DBController);
    }

    public void openDeleteProductFrame() {
        deleteProductFrame = new DeleteProductFrame(this, DBController);
    }

    public void openHandleProductFrame() {
        handleProductFrame = new HandleProductFrame(this, DBController);
    }

    public void openHandleOrdersFrame() {
        handleOrdersFrame = new HandleOrdersFrame(this, DBController);
    }

    public void openViewUsedDiscountsFrame() {
        viewUsedDiscountsFrame = new ViewUsedDiscountsFrame(this);
    }

    public void openShoppingCart() {
        shoppingCartFrame = new ShoppingCartFrame(this);
    }

    public Countries[] getCountries() {
        return Countries.values();
    }

}
