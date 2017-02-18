<%@ page import="java.util.List" %>
<%@ page import="model.Book" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ViewBooks</title>
</head>
<body>
<%
    List<Book> books = (LinkedList<Book>) request.getAttribute("allBooks");

    out.print("<table width='100%'");
    out.print("<tr><th>ID</th><th>Book Name</th><th>Author</th><th>Genre</th></tr>");
    out.print("<tr><th></th></tr>");

    if(books!=null) {
            for(Book book :books) {
            out.print("<tr><th>" + book.getId() + "</th><th>" + book.getName() + "</th><th>" + book.getAuthor()
                    + "</th><th>" + book.getGenre() + "</td></tr>");
        }
    }
    out.print("<tr><td><a href=\"editBook.jsp\">Edit book</a></tr></td>");
    out.print("<tr><td><a href=\"deleteBook.jsp\">Delete book</a></tr></td>");
%>

<div>
</div>
<a href="index.html">Back to the main page</a>
</body>
</html>
