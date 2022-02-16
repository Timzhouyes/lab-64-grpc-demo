package cn.iocoder.springboot.lab64.userservice;

import java.util.concurrent.CountDownLatch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserServiceApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(UserServiceApplication.class, args);
        new CountDownLatch(1).await();
    }

}
