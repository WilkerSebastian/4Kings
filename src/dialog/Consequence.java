package dialog;

import application.FourKings;

public class Consequence {
    
    private final int max_arguments = 5;
    public int [] values;

    public Consequence(String blob) {

        this.values = new int[max_arguments];

        String [] results = blob.split(" ");

        for (int i = 0; i < max_arguments; i++) {

            values[i] = Integer.parseInt(results[i].trim());

        }

    }

    public void aplly() {

        for (int i = 0; i < this.values.length; i++) {
            
            int x = this.values[i];

            switch (i) {
                case 0:
                    
                    FourKings.Inveractus.addReputatio(x);
                    break;
            
                case 1:

                    FourKings.Aridum.addReputatio(x);
                    break;
                case 2:
                    
                    FourKings.Flachland.addReputatio(x);
                    break;
            
                case 3:

                    FourKings.Fluss.addReputatio(x);
                    break;
                case 4:

                    FourKings.Conspiracy.addReputatio(x);
                    break;
            }

        }

    }

}
