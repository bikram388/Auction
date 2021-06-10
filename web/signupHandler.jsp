
<%@page import="com.Storage.DBData"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="obj" class="com.bean.SignupBean"/>
<jsp:setProperty property="*" name="obj"/>

<script src="./js/welcomeMsg.js"></script>


<%
int status=DBData.newBidder(obj);
if(status>0)
    
    {%>
    <h1>
        submitted
</h1>
    
   
    <body onload="welcomeMsg()">
        
         <input type="hidden" id="id1" value="<%= obj.getName() %>"/>
        
    </body>


 
<%}
else
{

}
%>



