        <%@ page import="java.util.List" %>
<%@ page import="com.test.pojo.Course" %>
<%@ page import="com.test.imp.CourseDaoImp" %>
<%@ page import="com.mysql.cj.jdbc.Driver" %>
<%--
  Created by IntelliJ IDEA.
  User: zq
  Date: 2022/11/10
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("UTF-8");
  response.setContentType("text/html;charset=utf-8");
  List<Course> list = null;
  int iPage = 0;// 当前页
  int iPageCnt = 0;// 页数
  int iPageSize = 2;// 每页的数据量
  if (request.getParameter("strKey") != null && request.getParameter("action").equals("102")) {
    String strKey = request.getParameter("strKey");
    session.setAttribute("strKey", strKey);
    System.out.println((String) session.getAttribute("strKey"));
    CourseDaoImp courseDaoImp = new CourseDaoImp();
    list = courseDaoImp.queryByCourseName((String) session.getAttribute("strKey"));
    int total = list.size();
    iPage=1;
    iPageCnt = (int) Math.ceil((double)total/iPageSize);
  }

%>
<html>
  <head>
    <title>课程管理</title>
    <script type="text/javascript">
      function clearData(){
          
      }
      function search(){

      }
    </script>
  </head>
  <body>
  <table id="tableTop">
    <tr>
      <td>课程管理</td>
    </tr>
    <tr>
      <td>
        <a href="sysAdm/addCourse.jsp" >增加</a>
      </td>
      <form action="indexCourse.jsp?action=102" method="post" name="inqForm">
        <td>关键字:
          <label><input name="strKey" type="text" value="${sessionScope.strKey}">
          <select name="strType" id="select">
            <option value="sCname" <%if (session.getAttribute("strType") == "sCname") {%> selected <%}%>>课程名</option>
            <option value="sTeacher"<%if (session.getAttribute("strType") == "sTeacher") {%> selected <%}%>>教师</option>
          </select>
            <input type="button" name="button"  value="重置" onclick="clearData()">
            <input type="submit" name="button" value="搜索">
        </label>
        </td>
      </form>
    </tr>
  </table>

  <table id="tableList" >
    <tr><th scope="col">课程编号</th>
    <th scope="col">课程名称</th>
    <th scope="col">开课日期</th>
    <th scope="col">教师</th>
    <th scope="col">周数</th>
    <th scope="col">在线学习链接</th>
    <th scope="col">状态</th>
    <th scope="col">操作</th>
    </tr>
    <%
      if (list != null && list.size() > 0) {
        for (Course course : list) {
    %>
    <tr><td><%=course.getsCourseNo()%></td>
      <td><%=course.getsCname()%></td>
      <td><%=course.getDtOpenDate()%></td>
      <td><%=course.getsTeacher()%></td>
      <td><%=course.getiWeekCnt()%></td>
      <td><%=course.getsIndexURL()%></td>
      <td><%=course.getsStatuse()%></td>
    </tr>
    <%
        }
      }
    %>

    <th>当前页数<%=iPage%>/<%=iPageCnt%>&nbsp;
      <%if (iPage > 1) {
      %>
        <a href="indexCourse.jsp?action=109&page=1">第一页</a>
        <a href="indexCourse.jsp?action=109&page=<%=iPage - 1%>">上一页</a>
      <%}
        if (iPage < iPageCnt) {
      %>
        <a href="indexCourse.jsp?action=109&page=<%=iPage + 1%>">下一页</a>
        <a href="indexCourse.jsp?action=109&page=<%=iPageCnt%>">页尾</a>
      <%}
      %>
    </th>

  </table>

  </body>
</html>
