package kings;

import java.io.IOException;

import application.FourKings;

public class King {
    
    private String name;
    private int reputation;

    public King(String name, int reputation) {
        this.name = name;
        this.reputation = reputation;
    }

    public void addReputatio(int reputation) {

        if(this.reputation + reputation <= 0) {

            this.reputation = 0;
            return;
            
        }
        if(this.reputation + reputation >= 100) {
            
            this.reputation = 100;
            return;

        }

        this.reputation += reputation;

    }

    public String end() throws IOException {

        if (this.name == "Conspiracy")
            return FourKings.readFile("./assets/history/ends/real_end.txt");

        return FourKings.readFile("./assets/history/ends/" + this.name + '_' + this.reputation + ".txt");

    }

    public String getName() {
        return name;
    }

    public int getReputation() {
        return reputation;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.reputation;
    }
}
