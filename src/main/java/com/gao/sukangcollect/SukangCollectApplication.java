package com.gao.sukangcollect;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gao.sukangcollect.mapper")
public class SukangCollectApplication {
    public static void main(String[] args) {
        SpringApplication.run(SukangCollectApplication.class, args);
    }
}
