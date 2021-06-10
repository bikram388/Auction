

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="com.Storage.DBData"%>
<jsp:useBean id="obj" class="com.bean.SignupBean" scope="session"/>
<jsp:setProperty property="*" name="obj"/>
<%
    
  
    String status=DBData.checkLogin(obj);
   if(status.equals("true"))
    
    
    //if(status.equals("true"))
    {
        session.setAttribute("email", obj.getEmail());
        response.sendRedirect("home.jsp");
    }
    if(status.equals("false"))
    {
        response.sendRedirect("index.jsp?status=false");
    }
    if(status.equals("error"))
    {
        response.sendRedirect("index.jsp?status=error");
    }
    
    %>