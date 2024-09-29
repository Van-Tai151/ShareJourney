<%-- 
    Document   : index
    Created on : Jun 20, 2024, 8:24:30 PM
    Author     : Tài đẹp trai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info mt-1">QUẢN TRỊ TẤT CẢ CÁC CHUYẾN ĐI</h1>
<div>
    <a class="btn btn-info mt-3" href="<c:url value="/journeys"/>">Thêm Chuyến Đi</a>
</div>
<div>
    <a class="btn btn-danger mt-3" href="<c:url value="/ratings"/>">Thêm Thành Viên Vào Chuyến Đi</a>
</div>
<table class="table table-striped mt-3">
    <tr>
        <th>Id</th>
        <th>Điểm đi</th>
        <th>Điểm đến</th>
        <th>Thời Gian</th>
        <th></th>
    </tr>
    <c:forEach items="${journeys}" var="j">
        <tr>
            <td>${j.id}</td>
            <td>${j.fromLocation}</td>
            <td>${j.toLocation}</td>
            <td>${j.estimatedTime}</td>
            <td>
                <c:url value="/journeys/${j.id}" var="url" />
                <c:url value="/api/journeys/${j.id}/" var="urlDelete" />
                <button class="btn btn-danger" onclick="deleteJourney('${urlDelete}', ${j.id})">Xóa</button>
                <a href="${url}" class="btn btn-info">Cập nhật</a>

            </td>

        </tr>
    </c:forEach>
</table>
<script>
    function deleteJourney(url, journeyId) {
        if (confirm("Bạn chắc chắn xóa không?") === true) {
            fetch(url, {
                method: "delete"
            }).then(res => {
                if (res.status === 204)
                    location.reload();
                else
                    alert("Something wrong!");

            });
        }
    }
</script>