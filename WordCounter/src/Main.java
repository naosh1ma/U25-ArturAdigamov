import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //werkzeuge erschaffen
        String eingabe;  // variablen deklarieren
        System.out.print(CS.RED_BRIGHT + "Bitte geben Sie ein: ");
        eingabe = sc.nextLine(); // variablen initialisieren
        System.out.println();
        ausgabe(eingabe);
        str_Forme(eingabe, str_Frage());
        sc.close();
    }

    public static void str_Forme(String eingabe, int typ) {
        switch (typ) {
            case 1:
                System.out.println();
                str_Umg(eingabe);
                break;
            case 2:
                System.out.println();
                str_Unten(eingabe);
                break;
            case 3:
                System.out.println();
                str_Pyr(eingabe);
                break;
        }
    }

    public static int str_Frage() {
        Scanner sc = new Scanner(System.in);
        int typ;
        System.out.println(CS.RED_BRIGHT);
        System.out.println("Wie willst du dein Text ausgeben?");
        System.out.print(CS.PURPLE_BRIGHT + "1) Umgekehrt, ");
        System.out.print(CS.CYAN_BRIGHT + "2) Nach unten, ");
        System.out.print(CS.GREEN_BRIGHT + "3) Als Pyramide : " + CS.RESET);
        typ = sc.nextInt();
        sc.close();
        return typ;
    }

    public static void str_Umg(String str) {// ausgabe umgekehrt
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(CS.PURPLE_BRIGHT + str.charAt(i));
        }
    }

    public static void str_Unten(String str) {// ausgabe nach unten
        for (int i = 0; i < str.length(); i++) {
            System.out.println(CS.CYAN_BRIGHT + str.charAt(i));
        }
    }

    public static void str_Pyr(String str) {// ausgabe als pyramide
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(CS.GREEN_BRIGHT + str.charAt(j));
            }
            System.out.println();
        }
    }

    public static int str_Symbol(String str) { // methode für buchstaben und sonderzeichen zu zählen
        int z = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') { // prüfen nach leerzeichen
                z++;
            }
        }
        return z;
    }

    public static int str_Zahlen(String str) { // methode für zahlen zu zählen
        int z = 0;
        char[] arr_zahl = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'}; // array mit gesuchten buchstaben erstellen
        for (int i = 0; i < str.length(); i++) {
            for (char c : arr_zahl) {
                if (str.charAt(i) == c) {
                    z++;
                    break;
                }
            }
        }
        return z;
    }

    public static int str_Zeichen(String str) { // methode für sonderzeichen zu zählen
        int z = 0;
        char[] arr_zeich = {',', '.', '-', '\'', '"', ';', ':', '+', '=', '?', '!', '@', '#', '$', '&', '*', '%'}; // array mit gesuchten buchstaben erstellen
        for (int i = 0; i < str.length(); i++) {
            for (char arrZeich : arr_zeich) {
                if (str.charAt(i) == arrZeich) {
                    z++;
                    break;
                }
            }
        }
        return z;
    }

    public static int str_Gross(String str) { //methode für große buchstaben zu zählen
        int z = 0;
        String temp_str = str.toLowerCase(); // erstelen neuen string mit lowercase von eingegebenen string
        for (int i = 0; i < str.length(); i++) {
            if (temp_str.charAt(i) != str.charAt(i)) {
                z++;
            }
        }
        return z;
    }

    public static int str_Vokal(String str) { // methode für vokale buchstaben zu zählen
        int z = 0;
        char[] arr_vok = {'A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u'}; // array mit gesuchten buchstaben erstellen
        for (int i = 0; i < str.length(); i++) {
            for (char c : arr_vok) {
                if (str.charAt(i) == c) { // array von gesuchten buchstaben mit array von buchstaben des strings vergleichen
                    z++;
                    break;
                }
            }
        }
        return z;
    }

    public static void ausgabe(String eingabe) { // methode für ausgabe
        System.out.println(CS.PURPLE_BRIGHT + "Buchstaben:       " + CS.YELLOW_BRIGHT + (str_Symbol(eingabe) - str_Zeichen(eingabe) - str_Zahlen(eingabe)));
        System.out.println(CS.CYAN_BRIGHT + "Grosse Buchstabe: " + CS.YELLOW_BRIGHT + str_Gross(eingabe));
        System.out.println(CS.GREEN_BRIGHT + "Vokale:           " + CS.YELLOW_BRIGHT + str_Vokal(eingabe));
    }
}
