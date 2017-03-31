package biomart.Bean;

import java.util.Date;
import java.util.List;

public class OrderBean {

    private String orderId;
    private Date orderDate;
    private String userId;
    private int quantity;
    private float totalAmount;
    private String orderStatus;
    private String deliveryType;
    private String deliveryDescription;
    private List<OrderListBean> orderListBeans;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDeliveryDescription() {
        return deliveryDescription;
    }

    public void setDeliveryDescription(String deliveryDescription) {
        this.deliveryDescription = deliveryDescription;
    }

    public List<OrderListBean> getOrderListBeans() {
        return orderListBeans;
    }

    public void setOrderListBeans(List<OrderListBean> orderListBeans) {
        this.orderListBeans = orderListBeans;
    }

   
   
}
