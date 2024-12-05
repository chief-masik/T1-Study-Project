package org.pyatakov.t1studyproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class T1StudyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(T1StudyProjectApplication.class, args);
    }

}
