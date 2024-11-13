package com.security.login;

import org.springframework.stereotype.Service;

@Service
public class Services{

    private final Repo repo;

    public Services(Repo repo) {
        this.repo = repo;
    }

    public boolean isUser(String email,String password){
        User realUser=repo.findByMail(email);
        if(realUser != null && realUser.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public void createUser(String email, String password) {
        repo.save(new User(email, password));
    }
}
