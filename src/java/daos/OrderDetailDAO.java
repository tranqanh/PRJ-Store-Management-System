/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrderDTO;
import dtos.OrderDetailDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import untils.DBUntils;

/**
 *
 * @author Admin
 */
public class OrderDetailDAO {

    public List<OrderDetailDTO> getAllOrderDetail() throws SQLException {
        List<OrderDetailDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUntils.getcon();
            if (conn != null) {
                String sql = "SELECT detailid,price,quantity,orderid,productid,status FROM tblOrderDetail";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int orderiddetailid = rs.getInt("detailid");
                    String orderid = rs.getString("orderid");
                    String productid = rs.getString("productid");
                    Double price = rs.getDouble("price");
                    int quantity = rs.getInt("quantity");
                    Boolean status = rs.getBoolean("status");
                    if (list == null) {
                        list = new ArrayList<OrderDetailDTO>();
                    }
                    list.add(new OrderDetailDTO(orderiddetailid, orderid, productid, price, quantity,true));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }

    public void insertToOrderDetail(OrderDetailDTO order) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        try {
            conn = DBUntils.getcon();
            String sql = "INSERT INTO tblOrderDetail (detailid,price,quantity,orderid,productid ,status) VALUES (?,?,?,?,?,?)";
            if (conn != null) {
                stm = conn.prepareStatement(sql);
                
                stm.setInt(1, order.getDetailId());
                stm.setDouble(2, order.getPrice());
                stm.setInt(3, order.getQuantity());
                stm.setString(4, order.getOrderid());
                stm.setString(5, order.getProductid());
                stm.setBoolean(6, order.isStatus());
                stm.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
