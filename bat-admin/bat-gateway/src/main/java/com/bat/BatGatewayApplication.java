package com.bat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@Slf4j
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
        log.info("info####addr:{}####port:{}", addr, port);
        log.debug("debug####addr:{}####port:{}", addr, port);
        log.warn("warn####addr:{}####port:{}", addr, port);
        log.error("error####addr:{}####port:{}", addr, port);
        return LocalDateTime.now().toString() + "####addr:" + addr + "####port:" + port;
    }
}
