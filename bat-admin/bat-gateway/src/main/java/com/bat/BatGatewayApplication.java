package com.bat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestController
@SpringBootApplication
public class BatGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatGatewayApplication.class, args);
    }

    @GetMapping("/")
    public String indexMsg(HttpServletRequest request) {
        String addr = request.getRemoteAddr();
        int port = request.getLocalPort();
        return LocalDateTime.now().toString() + "####addr:" + addr + "####port:" + port;
    }
}
