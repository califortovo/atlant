package io.atlant.ledger.repository;

import io.atlant.ledger.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BalanceRepo extends JpaRepository<Balance, Long> {

    // By default, the query definition uses JPQL
    @Query("SELECT b FROM Balance b WHERE b.id >= 0")
    Collection<Balance> finalAllBalances();

    Balance findFirstByOrderBySum();

}

