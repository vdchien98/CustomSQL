<%@ include file="/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
 
 
 
<table class="table table-bordered">
    <thead>
        <tr class="text-center text-white">
            <th style="padding: 0;" class="bg-info">T2</th>
            <th style="padding: 0;" class="bg-info">T3</th>
            <th style="padding: 0;" class="bg-info">T4</th>
            <th style="padding: 0;" class="bg-info">T5</th>
            <th style="padding: 0;" class="bg-info">T6</th>
            <th style="padding: 0;" class="bg-warning">T7</th>
            <th style="padding: 0;" class="bg-warning">CN</th>
        </tr>
    </thead>
    <tbody>
 
    <%--comment --%>     
        <c:choose>
                <c:when test="${ThuDauTiencuaThang == 2}">
                 <c:forEach var="NgayTrongThang" items="${danhSachNgayTrongThang}" varStatus="loop">
							<c:if test="${loop.index % 7 == 0}">
								<tr>
							</c:if>
							    <td class="text-center" style="padding: 0;">
										   ${NgayTrongThang}
								</td>
							<c:if test="${loop.index % 7 == 6}">
								</tr>
							</c:if>
						</c:forEach>
                </c:when>
                 <c:when test="${ThuDauTiencuaThang == 3}">
                 <c:forEach var="NgayTrongThang" items="${danhSachNgayTrongThang}" varStatus="loop">
							<c:if test="${loop.index % 7 == 0}">
								<tr>
							</c:if>
							    <td class="text-center" style="padding: 0;">
										   ${NgayTrongThang}
								</td>
							<c:if test="${loop.index % 7 == 6}">
								</tr>
							</c:if>
						</c:forEach>
                </c:when>
                 <c:when test="${ThuDauTiencuaThang == 4}">
                 <c:forEach var="NgayTrongThang" items="${danhSachNgayTrongThang}" varStatus="loop">
							<c:if test="${loop.index % 7 == 0}">
								<tr>
							</c:if>
							    <td class="text-center" style="padding: 0;">
										   ${NgayTrongThang}
								</td>
							<c:if test="${loop.index % 7 == 6}">
								</tr>
							</c:if>
						</c:forEach>
                </c:when>
                 <c:when test="${ThuDauTiencuaThang == 5}">
                 <c:forEach var="NgayTrongThang" items="${danhSachNgayTrongThang}" varStatus="loop">
							<c:if test="${loop.index % 7 == 0}">
								<tr>
							</c:if>
							    <td class="text-center" style="padding: 0;">
										   ${NgayTrongThang}
								</td>
							<c:if test="${loop.index % 7 == 6}">
								</tr>
							</c:if>
						</c:forEach>
                </c:when>
                 <c:when test="${ThuDauTiencuaThang == 6}">
				      <c:forEach var="NgayTrongThang" items="${danhSachNgayTrongThang}" varStatus="loop">
							<c:if test="${loop.index % 7 == 0}">
								<tr>
							</c:if>
							    <td class="text-center" style="padding: 0;">
										   ${NgayTrongThang}
								</td>
							<c:if test="${loop.index % 7 == 6}">
								</tr>
							</c:if>
						</c:forEach>
                </c:when>
                 <c:when test="${ThuDauTiencuaThang == 7}">
                 <c:forEach var="NgayTrongThang" items="${danhSachNgayTrongThang}" varStatus="loop">
							<c:if test="${loop.index % 7 == 0}">
								<tr>
							</c:if>
							    <td class="text-center" style="padding: 0;">
										   ${NgayTrongThang}
								</td>
							<c:if test="${loop.index % 7 == 6}">
								</tr>
							</c:if>
						</c:forEach>
                </c:when>
                 <c:when test="${ThuDauTiencuaThang == 8}">
                 <c:forEach var="NgayTrongThang" items="${danhSachNgayTrongThang}" varStatus="loop">
							<c:if test="${loop.index % 7 == 0}">
								<tr>
							</c:if>
							    <td class="text-center" style="padding: 0;">
										   ${NgayTrongThang}
								</td>
							<c:if test="${loop.index % 7 == 6}">
								</tr>
							</c:if>
						</c:forEach>
                </c:when>
                <c:otherwise>
                   
                   
                </c:otherwise>
         </c:choose>
    
    </tbody>
</table>