import javax.swing.*;

public class FrameBase extends JFrame {
    int largo_pantalla,alto_pantalla;
    void frame(String page_name,int largo,int alto){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(page_name);
        setSize(largo,alto);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("images/KeyIcon.png")).getImage());
    }
}
