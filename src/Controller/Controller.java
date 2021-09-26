package Controller;

import View.Admin.AdminFrames.*;
import View.Main.MainFrame;
import View.Main.MainPanel;
import Model.*;
import View.User.CreateAccountFrame;
import View.User.ShoppingCartFrame;

import java.util.ArrayList;

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

    public Controller(DBController DBController){
        this.DBController=DBController;
        mainFrame = new MainFrame(this, DBController);
        mainPanel = new MainPanel(this);
    }



    public ArrayList<String> getProductsForCustomers() {
        return DBController.getProductsForCustomers();
    }
    public ArrayList<String> getSearchedProducts(String searchedCode, String searchedSupplier, String searchedProduct) {
        return DBController.getUserSearchedProducts(searchedCode, searchedSupplier, searchedProduct);
    }
    public ArrayList<String> getAllProducts() {
        return DBController.getAllProducts();
    }
    public ArrayList<String> getProducts() {
        return DBController.getProducts();
    }
    public ArrayList<String> getOrdersList() {
        return DBController.getOrdersList();
    }
    public ArrayList<String> getDiscounts() {
        return DBController.getDiscounts();
    }
    public ArrayList<String> getUsedDiscounts() {
        return DBController.getUsedDiscounts();
    }
    public ArrayList<String> getSuppliers() {
        return DBController.getSuppliers();
    }
    public ArrayList<String> getOrderedProduct(int productID, int nbrOfItems) {
        return DBController.getOrderedProduct(productID, nbrOfItems);
    }
    public Countries[] getCountries() {
        return Countries.values();
    }

    public boolean createAdminUser(User admin, String adminPassword) {
        DBController.createAdminUser(user);
        createAccountFrame.dispose();
        return true;
    }
    public boolean createNormalUser(User regularUser) {
        if(DBController.createNormalUser(user)) {
            createAccountFrame.dispose();
            return true;
        }
        return false;
    }

    public boolean isUserCostumer(String userNameLogin, String passwordLogin) {
        DBController.isUserCostumer(userNameLogin, passwordLogin);
        return DBController.isUserCostumer(userNameLogin, passwordLogin);
    }
    public boolean isUserAdmin(String userNameLogin, String passwordLogin) {
        DBController.isUserAdmin(userNameLogin, passwordLogin);
        return DBController.isUserAdmin(userNameLogin, passwordLogin);
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

    public void sendSupplierCredentials(String supplierName, String supplierAddress, String supplierPhone) {
        Supplier supplier = new Supplier(supplierName, supplierAddress, supplierPhone, DBController);
        DBController.addSupplier(supplier);
    }
    public void sendProductInformation(String productName, int productQuantity, int productPrice, String productSupplier) {
        Product product = new Product(productName, productQuantity, productPrice, productSupplier, DBController);
        DBController.addProduct(product);
    }
    public void sendDiscountInformation(int discountCode, double discountPercentage, String discountReason) {
        Discount discount = new Discount(discountCode, discountPercentage, discountReason, DBController);
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
}
