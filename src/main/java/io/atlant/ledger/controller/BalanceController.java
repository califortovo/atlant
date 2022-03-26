package io.atlant.ledger.controller;

import io.atlant.ledger.model.Balance;
import io.atlant.ledger.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "balance")
public class BalanceController {

    private BalanceService balanceService;

    @Autowired
    private void setBalanceService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }


    @GetMapping
    public List<Balance> getBalance() {
        return balanceService.findAll();
    }

    @PostMapping
    public void saveBalance(@RequestBody Balance balance) {
        balanceService.saveBalance(balance);
    }

    @DeleteMapping(path = "{balanceId}")
    public void deleteBalance(@PathVariable("balanceId") Long id) {
        balanceService.deleteBalance(id);
    }

    @PutMapping(path = "{balanceId}")
    public void updateBalance(
            @PathVariable("balanceId") Long id,
            @RequestParam(required = false) Integer sum
    ) {
        balanceService.updateBalance(id, sum);
    }

}
