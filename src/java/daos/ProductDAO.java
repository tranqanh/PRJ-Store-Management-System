/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import dtos.ProductDTO;
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
public class ProductDAO {

    Connection conn = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    public List<ProductDTO> getAllProduct() throws SQLException {
        List<ProductDTO> list = null;

        try {
            conn = DBUntils.getcon();
            if (conn != null) {
                String sql = "SELECT productId,productName,image,price,quantity,categoryId,importDate,usingDate FROM tblProducts WHERE status='true'";
                stm = conn.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productId = rs.getString("productId");
                    String productName = rs.getString("productName");
                    Double price = rs.getDouble("price");
                    Integer quantity = rs.getInt("quantity");
                    String categoryId = rs.getString("categoryId");
                    String image = rs.getString("image");
                    String importDate = rs.getString("importDate");
                    String usingDate = rs.getString("usingDate");
                    if (list == null) {
                        list = new ArrayList<ProductDTO>();
                    }
                    list.add(new ProductDTO(productId, productName, image, price, quantity, categoryId, importDate, usingDate,true));
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

//    public List<ProductDTO> pagingFood(int index) {// pagenigbition phân trang 
//        List<ProductDTO> list = new ArrayList<>();
//        String sql = "SELECT productId,productName,image,price,quantity,categoryId,importDate,usingDate From tblProducts ORDER BY productID OFFSET ? ROWS FETCH NEXT 10 ROW ONLY;";
//        try {
//            conn = DBUntils.getcon();
//            stm = conn.prepareStatement(sql);
//            stm.setInt(1, (index - 1) * 10);
//            rs = stm.executeQuery();
//            while (rs.next()) {
//                String productId = rs.getString("productId");
//                String productName = rs.getString("productName");
//                Double price = rs.getDouble("price");
//                Integer quantity = rs.getInt("quantity");
//                String categoryId = rs.getString("categoryId");
//                String image = rs.getString("image");
//                String importDate = rs.getString("importDate");
//                String usingDate = rs.getString("usingDate");
//                
//                list.add( new ProductDTO(productId, productName, image, price, quantity, categoryId, importDate, usingDate));
//            }
//        } catch (Exception e) {
//        }
//
//        return list;
//
//    }

    public ProductDTO getAProduct(String productId) throws SQLException {
        ProductDTO product = new ProductDTO();

        try {
            conn = DBUntils.getcon();
            if (conn != null) {
                String sql = "SELECT productId,productName,price,quantity,categoryid,image,importDate,usingDate FROM tblProducts WHERE productid = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, productId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String productName = rs.getString("productName");
                    Double price = rs.getDouble("price");
                    Integer quantity = rs.getInt("quantity");
                    String categoryId = rs.getString("categoryId");
                    String image = rs.getString("image");
                    String importDate = rs.getString("importDate");
                    String usingDate = rs.getString("usingDate");

                    product = new ProductDTO(productId, productName, image, price, quantity, categoryId, importDate, usingDate,true);
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
        return product;
    }

    public List<ProductDTO> getSearchProduct(String productName, String status) throws SQLException {
        List<ProductDTO> list = null;

        try {
            conn = DBUntils.getcon();
            if (conn != null) {
                String sql = "SELECT productid,productname,image,price,quantity,categoryid,importDate,usingDate,status FROM tblProducts WHERE productname like ? AND status = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + productName + "%");
                stm.setString(2, status);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String productId = rs.getString("productid");
                    String productname = rs.getString("productname");
                    Double price = rs.getDouble("price");
                    Integer quantity = rs.getInt("quantity");
                    String categoryId = rs.getString("categoryid");
                    boolean statuspr = rs.getBoolean("status");
                    String image = rs.getString("image");
                    String importDate = rs.getString("importDate");
                    String usingDate = rs.getString("usingDate");
                    
                    if (list == null) {
                        list = new ArrayList<ProductDTO>();
                    }
                    list.add(new ProductDTO(productId, productname, image, price, quantity, categoryId, importDate, usingDate, statuspr));
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

    public void changeQuantity(String id, int nowQuantity, int buyQuantity) throws SQLException {
        try {
            conn = DBUntils.getcon();
            if (conn != null) {
                String sql = "  UPDATE tblProducts SET quantity = ? WHERE productid = ?";
                stm = conn.prepareStatement(sql);
                stm.setInt(1, (nowQuantity - buyQuantity));
                stm.setString(2, id);
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

    public void delete(String id) throws SQLException {
        try {
            conn = DBUntils.getcon();
            if (conn != null) {
                String sql = "UPDATE tblProducts SET status = 'false' WHERE productid = ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
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
     public boolean deletev2(String productID,String productIDN) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            String sql = "DELETE tblProducts WHERE productID=?";
            conn = DBUntils.getcon();
            if (productIDN.equals(productID)) {
                check = false;
            } else if (conn != null) {
                ptm = conn.prepareStatement(sql);
                ptm.setString(1, productID);
                check = ptm.executeUpdate() > 0 ? true : false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;
    }

    public boolean create(ProductDTO dto) throws Exception {
        boolean check = false;
        try {
            
            conn = DBUntils.getcon();
            String sql = "INSERT into tblProducts(productid,productname,image,price,quantity,categoryid,importDate,usingDate,status) values(?,?,?,?,?,?,?,?,?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getProductId());
            stm.setString(2, dto.getProductName());
            stm.setString(3, dto.getImage());
            stm.setDouble(4, dto.getPrice());
            stm.setInt(5, dto.getQuantity());
            stm.setString(6, dto.getCategoryid());
            stm.setString(7, dto.getImportDate());
            stm.setString(8, dto.getUsingDate());
            stm.setBoolean(9, dto.isStatus());
            
            check = stm.executeUpdate() > 0 ? true : false;
        }catch(Exception e){
            e.printStackTrace();
        
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();                 
            }
        }  
        return check;
    }

    public boolean upload(ProductDTO dto) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        boolean check = false;
        try {
            conn = DBUntils.getcon();
            String sql = "UPDATE tblProducts SET productname=?,image=?,price=?,quantity=?,categoryid=?, importDate = ?, usingDate = ?,status = ?  WHERE productid = ? ";
            stm = conn.prepareStatement(sql);
            stm.setString(1, dto.getProductName());
            stm.setString(2, dto.getImage());
            stm.setDouble(3, dto.getPrice());
            stm.setInt(4, dto.getQuantity());
            stm.setString(5, dto.getCategoryid());
            stm.setString(6, dto.getImportDate());
            stm.setString(7, dto.getUsingDate());
            stm.setBoolean(8, dto.isStatus());
            stm.setString(9, dto.getProductId());
            check = stm.executeUpdate() > 0 ? true : false;
        }catch(Exception e){
            e.printStackTrace();
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
        return check;
    }

    public boolean checkDuplicate(String productId) throws SQLException {
        boolean check = false;

        try {
            conn = DBUntils.getcon();
            if (conn != null) {
                String url = "SELECT productid FROM tblProducts WHERE  productid = ? ";
                stm = conn.prepareStatement(url);
                stm.setString(1, productId);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return check;
    }

    public boolean checkCategories(String cate) throws SQLException {
        boolean check = false;

        try {
            conn = DBUntils.getcon();
            if (conn != null) {
                String url = "SELECT categoryid FROM tblCategories WHERE  categoryid = ? ";
                stm = conn.prepareStatement(url);
                stm.setString(1, cate);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        return check;
    }
}
