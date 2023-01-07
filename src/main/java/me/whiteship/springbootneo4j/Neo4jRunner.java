package me.whiteship.springbootneo4j;

import me.whiteship.springbootneo4j.account.Account;
import me.whiteship.springbootneo4j.account.Role;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Neo4jRunner implements ApplicationRunner {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setEmail("keesun@mail.com");
        account.setUsername("keesun");

        Role role = new Role();
        role.setName("admin");

        account.getRoles().add(role);

        Session session = sessionFactory.openSession();
        session.save(account);
        sessionFactory.close();

        System.out.println("finished");
    }
}
