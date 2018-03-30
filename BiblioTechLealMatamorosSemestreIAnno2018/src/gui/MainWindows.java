/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author maikel
 */
public class MainWindows extends JFrame implements ActionListener{
    private JMenuBar jMenuBar;
    private JMenuItem jmiNewStudent,jmiDeleteStudent;
    private JMenu jmStudent;
    private JIFNewStudent jIFNewStudent;
    private JIFStudentDelete jIFStudentDelete;
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
        
        this.jmiNewStudent=new JMenuItem("New Student");
        this.jmiDeleteStudent=new JMenuItem("Delete Student");
        
        this.jmiNewStudent.addActionListener(this);
        this.jmiDeleteStudent.addActionListener(this);
        
        this.jMenuBar.setSize(500, 40);
        
        this.jmStudent.add(this.jmiNewStudent);
        this.jmStudent.add(this.jmiDeleteStudent);
        this.jMenuBar.add(this.jmStudent);
        this.add(this.jMenuBar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.jmiNewStudent){
            this.jIFNewStudent=new JIFNewStudent();
            this.add(jIFNewStudent);
            jIFNewStudent.setVisible(true);
        }else if(e.getSource()==this.jmiDeleteStudent){
            this.jIFStudentDelete=new JIFStudentDelete();
            this.add(jIFStudentDelete);
            jIFStudentDelete.setVisible(true);
        }
    }
}
