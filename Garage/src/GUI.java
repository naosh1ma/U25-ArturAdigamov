import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
    // Konstruktoren
    public GUI() {
        initComponents();
    }

    public GUI(Parkhaus p) {
        this();
        this.garage = p; // Parkhaus Objekt in GUI registrieren
        p.setGUI(this); // Gui Objekt an Parkhaus uebergeben
        lblFreiePlaetze.setText("" + garage.freiePlaetze());
    }

    // Methoden
    private void initComponents() {

        lblParkhaus = new JLabel();
        lblPlaetze = new JLabel();
        lblFreiePlaetze = new JLabel();
        lblKennzeichen = new JLabel();
        lblTyp = new JLabel();
        cbTyp = new JComboBox<>();
        cbKfz = new JComboBox<>();
        btnIn = new JButton();
        btnOut = new JButton();
        btnSearch = new JButton();
        lblStatus = new JLabel();
        btnExit = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(500, 500));
        getContentPane().setLayout(null);

        lblParkhaus.setFont(new Font("Arial", Font.PLAIN, 36));
        lblPlaetze.setFont(new Font("Arial", Font.PLAIN, 20));
        lblFreiePlaetze.setFont(new Font("Arial", Font.PLAIN, 20));
        lblKennzeichen.setFont(new Font("Arial", Font.PLAIN, 20));
        lblTyp.setFont(new Font("Arial", Font.PLAIN, 20));
        cbTyp.setFont(new Font("Arial", Font.PLAIN, 16));
        cbKfz.setFont(new Font("Arial", Font.PLAIN, 16));
        btnIn.setFont(new Font("Arial", Font.PLAIN, 17));
        btnOut.setFont(new Font("Arial", Font.PLAIN, 17));
        btnSearch.setFont(new Font("Arial", Font.PLAIN, 17));
        btnExit.setFont(new Font("Arial", Font.PLAIN, 17));
        lblStatus.setFont(new Font("Arial", Font.PLAIN, 16));

        lblParkhaus.setText("Parkhaus Verwaltung");
        lblPlaetze.setText("Freie Plätze:");
        lblKennzeichen.setText("Kennzeichen:");
        lblTyp.setText("Typ:");
        btnIn.setText("Einfahren");
        btnOut.setText("Verlassen");
        btnSearch.setText("Suchen");
        btnExit.setText("Beenden");

        lblParkhaus.setBounds(70, 10, 440, 100);
        lblPlaetze.setBounds(30, 150, 160, 29);
        lblFreiePlaetze.setBounds(200, 150, 50, 30);
        lblKennzeichen.setBounds(30, 230, 160, 29);
        lblTyp.setBounds(200, 230, 100, 30);
        cbTyp.setBounds(200, 280, 70, 28);
        cbKfz.setBounds(30, 280, 140, 30);
        btnIn.setBounds(330, 280, 120, 30);
        btnOut.setBounds(330, 340, 120, 30);
        btnSearch.setBounds(40, 340, 120, 30);
        lblStatus.setBounds(30, 410, 270, 30);
        btnExit.setBounds(330, 410, 120, 30);

        lblFreiePlaetze.setHorizontalAlignment(SwingConstants.CENTER);
        lblFreiePlaetze.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lblStatus.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        cbTyp.setModel(new DefaultComboBoxModel<>(new String[]{"Auto", "Motorrad"}));

        cbTyp.addActionListener(evt -> boxTypActionPerformed(evt));
        btnIn.addActionListener(evt -> btnInActionPerformed(evt));
        btnOut.addActionListener(evt -> btnOutActionPerformed(evt));
        btnSearch.addActionListener(evt -> btnSearchActionPerformed(evt));
        btnExit.addActionListener(evt -> btnExitActionPerformed(evt));

        getContentPane().add(lblParkhaus);
        getContentPane().add(lblPlaetze);
        getContentPane().add(lblFreiePlaetze);
        getContentPane().add(lblKennzeichen);
        getContentPane().add(lblTyp);
        getContentPane().add(cbTyp);
        getContentPane().add(cbKfz);
        getContentPane().add(btnIn);
        getContentPane().add(btnOut);
        getContentPane().add(btnSearch);
        getContentPane().add(lblStatus);
        getContentPane().add(btnExit);
    }

    private void btnInActionPerformed(ActionEvent evt) {
        Fahrzeug kfz = null;
        String kfzId = null;
        kfzId = this.getKfzId(this.cbKfz.getSelectedItem());
        // Ueberpruefung auf korrektes Kennzeichen
        if (Fahrzeug.checkSign(kfzId)) {
            // Fahrzeugtype bestimmen
            String type = (String) this.cbTyp.getSelectedItem();
            // freien Parkplatz suchen
            Parkplatz platz = garage.zuweisen();
            if (platz == null) {
                this.lblStatus.setText("Kein Platz verfügbar!");
            } else {
                this.lblStatus.setText("");
                // neues Fahrzeuge Objekt erzeugen
                kfz = new Fahrzeug(kfzId, type, platz);
                // Fahrzeug in Auswahlliste eintragen
                if(garage.sucheKfz(kfzId)== null) changeCbKfz(kfz);
                // Fahrzeug im Parkhaus abstellen
                // TODO this.garage.einfahren(kfz);
            }
            this.lblFreiePlaetze.setText("" + garage.freiePlaetze());
        } else {
            this.lblStatus.setText("Falsches Kennzeichen " + kfzId);
        }
        // Restet der Combobox
        this.cbTyp.setSelectedIndex(0);
    }

    private void btnOutActionPerformed(ActionEvent evt) {
        String kfzID = null;

        // ComboBox Kennzeichen auslesen
        Object obj = this.cbKfz.getSelectedItem();
        // Kennzeichen bestimmen
        kfzID = this.getKfzId(obj);
        // Objekt-Typ bestimmen (Fahrzeuge oder String)
        if(obj.getClass().toString().equals("class java.lang.String"))
            obj = garage.sucheKfz(kfzID);// korrektes Fahrzeuge Objekt ermitteln
        // Fahrzeug aus Parkhaus entfernen
        this.lblStatus.setText("");
        this.garage.verlassen(kfzID);
        this.lblFreiePlaetze.setText("" + garage.freiePlaetze());
        this.cbKfz.removeItem(obj);
        this.cbKfz.setSelectedItem("");
    }

    private void btnExitActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void btnSearchActionPerformed(ActionEvent evt) {
        String kfzId = null;
        kfzId = this.getKfzId(this.cbKfz.getSelectedItem());
        this.lblStatus.setText(garage.getPosKfz(kfzId));
    }

    private void boxTypActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void setTextStatus(String text) {
        lblStatus.setText(text);
    }

    private String getKfzId(Object obj) {
        String retVal = null;
        try {
            retVal = (String) this.cbKfz.getSelectedItem();
        } catch (ClassCastException ccEx) {
            retVal = ((Fahrzeug) this.cbKfz.getSelectedItem()).toString();
        }
        return retVal;
    }

    private void changeCbKfz(Fahrzeug kfz) {
        this.cbKfz.addItem(kfz);
        this.cbKfz.setSelectedItem("");
    }



    // Variablen
    private Parkhaus garage;
    private JComboBox<String> cbTyp;
    private JComboBox<Fahrzeug> cbKfz;
    private JButton btnExit;
    private JButton btnIn;
    private JButton btnOut;
    private JButton btnSearch;
    private JLabel lblFreiePlaetze;
    private JLabel lblKennzeichen;
    private JLabel lblParkhaus;
    private JLabel lblPlaetze;
    private JLabel lblStatus;
    private JLabel lblTyp;
}
