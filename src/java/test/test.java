/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import biomart.Bean.PersonalDetailsBean;
import biomart.DAO.SalesmanDAO;

/**
 *
 * @author bala
 */
public class test {
    public static void main(String[] args) {
         SalesmanDAO salesmanDAO = new SalesmanDAO();
                PersonalDetailsBean personalDetailsBean = salesmanDAO.viewSalesmanDetails("RET_002");
                
                System.out.println(personalDetailsBean.toString());
    }
    
}
