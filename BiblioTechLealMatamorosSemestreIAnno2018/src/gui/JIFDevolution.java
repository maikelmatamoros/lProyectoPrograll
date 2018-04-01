package gui;

import domain.Material;
import domain.Student;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

public class JIFDevolution extends JInternalFrame implements InternalFrameListener, MouseListener {

    private JTable jtbTable;
    private DefaultTableModel dtmModelTable;
    private JScrollPane scrollPane;
    private ArrayList<Material> list;
    private JLabel jlStudentID;
    private JTextField jtfStudentID;
    private JButton jbCheck;
    private int position;

    public JIFDevolution() {
        super("Devolution", false, true, false, false);
        this.setLocation(20, 40);
        this.setLayout(null);
        init();
        this.addInternalFrameListener(this);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    } // constructor

    private void init() {
        this.setSize(250, 300);

        this.jlStudentID = new JLabel("Student ID");
        this.jtfStudentID = new JTextField();
        this.jbCheck = new JButton("Check");

        this.jlStudentID.setBounds(30, 20, 120, 15);
        this.jtfStudentID.setBounds(30, 40, 170, 25);
        this.jbCheck.setBounds(30, 70, 90, 30);

        this.add(this.jlStudentID);
        this.add(this.jtfStudentID);
        this.add(this.jbCheck);
    } // init
    
    private void initTable(){
        Object[][] material = new Object[0][0];
        String[] columNames1 = {"Code", "Type"};
        this.dtmModelTable = new DefaultTableModel(material, columNames1);
        
        for (int i = 0; i < list.size(); i++) {
            this.dtmModelTable.addRow(new Object[]{list.get(i).getCode(),list.get(i).getType()});
        }//for
        
        this.jtbTable = new JTable(this.dtmModelTable);
        this.scrollPane = new JScrollPane(this.jtbTable);
        this.scrollPane.setBounds(5, 5, 420, 285);
        this.jtbTable.setSelectionBackground(Color.GREEN);
        this.add(this.scrollPane);
        this.jtbTable.addMouseListener(this);
    }

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

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

} // fin de la clase
