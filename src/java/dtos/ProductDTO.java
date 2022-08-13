/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Admin
 */
public class ProductDTO {

    String productId;
    String productName;
    String image ;
    Double price;
    Integer quantity;
    String categoryid;
    String importDate;
    String usingDate;
    boolean status;

    public ProductDTO() {
        this.productId = "";
        this.productName = "";
        this.image = "";
        this.price = 0.0;
        this.quantity = 0;
        this.categoryid = "";
        this.importDate = "";
        this.usingDate = "";
        
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    

    public ProductDTO(String productId, String productName, String image, Double price, Integer quantity, String categoryid, String importDate, String usingDate,boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.categoryid = categoryid;
        this.importDate = importDate;
        this.usingDate = usingDate;
        this.status=status;
    }

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

    public String getImage() {
        return image;
    }

    public void setImg(String img) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getUsingDate() {
        return usingDate;
    }

    public void setUsingDate(String usingDate) {
        this.usingDate = usingDate;
    }
    

   
}