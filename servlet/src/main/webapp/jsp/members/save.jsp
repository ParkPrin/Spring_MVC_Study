<%@ page import="com.example.servlet.domain.member.MemberReponsitory" %>
<%@ page import="com.example.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
  MemberReponsitory memberReponsitory = MemberReponsitory.getInstance();

  System.out.println("save.jsp");
  String username = request.getParameter("username");
  int age = Integer.parseInt(request.getParameter("age"));

  Member member = new Member(username, age);
  System.out.println("member = " + member);
  member = memberReponsitory.save(member);
%>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<ul>
  <li>id= <%=member.getId()%></li>
  <li>username= <%=member.getUsername()%></li>
  <li>age= <%=member.getAge()%></li>
</ul>
<a href="/index.html"></a>
</body>
</html>
