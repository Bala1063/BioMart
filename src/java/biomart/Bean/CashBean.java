package biomart.Bean;

public class CashBean {
	
	private String userId;
	private float amount;
        private PersonalDetailsBean personalDetailsBean;

    public PersonalDetailsBean getPersonalDetailsBean() {
        return personalDetailsBean;
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

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
	
	
}
