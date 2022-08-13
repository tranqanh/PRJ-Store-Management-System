/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.OrderDAO;
import daos.OrderDetailDAO;
import daos.ProductDAO;
import dtos.CartDTO;
import dtos.OrderDTO;
import dtos.OrderDetailDTO;
import dtos.ProductDTO;
import dtos.UserDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "ConfirmController", urlPatterns = {"/ConfirmController"})
public class ConfirmController extends HttpServlet {
    private static final String ERROR = "checkout.jsp";
    private static final String SUCCESS = "viewCart.jsp";
    private static final String SUCCESS1 = "search.jsp";
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            HttpSession ses = request.getSession();
            UserDTO user = (UserDTO) ses.getAttribute("LOGIN_USER");
            OrderDAO dao = new OrderDAO();
            OrderDTO order = new OrderDTO();
            List<OrderDTO> dto = dao.getAllOrder();
            String userID = user.getUserId();
            String orderid = order.settOrderid(dto, userID);
            String date = java.time.LocalDate.now().toString();
            Double totalall = Double.parseDouble(request.getParameter("totalall"));
            order = new OrderDTO(orderid, userID, date, totalall,true);
            dao.insertToOrder(order);

            CartDTO cart = (CartDTO) ses.getAttribute("CART");
            OrderDetailDAO oda = new OrderDetailDAO();
            OrderDetailDTO odd = new OrderDetailDTO();
            ProductDAO prodao = new ProductDAO();
            for (ProductDTO prodcut : cart.getCart().values()) {
                List<OrderDetailDTO> listdetail = oda.getAllOrderDetail();
                int detailid = odd.settOrderDetailid(listdetail);
                String productid = prodcut.getProductId();
                String idorder = orderid;
                Double price = prodcut.getPrice();
                int quantity = prodcut.getQuantity();
                odd = new OrderDetailDTO(detailid, idorder, productid, price, quantity,true);
                oda.insertToOrderDetail(odd);
                
                ProductDTO pr = prodao.getAProduct(productid);
                prodao.changeQuantity(productid,pr.getQuantity(),quantity);
            }
            ses.setAttribute("CART", null);
            url = SUCCESS;
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
