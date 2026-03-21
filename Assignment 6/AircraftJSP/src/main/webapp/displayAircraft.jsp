<%@ page import="java.sql.*" %>

<html>
<head>
    <title>Aircraft Data</title>
</head>
<body>

<h2>Aircraft Table</h2>

<table border="1">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Type</th>
    <th>Manufaturer</th>
    <th>Quantity</th>
</tr>

<%
    String url = "jdbc:mysql://localhost:3306/test";
    String user = "root";
    String password = "2704";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM aircraft");

        while(rs.next()) {
%>

<tr>
    <td><%= rs.getInt("aircraft_id") %></td>
    <td><%= rs.getString("aircraft_name") %></td>
    <td><%= rs.getString("aircraft_type") %></td>
    <td><%= rs.getString("manufacturer") %></td>
    <td><%= rs.getInt("quantity") %></td>
</tr>

<%
        }
        con.close();
    } catch(Exception e) {
        out.println(e);
    }
%>

</table>

</body>
</html>