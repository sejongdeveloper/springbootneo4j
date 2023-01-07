package me.whiteship.springbootneo4j;

import me.whiteship.springbootneo4j.account.Account;
import me.whiteship.springbootneo4j.account.AccountRepository;
import me.whiteship.springbootneo4j.account.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setEmail("aaaa@mail.com");
        account.setUsername("aaaa");

        Role role = new Role();
        role.setName("user");

        account.getRoles().add(role);

        accountRepository.save(account);

        System.out.println("finished");
    }
}
