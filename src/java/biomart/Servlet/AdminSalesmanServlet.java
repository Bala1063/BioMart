/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.Servlet;

import biomart.Bean.PaddressBean;
import biomart.Bean.PersonalDetailsBean;
import biomart.DAO.CommonDAO;
import biomart.DAO.SalesmanDAO;
import biomart.IdGenerator.SalesmanIdGenerator;
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
public class AdminSalesmanServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String operation = request.getParameter("operation");
        if (operation.equalsIgnoreCase("add") || operation.equalsIgnoreCase("update")) {
            PersonalDetailsBean personalDetailsBean = null;
            String userId = "";
            if (operation.equalsIgnoreCase("add")) {
                personalDetailsBean = new PersonalDetailsBean();
                userId = new SalesmanIdGenerator().generateSalesmanId(request.getParameter("username"));
                personalDetailsBean.setUserId(userId);
            } else if (operation.equalsIgnoreCase("update")) {
                personalDetailsBean = new SalesmanDAO().viewSalesmanDetails(request.getParameter("userid"));
            }
            personalDetailsBean.setUserName(request.getParameter("username"));
            personalDetailsBean.setType("S");
            personalDetailsBean.setEmailId(request.getParameter("email"));
            personalDetailsBean.setPhoneNo(Long.parseLong(request.getParameter("mobileno")));
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
                    request.setAttribute("status", "Salesman Added");
                    request.getRequestDispatcher("adminaddsales.jsp").forward(request, response);
                } else if (operation.equalsIgnoreCase("update")) {
                    request.setAttribute("status", "Salesman Updated");
                    request.getRequestDispatcher("admineditsales.jsp").forward(request, response);
                }
            }
        } else if (operation.equalsIgnoreCase("namelist")) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String salesmannamelist = "";
            try {
                List<PersonalDetailsBean> personalDetailsBeans = new SalesmanDAO().getAllSalesman();
                for (PersonalDetailsBean personalDetailsBean : personalDetailsBeans) {
                    salesmannamelist += "<option>" + personalDetailsBean.getUserName() + "</option>";
                }
                out.println(salesmannamelist);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (operation.equalsIgnoreCase("getDetails")) {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            String details = "";
            String userName = request.getParameter("userName");
            try {
                SalesmanDAO salesmanDAO = new SalesmanDAO();
                PersonalDetailsBean personalDetailsBean = salesmanDAO.viewSalesmanDetails(salesmanDAO.getSalesmanId(userName));
                details = personalDetailsBean.toString();
                out.println(details);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
