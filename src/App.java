import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        //Auth a = new Auth();
        //a.lerArquivo();
        DBConnection c = new DBConnection();
        //c.createTableUsers();
        System.out.println(c.validarUsuario("admin"));
    }
}
