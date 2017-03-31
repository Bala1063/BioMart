/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.DAO;

import biomart.Bean.PersonalDetailsBean;
import biomart.Util.Util;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author bala
 */
public class RetailerDAO {
    public PersonalDetailsBean viewRetailerDetails(String userId)
    {
        Session session=Util.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(PersonalDetailsBean.class);
        criteria.add(Restrictions.eq("User_id", userId));
        PersonalDetailsBean personalDetailsBean=(PersonalDetailsBean)criteria.list().get(0);
        session.close();
        return personalDetailsBean;
    }
    
    public List<PersonalDetailsBean> getAllRetailers()
    {
        Session session=Util.getSessionFactory().openSession();
        Criteria criteria=session.createCriteria(PersonalDetailsBean.class);
        criteria.add(Restrictions.eq("Type","R"));
        List<PersonalDetailsBean> personalDetailsBeans=criteria.list();
        session.close();
        return personalDetailsBeans;
    }
    
}
