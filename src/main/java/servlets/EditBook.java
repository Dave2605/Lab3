package servlets;

import dao.BookDao;
import model.Book;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/editBook")
public class EditBook extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        String genre = request.getParameter("genre");

        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setGenre(genre);

        int status = BookDao.editBook(book);

        if(status == 1) {
            out.print("<p>" + "Book info is updated" + "</p>");
        } else {
            out.print("<p>" + "Sorry, book info isn't updated" + "</p>");
        }
        out.print("<a href=\"index.html\">Back to the main page</a>");
    }
}
