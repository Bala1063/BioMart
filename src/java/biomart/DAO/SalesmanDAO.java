/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.DAO;

import biomart.Bean.CashBean;
import biomart.Bean.PersonalDetailsBean;
import biomart.Util.Util;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author bala
 */
public class SalesmanDAO {

    public List<PersonalDetailsBean> viewPendingAmountDetails(String district) {
        Session session = Util.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(PersonalDetailsBean.class);
        criteria.add(Restrictions.eq("District", district));
        criteria.add(Restrictions.eq("Type", "R"));
        List<PersonalDetailsBean> personalDetailsBeans = criteria.list();
        session.close();
        return personalDetailsBeans;
    }

    public PersonalDetailsBean viewSalesmanDetails(String userId) {
        Session session = Util.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(PersonalDetailsBean.class);
        criteria.add(Restrictions.eq("User_id", userId));
        PersonalDetailsBean personalDetailsBeans = (PersonalDetailsBean)criteria.list().get(0);
        session.close();
        return personalDetailsBeans;
    }
    public List<PersonalDetailsBean> getAllSalesman()
    {
        Session session=Util.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(PersonalDetailsBean.class);
        criteria.add(Restrictions.eq("Type","S"));
        List<PersonalDetailsBean> personalDetailsBeans=criteria.list();
        session.close();
        return personalDetailsBeans;
    }
}
