function myFunction()
{
	var rtype=document.getElementById("r_type");
	var date=document.getElementById("datepicker");
	

	var isError=true;
	
	if(rtype.value=="dropdown")
	{
	document.getElementById("rselect_typeerror").innerHTML="Please select a resource";
	isError=false;
	}
	else
		document.getElementById("rselect_typeerror").innerHTML="";
	
	
	if(date.value=="")
		{
		
		document.getElementById("dateerror").innerHTML="Please select a date";
		isError=false;
		}
		else
			document.getElementById("dateerror").innerHTML="";
		
	return isError;
}



function addCheck()
{
	
	var artype=document.getElementById("artype");
	var arname=document.getElementById("arname");
	var ardesc=document.getElementById("ardesc");

	var isError=true;
	
	if(artype.value=="dropdown")
	{
	document.getElementById("artypeerror").innerHTML="Please select a resource type";
	isError=false;
	}
	else
		document.getElementById("artypeerror").innerHTML="";
	
	
	if(!alphanumeric(arname))
		{
		
		document.getElementById("arnameerror").innerHTML="Please select a res name";
		isError=false;
		}
		else
			document.getElementById("arnameerror").innerHTML="";
	
	if(ardesc.value=="")
	{
	
	document.getElementById("ardescerror").innerHTML="Please add description";
	isError=false;
	}
	else
		document.getElementById("ardescerror").innerHTML="";
	
	return isError;
}


function clickFunction(clicked_id)
{

	var str=clicked_id;
	var resname=str.substring(5);
	var slot=str.substring(0,5);

	document.getElementById("resname").value=resname;
	document.getElementById("slot").value=slot;

}

function myFunction2()
{
	var x=false;
	if (confirm("Are you sure you want to continue?") == true) {
        x = true;
    } else {
        x = false;
    }
	return x;
}

function cancelFunc(str)
{
	var slot=str.substring(0,5);
	var date=str.substring(5,15)
	var resname=str.substring(15);
	document.getElementById("resname").value=resname;
	document.getElementById("slot").value=slot;
	document.getElementById("date").value=date;

	
	
}


function alphanumeric(input)  
{   
var letters = /^[0-9a-zA-Z]+$/;  
if(input.value.match(letters))  
return true;
else
return false;   
} 