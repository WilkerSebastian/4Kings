package kings;

public class King {
    
    private String name;
    private int reputation;

    public King(String name, int reputation) {
        this.name = name;
        this.reputation = reputation;
    }

    public void addReputatio(int reputation) {

        this.reputation += reputation;

    }

    public void removeReputatio(int reputation) {

        if (this.reputation - reputation < 0) {
            
            this.reputation = 0;

        }

        this.reputation -= reputation;

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
