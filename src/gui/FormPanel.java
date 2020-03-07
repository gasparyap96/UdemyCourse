package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class FormPanel extends JPanel{
    
    private JLabel lblName, lblOccupation, lblTax;
    private JTextField txtName, txtOccupation, txtTax;
    private JButton btnSubmit;
    private FormListener formListener;
    private JList ageList;
    private JComboBox empCombo;
    private JCheckBox citizenCheck;
    private JRadioButton maleRadio, femaleRadio;
    private ButtonGroup genderGroup;
    
    public FormPanel() {
        //Resize the form panel
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
        //Border setting
        Border innerBorder = BorderFactory.createTitledBorder("Add Person");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
        
        lblName = new JLabel("Name: ");
        lblOccupation = new JLabel("Occupation: ");
        txtName = new JTextField(13);
        txtOccupation = new JTextField(13);
        ageList = new JList();
        empCombo = new JComboBox();
        lblTax = new JLabel("Tax: ");
        txtTax = new JTextField(13);
        citizenCheck = new JCheckBox();
        
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        
        //Set up radio
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);
        maleRadio.setSelected(true);
        
        maleRadio.setActionCommand("male");
        femaleRadio.setActionCommand("female");
        
        //Set List
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "Under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
        ageModel.addElement(new AgeCategory(2, "66 and Above"));
        ageList.setModel(ageModel);
        
        ageList.setPreferredSize(new Dimension(100,66));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(0);
        
        //Set combo box
        DefaultComboBoxModel empModel = new DefaultComboBoxModel();
        empModel.addElement("Employed");
        empModel.addElement("Self-Employed");
        empModel.addElement("Unemployed");
        empCombo.setModel(empModel);
        empCombo.setSelectedIndex(0);
        
        //Set up tax id
        lblTax.setEnabled(false);
        txtTax.setEnabled(false);
        
        citizenCheck.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean isChecked = citizenCheck.isSelected();
                lblTax.setEnabled(isChecked);
                txtTax.setEnabled(isChecked);
            }
        });
        
        btnSubmit = new JButton("Submit");
        
        //ActionListener for button submit
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String occupation = txtOccupation.getText();
                AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
                String empCat = (String)empCombo.getSelectedItem();
                String taxId = txtTax.getText();
                boolean USCitizen = citizenCheck.isSelected();
                String gender = genderGroup.getSelection().getActionCommand();
                
                FormEvent event = new FormEvent(this, name, occupation, 
                                                 ageCat.getId(), empCat, taxId, USCitizen,
                                                gender);
                
                if(formListener != null) {
                    formListener.formEvent(event);
                    txtName.setText("");
                    txtOccupation.setText("");
                }
            }
        });
        
        layoutComponents();
    }//END of Constructor
    
    public void layoutComponents() {
        //set Panel layout
        setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        
        
        
        //////////////////// FIRST ROW ////////////////////
        
        gc.gridy = 0; //this mean first of the row
        gc.weightx = 1.0;
        gc.weighty = 0.3; //Let the 上下宽度比较小
        
        //This is for name label setting
        gc.gridx = 0; //this mean first of the col
        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END; //Put the label name to the very right
        gc.insets = new Insets(0, 0, 0, 5); //Top, Left, Bottom, Right, Add padding to right
        //add components to gridBagLayout
        add(lblName, gc);
        
        //txt name setting
        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        //add txt name to panel
        add(txtName, gc);
        
        //////////////////// SECOND ROW ////////////////////
        
        gc.gridy++; //Mean new row
        gc.weightx = 1.0;
        gc.weighty = 0.3;
        
        //occupation label setting
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        //add occupation label
        add(lblOccupation, gc);
        
        //txt occupation setting
        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.LINE_START;
        //add occupation text field
        add(txtOccupation, gc);
        
        //////////////////// Third ROW ////////////////////
        
        gc.gridy++; //Mean new row
        gc.weightx = 1.0;
        gc.weighty = 0.3;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        //add occupation label
        add(new JLabel("Age: "), gc);
        
        //List setting
        gc.gridx = 1; //put in the 2nd column, so the button will be centered
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        //Add Jlist
        add(ageList, gc);
        
        //////////////////// New ROW ////////////////////
        
        gc.gridy++; //Mean new row
        gc.weightx = 1.0;
        gc.weighty = 0.3;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        //add occupation label
        add(new JLabel("Employment: "), gc);
        
        //button setting
        gc.gridx = 1; //put in the 2nd column, so the button will be centered
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        //Add Jlist
        add(empCombo, gc);
        
        //////////////////// New ROW ////////////////////
        
        gc.gridy++; //Mean new row
        gc.weightx = 1.0;
        gc.weighty = 0.3;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        //add occupation label
        add(new JLabel("US Citizen: "), gc);
        
        //button setting
        gc.gridx = 1; //put in the 2nd column, so the button will be centered
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        //Add Jlist
        add(citizenCheck, gc);
        
        //////////////////// New ROW ////////////////////
        
        gc.gridy++; //Mean new row
        gc.weightx = 1.0;
        gc.weighty = 0.3;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        //add occupation label
        add(lblTax, gc);
        
        //button setting
        gc.gridx = 1; //put in the 2nd column, so the button will be centered
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        //Add Jlist
        add(txtTax, gc);
        
        //////////////////// New ROW ////////////////////
        
        gc.gridy++; //Mean new row
        gc.weightx = 1.0;
        gc.weighty = 0.05;
        
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0, 0, 0, 5);
        //add occupation label
        add(new JLabel("Gender: "), gc);
        
        //button setting
        gc.gridx = 1; //put in the 2nd column, so the button will be centered
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        //Add Jlist
        add(maleRadio, gc);
        
        //////////////////// New ROW ////////////////////
        
        gc.gridy++; //Mean new row
        gc.weightx = 1.0;
        gc.weighty = 0.3;
        
        //button setting
        gc.gridx = 1; //put in the 2nd column, so the button will be centered
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        //Add Jlist
        add(femaleRadio, gc);
        
        //////////////////// Next ROW ////////////////////
        
        gc.gridy++; //Mean new row
        gc.weightx = 1.0;
        gc.weighty = 1.0;
        
        //button setting
        gc.gridx = 1; //put in the 2nd column, so the button will be centered
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        //add button
        add(btnSubmit, gc);
    }
    
    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}

class AgeCategory {
    
    private int id;
    private String text;
    
    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }
    
    public String toString() {
        return text;
    }
    
    public int getId() {
        return id;
    }
}