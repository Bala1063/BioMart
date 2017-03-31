package biomart.Bean;

import java.util.List;

public class ProductBean {

    private String productId;
    private String productName;
    private String description;
    private int price;
    List<ProductImageBean> imageBeans;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<ProductImageBean> getImageBeans() {
        return imageBeans;
    }

    public void setImageBeans(List<ProductImageBean> imageBeans) {
        this.imageBeans = imageBeans;
    }

}
