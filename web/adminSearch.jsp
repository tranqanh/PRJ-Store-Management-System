
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    </head>
    <style type="text/css">
        form {
            text-align: center;
        }
        h1 {
            text-align: center;
            color: red;
        }
        table{
            text-align: center;
            margin-left: auto; 
            margin-right: auto
        }
        th{
            text-align: center;
        }
    </style>
    <title>Admin Search Food</title>
</head>

<body>
<center>
    <!-- xac thuc phan quyen sih vien tu lam -->
         <c:if test="${sessionScope.LOGIN_USER == null or sessionScope.LOGIN_USER.roleId ne 'AD'}">
             <c:redirect url="login.jsp"></c:redirect>
         </c:if>
    <h1>WELCOME ${sessionScope.LOGIN_USER.fullName} ! </h1>
    <form action = "MainController">
        <input type="submit" name="action" value="Logout" />
    </form>

    <form action="MainController">
        <input type="text" name="search" value="${ param.search }" />
        <select  name="statusSearch">
            <option value="true">Avaiable</option>
            <option value="false">Deleted</option>
        </select>
        <input type="submit" name="action" value="Search"/> 
        <input type="submit" name="action" value="Get All"/> 
        <input type="submit" name="action" value="Add Product" />



        <style>
            .custab{
                border: 1px solid #ccc;
                padding: 1px;
                margin: 5% 0;
                box-shadow: 3px 3px 2px #ccc;
                transition: 0.5s;
            }
            .custab:hover{
                box-shadow: 3px 3px 0px;
                transition: 0.5s;
            }
        </style>
        <c:if test="${ requestScope.LIST_PRODUCT != null }">
            <c:if test="${ not empty requestScope.LIST_PRODUCT }">
                <div class="container">
                    <form action="MainController">

                        <table border="1" class="table table-striped custab">
                            <thead>
                                <tr>
                                    <th>Product Name</th>
                                    <th>Img</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Update</th>
                                    
                                    <th>
                                        Delete
                                    </th>
                                </tr>
                            </thead>
                            <c:forEach var="product" varStatus="counter" items="${requestScope.LIST_PRODUCT}"> 
                                <form action="MainController">
                                    <tr>
                                        <td>${ product.productName }</td>
                                        <td><img src="${product.image}" width="90" height="90" /></td>
                                        <td>${ product.price }</td>
                                        <td>${ product.quantity }</td>
                                        <td>
                                            <input type="submit" name="action" class="btn btn-success btn-xs" value="Update Product"/>   
                                            <input type="hidden" name="productId" value="${product.productId}"/>
                                            <input type="hidden" name="productName" value="${product.productName}">
                                            <input type="hidden" name="image" value="${product.image}">
                                            <input type="hidden" name="price" value="${product.price}">
                                            <input type="hidden" name="quantity" value="${product.quantity}">
                                            <input type="hidden" name="categoryId" value="${product.categoryid}">  
                                            <input type="hidden" name="importDate" value="${product.importDate}">
                                            <input type="hidden" name="usingDate" value="${product.usingDate}">
                                            <input type="hidden" name="status" value="${product.status}">
                                        </td>
                                        <td>
                                            <input type="submit" name="action" class="btn btn-danger btn-xs" value="Delete" />
                                            
                                            
                                        </td> 
                                    </tr>
                                </form>
                            </c:forEach>
                        </table>
                    </form>
                </div>
            </c:if>
        </c:if>
</center>

</body>
</html>
