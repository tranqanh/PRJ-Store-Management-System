/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.OrderDTO;
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
public class OrderDAO {

    public void insertToOrder(OrderDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;

        try {
            conn = DBUntils.getcon();
            String sql = "  INSERT INTO tblOrder(orderid,userid,orderdate,total,status) VALUES (?,?,?,?,?)";
            if(conn!=null){
                stm=conn.prepareStatement(sql);
                stm.setString(1, dto.getOrderid());
                stm.setString(2, dto.getUserid());
                stm.setString(3, dto.getOrderDate());
                stm.setDouble(4, dto.getTotal());
                stm.setBoolean(5, true);
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
     public List<OrderDTO> getAllOrder() throws SQLException {
        List<OrderDTO> list = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUntils.getcon();
            if (conn != null) {
                String sql = "SELECT orderid,userid,orderdate,total,status FROM tblOrder";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String orderid = rs.getString("orderid");
                    String userid = rs.getString("userid");
                    String date = rs.getString("orderdate");
                    Double total = rs.getDouble("total");
                    Boolean status = rs.getBoolean("status");
                    if (list == null) {
                        list = new ArrayList<OrderDTO>();
                    }
                    list.add(new OrderDTO(orderid, userid, orderid, total,true));
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
}
