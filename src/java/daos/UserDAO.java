/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.ProductDTO;
import dtos.UserDTO;
import untils.DBUntils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class UserDAO {

    public UserDTO checkLogin(String userId, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        UserDTO user = null;

        try {
            conn = DBUntils.getcon();
            if (conn != null) {
                String url = "SELECT fullname,roleid,address,birthday,phone,email,status FROM tblUsers Where userID=? and  password=? AND status ='true'";
                stm = conn.prepareStatement(url);
                stm.setString(1, userId);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String fullName = rs.getString("fullName");
                    String roleId = rs.getString("roleid");
                    String address = rs.getString("address");
                    String birthday = rs.getString("birthday");
                    String phone = rs.getString("phone");
                    String email = rs.getString("email");
                    String status = rs.getString("status");
                    
                    user = new UserDTO(userId, fullName, "***", roleId, address, birthday, phone,status,email);
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
        return user;
    }

   
}
