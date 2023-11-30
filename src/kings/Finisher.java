package kings;

import java.io.IOException;

import application.FourKings;
import view.Hitstory;

public class Finisher {

    public static boolean toCheck() {

        if (FourKings.Conspiracy.getReputation() == 100 || FourKings.Conspiracy.getReputation() == 0)
            return true;

        else if (FourKings.Aridum.getReputation() == 100 || FourKings.Aridum.getReputation() == 0) 
            return true;

        else if (FourKings.Flachland.getReputation() == 100 || FourKings.Flachland.getReputation() == 0) 
            return true;

        else if (FourKings.Inveractus.getReputation() == 100 || FourKings.Inveractus.getReputation() == 0) 
            return true;

        else if (FourKings.Fluss .getReputation() == 100 || FourKings.Fluss.getReputation() == 0) 
            return true;

        return false;

    }


    public static void showEnd() throws IOException {

        boolean real = false;
        String end = "";

        if (FourKings.Conspiracy.getReputation() == 100 || FourKings.Conspiracy.getReputation() == 0) {
            end = FourKings.Conspiracy.end();
            real = true;
        }
        else if (FourKings.Aridum.getReputation() == 100 || FourKings.Aridum.getReputation() == 0) 
            end = FourKings.Aridum.end();

        else if (FourKings.Flachland.getReputation() == 100 || FourKings.Flachland.getReputation() == 0) 
            end = FourKings.Flachland.end();

        else if (FourKings.Inveractus.getReputation() == 100 || FourKings.Inveractus.getReputation() == 0) 
            end = FourKings.Inveractus.end();

        else if (FourKings.Fluss .getReputation() == 100 || FourKings.Fluss.getReputation() == 0) 
            end = FourKings.Fluss.end();

        Hitstory.ending(end, real);       

    };
    
}