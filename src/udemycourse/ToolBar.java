package udemycourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolBar extends JPanel implements ActionListener{
    
    private JButton btn_1, btn_2;
    private StringListener textListener;
    
    public ToolBar() {
        btn_1 = new JButton("Hello");
        btn_2 = new JButton("Goodbye");
        
        //Add action listener to btn
        btn_1.addActionListener(this);
        btn_2.addActionListener(this);
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        
        add(btn_1);
        add(btn_2);
    }
    
    public void setStringListener(StringListener listener) {
        this.textListener = listener;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton clicked = (JButton)e.getSource();
        
        if(clicked == btn_1) {
            if(textListener != null) {
                textListener.textPerformed("Hello\n");
            }
        } else if(clicked == btn_2) {
            if(textListener != null) {
                textListener.textPerformed("GoodBye\n");
            }
        }
    }
}
