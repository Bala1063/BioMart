/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.DAO;

import biomart.Bean.CheckBean;
import biomart.Bean.OrderBean;
import biomart.Bean.PaddressBean;
import biomart.Bean.PaymentDetailsBean;
import biomart.Bean.PersonalDetailsBean;
import biomart.Bean.ProductBean;
import biomart.Bean.ReferenceBean;
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
public class AdminDAO {

    public String removeUserDetails(String userName, long phoneNo) {
        Session session = Util.getSessionFactory().openSession();
        Query query = session.createQuery("delete from PersonalDetailsBean where userName=:un and phoneNo=:pno");
        query.setParameter("un", userName);
        query.setParameter("pno", phoneNo);
        session.close();
        return "success";
    }

    public String removeProductDetails(String productName) {
        Session session = Util.getSessionFactory().openSession();
        Query query = session.createQuery("delete from ProductBean where Product_name=:pn");
        query.setParameter("pn", productName);
        session.close();
        return "success";
    }

    public List<OrderBean> viewOrderDetails(String orderStatus) {
        Session session = Util.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(OrderBean.class);
        criteria.add(Restrictions.eq("Order_status", orderStatus));
        List<OrderBean> orderBeans = criteria.list();
        session.close();
        return orderBeans;
    }

    public String updateOrderStatus(String orderId, String orderStatus) {
        Session session = Util.getSessionFactory().openSession();
        OrderBean orderBean = (OrderBean) session.get(OrderBean.class, orderId);
        orderBean.setOrderStatus(orderStatus);
        session.close();
        if (new CommonDAO().addOrUpdateDetails(orderBean).equals("success")) {

            return "success";
        }
        return null;
    }

    public String UpdateDeliveryStatus(String orderId, String deliveryType, String deliveryDescription) {
        Session session = Util.getSessionFactory().openSession();
        OrderBean orderBean = (OrderBean) session.get(OrderBean.class, orderId);
        orderBean.setDeliveryType(deliveryType);
        orderBean.setDeliveryDescription(deliveryDescription);
        session.close();
        if (new CommonDAO().addOrUpdateDetails(orderBean).equals("success")) {
            return "success";
        }
        return null;
    }

    public List<CheckBean> checkDetails() {
        Session session = Util.getSessionFactory().openSession();
        Query query = session.createQuery("From CheckBean");
        List<CheckBean> checkBeans = query.list();
        session.close();
        return checkBeans;
    }

    public List<PaymentDetailsBean> paymentDetails() {
        Session session = Util.getSessionFactory().openSession();
        Query query = session.createQuery("From PaymentDetailsBean");
        List<PaymentDetailsBean> paymentDetailsBeans = query.list();
        session.close();
        return paymentDetailsBeans;
    }

    public List<ReferenceBean> viewReferenceBean(String status) {
        Session session = Util.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(ReferenceBean.class);
        criteria.add(Restrictions.eq("Status", status));
        List<ReferenceBean> referenceBeans = criteria.list();
        session.close();
        return referenceBeans;

    }

    public String acceptReference(String referenceId) {
        Session session = Util.getSessionFactory().openSession();
        ReferenceBean referenceBean = (ReferenceBean) session.get(ReferenceBean.class, referenceId);
        PersonalDetailsBean personalDetailsBean = new PersonalDetailsBean();
        personalDetailsBean.setUserName(referenceBean.getName());
        personalDetailsBean.setType("S");
        personalDetailsBean.setStoreName(referenceBean.getStoreName());
        personalDetailsBean.setPhoneNo(referenceBean.getPhoneNo());
        personalDetailsBean.setEmailId(referenceBean.getEmail());
        PaddressBean paddressBean = new PaddressBean();
        paddressBean.setCity(referenceBean.getRaddressBean().getCity());
        paddressBean.setDistrict(referenceBean.getRaddressBean().getDistrict());
        paddressBean.setDoorNo(referenceBean.getRaddressBean().getDoorNo());
        paddressBean.setPincode(referenceBean.getRaddressBean().getPincode());
        paddressBean.setState(referenceBean.getRaddressBean().getState());
        paddressBean.setStreet(referenceBean.getRaddressBean().getStreet());
        personalDetailsBean.setpAddressBean(paddressBean);
        session.close();
        if (new CommonDAO().addOrUpdateDetails(personalDetailsBean).equals("success")) {
            return "success";
        }

        return null;

    }
    public List<ProductBean> getAllProdudctNames()
    {
        Session session = Util.getSessionFactory().openSession();
        Query query = session.createQuery("From ProductBean");
        List<ProductBean> productBeans = query.list();
        session.close();
        return productBeans;
        
    }
}
