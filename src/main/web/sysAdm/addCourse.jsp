<%@ page import="java.util.List" %>
<%@ page import="com.test.pojo.Course" %>
<%@ page import="com.test.dao.CourseDao" %>
<%@ page import="com.test.imp.CourseDaoImp" %><%--
  Created by IntelliJ IDEA.
  User: zq
  Date: 2022/11/15
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>添加课程</title>
</head>
<body>
<form action="http://localhost:8080/demo_war_exploded/submitCourseServlet" method="post">
    <table>
        <tr>
            <th>增加课程记录</th>
        </tr>
        <tr>
            <td>课程编号</td>
            <td><input type="text" name="sCourseNo"></td>
        </tr>
        <tr>
            <td>课程名称</td>
            <td><input type="text" name="sCname"></td>
        </tr>
        <tr>
            <td>开课日期</td>
            <td><input type="date" name="dtOpenDate"></td>
        </tr>
        <tr>
            <td>教师</td>
            <td><select name="sTeacher">
                <%
                    List<Course> list = CourseDaoImp.getInstance().queryAllCourse();
                    if (list!=null && list.size()>0){
                        for (Course course:list){
                %>
                             <option><%=course.getsTeacher()%></option>
                <%
                        }
                }%>

            </select></td>
        </tr>
        <tr>
            <td>周数</td>
            <td><input type="number" name="iWeekCnt"></td>
        </tr>
        <tr>
            <td>在线学习链接</td>
            <td><input type="text" name="sIndexURL"></td>
        </tr>
        <tr>
            <td>状态</td>
            <td>
                <input type="radio" name="sStatuse" ID="radio" value="可用" checked>
                <LABEL for="radio">可用</LABEL>
                <input type="radio" name="sStatuse" value="作废">
                <LABEL for="radio">作废</LABEL></td>
        </tr>
        <tr>
            <td>课程资源</td>
            <td><input type="text" name="sUploadFile"></td>
        </tr>
        <tr>
            <th><input name="submit1" type="submit" value="提交">
                <input name="submit2" type="reset" value="重置">
                <input name="back" type="button" value="返回" onclick="JavaScrip:history.back();"></th>
        </tr>
    </table>
</form>
</body>
</html>
