package RomanArabicConverter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String wahl, zahl;

        do {
            System.out.println("Befehlauswahl");
            System.out.println("-------------");
            System.out.println("Roemische eingeben  (r)");
            System.out.println("Arabische eingeben  (a)");
            System.out.println("Programm beenden    (x)");
            wahl = scanner.nextLine();
            // Befehlausfuerung
            System.out.print("Eingabe: ");
            switch (wahl) {
                case "r":
                    zahl = scanner.nextLine();
                    System.out.println(zahl + ": " + roemArab(zahl));
                    break;
                case "a":
                    zahl = scanner.nextLine();
                    System.out.println(zahl + ": " + arabRoem(zahl));
                    break;
            }
        }
        while (!wahl.equals("x"));
    }

    /**
     * Die Methode arabRoem liefert fuer den uebergebenen Dezimalwert die entsprechende roemische Zahl
     *
     * @param zahl Umzuwandelnde Dezimalzahl
     * @return Raoemische Zahl
     */
    public static String arabRoem(String zahl) {
        StringBuilder roemzahl = new StringBuilder();
        String ziffer = "";
        int index = 0;
        String[] f_einer = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] f_zehner = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] f_hunderter = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] f_tausender = {"", "M", "MM", "MMM"};
        // Ueberprufung auf maximalen Zahl
        if (zahl.length() > 4) {
            return "Zahl zu lang!";
        } else {
            zahl = "000" + zahl;                                    // Fuerende Nullen einfuegen
            zahl = zahl.substring(zahl.length() - 4);   // Zahl wieder auf die letzten 4 Zeichen kuerzen
        }
        // Erzeugung der roemischen Zahl
        for (int i = zahl.length(); i > 0; i--) {
            ziffer = zahl.substring(i - 1, i);    // Zahl in Ziffern zerlegen und mit kleinster Stelle beginnen
            index = Integer.parseInt(ziffer);     // Ziffer in Integerwert konvertieren
            // Bestimmung der roemischen Zahlzeichen
            if (index != 0) {
                switch (i) {
                    case 1:
                        roemzahl.insert(0, f_tausender[index]);
                        break;
                    case 2:
                        roemzahl.insert(0, f_hunderter[index]);
                        break;
                    case 3:
                        roemzahl.insert(0, f_zehner[index]);
                        break;
                    case 4:
                        roemzahl.insert(0, f_einer[index]);
                        break;
                }
            }
        }
        return roemzahl.toString();
    }

    /**
     * Die Methode raoemArab rechnet die uebergebene roemische Zahl in einen dezimalen Wert ein.
     *
     * @param zahl Roemische Zahl
     * @return Dezimales Ergebnis
     */
    public static String roemArab(String zahl) {
        String zeichen = "";
        int wert = 0, summe = 0, i;
        for (i = 0; i < zahl.length() - 1; i++) {
            zeichen = String.valueOf(zahl.charAt(i));
            wert = zahlenWert(zeichen);
            if (wert < zahlenWert(String.valueOf(zahl.charAt(i + 1)))) {
                wert = wert * -1;
            }
            summe = summe + wert;
        }
        summe = summe + zahlenWert(String.valueOf(zahl.charAt(i)));
        return "" + summe;
    }

    public static int zahlenWert(String ziffer) {
        int retVal = 0;
        ziffer = ziffer.toUpperCase();
        retVal = switch (ziffer) {
            case "I" -> 1;
            case "V" -> 5;
            case "X" -> 10;
            case "L" -> 50;
            case "C" -> 100;
            case "D" -> 500;
            case "M" -> 1000;
            default -> retVal;
        };
        return retVal;
    }

}
