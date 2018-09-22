<%@ page import="src.util.StringUtils" %><%--
  Created by IntelliJ IDEA.
  User: z
  Date: 2018/8/30
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>web test</title>

    <script type="text/javascript" src="/jslib/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('#cde').attr('src','code?s='+Math.random());
            $('#cde').click(function () {
                $('#cde').attr('src','code?p='+Math.random());
            });

        });
    </script>
  </head>
  <body>
    <form action="login" method="post">
      <table >
        <tr>
          <td>name</td>
          <td><input type="text" name="username"/>
            <span ><%=StringUtils.getInfo(request,"username") %></span>
          </td>
        </tr>
        <tr>
          <td>password</td>
          <td><input type="password" name="password"/>
            <span ><%=StringUtils.getInfo(request,"password") %></span>
          </td>
        </tr>
        <tr>
          <td>check code</td>
          <td><input type="text" name="code"/>
            <span ><%=StringUtils.getInfo(request,"code") %></span>
          </td>
        </tr>
        <tr>
          <td><img id="cde"></td>
          <td>click pic to refresh</td>
          <%--<td><img src="/code"></td>--%>
          <%--<td>click pic to refresh</td>--%>
        </tr>
        <tr>
          <td><input type="submit" value="login"/> </td>
          <td><input type="reset" value="reset"/> </td>
          <td><input type="button" value="register"/></td>
        </tr>
      </table>
    </form>



  </body>
</html>
