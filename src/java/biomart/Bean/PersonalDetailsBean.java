package biomart.Bean;

import java.util.List;

public class PersonalDetailsBean {

    private String userId;
    private String userName;
    private String type;
    private long phoneNo;
    private String emailId;
    private String storeName;
    private PaddressBean pAddressBean;
    private CashBean cashBean;
    private List<CheckBean> checkBeans;
    private List<PaymentDetailsBean> paymentDetailsBeans;
    private List<OrderBean> orderBeans;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    
    public List<OrderBean> getOrderBeans() {
        return orderBeans;
    }

    public void setOrderBeans(List<OrderBean> orderBeans) {
        this.orderBeans = orderBeans;
    }
    

    public List<CheckBean> getCheckBeans() {
        return checkBeans;
    }

    public void setCheckBeans(List<CheckBean> checkBeans) {
        this.checkBeans = checkBeans;
    }

    public List<PaymentDetailsBean> getPaymentDetailsBeans() {
        return paymentDetailsBeans;
    }

    public void setPaymentDetailsBeans(List<PaymentDetailsBean> paymentDetailsBeans) {
        this.paymentDetailsBeans = paymentDetailsBeans;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PaddressBean getpAddressBean() {
        return pAddressBean;
    }

    public void setpAddressBean(PaddressBean pAddressBean) {
        this.pAddressBean = pAddressBean;
    }

    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public CashBean getCashBean() {
        return cashBean;
    }

    public void setCashBean(CashBean cashBean) {
        this.cashBean = cashBean;
    }

}
