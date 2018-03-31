/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author maikel
 */
public class MainWindows extends JFrame implements ActionListener{
    private JMenuBar jMenuBar;
    private JMenuItem jmiNewStudent,jmiDeleteStudent,jmiUpdateStudent,jmiShowStudents,jmiLoanApplication;
    private JMenu jmStudent,jmLoans;
    private JInternalFrame jIFNewStudent,jiFShowAllStudents,jIFStudentUpdate,jIFStudentDelete,jILoanApplication;
    public MainWindows(){
        super("BiblioTech");
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(700, 600);
        init();
        this.setVisible(true);
        
    }//Constructor
    
    public void init(){
        this.jMenuBar=new JMenuBar();
        
        this.jmStudent=new JMenu("Student");
        this.jmLoans=new JMenu("Loans");
        
        this.jmiNewStudent=new JMenuItem("New Student");
        this.jmiDeleteStudent=new JMenuItem("Delete Student");
        this.jmiUpdateStudent=new JMenuItem("Update Student");
        this.jmiShowStudents=new JMenuItem("Show Students");
        this.jmiLoanApplication=new JMenuItem("Loan Application");
        
        this.jmiNewStudent.addActionListener(this);
        this.jmiDeleteStudent.addActionListener(this);
        this.jmiUpdateStudent.addActionListener(this);
        this.jmiShowStudents.addActionListener(this);
        this.jmiLoanApplication.addActionListener(this);
        
        this.jMenuBar.setSize(700, 40);
        
        this.jmStudent.add(this.jmiNewStudent);
        this.jmStudent.add(this.jmiDeleteStudent);
        this.jmStudent.add(this.jmiUpdateStudent);
        this.jmStudent.add(this.jmiShowStudents);
        this.jmLoans.add(this.jmiLoanApplication);
        this.jMenuBar.add(this.jmLoans);
        this.jMenuBar.add(this.jmStudent);
        this.add(this.jMenuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.jmiNewStudent){
            this.jIFNewStudent=new JIFNewStudent();
            this.add(this.jIFNewStudent);
            jIFNewStudent.setVisible(true);
        }else if(e.getSource()==this.jmiDeleteStudent){
            this.jIFStudentDelete=new JIFStudentDelete();
            this.add(this.jIFStudentDelete);
            jIFStudentDelete.setVisible(true);
        }else if(e.getSource()==this.jmiUpdateStudent){
            this.jIFStudentUpdate=new JIFStudentUpdate();
            this.add(this.jIFStudentUpdate);
            this.jIFStudentUpdate.setVisible(true);
        }else if(e.getSource()==this.jmiShowStudents){
            this.jiFShowAllStudents=new JIFShowAllStudents();
            this.add(this.jiFShowAllStudents);
            this.jiFShowAllStudents.setVisible(true);
        }else if(e.getSource()==this.jmiLoanApplication){
            this.jILoanApplication=new JIFLoan();
            this.add(this.jILoanApplication);
            this.jILoanApplication.setVisible(true);
        }
    }
}
