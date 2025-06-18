<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add / Update car</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-4">
            <h1>Add / Update car</h1>
            <form:form action="${pageContext.request.contextPath}/cars/add" method="post" modelAttribute="car">
                <form:hidden path="id"/>
                <div class="mb-3">
                    <label for="name" class="form-label">Car name</label>
                    <form:input path="name" class="form-control" required="true"/>
                    <form:errors path="name" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="brand" class="form-label">Car brand</label>
                    <form:input path="brand" class="form-control" required="true"/>
                    <form:errors path="brand" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="year" class="form-label">Year</label>
                    <form:input path="year" class="form-control" required="true"/>
                    <form:errors path="year" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="category_id" class="form-label">Category</label>
                    <form:input path="category_id" class="form-control" required="true"/>
                    <form:errors path="category_id" cssClass="text-danger"/>
                </div>
                <div class="mb-3">
                    <label for="branch_id" class="form-label">Branch</label>
                    <form:input path="branch_id" class="form-control" required="true"/>
                    <form:errors path="branch_id" cssClass="text-danger"/>
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
                <a href="${pageContext.request.contextPath}/main" class="btn btn-secondary">Return</a>
            </form:form>
        </div>
    </body>
</html>
</html>
