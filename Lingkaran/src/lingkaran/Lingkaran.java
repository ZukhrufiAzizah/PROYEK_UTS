package lingkaran;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author WINDOWS
 */
public class Lingkaran {

    
    public static void main(String[] args) {
        JFrame frame = new JFrame("algoritma pembuat lingkaran");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setVisible(true);
        
        Dimension screenSize =
                Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((screenSize.width - frame.getWidth()) / 2,
                ((screenSize.height - frame.getHeight())) /2);

        gambar gbr = new gambar();
        gbr.setxc(100);
        gbr.setyc(150);
        gbr.setr(50);
        frame.add(gbr);
    }
}
    
