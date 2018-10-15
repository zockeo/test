<%@ page import="src.entity.User" %>
<%@ page import="java.util.List" %>

<%--
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

    <script type="text/javascript" src="/jslib/jquery.min.js"></script>

    <style>
    </style>

  </head>
  <body>
  <%
    Object obj = request.getAttribute("userlist");
      if(obj != null && ((List)obj).size() > 0 ) {
      List<User> ulist = (List<User>)obj;
  %>
    <table border="1">
      <thead>
        <tr>
          <th>id</th>
          <th>username</th>
          <th>role</th>
          <th>description</th>
          <th>action</th>
        </tr>
      </thead>
      <tbody>
      <%for(User uList:ulist){%>
        <tr>
          <td><%=uList.getId()%></td>
          <td><%=uList.getUsername()%></td>
          <td><%=uList.getRole().getName()%></td>
          <td><%=uList.getRole().getDesc()%></td>
          <td>details|modify|delete</td>
        </tr>
      <%}%>
      </tbody>
    </table>
  <%
    } else {
  %>
  <h2>no any information!</h2>
  <%}%>
  </body>
</html>
