package com.offcn.service;

import com.offcn.bean.Page;
import com.offcn.bean.Student;
import com.offcn.dao.StudentDao;
import com.offcn.dao.StudentDaoImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService{
        StudentDao sd = new StudentDaoImpl();
    @Override
    public int addStudent(Student stu) {
        return sd.addStudent(stu);
    }

    @Override
    public List<Student> selectAllStudent(Page page) {
        return sd.selectAllStudent(page);
    }

    @Override
    public int findCount() {
        return sd.findCount();
    }

    @Override
    public List<Student> selectStudentByCondition(Student stu) {
        return sd.selectStudentByCondition(stu);
    }

    @Override
    public int delStudent(int id) {
        return sd.delStudent(id);
    }

    @Override
    public int updateStudentById(Student stu) {
        return sd.updateStudentById(stu);
    }

    @Override
    public Student selectStudentById(int id) {
        return sd.selectStudentById(id);
    }
}
