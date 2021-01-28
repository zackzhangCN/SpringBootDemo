package cn.zack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConditionalApplication {
    public static void main(String[] args) {
        new SpringApplication(ConditionalApplication.class).run(args);
    }
}
