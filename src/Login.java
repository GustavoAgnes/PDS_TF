import java.io.*;

import javax.jms.ConnectionFactory;
import javax.jms.Session;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;



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
        HttpSession sessao = req.getSession();
        // Post Parameters From The Request
        String param1 = req.getParameter("username");
        String param2 = req.getParameter("password");

        PrintWriter out = resp.getWriter();
      //  out.write("<html><body><div id='serlvetResponse' style='text-align: center;'>");
           // if((param1.equalsIgnoreCase("admin")) && (param2.equals("admin"))) {
        int valido = dbc.validarUsuario(param1,param2);
        if(valido== 1){
            sessao.setAttribute("logado",param1);
                out.write("<h2>Servlet Application Login Example</h2>");
                out.write("<p style='color: green; font-size: large;'>Congratulations! <span style='text-transform: capitalize;'>" + param1 + "</span>, You are an authorised login!</p>");
                out.write("<button type=\"submit\" class=\"btn btn-primary\" value=\"Consultar VendasController\">Consultar VendasController</button>");
            //implementar sessão
            resp.sendRedirect("./vendas.jsp");
            System.out.println(sessao.getAttribute("logado"));
        }
            if(valido == 0){
                out.write("<p style='color: red; font-size: larger;'>Você não tem acesso!</p>");
                //implementar sessão
            }
           if(valido == 2) {
               out.write("<p style='color: red; font-size: larger;'>Seu usuário está bloqueado por excesso de tentativas!</p>");
           }
            out.write("</div></body></html>");
            out.close();
        }
    }