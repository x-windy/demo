package com.test.servlet;

import com.test.imp.CourseDaoImp;
import com.test.pojo.Course;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "modiCourseServlet", value = "/modiCourseServlet")
public class modiCourseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        Course course = new Course();
        course.setsCourseNo(request.getParameter("sCourseNo"));
        course.setsCname(request.getParameter("sCname"));
        course.setsTeacher(request.getParameter("sTeacher"));
        course.setiWeekCnt(Integer.parseInt(request.getParameter("iWeekCnt")));
        course.setsStatuse(request.getParameter("sStatuse"));
        course.setDtOpenDate(request.getParameter("dtOpenDate"));
        course.setsIndexURL(request.getParameter("sIndexURL"));
        if (CourseDaoImp.getInstance().updateCourse(course)){
            System.out.println("修改成功");
            request.getRequestDispatcher("indexCourse.jsp").forward(request,response);
        }

    }
}
