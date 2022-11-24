package com.test.dao;

import com.test.pojo.Course;

import java.util.List;

public interface CourseDao {
    List queryByCourseName(String sCourse);
    List queryByTeacherName(String sTeacher);
    List queryAllCourse();
    List queryTeacherByCourseNo();
    Course queryCourseByCourseNo(String sCourseNo);
    Boolean inertCourse(Course course);
    Boolean updateCourse(Course course);
    Boolean deleteCourse();
}
