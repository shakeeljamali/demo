<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="js/jquery-2.1.4.min.js"> </script>
<script>
$(document).ready(function () {
	$("#btn").on("click",function () {
		$.ajax({
			url:"TableServlet",
			type:"post",
			data:{
				number:$("#num").val()
				},
				success:function(data){
					$("div").html(data);
					}
			});
	
	});
});
</script>
<body>
<input type="number" id="num"/>
<input type="button" value="Generate" id="btn"/>
<div> </div>
</body>
</html>