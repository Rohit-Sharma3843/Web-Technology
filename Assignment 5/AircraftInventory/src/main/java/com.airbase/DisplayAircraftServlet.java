package com.airbase;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/displayAircraft")
public class DisplayAircraftServlet extends HttpServlet {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "2704";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Aircraft Inventory</title>");
        out.println("<style>table {width:80%; margin:auto; border-collapse:collapse;} th,td {border:1px solid #2a5298; padding:12px;} th {background:#1e3c72; color:white;} tr:nth-child(even){background:#e3ebf6;} h2{text-align:center;color:#1e3c72;}</style>");
        out.println("</head><body><h2>Aircraft Inventory</h2><table><tr><th>ID</th><th>Name</th><th>Type</th><th>Manufacturer</th><th>Quantity</th></tr>");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM aircraft");

            while(rs.next()){
                out.println("<tr><td>"+rs.getInt("aircraft_id")+"</td><td>"+rs.getString("aircraft_name")+"</td><td>"+rs.getString("aircraft_type")+"</td><td>"+rs.getString("manufacturer")+"</td><td>"+rs.getInt("quantity")+"</td></tr>");
            }
            rs.close(); stmt.close(); con.close();
        } catch(Exception e) {
            out.println("<tr><td colspan='5'>Error: "+e.getMessage()+"</td></tr>");
        }

        out.println("</table></body></html>");
    }
}