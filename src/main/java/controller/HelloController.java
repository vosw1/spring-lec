package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class HelloController {

    public HelloController(){
        System.out.println("HelloController 컴포넌트 스캔됨");
    }

    @GetMapping("home")
    public void home() { //HelloControlle가 new 되서 찾을 수 있음, 다른 패키지는 뜨지 않음
        System.out.println("home 호출됨");
    }

    @GetMapping("/hello")
    public String hello(){
        String name = "홍길동";
        return "<h1>hello "+name+"</h1>";
    }

    @GetMapping("/random")
    public String random(){
        Random r = new Random();
        int num = r.nextInt(5)+1; // 0부터 시작하니까 +1을 해줘야 함
        return "<h1>random "+num+"</h1>";
    }
}