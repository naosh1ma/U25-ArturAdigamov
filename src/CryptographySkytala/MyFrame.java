package CryptographySkytala;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.Scanner;

public class MyFrame extends JFrame {
    private Main main = null;
    private MyFrame frame = null;

    private JPanel contentPane;
    private JButton buttonCode;
    private JButton buttonDecode;
    private JButton bruteForce;
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

    public MyFrame() {
        main = new Main();
        frame = this;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 420);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
//------Text Area "Original Text"-----------------------------------------------------------
        JScrollPane paneOrig = new JScrollPane();
        paneOrig.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        paneOrig.setBounds(20, 60, 380, 120);
        contentPane.add(paneOrig);
        textOrig = new JTextArea();
        paneOrig.setViewportView(textOrig);
//------Text Area "Kodierter Text"----------------------------------------------------------
        JScrollPane paneCode = new JScrollPane();
        paneCode.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        paneCode.setBounds(20, 240, 380, 120);
        contentPane.add(paneCode);
        textCode = new JTextArea();
        paneCode.setViewportView(textCode);
//------Taste "Kodieren"---------------------------------------------------------------------
        buttonCode = new JButton("Kodieren");
        buttonCode.setFont(new Font("Times New Roman", Font.BOLD, 12));
        buttonCode.setBounds(410, 23, 100, 25);
        buttonCode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.crypt(frame);
            }
        });
        contentPane.add(buttonCode);
//------Taste "Dekodieren"-------------------------------------------------------------------
        buttonDecode = new JButton("Dekodieren");
        buttonDecode.setFont(new Font("Times New Roman", Font.BOLD, 12));
        buttonDecode.setBounds(410, 60, 100, 25);
        buttonDecode.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.decrypt(frame);
            }
        });
        contentPane.add(buttonDecode);
//------Taste "Brechen"----------------------------------------------------------------------
        bruteForce = new JButton("Brechen");
        bruteForce.setFont(new Font("Times New Roman", Font.BOLD, 12));
        bruteForce.setBounds(410, 120, 100, 25);
        bruteForce.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.bruteForce(frame);
            }
        });
        contentPane.add(bruteForce);
//------Taste "Laden"------------------------------------------------------------------------
        buttonLoad = new JButton("Laden...");
        buttonLoad.setFont(new Font("Times New Roman", Font.BOLD, 12));
        buttonLoad.setBounds(410, 155, 100, 25);
        buttonLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .txt files", "txt");
                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(restrict);
                fileChooser.showOpenDialog(null);
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                try {
                    Scanner scan = new Scanner(file);
                    StringBuilder temp = new StringBuilder();
                    while (scan.hasNext()) {
                        temp.append(scan.nextLine());
                        temp.append("\n");
                    }
                    textOrig.setText(temp.toString());
                    scan.close();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        contentPane.add(buttonLoad);
//------Taste "Speichern"------------------------------------------------------------------------
        buttonSave = new JButton("Speichern...");
        buttonSave.setFont(new Font("Times New Roman", Font.BOLD, 12));
        buttonSave.setBounds(410, 240, 100, 25);
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
        contentPane.add(buttonSave);
//------Taste "Beenden"------------------------------------------------------------------------
        buttonClose = new JButton("Beenden");
        buttonClose.setFont(new Font("Times New Roman", Font.BOLD, 12));
        buttonClose.setBounds(410, 335, 100, 25);
        buttonClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        contentPane.add(buttonClose);
//------Kombinationsfeld "Zeilen"---------------------------------------------------------------
        JComboBox comboBox = new JComboBox();
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "10"}));
        comboBox.setSelectedIndex(0);
        comboBox.setBounds(355, 25, 45, 25);
        comboBox.setMaximumRowCount(10);
        main.setZ(comboBox.getSelectedIndex() + 2);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int z = comboBox.getSelectedIndex() + 2;
                main.setZ(z);
            }
        });
        contentPane.add(comboBox);
//--------------------------------------------------------------------------------------------
        JLabel labelOrig = new JLabel("Original Text:");
        labelOrig.setVerticalAlignment(SwingConstants.BOTTOM);
        labelOrig.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelOrig.setBounds(20, 23, 100, 25);
        contentPane.add(labelOrig);
//---------------------------------------------------------------------------------------------
        JLabel labelCode = new JLabel("Kodierter Text:");
        labelCode.setVerticalAlignment(SwingConstants.BOTTOM);
        labelCode.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelCode.setBounds(20, 205, 100, 25);
        contentPane.add(labelCode);
//----------------------------------------------------------------------------------------------
        JLabel labelRow = new JLabel("Zeilen:");
        labelRow.setVerticalAlignment(SwingConstants.BOTTOM);
        labelRow.setFont(new Font("Times New Roman", Font.BOLD, 14));
        labelRow.setBounds(287, 23, 58, 25);
        contentPane.add(labelRow);
    }
}

