/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDetailDTO {

    int detailId;
    String orderid;
    String productid;
    Double price;
    int quantity;
    boolean status;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(int detailId, String orderid, String productid, Double price, int quantity, boolean status) {
        this.detailId = detailId;
        this.orderid = orderid;
        this.productid = productid;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

   

     public int settOrderDetailid(List<OrderDetailDTO> dto) throws SQLException {
        int id;
        String loop = null;
        if (dto == null) {
            id = 1;
            return id;
        } else {
            for (int i = 1;; i++) {
                loop=null;
                id = 0;
                id = i;
                for (int j = 0; j < dto.size(); j++) {
//                    boolean a =dto.get(j).getOrderiddetailid().equals(id);
//                    String b = dto.get(j).getOrderiddetailid();
//                    String c = id;
//                        dto.get(j).getOrderiddetailid();
                    if (dto.get(j).getDetailId()== id) {
                        
                        loop = "end";
                    }
                }
                int c = id;
                if (loop!="end") {
                    return id;
                }
            }
        }
    }
   
    
}
