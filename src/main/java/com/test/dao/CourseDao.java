package com.test.dao;

import java.util.List;

public interface CourseDao {
    List queryByCourseName(String sCourse);
    List queryByTeacherName();
    Boolean inertCourse();
    Boolean updateCourse();
    Boolean deleteCourse();
}
