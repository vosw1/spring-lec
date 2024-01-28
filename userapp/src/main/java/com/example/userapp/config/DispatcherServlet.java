package com.example.userapp.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("*.do") // '/*'하면 리다이렉션 요청도 다 들어오기에 또 로직이 필요함
//FrontController와 동일 = Dispatcher
public class DispatcherServlet extends HttpServlet { // 단일 진입점

    // http://localhost:8080/a.do?smd=join 쿼리 스트링을 이용
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 공통 로직
        System.out.println("시간 출력~~~~~");
        resp.setHeader("Content-type", "text/html; charset=utf-8"); // 한글 깨짐 해결

        // 2. 분기
        // cmd를 받아야 함 or join.do로 해서 해도 됨
        String uri = req.getRequestURI(); // 끝에 있는 값 받기
        System.out.println(uri);

        if(uri.equals("/join-form.do")){
            //resp.sendRedirect("/WEB-INF/user/join-form.jsp");
            req.getRequestDispatcher("/WEB-INF/user/join-form.jsp").forward(req, resp);
        }else if(uri.equals("/join.do")){
            //resp.sendRedirect("/WEB-INF/user/join.jsp");
            req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
        }else if(uri.equals("/main.do")){
            //resp.sendRedirect("/WEB-INF/board/main.jsp");
            req.getRequestDispatcher("/WEB-INF/board/main.jsp").forward(req, resp);
        }else{
            resp.setStatus(404);
            resp.getWriter().println("잘못된 페이지를 요청하셨어요");
        }
    }
}