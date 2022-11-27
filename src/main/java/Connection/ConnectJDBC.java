package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectJDBC {
    private final String serverName = "DESKTOP-B5NMLGI\\LONG";
    private final String dbName = "AppleStore3";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa";
    private final String password = "20110299";

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";
        if (instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try {
            System.out.println(new ConnectJDBC().getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
