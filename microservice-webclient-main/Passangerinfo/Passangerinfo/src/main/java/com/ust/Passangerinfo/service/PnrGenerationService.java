package com.ust.Passangerinfo.service;

import com.ust.Passangerinfo.repo.Passengerrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PnrGenerationService {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int PNR_LENGTH = 6;

    @Autowired
    private Passengerrepo passengerRepository;

    public String generatePnr() {
        String pnr;
        do {
            pnr = generateRandomPnr();
        } while (passengerRepository.existsByPnr(pnr));
        return pnr;
    }

    private String generateRandomPnr() {
        Random random = new Random();
        StringBuilder pnr = new StringBuilder(PNR_LENGTH);

        for (int i = 0; i < PNR_LENGTH; i++) {
            pnr.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return pnr.toString();
    }
}

