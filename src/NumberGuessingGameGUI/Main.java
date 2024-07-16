package NumberGuessingGameGUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MyJFrame gui = new MyJFrame();
                gui.setLocationRelativeTo(null);
                gui.setVisible(true);
            }
        });

//        if(args.length==0){
//            System.out.println("Bitte einen Startparameter angeben!");
//            System.out.println("  /C : Konsolenausgabe");
//            System.out.println("  /G : GUI Ausgabe");
//        } else {
//            String p = args[0].toUpperCase();
//            switch(p){
//                case "/C" : useCui(); break;
//                case "/G" : useGui(); break;
//                default: System.out.println("Falscher Parameter '"+p+"' !");
//            }
//        }
    }

    private static void useCui(){
        Zahlenraten game = new Zahlenraten();
        Scanner scanner = new Scanner(System.in);
        game.setOutput(new View(View.CONSOLE));
        // Eingabe der Intervallgrenzen
        System.out.println("Bitte untere Intervalgrenze eingeben: ");
        game.setMinZahl(scanner.nextInt());
        System.out.print("Bitte oberste Intervalgrenze eingeben: ");
        game.setMaxZahl(scanner.nextInt());
        // Spiel starten
        game.start();
    }
    private static void useGui() {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MyJFrame gui = new MyJFrame();
                gui.setLocationRelativeTo(null);
                gui.setVisible(true);
            }
        });
    }
}
