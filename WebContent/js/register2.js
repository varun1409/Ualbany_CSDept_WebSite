
/**
 * 
 */

function myFunction()
{
	var fname=document.getElementById("fname");
	var lname=document.getElementById("lname");
	var email=document.getElementById("email");
	var address=document.getElementById("address");
	var password=document.getElementById("password");
	var confirmpassword=document.getElementById("confirmpassword");
	var phone=document.getElementById("phone");
	var user_type=document.getElementById("user_type");
	
	
	var isError=true;
	//alert(confirmPassword.value==password.value);
	if(user_type.value=="dropdown")
	{
	document.getElementById("user_typeerror").innerHTML="Please select a Specialization";
	isError=false;
	}
	else
		document.getElementById("user_typeerror").innerHTML="";
	
	
	if(fname.value=="")
	{
	
	document.getElementById("fnameerror").innerHTML="First Name not entered";
	isError=false;
	
	}
	else
		document.getElementById("fnameerror").innerHTML="";
	
	//return isError;
	
	if(lname.value=="")
	{
	document.getElementById("lnameerror").innerHTML="Please enter Last Name";
	isError=false;
	
	}
	else
		document.getElementById("lnameerror").innerHTML="";


	if((address.value==""))
	{
	document.getElementById("addresserror").innerHTML="Invalid Email Address";
	isError=false;
	
	}
	else
		document.getElementById("addresserror").innerHTML="";
	
	if((email.value==""))
	{
	document.getElementById("emailerror").innerHTML="Invalid NET ID";
	isError=false;
	
	}
	else
		document.getElementById("emailerror").innerHTML="";

	
	if(!(alphanumeric(password) && password.value.length>5))
	{
	
	document.getElementById("passworderror").innerHTML="Password should not contain special characters.Min 6 chars.";
	isError=false;
	
	}
	else
		document.getElementById("passworderror").innerHTML="";
	//return isError;
	
	if(!(confirmpassword.value==password.value))
	{
	document.getElementById("confirmpassworderror").innerHTML="Password do not match";
	isError=false;
	
	}
	else
		document.getElementById("confirmpassworderror").innerHTML="";
	
	if(!numeric(phone))
	{
	document.getElementById("phoneerror").innerHTML="Please enter a valid Phone Number";
	isError=false;
	}
	else
		document.getElementById("phoneerror").innerHTML="";
	
	
	
	return isError;
}



function alphanumeric(input)  
{   
var letters = /^[0-9a-zA-Z]+$/;  
if(input.value.match(letters))  
return true;
else
return false;   
} 

function alpha(input)  
{   
var letters = /^[a-zA-Z]+$/;  
if(input.value.match(letters))  
{  
return true;  
}  
else  
{    
return false;  
}  
} 

function numeric(input)  
{   
var letters = /^[0-9]+$/;  
if(input.value.match(letters))  
{  
return true;  
}  
else  
{    
return false;  
}  

} 

	
function ValidateEmail(mail)   
{  
	var email_regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/ ;
 if (mail.value.match(email_regex))  
  {  
    return true; 
  }  
    //alert("You have entered an invalid email address!")  
    return false; 
}  	
	
	







