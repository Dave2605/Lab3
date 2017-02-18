package dao;

import database.Database;
import model.Book;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class BookDao {

    public static List<Book> viewBooks() {

        List<Book> books = new LinkedList<Book>();

        Connection connection = Database.getConnection();
        String sql = "SELECT b.id, b.name, b.author, g.genre FROM books b JOIN genres g ON b.genre=g.id";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();

                book.setId(resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setGenre(resultSet.getString("genre"));

                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("Can't create statement: " + e);
            Database.CloseConnection(connection);
        }
        Database.CloseConnection(connection);

        return books;
    }

    public static int addBook(Book book) {

        Connection connection = Database.getConnection();
        String sql = "INSERT INTO books (name, author, genre) values (?,?, (SELECT id FROM genres WHERE genre = ?))";

        int status = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());

            status = statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Can't add a new book");
            Database.CloseConnection(connection);
        }
        Database.CloseConnection(connection);

        return status;
    }

    public static int editBook(Book book) {

        Connection connection = Database.getConnection();
        String sql = "UPDATE books SET name = ?, author = ?, genre = (SELECT id FROM genres WHERE genre = ?) " +
                "WHERE id = ?";

        int status = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, book.getName());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.setString(4, String.valueOf(book.getId()));

            status = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can't edit a book");
            Database.CloseConnection(connection);
        }
        Database.CloseConnection(connection);

        return status;
    }

    public static int deleteBook(int id) {

        Connection connection = Database.getConnection();
        String sql = "DELETE FROM books WHERE id = ?";

        int status = 0;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, String.valueOf(id));
            status = statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Can't delete a book");
            Database.CloseConnection(connection);
        }
        Database.CloseConnection(connection);

        return status;
    }
}
