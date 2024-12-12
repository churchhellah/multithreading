package org.threads.service.impl;

import org.threads.service.TicketGenerator;

import java.util.Random;

public class TicketGeneratorImpl implements TicketGenerator {
    @Override
    public String generateTicket() {
        String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // Длина рандомной строки
            int index = (int) (rnd.nextFloat() * CHARS.length());
            salt.append(CHARS.charAt(index));
        }
        String ticketId = salt.toString();
        return ticketId;
    }
}