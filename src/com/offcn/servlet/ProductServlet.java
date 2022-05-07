package com.offcn.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.dao.ProductDaoImpl;
import com.offcn.service.ProductService;
import com.offcn.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productname = request.getParameter("productname");
        ProductService ps = new ProductServiceImpl();
        List<Product> list = ps.selectProductByName(productname);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        writer.println(s);
    }
}
