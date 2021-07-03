package com.example.servlet.basic.response;

import com.example.servlet.basic.dto.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 반환타입이 application/json이면 json 결과로 반환함
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        HelloData data = new HelloData();
        data.setUsername("park");
        data.setAge(34);
        // objectMapper.writeValueAsString(data) 는 HelloData 형태를 JSON String화 시켜준다.
        // response.getWriter()는 response body를 write를 할 수 있는 객체임
        // response.getWriter().write(response body에 입력할 내용)
        response.getWriter().write(objectMapper.writeValueAsString(data));
    }
}
