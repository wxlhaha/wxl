package com.offcn.service;

import com.offcn.bean.Page;
import com.offcn.bean.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student stu);
    List<Student> selectAllStudent(Page page);
    int findCount();
    List<Student> selectStudentByCondition(Student stu);
    int delStudent(int id);
    int updateStudentById(Student stu);
    Student selectStudentById(int id);
}
