package dialog;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import application.FourKings;

public class Dialog {
    
    public Consequence firstConsequence;
    private Consequence secondConsequence;
    public String output;
    public String optionFirst;
    public String optionSecond;

    public Dialog() throws IOException {

        Random random = new Random();

        String king = getRandomKing();

        int size_foldar = new File("./assets/" + king).listFiles().length;

        int seed = random.nextInt(size_foldar) ;

        String [] blob = FourKings.readFile("./assets/" + king + '/' + king + '_' + seed + ".txt").split("\\$");

        this.output = blob[0];

        firstConsequence = new Consequence(blob[1]);

        secondConsequence = new Consequence(blob[2]);

        optionFirst = blob[3].trim();

        optionSecond = blob[4].trim();

    }

    public void trigger(boolean first) {
        
        if (first) {
            
           this.firstConsequence.aplly();
           return;

        } 

        this.secondConsequence.aplly();

    }

    private String getRandomKing() {

        Random random = new Random();

        int seed = random.nextInt(4);

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