/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas4;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author safik
 */
public class Tugas4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ImageIcon icon = new ImageIcon(Tugas4.class.getResource("14.gif").getFile());
        JOptionPane.showMessageDialog(null, "Cerrando sesión...", "About", JOptionPane.INFORMATION_MESSAGE, icon);
    }
    
}
