package gui;

import business.MaterialBusiness;
import domain.Audiovisual;
import domain.Book;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class JIFNewMaterial extends JInternalFrame implements ActionListener, InternalFrameListener {

    private MaterialBusiness materialBusiness;

    private JComboBox jcbOption, jcbTheme, jcbBrand, jcbType;
    private JLabel jlImage, jlName, jlAuthor, jlYear, jlTheme, jlLanguage, jlCountry, jlFormat, jlBrand, jlDescription, jlType;
    private JTextField jtfPathImage, jtfName, jtfAuthor, jtfYear, jtfLanguage, jtfCountry, jtfDescription;
    private JRadioButton jrbPhysical, jrbDigital;
    private ButtonGroup bgFormat;
    private JButton jbSearch, jbOkBook, jbOkAudiovisual, jbOkDisk, jbOkOther;
    private String pathImage;

    public JIFNewMaterial() {
        super("New Material", false, true, false, false);
        this.setSize(360, 150);
        this.setLocation(20, 40);
        this.setLayout(null);
        this.materialBusiness = new MaterialBusiness();
        init();
        this.addInternalFrameListener(this);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    } // constructor

    private void init() {
        initComboBoxOption();
        this.initBook();
    } // init

    private void initComboBoxOption() {
        this.jcbOption = new JComboBox(new String[]{"Book","Disk","Laptop","Mouse","Projector","Other"});
        this.jcbOption.setBounds(30, 20, 120, 25);
        this.jcbOption.addActionListener(this);
        this.add(jcbOption);
    } // initComboBoxOption

    private void initBook() {
        this.setSize(360, 480);
        refresh();

        this.jlImage = new JLabel("Image");
        this.jlName = new JLabel("Name");
        this.jlAuthor = new JLabel("Author");
        this.jlYear = new JLabel("Year");
        this.jlTheme = new JLabel("Theme");
        this.jlLanguage = new JLabel("Language");
        this.jlCountry = new JLabel("Country");
        this.jlFormat = new JLabel("Format");
        this.jtfPathImage = new JTextField();
        this.jtfName = new JTextField();
        this.jtfAuthor = new JTextField();
        this.jtfYear = new JTextField();
        this.jtfLanguage = new JTextField();
        this.jtfCountry = new JTextField();
        this.jrbDigital = new JRadioButton("Digital");
        this.jrbPhysical = new JRadioButton("Physical");
        this.jbOkBook = new JButton("Book");
        this.jbSearch = new JButton("Search");

        this.bgFormat = new ButtonGroup();
        this.bgFormat.add(this.jrbDigital);
        this.bgFormat.add(this.jrbPhysical);
        
        this.jcbTheme = new JComboBox(new String[]{"Other", "Agronomy",
            "Anthropology", "Biology", "Chemistry", "Computing",
            "Economic Sciences", "Essay", "Geography", "Geology", "History",
            "Languages", "Law", "Math", "Medicine", "Music", "Pedagogy",
            "Philology", "Philosophy", "Psychology", "Science",
            "Sociology", "Thesis"});

        this.pathImage = "";

        this.jbOkBook.setFocusable(false);
        this.jbSearch.setFocusable(false);

        this.jbOkBook.addActionListener(this);
        this.jbSearch.addActionListener(this);

        this.jlImage.setBounds(30, 70, 50, 15);
        this.jlName.setBounds(30, 110, 40, 15);
        this.jlAuthor.setBounds(30, 150, 50, 15);
        this.jlYear.setBounds(30, 190, 70, 15);
        this.jlTheme.setBounds(30, 230, 70, 15);
        this.jlLanguage.setBounds(30, 270, 100, 15);
        this.jlCountry.setBounds(30, 310, 70, 15);
        this.jlFormat.setBounds(30, 350, 70, 15);
        this.jtfPathImage.setBounds(130, 65, 170, 25);
        this.jtfName.setBounds(130, 105, 170, 25);
        this.jtfAuthor.setBounds(130, 145, 170, 25);
        this.jtfYear.setBounds(130, 185, 170, 25);
        this.jcbTheme.setBounds(130, 225, 170, 25);
        this.jtfLanguage.setBounds(130, 265, 170, 25);
        this.jtfCountry.setBounds(130, 305, 170, 25);
        this.jrbDigital.setBounds(125, 350, 85, 15);
        this.jrbPhysical.setBounds(210, 350, 170, 15);
        this.jbOkBook.setBounds(230, 390, 70, 40);
        this.jbSearch.setBounds(305, 65, 25, 25);

        this.jrbDigital.setSelected(true);

        this.add(this.jlImage);
        this.add(this.jlName);
        this.add(this.jlAuthor);
        this.add(this.jlYear);
        this.add(this.jlTheme);
        this.add(this.jlLanguage);
        this.add(this.jlCountry);
        this.add(this.jlFormat);
        this.add(this.jtfPathImage);
        this.add(this.jtfName);
        this.add(this.jtfAuthor);
        this.add(this.jtfYear);
        this.add(this.jcbTheme);
        this.add(this.jtfLanguage);
        this.add(this.jtfCountry);
        this.add(this.jrbDigital);
        this.add(this.jrbPhysical);
        this.add(this.jbOkBook);
        this.add(this.jbSearch);
    } // initBook

    private void initAudiovisual() {
        this.setSize(360, 240);
        refresh();
        
        this.jlBrand = new JLabel("Brand");
        this.jlDescription = new JLabel("Description");
        this.jcbBrand = new JComboBox(new String[]{"Hp", "Toshiba", "Dell"});
        this.jtfDescription = new JTextField();
        this.jbOkAudiovisual = new JButton("OK");

        this.jbOkAudiovisual.addActionListener(this);
        this.jbOkAudiovisual.setFocusable(false);

        this.jlBrand.setBounds(30, 70, 50, 15);
        this.jlDescription.setBounds(30, 110, 90, 15);
        this.jcbBrand.setBounds(130, 65, 170, 25);
        this.jtfDescription.setBounds(130, 105, 170, 25);
        this.jbOkAudiovisual.setBounds(230, 140, 70, 40);

        this.add(this.jlBrand);
        this.add(this.jlDescription);
        this.add(this.jcbBrand);
        this.add(this.jtfDescription);
        this.add(this.jbOkAudiovisual);
    } // initAudiovisual: laptop, proyector, Mouse

    private void initDisk() {
        this.setSize(360, 300);
        refresh();

        this.jlType = new JLabel("Type");
        this.jlName = new JLabel("Name");
        this.jlDescription = new JLabel("Description");
        this.jcbType = new JComboBox(new String[]{"CD", "DVD"});
        this.jtfName = new JTextField();
        this.jtfDescription = new JTextField();
        this.jbOkDisk = new JButton("OK");

        this.jbOkDisk.addActionListener(this);
        this.jbOkDisk.setFocusable(false);

        this.jlType.setBounds(30, 70, 50, 15);
        this.jlName.setBounds(30, 110, 50, 15);
        this.jlDescription.setBounds(30, 150, 90, 15);
        this.jcbType.setBounds(130, 65, 170, 25);
        this.jtfName.setBounds(130, 105, 170, 25);
        this.jtfDescription.setBounds(130, 140, 170, 25);
        this.jbOkDisk.setBounds(230, 180, 70, 40);

        this.add(this.jlType);
        this.add(this.jlName);
        this.add(this.jlDescription);
        this.add(this.jcbType);
        this.add(this.jtfName);
        this.add(this.jtfDescription);
        this.add(this.jbOkDisk);
    } // initDisk: CD DVD

    private void initOther() {
        this.setSize(360, 240);
        refresh();

        this.jlName = new JLabel("Name");
        this.jlDescription = new JLabel("Description");
        this.jtfName = new JTextField();
        this.jtfDescription = new JTextField();
        this.jbOkOther = new JButton("OK");

        this.jbOkOther.addActionListener(this);
        this.jbOkOther.setFocusable(false);

        this.jlName.setBounds(30, 70, 50, 15);
        this.jlDescription.setBounds(30, 110, 90, 15);
        this.jtfName.setBounds(130, 65, 170, 25);
        this.jtfDescription.setBounds(130, 100, 170, 25);
        this.jbOkOther.setBounds(230, 140, 70, 40);

        this.add(this.jlName);
        this.add(this.jlDescription);
        this.add(this.jtfName);
        this.add(this.jtfDescription);
        this.add(this.jbOkOther);
    } // initOther

    private void refresh() {
        this.getContentPane().removeAll();
        initComboBoxOption();
    } // refresh

    private void cleanTextFields() {
        this.jtfName.setText("");
        this.jtfYear.setText("");
        this.jtfAuthor.setText("");
        this.jtfCountry.setText("");
        this.jtfLanguage.setText("");
        this.jtfPathImage.setText("");
        this.jtfDescription.setText("");
    } // cleanTextFields

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jcbOption) {
            Object selection = this.jcbOption.getSelectedItem();
            if (selection.equals("Book")) {
                initBook();
            } else if (selection.equals("Laptop") || selection.equals("Projector") || selection.equals("Mouse")) {
                initAudiovisual();
            } else if (selection.equals("Disk")) {
                initDisk();
            } else if (selection.equals("Other")) {
                initOther();
            }
        } else if (e.getSource() == this.jbOkBook) {
            try {
                String name = this.jtfName.getText();
                String author = this.jtfAuthor.getText();
                String language = this.jtfLanguage.getText();
                String country = this.jtfCountry.getText();
                int year = Integer.parseInt(this.jtfYear.getText());
                if (name.equals("") || author.equals("") || language.equals("") || country.equals("")) {
                    JOptionPane.showMessageDialog(this, "All spaces are required", "Error", 0);
                } else {
                    Book book = new Book(name, author, year, this.jcbTheme.getSelectedItem().toString(),
                            language, country, "", -1, this.jcbOption.getSelectedItem().toString(), 1, 1);
                    if (!this.pathImage.equals("")) {
                        book.setPathImage(this.pathImage);
                    } else {
                        book.setPathImage("/assets/sinIma.png");
                    }
                    if (this.jrbDigital.isSelected()) {
                        book.setFormat("Digital");
                    } else {
                        book.setFormat("Physical");
                    }
                    try {
                        this.materialBusiness.addMaterial(book, 2);
                        JOptionPane.showMessageDialog(this, "Success");
                        cleanTextFields();
                    } catch (IOException | ClassNotFoundException ex) {
                        Logger.getLogger(JIFNewMaterial.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "The year must be a number.", "Error", 0);
            }

        } else if (e.getSource() == this.jbOkAudiovisual) {
            try {
                this.materialBusiness.addMaterial(new Audiovisual(this.jcbBrand.getSelectedItem().toString(),
                        this.jtfDescription.getText(), -1, this.jcbOption.getSelectedItem().toString(),
                        true), 1);
                JOptionPane.showMessageDialog(this, "Success");
                cleanTextFields();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(JIFNewMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == this.jbOkDisk) {
            if (this.jtfName.equals("")) {
                JOptionPane.showMessageDialog(this, "The name is required", "Error", 0);
            } else {
                try {
                    this.materialBusiness.addMaterial(new Audiovisual(this.jtfName.getText(),
                            this.jtfDescription.getText(), -1, this.jcbType.getSelectedItem().toString(),
                            true), 1);
                    JOptionPane.showMessageDialog(this, "Success");
                    cleanTextFields();
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(JIFNewMaterial.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (e.getSource() == this.jbOkOther) {
            try {
                if (this.jtfName.equals("") || this.jtfDescription.equals("")) {
                    JOptionPane.showMessageDialog(this, "All spaces are required", "Error", 0);
                } else {
                    this.materialBusiness.addMaterial(new Audiovisual(this.jtfName.getText(),
                            this.jtfDescription.getText(), -1, "Other", true), 1);
                    JOptionPane.showMessageDialog(this, "Success");
                    cleanTextFields();
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(JIFNewMaterial.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == this.jbSearch) {
            this.pathImage = pathImage();
            this.jtfPathImage.setText(this.pathImage);
        }
    } // actionPerformed

    private String pathImage() {
        JFileChooser chooser = new JFileChooser();
        //FileNameExtensionFilter fnef = new FileNameExtensionFilter("image", "png");
        //chooser.setFileFilter(fnef);
        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile().getPath();
        }
        return "/assets/sinIma.png";
    } // pathImage

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        MainWindows.jmiNewMaterial.setEnabled(true);
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
