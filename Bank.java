package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    public static Map<Integer, Client> users = new HashMap<>();


    public static void createUser(Client client) {
        users.put(client.number, client);
    }

    public static void deleteUser(Client client) {
        users.remove(client.number);
    }

    public static double totalSum() {
        double total = 0;
        for (Map.Entry<Integer, Client> j : users.entrySet()) {
            System.out.println(j.getValue().account.currency + ": ");
            double exchange_rate;
            Scanner input = new Scanner(System.in);
            exchange_rate = input.nextDouble();
            total += j.getValue().account.money*exchange_rate;

        }
        return total;
    }


}
