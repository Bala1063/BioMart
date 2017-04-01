package biomart.Bean;

public class PaddressBean {

    private String userId;
    private String doorNo;
    private String street;
    private String city;
    private String district;
    private String state;
    private long pincode;
    private PersonalDetailsBean personalDetailsBean;

    public PersonalDetailsBean getPersonalDetailsBean() {
        return personalDetailsBean;
    }

    @Override
    public String toString() {
        return doorNo + "," + street + "," + city + "," + district + "," + state + "," + pincode;
    }

    public void setPersonalDetailsBean(PersonalDetailsBean personalDetailsBean) {
        this.personalDetailsBean = personalDetailsBean;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
