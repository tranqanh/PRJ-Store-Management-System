
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Upload Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
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
        </style>
    <body>
        <h1>Upload Food!</h1>
        <form action="MainController">
            Food Id    <input type="text" name="productId" value="${param.productId}" readonly=""></br>
            Name        <input type="text" name="productName" value="${param.productName}"></br>
            Price       <input type="text" name="price" value="${param.price}"></br>
            Quantity    <input type="text" name="quantity" value="${param.quantity}"></br>
            Category Id <input type="text" name="categoryId" value="${param.categoryId}"></br>
            ImportDate <input type="text" name="importDate" value="${param.importDate}"></br>
            UsingDate <input type="text" name="usingDate" value="${param.usingDate}"></br>
            Img Link    <input type="text" name="image" value="${param.image}"></br>
            Status <input type="text" name="status" value="${param.status}" ></br>
            <input type="submit" name="action" value="Upload">
            <input type="submit" name="action" value="Back"></br>
        </form>
    </body>
</html>
