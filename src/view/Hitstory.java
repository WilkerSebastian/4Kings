package view;

import application.FourKings;

public class Hitstory {
    
    public static void show() {

        try {

            FourKings.clear();

            String history = FourKings.readFile("./assets/history/4kings.txt");

            System.out.print(history + 
            "\n(0) voltar" +
            "\n\nOpção: ");

            FourKings.in.next();

        } catch (Exception e) {

            return;

        }

    }

}
