package com.example.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 실행 파라미터
        // http://localhost:8080/request-param?username=hello&age=20
        // http://localhost:8080/request-param?username=hello&age=20&username=pjh

        /**
         * # HTTP 요청 데이터 - GET 쿼리 파라미터
         * 메시지 바디 없이, URL의 쿼리 파라미터를 사용해서 데이터를 전달
         * 복수 파라미터에서 같은 이름을 사용할 시 첫번째 파라미터 값을 반환한다.
         *
         * # HTTP 요청 데이터 POST HTML Form 일 경우
         *
         * content-type: application/x-www-form-urlencoded
         * 메시지 바디에 쿼리 파리미터 형식으로 데이터를 전달
         * => request.getParameter로 받을 수 있다.
         *
         * POSTMAN 사용시
         * Body x-www-form-urlencoded 선택
         * Headers에서 content-type: application/x-www-form-urlencoded 로 지정된 부분 꼭 확인
         *
         *
         * # HTTP 요청 데이터 - API 메시지 바디 - 단순 텍스트
         *  HTTP message body에 데이터를 직접 담아서 요청
         *  HTTP API에서 주로 사용, JSON, XML, TEXT => JSON이 주력임
         */


        System.out.println("[전체 파라미터 조회] - 조회");

        request.getParameterNames().asIterator().forEachRemaining(paramName
                -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] = end" );
        System.out.println();

        // 복수의 값일 경우 첫번째 값만 리턴한다.
        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);

        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("request.getparameterValues(username)");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("useranme= " + name);
        }

        response.getWriter().write("ok");
    }
}
