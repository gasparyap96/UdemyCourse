package udemycourse;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    
    private TextPanel textPanel;
    private ToolBar toolBar;
    private FormPanel formPanel;
    
    public MainFrame() {
        //set Frame windows name
        super("Udemy Course");
        
        //set Frame Layout
        setLayout(new BorderLayout());
        
        textPanel = new TextPanel();
        toolBar = new ToolBar();
        formPanel = new FormPanel();
        
        //pass text panel to toolbar
        toolBar.setStringListener(new StringListener() {
            
            @Override
            public void textPerformed(String text) {
                textPanel.appendText(text);
            }
        });
        
        formPanel.setFormListener(new FormListener() {
            
            @Override
            public void formEvent(FormEvent e) {
                String name = e.getName();
                String occupation = e.getOccupation();
                
                textPanel.appendText(name + " : " + occupation + "\n");
            }
        });
        
        add(formPanel, BorderLayout.WEST);
        add(toolBar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        
        //Frame setting
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
    }
}
