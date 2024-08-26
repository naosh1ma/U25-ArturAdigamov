public class Etage {
    // Attribute
    private String name;          // Name der Etage
    private boolean eVoll;        // Status voll
    private Parkplatz[] plaetze;  // Array mit belegten Plätzen
    private int anzahl;           // max. Anzahl Plätze pro Etage

    // Konstruktoren
    public Etage(String name, int anzahl) {
        this.name = name;
        this.anzahl = anzahl;
        this.eVoll = false;
        this.plaetze = new Parkplatz[anzahl];
        for (int i = 0; i < plaetze.length; i++) {
            plaetze[i] = new Parkplatz(this, i);
        }
    }

    public Etage() {
        this("", 1);
    }

    public Etage[] add(Etage[] arr) {
        int i;
        Etage[] retVal;
        // Neues Array erzeugen
        if (arr == null) {
            retVal = new Etage[1];
        } else {
            if (arr.length == 0) {
                retVal = new Etage[1];
            } else {
                retVal = new Etage[arr.length + 1];
            }
        }
        // Array kopieren
        for (i = 0; i < retVal.length - 1; i++) {
            retVal[i] = arr[i]; // Alten Arrayinhalte kopieren
        }
        retVal[i] = this; // neues Element an neues Array anfuegen
        return retVal;
    }

    public Etage[] del(Etage[] arr) {
        int i = 0, j = 0;
        Etage[] retVal = null;
        if (arr != null) {
            retVal = new Etage[arr.length - 1];
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

    public boolean isEVoll() {
        return this.eVoll;
    }

    public int freiePlaetze() {
        int retVal = 0;
        for (Parkplatz parkplatz : plaetze) {
            if (!parkplatz.isBesetzt()) {
                retVal++;
            }
        }
        return retVal;
    }

    // Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEVoll(boolean eVoll) {
        this.eVoll = eVoll;
    }

    public Parkplatz[] getPlaetze() {
        return plaetze;
    }

    public void setPlaetze(Parkplatz[] plaetze) {
        this.plaetze = plaetze;
    }

    public int getAnzahl() {
        return anzahl;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }
}
