/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.Servlet;

import biomart.Bean.PaddressBean;
import biomart.Bean.PersonalDetailsBean;
import biomart.DAO.AdminDAO;
import biomart.DAO.CommonDAO;
import biomart.DAO.RetailerDAO;
import biomart.IdGenerator.RetailerIdGenerator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bala
 */
public class AdminRetailerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operation = request.getParameter("operation");
        if (operation.equalsIgnoreCase("add") || operation.equalsIgnoreCase("update")) {
            PersonalDetailsBean personalDetailsBean = null;
            if (operation.equalsIgnoreCase("add")) {
                personalDetailsBean = new PersonalDetailsBean();
                personalDetailsBean.setUserId(new RetailerIdGenerator().generateRetailerId(request.getParameter("username")));
            } else if (operation.equalsIgnoreCase("update")) {
                personalDetailsBean = new RetailerDAO().viewRetailerDetails(request.getParameter("userid"));
            }
            personalDetailsBean.setUserName(request.getParameter("username"));
            personalDetailsBean.setType("R");
            personalDetailsBean.setEmailId(request.getParameter("email"));
            personalDetailsBean.setPhoneNo(Long.parseLong(request.getParameter("mobileno")));
            personalDetailsBean.setStoreName(request.getParameter("storename"));
            PaddressBean paddressBean = null;
            if (operation.equalsIgnoreCase("add")) {
                paddressBean = new PaddressBean();
                paddressBean.setPersonalDetailsBean(personalDetailsBean);
            } else if (operation.equalsIgnoreCase("update")) {
                paddressBean = personalDetailsBean.getpAddressBean();
            }
            paddressBean.setDoorNo(request.getParameter("doorno"));
            paddressBean.setStreet(request.getParameter("streetname"));
            paddressBean.setCity(request.getParameter("city"));
            paddressBean.setDistrict(request.getParameter("district"));
            paddressBean.setState(request.getParameter("state"));
            paddressBean.setPincode(Long.parseLong(request.getParameter("pincode")));
            if (operation.equalsIgnoreCase("add")) {
                personalDetailsBean.setpAddressBean(paddressBean);
            }
            if (new CommonDAO().addOrUpdateDetails(personalDetailsBean).equalsIgnoreCase("success")) {
                if (operation.equalsIgnoreCase("add")) {
                    request.setAttribute("status", "Retailer Added");
                    request.getRequestDispatcher("adminaddret.jsp").forward(request, response);
                } else if (operation.equalsIgnoreCase("update")) {
                    request.setAttribute("status", "Retailer Updated");
                    request.getRequestDispatcher("admineditret.jsp").forward(request, response);
                }
            }
        } else if (operation.equalsIgnoreCase("storelist")) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String storelist = "";
            try {
                List<PersonalDetailsBean> personalDetailsBeans = new RetailerDAO().getAllRetailers();
                for (PersonalDetailsBean personalDetailsBean : personalDetailsBeans) {
                    storelist += "<option>" + personalDetailsBean.getStoreName() + "</option>";
                }
                 out.println(storelist);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (operation.equalsIgnoreCase("getDetails")) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String details = "";
            String storeName = request.getParameter("storename");
                      
            try {
                RetailerDAO retailerDAO=new RetailerDAO();
                String retailerId=retailerDAO.getRetailerId(storeName);
                if(retailerId!=null){
                PersonalDetailsBean personalDetailsBean = retailerDAO.viewRetailerDetails(retailerId);
                details = personalDetailsBean.toString();}
                System.out.println(details);
                out.println(details);
            } catch (Exception e) {
                e.printStackTrace();
            }
            
    }
        else if (operation.equalsIgnoreCase("remove")) {
            String salesmanname = request.getParameter("username");
            long mobileno = Long.parseLong(request.getParameter("mobileno"));

            if (new AdminDAO().removeUserDetails(salesmanname, mobileno).equalsIgnoreCase("success")) {
                request.setAttribute("status", "Salesman Removed");
                request.getRequestDispatcher("admindeletesales.jsp").forward(request, response);
            }

        }
        
}
}
