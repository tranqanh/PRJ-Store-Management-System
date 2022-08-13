

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <title>Your Cart!</title>
    </head><style type="text/css">
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
        a {
            text-align: center;
            margin-left: auto; 
            margin-right: auto
        }  th{
            text-align: center;
        }
    </style>
</head>
<body>
    <h1>Your selected Food!</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Product id</th>
                <th>Product Name</th>
                <th>Img</th>
                <th>Product Price</th>
                <th>Buy quantity</th>
                <th>Category Id</th>
                <th>TOTAL</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="list" value="${sessionScope.CART.cart.values()}"/>
            <c:if test="${ list != null }">
                <c:if test="${ not empty list }">
                    <c:set var="total" value=""/>
                    <c:forEach var="cart" varStatus="counter" items="${list}" >

                    <form action="MainController">
                        <tr>
                            <td>${ cart.productId } </td>
                            <td>${ cart.productName } </td>
                            <td><img src="${cart.image}" width="90" height="90" /></td>
                            <td>${ cart.price } </td>
                            <td>            
                                <input type="number" min="1" max="${param.realQuantity}"  name="quantity" value="${ cart.quantity }" required="true" />
                            </td>
                            <td>${ cart.categoryid } </td>
                            <td>${cart.price *  cart.quantity}</td>
                            <c:set var="totalof1" value="${cart.price *  cart.quantity}"/>
                            <c:set var="total" value="${total   + totalof1}"/>
                            <td>
                                <input type="submit" name="action" class="btn btn-success btn-xs" value="update"/>
                            </td>
                            <td>
                                <input type="submit" name="action" class="btn btn-danger btn-xs" value="delete"/>
                                <input type="hidden" name="proid" value="${ cart.productId }"/>
                            </td>
                        </tr>
                    </form>
                </c:forEach>
            </c:if>
        </c:if>
    </tbody>
</table>
<a> Total All:${total}</a></br>


<a href="MainController?action=add_more" > Add More </a></br>
<a href="MainController?action=Checkout" > Confirm</a></br>
</body>
</html>
