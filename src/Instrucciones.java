
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Instrucciones extends JFrame implements KeyListener{
    private JLabel [] arrayLabel = new JLabel[20];
    private ImageIcon [] imagen = new ImageIcon[10];
    private JButton boton1;
    private Sound music = new Sound();
    private ImageIcon [] imagenEntidades = new ImageIcon[3];

    public Instrucciones(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Instruciones");
        setSize(300,600);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("images/KeyIcon.png")).getImage());

        addKeyListener(this);

        getContentPane().setBackground(new Color(0, 204, 255));

        arrayLabel[1] = new JLabel();
        arrayLabel[1].setOpaque(true);
        arrayLabel[1].setBackground(new Color(255,255,255));
        arrayLabel[1].setBounds(95,510,96,44);

        arrayLabel[0] = new JLabel("  Regresar");
        arrayLabel[0].setOpaque(true);
        arrayLabel[0].setBounds(98,513,90,38);
        arrayLabel[0].setFont(new Font("Agency FB",0,26));
        arrayLabel[0].setForeground(new Color(255,255,255));
        arrayLabel[0].setBackground(new Color(0,0,255));

        imagen[0] = new ImageIcon("src/images/Man.png");//imagen
        arrayLabel[2] = new JLabel(imagen[0]);
        arrayLabel[2].setBounds(110,440,60,60);

        arrayLabel[3] = new JLabel("1. Memoriza el laberinto.");
        arrayLabel[3].setBounds(5,3,300,20);
        arrayLabel[3].setFont(new Font("Arial",1,17));
        arrayLabel[3].setForeground(Color.black);

        arrayLabel[4] = new JLabel("2. Llega a la salida con pocos");
        arrayLabel[4].setBounds(5,23,300,20);
        arrayLabel[4].setFont(new Font("Arial",1,17));
        arrayLabel[4].setForeground(Color.black);

        arrayLabel[8] = new JLabel("    movimientos.");
        arrayLabel[8].setBounds(5,43,300,20);
        arrayLabel[8].setFont(new Font("Arial",1,17));
        arrayLabel[8].setForeground(Color.black);

        arrayLabel[5] = new JLabel("3. Usa objetos de ayuda.");
        arrayLabel[5].setBounds(5,63,300,20);
        arrayLabel[5].setFont(new Font("Arial",1,17));
        arrayLabel[5].setForeground(Color.black);

        arrayLabel[6] = new JLabel("4. Responde a la pregunta al");
        arrayLabel[6].setBounds(5,83,300,20);
        arrayLabel[6].setFont(new Font("Arial",1,17));
        
        arrayLabel[6].setForeground(Color.black);

        arrayLabel[9] = new JLabel("    encontrar un enemigo.");
        arrayLabel[9].setBounds(5,103,300,20);
        arrayLabel[9].setFont(new Font("Arial",1,17));
        arrayLabel[9].setForeground(Color.black);

        arrayLabel[7] = new JLabel("5. El ganador sera basado en");
        arrayLabel[7].setBounds(5,123,300,20);
        arrayLabel[7].setFont(new Font("Arial",1,17));
        arrayLabel[7].setForeground(Color.black);

        arrayLabel[10] = new JLabel("    movimientos y si ha muerto.");
        arrayLabel[10].setBounds(5,143,300,20);
        arrayLabel[10].setFont(new Font("Arial",1,17));
        arrayLabel[10].setForeground(Color.black);


        arrayLabel[13] = new JLabel("OBJETOS DE AYUDA:");
        arrayLabel[13].setBounds(3,233,300,20);
        arrayLabel[13].setFont(new Font("Arial",1,20));
        arrayLabel[13].setForeground(new Color(0,0,0));


        imagenEntidades[0] = new ImageIcon("src/images/Candle.gif");
        imagenEntidades[1] = new ImageIcon("src/images/Bomb.gif");
        imagenEntidades[2] = new ImageIcon("src/images/Heart.gif");

        arrayLabel[14] = new JLabel(imagenEntidades[2]);
        arrayLabel[14].setBounds(10,244,60,60);

        arrayLabel[15] = new JLabel("CORAZON: Sube un punto de vida");
        arrayLabel[15].setBounds(58,268,300,13);
        arrayLabel[15].setFont(new Font("Arial",1,13));
        arrayLabel[15].setForeground(Color.red);

        arrayLabel[16] = new JLabel(imagenEntidades[0]);
        arrayLabel[16].setBounds(10,294,60,60);

        arrayLabel[17] = new JLabel("VELA: Muestra mas area alrededor");
        arrayLabel[17].setBounds(58,323,300,13);
        arrayLabel[17].setFont(new Font("Arial",1,13));
        arrayLabel[17].setForeground(Color.red);

        arrayLabel[18] = new JLabel(imagenEntidades[1]);
        arrayLabel[18].setBounds(7,354,60,60);

        arrayLabel[19] = new JLabel("BOMBA: Mata a un enemigo");
        arrayLabel[19].setBounds(58,388,300,13);
        arrayLabel[19].setFont(new Font("Arial",1,13));
        arrayLabel[19].setForeground(Color.red);

        add(arrayLabel[19]);
        add(arrayLabel[18]);
        add(arrayLabel[17]);
        add(arrayLabel[16]);
        add(arrayLabel[15]);
        add(arrayLabel[14]);
        add(arrayLabel[13]);
        add(arrayLabel[10]);
        add(arrayLabel[9]);
        add(arrayLabel[8]);
        add(arrayLabel[7]);
        add(arrayLabel[6]);
        add(arrayLabel[5]);
        add(arrayLabel[4]);
        add(arrayLabel[3]);
        add(arrayLabel[2]);
        add(arrayLabel[0]);
        add(arrayLabel[1]);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {//eventos de teclado en cualquier situacion
            case 27://esc
                Inicio v = new Inicio();
                v.setVisible(true);
                this.setVisible(false);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
