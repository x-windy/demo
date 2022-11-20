<%--
  Created by IntelliJ IDEA.
  User: zq
  Date: 2022/11/18
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改课程</title>
</head>
<body>
<form action="#" method="post">
    <table>
        <tr>
            <th>修改课程记录</th>
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
            <td><input type="text" name="dtOpenDate"></td>
        </tr>
        <tr>
            <td>教师</td>
            <td><select name="sTeacher"></select></td>
        </tr>
        <tr>
            <td>周数</td>
            <td><input type="text" name="iWeekCnt"></td>
        </tr>
        <tr>
            <td>在线学习链接</td>
            <td><input type="text"></td>
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
            <td><input type="text"></td>
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
