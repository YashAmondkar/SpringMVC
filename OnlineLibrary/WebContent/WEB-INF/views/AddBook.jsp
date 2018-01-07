<%@ taglib uri="http://www.springframework.org/tags/form" prefix="outline"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Book</title>

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
     <outline:form action="insert" method="post" modelAttribute="book">
       <form>
         <div align="center">
            <a href="/OnlineLibrary/vit/library/admin/home">Home</a>
         </div>
         <div>
            <label for="Title">Title:</label> <input type="text" name="title"/> <outline:errors path="title"/>
         </div>
         <div>
            <label for="ISBN">ISBN:</label> <input type="text" name="isbn"/><outline:errors path="isbn"/> 
         </div>
         <div>
            <label for="Languages">Languages:</label> <input type="text" name="languages"/> <outline:errors path="languages"/>
         </div>
         <div>
            <label for="Publisher">Publisher:</label> <input type="text" name="publisher"/> <outline:errors path="publisher"/>
         </div>
         <div>
            <label for="Author Name">Author Name:</label> <input type="text" name="authorName"/> <outline:errors path="authorName"/>
         </div>
         <div class="button" align="center">
            <button type="submit">INSERT</button>
         </div>
       </form>
     </outline:form>   

</body>
</html>