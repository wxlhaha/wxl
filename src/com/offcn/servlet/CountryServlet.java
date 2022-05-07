package com.offcn.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.bean.Country;
import com.offcn.service.CountryService;
import com.offcn.service.CountryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/CountryServlet")
public class CountryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        CountryService cs = new CountryServiceImpl();
        List<Country> list = cs.selectAllCountry();
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        writer.println(s);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
