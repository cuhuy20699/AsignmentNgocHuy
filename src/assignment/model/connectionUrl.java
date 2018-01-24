package assignment.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class connectionUrl {
    private static Connection connection = null;

    public static Connection connectionHelp(){
        if (connection== null){
            try {
                // tạo kết nối tới database với tài khoản root, pass rỗng
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aptech_fpt", "root", "");
            }
            catch (SQLException ex) {
                System.err.println("Can not connect to database.");
                connection = null;
            }
        }
        return connection;
    }

}
