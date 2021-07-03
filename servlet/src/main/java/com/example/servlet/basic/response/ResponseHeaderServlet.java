package com.example.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     *
     * Response의 Header 사용에 대한 예제
     */

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);

        // Content-type을 입력할 수 있는 두 가지 방식
        // 1. response.setHeader("Content-Type", "text/plain;charset=utf-8");
        // 2. response.setContentType("text/plain")
        //    response.setCharacterEncoding("utf-8");

        // response.setHeader를 이용해서 Header에 값을 입력할 수 있다.
        // response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");

        content(response);
        cookie(response);
        redirect(response);

    }

    private void redirect(HttpServletResponse response) throws IOException {
        // Status Code 302
        // Location: /basic/hello-form.html

        /**
        response.setStatus(HttpServletResponse.SC_FOUND);

         리다이렉트 할 수 있는 두 가지 방식
         1. setHeader를 이용한 방식
            예) response.setHeader("Location", "/basic/hello-from.html");
         2. response.sendRedirect를 사용하는 방식
            예) response.sendRedirect("/basic/hello-form.html");

         */
        response.sendRedirect("/basic/hello-form.html");
    }

    private void cookie(HttpServletResponse response) {
        /**
         * 쿠키 사용하는 방법
         * 1) Cookie 객체 생성
         *      Cookie cookie = new Cookie("키값", "저장할 값");
         * 2) Cookie 객체의 유효시간 설정
         *      cookie.setMaxAge(600);
         * 3) response객체 안에 담기
         *      response.addCookie(cookie);
         */

        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private void content(HttpServletResponse response) {
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
    }
}
