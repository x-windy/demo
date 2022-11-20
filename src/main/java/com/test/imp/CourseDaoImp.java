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
    public List queryByTeacherName() {
        return null;
    }

    @Override
    public Boolean inertCourse() {
        return null;
    }

    @Override
    public Boolean updateCourse() {
        return null;
    }

    @Override
    public Boolean deleteCourse() {
        return null;
    }


}
