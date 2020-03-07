package gui;

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
        
        //Set menubar
        setJMenuBar(createMenuBar());
        
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
                int ageCat = e.getAgeID();
                String empCat = e.getEmployment();
                
                textPanel.appendText(name + " : " + occupation + ":" + ageCat +
                                     ":" + empCat +"\n");
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
    
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        //New menu
        JMenu fileMenu = new JMenu("File");
        JMenu windowMenu = new JMenu("Window");
        JMenu showMenu = new JMenu("Show");
        
        //Item inside Menu
        JMenuItem exportDataItem = new JMenuItem("Export Data");
        JMenuItem importDataItem = new JMenuItem("Import Data");
        JMenuItem exitItem = new JMenuItem("Exit");
        //showMenu
        JMenuItem showFormItem = new JMenuItem("Person Form");
        
        //Add item to menu
        fileMenu.add(exportDataItem);
        fileMenu.add(importDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        //Showmenu
        showMenu.add(showFormItem);
        //window menu
        windowMenu.add(showMenu);
        
        //Add menu to menu bar
        menuBar.add(fileMenu);
        menuBar.add(windowMenu);
        
        return menuBar;
    }
}
