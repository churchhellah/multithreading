package org.threads.service.impl;

import org.threads.service.TicketGenerator;

import java.util.Random;

public class TicketGeneratorImpl implements TicketGenerator {
    @Override
    public String generateTicket() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String ticketId = salt.toString();
        return ticketId;
    }
}