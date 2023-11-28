package view;

import java.io.IOException;

import application.FourKings;

public class Menus {
    
    public static int view(String dialog) {

        int op;

        try {

            FourKings.clear();
            System.out.print(
                "------------------------------\n" +
                "semanas: " + FourKings.weeks + '\n' +
                FourKings.Inveractus + '\n' +
                FourKings.Aridum + '\n' +
                FourKings.Flachland + '\n' +
                FourKings.Fluss + '\n' +
                "------------------------------\n");
            
            System.out.println(dialog);
            
            System.out.print(
            "------------------------------\n" + 
            "(1) SIM    (2) NÃO    (0) SAIR\n" +
            "------------------------------\n" +
            "Opção: ");

            op = Integer.parseInt(FourKings.in.nextLine());

            if (op < 0 || op > 2) {
             
                throw new IOException();

            }
            
        } catch (Exception e) {
            
            return view(dialog);

        }

        return op;

    }

    public static int intro() {

        int op = 0;

        try {
            
            FourKings.clear();
            System.out.print(
            " _  _     _  _____ _   _  ____ ____  \n" + 
            "| || |   | |/ /_ _| \\ | |/ ___/ ___| \n" + 
            "| || |_  | ' / | ||  \\| | |  _\\___ \\ \n" + 
            "|__   _| | . \\ | || |\\  | |_| |___) |\n" + 
            "   |_|   |_|\\_\\___|_| \\_|\\____|____/\n\n" +
            "(1) JOGAR\n\n" +
            "(2) HISTÓRIA\n\n" +
            "(3) SAIR\n\n" +
            "Opção: ");

            op = Integer.parseInt(FourKings.in.nextLine());

            if (op < 1 || op > 3) {
                
                throw new IOException();

            }

        } catch (Exception e) {
            
            intro();

        }
                

        return op;

    }

}
