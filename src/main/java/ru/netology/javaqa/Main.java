package ru.netology.javaqa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Ticket ticket1 = new Ticket("LED", "MSC", 2_000, 20, 23);
        Ticket ticket2 = new Ticket("MSC", "LED", 4_000, 20, 23);

        System.out.println(ticket1.compareTo(ticket2));
        Ticket[] tickets = {ticket1, ticket2};
        Arrays.sort(tickets);
    }
}