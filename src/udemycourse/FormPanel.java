package udemycourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class FormPanel extends JPanel{
    
    private JLabel lblName, lblOccupation;
    private JTextField txtName, txtOccupation;
    private JButton btnSubmit;
    private FormListener formListener;
    private JList ageList;
    
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
        
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(0, "Under 18"));
        ageModel.addElement(new AgeCategory(1, "18 to 65"));
        ageModel.addElement(new AgeCategory(2, "66 and Above"));
        ageList.setModel(ageModel);
        
        ageList.setPreferredSize(new Dimension(100,66));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(0);
        
        btnSubmit = new JButton("Submit");
        
        //ActionListener for button submit
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String occupation = txtOccupation.getText();
                AgeCategory ageCat = (AgeCategory)ageList.getSelectedValue();
                
                FormEvent event = new FormEvent(this, name, occupation, ageCat.getId());
                
                if(formListener != null) {
                    formListener.formEvent(event);
                    txtName.setText("");
                    txtOccupation.setText("");
                }
            }
        });
        
        //set Panel layout
        setLayout(new GridBagLayout());
        
        GridBagConstraints gc = new GridBagConstraints();
        
        
        
        //////////////////// FIRST ROW ////////////////////
        
        gc.weightx = 1.0;
        gc.weighty = 0.3; //Let the 上下宽度比较小
        
        //This is for name label setting
        gc.gridx = 0; //this mean first of the col
        gc.gridy = 0; //this mean first of the row
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
        
        gc.weightx = 1.0;
        gc.weighty = 0.3;
        
        //occupation label setting
        gc.gridx = 0;
        gc.gridy = 1;
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
        
        gc.weightx = 1.0;
        gc.weighty = 0.3;
        
        //button setting
        gc.gridx = 1; //put in the 2nd column, so the button will be centered
        gc.gridy = 2;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        //Add Jlist
        add(ageList, gc);
        
        //////////////////// FOURTH ROW ////////////////////
        
        gc.weightx = 1.0;
        gc.weighty = 1.0;
        
        //button setting
        gc.gridx = 1; //put in the 2nd column, so the button will be centered
        gc.gridy = 3;
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