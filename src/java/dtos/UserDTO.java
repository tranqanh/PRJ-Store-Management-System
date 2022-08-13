/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Admin
 */
public class UserDTO {

    String userId;
    String fullName;
    String password;
    String roleId;
    String address;
    String birthday;
    String phone;
    String status;
    String email;

    public UserDTO() {
        this.userId = "";
        this.fullName = "";
        this.password = "";
        this.roleId = "";
        this.address = "";
        this.birthday = "";
        this.phone = "";
        this.status = "";
        this.email = "";
    }

    public UserDTO(String userId, String fullName, String password, String roleId, String address, String birthday, String phone, String status, String email) {
        this.userId = userId;
        this.fullName = fullName;
        this.password = password;
        this.roleId = roleId;
        this.address = address;
        this.birthday = birthday;
        this.phone = phone;
        this.status = status;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
}