package io.atlant.ledger.config;

import io.atlant.ledger.model.Balance;
import io.atlant.ledger.repository.BalanceRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class BalanceConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(BalanceRepo balanceRepo) {
        return args -> {
            Balance balance1 = new Balance(234323423);
            Balance balance2 = new Balance(519955);
            Balance balance3 = new Balance(51995544);
            balanceRepo.saveAll(Arrays.asList(balance1, balance2, balance3));
        };
    }
}
