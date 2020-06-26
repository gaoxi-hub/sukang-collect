package com.gao.sukangcollect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.gao.sukangcollect.mapper")
@EnableScheduling
@EnableAsync
public class SukangCollectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SukangCollectApplication.class, args);
    }
}
