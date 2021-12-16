<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
function myFunction(id) {
  let rejectcomment = prompt("Please enter your Reject Reason", ""); 
  if(rejectcomment!=null){
	  document.forms[0].method="get";
	  document.forms[0].action="/SpringMVCCRUDApp/reject/"+id;
	  document.forms[0].submit();
  }
  
}
function myFunction1(id) {
	 
  document.forms[0].method="get";
  document.forms[0].action="/SpringMVCCRUDApp/acceptvalidation/"+id;
  document.forms[0].submit();
}
</script>
</head>
<body >
<form name="accept">

<h1 align="center">VERIFICATION</h1>
<h3  style="background-color:red;"><p>${result}</p></h3>
<table align="center" cellpadding="10" cellspacing="20">
<tr>
<td><b>MSISDN</b> &nbsp;&nbsp;&nbsp;&nbsp;</td><td>${autoacquire.msisdn}</td>
<td></td>
<td><b>SIM_TYPE</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>${autoacquire.simType}</td>
</tr>
<tr>
<td><b>NAME</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>${autoacquire.name}</td>
<td></td>
<td><b>GENDER</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>${autoacquire.gender}</td>
</tr>
<tr>
<td><b>DATE OF BIRTH</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>${autoacquire.dateOfBirth}</td>
</tr>
<tr>
<td><b>ID NUMBER</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>${autoacquire.idNumber}</td>
</tr>
<tr>
<td><b>ADDRESS</b>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>${autoacquire.address}</td>
</tr>
<tr></tr>
<tr>
<td></td>
<td><button  onclick="myFunction1(${autoacquire.msisdn})"><b>ACCEPT</b></button></td>
<td></td>
<td><button onclick="myFunction(${autoacquire.msisdn})"><b>REJECT</b></button></td>
</tr>
</table>
</form>
</body>
</html>