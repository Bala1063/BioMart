/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biomart.Bean;

/**
 *
 * @author bala
 */
public class ReferenceBean {
    private String referenceId;
    private String name;
    private String storeName;
    private String email;
    private long phoneNo;
    private String status;
    private RaddressBean raddressBean;

    public RaddressBean getRaddressBean() {
        return raddressBean;
    }

    public void setRaddressBean(RaddressBean raddressBean) {
        this.raddressBean = raddressBean;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
    
    
}
