package servlets;

import dao.BookDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/delete")
public class DeleteBook extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();

        int status = BookDao.deleteBook(Integer.parseInt(request.getParameter("id")));

        if(status == 1) {
            out.print("<p>" + "Book is deleted" + "</p>");
        } else {
            out.print("<p>" + "Sorry, book isn't deleted" + "</p>");
        }
        out.print("<a href=\"index.html\">Back to the main page</a>");
    }
}
