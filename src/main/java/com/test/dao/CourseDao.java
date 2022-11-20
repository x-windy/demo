package com.test.dao;

import com.test.pojo.Course;

import java.util.List;

public interface CourseDao {
    List queryByCourseName(String sCourse);
    List queryByTeacherName(String sTeacher);
    List queryTeacherByCourseNo();
    Course queryCourseByCourseNo(String sCourseNo);
    Boolean inertCourse(String sCourseNo,String sCname,String dtOpendate,String sTeacher,String iWeekCnt,String sIndexURL,String sStatuse);
    Boolean updateCourse(String sCourseNo,String sCname,String dtOpendate,String sTeacher,String iWeekCnt,String sIndexURL,String sStatuse);
    Boolean deleteCourse();
}
