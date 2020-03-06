package udemycourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToolBar extends JPanel implements ActionListener{
    
    private JButton btn_1, btn_2;
    private TextPanel textPanel;
    
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
    
    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton clicked = (JButton)e.getSource();
        
        if(clicked == btn_1) {
            textPanel.appendText("Hello\n");
        } else if(clicked == btn_2) {
            textPanel.appendText("GoodBye\n");
        }
    }
}
