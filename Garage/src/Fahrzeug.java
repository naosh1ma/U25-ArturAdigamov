import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fahrzeug {


    // Attributen
    private String typ;
    private String kfzID;
    private Parkplatz platzID;

    // Konstruktoren
    public Fahrzeug(String kfzID, String typ, Parkplatz platz) {
        this.kfzID = kfzID;
        this.typ = typ;
        this.platzID = platz;
    }

    public Fahrzeug(String kfzID, String typ) {
        this(kfzID, typ, null);
    }

    public Fahrzeug() {
        this("", "", null);
    }


    // Methoden
    public Fahrzeug[] add(Fahrzeug[] arr) {
        int i;
        Fahrzeug[] retVal;
        // Neues Array erzeugen
        if (arr == null) {
            retVal = new Fahrzeug[1];
        } else {
            if (arr.length == 0) {
                retVal = new Fahrzeug[1];
            } else {
                retVal = new Fahrzeug[arr.length + 1];
            }
        }
        // Array kopieren
        for (i = 0; i < retVal.length - 1; i++) {
            retVal[i] = arr[i]; // Alten Arrayinhalte kopieren
        }
        retVal[i] = this;
        return retVal;
    }

    public Fahrzeug[] del(Fahrzeug[] arr) {
        int i = 0, j = 0;
        Fahrzeug[] retVal = null;
        if (arr != null) {
            retVal = new Fahrzeug[arr.length - 1];
            while (i < arr.length) {
                if (arr[i] != this) {
                    retVal[j] = arr[i]; // alten Arrayinhalt kopieren
                    i++; // Zaehler fuer altes Array erhoehen
                    j++; // Zaehler fuer neues Aray uebernehmen
                } else {
                    i++; // alten Feld i ueberspringen
                }
            }
        }
        return retVal;
    }

    public static boolean checkSign(String sign) {
        boolean retVal = true;
        try{
            Pattern p = Pattern.compile("[A-Z]{1,3}-[A-Z]{1,2}\\s[1-9][0-9]{0,3}");
            Matcher m = p.matcher(sign.toUpperCase());
            retVal = m.matches();
        }
        catch(Exception ex){
            retVal = false;
        }
        return retVal;
    }

    // Getter und Setter
    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getKfzID() {
        return kfzID;
    }

    public void setKfzID(String kfzID) {
        this.kfzID = kfzID;
    }

    public Parkplatz getPlatzID() {
        return platzID;
    }

    public void setPlatzID(Parkplatz platzID) {
        this.platzID = platzID;
    }
}
