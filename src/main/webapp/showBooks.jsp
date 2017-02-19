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

                String id = String.valueOf(book.getId());
                String name = String.valueOf(book.getName());
                String author = String.valueOf(book.getAuthor());
                String genre = String.valueOf(book.getGenre());

            out.print("<tr><th>" + book.getId() + "</th><th>" + book.getName() + "</th><th>" + book.getAuthor()
                    + "</th><th>" + book.getGenre() + "</th><th>" + "<form action=\"editBook.jsp?id=" + id
                            + "&name=" + name  + "&author=" + author + "&genre=" + genre + "\""
                    + " method=\"post\"><input type=\"submit\" value=\"Edit\"></form>" + "</td></tr>");
        }
    }
    out.print("<tr><td><form action=\"deleteBook.jsp\"><input type =\"submit\" value=\"Delete book\"></form></tr></td>");
    out.print("<tr><th></th></tr>");
    out.print("<tr><td><form action=\"index.html\"><input type =\"submit\" value=\"Back to the main page\"></form></tr></td>");
%>

<div>
</div>
</body>
</html>
