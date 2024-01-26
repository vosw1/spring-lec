package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController { //main을 바로 호출하는 컨트롤러

    @GetMapping("/main")
    public String main() {
        return "main";
    }
}
