

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <title>Detail Page</title>
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
                margin-right: auto;
            }  th{
            text-align: center;
        }           

        </style>
    </head>
    <body>
        <h1>Detail</h1>
        <form action="MainController">
            <input type="submit" name="action" value="View Cart" />   
            <input type="hidden" name="id" value="${requestScope.DETAIL_PRODUCT.quantity}" /> 
            <input type="submit" name="action" value="Return"/>
        </form>
        <c:if test="${ requestScope.DETAIL_PRODUCT != null }">
            <c:if test="${ not empty requestScope.DETAIL_PRODUCT }">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Product Id</th>
                            <th>Product Name</th>
                            <th>Img</th>
                            <th>Product Price</th>
                            <th>Product Quantity</th>
                            <th>Category Id</th>
                            <th>Buy Quantity</th>
                            <th>UsingDate</th>
                            <th>Add to cart</th>
                        </tr>
                    </thead>
                    <tbody>

                    <form action="MainController">
                        <tr>
                            <td> ${ requestScope.DETAIL_PRODUCT.productId} </td>
                            <td> ${ requestScope.DETAIL_PRODUCT.productName} </td>
                            <td><img src="${ requestScope.DETAIL_PRODUCT.image}" width="90" height="90" /></td>
                            <td> ${ requestScope.DETAIL_PRODUCT.price} </td>
                            <td> ${ requestScope.DETAIL_PRODUCT.quantity} </td>
                            <td> ${ requestScope.DETAIL_PRODUCT.categoryid} </td>
                            <td>
                                <input type="number" min="1" max="${ requestScope.DETAIL_PRODUCT.quantity }" name="quantity" value="0" required="true" />
                            </td>
                            <td>${ requestScope.DETAIL_PRODUCT.importDate}</td>
                            <td>
                                <input type="submit" name="action" class="btn btn-success btn-xs" value="Add"/>
                                <input type="hidden" name="productId" value="${ requestScope.DETAIL_PRODUCT.productId }"/>
                                <input type="hidden" name="image" value="${ requestScope.DETAIL_PRODUCT.image }"/>
                                <input type="hidden" name="realQuantity" value="${ requestScope.DETAIL_PRODUCT.quantity }"/>
                                 
                            </td>
                        </tr>
                    </form>
                </tbody>
            </table>
        </c:if>
    </c:if>
    <h1>
        ${ requestScope.MESSAGE }
    </h1>
</body>
</html>
