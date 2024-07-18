package CryptographySkytala;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    private Main main = null;
    private MyFrame frame = null;
    private JButton buttonCode;
    private JButton buttonDecode;
    private JButton buttonCrush;
    private JButton buttonLoad;
    private JButton buttonSave;
    private JButton buttonClose;
    private JTextArea textCode;
    private JTextArea textOrig;

    public JTextArea getTextCode() {
        return textCode;
    }
    public JTextArea getTextOrig() {
        return textOrig;
    }

    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MyFrame frame = new MyFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

    /**
     * Create the frame.
     */
    public MyFrame() {
        main = new Main();
        frame = this;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 420);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane paneOrig = new JScrollPane();
        paneOrig.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        paneOrig.setBounds(20, 60, 380, 120);
        contentPane.add(paneOrig);

        textOrig = new JTextArea();
        paneOrig.setViewportView(textOrig);



        JScrollPane paneCode = new JScrollPane();
        paneCode.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        paneCode.setBounds(20, 240, 380, 120);
        contentPane.add(paneCode);

        textCode = new JTextArea();
        paneCode.setViewportView(textCode);

        buttonCode = new JButton("Kodieren");
        buttonCode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.crypt(frame);
            }
        });
        buttonCode.setFont(new Font("Times New Roman", Font.BOLD, 12));
        buttonCode.setBounds(410, 23, 100, 25);
        contentPane.add(buttonCode);

        buttonDecode = new JButton("Dekodieren");
        buttonDecode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonDecode.setFont(new Font("Times New Roman", Font.BOLD, 12));
        buttonDecode.setBounds(410, 60, 100, 25);
        contentPane.add(buttonDecode);

        buttonCrush = new JButton("Brechen");
        buttonCrush.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        buttonCrush.setFont(new Font("Times New Roman", Font.BOLD, 12));
        buttonCrush.setBounds(410, 120, 100, 25);
        contentPane.add(buttonCrush);

        buttonLoad = new JButton("Laden...");
        buttonLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser("C:\\Users\\ArturAdigamov\\Downloads");
                FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(restrict);
                fileChooser.showOpenDialog(null);
                File file = new File (fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    Scanner scan = new Scanner(file);
                    StringBuilder temp = new StringBuilder();
                    while (scan.hasNext()) {
                        temp.append(scan.nextLine());
                    }
                    textOrig.setText(temp.toString());
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buttonLoad.setFont(new Font("Times New Roman", Font.BOLD, 12));
        buttonLoad.setBounds(410, 155, 100, 25);
        contentPane.add(buttonLoad);

        buttonSave = new JButton("Speichern...");
        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.showSaveDialog(null);
                try {
                    textCode.write(new BufferedWriter(new FileWriter(jFileChooser.getSelectedFile().getAbsolutePath()
                            + jFileChooser.getFileFilter().getDescription().replace("Alle Dateien", ""))));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        buttonSave.setFont(new Font("Times New Roman", Font.BOLD, 12));
        buttonSave.setBounds(410, 240, 100, 25);
        contentPane.add(buttonSave);

        buttonClose = new JButton("Schließen");
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        buttonClose.setFont(new Font("Times New Roman", Font.BOLD, 12));
        buttonClose.setBounds(410, 335, 100, 25);
        contentPane.add(buttonClose);

        JComboBox comboBox = new JComboBox();
        comboBox.setMaximumRowCount(9);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int z = Integer.parseInt((String) comboBox.getSelectedItem());
                main.setZ(z);
            }
        });
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        comboBox.setSelectedIndex(0);

        comboBox.setBounds(355, 25, 45, 25);
        contentPane.add(comboBox);

        JLabel labelOrig = new JLabel("Original Text:");
        labelOrig.setVerticalAlignment(SwingConstants.BOTTOM);
        labelOrig.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelOrig.setBounds(20, 23, 100, 25);
        contentPane.add(labelOrig);

        JLabel labelCode = new JLabel("Kodierter Text:");
        labelCode.setVerticalAlignment(SwingConstants.BOTTOM);
        labelCode.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelCode.setBounds(20, 205, 100, 25);
        contentPane.add(labelCode);

        JLabel labelRow = new JLabel("Zeilen:");
        labelRow.setVerticalAlignment(SwingConstants.BOTTOM);
        labelRow.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelRow.setBounds(287, 23, 58, 25);
        contentPane.add(labelRow);
    }
}

