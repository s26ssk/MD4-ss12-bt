<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Edit Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="d-flex justify-content-center">
        <div class="col-lg-6 mt-5">
            <h1 class="text-center mb-3">Edit Category</h1>
            <form:form action="/category/update/${category.categoryId}" method="post" modelAttribute="category">
                <div class="form-group">
                    <label>CategoryId:</label>
                    <form:input class="form-control" type="text" path="categoryId" value="${category.categoryId}"
                                readonly="true"/>
                </div>
                <div class="form-group">
                    <label>Category Name:</label>
                    <form:input class="form-control" type="text" path="categoryName" value="${category.categoryName}"/>
                </div>
                <div class="form-group">
                    <label>Select Status:</label>
                    <form:select class="form-control" path="status">
                        <option value="true" ${category.status ? "selected" : ""}>Đang hoạt động</option>
                        <option value="false" ${!category.status ? "selected" : ""}>Dừng hoạt động</option>
                    </form:select>
                </div>
                <input class="btn btn-primary" type="submit" value="Update"/>
            </form:form>
        </div>
    </div>
</div>
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
