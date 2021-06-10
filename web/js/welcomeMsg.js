function welcomeMsg()
    {
  alert("Page is loaded");

        var val=document.getElementById("id1").value;
        if(window.confirm("Signup SuccessFully "+val+"! Do you want to Login click 'ok'"))
        {
            window.location.href="index.jsp";
        }
    }

