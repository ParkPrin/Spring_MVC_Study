package com.example.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

        printHeaderUtils(request);

        printEtc(request);
    }

    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]"); // 서버에 접속한 클라이언트 정보
        System.out.println("request.getRemoteHost() = " +
                request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                request.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]"); // 서버에 접속한 클
        System.out.println("request.getLocalName() = " +
                request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " +
                request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " +
                request.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " + request.getServerName());
        System.out.println("request.getServerPort() = " + request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +locale));
        System.out.println("request.getLocale() = " + request.getLocale()); // 최상위 locale 정보를 반환한다.

        System.out.println();
        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }}
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
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
        System.out.println("requestURL = " + requestURL); // 전체 주소
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI); // 자원 주소
        String queryString = request.getQueryString();
        System.out.println("queryString = " + queryString);
        boolean secure = request.isSecure();
        System.out.println("secure = " + secure); // https인가 아닌가?

        System.out.println("-----REQUEST-LINE - end-----");
    }
}
