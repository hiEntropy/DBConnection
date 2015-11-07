/**
 * Created by tiptona on 10/30/15.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {


    /**
     * Simple static method to close connections.  This methods purpose
     * is to make boilerplate coding less of an issue.
     * @param con
     */
    public static void closeConnection(Connection con){
        try {
            if(con!=null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method takes a file.  The file must conform to the key=value\n format
     *
     * @param file containing the url, username and password for a database connection
     * @return java.SQL.Connection if connection was successful else false
     */
    public static Connection getConnection(File file){
        Properties props = new Properties();
        Connection connection;
        try {
            props.load(new FileInputStream(file));
            connection= DriverManager.getConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("pass"));
            return connection;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
