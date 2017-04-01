/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.DAO;

import biomart.Util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class CommonDAO {
    public String addOrUpdateDetails(Object o) {

        Session session = Util.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.saveOrUpdate(o);
            t.commit();
        } catch (HibernateException e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
            return "fail";
        } finally {
            session.close();
        }
        return "success";
    }
    
   
}
