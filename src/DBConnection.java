import java.sql.*;

public class DBConnection {

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:C:/Users/gustavo.agnes/Desktop/PDS_TF/PDS_TF/src\\DBTF;create=true";
    Connection conn;
    private PreparedStatement stmt;
    private PreparedStatement createTable;
    private PreparedStatement stmt2;

    public void createTableUsers() {
        try {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                //handle exception
            }
            this.conn = DriverManager.getConnection(JDBC_URL);
            createTable = conn.prepareStatement("CREATE TABLE Users (id BIGINT, username VARCHAR(20), password VARCHAR(20), email VARCHAR(254), last_login DATE , date_created DATE, count INT");
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

    public int validarUsuario(String user, String senha) {
        int valido = 0; // 0 = usuario invalido, 1 = valido, 2 = bloqueado
        try {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                //handle exception
            }
            conn = DriverManager.getConnection(JDBC_URL);
            stmt = conn.prepareStatement("SELECT * FROM USERS");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if(Integer.parseInt(rs.getString(7))>2){
                    valido = 2;
                }
                System.out.println(rs.getString(7));
                if (user.equalsIgnoreCase(rs.getString(2)) && Integer.parseInt(rs.getString(7))<3) {
                    if (senha.equals(rs.getString(3))) {
                        stmt2 = conn.prepareStatement("UPDATE USERS SET CONT = 0 WHERE USERNAME = '" + rs.getString(2) + "'");
                        stmt2.executeUpdate();
                        valido = 1;
                    } else if (!senha.equals(rs.getString(3))) {
                        stmt2 = conn.prepareStatement("UPDATE USERS SET CONT = CONT+1 WHERE USERNAME = '" + rs.getString(2) + "'");
                        stmt2.executeUpdate();
                        valido = 0;
                    }
                } else if(Integer.parseInt(rs.getString(7))>2){
                    valido = 2;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        return valido;
    }
}
