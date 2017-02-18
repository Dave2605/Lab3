package servlets;

import dao.BookDao;
import model.Book;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/showAll")
public class ShowAll extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books= BookDao.viewBooks();

        response.setContentType("text/html");
        RequestDispatcher view = request.getRequestDispatcher("/showBooks.jsp");
        request.setAttribute("allBooks", books);
        view.forward(request, response);
    }
}
