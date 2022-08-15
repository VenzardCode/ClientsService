package com.example.clientsservice;

import com.example.clientsservice.models.Account;
import com.example.clientsservice.models.Client;
import com.example.clientsservice.models.Phone;
import com.example.clientsservice.repositories.AccountRepository;
import com.example.clientsservice.repositories.ClientRepository;
import com.example.clientsservice.repositories.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;

@SpringBootApplication
public class ClientsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientsServiceApplication.class, args);
    }
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PhoneRepository phoneRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void applicationReady(){

        Client client=new Client(0,"a","a", LocalDate.now(),"111","e111");
        client=clientRepository.save(client);
        System.err.println(client);
        client.setSurname("A");
        clientRepository.save(client);
        clientRepository.delete(client);
        System.err.println();
        clientRepository.findAll().forEach(System.err::println);
        //
        System.err.println("New phone");
        Phone phone=new Phone(0,420.22);
        phone=phoneRepository.save(phone);
        System.err.println(phone);
        phone.setAmount(420.69);
        phoneRepository.save(phone);
        System.err.println("Alter phone");
        System.err.println(phone);
        System.err.println("Delete phone...");
        phoneRepository.delete(phone);
        System.err.println("Print all phones");
        phoneRepository.findAll().forEach(System.err::println);
        System.err.println();

        //
        System.err.println("New account");

        Account account=new Account(0,"+3808291829383");
        account=accountRepository.save(account);
        System.err.println(account);
        account.setPhone("+38066788189623");
        accountRepository.save(account);
        System.err.println("Alter account");
        System.err.println(account);
        System.err.println("Delete account...");
        accountRepository.delete(account);
        System.err.println("Print all accounts");
        accountRepository.findAll().forEach(System.err::println);
    }

}
