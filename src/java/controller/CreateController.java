/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import daos.ProductDAO;
import dtos.ProductDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR = "addProduct.jsp";
    private static final String SUCESS = "adminController";

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
           String productId = request.getParameter("productId").trim();
            String productName = request.getParameter("productName").trim();
            String image = request.getParameter("image").trim();
            String price = request.getParameter("price").trim();
            String quantity = request.getParameter("quantity").trim();
            String categoryId = request.getParameter("categoryID").trim();
            String importDate = request.getParameter("importDate").trim();
            String usingDate = request.getParameter("usingDate").trim();
            String status = request.getParameter("status").trim();
            ProductDAO dao = new ProductDAO();
            boolean checkDuplicate = dao.checkDuplicate(productId);
            ProductDTO dto = new ProductDTO(productId, productName,image, Double.parseDouble(price), Integer.parseInt(quantity), categoryId, importDate, usingDate,Boolean.parseBoolean(status));
            boolean check = dao.create(dto);
            if (check) {
                url = SUCESS;
            }
        } catch (Exception e) {
            if(e.toString().contains("duplicate")){
                System.out.println("Trung productID");
            }
            log("Loi tai CreateController"+e.toString());
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
