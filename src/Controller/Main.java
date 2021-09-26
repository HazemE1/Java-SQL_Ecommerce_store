package Controller;

import java.sql.Connection;


public class Main {

    public static void main(String[] args){
        DBController DBController = new DBController();
        Connection connection = DBController.connect();
        Controller controller = new Controller(DBController);

    }
}
