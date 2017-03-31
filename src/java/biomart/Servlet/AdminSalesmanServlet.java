/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.Servlet;

import biomart.Bean.PaddressBean;
import biomart.Bean.PersonalDetailsBean;
import biomart.DAO.CommonDAO;
import biomart.IdGenerator.SalesmanIdGenerator;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bala
 */
public class AdminSalesmanServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation=request.getParameter("operation");
        if(operation.equalsIgnoreCase("add"))
        {
            PersonalDetailsBean personalDetailsBean=new PersonalDetailsBean();
           
            String userId=new SalesmanIdGenerator().generateSalesmanId(request.getParameter("username"));
            personalDetailsBean.setUserId(userId);
            personalDetailsBean.setUserName(request.getParameter("username"));
            personalDetailsBean.setType("S");
            personalDetailsBean.setEmailId(request.getParameter("email"));
            personalDetailsBean.setPhoneNo(Long.parseLong(request.getParameter("mobileno")));
            PaddressBean paddressBean=new PaddressBean();
            paddressBean.setDoorNo(request.getParameter("doorno"));
            paddressBean.setStreet(request.getParameter("streetname"));
            paddressBean.setCity(request.getParameter("city"));
            paddressBean.setDistrict(request.getParameter("district"));
            paddressBean.setState(request.getParameter("state"));
            paddressBean.setPincode(Integer.parseInt(request.getParameter("pincode")));
            paddressBean.setPersonalDetailsBean(personalDetailsBean);
            personalDetailsBean.setpAddressBean(paddressBean);
            if(new CommonDAO().addOrUpdateDetails(personalDetailsBean).equalsIgnoreCase("success"))
            {
               request.setAttribute("status", "Salesman Added");
               request.getRequestDispatcher("adminaddsales.jsp").forward(request, response);
            }
        }
      
            
    }

}