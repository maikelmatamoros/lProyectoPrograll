package gui;

import business.StudentBusiness;
import domain.Student;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import javax.swing.table.DefaultTableModel;

public class JIFStudentDelete extends JInternalFrame implements ActionListener, MouseListener, InternalFrameListener {

    private StudentBusiness studentBusiness;
    private JTable jtbTable1;
    private DefaultTableModel dtmModelTable;
    private JScrollPane scrollPane;
    private ArrayList<Student> list;
    private JButton jbtnDelete;
    private int position;

    public JIFStudentDelete() {
        super("Delete Student", false, true, false, false);
        this.setLayout(null);
        this.refresh();
        this.init();
        this.setLocation(20, 40);
        this.setSize(500, 325);
        this.addInternalFrameListener(this);
    }//constructor

    public void init() {
        this.jbtnDelete = new JButton("Delete");
        this.jbtnDelete.setBounds(350, 100, 90, 90);
        this.jbtnDelete.addActionListener(this);
        this.add(this.jbtnDelete);

    } // inicializa el boton

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
        this.jtbTable1.addMouseListener(this);
    } // inicializa el modelo de la tabla cargando los valores del archivo

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jbtnDelete) {
            try {
                if (!(this.list.isEmpty()) && this.studentBusiness.deleteStudent(this.list.get(this.position).getId())) {
                    JOptionPane.showMessageDialog(rootPane, "Success");
                    this.getContentPane().remove(this.scrollPane);
                    refresh();

                } else {
                    if (this.list.isEmpty()) {
                        JOptionPane.showMessageDialog(rootPane, "There is no registered vehicle");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "The ID not in the file");
                    }//else

                }//else
            } catch (IOException ex) {
                Logger.getLogger(JIFStudentDelete.class.getName()).log(Level.SEVERE, null, ex);
            }//Try-Catch

        }//if (e.getSource() == this.jbtnDelete)

    } // actionPerformed

    //Eventos para el mouse, se usa para saber cual es el vehiculo que se selecciona en la tabla
    @Override
    public void mouseClicked(MouseEvent e) {
        this.position = this.jtbTable1.getSelectedRow();
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

    //metodo para refrescar la Tabla
    public void refresh() {
        try {
            this.studentBusiness = new StudentBusiness();
            this.list = this.studentBusiness.getAllStudents();

        } catch (IOException ex) {
            Logger.getLogger(JIFStudentDelete.class.getName()).log(Level.SEVERE, null, ex);
        }
        initTable(this.list);

    } // refresh

    //evento de internalFrame, se usa para volver a hacer usable el JMitem que abre la ventana
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

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
