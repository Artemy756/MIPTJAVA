package org.example;

import java.util.Map;

import static org.example.Bank.users;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Иван","Петров",420942);
        Client client1 = new Client("Дима","Иванов",765842);
        client.createAccount(new Account(12313,"rub"));
        client1.createAccount(new Account(1313,"dollar"));
        Bank.createUser(client);
        Bank.createUser(client1);
        for (Map.Entry<Integer, Client> j : users.entrySet()){
            System.out.println(j.getKey()+": "+j.getValue().name+" "+j.getValue().last_name+" "+ j.getValue().account.money+" "+ j.getValue().account.currency);

        }
        System.out.println(Bank.totalSum());




    }
}