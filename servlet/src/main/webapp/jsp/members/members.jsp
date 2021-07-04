<%@ page import="com.example.servlet.domain.member.MemberReponsitory" %>
<%@ page import="com.example.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  MemberReponsitory memberReponsitory = MemberReponsitory.getInstance();
  List<Member> members = memberReponsitory.findAll();
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>members search</title>
</head>
<body>
<table>
  <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
  </thead>
  <tbody>
  <%
    for(Member member : members) {
      out.write("   <tr>");
      out.write("     <td>" + member.getId() + "</td>");
      out.write("     <td>" + member.getUsername() + "</td>");
      out.write("     <td>" + member.getAge() + "</td>");
      out.write("   </tr>");
    }
  %>
  </tbody>
</table>
</body>
</html>
