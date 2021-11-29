package controller;

import model.*;
import view.admin.AdminFrames.*;
import view.main.MainFrame;
import view.main.MainPanel;
import view.user.CreateAccountFrame;
import view.user.ShoppingCartFrame;

import java.util.HashSet;
import java.util.Set;

public class Controller {

    private DBController dbController;
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

    private Set<Supplier> suppliers;
    private Set<Product> products;
    private Set<Discount> discounts;
    private Set<Order> orders;
    private Order order;

    private User user;

    public Controller() {
        suppliers = new HashSet<>();
        products = new HashSet<>();
        discounts = new HashSet<>();

        dbController = DBController.getInstance();
        suppliers.addAll(dbController.fetchAllSuppliers());
        products.addAll(dbController.fetchAllProducts());
        orders.addAll(dbController.fetchAllOrders());
        discounts.addAll(dbController.fetchAllDiscounts());

        order = new Order();

        mainFrame = new MainFrame(this);
        mainPanel = new MainPanel(this);
    }


    public void createNormalUser(User regularUser) {
        user = regularUser;
        dbController.createNormalUser(regularUser);
        createAccountFrame.dispose();
    }

    public void loginUser(User user) {
        this.user = user;
        loginUser();
    }

    public void loginUser() {
        if (user.getRole() == Roles.User)
            mainPanel.updateUserView();
        else mainPanel.updateAdminView();
    }

    public void sendSupplierCredentials(String supplierName, String supplierAddress, String supplierPhone) {
        Supplier supplier = new Supplier(supplierName, supplierAddress, supplierPhone);
        dbController.addSupplier(supplier);
        this.suppliers.add(supplier);
    }

    public void sendProductInformation(String productName, int productQuantity, int productPrice, String productSupplier, String pCode) {
        Product product = new Product(productName, productQuantity, productPrice, productSupplier, pCode);
        dbController.addProduct(product);
        this.products.add(product);
        updateView();
    }


    public void sendDiscountInformation(int discountCode, double discountPercentage, String discountReason) {
        Discount discount = new Discount(discountCode, discountPercentage, discountReason);
        dbController.addDiscount(discount);
        this.discounts.add(discount);
    }

    public void sendToDelete(String productNameToDelete) {
        dbController.deleteProduct(productNameToDelete);
    }

    public void sendToUpdateQuantity(int newQuantity, String productNameToUpdate) {
        dbController.updateQuantity(newQuantity, productNameToUpdate);
    }

    public void sendToAddDiscountPeriod(String startDate, String endDate, String productNameToUpdate, String discountToSetDate) {
        dbController.AddDiscountUnusedPeriod(startDate, endDate, productNameToUpdate, discountToSetDate);
    }

    public boolean checkQuantity(int nbrOfItems, int productID) {
        return dbController.checkQuantity(nbrOfItems, productID);
    }

    public void updateProductList() {
        mainPanel.updateProductList();
    }


    public void openCreateAccountWindow() {
        createAccountFrame = new CreateAccountFrame(this, dbController);
    }

    public void openAddSupplierFrame() {
        addSupplierFrame = new AddSupplierFrame(this, dbController);
    }

    public void openAddProductFrame() {
        addProductFrame = new AddProductFrame(this, dbController);
    }

    public void openAddDiscountFrame() {
        addDiscountFrame = new AddDiscountFrame(this, dbController);
    }

    public void openDeleteProductFrame() {
        deleteProductFrame = new DeleteProductFrame(this, dbController);
    }

    public void openHandleProductFrame() {
        handleProductFrame = new HandleProductFrame(this, dbController);
    }

    public void openHandleOrdersFrame() {
        handleOrdersFrame = new HandleOrdersFrame(this, dbController);
    }

    public void openViewUsedDiscountsFrame() {
        viewUsedDiscountsFrame = new ViewUsedDiscountsFrame(this);
    }

    public void openShoppingCart() {
        shoppingCartFrame = new ShoppingCartFrame(this);
    }

    public controller.DBController getDbController() {
        return dbController;
    }

    public void setDbController(controller.DBController dbController) {
        this.dbController = dbController;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(MainPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public CreateAccountFrame getCreateAccountFrame() {
        return createAccountFrame;
    }

    public void setCreateAccountFrame(CreateAccountFrame createAccountFrame) {
        this.createAccountFrame = createAccountFrame;
    }

    public AddDiscountFrame getAddDiscountFrame() {
        return addDiscountFrame;
    }

    public void setAddDiscountFrame(AddDiscountFrame addDiscountFrame) {
        this.addDiscountFrame = addDiscountFrame;
    }

    public AddSupplierFrame getAddSupplierFrame() {
        return addSupplierFrame;
    }

    public void setAddSupplierFrame(AddSupplierFrame addSupplierFrame) {
        this.addSupplierFrame = addSupplierFrame;
    }

    public AddProductFrame getAddProductFrame() {
        return addProductFrame;
    }

    public void setAddProductFrame(AddProductFrame addProductFrame) {
        this.addProductFrame = addProductFrame;
    }

    public DeleteProductFrame getDeleteProductFrame() {
        return deleteProductFrame;
    }

    public void setDeleteProductFrame(DeleteProductFrame deleteProductFrame) {
        this.deleteProductFrame = deleteProductFrame;
    }

    public HandleProductFrame getHandleProductFrame() {
        return handleProductFrame;
    }

    public void setHandleProductFrame(HandleProductFrame handleProductFrame) {
        this.handleProductFrame = handleProductFrame;
    }

    public HandleOrdersFrame getHandleOrdersFrame() {
        return handleOrdersFrame;
    }

    public void setHandleOrdersFrame(HandleOrdersFrame handleOrdersFrame) {
        this.handleOrdersFrame = handleOrdersFrame;
    }

    public ViewUsedDiscountsFrame getViewUsedDiscountsFrame() {
        return viewUsedDiscountsFrame;
    }

    public void setViewUsedDiscountsFrame(ViewUsedDiscountsFrame viewUsedDiscountsFrame) {
        this.viewUsedDiscountsFrame = viewUsedDiscountsFrame;
    }

    public ShoppingCartFrame getShoppingCartFrame() {
        return shoppingCartFrame;
    }

    public void setShoppingCartFrame(ShoppingCartFrame shoppingCartFrame) {
        this.shoppingCartFrame = shoppingCartFrame;
    }

    private void updateView() {
        mainPanel.getPnlStore().get
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Set<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(Set<Discount> discounts) {
        this.discounts = discounts;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Countries[] getCountries() {
        return Countries.values();
    }

}
