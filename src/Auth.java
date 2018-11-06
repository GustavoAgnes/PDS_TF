import java.io.*;
import java.sql.*;
import java.util.prefs.Preferences;

public class Auth {

    Preferences preferences =
            Preferences.userNodeForPackage(Auth.class);

    public String getPassword() {
        return preferences.get("db_password", null);
    }

    public int lerArquivo(){
        File file = new File("C:\\Users\\gustavo.agnes\\Desktop\\PDS_TF\\PDS_TF\\usuarios.txt");
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
        }catch(FileNotFoundException FNF){
            System.out.println("Arquivo não existe");
            return 1;
        }

        String st;
        try {
            while ((st = br.readLine()) != null) {

                String[] partes = st.split(";");
                String usuario = partes[0];
                String senha = partes[1];
            }
        }catch(IOException IOe){
            return 1;
        }
        return 0;
    }


}
