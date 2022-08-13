/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import daos.OrderDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Admin
 */
public class OrderDTO {

    String orderid;
    String userid;
    String orderDate;
    double total;
    boolean status;

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderid() {
        return orderid;
    }

        public OrderDTO(String orderid, String userid, String orderDate, double total,boolean status) {
        this.orderid = orderid;
        this.userid = userid;
        this.orderDate = orderDate;
        this.total = total;
        this.status=status;
    }
    public OrderDTO(String orderid, String userid, String orderDate, double total) {
        this.orderid = orderid;
        this.userid = userid;
        this.orderDate = orderDate;
        this.total = total;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String settOrderid(List<OrderDTO> dto, String userid) throws SQLException {
        String id;
        String loop = null;
        if (dto.isEmpty()) {
            id = userid + "_" + 1;
            return id;
        } else {
            for (int i = 1;; i++) {
                loop=null;
                id = null;
                id = userid + "_" + i;
                for (int j = 0; j < dto.size(); j++) {
                    if (dto.get(j).getOrderid().equals(id)) {
                        loop = "end";
                    }
                }
                String c = id;
                if (loop!="end") {
                    return id;
                }
            }
        }
    }



    public OrderDTO() {
    }

}
