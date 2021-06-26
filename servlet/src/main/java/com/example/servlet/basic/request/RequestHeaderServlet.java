package com.example.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // extract method 기능:  ctrl + t 누른후 extract method 선택
        printHeaders(request);
        printStartLine(request);
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");
        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + request.getHeader(headerName)));
        System.out.println("--- Headers - end ---");
        System.out.println();
    }

    private void printStartLine(HttpServletRequest request) {
        System.out.println("-----REQUEST-LINE - start-----");
        String method = request.getMethod();
        System.out.println("method = " + method);
        String protocol = request.getProtocol();
        System.out.println("protocol = " + protocol);
        String scheme = request.getScheme();
        System.out.println("scheme = " + scheme);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL = " + requestURL);
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);
        String queryString = request.getQueryString();
        System.out.println("queryString = " + queryString);
        boolean secure = request.isSecure();
        System.out.println("secure = " + secure); // https인가 아닌가?

        System.out.println("-----REQUEST-LINE - end-----");
    }
}
