package com.example.servlet.basic.request;

import com.example.servlet.basic.dto.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * # HTTP 요청 데이터 - API 메시지 바디 - 단순 텍스트
         *  HTTP message body에 데이터를 직접 담아서 요청
         *  HTTP API에서 주로 사용, JSON, XML, TEXT => JSON이 주력임
         *  URL: http://localhost:8080/request-body-json
         *
         *  {
         *      "username": "hello",
         *      "age": 20
         *  }
         *
         *  message body를 객체로 파싱할 수 있다.
         *  필요사항
         *  1) DTO 객체 : HelloData
         *  2) ObjectMapper
         *
         *  ObjectMapper는 Jackson 라이브러리에 포함된 API이며,
         *  Jackson은 스프링부트에 기본적으로 탑재되어 있는 라이브러리이다.
         */

        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);
        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println("helloData = " + helloData);
        response.getWriter().write("ok");
    }
}
