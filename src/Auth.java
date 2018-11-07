import java.io.*;
import java.sql.*;
import java.util.prefs.Preferences;

public class Auth {

    Preferences preferences =
            Preferences.userNodeForPackage(Auth.class);

    public String getPassword() {
        return preferences.get("db_password", null);
    }



}
