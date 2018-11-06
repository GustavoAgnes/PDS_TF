import java.io.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class Login extends HttpServlet {
    DBConnection dbc = new DBConnection();
    private static final long serialVersionUID = 1L;

    // This Method Is Called By The Servlet Container To Process A 'POST' Request.
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        handleRequest(req, resp);
    }

    public void handleRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("text/html");

        // Post Parameters From The Request
        String param1 = req.getParameter("username");
        String param2 = req.getParameter("password");

        PrintWriter out = resp.getWriter();
      //  out.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
           // if((param1.equalsIgnoreCase("admin")) && (param2.equals("admin"))) {
        System.out.println(dbc.validarUsuario(param1));
                if(dbc.validarUsuario(param1)){
                out.write("<h2>Servlet Application Login Example</h2>");
                out.write("<p style='color: green; font-size: large;'>Congratulations! <span style='text-transform: capitalize;'>" + param1 + "</span>, You are an authorised login!</p>");
            } else {
                out.write("<p style='color: red; font-size: larger;'>Você não tem acesso!</p>");
            }
            out.write("</div></body></html>");
            out.close();
        }
    }