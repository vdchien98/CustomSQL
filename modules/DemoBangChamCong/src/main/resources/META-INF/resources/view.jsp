<%@ include file="/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>




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

		<c:forEach var="NgayTrongThang" items="${danhSachNgayTrongThang}"
			varStatus="loop">
			<c:if test="${loop.index % 7 == 0}">
				<tr>
			</c:if>
			<td class="text-center" style="padding: 0;">${NgayTrongThang}</td>
			<c:if test="${loop.index % 7 == 6}">
				</tr>
			</c:if>
		</c:forEach>

	</tbody>
</table>



<%-- xử lý mở file Pdf --%>
<portlet:resourceURL var="pdfResourceURL"></portlet:resourceURL>
<a href="<%=pdfResourceURL%>">Mở file PDF</a>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://jquery-ui.googlecode.com/svn/trunk/ui/i18n/jquery.ui.datepicker-vi.js"></script>

<%-- xử lý datepiecker --%>
<form method="post">
	<input type="text" id="yourDatePickerId" name="yourDateFieldName">
	<input type="submit" value="Submit">
</form>

<style>
div#ui-datepicker-div {
	top: 212px;
}
</style>
<script>
	$(function() {
		$.datepicker.setDefaults($.datepicker.regional['vi']);

		$("#yourDatePickerId").datepicker({
			dateFormat : 'dd/mm/yy',
			changeMonth : true,
			changeYear : true
		});
	});
</script>

<script>
	$.datepicker.regional['vi'] = {
		closeText : 'Đóng',
		prevText : '&#x3C;Trước',
		nextText : 'Tiếp&#x3E;',
		currentText : 'Hôm nay',
		monthNames : [ 'Tháng 1', 'Tháng 2', 'Tháng 3', 'Tháng 4', 'Tháng 5',
				'Tháng 6', 'Tháng 7', 'Tháng 8', 'Tháng 9', 'Tháng 10',
				'Tháng 11', 'Tháng 12' ],
		monthNamesShort : [ 'Th1', 'Th2', 'Th3', 'Th4', 'Th5', 'Th6', 'Th7',
				'Th8', 'Th9', 'Th10', 'Th11', 'Th12' ],
		dayNames : [ 'Chủ Nhật', 'Thứ Hai', 'Thứ Ba', 'Thứ Tư', 'Thứ Năm',
				'Thứ Sáu', 'Thứ Bảy' ],
		dayNamesShort : [ 'CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7' ],
		dayNamesMin : [ 'CN', 'T2', 'T3', 'T4', 'T5', 'T6', 'T7' ],
		weekHeader : 'Tu',
		dateFormat : 'dd/mm/yy',
		firstDay : 0,
		isRTL : false,
		showMonthAfterYear : false,
		yearSuffix : ''
	};
</script>
