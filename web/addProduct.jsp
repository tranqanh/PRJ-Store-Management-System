
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <style type="text/css">
            form  { display: table;      }
            p     { display: table-row;  }
            label { display: table-cell; }
            input { display: table-cell; }
        </style>

    </head>
    <body>
    <center>
        <h1>Create new Food!</h1>
        <form action="MainController" method="POST">
                <table border="1">
                    <tbody>
                        <tr>
                            <td>Product ID</td>
                            <td>
                                <input type="text" name="productId" value="" placeholder="ProductID">
                            </td>
                        </tr>
                        <tr>
                            <td>Product Name</td>
                            <td>
                                <input type="text" name="productName" value="" placeholder="ProductName">
                            </td>
                        </tr>
                        <tr>
                            <td>Image</td>
                            <td>
                                <input type="text" name="image" value="" placeholder="Image">
                            </td>
                        </tr>
                        <tr>
                            <td>Price($)</td>
                            <td>
                                <input type="text" name="price" value="" placeholder="Price">
                            </td>
                        </tr>
                        <tr>
                            <td>Quantity</td>
                            <td>
                               <input type="text" name="quantity" value="" placeholder="Quantity">
                            </td>
                        </tr>
<tr>
                            <td>Category ID</td>
                            <td>
                                <select name="categoryID">
                                    <option value="F1">F1(Vegetable)</option>
                                    <option value="F2">F2(Meat)</option>
                                    <option value="F3">F3(Fish)</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Import Date</td>
                            <td>
                               <input type="date" name="importDate" value="" placeholder="ImportDate">
                            </td>
                        </tr>
                        <tr>
                            <td>Using Date</td>
                            <td>
                                <input type="date" name="usingDate" value="" placeholder="ImportDate">
                            </td>
                        </tr>
                        <td>Status</td>
                            <td>
                                <select name="status">
                                    <option value="true">True</option>
                                    <option value="F2">False</option>
                                </select>
                            </td>

                    </tbody>
                </table>

                <input type="submit" name="action" value="Create">
                <input type="submit" name="action" value="Back">
                </form>
                </center> 
                </body>
                </html>
