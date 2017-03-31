/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.Servlet;

import biomart.DAO.LoginDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bala
 */
public class LoginServlet extends HttpServlet {

    
    public String login(String userId, String password) {
        return new LoginDAO().login(userId, password);
    }

    public String logout(String userId) {
        return new LoginDAO().logout(userId);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if (operation.equalsIgnoreCase("login")) {
            String userId = request.getParameter("user_id");
            String password = request.getParameter("pass_word");
            String result = login(userId, password);
            if (result == null) {

            } else if (result.equalsIgnoreCase("A")) {
                request.getSession().setAttribute("userId", userId);
                response.sendRedirect("admindash.html");
            } else if (result.equalsIgnoreCase("S")) {
                 request.getSession().setAttribute("userId", userId);
                response.sendRedirect("salesmandash.html");

            } else if (result.equals("M")) {
                  request.getSession().setAttribute("userId", userId);
                response.sendRedirect("managerdash.html");

            } 
            else if(result.equals("R"))
            {
                
            }
            else if (result.equalsIgnoreCase("fail")) {

            }

        }

        if (operation.equalsIgnoreCase("logout")) {
            String userId = (String) request.getSession(false).getAttribute("userId");
            String result = logout(userId);
            if (result.equalsIgnoreCase("success")) {
                request.getSession().invalidate();
                response.sendRedirect("login.html");
            }

        }
        if(operation.equalsIgnoreCase("submit"))
        {
            String userId=(String) request.getSession(false).getAttribute("userId");
            String newPassword=request.getParameter("new_password");
            String result=new LoginDAO().changePassword(userId, newPassword);
            if(!result.equalsIgnoreCase("fail"))
            {                
             request.setAttribute("changeStatus", result);
             request.getRequestDispatcher("passwordchange.jsp").forward(request, response);
            }
            
        }
    }

}
