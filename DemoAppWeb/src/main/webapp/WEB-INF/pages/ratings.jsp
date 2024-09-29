<%-- 
    Document   : ratings
    Created on : Jun 30, 2024, 3:34:47 AM
    Author     : Tài đẹp trai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info mt-3">Quản Lý Hành Khách Tham Gia</h1>

<c:url value="/ratings" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<form:form method="post" modelAttribute="rating" action="${action}">
    <div class="form-floating mb-3 mt-3">       
        <form:input class="form-control" id="score" placeholder="Điểm" path="score" />
        <label for="name">Điểm</label>
    </div>
    <div class="form-floating mb-3 mt-3">       
        <form:input class="form-control" id="comment" placeholder="Bình Luận" path="comment" />
        <label for="name">Bình Luận</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="journey" name="journey" path="journeyId">
            <c:forEach items="${journeys}" var="j">
                <c:choose>
                    <c:when test="${j.id == rating.journeyId.id}">
                        <option value="${j.id}" selected>${j.fromLocation}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${j.id}">${j.fromLocation}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="journey" class="form-label">Select list (select one):</label>
    </div>
    <div class="form-floating mt-3">
        <button  type="submit" class="btn btn-primary mt-3" >Thêm vào chuyến đi</button>
    </div>

</form:form>