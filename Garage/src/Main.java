public class Main {

    private static final int ETAGEN = 3;
    private static final int PLAETZE = 25;

    public static void main(String[] args) {
        Parkhaus parkhaus = new Parkhaus(ETAGEN, PLAETZE);
        java.awt.EventQueue.invokeLater(() -> {
            GUI gui = new GUI(parkhaus);
            gui.setLocationRelativeTo(null);
            gui.setVisible(true);
        });
    }
}
