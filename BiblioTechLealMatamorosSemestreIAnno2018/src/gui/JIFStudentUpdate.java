/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import business.StudentBusiness;
import domain.Student;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author maikel
 */
public class JIFStudentUpdate extends JInternalFrame implements ActionListener {

    private JComboBox jComboCareer, jComboID;
    private JTextField jtfName, jtfLast, jtfYear;
    private JLabel jlblName, jlblLast, jlblYear, jlblCareer, jlblID;
    private JButton jbtnUpdate, jbtnSearch;
    private StudentBusiness studentBusiness;
    private ArrayList<Student> list;

    public JIFStudentUpdate() {
        super("Stundent Update", false, true, false, false);
        this.setSize(500, 400);
        this.setLocation(20, 40);
        this.setLayout(null);
        try {
            this.studentBusiness = new StudentBusiness();
            this.list = this.studentBusiness.getAllStudents();
        } catch (IOException ex) {
            Logger.getLogger(JIFNewStudent.class.getName()).log(Level.SEVERE, null, ex);
        }
        init();
    }

    public void init() {
        this.jComboCareer = new JComboBox();
        this.jComboCareer.addItem("Agronomía");
        this.jComboCareer.addItem("Educación");
        this.jComboCareer.addItem("Informática");

        this.jComboID = new JComboBox();

        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "The register is empty");
        } else {
            for (Student list1 : list) {
                this.jComboID.addItem(list1.getId());
            }
        }

        this.jtfName = new JTextField();
        this.jlblName = new JLabel("Name");
        this.jtfLast = new JTextField();
        this.jlblLast = new JLabel("Lastname");
        this.jtfYear = new JTextField();
        this.jlblYear = new JLabel("Year");
        this.jlblCareer = new JLabel("Career");
        this.jlblID = new JLabel("ID");
        this.jbtnUpdate = new JButton("Update");
        this.jbtnSearch = new JButton("Search");

        this.jComboID.setBounds(90, 10, 110, 30);
        this.jlblID.setBounds(20, 10, 110, 30);
        this.jtfName.setBounds(90, 50, 110, 30);
        this.jlblName.setBounds(20, 50, 100, 30);
        this.jtfLast.setBounds(90, 90, 110, 30);
        this.jlblLast.setBounds(20, 90, 100, 30);
        this.jtfYear.setBounds(90, 130, 110, 30);
        this.jlblYear.setBounds(20, 130, 100, 30);
        this.jlblCareer.setBounds(210, 50, 100, 30);
        this.jComboCareer.setBounds(270, 50, 110, 30);
        this.jbtnUpdate.setBounds(40, 180, 100, 30);
        this.jbtnSearch.setBounds(210, 10, 110, 30);

        this.jbtnSearch.addActionListener(this);
        this.jbtnUpdate.addActionListener(this);

        this.add(this.jComboCareer);
        this.add(this.jtfName);
        this.add(this.jlblName);
        this.add(this.jtfLast);
        this.add(this.jlblLast);
        this.add(this.jtfYear);
        this.add(this.jlblYear);
        this.add(this.jlblCareer);
        this.add(this.jbtnUpdate);
        this.add(this.jComboID);
        this.add(this.jlblID);
        this.add(this.jbtnSearch);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jbtnUpdate) {
            if (validation()) {
                try {
                    String first = String.valueOf(this.jComboCareer.getSelectedItem().toString().charAt(0));
                    String second = String.valueOf(this.jtfYear.getText().charAt(this.jtfYear.getText().length() - 1));
                    String third = this.jComboID.getSelectedItem().toString().substring(2);
                    String id = first + second + third;
                    if (this.studentBusiness.updateRecord(new Student(id, this.jtfName.getText(),
                            this.jtfLast.getText(), this.jComboCareer.getSelectedItem().toString(),
                            Integer.parseInt(this.jtfYear.getText())), this.jComboID.getSelectedIndex())) {
                        this.list.get(this.jComboID.getSelectedIndex()).setName(this.jtfName.getText());
                        this.list.get(this.jComboID.getSelectedIndex()).setLastName(this.jtfLast.getText());
                        this.list.get(this.jComboID.getSelectedIndex()).setCarrera(this.jComboCareer.getSelectedItem().toString());
                        this.list.get(this.jComboID.getSelectedIndex()).setYear(Integer.parseInt(this.jtfYear.getText()));
                        this.list.get(this.jComboID.getSelectedIndex()).setId(id);                       
                        this.jtfLast.setText("");
                        this.jtfName.setText("");
                        this.jtfYear.setText("");
                        
                        refresh();
                        JOptionPane.showMessageDialog(rootPane, "Success, your institucional ID is: " + id);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error");
                    }
                } catch (IOException ex) {
                    Logger.getLogger(JIFNewStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (e.getSource() == this.jbtnSearch) {
            this.jtfName.setText(this.list.get(this.jComboID.getSelectedIndex()).getName());
            this.jtfLast.setText(this.list.get(this.jComboID.getSelectedIndex()).getLastName());
            this.jtfYear.setText(String.valueOf(this.list.get(this.jComboID.getSelectedIndex()).getYear()));
            if (this.list.get(this.jComboID.getSelectedIndex()).getCarrera().equals("Agronomía")) {
                this.jComboCareer.setSelectedIndex(0);
            } else if (this.list.get(this.jComboID.getSelectedIndex()).getCarrera().equals("Educación")) {
                this.jComboCareer.setSelectedIndex(1);
            } else {
                this.jComboCareer.setSelectedIndex(2);
            }

        }
    }

    private boolean validation() {

        if (this.jtfName.getText().equals("") || this.jtfLast.getText().equals("") || this.jtfYear.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All spaces are required", "Error", 0);
            return false;
        } else {
            try {
                if (Integer.parseInt(this.jtfYear.getText()) < 1941 || Integer.parseInt(this.jtfYear.getText()) > 2018) {
                    String message = "Invalid data";
                    if (Integer.parseInt(this.jtfYear.getText()) < 1941) {
                        message = message + ", the first student entered in 1941";
                    } else if (Integer.parseInt(this.jtfYear.getText()) > 2018) {
                        message = message + ",the year can not be greater than the current";
                    }
                    JOptionPane.showMessageDialog(this, message, "Error", 2);
                    return false;
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "The year must be a number.", "Error", 0);
                return false;
            }
        }
        return true;
    } // newData

    private void refresh() {
        this.jComboID.removeAllItems();
        for (int i=0;i<this.list.size();i++) {
            this.jComboID.addItem(this.list.get(i).getId());
        }
    }
}
