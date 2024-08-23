public class Parkhaus {
    // Attributen
    private Etage[] etagen;
    private Fahrzeug[] fahrzeugen;
    private int kfzCounter;
    private GUI gui;

    // Konstruktoren
    public Parkhaus(int etagen, int plaetze) {
        this.etagen = new Etage[etagen];
        for (int i = 0; i < etagen; i++) {
            this.etagen[i] = new Etage("OG" + 1, plaetze);
        }
    }

    public Parkhaus() {
        this(1, 1);
    }

    // Methoden
    /**
     * Die Methode einfahren() erzeugt und registriert ein Objekt der Klasse
     * Fahrzeuge unter Verwendung der uebergebene Informationen und weist
     * dem Fahrzeug seinen Platz zu.
     *
     * @param kfzID Fahrzeug Kennzeichen
     * @param typ   Fahrzeugart (z.B. Auto, Motorrad)
     * @param platz Parkplatz in der Garage
     */
    public void einfahren(String kfzID, String typ, Parkplatz platz) {
        if (this.sucheKfz(kfzID) == null) {
            // 1. Fahrzeug erstellen
            Fahrzeug kfz = new Fahrzeug(kfzID, typ, platz);
            // 2. Fahrzeug registieren
            this.fahrzeugen = kfz.add(fahrzeugen);
            // 3. Parkplatz belegen
            platz.setBesetzt(true);
            // 4. Etagen Status aendern
            if (platz.geteID().freiePlaetze() == 0) {
                platz.geteID().setEVoll(true);
            }
        } else {
            if (gui != null) {
                gui.setTextStatus(" Zahrzeug schon vorhanden");
            }
        }
    }

    /**
     * Die Methode zuweisen() liefert den naechsten freien Parkplatz oder den
     * Wert null im Fehlerfall.
     *
     * @return Parkplatz-ID oder null
     */
    public Parkplatz zuweisen() {
        Parkplatz retVal = null;
        Parkplatz[] pArr;   // Hilfsarray
        // Scleife über alle Etage des Parkhauses
        for (Etage etage : etagen) {
            if (etage.freiePlaetze() > 0) {
                pArr = etage.getPlaetze();    // Parkplätze der akt. Etage
                // Scheife über alle
                for (int p = 1; p < pArr.length; p++) {
                    if (!pArr[p].isBesetzt()) {
                        retVal = pArr[p];
                        break;
                    }
                }
            }
            if (retVal != null) {
                break;
            }
        }
        return retVal;
    }

    /**
     * Die Methode verlassen() entfernt das uebergebene Fahrzeuge Objekt aus dem
     * Parkhaus. Der Parkplatz wird wieder freigegeben der Etagen-Status
     * angepasst.
     *
     * @param kfz Objektreferenz des verlassenden Fahrzeuges
     */
    public void verlassen(Fahrzeug kfz) {
        if (kfz != null) {
            // 1. KFZ suchen und Platz freigeben
            kfz.getPlatz().setBesetzt(false);
            // 2. Etage freigben
            if (kfz.getPlatz().geteID().isEVoll()) {
                kfz.getPlatz().geteID().setEVoll(false);
            }
            // 3. KFZ aus Array fahrzeuge entfernen
            this.fahrzeugen = kfz.del(fahrzeugen);
        } else {
            if (gui != null) {
                gui.setTextStatus(" Zahrzeug exertiers nicht");
            }
        }
    }

    /**
     * Die Methode verlassen() entfernt das Fahrzeug mit dem uebergebenen
     * Fahrzeugekennzeichen(kfzID) Objekt aus dem Parkhaus. Der Parkplatz wird
     * wieder freigegeben der Etagen-Status angepasst.
     *
     * @param kfzID Fahrzeugkennzeichen des verlassenden Fahrzeuges
     */
    public void verlassen(String kfzID) {
        verlassen(sucheKfz(kfzID));
    }

    /**
     * Die Methode getPosKfz() liefert die Position eines Fahrzeugs als String
     * im Format "Etage X Parkplatz Y" oder Leerstring im Fehlerfall.
     *
     * @param kfzID Fahrzeugkennzeichen des Fahrzeuges
     * @return Etage und Platz oder ""
     */
    public String getPosKfz(String kfzID) {
        String retVal = "";
        // 1. Fahrzeuge Objekt besorgen
        Fahrzeug kfz = sucheKfz(kfzID);
        // 2. kfz auf Existenz pruefen
        if (kfz != null) {
            // 3. Parkplatznummer ermitteln und in retVal uebernehmen
            retVal = " Etage: " + kfz.getPlatz().geteID().getName();
            // 4. Etagennummer ermitteln und in retVal uebernehmen
            retVal += " Parkplatz: " + kfz.getPlatz().getNummer();
        }
        return retVal;
    }

    /**
     * Die Methode freiePlaetze() liefert die aktuelle Anzahl der noch nicht
     * belegten Parkplaetz aller Etagen.
     *
     * @return Anzahl freier Parkplaetze oder -1 wenn voll.
     */
    public int freiePlaetze() {
        int retVal = 0;
        for (Etage etage : this.etagen) {
            retVal += etage.freiePlaetze();
        }
        if (retVal == 0) {
            retVal = -1;
        }
        return retVal;
    }

    private Fahrzeug sucheKfz(String kfzID) {
        Fahrzeug retVal = null;
        if (fahrzeugen != null) {
            for (Fahrzeug fahrzeug : this.fahrzeugen) {
                if (fahrzeug.getKfzID().equalsIgnoreCase(kfzID)) {
                    retVal = fahrzeug;
                    break;
                }
            }
        }
        return retVal;
    }

    public void setGUI(GUI gui) {this.gui = gui;}
}