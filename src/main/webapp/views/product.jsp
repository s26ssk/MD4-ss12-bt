<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Product List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-center">
        <div class="col-lg-12 mt-4 ">
            <h1 class="text-center mb-3">Product List</h1>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>Product Code</th>
                    <th>Product Name</th>
                    <th>Product Price</th>
                    <th>Category Name</th>
                    <th>Action</th>
                </tr>
                </thead>
                <c:forEach items="${products}" var="product">
                    <tr>
                        <td>${product.productCode}</td>
                        <td>${product.productName}</td>
                        <td>${product.productPrice}</td>
                        <td>${product.category.categoryName}</td>
                        <td>
                            <a class="btn btn-warning" href="/product/edit/${product.productCode}">Edit</a>
                            <a class="btn btn-danger" href="/product/delete/${product.productCode}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <a class="btn btn-success" href="/product/create">Add New Product</a>
        </div>
    </div>
</div>
<br>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>
