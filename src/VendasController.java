import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

@WebServlet("/vendasServlet")
public class VendasController extends HttpServlet {

    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:C:/Users/gustavo.agnes/Desktop/PDS_TF/PDS_TF/src\\DBTF;create=true";
    Connection conn;

    private PreparedStatement stmt;

   // ArrayList<Vendas> vendas = new ArrayList<Vendas>();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        handleRequest(req, resp);
    }

    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            try {
                Class.forName(DRIVER);
            } catch (ClassNotFoundException e) {
                //handle exception
            }
            PrintWriter out = resp.getWriter();
            this.conn = DriverManager.getConnection(JDBC_URL);
            stmt = conn.prepareStatement("SELECT * FROM VENDAS");
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            out.write("<h1><center> Vendas Realizadas</center></h1>");
                while (rs.next()) {
                 //   vendas.add(new Vendas(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
                    out.write("<p>"+"O número da venda é: "+rs.getString(1)
                            + ", a data da venda é: "+rs.getString(2) +
                            ", o nome do atendente que realizou a venda é: "+ rs.getString(3) +
                            ", o CRM do médico é: "+ rs.getString(4) +
                            ", a data da receita é: "+rs.getString(5)+"</p>");
                }
                /*
            for (int i = 0; i < vendas.size(); i++) {
                out.write("<p>" + vendas.toString().substring(1, vendas.toString().length() - 1) + "</p>");
                out.write("<p>teste</p>");
            }
            */
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
    }
}
