public class Parkplatz {


    // Attributen
    private int nummer;          // fortlaufende Parkplatz Nummer oder Text
    private boolean besetzt;     // true wenn Belegt sonst false
    private Etage eID;           // Objekt Etage

    // Konstruktoren
    public Parkplatz(Etage eID, int nummer) {
        this.eID = eID;
        this.nummer = nummer;
        this.besetzt = false;
    }

    public Parkplatz(Etage eID) {
        this(eID, 1);
    }

    public Parkplatz() {
        this(null, 1);
    }

    // Methoden
    public Parkplatz[] add(Parkplatz[] arr) {
        int i;
        Parkplatz[] retVal;
        // Neues Array erzeugen
        if (arr == null) {
            retVal = new Parkplatz[1];
        } else {
            if (arr.length == 0) {
                retVal = new Parkplatz[1];
            } else {
                retVal = new Parkplatz[arr.length + 1];
            }
        }
        // Array kopieren
        for (i = 0; i < arr.length - 1; i++) {
            retVal[i] = arr[i]; // Alten Arrayinhalte kopieren
        }
        retVal[i] = this;
        return retVal;
    }

    public Parkplatz[] del(Parkplatz[] arr) {
        int i = 0, j = 0;
        Parkplatz[] retVal = null;
        if (arr != null) {
            retVal = new Parkplatz[arr.length - 1];
            while (i < arr.length) {
                if (arr[i] != this) {
                    retVal[j] = arr[i];
                    i++;   // Zähler für altes Array erhöhen
                    j++;   // Zähler für neues Array übernehmen
                } else {
                    i++;   // alten Feld i überspringen
                }
            }
        }
        return retVal;
    }

    // Getter und Setter
    public int getNummer() {
        return this.nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public boolean isBesetzt() {
        return this.besetzt;
    }

    public void setBesetzt(boolean status) {
        this.besetzt = status;
    }

    public Etage geteID() {
        return this.eID;
    }

    public void seteID(Etage eID) {
        this.eID = eID;
    }

}
