<%-- 
    Document   : header
    Created on : Jun 21, 2024, 5:20:19 AM
    Author     : Tài đẹp trai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Journey App</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="/" />">TRANG CHỦ</a>
                </li>

                <c:forEach items="${categories}" var="c">
                    <li class="nav-item">
                        <c:url value="/" var="myUrl">
                            <c:param name="cateId" value="${c.id}" />
                        </c:url>
                        <a class="nav-link" href="${myUrl}">${c.name}</a>
                    </li>
                </c:forEach>
                <li class="nav-item">
                    <a class="nav-link text-danger" href="<c:url value="/reports" />">BÁO CÁO</a>
                </li>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li class="nav-item">
                            <a class="nav-link text-info" href="<c:url value="/login" />">Đăng nhập</a>
                        </li>
                    </c:when>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/" />">Chào ${pageContext.request.userPrincipal.name}!</a>
                        </li>
                        <li class=""nav-item">
                            <a class="nav-link text-info" href="<c:url value="/logout" />">Đăng xuất</a>
                        </li>
                    </c:when>
                </c:choose>
            </ul>
            <form action="<c:url value="/" />" class="d-flex">
                <input class="form-control me-2" name="kw" type="text" placeholder="Nhập tên...">
                <button class="btn btn-primary" type="submit">Tìm</button>
            </form>
        </div>
    </div>
</nav>
