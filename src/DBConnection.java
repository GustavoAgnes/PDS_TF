import java.sql.*;
import java.util.prefs.Preferences;

public class DBConnection {

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:C:/Users/gustavo.agnes/Desktop/PDS_TF/PDS_TF/src\\DBTF;create=true";
    Connection conn;
    private PreparedStatement stmt;

    public void createTableUsers() {
        try {
            try{
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e){
                //handle exception
            }
            this.conn = DriverManager.getConnection(JDBC_URL);
            stmt = conn.prepareStatement("CREATE TABLE Users (id BIGINT, username VARCHAR(20), password VARCHAR(20), email VARCHAR(254), last_login DATE , date_created DATE");
            //stmt.executeUpdate("CREATE TABLE Users (id BIGINT, username VARCHAR(20), password VARCHAR(20), email VARCHAR(254), last_login DATE , date_created DATE)");
        } catch (SQLException sqlExcept) {
            sqlExcept.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }

    public boolean validarUsuario(String user, String senha) {
        boolean existe = false;
        try {
            try{
                Class.forName(DRIVER);
            } catch(ClassNotFoundException e){
                //handle exception
            }
            conn = DriverManager.getConnection(JDBC_URL);
            stmt = conn.prepareStatement("SELECT * FROM USERS");
            //ResultSet rs = stmt.executeQuery("SELECT * FROM USERS");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if(user.equalsIgnoreCase(rs.getString(2)) && senha.equals(rs.getString(3))){
                    existe = true;
                }
            }
        } catch (SQLException sqlExcept) {
            System.out.println("Falhou conexão");
            sqlExcept.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) { /* ignored */}
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return existe;
    }
}
