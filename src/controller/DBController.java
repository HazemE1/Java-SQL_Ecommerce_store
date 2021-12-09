package controller;

import model.*;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;


public class DBController {
    private static DBController instance;
    private static String DB_URL = "jdbc:sqlserver://localhost;databaseName=Store";
    private static String user = "root";
    private static String password = "";
    private static Connection connection;

    public DBController() {
        connect();


    }

    public Set<Order> fetchAllOrders() {
        Set<Order> val = new HashSet<>();
        ResultSet set = executeQuery("SELECT * FROM orders;");
        try {
            while (set.next()) {
                val.add(new Order(
                        set.getString("orderId"),
                        set.getString("orderContent"),
                        OrderStatus.valueOf(set.getString("confirmation")),
                        set.getString("username")

                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return val;
    }

    public Set<Product> fetchAllProducts() {
        Set<Product> val = new HashSet<>();
        ResultSet set = executeQuery("SELECT * FROM products;");
        try {
            while (set.next()) {
                val.add(
                        new Product(
                                set.getString("pName"),
                                set.getInt("stockTotal"),
                                set.getInt("basePrice"),
                                set.getString("supplier"),
                                set.getString("pCode")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return val;
    }

    public Set<Supplier> fetchAllSuppliers() {
        Set<Supplier> val = new HashSet<>();
        ResultSet set = executeQuery("SELECT * FROM suppliers;");
        try {
            while (set.next()) {
                val.add(new Supplier(set.getString("name"), set.getString("address"), set.getString("tel")));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return val;
    }

    public Set<Discount> fetchAllDiscounts() {
        Set<Discount> val = new HashSet<>();
        ResultSet set = executeQuery("SELECT * FROM discount;");
        try {
            while (set.next()) {
                val.add(new Discount(
                        set.getString("code"),
                        set.getInt("percentage"),
                        set.getString("description"),
                        set.getString("products")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        val.add(new Discount("No discount", 0, "No discount"));

        return val;
    }

    public static DBController getInstance() {
        if (instance == null) {
            instance = new DBController();
        }
        return instance;
    }

    public static Connection connect() {
        connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(DB_URL, user, password);
            System.out.println("Connection to database successful.");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);

        }
        return connection;
    }


    public static void disconnect() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Failed to disconnect from database.");
        }
    }


    public boolean nameIsTaken(String userName) {
        ResultSet set = executeQuery("SELECT * FROM customers where username='" + userName + "'");
        try {
            return set.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void createNormalUser(User user) {
        executeQuery("INSERT INTO customers values ('" +
                user.getUserName() + "','" +
                user.getFirstName() + "','" +
                user.getLastName() + "','" +
                user.getCountry() + "','" +
                user.getCity() + "','" +
                user.getAddress() + "','" +
                user.getPassword() + "','" +
                user.getEmail() + "','" +
                user.getPhone() + "')");
    }

    public boolean addDiscount(Discount discount) {
        return true;
    }

    public void addSupplier(Supplier supplier) {
        executeQuery("INSERT INTO suppliers values ('" +
                supplier.getSupplierName() + "','" +
                supplier.getSupplierPhone() + "','" +
                supplier.getSupplierAddress() + "')");
    }


    public boolean addProduct(Product product) {
        return true;
    }

    public boolean deleteProduct(String productNameToDelete) {
        return true;
    }

    public User authenticateUser(String username, String password) {
        try {

            User user;
            ResultSet set = executeQuery("select * from customers where username='" + username + "'");
            set.next();
            if (!password.equals(set.getString("pass"))) {
                return null;
            }

            return new User(set.getString("username"),
                    set.getString("firstname"),
                    set.getString("lastname"),
                    set.getString("country"),
                    set.getString("city"),
                    set.getString("adress"),
                    set.getString("pass"),
                    set.getString("email"),
                    set.getString("phonenr"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet set = statement.executeQuery(query);
            return set;
        } catch (SQLException e) {
            System.out.println("err");
        }
        return null;
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
