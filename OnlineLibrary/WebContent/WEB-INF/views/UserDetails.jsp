<%@ taglib uri="http://www.springframework.org/tags/form" prefix="outline"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Details</title>

<style>
      form {
        /* Just to center the form on the page */
        margin: 0 auto;
        width: 700px;
        /* To see the outline of the form */
        padding: 1em;
        border: 1px solid #CCC;
        border-radius: 1em;
       }

      form div + div {
        margin-top: 1em;
      }

      label {
        /* To make sure that all labels have the same size and are properly aligned */
        display: inline-block;
        width: 90px;
        text-align: right;
      }

      input, textarea {
        /* To make sure that all text fields have the same font settings By default, textareas have a monospace font */
        font: 1em sans-serif;
        /* To give the same size to all text fields */
        width: 300px;
        box-sizing: border-box; /* To harmonize the look & feel of text field border */
        border: 1px solid #999;
      }

      input:focus, textarea:focus {
        /* To give a little highlight on active elements */
        border-color: #000;
      }

      textarea {
        /* To properly align multiline text fields with their labels */
        vertical-align: top;
        /* To give enough room to type some text */
        height: 5em;
      }

      .button {
        /* To position the buttons to the same position of the text fields */
        padding-left: 90px;
        /* same size as the label elements */
      }

      button {
        /* This extra margin represent roughly the same space as the space between the labels and their text fields */
        margin-left: .5em;
      }      
    </style>

</head>
<body> 
       <outline:form>
          <div align="center">
           <h1>List Of Users</h1>            
            <table border="2">
                <th>User ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email ID</th>
                <th>City</th>
                <th>Phone Number</th>

                <c:forEach var="user" items="${listUsers}">
                <tr> 
                    <td>${user.userId}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.emailId}</td>
                    <td>${user.city}</td>    
                    <td>${user.phoneNumber}</td>
                    <td><a href="/OnlineLibrary/vit/library/admin/edituser?userid=${user.userId}">Edit</a> | <a href="/OnlineLibrary/vit/library/admin/deleteuser?userid=${user.userId}">Delete</a></td>
                </tr>
                </c:forEach> 
            </table>
        </div>
      </outline:form>   
</body>
</html>