<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add / Update category</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container mt-4">
            <h1>Add / Update category</h1>
            <form:form action="${pageContext.request.contextPath}/categories/add" method="post" modelAttribute="category">
                <form:hidden path="id"/>
                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <form:input path="name" class="form-control" required="true"/>
                    <form:errors path="name" cssClass="text-danger"/>
                <div class="mb-3">
                    <label for="note" class="form-label">Note</label>
                    <form:input path="note" class="form-control" required="true"/>
                    <form:errors path="note" cssClass="text-danger"/>
                </div>
                <button type="submit" class="btn btn-primary">Save</button>
                <a href="${pageContext.request.contextPath}/categories" class="btn btn-secondary">Return</a>
            </form:form>
        </div>
    </body>
</html>
