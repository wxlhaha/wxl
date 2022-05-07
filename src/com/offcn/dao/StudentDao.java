package com.offcn.dao;

import com.offcn.bean.Page;
import com.offcn.bean.Student;

import java.util.List;

public interface StudentDao {
    int addStudent(Student stu);
    List<Student> selectAllStudent(Page page);
    List<Student> selectStudentByCondition(Student stu);
//      Book selectBookById(int id);
//    int preupdate(Book book);
//    // 全部查询
////    List<Book> selectAllBook();
////    Book selectBookById(int id);
////    //根据id更改
   int updateStudentById(Student stu);
////    //根据id删除
   int delStudent(int id);
   int findCount();

    Student selectStudentById(int id);
}
