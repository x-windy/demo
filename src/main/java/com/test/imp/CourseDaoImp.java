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
    List<Course> list = null;
    private static CourseDaoImp courseDaoImp = new CourseDaoImp();

    public static CourseDaoImp getInstance(){
        return courseDaoImp;
    }
    @Override
    public  List queryByCourseName(String sCourse) {
        DBUtil.loadClass();
        Connection connection = DBUtil.getConn();
        list=new ArrayList();
        String sql = "SELECT sCourseNo,sCname,dtOpendate,sTeacher,iWeekCnt,sIndexURL,sStatuse FROM course WHERE sCname LIKE ?";
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
                course.setiWeekCnt(resultSet.getInt("iWeekCnt"));
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
        list=new ArrayList();
        String sql = "SELECT sCourseNo,sCname,dtOpendate,sTeacher,iWeekCnt,sIndexURL,sStatuse FROM course WHERE sTeacher LIKE ?";
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
                course.setiWeekCnt(resultSet.getInt("iWeekCnt"));
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
    public List queryAllCourse() {
        DBUtil.loadClass();
        Connection connection = DBUtil.getConn();
        list=new ArrayList();
        String sql = "SELECT sCourseNo,sCname,dtOpendate,sTeacher,iWeekCnt,sIndexURL,sStatuse FROM course";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet != null && resultSet.next()) {
                Course course = new Course();
                course.setsCourseNo(resultSet.getString("sCourseNo"));
                course.setsCname(resultSet.getString("sCname"));
                course.setDtOpenDate(resultSet.getString("dtOpendate"));
                course.setsTeacher(resultSet.getString("sTeacher"));
                course.setiWeekCnt(resultSet.getInt("iWeekCnt"));
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
                course.setiWeekCnt(resultSet.getInt("iWeekCnt"));
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
    public Boolean inertCourse(Course course) {
        DBUtil.loadClass();
        Connection connection = DBUtil.getConn();
        String sql = "Insert into course(sCourseNo,sCname,dtOpendate,sTeacher,iWeekCnt,sIndexURL,sStatuse)  values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,course.getsCourseNo());
            preparedStatement.setString(2,course.getsCname());
            preparedStatement.setString(3,course.getDtOpenDate());
            preparedStatement.setString(4,course.getsTeacher());
            preparedStatement.setInt(5,course.getiWeekCnt());
            preparedStatement.setString(6,course.getsIndexURL());
            preparedStatement.setString(7,course.getsStatuse());

            if (preparedStatement.executeUpdate()==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean updateCourse(Course course) {
        DBUtil.loadClass();
        Connection connection = DBUtil.getConn();
        String sql = "update course set sCourseNo=?,sCname=?,dtOpendate=?,sTeacher=?,iWeekCnt=?,sIndexURL=?,sStatuse=? where sCourseNo=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,course.getsCourseNo());
            preparedStatement.setString(2,course.getsCname());
            preparedStatement.setString(3,course.getDtOpenDate());
            preparedStatement.setString(4,course.getsTeacher());
            preparedStatement.setInt(5,course.getiWeekCnt());
            preparedStatement.setString(6,course.getsIndexURL());
            preparedStatement.setString(7,course.getsStatuse());
            preparedStatement.setString(8,course.getsCourseNo());
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
