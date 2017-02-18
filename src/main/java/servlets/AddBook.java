package servlets;

import dao.BookDao;
import model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addBook")
public class AddBook extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");

        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);

        int status = BookDao.addBook(book);

        if(status == 1) {
            out.print("<p>" + "Book is added!" + "</p>");
        } else {
            out.print("<p>" + "Sorry, book isn't added" + "</p>");
        }
        out.print("<a href=\"index.html\">Back to the main page</a>");
    }
}
