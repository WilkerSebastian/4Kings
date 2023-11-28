package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import dialog.Dialog;
import kings.King;
import view.Hitstory;
import view.Menus;

public class FourKings {

    public static King Inveractus;
    public static King Aridum;
    public static King Flachland;
    public static King Fluss;

    public static Scanner in;

    public static long weeks;
    
    public static void main(String[] args) {

        weeks = 0;
        
        Inveractus = new King("Inveractus", 50);
        Aridum = new King("Aridum", 50);
        Flachland = new King("Flachland", 50);
        Fluss = new King("Fluss", 50);

        in = new Scanner(System.in);

        int op;

        try {

            do {

                clear();

                op = Menus.intro();

                switch (op) {
                    case 1:

                        gameLoop();                        
                        break;
                    case 2:

                        Hitstory.show();
                        break;
                }
                
            } while (op != 3);

        } catch (Exception e) {
            
            e.printStackTrace();

        } finally {

            in.close();

        }

    }

    public static void gameLoop() {

        try {

            String output;

            Dialog dialog = null;

            if (weeks == 0)
                output = readFile("./assets/dialog/first.txt");
            else {
                dialog = new Dialog();
                output = dialog.output;
            }
            
            int selection = Menus.view(output);

            if (selection > 0) {
                
                if (weeks > 0)
                    dialog.trigger(selection == 1);

                weeks++;

                gameLoop();

            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void clear() {

        String os = System.getProperty("os.name").toLowerCase();
        String command = (os.contains("win")) ? "cmd /c cls" : "clear";

        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.inheritIO();
    
        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static String readFile(String path) throws FileNotFoundException, IOException {

        FileReader fileReader = new FileReader(path);

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        String result = "";

        while ((line = bufferedReader.readLine()) != null) {

            result += (line + '\n');

        }

        bufferedReader.close();

        return result;

    }

}
