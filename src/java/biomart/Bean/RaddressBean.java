package biomart.Bean;

public class RaddressBean {

    private String referenceId;
    private String doorNo;
    private String street;
    private String city;
    private String district;
    private String state;
    private long pincode;
    private PersonalDetailsBean ReferenceBean;

    public PersonalDetailsBean getReferenceBean() {
        return ReferenceBean;
    }

    public void setReferenceBean(PersonalDetailsBean ReferenceBean) {
        this.ReferenceBean = ReferenceBean;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getPincode() {
        return pincode;
    }

    public void setPincode(long pincode) {
        this.pincode = pincode;
    }

}
