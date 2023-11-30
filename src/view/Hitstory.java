package view;

import java.io.IOException;

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

    public static void credits() {

        try {

            FourKings.clear();

            System.out.print(
                "------------ Créditos 4 KINGS --------------\n\n" +
                "Programador: Wilker Sebastian Afonso Pereira\n\n" +
                "Roterista: Grabiel Taveira Granja\n\n" +
                "--------------------------------------------\n"  +
                "(0) Sair\n" +
                "--------------------------------------------\n" +
                "Opção: "
            );

            FourKings.in.nextLine();
            return;
            
        } catch (Exception e) {
            credits();
            return;
        }

    }

    public static void ending(String end, boolean real) {

        try {

            FourKings.clear();
            
            System.out.print("------------- Final " + (real ? "Verdadeiro" : "Falso") + "-------------\n" +
            end + '\n' + 
            "---------------------------------------\n" +
            (real ? "Você sabe a verdade\n" : "Para saber a verdade, é necessário vivê-la ou concluí-la\n") +
            "---------------------------------------\n" +
            "Continuar(sim/não):  ");

            boolean continuar = FourKings.in.nextLine().equals("sim");

            if (continuar) {
                
                credits();
                return;

            }

            throw new IOException();

        } catch (Exception e) {
            ending(end, real);
            return;
        }

    }

}
