<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <title>Car Rental Management</title>
        <!-- Dẫn Bootstrap từ CDN -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <style>
            /* Custom CSS để tạo khoảng cách giữa các card và làm tiêu đề bảng nổi bật */
            .card {
                margin-bottom: 20px;
            }
            .card-header {
                background-color: #007bff;
                color: white;
                font-weight: bold;
            }
            .btn-add {
                float: right;
            }
            .table thead th {
                background-color: #e9ecef;
            }
        </style>
    </head>
    <body>
        <!-- Thanh điều hướng đơn giản -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Car Rental Management</a>
        </nav>

        <div class="container mt-4">
            <!-- Branch Card -->
            <div class="card">
                <div class="card-header">
                    Branch List
                    <a href="${pageContext.request.contextPath}/branches/add" class="btn btn-success btn-sm btn-add">Add / Update Branch</a>
                </div>
                <div class="card-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Number</th>
                                <th>Manager</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="branch" items="${branches}">
                                <tr>
                                    <td>${branch.id}</td>
                                    <td>${branch.name}</td>
                                    <td>${branch.address}</td>
                                    <td>${branch.number}</td>
                                    <td>${branch.manager_id}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/branches/edit/${branch.id}" class="btn btn-warning btn-sm">Edit</a>
                                        <a href="${pageContext.request.contextPath}/branches/delete/${branch.id}" class="btn btn-danger btn-sm" onclick="return confirm('You sure want to delete?')">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Car Card -->
            <div class="card">
                <div class="card-header">
                    Car List
                    <a href="${pageContext.request.contextPath}/cars/add" class="btn btn-success btn-sm btn-add">Add / Update Car</a>
                </div>
                <div class="card-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Brand</th>
                                <th>Year</th>
                                <th>Category ID</th>
                                <th>Branch ID</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="car" items="${cars}">
                                <tr>
                                    <td>${car.id}</td>
                                    <td>${car.name}</td>
                                    <td>${car.brand}</td>
                                    <td>${car.year}</td>
                                    <td>${car.category_id}</td>
                                    <td>${car.branch_id}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/cars/edit/${car.id}" class="btn btn-warning btn-sm">Edit</a>
                                        <a href="${pageContext.request.contextPath}/cars/delete/${car.id}" class="btn btn-danger btn-sm" onclick="return confirm('You sure want to delete?')">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Category Card -->
            <div class="card">
                <div class="card-header">
                    Category List
                    <!-- Sửa lại đường dẫn nếu cần thiết, đảm bảo thống nhất: categories chứ không phải catogories -->
                    <a href="${pageContext.request.contextPath}/categories/add" class="btn btn-success btn-sm btn-add">Add / Update Category</a>
                </div>
                <div class="card-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Note</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="category" items="${categories}">
                                <tr>
                                    <td>${category.id}</td>
                                    <td>${category.name}</td>
                                    <td>${category.note}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/categories/edit/${category.id}" class="btn btn-warning btn-sm">Edit</a>
                                        <a href="${pageContext.request.contextPath}/categories/delete/${category.id}" class="btn btn-danger btn-sm" onclick="return confirm('You sure want to delete?')">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Customer Card -->
            <div class="card">
                <div class="card-header">
                    Customer List
                    <a href="${pageContext.request.contextPath}/customers/add" class="btn btn-success btn-sm btn-add">Add / Update Customer</a>
                </div>
                <div class="card-body">
                    <table class="table table-bordered table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Number</th>
                                <th>Address</th>
                                <th>Email</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="customer" items="${customers}">
                                <tr>
                                    <td>${customer.id}</td>
                                    <td>${customer.name}</td>
                                    <td>${customer.number}</td>
                                    <td>${customer.address}</td>
                                    <td>${customer.email}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/customers/edit/${customer.id}" class="btn btn-warning btn-sm">Edit</a>
                                        <a href="${pageContext.request.contextPath}/customers/delete/${customer.id}" class="btn btn-danger btn-sm" onclick="return confirm('You sure want to delete?')">Delete</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

        <!-- Scripts cần thiết cho Bootstrap -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
