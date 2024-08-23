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
        this.garage = p;
        p.setGUI(this);
        lblFreiePlaetze.setText("" + garage.freiePlaetze());
    }

    // Methoden
    private void initComponents() {

        lblParkhaus = new JLabel();
        lblPlaetze = new JLabel();
        lblFreiePlaetze = new JLabel();
        lblKennzeichen = new JLabel();
        lblTyp = new JLabel();
        boxTyp = new JComboBox<>();
        fieldKfz = new JTextField();
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
        boxTyp.setFont(new Font("Arial", Font.PLAIN, 16));
        fieldKfz.setFont(new Font("Arial", Font.PLAIN, 16));
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
        boxTyp.setBounds(200, 280, 70, 28);
        fieldKfz.setBounds(30, 280, 140, 30);
        btnIn.setBounds(330, 280, 120, 30);
        btnOut.setBounds(330, 340, 120, 30);
        btnSearch.setBounds(40, 340, 120, 30);
        lblStatus.setBounds(30, 410, 270, 30);
        btnExit.setBounds(330, 410, 120, 30);

        lblFreiePlaetze.setHorizontalAlignment(SwingConstants.CENTER);
        lblFreiePlaetze.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        lblStatus.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));

        boxTyp.setModel(new DefaultComboBoxModel<>(new String[]{"Auto", "Motorrad"}));

        boxTyp.addActionListener(evt -> boxTypActionPerformed(evt));
        fieldKfz.addActionListener(evt -> fieldKfzActionPerformed(evt));
        btnIn.addActionListener(evt -> btnInActionPerformed(evt));
        btnOut.addActionListener(evt -> btnOutActionPerformed(evt));
        btnSearch.addActionListener(evt -> btnSearchActionPerformed(evt));
        btnExit.addActionListener(evt -> btnExitActionPerformed(evt));

        getContentPane().add(lblParkhaus);
        getContentPane().add(lblPlaetze);
        getContentPane().add(lblFreiePlaetze);
        getContentPane().add(lblKennzeichen);
        getContentPane().add(lblTyp);
        getContentPane().add(boxTyp);
        getContentPane().add(fieldKfz);
        getContentPane().add(btnIn);
        getContentPane().add(btnOut);
        getContentPane().add(btnSearch);
        getContentPane().add(lblStatus);
        getContentPane().add(btnExit);
    }

    private void fieldKfzActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnInActionPerformed(ActionEvent evt) {
        String kfz = fieldKfz.getText();
        if (Fahrzeug.checkSign(kfz)) {
            String typ = (String) boxTyp.getSelectedItem();
            Parkplatz platz = garage.zuweisen();
            if (platz == null) {
                this.lblStatus.setText(" Kein Platz verfuegbar");
            } else {
                this.lblStatus.setText("");
                this.garage.einfahren(kfz, typ, platz);
            }
            this.lblFreiePlaetze.setText("" + garage.freiePlaetze());
        } else {
            this.lblStatus.setText(" Falsche Kennzeichen: " + kfz);
        }
        this.boxTyp.setSelectedIndex(0);
    }

    private void btnOutActionPerformed(ActionEvent evt) {
        String kfz = fieldKfz.getText();
        this.garage.verlassen(kfz);
        this.lblFreiePlaetze.setText("" + garage.freiePlaetze());
    }

    private void btnExitActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    private void btnSearchActionPerformed(ActionEvent evt) {
        this.lblStatus.setText(garage.getPosKfz(this.fieldKfz.getText()));
    }

    private void boxTypActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void setTextStatus(String text) {
        lblStatus.setText(text);
    }

    // Variablen
    private Parkhaus garage;
    private JComboBox<String> boxTyp;
    private JButton btnExit;
    private JButton btnIn;
    private JButton btnOut;
    private JButton btnSearch;
    private JTextField fieldKfz;
    private JLabel lblFreiePlaetze;
    private JLabel lblKennzeichen;
    private JLabel lblParkhaus;
    private JLabel lblPlaetze;
    private JLabel lblStatus;
    private JLabel lblTyp;
}
