package io.atlant.ledger.service;

import io.atlant.ledger.model.Balance;
import io.atlant.ledger.repository.BalanceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
public class BalanceService {

    private BalanceRepo balanceRepo;

    @Autowired
    public void setBalanceRepo(BalanceRepo balanceRepo) {
        this.balanceRepo = balanceRepo;
    }

    public List<Balance> findAll() {
        return (List<Balance>) balanceRepo.findAll();
    }

    public Balance findCurrentBalance() {
        return balanceRepo.findFirstByOrderBySum();
    }

    public void saveBalance(Balance balance) {

        if (Objects.equals(balanceRepo.findFirstByOrderBySum().getSum(), balance.getSum())) return;

        balanceRepo.save(balance);

    }

    public void deleteBalance(Long id) {

        // Good practise
        if (!(balanceRepo.existsById(id)))
            throw new IllegalStateException(Balance.class.getName() + "with id " + id + " doesn't exist");


        balanceRepo.deleteById(id);

    }

    @Transactional
    public void updateBalance(Long id, int sum) {
        Balance balance = balanceRepo.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "dfdfdsf"
                ));

        if (sum > 0) {
            balance.setSum(sum);
        }

    }
}
