package io.github.bitfist.jcef.spring.example;

import io.github.bitfist.jcef.spring.application.JcefApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        JcefApplication.run(ExampleApplication.class, args);
    }
}
