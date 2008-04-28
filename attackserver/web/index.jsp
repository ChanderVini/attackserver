<%-- 
    Document   : index
    Created on : Apr 26, 2008, 8:11:35 PM
    Author     : Chander Singh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <META http-equiv="Refresh" content="5">
        <title>JSP Page</title>
    </head>
    <%
        Object sessionvals = config.getServletContext().getAttribute("SESSIONVAL");
        String[] sessionvalues = new String[0];
        if (sessionvals != null) {
            sessionvalues = (String[]) sessionvals;
        }        
    %>
    <body>
        <%
            if (sessionvalues != null && sessionvalues.length > 0) {
        %>
        <table>
            <tr>
                <td>
                     Parameter Name
                 </td>
                 <td>
                     Parameter value
                 </td>
             </tr>
             <%
                for (int cnt = 0; cnt < sessionvalues.length; cnt++) {
                    String[] sessionval = sessionvalues[cnt].split(":");
                    String paramname = sessionval [0];
                    String paramvalue = sessionval [1];
             %>
             <tr>
                 <td>
                    <%=paramname%>
                </td>
                <td>
                    <%=paramvalue%>
                </td>
            </tr>
            <%
                }
            %>
        </table>
        <%
            }
        %>
    </body>
</html>
