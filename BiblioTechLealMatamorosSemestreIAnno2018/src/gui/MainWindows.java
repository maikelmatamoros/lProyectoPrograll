package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainWindows extends JFrame implements ActionListener{
    
    private JMenuBar jMenuBar;
    private JMenu jmStudent, jmLoans, jmMaterial;
    private JMenuItem jmiNewStudent, jmiDeleteStudent, jmiUpdateStudent, jmiShowStudents, jmiLoanApplication;
    private JInternalFrame jifNewStudent, jifShowAllStudents, jifStudentUpdate, jifStudentDelete,
            jILoanApplication, jifNewMaterial, jifAddBookExisting;
    
    public static JMenuItem jmiNewMaterial, jmiAddBookExisting;
    
    public MainWindows(){
        super("BiblioTech");
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        init();
        this.setVisible(true);  
    } // Constructor
    
    public void init(){
        this.jMenuBar=new JMenuBar();
        
        this.jmStudent=new JMenu("Student");
        this.jmLoans=new JMenu("Loans");
        this.jmMaterial = new JMenu("Material");
        
        this.jmiNewStudent=new JMenuItem("New Student");
        this.jmiDeleteStudent=new JMenuItem("Delete Student");
        this.jmiUpdateStudent=new JMenuItem("Update Student");
        this.jmiShowStudents=new JMenuItem("Show Students");
        this.jmiLoanApplication=new JMenuItem("Loan Application");
        
        jmiNewMaterial = new JMenuItem("New Material");
        jmiAddBookExisting = new JMenuItem("Add Book Existing");
        
        this.jmStudent.setMnemonic('S');
        this.jmMaterial.setMnemonic('M');
        this.jmiNewStudent.setMnemonic('N');
        this.jmiDeleteStudent.setMnemonic('D');
        jmiNewMaterial.setMnemonic('N');
        jmiAddBookExisting.setMnemonic('A');
        
        this.jmiNewStudent.addActionListener(this);
        this.jmiDeleteStudent.addActionListener(this);
        this.jmiUpdateStudent.addActionListener(this);
        this.jmiShowStudents.addActionListener(this);
        this.jmiLoanApplication.addActionListener(this);
        jmiNewMaterial.addActionListener(this);
        jmiAddBookExisting.addActionListener(this);

        this.jMenuBar.setSize(800, 30);
        
        this.jmStudent.add(this.jmiNewStudent);
        this.jmStudent.add(this.jmiDeleteStudent);
        this.jmStudent.add(this.jmiUpdateStudent);
        this.jmStudent.add(this.jmiShowStudents);
        this.jmLoans.add(this.jmiLoanApplication);
        this.jmMaterial.add(jmiNewMaterial);
        this.jmMaterial.add(jmiAddBookExisting);
        this.jMenuBar.add(this.jmLoans);
        this.jMenuBar.add(this.jmStudent);
        this.jMenuBar.add(this.jmMaterial);
        this.add(this.jMenuBar);
    } // init

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.jmiNewStudent){
            this.jifNewStudent=new JIFNewStudent();
            this.add(this.jifNewStudent);
            jifNewStudent.setVisible(true);
        }else if(e.getSource()==this.jmiDeleteStudent){
            this.jifStudentDelete=new JIFStudentDelete();
            this.add(this.jifStudentDelete);
            jifStudentDelete.setVisible(true);
        }else if(e.getSource()==this.jmiUpdateStudent){
            this.jifStudentUpdate=new JIFStudentUpdate();
            this.add(this.jifStudentUpdate);
            this.jifStudentUpdate.setVisible(true);
        }else if(e.getSource()==this.jmiShowStudents){
            this.jifShowAllStudents=new JIFShowAllStudents();
            this.add(this.jifShowAllStudents);
            this.jifShowAllStudents.setVisible(true);
        }else if(e.getSource()==this.jmiLoanApplication){
//            this.jILoanApplication=new JIFLoan();
//            this.add(this.jILoanApplication);
//            this.jILoanApplication.setVisible(true);
        }else if( e.getSource()==jmiNewMaterial){
            jmiNewMaterial.setEnabled(false);
            this.jifNewMaterial = new JIFNewMaterial();
            this.add(this.jifNewMaterial);
            this.jifNewMaterial.setVisible(true);
        }  else if(e.getSource() == jmiAddBookExisting){
            jmiAddBookExisting.setEnabled(false);
            this.jifAddBookExisting = new JIFAddBookExisting();
            this.add(this.jifAddBookExisting);
            this.jifAddBookExisting.setVisible(true);
        }
    } // actionPerformed
    
} // fin de la clase
