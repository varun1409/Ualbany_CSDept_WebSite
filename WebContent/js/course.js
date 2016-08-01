function clickFunction(clicked_id)
{
	//alert(clicked_id);
	var cid=clicked_id;
	//var cid=str.substring(6);
	//var slot=str.substring(0,6);
	//alert(cid);
	document.getElementById("cid2").value=cid;
	//document.getElementById("slot").value=slot;

}

function clickFunction22(clicked_id)
{
	//alert(clicked_id);
	var cid=clicked_id;
	//var cid=str.substring(6);
	//var slot=str.substring(0,6);
	//alert(cid);
	document.getElementById("cid3").value=cid;
	//document.getElementById("slot").value=slot;

}
function myFunction3()
{
	var x=false;
	if (confirm("Are you sure you want to delete?") == true) {
        x = true;
    } else {
        x = false;
    }
	return x;
}


function readFunc()
{
	
	document.getElementById("atitle").readOnly=false;
	document.getElementById("adetails").readOnly=false;
	document.getElementById("alinks").readOnly=false;
	document.getElementById("save").style.visibility = "visible";
	document.getElementById("update").style.visibility = "hidden";
	document.getElementById("delete").style.visibility = "hidden";
}


function examClick(clicked_id)
{
	
	var eid=clicked_id;
	//var cid=str.substring(6);
	//var slot=str.substring(0,6);
	//alert(cid);
	document.getElementById("eid").value=eid;
	//document.getElementById("slot").value=slot;

	}


function readExamFunc()
{
	
	document.getElementById("econtent").readOnly=false;

	document.getElementById("save").style.visibility = "visible";
	document.getElementById("update").style.visibility = "hidden";
	document.getElementById("delete").style.visibility = "hidden";
}


function checkCourse()
{
	var cid=document.getElementById("cid");
	var cname=document.getElementById("cname");
	var sem=document.getElementById("sem");
	var OffLoc=document.getElementById("OffLoc");
	var OffHours=document.getElementById("offHours");
	var ta=document.getElementById("ta");
	var taemail=document.getElementById("taemail");

	var isError=true;
	
	if(taemail.value=="")
	{
	
	document.getElementById("taemailerror").innerHTML="Please enter email";
	isError=false;
	}
	else
		document.getElementById("taemailerror").innerHTML="";
	
	if(!alphanumeric(cid))
	{
	
	document.getElementById("ciderror").innerHTML="Please enter valid course Id.";
	isError=false;
	}
	else
		document.getElementById("ciderror").innerHTML="";
	
	if(cname.value=="")
	{
	
	document.getElementById("cnameerror").innerHTML="Please enter course name";
	isError=false;
	}
	else
		document.getElementById("cnameerror").innerHTML="";
	
	if(ta.value=="")
	{
	
	document.getElementById("taerror").innerHTML="Please enter TA details";
	isError=false;
	}
	else
		document.getElementById("taerror").innerHTML="";
	
	if(sem.value=="")
	{
	
	document.getElementById("semerror").innerHTML="Please enter semester";
	isError=false;
	}
	else
		document.getElementById("semerror").innerHTML="";
	
	if(OffLoc.value=="")
	{
	
	document.getElementById("OffLocerror").innerHTML="Please enter Office Location";
	isError=false;
	}
	else
		document.getElementById("OffLocerror").innerHTML="";
	
	if(OffHours.value=="")
	{
	
	document.getElementById("offHourserror").innerHTML="Please enter Office Hours";
	isError=false;
	}
	else
		document.getElementById("offHourserror").innerHTML="";
	
	
	return isError;
	
	}

function checkDisco()
{
	var qtitle=document.getElementById("qtitle");
	var qcontent=document.getElementById("qcontent");
	
	

	var isError=true;
	
	
	
	if(qtitle.value=="")
	{
	
	document.getElementById("qtitleerror").innerHTML="Please enter title";
	isError=false;
	}
	else
		document.getElementById("qtitleerror").innerHTML="";
	
	if(qcontent.value=="")
	{
	document.getElementById("qcontenterror").innerHTML="Please enter content";
	isError=false;
	}
	else
		document.getElementById("qcontenterror").innerHTML="";
	
	
	return isError;
}



function checkAnnc()
{
	var isError=true;
	
	var atype=document.getElementById("atype");
	var atitle=document.getElementById("atitle");
	var adetails=document.getElementById("adetails");
	var alinks=document.getElementById("alinks");
	
	
	if(atype.value=="dropdown")
	{
	document.getElementById("atypeerror").innerHTML="Please select a  type";
	isError=false;
	}
	else
		document.getElementById("atypeerror").innerHTML="";
	
	if(atitle.value=="")
	{
	document.getElementById("atitleerror").innerHTML="Please enter title";
	isError=false;
	}
	else
		document.getElementById("atitleerror").innerHTML="";
	
	if(adetails.value=="")
	{
	document.getElementById("adetailserror").innerHTML="Please enter details";
	isError=false;
	}
	else
		document.getElementById("adetailserror").innerHTML="";
	
	if(alinks.value=="")
	{
	document.getElementById("alinkserror").innerHTML="Please enter links";
	isError=false;
	}
	else
		document.getElementById("alinkserror").innerHTML="";
	
	
	
	return isError;
	}


function checkExam()
{
	var isError=true;
	
	var etitle=document.getElementById("etitle");
	var esemester=document.getElementById("esemester");
	var edate=document.getElementById("edate");
	
	if(etitle.value=="")
	{
	document.getElementById("etitleerror").innerHTML="Please enter title";
	isError=false;
	}
	else
		document.getElementById("etitleerror").innerHTML="";
	
	if(esemester.value=="")
	{
	document.getElementById("esemestererror").innerHTML="Please enter semester";
	isError=false;
	}
	else
		document.getElementById("esemestererror").innerHTML="";
	
	if(edate.value=="")
	{
	document.getElementById("edateerror").innerHTML="Please enter date";
	isError=false;
	}
	else
		document.getElementById("edateerror").innerHTML="";
	
	
	return isError;
	}




function checkAlumni()
{
	var isError=true;
	
	var alname=document.getElementById("alname");
	var allink=document.getElementById("allink");
	var aldetails=document.getElementById("aldetails");
	
	if(alname.value=="")
	{
	document.getElementById("alnameerror").innerHTML="Please enter name";
	isError=false;
	}
	else
		document.getElementById("alnameerror").innerHTML="";
	
	if(allink.value=="")
	{
	document.getElementById("allinkerror").innerHTML="Please enter link";
	isError=false;
	}
	else
		document.getElementById("allinkerror").innerHTML="";
	
	if(aldetails.value=="")
	{
	document.getElementById("aldetailserror").innerHTML="Please enter details";
	isError=false;
	}
	else
		document.getElementById("aldetailserror").innerHTML="";
	

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