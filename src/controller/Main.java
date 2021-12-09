package controller;

import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException {
        Controller.getInstance().setUp();


        //ResultSet set = DBController.getInstance().executeQuery("SELECT * FROM customers where username='5164'");
        // System.out.println(set.next());

    }
}
