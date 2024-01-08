package com.example.companyemployeeee;


import manager.CompanyManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/companies")
public class CompaniesServlet extends HttpServlet {

    private CompanyManager companyManager = new CompanyManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("companies",companyManager.getCompanies());
        req.getRequestDispatcher("/companies.jsp").forward(req,resp);
    }
}
