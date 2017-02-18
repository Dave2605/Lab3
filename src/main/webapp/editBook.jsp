<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="editBook" method="get">
    <table>
        <tr><td>ID:</td><td><input type="text" name="id"/></td></tr>
        <tr><td>Name:</td><td><input type="text" name="name"/></td></tr>
        <tr><td>Author:</td><td><input type="text" name="author"/></td></tr>
        <tr><td>
            <select name="genre" style="width:150px">
                <option>adventure</option>
                <option>novel</option>
                <option>fiction</option>
            </select>
        </td></tr>
        <tr><td colspan="2"><input type="submit" value="Edit"/></td></tr>
    </table>
</form>
<a href="index.html">Back to the main page</a>
</body>
</html>
