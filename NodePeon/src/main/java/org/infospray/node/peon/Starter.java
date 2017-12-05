package org.infospray.node.peon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class Starter {

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(Starter.class, args);
    }
}