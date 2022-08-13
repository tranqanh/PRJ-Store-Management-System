/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String SEARCH = "SearchController";
    private static final String GET_ALL = "GetAllController";
    private static final String VIEW_DETAIL = "viewDetailController";
    private static final String ADD = "AddController";
    private static final String VIEW_CART = "viewCartController";
    private static final String ADD_MORE = "customerController";
    private static final String CONFIRM = "ConfirmController";
    private static final String LOGOUT = "LogoutController";
    private static final String DELETE = "DeleteController";
    private static final String UPDATE = "UpdateController";
    private static final String ADMIN_DELETE = "AdminDeleteController";
    private static final String ADD_PRODUCT = "addProduct.jsp";
    private static final String CREATECONTROLLER = "CreateController";
    private static final String UPDATE_PRODUCT = "updateProduct.jsp";
    private static final String UPDATECONTROLLER = "updateProductController";
    private static final String BACK = "adminController";
    private static final String RETURN = "customerController";
    private static final String CHECKOUT = "checkout.jsp";
    

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
            String action = request.getParameter("action");
            if ("Login".equals(action)) {
                url = LOGIN;
            } else if ("View".equals(action)) {
                url = VIEW_DETAIL;
            } else if ("Search".equals(action)) {
                url = SEARCH;
            } else if ("Get All".equals(action)) {
                url = GET_ALL;
            } else if ("Add".equals(action)) {
                url = ADD;
            } else if ("View Cart".equals(action)) {
                url = VIEW_CART;
            } else if ("add_more".equals(action)) {
                url = ADD_MORE;
            } else if ("confirm".equals(action)) {
                url = CONFIRM;
            } else if ("Logout".equals(action)) {
                url = LOGOUT;
            } else if ("delete".equals(action)) {
                url = DELETE;
            } else if ("update".equals(action)) {
                url = UPDATE;
            } else if ("Delete".equals(action)) {
                url = ADMIN_DELETE;
            } else if ("Add Product".equals(action)) {
                url = ADD_PRODUCT;
            } else if ("Create".equals(action)) {
                url = CREATECONTROLLER;
            } else if ("Update Product".equals(action)) {
                url = UPDATE_PRODUCT;
            } else if ("Upload".equals(action)) {
                url = UPDATECONTROLLER;
            }else if ("Back".equals(action)) {
                url = BACK;
            }else if ("Return".equals(action)) {
                url = RETURN;
            }else if ("Checkout".equals(action)) {
                url = CHECKOUT;
            }

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
