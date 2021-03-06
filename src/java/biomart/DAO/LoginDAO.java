/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.DAO;

import biomart.Bean.LoginBean;
import biomart.Util.Util;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author bala
 */
public class LoginDAO {

    public String login(String userId, String password) {
        Session session = Util.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(LoginBean.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.eq("password", password));
        if (criteria.list().isEmpty()) {
            return null;
        } else {
            LoginBean loginBean = (LoginBean) criteria.list().get(0);
            if (loginBean.getStatus() == null) {
                loginBean.setStatus("noactive");
            }
            if (loginBean.getStatus().equalsIgnoreCase("active")) {
                return "already active";
            }
            loginBean.setLoginTime(new Date());
            loginBean.setLogoutTime(null);
            loginBean.setStatus("active");
            if (updateLoginDetails(loginBean).equals("success")) {
                return loginBean.getType();
            } else {
                return "fail";
            }
        }
    }

    public String logout(String userId) {
        Session session = Util.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(LoginBean.class);
        criteria.add(Restrictions.eq("userId", userId));
        if (criteria.list().isEmpty()) {
            return null;
        } else {

            LoginBean loginBean = (LoginBean) criteria.list().get(0);
            loginBean.setLogoutTime(new Date());
            loginBean.setStatus("noactive");
            if (updateLoginDetails(loginBean).equals("success")) {
                return "success";
            } else {
                return "fail";
            }
        }

    }

    public String updateLoginDetails(LoginBean loginBean) {

        Session session = Util.getSessionFactory().openSession();
        Transaction t = null;
        try {
            t = session.beginTransaction();
            session.update(loginBean);
            t.commit();
        } catch (HibernateException e) {
            if (t != null) {
                t.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return "success";
    }

    public String changePassword(String userId, String newPassword) {
        Session session = Util.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(LoginBean.class);
        criteria.add(Restrictions.eq("userId", userId));
        if (criteria.list().isEmpty()) {
            return "fail";
        }
        LoginBean loginBean = (LoginBean) criteria.list().get(0);
        loginBean.setPassword(newPassword);
        if (new CommonDAO().addOrUpdateDetails(loginBean).equals("success")) {
            return loginBean.getType();
        }
        return "fail";
    }
}
