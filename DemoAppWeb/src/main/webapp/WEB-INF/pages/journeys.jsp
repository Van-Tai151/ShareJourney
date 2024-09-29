<%-- 
    Document   : journey
    Created on : Jun 21, 2024, 10:05:56 AM
    Author     : Tài đẹp trai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-center text-info mt-3">QUẢN LÝ CHUYẾN ĐI</h1>

<c:url value="/journeys" var="action" />
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">${errMsg}</div>
</c:if>
<form:form method="post" modelAttribute="journey" action="${action}">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">       
        <form:input class="form-control" id="id" placeholder="ID" path="id" />
        <label for="name">ID</label>
    </div>
    <div class="form-floating mb-3 mt-3">      
        <form:input class="form-control" id="fromLocation" placeholder="Tên chuyến đi" path="fromLocation" />
        <label for="name">Tên chuyến đi</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="toLocation" placeholder="Tên điểm đến" path="toLocation" />
        <label for="name">Tên điểm đến</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input class="form-control" id="estimatedTime" placeholder="Thời gian đi" path="estimatedTime" />
        <label for="name">Thời gian đi </label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="category" name="category" path="categoryId">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${c.id == journey.categoryId.id}">
                        <option value="${c.id}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.id}">${c.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
    <label for="category" class="form-label">Select list (select one):</label>
    </div>
    <div class="form-floating mt-3">
        <button  type="submit" class="btn btn-primary mt-3" >Thêm chuyến đi</button>
    </div>

</form:form>

