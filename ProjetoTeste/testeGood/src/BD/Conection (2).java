package BD;

import java.sql.*;

public class Conection {
    public static String url = "jdbc:mysql://localhost:3306/dbclinica-project";
    public static String user = "root";
    public static String password = "";

    public static Connection conectar = null;

    public static Connection getConectar() throws Exception {
        try {
            if ((conectar == null) || (conectar.isClosed())) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conectar = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Error " + e.getMessage());
        }
        return conectar;
    }

    public static void fecharConexao() throws Exception {
        if ((conectar != null) && !conectar.isClosed()) {
            conectar.close();
        }
    }
}
