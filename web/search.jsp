

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <style type="text/css">
            form {
                text-align: center;
            }
            h1 {
                text-align: center;
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
        <title>Search Food</title>
    </head>
    <body>
        <h1>Welcome: ${sessionScope.LOGIN_USER.fullName} </h1>
        <form action = "MainController">
            <input type="submit" name="action" value="Logout" />
        </form>

        <form action="MainController">
            <input type="text" name="search" value="${ param.search }" />
            <input type="submit" name="action" value="Search"/>
            <input type="submit" name="action" value="Get All"/>  
            <input type="submit" name="action" value="View Cart" />
        </form>
        <style>
            .custab{
                border: 1px solid #ccc;
                padding: 5px;
                margin: 5% 0;
                box-shadow: 3px 3px 2px #ccc;
                transition: 0.5s;
            }
            .custab:hover{
                box-shadow: 3px 3px 0px transparent;
                transition: 0.5s;
            }
        </style>

        <c:if test="${ requestScope.LIST_PRODUCT != null }">
            <c:if test="${ not empty requestScope.LIST_PRODUCT }">
                <table border="1"  width="1000">
                    <!--                    class="table table-striped custab"-->
                    <thead>
                        <tr>
                            <th width="25%">Product Name</th>
                            <th width="25%">Image</th>
                            <th width="25%">Product Price</th>
                            <th width="25%">Product Quantity</th>
                            <th width="25%">View Detail</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="product" varStatus="counter" items="${requestScope.LIST_PRODUCT}"> 
                            <tr>
                                <td>${ product.productName}</td>
                                <td><img src="${product.image}" width="90" height="90" /></td>
                                <td>${ product.price}</td>
                                <td>${ product.quantity}</td>
                                <td>
                                    <a href="MainController?search=${param.search}&action=View&productid=${product.productId}" >View Detail<a>
                                            </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                        </table>
                                    </c:if>
                                </c:if>
                                </body>
                                </html>
