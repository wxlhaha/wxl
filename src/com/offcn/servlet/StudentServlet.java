package com.offcn.servlet;

import com.offcn.bean.Page;
import com.offcn.bean.Student;
import com.offcn.service.StudentService;
import com.offcn.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

import static com.sun.javafx.fxml.expression.Expression.add;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    StudentService ss = new StudentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        if ("addstudent".equals(method)){
            addstudent(request,response);
        }else if ("findall".equals(method)){
            findall(request,response);
        }else if ("selectstudentbycondition".equals(method)){
            selectstudentbycondition(request,response);
        }else if ("del".equals(method)){
            del(request,response);
        }else if ("find".equals(method)){
            find(request,response);
        }else if ("update".equals(method)){
            update(request,response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String score = request.getParameter("score");
        Student student = new Student();
        student.setName(name);
        student.setId(Integer.parseInt(id));
        student.setScore(Integer.parseInt(score));
        student.setAge(Integer.parseInt(age));
        int i = ss.updateStudentById(student);
        if (i != 0){
            response.sendRedirect("StudentServlet?method=findall");
        }else {
            response.sendRedirect("error.jsp");
        }
    }

    private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Student stu = ss.selectStudentById(Integer.parseInt(id));
        request.setAttribute("student",stu);
        //转发
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

    private void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        int i = ss.delStudent(Integer.parseInt(id));
        if (i > 0){
            response.sendRedirect("StudentServlet?method=findall");
        }else {
            response.sendRedirect("error.jsp");
        }
    }

    private void selectstudentbycondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String score = request.getParameter("score");
        Student student = new Student();
        student.setName(name);
        student.setAge(Integer.parseInt(age));
        student.setScore(Integer.parseInt(score));
        List<Student> list = ss.selectStudentByCondition(student);
        request.setAttribute("slist",list);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void findall(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //当前页
        int currentPage = 1;
        String currPage = request.getParameter("currPage");
        if (currPage != null && !"".equals(currPage)){
            currentPage = Integer.parseInt(currPage);
        }
        Page page = new Page();
        page.setCurrentPage(currentPage);
        //计算总条数
        int totalNum = ss.findCount();
        page.setTotalNum(totalNum);
        //计算总页数
        int totalPage = 0;
        if (totalNum % Page.PAGESIZE == 0){
            totalPage = totalNum / Page.PAGESIZE;
        }else {
            totalPage = totalNum / Page.PAGESIZE + 1;
        }
        //设置总页码
        page.setTotalPage(totalPage);
        List<Student> list = ss.selectAllStudent(page);
        request.setAttribute("slist",list);
        request.setAttribute("page",page);
        request.getRequestDispatcher("list.jsp").forward(request,response);
    }

    private void addstudent(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String score = request.getParameter("score");
        Student stu = new Student();
        stu.setName(name);
        stu.setAge(Integer.parseInt(age));
        stu.setScore(Integer.parseInt(score));
        int i = ss.addStudent(stu);
        if (i > 0){
            response.sendRedirect("StudentServlet?method=findall");
        }else {
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
