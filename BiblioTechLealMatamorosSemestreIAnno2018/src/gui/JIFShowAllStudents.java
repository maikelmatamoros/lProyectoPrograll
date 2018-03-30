package gui;

import business.StudentBusiness;
import domain.Student;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

public class JIFShowAllStudents extends JInternalFrame implements InternalFrameListener {

    //Atributos
    private StudentBusiness studentBusiness;
    private JTable jtbTable1;
    private DefaultTableModel dtmModelTable;
    private JScrollPane scrollPane;
    private ArrayList<Student> list;

    //Constructor
    public JIFShowAllStudents() {
        super("Show Vehicles", false, true, false, false);
        this.setLayout(null);
        this.refresh();
        this.setLocation(20, 40);
        this.setSize(600, 350);
        this.addInternalFrameListener(this);
    }

    //inicializa la tabla
    public void initTable(ArrayList<Student> list) {

        Object[][] vehicles = new Object[0][0];
        String[] columNames1 = {"Name", "LastName", "Year", "Career", "ID"};
        this.dtmModelTable = new DefaultTableModel(vehicles, columNames1);
        for (int i = 0; i < list.size(); i++) {

            this.dtmModelTable.addRow(new Object[]{list.get(i).getName(),
                list.get(i).getLastName(), list.get(i).getYear(), list.get(i).getCarrera(), list.get(i).getId()});

        }//for
        this.jtbTable1 = new JTable(this.dtmModelTable);
        this.scrollPane = new JScrollPane(this.jtbTable1);
        scrollPane.setBounds(5, 5, 300, 285);
        this.jtbTable1.setSelectionBackground(Color.GREEN);
        this.add(scrollPane);
    } // inicializa el modelo de la tabla cargando los valores del archivo

    //refresca los valores de la tabla
    public void refresh() {
        try {
            this.studentBusiness = new StudentBusiness();
            this.list = this.studentBusiness.getAllStudents();

        } catch (IOException ex) {
            Logger.getLogger(JIFShowAllStudents.class.getName()).log(Level.SEVERE, null, ex);
        }
        initTable(this.list);

    } // refresh

    //Evento internalFrame para que cuando se cierre habilite el JMitem con el que se abre la ventana
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    
    } // internalFrameClosed

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }

} // fin de la clase
