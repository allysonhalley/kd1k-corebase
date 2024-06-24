package com.kd1k.corebase;

import org.springframework.boot.SpringApplication;

public class TestCorebaseApplication {

    public static void main(String[] args) {
        SpringApplication.from(CorebaseApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
