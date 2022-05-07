package com.offcn.dao;

import com.offcn.bean.Page;
import com.offcn.bean.Student;
import com.offcn.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int addStudent(Student stu) {
        int result = 0;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into student values(null,?,?,?)";
        try {
           result =  qr.update(sql,stu.getName(),stu.getAge(),stu.getScore());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Student> selectAllStudent(Page page) {
        List<Student> list = new ArrayList<>();
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        //  分页
        String sql = "select * from student order by score limit ?,?";
        try {
            list = qr.query(sql,new BeanListHandler<>(Student.class),(page.getCurrentPage()-1)*Page.PAGESIZE,Page.PAGESIZE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Student> selectStudentByCondition(Student stu) {
      List<Student> list = new ArrayList<>();
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = getSql(stu);
        try {
          list =   qr.query(sql,new BeanListHandler<>(Student.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int updateStudentById(Student stu) {
        int result = 0;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update student set name = ?,age = ?,score = ? where id = ?";
        try {
            result = qr.update(sql, stu.getName(),stu.getAge(),stu.getScore(),stu.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public int delStudent(int id) {
        int result = 0;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from student where id=?";
        try {
            result = qr.update(sql,id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    private String getSql(Student stu) {
        StringBuilder sb = new StringBuilder("select * from student where 1 = 1");
        if (stu.getName() != null && !"".equals(stu.getName().trim())){
            sb.append(" and name like '%").append(stu.getName()).append("%'");
        }
        if (stu.getAge() != 0){
            sb.append(" and age = '").append(stu.getAge()).append("'");
        }
        if (stu.getScore() != 0){
            sb.append(" and score = '").append(stu.getScore()).append("'");
        }
        return sb.toString();
    }

    @Override
    public int findCount() {
        Long count = 0L;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(*) from student";
        try {
           count =  (Long) qr.query(sql,new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count.intValue();
    }

    @Override
    public Student selectStudentById(int id) {
     Student stu = null;
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from student where id = ?";
        try {
            stu =   qr.query(sql, new BeanHandler<>(Student.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stu;
    }

}
