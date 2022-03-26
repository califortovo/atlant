package io.atlant.ledger.service;

import io.atlant.ledger.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    private UserRepo userRepo;

    @Autowired
    public void setUserRepo(UserRepo userRepo) {
        this.userRepo = userRepo;
    }



}
