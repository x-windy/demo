package com.test.imp;

import com.test.pojo.Course;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseDaoImpTest {
    CourseDaoImp courseDaoImp = new CourseDaoImp();
    @Test
    void queryByCourseName() {
        List<Course> list = courseDaoImp.queryByCourseName("编");
        System.out.println(list.size());
    }
    @Test
    void testCeil(){
        // 向上取整
        System.out.println((int)Math.ceil((double)1/3));
    }

    @Test
    void testPage(){
        List<Course> list = null;
        int iPageCnt = 0;// 总页数
        int iPage = 0;// 当前页码
        int iPageSize = 2;// 页面大小
        int total = 0; // 总数据量
        list = courseDaoImp.queryByCourseName("大");
        total = list.size();
        iPage=1;
        iPageCnt = (int) Math.ceil((double)total/iPageSize);
        System.out.println(total);
        for (Course course:list){
            System.out.println(course.getsCourseNo());
        }
        System.out.println("========");
        int temp= 0;
        for (int i=0;i<iPageCnt;i++){
            System.out.println("第"+ (i+1) +"页");
            for (int j=temp;j<(i+1)*iPageSize;j++){
                temp=j+1;
                System.out.println(list.get(j).getsCourseNo());
            }
        }
    }

    @Test
    void queryByTeacherName() {
        System.out.println(courseDaoImp.queryByTeacherName("张").size());
    }

    @Test
    void queryTeacherByCourseNo() {

    }

    @Test
    void inertCourse() {
    }

    @Test
    void updateCourse() {
    }

    @Test
    void deleteCourse() {
    }

    @Test
    void queryCourseByCourseNo() {
        System.out.println(courseDaoImp.queryCourseByCourseNo("D3232").getsCname());
    }
}