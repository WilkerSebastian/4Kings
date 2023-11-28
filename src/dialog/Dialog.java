package dialog;

import java.io.File;
import java.io.IOException;

import application.FourKings;
import kings.King;

public class Dialog {
    
    private Consequence fisrtConsequence;
    private Consequence secondConsequence;
    private boolean sensitiveToYes;
    public String output;

    public Dialog() throws IOException {

        String king = getRandomKing();

        int size_foldar = new File("./asset/" + king).listFiles().length;

        int seed = (int)Math.random() * size_foldar;

        String [] blob = FourKings.readFile("./asset/" + king + '/' + king + '_' + seed + ".txt").split("$");

        this.output = blob[0];

        fisrtConsequence = new Consequence();
        fisrtConsequence.positiveKing = getKingByName(blob[1]);
        fisrtConsequence.positive = Integer.parseInt(blob[2]);
        fisrtConsequence.negativeKing = getKingByName(blob[3]);
        fisrtConsequence.negative = Integer.parseInt(blob[4]);

        secondConsequence = new Consequence();
        secondConsequence.positiveKing = getKingByName(blob[5]);
        secondConsequence.positive = Integer.parseInt(blob[6]);
        secondConsequence.negativeKing = getKingByName(blob[7]);
        secondConsequence.negative = Integer.parseInt(blob[8]);

        this.sensitiveToYes = Integer.parseInt(blob[9]) != 0;

    }

    public void trigger(boolean yes) {
        
        if (yes) {
            
            if (this.sensitiveToYes) {
                
                this.applyFirst();
                return;

            }

            this.applySecond();
            return;

        } else if (!this.sensitiveToYes) {

            this.applyFirst();
            return;

        }

        this.applySecond();

    }

    private void applyFirst() {

        this.fisrtConsequence.positiveKing.addReputatio(this.fisrtConsequence.positive);

        this.fisrtConsequence.negativeKing.addReputatio(this.fisrtConsequence.negative);

    }

    private void applySecond() {

        this.secondConsequence.positiveKing.addReputatio(this.secondConsequence.positive);

        this.secondConsequence.negativeKing.addReputatio(this.secondConsequence.negative);

    }

    private King getKingByName(String name) {

        switch (name) {
            case "Inveractus":

                return FourKings.Inveractus;
            case "Aridum":

                return FourKings.Aridum;
            case "Flachland":

                return FourKings.Flachland;
        }

        return FourKings.Fluss;

    }

    private String getRandomKing() {

        int seed = (int)Math.random() * 4 + 1;

        switch (seed) {
            case 1:

                return "Inveractus";
            case 2:
                
                return "Aridum";
            case 3:

                return "Flachland";
        }

        return "Fluss";

    }

}