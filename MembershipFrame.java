
package ac.za;




import ac.za.tut.Member;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;


public class MembershipFrame extends JFrame{
    
    
    private JPanel headingPnl;
    private JPanel clientdetailsPnl;
    private JPanel namePnl;
    private JPanel surnamePnl;
    private JPanel idNoPnl;
    private JPanel genderPnl;
    private JPanel contractPnl;
    private JPanel typeContractPnl;
    private JPanel checkBoxPnl;
    private JPanel textAreaPnl;
    private JPanel btnPnl;
    private JPanel clientAndContract;
    private JPanel mainPnl;
    
    //labels
    private JLabel headingLbl;
    private JLabel nameLbl;
    private JLabel surnameLbl;
    private JLabel idNoLbl;
    private JLabel genderLbl;
    private JLabel typeLbl;
    private JLabel checkBoxLbl;
    
    //textFields
    private JTextField nameTxtFld;
    private JTextField surnameTxtFld;
    private JTextField idNoTxtFld;
    
   
    //comboBox
    private JComboBox comboBox;
    //radiobuttons
    private JRadioButton month;
    private JRadioButton sixMonth;
    private JRadioButton annual;
    //textarea
    private JTextArea textarea;
    //scrollPane
    private JScrollPane scroll;
    //checkBox
    private JCheckBox checkBox;
    //btngroup
    private ButtonGroup btnGroup;
    //buttons
    private JButton register;
    private JButton search;
    private JButton update;
    private JButton remove;
    private JButton displayAll;
    private JButton clear;
    private JButton exit;
    private ArrayList<Member>members;
    public MembershipFrame(){
        setTitle("Gym membership");
        setSize(400,450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        
        headingPnl=new JPanel(new FlowLayout(FlowLayout.CENTER));
        clientdetailsPnl=new JPanel(new GridLayout(4,1,1,1));
        clientdetailsPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK, 1),"Client details"));
        namePnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        surnamePnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        idNoPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        contractPnl=new JPanel(new GridLayout(2,1,1,1));
        contractPnl.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1 ),"Contract options"));
        typeContractPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        checkBoxPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        textAreaPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnPnl=new JPanel(new FlowLayout(FlowLayout.LEFT));
        clientAndContract=new JPanel(new BorderLayout());
        mainPnl=new JPanel(new BorderLayout());
        
        //labels
        headingLbl=new JLabel("Membership Form");
        headingLbl.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        headingLbl.setFont(new Font(Font.SANS_SERIF, Font.BOLD+Font.ITALIC,20));
        headingLbl.setForeground(Color.BLUE);
        nameLbl=new JLabel("Name: ");
        surnameLbl=new JLabel("Surname: ");
        idNoLbl=new JLabel("Id no: ");
        genderLbl=new JLabel("Gender: ");
        typeLbl=new JLabel("Type of contract: ");
        checkBoxLbl=new JLabel("Select the checkbox if you need a personal trainer   ");
        //textFields
        nameTxtFld=new JTextField(15);
        surnameTxtFld=new JTextField(15);
        idNoTxtFld=new JTextField(15);
        //comboBox
        comboBox=new JComboBox();
        comboBox.addItem("Male");
        comboBox.addItem("Female");
        
        //radioButtons
        month=new JRadioButton("Month-to-month");
        sixMonth=new JRadioButton("six months");
        annual=new JRadioButton("Annual");
        
        //checkbox
        checkBox=new JCheckBox();
        //btnGroup
        btnGroup=new ButtonGroup();
        btnGroup.add(month);
        btnGroup.add(sixMonth);
        btnGroup.add(annual);
        
        //textarea
        textarea=new JTextArea(30,40);
        textarea.setBorder(new TitledBorder(new LineBorder(Color.BLACK,1 ),"Member(s) details"));
        
        //scrollPane
        scroll=new JScrollPane(textarea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        
        //btn
        register=new JButton("Register");
        register.addActionListener(new RegisterBtnListener());
        search=new JButton("Search");
        update=new JButton("Update");
        remove=new JButton("Remove");
        displayAll=new JButton("Display All");
        displayAll.addActionListener(new displayAllbtnListener());
        clear=new JButton("Clear");
        clear.addActionListener(new clearBtnActionListener());
        exit=new JButton("Exit");
        exit.addActionListener(new exitBtnActionListener());
        
        
        //add
        headingPnl.add(headingLbl);
        namePnl.add(nameLbl);
        namePnl.add(nameTxtFld);
        surnamePnl.add(surnameLbl);
        surnamePnl.add(surnameTxtFld);
        idNoPnl.add(idNoLbl);
        idNoPnl.add(idNoTxtFld);
        genderPnl.add(genderLbl);
        genderPnl.add(comboBox);
        clientdetailsPnl.add(namePnl);
        clientdetailsPnl.add(surnamePnl);
        clientdetailsPnl.add(idNoPnl);
        clientdetailsPnl.add(genderPnl);
        typeContractPnl.add(typeLbl);
        typeContractPnl.add(month);
        typeContractPnl.add(sixMonth);
        typeContractPnl.add(annual);
        checkBoxPnl.add(checkBoxLbl);
        checkBoxPnl.add(checkBox);
        contractPnl.add(typeContractPnl);
        contractPnl.add(checkBoxPnl);
        textAreaPnl.add(scroll);
        btnPnl.add(register);
        btnPnl.add(search);
        btnPnl.add(update);
        btnPnl.add(remove);
        btnPnl.add(displayAll);
        btnPnl.add(clear);
        btnPnl.add(exit);
        
        clientAndContract.add(clientdetailsPnl,BorderLayout.NORTH);
        clientAndContract.add(contractPnl,BorderLayout.CENTER);
        clientAndContract.add(textAreaPnl,BorderLayout.SOUTH);
        
       mainPnl.add(headingPnl,BorderLayout.NORTH);
       mainPnl.add(clientAndContract,BorderLayout.CENTER);
        mainPnl.add(btnPnl,BorderLayout.SOUTH);
        add(mainPnl);
        pack();
        
        setVisible(true);
        
        
    }
    private void clearFields(){
        nameTxtFld.setText("");
        surnameTxtFld.setText("");
        idNoTxtFld.setText("");
        checkBox.setSelected(false);
        btnGroup.clearSelection();
        textarea.setText(" ");
    }
    private class RegisterBtnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            String name=nameTxtFld.getText();
            String surname=surnameTxtFld.getText();
            String idNo=idNoTxtFld.getText();
            String gender=(String)comboBox.getSelectedItem();
            String typeContract="Month-to-Month";
            Boolean personalTrainer=checkBox.isSelected();
            if(sixMonth.isSelected()){
                typeContract="Six months";
            }
            else if(annual.isSelected()){
                typeContract="Annual";
            }
            Member member=new Member(name,surname,idNo,gender,typeContract,personalTrainer);
            
           JFileChooser fc;
           fc= new JFileChooser();
           File file;
           int val=fc.showSaveDialog(MembershipFrame.this);
            BufferedWriter bw;
           
           if(val==JFileChooser.APPROVE_OPTION){
               try{
                   file=fc.getSelectedFile();
                   bw=new BufferedWriter(new FileWriter(file,true));
                   bw.write(member.toString());
                   bw.newLine();
                   bw.close();
                   clearFields();
                   JOptionPane.showMessageDialog(MembershipFrame.this, "Member registered!");
               } catch (IOException ex) {
               
               }
           }
           else{
               JOptionPane.showMessageDialog(MembershipFrame.this, "The if statement failed , return value "+val);
           }
           
        }
        
    }
    private class displayAllbtnListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
        JFileChooser fc;
        int val;
        File file;
        BufferedReader br;
        String data, record="";
        
        fc=new JFileChooser();
        val=fc.showOpenDialog(MembershipFrame.this);
        if(val==JFileChooser.APPROVE_OPTION){
            
             try{
                 file=fc.getSelectedFile();
              br=new BufferedReader(new FileReader(file));
              
              while((data=br.readLine())!=null){
                  record+=data+"\n";
              }
              br.close();
              textarea.setText(record);
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }   catch (IOException ex) {
            ex.printStackTrace();
        }
        }
       
      }
        
    }
    private class clearBtnActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
       
        clearFields();
        
        }
        
    }
    private class exitBtnActionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
       
        System.exit(0);
        
        }
        
    }
}

