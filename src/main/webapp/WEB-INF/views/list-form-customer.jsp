<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add / Update customer</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-4">
            <h1>Add / Update customer</h1>
            <form:form action="${pageContext.request.contextPath}/customers/save" method="post" modelAttribute="customer">
                <form:hidden path="id"/>
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <form:input path="name" class="form-control" required="true"/>
                    <form:errors path="name" cssClass="text-danger"/>
                <div class="mb-3">
                    <label for="number" class="form-label">Number</label>
                    <form:input path="number" class="form-control" required="true"/>
                    <form:errors path="number" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <form:input path="address" class="form-control" required="true"/>
                    <form:errors path="address" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <form:input path="email" class="form-control" required="true"/>
                    <form:errors path="email" cssClass="text-danger"/>
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
                <a href="${pageContext.request.contextPath}/customers" class="btn btn-secondary">Return</a>
            </form:form>
        </div>
    </body>
</html>
