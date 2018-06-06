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
			url:"StudentServlet",
			type:"post",
			data:{
				name:$("#name").val(),
				rollno:$("#rollno").val(),
				method:"addRecord"
				},
				success:function(data){
					$("#name").val("");
					$("#rollno").val("");
					getAllRecrods();		
				}
			});
		
	});
	getAllRecrods();
	});
	function getAllRecrods(){
		$.ajax({
			url:"StudentServlet",
			type:"post",
			data:{
				method:"getAllRecrods"
			},
			success:function(data){
				var table="<table>";
				table+="<tr>";
				table+="<td>Id</td><td>Name</td><td>RollNo</td><td>Update</td>";
				table+="</tr>";
				var object=JSON.parse(data);
				for(x in object){
				table+="<tr><td>"+object[x].studentId+"</td>";
				table+="<td>"+object[x].name+"</td>";
				table+="<td>"+object[x].rollNo+"</td>";
				table+="<td><button value='"+object[x].studentId+"' class='update'>Update</button></td>";
				
				table+="</tr>";
				}

				 table+="</table>";		
				$("div").html(table);	
								
			}


	});
	
		$(document).on("click",".update",function(e){

					alert(e.target.value);

			});

		}
</script>
<body>
<input type="text" id="name" /> <br />
<input type="text" id="rollno" /> <br />
<input type="button" value="Add" id="btn" />
<div></div>




</body>
</html>