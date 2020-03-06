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
        
        btnSubmit = new JButton("Submit");
        
        //ActionListener for button submit
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String occupation = txtOccupation.getText();
                
                FormEvent event = new FormEvent(this, name, occupation);
                
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
        gc.weighty = 0.1; //Let the 上下宽度比较小
        
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
        gc.weighty = 0.1;
        
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
        
        //////////////////// THIRD ROW ////////////////////
        
        gc.weightx = 1.0;
        gc.weighty = 1.0;
        
        //button setting
        gc.gridx = 1; //put in the 2nd column, so the button will be centered
        gc.gridy = 2;
        gc.insets = new Insets(0, 0, 0, 0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        //add button
        add(btnSubmit, gc);
    }
    
    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}
