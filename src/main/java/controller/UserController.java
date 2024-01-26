package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@RestController // 리턴시 그 문자를 그대로 응답
@Controller // 리턴시 파일명을 찾아 응답해줌 -> 포워드 해주는 것
public class UserController { // 메모리에 띄워야 함

    @GetMapping("/joinForm")
    public String joinForm() {
        return "joinForm"; // 폴더이름도 확장자 생략 가능->뷰 리절브 클래스가 붙여줌 - 포워드(내부적 요청)와 동일
    }

    @PostMapping("/join")
    public String join(String username, String password, String email) {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("email");

        System.out.println("username : " + username);
        System.out.println("password : " + password);
        System.out.println("email : " + email);

        if (username.length() > 10) {
            return "error-404";
        }

        return "redirect:/main"; // 이미있으니 리다이렉션해야함
    }
}
