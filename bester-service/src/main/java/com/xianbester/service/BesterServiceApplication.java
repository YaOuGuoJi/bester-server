package com.xianbester.service;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author liuwen
 */
@EnableScheduling
@EnableDubboConfiguration
@SpringBootApplication
@MapperScan("com.xianbester.service.dao")
@ServletComponentScan
public class BesterServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BesterServiceApplication.class, args);
    }

}

