function validateLogin() {
  let username = document.getElementById("username").value;
  let pass = document.getElementById("pass").value;

  if (username.trim() == "" ) {
    document.getElementById("usererror").innerText = "*Please Enter Email Id.";
    return false;
  } else if (pass.trim() == "" && username != "") {
    document.getElementById("usererror").innerText = "";
    document.getElementById("passerror").innerText = "*Please Enter a Password";
    return false;
  } else if (pass.length < 8) {
    document.getElementById("usererror").innerText = "";
    document.getElementById("passerror").innerText =
      "*Enter at least 8 characters";
    return false;
  } else {
    document.getElementById("passerror").innerText = "";
    let user = document.getElementById("username").value;
    // alert("Hey, " + user + " Nice to See You Again :) ");
    return true;
  }
}

function showpass() {
  let pass = document.getElementById("pass");
  if (pass.type == "password") {
    pass.type = "text";
    document.getElementById("showpass").innerText = "HIDE PASSWORD";
  } else if (pass.type == "text") {
    pass.type = "password";
    document.getElementById("showpass").innerText = "SHOW PASSWORD";
  }
}

function hidepass() {
  let pass = document.getElementById("pass");
  if (pass.type == "text") {
    pass.type = "password";
    document.getElementById("showpass").innerText = "SHOW PASSWORD";
  }
}
