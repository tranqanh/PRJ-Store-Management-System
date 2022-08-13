/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class CartDTO {

    private Map<String, ProductDTO> cart;
    String id ;
    int quantity;

    public void setId(String id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public CartDTO(String id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
    
    public CartDTO() {
    }

    public CartDTO(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public Map<String, ProductDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, ProductDTO> cart) {
        this.cart = cart;
    }

    public void add(ProductDTO product) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        if (this.cart.containsKey(product.getProductId())) {
            int quantity = this.cart.get(product.getProductId()).getQuantity();
            product.setQuantity(quantity + product.getQuantity());
        }
        cart.put(product.getProductId(), product);
    }

    public void delete(String id) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

    public void update(String id, ProductDTO product) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.replace(id, product);
        }
    }
}
