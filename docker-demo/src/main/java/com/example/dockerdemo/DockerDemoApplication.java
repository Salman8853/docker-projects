package com.example.dockerdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DockerDemoApplication {

    @GetMapping(value = "/welcome",produces = {"application/json"})
    public String greetMsg(){
        return "Welcome Puddua...!! I love you.";
    }



    public static void main(String[] args) {
        SpringApplication.run(DockerDemoApplication.class, args);
    }

}

