package udemycourse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{
    
    private JButton btn_Click;
    private TextPanel textPanel;
    
    public MainFrame() {
        //set Frame windows name
        super("Udemy Course");
        
        //set Frame Layout
        setLayout(new BorderLayout());
        
        btn_Click = new JButton("Click Me");
        textPanel = new TextPanel();
        
        btn_Click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textPanel.appendText("Hello\n");
            }
        });
        
        add(textPanel, BorderLayout.CENTER);
        add(btn_Click, BorderLayout.SOUTH);
        
        //Frame setting
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
    }
}
