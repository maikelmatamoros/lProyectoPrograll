/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import business.MaterialBusiness;
import com.toedter.calendar.JDateChooser;
import domain.Audiovisual;
import domain.Book;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author maikel
 */
public class JIFLoan extends JInternalFrame implements ActionListener, MouseListener, KeyListener {

    private JComboBox jComboSelection, jComboBox;
    private JButton jbtnLoan;
    private JDateChooser jDateChooser;
    private JTable jtbTable;
    private DefaultTableModel dtmModelTable;
    private JScrollPane scrollPane;
    private TableRowSorter trs;
    private ArrayList<Book> list;
    private String format;
    private JTextField jtfText, jtfCode;

    public JIFLoan() {
        super("Loan", false, true, false, false);
        this.setSize(700, 500);
        this.setLayout(null);
        this.setLocation(30, 30);
        init();
    }

    public void init() {
        this.jComboSelection = new JComboBox(new String[]{"Libros", "Material"});
        this.jDateChooser = new JDateChooser();
        this.jtfText = new JTextField();
        this.jtfCode = new JTextField();
        this.jComboBox = new JComboBox();

        this.jComboSelection.setBounds(30, 30, 100, 30);
        this.jDateChooser.setBounds(570, 30, 100, 30);
        this.jtfText.setBounds(450, 250, 100, 30);
        this.jtfCode.setBounds(570, 250, 100, 30);

        this.jtfText.setVisible(false);
        this.jtfCode.setVisible(false);
        this.jComboSelection.addActionListener(this);
        this.jtfText.addKeyListener(this);
        this.jtfCode.addKeyListener(this);

        Object[][] vehicles = new Object[0][0];
        String[] columNames1 = {"Name", "Author", "Year", "Language", "Theme"};
        this.dtmModelTable = new DefaultTableModel(vehicles, columNames1);
        this.jtbTable = new JTable(this.dtmModelTable);
        this.scrollPane = new JScrollPane(this.jtbTable);
        scrollPane.setBounds(10, 80, 400, 285);
        this.jtbTable.setSelectionBackground(Color.GREEN);
        this.add(scrollPane);

        this.add(this.jDateChooser);
        this.add(this.jComboSelection);
        this.add(this.jtfText);
        this.add(this.jtfCode);
        this.add(this.jComboBox);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jComboSelection) {
            if (this.jComboBox.isShowing()) {
                this.remove(this.jComboBox);
            }
            MaterialBusiness materialBusiness = new MaterialBusiness();
            if (this.jComboSelection.getSelectedIndex() == 0) {
                try {
                    this.list = materialBusiness.getBooksAndAudiovisual().get(0);
                } catch (IOException ex) {
                    Logger.getLogger(JIFLoan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JIFLoan.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jComboBox = new JComboBox(new String[]{"Physical", "Digital"});
                this.jComboBox.setBounds(150, 30, 100, 30);
                this.jComboBox.addActionListener(this);
                this.add(this.jComboBox);
                this.jtfText.setVisible(true);
                this.jtfCode.setVisible(true);
            } else {
                try {
                    this.list = materialBusiness.getBooksAndAudiovisual().get(1);
                } catch (IOException ex) {
                    Logger.getLogger(JIFLoan.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(JIFLoan.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jComboBox = new JComboBox(new String[]{"Disk", "Laptop", "Mouse", "Projector", "Other"});
                this.jComboBox.setBounds(150, 30, 100, 30);
                this.jComboBox.addActionListener(this);
                this.add(this.jComboBox);
            }
        } else if (e.getSource() == this.jComboBox) {

            this.format = this.jComboBox.getSelectedItem().toString();
            initTableBook(list, format);

        }
    }

    public void initTableBook(ArrayList<Book> list, String subString, String format, int var) {
        this.remove(this.scrollPane);

        Object[][] vehicles = new Object[0][0];
        String[] columNames1 = {"Name", "Author", "Year", "Language", "Theme"};
        this.dtmModelTable = new DefaultTableModel(vehicles, columNames1);
        for (int i = 0; i < list.size(); i++) {
            if (this.list.get(i).getFormat().equals(format) && this.list.get(i).getName().substring(0, subString.length()).equalsIgnoreCase(subString) && var == 0) {
                //System.out.println("Entra");
                this.dtmModelTable.addRow(new Object[]{list.get(i).getName(),
                    list.get(i).getAuthor(), list.get(i).getYear(), list.get(i).getLanguage(), list.get(i).getTheme()});
            } else if (this.list.get(i).getFormat().equals(format) && String.valueOf(this.list.get(i).getCode()).substring(0, subString.length()).equalsIgnoreCase(subString) && var == 1) {
                this.dtmModelTable.addRow(new Object[]{list.get(i).getName(),
                    list.get(i).getAuthor(), list.get(i).getYear(), list.get(i).getLanguage(), list.get(i).getTheme()});
            }

        }//for

        this.jtbTable = new JTable(this.dtmModelTable);

        this.scrollPane = new JScrollPane(this.jtbTable);

        scrollPane.setBounds(
                10, 80, 400, 285);

        this.jtbTable.setSelectionBackground(Color.GREEN);

        this.add(scrollPane);

        this.jtbTable.addMouseListener(
                this);
    } // inicializa el modelo de la tabla cargando los valores del archivo

    public void initTableBook(ArrayList<Book> list, String format) {
        this.remove(this.scrollPane);
        Object[][] vehicles = new Object[0][0];
        String[] columNames1 = {"Name", "Author", "Year", "Language", "Theme"};
        this.dtmModelTable = new DefaultTableModel(vehicles, columNames1);
        for (int i = 0; i < list.size(); i++) {
            if (this.list.get(i).getFormat().equalsIgnoreCase(format)) {
                //System.out.println("Entra");
                this.dtmModelTable.addRow(new Object[]{list.get(i).getName(),
                    list.get(i).getAuthor(), list.get(i).getYear(), list.get(i).getLanguage(), list.get(i).getTheme()});
            }
        }//for

        this.jtbTable = new JTable(this.dtmModelTable);
        this.scrollPane = new JScrollPane(this.jtbTable);
        scrollPane.setBounds(10, 80, 400, 285);
        this.jtbTable.setSelectionBackground(Color.GREEN);

        this.add(scrollPane);
        this.jtbTable.addMouseListener(this);
    } // inicializa el modelo de la tabla cargando los valores del archivo

    public void initTableMaterial(ArrayList<Audiovisual> list, String subString, String format, int var) {
        this.remove(this.scrollPane);

        Object[][] vehicles = new Object[0][0];
        String[] columNames1 = {"Type", "ID", "Description", "Code"};
        this.dtmModelTable = new DefaultTableModel(vehicles, columNames1);
        for (int i = 0; i < list.size(); i++) {
            if (this.list.get(i).getFormat().equals(format)
                    && this.list.get(i).getName().substring(0, subString.length()).equalsIgnoreCase(subString) && var == 0) {
                //System.out.println("Entra");
                this.dtmModelTable.addRow(new Object[]{list.get(i).getType(),
                    list.get(i).getId(), list.get(i).getDescription(), list.get(i).getCode()});
            } else if (this.list.get(i).getFormat().equals(format)
                    && this.list.get(i).getName().substring(0, subString.length()).equalsIgnoreCase(subString) && var == 1) {

                this.dtmModelTable.addRow(new Object[]{list.get(i).getType(),
                    list.get(i).getId(), list.get(i).getDescription(), list.get(i).getCode()});
            }
        }//for

        this.jtbTable = new JTable(this.dtmModelTable);
        trs = new TableRowSorter(dtmModelTable);
        this.scrollPane = new JScrollPane(this.jtbTable);
        scrollPane.setBounds(10, 80, 400, 285);
        this.jtbTable.setSelectionBackground(Color.GREEN);
        this.add(scrollPane);
        this.jtbTable.addMouseListener(this);
    } // inicializa el modelo de la tabla cargando los valores del archivo

    public void initTableMaterial(ArrayList<Audiovisual> list, String format) {
        this.remove(this.scrollPane);

        Object[][] vehicles = new Object[0][0];
        String[] columNames1 = {"Type", "ID", "Description", "Code"};
        this.dtmModelTable = new DefaultTableModel(vehicles, columNames1);
        for (int i = 0; i < list.size(); i++) {
            if (this.list.get(i).getFormat().equals(format)) {
                //System.out.println("Entra");
                this.dtmModelTable.addRow(new Object[]{list.get(i).getType(),
                    list.get(i).getId(), list.get(i).getDescription(), list.get(i).getCode()});
            }
        }//for

        this.jtbTable = new JTable(this.dtmModelTable);
        trs = new TableRowSorter(dtmModelTable);
        this.scrollPane = new JScrollPane(this.jtbTable);
        scrollPane.setBounds(10, 80, 400, 285);
        this.jtbTable.setSelectionBackground(Color.GREEN);
        this.add(scrollPane);
        this.jtbTable.addMouseListener(this);
    } // inicializa el modelo de la tabla cargando los valores del archivo

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    private String name = "";
    private String code = "";

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getSource() == this.jtfText) {
            int keycode = e.getKeyChar();

            if (keycode != 8) {
                this.name = name + (char) keycode;
                System.out.println(name);
                initTableBook(this.list, name, format, 0);
            } else {
                if (name.length() >= 1) {
                    this.name = name.substring(0, name.length() - 1);
                    initTableBook(this.list, name, this.format, 0);
                }
            }
        } else {
            int keycode = e.getKeyChar();

            if (keycode != 8) {
                this.code = code + (char) keycode;
                System.out.println(code);
                if (code.length() <= 9) {
                    initTableBook(this.list, code, format, 1);
                }

            } else {
                if (code.length() >= 1) {
                    this.code = code.substring(0, code.length() - 1);
                    if (code.length() <= 9) {
                        initTableBook(this.list, code, format, 1);
                    }

                }
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
