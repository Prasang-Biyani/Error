/**
 * 
 */
function getErrorSearchData(){
	var errortype = document.getElementById("errortype").value;
	var errordesc = document.getElementById("errordesc").value;
	var errordate = document.getElementById("errordate").value;
	var errortime = document.getElementById("errortime").value;
	/**if(x.length  == 0){
		alert("Please Enter value");
		return (false);
	}*/

	return true;
}

 function checkForm(form)
  {
    // regular expression to match required date format
    re = /^\d{4}\-\d{1,2}\-\d{1,2}$/;

    if(form.errorstartdate.value != '' && !form.errorstartdate.value.match(re)) {
      alert("Invalid date format: " + form.errorstartdate.value);
      form.errorstartdate.focus();
      return false;
    }

    if(form.errorenddate.value != '' && !form.errorenddate.value.match(re)) {
      alert("Invalid date format: " + form.errorenddate.value);
      form.errorenddate.focus();
      return false;
    }

    // regular expression to match required time format
    re = /^\d{1,2}:\d{2}:\d{2}$/;

    if(form.errorstarttime.value != '' && !form.errorstarttime.value.match(re)) {
      alert("Invalid time format: " + form.errorstarttime.value);
      form.errorstarttime.focus();
      return false;
    }

	if(form.errorendtime.value != '' && !form.errorendtime.value.match(re)) {
      alert("Invalid time format: " + form.errorendtime.value);
      form.errorendtime.focus();
      return false;
    }
    //alert("All input fields have been validated!");
    return true;
  }