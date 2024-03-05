<%@ include file="/init.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/2.0.0/css/dataTables.bootstrap4.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

<%-- nhúng đoạn này vào để thêm giây trong popup --%>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
	integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
	crossorigin="anonymous"></script>
</head>


<style>
/* đây là css Popup mở ra  */
.modal-header.thongbao {
	background: #1d61a9;
	text-align: center;
	color: white;
}

.form-group.Box {
	display: flex;
	margin-bottom: -10px;
	/* flex-direction: row; */
}

p.box1 {
	margin-right: 5px;
	font-size: 20px;
	font-weight: 400;
}

div#timer {
	margin-left: 5px;
	font-size: 20px;
	font-weight: bold;
	color: red;
}

p.box3 {
	margin-left: 5px; 
	font-size : 20px;
	font-weight: 400;
	font-size: 20px;
}

label.col-form-label.mxn {
    font-size: 20px;
}

</style>




<portlet:renderURL var="addEntryURL">
	<portlet:param name="mvcPath" value="/addName.jsp"></portlet:param>
</portlet:renderURL>

<aui:button-row>
	<aui:button onClick="<%=addEntryURL.toString()%>" value="Thêm mới"></aui:button>
</aui:button-row>



<%-- datatable phân trang --%>
<div class="chien">
	<table id="example" class="table table-striped table-bordered"
		style="width: 100%">
		<thead>
			<tr>
				<th>STT</th>
				<th>Name</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${usersList}" varStatus="loop">
				<tr>
					<td>${loop.index +1}</td>
					<td>${user.pname}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>
</div>


<%-- xử lý popup in Bootstrap --%>

<div>=====================================================================</div>


<button class="btn btn-primary btn-lg custom-modal">Open Modal</button>
<div id="myModal" class="modal fade">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header thongbao">
				<h5 class="modal-title" id="exampleModalLongTitle">Thông Báo</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<span class="modal-title">Bạn có muốn chắc chắn chấm công
					vào/ra ?? </span>
				<div class="form-group Box">
					<p class="box1">Thời gian nhập mã xác nhận</p>
					<div class="box2" id="timer"></div>
					<p class="box3">giây</p>
				</div>
				<form>
					<div class="form-group">
						<label for="recipient-name" class="col-form-label mxn">Nhập mã
							xác nhận </label> <input type="number" class="form-control"
							id="recipient-name">
					</div>
				</form>
			</div>

			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" data-dismiss="modal">Hủy</button>
				<button type="button" class="btn btn-danger">Gửi Mã</button>
			</div>
		</div>
	</div>
</div>

<script>

$(function() {
	var time_out;
	 $('.custom-modal').click(function(e) {
	      e.preventDefault();
	      var mymodal = $('#myModal');
	      mymodal.modal('show');
	      var time_limit = 30;
	      var timerElement = $('#timer');

	      time_out = setInterval(() => {
	        if (time_limit == 0) {
	          clearInterval(time_out);
	          mymodal.modal('hide');
	        } else {
	          if (time_limit < 10) {
	            time_limit = '0' + time_limit;
	          }
	          timerElement.html(time_limit);
	          time_limit -= 1;
	        }
	      }, 1000);
	    });

	    $('#myModal').on('hidden.bs.modal', function() {
	      clearInterval(time_out); // Dừng đếm ngược khi modal ẩn
	      time_limit = 30; // Đặt lại giá trị của time_limit về giá trị ban đầu
	     //location.reload(); // Load lại trang sau khi modal được ẩn
	    });
	  });
</script>






<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://cdn.datatables.net/2.0.0/js/dataTables.js"></script>
<script
	src="https://cdn.datatables.net/2.0.0/js/dataTables.bootstrap4.js"></script>
<script>
new DataTable('#example');

</script>





