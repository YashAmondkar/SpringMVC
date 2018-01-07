<%@ taglib uri="http://www.springframework.org/tags/form" prefix="outline"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>

<style>
      form {
        /* Just to center the form on the page */
        margin: 0 auto;
        width: 400px;
        /* To see the outline of the form */
        padding: 1em;
        border: 1px solid #CCC;
        border-radius: 1em;
      }
      
      input, textarea {
        border: 1px solid #CCC;
      }
      
</style>

</head>
<body>
       <outline:form action="register" method="post">
             <div align="left">
             <a href="/OnlineLibrary/vit/library/user/login">Go To Library</a>
             </div>
             
             <div align="right">
                  <a href="/OnlineLibrary/vit/library/admin/login">Admin Login</a>
             </div>            
             
             <div align="right">
                  <a href="/OnlineLibrary/vit/library/user/register">Register</a>
             </div>            
             <div>
                  <textarea rows="5" cols="32">Outstanding, world class facilities. Students here should count themselves fortunate and I hope they use them to the full. Most impressive!</textarea>
             </div>            
       </outline:form>       
</body>
</html>