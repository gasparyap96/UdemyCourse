package udemycourse;

import javax.swing.*;

public class UdemyCourse {

    
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
    
}
