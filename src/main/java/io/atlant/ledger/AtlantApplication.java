package io.atlant.ledger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AtlantApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtlantApplication.class, args);
    }

}
