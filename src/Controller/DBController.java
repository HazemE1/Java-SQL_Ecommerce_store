package Controller;

import Model.Discount;
import Model.Product;
import Model.Supplier;
import Model.User;

import java.sql.*;
import java.util.ArrayList;


public class DBController {
    private static String DB_URL = "jdbc:sqlserver://localhost";
    private static String user = "Test";
    private static String password = "test";
    private static Connection connection;

    public DBController(){
    }

    public static Connection connect(){
        connection = null;
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(DB_URL, user, password);
              System.out.println("Connection to database successful.");
        } catch(SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void disconnect() {
        try {
            if(connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch(SQLException e) {
            System.out.println("Failed to disconnect from database.");
        }
    }


    public boolean checkIfAlreadyExists(String userName) {
        return false;
    }

    public boolean isUserCostumer(String userNameLogin, String passwordLogin) {
        return true;
    }
    public boolean isUserAdmin(String userNameLogin, String passwordLogin) {
        return false;
    }

    public boolean createAdminUser(User user) {
        return false;
    }
    public boolean createNormalUser(User user) {
        return false;
    }

    public boolean addDiscount(Discount discount) {
        return true;
    }
    public boolean addSupplier(Supplier supplier) {
        return true;
    }
    public boolean addProduct(Product product) {
        return true;
    }
    public boolean deleteProduct(String productNameToDelete) {
        return true;
    }

    public ArrayList<String> getSuppliers() {
        ArrayList<String> suppliers = new ArrayList<String>();
        return suppliers;
    }
    public ArrayList<String> getProducts() {
        ArrayList<String> products = new ArrayList<String>();
        return products;
    }
    public ArrayList<String> getAllProducts() {
        ArrayList<String> allProducts = new ArrayList<String>();
        return allProducts;
    }
    public ArrayList<String> getUserSearchedProducts(String searchedCode, String searchedSupplier, String searchedProduct) {
        ArrayList<String> searchedProductsUser = new ArrayList<String>();
        return searchedProductsUser;
    }
    public ArrayList<String> getProductsForCustomers() {
        ArrayList<String> ProductsForCustomers = new ArrayList<String>();
        return ProductsForCustomers;
    }
    public ArrayList<String> getOrdersList() {
        ArrayList<String> OrdersList = new ArrayList<String>();
        return OrdersList;
    }
    public ArrayList<String> getDiscounts() {
        ArrayList<String> discounts = new ArrayList<String>();
        return discounts;
    }
    public ArrayList<String> getUsedDiscounts() {
        ArrayList<String> usedDiscounts = new ArrayList<>();
        return usedDiscounts;
    }
    public ArrayList<String> getOrderedProduct(int productID, int nbrOfItems) {
        ArrayList<String> OrderdProduct = new ArrayList<>();
        return OrderdProduct;
    }

    public boolean updateQuantity(int newQuantity, String productNameToUpdate) {
        return true;
    }

    public boolean AddDiscountUnusedPeriod(String startDate, String endDate, String productNameToUpdate, String discountToSetDate) {
        return true;
    }


    public boolean checkQuantity(int nbrOfItems, int productID) {
        return false;
    }



}
