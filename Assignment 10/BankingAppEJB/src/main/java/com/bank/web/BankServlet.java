package com.bank.web;

import com.bank.ejb.BankService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bank")
public class BankServlet extends HttpServlet {

    @EJB
    private BankService bankService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("action");
        double amount = 0;
        if (request.getParameter("amount") != null)
            amount = Double.parseDouble(request.getParameter("amount"));

        try {
            if ("deposit".equals(action)) {
                bankService.deposit(amount);
                out.println("Deposited: " + amount);
            } else if ("withdraw".equals(action)) {
                bankService.withdraw(amount);
                out.println("Withdrawn: " + amount);
            } else if ("balance".equals(action)) {
                out.println("Current Balance: " + bankService.getBalance());
            } else {
                out.println("No action performed.");
            }
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }
    }
}