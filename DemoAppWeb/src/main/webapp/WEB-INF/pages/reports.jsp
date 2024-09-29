<%-- 
    Document   : reports
    Created on : Jun 21, 2024, 9:54:45 PM
    Author     : Tài đẹp trai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-info mt-3">QUẢN LÝ REPORT</h1>
<table class="table table-striped mt-3">
    <tr>
        <th>ID</th>
        <th>Người Report</th>
        <th>Lý do</th>
        <th>Chuyến đi</th>
    </tr>
    <c:forEach items="${reports}" var="r">
        <tr>
            <td>${r.id}</td>
            <td>${r.reported_user_id}</td>
            <td>${r.reason}</td>
            <td>${r.journey_id}</td>

        </tr>
    </c:forEach>
</table>