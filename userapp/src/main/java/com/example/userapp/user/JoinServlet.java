package com.example.userapp.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

//@WebServlet("/join")
public class JoinServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-type", "text/html; charset=utf-8"); //헤더에 바디를 설명
        // username=ssar&password=1234&email=ssar@nate.com

//        BufferedReader br = req.getReader();
//        String requestBody = "";
//        while(true){
//            String line = br.readLine();
//
//            if(line == null) break;
//
//            requestBody = requestBody + line;
//        }
//        System.out.println(requestBody);
        // 1. 파싱 쉽게 하기 -> 커퍼에 키값을 찾아줌
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        System.out.println("username : " + username);
        System.out.println("password : " + password);
        System.out.println("email : " + email);

        // 2. 유효성 검사(1000줄 정도 됨...)
        if(username.length() < 3 || username.length() > 10) { // 필터링으로 사용
            resp.getWriter().println("<h1>username 글자수가 3~10 사이여야 합니다.");
        }

        // 3. DB연결 -> DAO에 연결하기 위함

        // 4. DAO의 insert 메서드를 회출
        // 5. 메인 페이지 그리기
        // 6. 리다이렉트 : 내가 요청한 주소를 자기 안에 있는 다른 것을 응답해주는 것
        //resp.sendRedirect("/main"); // 톰캣이 만들어준 메서드
        resp.setStatus(302);
        resp.setHeader("Location", "/main"); // 헤더에 정보 담기
        resp.setHeader("clock", "12pm"); // 프로토콜이 없어서 안뜸
    }
}