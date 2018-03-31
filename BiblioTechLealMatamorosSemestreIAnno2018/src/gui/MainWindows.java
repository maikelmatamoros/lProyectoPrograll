package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindows extends JFrame implements ActionListener {

    private JMenuBar jMenuBar;
    private JMenu jmStudent, jmLoans, jmMaterial;
    private JInternalFrame jifNewStudent, jifShowAllStudents, jifStudentUpdate, jifStudentDelete,
            jILoanApplication, jifNewMaterial, jifAddBookExisting;

    public static JMenuItem jmiNewMaterial, jmiAddBookExisting, jmiNewStudent,
            jmiDeleteStudent, jmiUpdateStudent, jmiShowStudents, jmiLoanApplication;

    public MainWindows() {
        super("BiblioTech");
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        init();
        this.setVisible(true);
    } // Constructor

    public void init() {
        this.jMenuBar = new JMenuBar();

        this.jmStudent = new JMenu("Student");
        this.jmLoans = new JMenu("Loans");
        this.jmMaterial = new JMenu("Material");

        jmiNewStudent = new JMenuItem("New Student");
        jmiDeleteStudent = new JMenuItem("Delete Student");
        jmiUpdateStudent = new JMenuItem("Update Student");
        jmiShowStudents = new JMenuItem("Show Students");
        jmiLoanApplication = new JMenuItem("Loan Application");

        jmiNewMaterial = new JMenuItem("New Material");
        jmiAddBookExisting = new JMenuItem("Add Book Existing");

        this.jmStudent.setMnemonic('S');
        this.jmMaterial.setMnemonic('M');
        this.jmLoans.setMnemonic('L');

        jmiUpdateStudent.setMnemonic('U');
        jmiNewStudent.setMnemonic('N');
        jmiDeleteStudent.setMnemonic('D');
        jmiShowStudents.setMnemonic('S');
        jmiNewMaterial.setMnemonic('N');
        jmiAddBookExisting.setMnemonic('A');

        jmiNewStudent.addActionListener(this);
        jmiDeleteStudent.addActionListener(this);
        jmiUpdateStudent.addActionListener(this);
        jmiShowStudents.addActionListener(this);
        jmiLoanApplication.addActionListener(this);
        jmiNewMaterial.addActionListener(this);
        jmiAddBookExisting.addActionListener(this);

        this.jMenuBar.setSize(800, 30);

        this.jmStudent.add(jmiNewStudent);
        this.jmStudent.add(jmiDeleteStudent);
        this.jmStudent.add(jmiUpdateStudent);
        this.jmStudent.add(jmiShowStudents);
        this.jmLoans.add(jmiLoanApplication);
        this.jmMaterial.add(jmiNewMaterial);
        this.jmMaterial.add(jmiAddBookExisting);
        this.jMenuBar.add(this.jmLoans);
        this.jMenuBar.add(this.jmStudent);
        this.jMenuBar.add(this.jmMaterial);
        this.add(this.jMenuBar);
    } // init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jmiNewStudent) {
            jmiNewStudent.setEnabled(false);
            this.jifNewStudent = new JIFNewStudent();
            this.add(this.jifNewStudent);
            jifNewStudent.setVisible(true);
        } else if (e.getSource() == jmiDeleteStudent) {
            jmiDeleteStudent.setEnabled(false);
            this.jifStudentDelete = new JIFStudentDelete();
            this.add(this.jifStudentDelete);
            jifStudentDelete.setVisible(true);
        } else if (e.getSource() == jmiUpdateStudent) {
            jmiUpdateStudent.setEnabled(false);
            this.jifStudentUpdate = new JIFStudentUpdate();
            this.add(this.jifStudentUpdate);
            this.jifStudentUpdate.setVisible(true);
        } else if (e.getSource() == jmiShowStudents) {
            jmiShowStudents.setEnabled(false);
            this.jifShowAllStudents = new JIFShowAllStudents();
            this.add(this.jifShowAllStudents);
            this.jifShowAllStudents.setVisible(true);
        } else if (e.getSource() == jmiLoanApplication) {
//            this.jILoanApplication=new JIFLoan();
//            this.add(this.jILoanApplication);
//            this.jILoanApplication.setVisible(true);
        } else if (e.getSource() == jmiNewMaterial) {
            jmiNewMaterial.setEnabled(false);
            this.jifNewMaterial = new JIFNewMaterial();
            this.add(this.jifNewMaterial);
            this.jifNewMaterial.setVisible(true);
        } else if (e.getSource() == jmiAddBookExisting) {
            jmiAddBookExisting.setEnabled(false);
            this.jifAddBookExisting = new JIFAddBookExisting();
            this.add(this.jifAddBookExisting);
            this.jifAddBookExisting.setVisible(true);
        }
    } // actionPerformed

} // fin de la clase
