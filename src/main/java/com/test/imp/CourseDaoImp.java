package com.test.imp;

import com.test.dao.CourseDao;
import com.test.pojo.Course;
import com.test.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CourseDaoImp implements CourseDao {
    @Override
    public List queryByCourseName(String sCourse) {
        DBUtil.loadClass();
        Connection connection = DBUtil.getConn();
        String sql = "SELECT sCourseNo,sCname,dtOpendate,sTeacher,iWeekCnt,sIndexURL,sStatuse FROM course WHERE sCname LIKE ?";
        List<Course> list = new ArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,  "%" + sCourse+ "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                Course course = new Course();
                course.setsCourseNo(resultSet.getString("sCourseNo"));
                course.setsCname(resultSet.getString("sCname"));
                course.setDtOpenDate(resultSet.getString("dtOpendate"));
                course.setsTeacher(resultSet.getString("sTeacher"));
                course.setiWeekCnt(resultSet.getString("iWeekCnt"));
                course.setsIndexURL(resultSet.getString("sIndexURL"));
                course.setsStatuse(resultSet.getString("sStatuse"));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List queryByTeacherName(String sTeacher) {
        DBUtil.loadClass();
        Connection connection = DBUtil.getConn();
        String sql = "SELECT sCourseNo,sCname,dtOpendate,sTeacher,iWeekCnt,sIndexURL,sStatuse FROM course WHERE sTeacher LIKE ?";
        List<Course> list = new ArrayList();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,  "%" + sTeacher+ "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                Course course = new Course();
                course.setsCourseNo(resultSet.getString("sCourseNo"));
                course.setsCname(resultSet.getString("sCname"));
                course.setDtOpenDate(resultSet.getString("dtOpendate"));
                course.setsTeacher(resultSet.getString("sTeacher"));
                course.setiWeekCnt(resultSet.getString("iWeekCnt"));
                course.setsIndexURL(resultSet.getString("sIndexURL"));
                course.setsStatuse(resultSet.getString("sStatuse"));
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List queryTeacherByCourseNo() {
        return null;
    }

    @Override
    public Course queryCourseByCourseNo(String sCourseNo) {
        DBUtil.loadClass();
        Connection connection = DBUtil.getConn();
        String sql = "SELECT sCourseNo,sCname,dtOpendate,sTeacher,iWeekCnt,sIndexURL,sStatuse FROM course WHERE sCourseNo =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,  sCourseNo);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet != null && resultSet.next()) {
                Course course = new Course();
                course.setsCourseNo(resultSet.getString("sCourseNo"));
                course.setsCname(resultSet.getString("sCname"));
                course.setDtOpenDate(resultSet.getString("dtOpendate"));
                course.setsTeacher(resultSet.getString("sTeacher"));
                course.setiWeekCnt(resultSet.getString("iWeekCnt"));
                course.setsIndexURL(resultSet.getString("sIndexURL"));
                course.setsStatuse(resultSet.getString("sStatuse"));
                return course;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    @Override
    public Boolean inertCourse(String sCourseNo,String sCname,String dtOpendate,String sTeacher,String iWeekCnt,String sIndexURL,String sStatuse) {
        DBUtil.loadClass();
        Connection connection = DBUtil.getConn();
        String sql = "Insert into course(sCourseNo,sCname,dtOpendate,sTeacher,iWeekCnt,sIndexURL,sStatuse)  values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sCourseNo);
            preparedStatement.setString(2,sCname);
            preparedStatement.setString(3,dtOpendate);
            preparedStatement.setString(4,sTeacher);
            preparedStatement.setString(5,iWeekCnt);
            preparedStatement.setString(6,sIndexURL);
            preparedStatement.setString(7,sStatuse);
            if (preparedStatement.executeUpdate()==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean updateCourse(String sCourseNo,String sCname,String dtOpendate,String sTeacher,String iWeekCnt,String sIndexURL,String sStatuse) {
        DBUtil.loadClass();
        Connection connection = DBUtil.getConn();
        String sql = "update course set sCourseNo=?,sCname=?,dtOpendate=?,sTeacher=?,iWeekCnt=?,sIndexURL=?,sStatuse=? where sCourseNo=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,sCourseNo);
            preparedStatement.setString(2,sCname);
            preparedStatement.setString(3,dtOpendate);
            preparedStatement.setString(4,sTeacher);
            preparedStatement.setString(5,iWeekCnt);
            preparedStatement.setString(6,sIndexURL);
            preparedStatement.setString(7,sStatuse);
            preparedStatement.setString(8,sCourseNo);
            if (preparedStatement.executeUpdate()==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

    @Override
    public Boolean deleteCourse() {
        return null;
    }


}
