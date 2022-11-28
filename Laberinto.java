import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.Component;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.util.Random;

public class Laverinto {
    public static void main(String[] args) {

        Nivel1.numLav = 0;
        Inicio in = new Inicio();
        in.setVisible(true);
    }
}

class Inicio extends JFrame implements MouseListener {
    public static int reset = 0;
    private JLabel label0, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11;
    private ImageIcon imagen0, imagen1, imagen2, imagen3, imagen4, imagen5;
    private Sound music = new Sound();

    public Inicio() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Menu Principal");
        setSize(716, 497);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("images/KeyIcon.png")).getImage());

        getContentPane().setBackground(new Color(0, 204, 255));

        imagen0 = new ImageIcon("images/TitleScreen.png");
        label0 = new JLabel(imagen0);
        label0.setBounds(0, -2, 700, 500);// x , y; Ubicacion Tamaño

        label1 = new JLabel("Memorizacion y Escape");
        label1.setBounds(115, 30, 500, 40);
        label1.setFont(new Font("Copperplate Gothic Bold", 0, 35));
        label1.setForeground(new Color(225, 0, 0));

        label5 = new JLabel("Nivel 1");
        label5.setBounds(190, 145, 100, 30);
        label5.setFont(new Font("Arial", 0, 30));
        label5.setForeground(new Color(0, 0, 0));

        label6 = new JLabel("Nivel 2");
        label6.setBounds(427, 145, 100, 30);
        label6.setFont(new Font("Arial", 0, 30));
        label6.setForeground(new Color(0, 0, 0));

        imagen1 = new ImageIcon("images/Shield1.png");
        label2 = new JLabel(imagen1);
        label2.setBounds(185, 175, 100, 150);

        label3 = new JLabel(imagen1);
        label3.setBounds(425, 175, 100, 150);

        imagen3 = new ImageIcon("images/Shield2.png");
        label9 = new JLabel(imagen3);
        label9.setBounds(185, 175, 100, 150);

        label10 = new JLabel(imagen3);
        label10.setBounds(425, 175, 100, 150);

        label4 = new JLabel("FACIL");
        label4.setBounds(205, 330, 100, 30);
        label4.setFont(new Font("Bahnschrift", 0, 20));
        label4.setForeground(Color.blue);

        label7 = new JLabel("NORMAL");
        label7.setBounds(435, 330, 100, 30);
        label7.setFont(new Font("Bahnschrift", 0, 20));
        label7.setForeground(Color.gray);

        label8 = new JLabel(" Instruciones");
        label8.setOpaque(true);
        label8.setBounds(20, 400, 95, 40);
        label8.setFont(new Font("Agency FB", 1, 22));
        label8.setForeground(new Color(225, 255, 255));
        label8.setBackground(new Color(0, 142, 211));

        // events
        label9.addMouseListener(this);
        label10.addMouseListener(this);
        label8.addMouseListener(this);

        add(label7);
        add(label4);
        add(label8);
        add(label6);
        add(label5);
        add(label3);
        add(label2);
        add(label1);
        add(label10);
        add(label9);
        add(label0);
    }

    // events
    @Override
    public void mouseClicked(MouseEvent e) {
        // System.out.println("Mouse clicked");
        if (e.getSource() == label8) {
            this.setVisible(false);
            Instrucciones ins = new Instrucciones();
            ins.setVisible(true);
        }
        if (e.getSource() == label9) {
            this.setVisible(false);
            Nivel1.numLav++;
            Nivel1 n = new Nivel1();
            n.setVisible(true);
        }
        if (e.getSource() == label10) {
            this.setVisible(false);
            Nivel2.numLav++;
            Nivel2 n = new Nivel2();
            n.setVisible(true);
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == label8) {
            label8.setBackground(new Color(140, 207, 244));
        }
        if (e.getSource() == label9) {
            label2.setBounds(-100, 230, 0, 0);
            music.Play("music/Rupee.wav");
        }
        if (e.getSource() == label10) {
            label3.setBounds(-100, 230, 0, 0);
            music.Play("music/Rupee.wav");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == label8) {
            label8.setBackground(new Color(0, 142, 211));
        }
        if (e.getSource() == label9) {
            label2.setBounds(185, 175, 100, 150);
        }
        if (e.getSource() == label10) {
            label3.setBounds(425, 175, 100, 150);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

}

class Instrucciones extends JFrame implements MouseListener {
    private JLabel[] arrayLabel = new JLabel[20];
    private ImageIcon[] imagen = new ImageIcon[10];
    private JButton boton1;
    private Sound music = new Sound();
    private ImageIcon[] imagenEntidades = new ImageIcon[3];

    public Instrucciones() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Instruciones");
        setSize(300, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon(getClass().getResource("images/KeyIcon.png")).getImage());

        getContentPane().setBackground(new Color(0, 204, 255));

        arrayLabel[1] = new JLabel();
        arrayLabel[1].setOpaque(true);
        arrayLabel[1].setBackground(new Color(255, 255, 255));
        arrayLabel[1].setBounds(95, 510, 96, 44);

        arrayLabel[0] = new JLabel("  Regresar");
        arrayLabel[0].setOpaque(true);
        arrayLabel[0].setBounds(98, 513, 90, 38);
        arrayLabel[0].setFont(new Font("Agency FB", 0, 26));
        arrayLabel[0].setForeground(new Color(255, 255, 255));
        arrayLabel[0].setBackground(new Color(0, 0, 255));
        arrayLabel[0].addMouseListener(this);

        imagen[0] = new ImageIcon("images/Man.png");// imagen
        arrayLabel[2] = new JLabel(imagen[0]);
        arrayLabel[2].setBounds(110, 440, 60, 60);

        arrayLabel[3] = new JLabel("El juego consiste en escapar de un la-");
        arrayLabel[3].setBounds(5, 3, 300, 15);
        arrayLabel[3].setFont(new Font("Arial", 0, 15));
        arrayLabel[3].setForeground(new Color(255, 255, 255));

        arrayLabel[4] = new JLabel("verinto pero solo se puede ver una pe-");
        arrayLabel[4].setBounds(5, 23, 300, 15);
        arrayLabel[4].setFont(new Font("Arial", 0, 15));
        arrayLabel[4].setForeground(new Color(255, 255, 255));

        arrayLabel[5] = new JLabel("que\u00f1a parte cuando se esta jugando.");
        arrayLabel[5].setBounds(5, 43, 300, 15);
        arrayLabel[5].setFont(new Font("Arial", 0, 15));
        arrayLabel[5].setForeground(new Color(255, 255, 255));

        arrayLabel[6] = new JLabel("Hay dos cosas que se pueden encontrar,");
        arrayLabel[6].setBounds(5, 63, 300, 15);
        arrayLabel[6].setFont(new Font("Arial", 0, 15));
        arrayLabel[6].setForeground(new Color(255, 255, 255));

        arrayLabel[7] = new JLabel("enemigos y objetos de ayuda. Los ene-");
        arrayLabel[7].setBounds(5, 83, 300, 15);
        arrayLabel[7].setFont(new Font("Arial", 0, 15));
        arrayLabel[7].setForeground(new Color(255, 255, 255));

        arrayLabel[8] = new JLabel("migos consisten en una pregunta rela-");
        arrayLabel[8].setBounds(3, 103, 300, 15);
        arrayLabel[8].setFont(new Font("Arial", 0, 15));
        arrayLabel[8].setForeground(new Color(255, 255, 255));

        arrayLabel[9] = new JLabel("cionada calculo o algebra. La vida ");
        arrayLabel[9].setBounds(3, 123, 300, 15);
        arrayLabel[9].setFont(new Font("Arial", 0, 15));
        arrayLabel[9].setForeground(new Color(255, 255, 255));

        arrayLabel[10] = new JLabel("bajara si no se responde correctamente.");
        arrayLabel[10].setBounds(2, 143, 300, 15);
        arrayLabel[10].setFont(new Font("Arial", 0, 15));
        arrayLabel[10].setForeground(new Color(255, 255, 255));

        arrayLabel[11] = new JLabel("Se ganara el juego al salir del laverinto,");
        arrayLabel[11].setBounds(3, 163, 300, 15);
        arrayLabel[11].setFont(new Font("Arial", 0, 15));
        arrayLabel[11].setForeground(new Color(255, 255, 255));

        arrayLabel[12] = new JLabel("y se perdera si la vida llega a 0.");
        arrayLabel[12].setBounds(3, 183, 300, 15);
        arrayLabel[12].setFont(new Font("Arial", 0, 15));
        arrayLabel[12].setForeground(new Color(255, 255, 255));

        arrayLabel[13] = new JLabel("OBJETOS DE AYUDA:");
        arrayLabel[13].setBounds(3, 233, 300, 20);
        arrayLabel[13].setFont(new Font("Arial", 1, 20));
        arrayLabel[13].setForeground(new Color(0, 0, 0));

        imagenEntidades[0] = new ImageIcon("images/Candle.gif");
        imagenEntidades[1] = new ImageIcon("images/Bomb.gif");
        imagenEntidades[2] = new ImageIcon("images/Heart.gif");

        arrayLabel[14] = new JLabel(imagenEntidades[2]);
        arrayLabel[14].setBounds(10, 244, 60, 60);

        arrayLabel[15] = new JLabel("CORAZON: Sube un punto de vida");
        arrayLabel[15].setBounds(58, 268, 300, 13);
        arrayLabel[15].setFont(new Font("Arial", 1, 13));
        arrayLabel[15].setForeground(Color.red);

        arrayLabel[16] = new JLabel(imagenEntidades[0]);
        arrayLabel[16].setBounds(10, 294, 60, 60);

        arrayLabel[17] = new JLabel("VELA: Muestra mas area alrededor");
        arrayLabel[17].setBounds(58, 323, 300, 13);
        arrayLabel[17].setFont(new Font("Arial", 1, 13));
        arrayLabel[17].setForeground(Color.red);

        arrayLabel[18] = new JLabel(imagenEntidades[1]);
        arrayLabel[18].setBounds(7, 354, 60, 60);

        arrayLabel[19] = new JLabel("BOMBA: Mata a un enemigo");
        arrayLabel[19].setBounds(58, 388, 300, 13);
        arrayLabel[19].setFont(new Font("Arial", 1, 13));
        arrayLabel[19].setForeground(Color.red);

        add(arrayLabel[19]);
        add(arrayLabel[18]);
        add(arrayLabel[17]);
        add(arrayLabel[16]);
        add(arrayLabel[15]);
        add(arrayLabel[14]);
        add(arrayLabel[13]);
        add(arrayLabel[12]);
        add(arrayLabel[11]);
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
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == arrayLabel[0]) {// regresar
            Inicio v = new Inicio();
            v.setVisible(true);
            this.setVisible(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == arrayLabel[0]) {// regresar
            arrayLabel[0].setBackground(new Color(0, 0, 140));
            music.Play("music/Rupee.wav");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == arrayLabel[0]) {// regresar
            arrayLabel[0].setBackground(new Color(0, 0, 255));
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}

class Nivel1 extends JFrame implements MouseListener, KeyListener {
    public static int numLav;
    private int i, j, candle = 0, bomb = 0, posX = 5, posY = 0, vida = 2, vidaAntigua, moviminetos = 0, numPregunta,
            fogTurns;
    private int[] pregunta = { 1, 1, 1, 1, 1 };
    private int[][] matEntities = new int[4][6];
    private int[][] matParedes = new int[4][6];
    private String canS, bombS;
    private boolean play = false, moved = false, preguntaActiva = false;
    private JLabel[] arrayLabel = new JLabel[45];
    private JLabel[][] matLabelPreguntas = new JLabel[5][4];
    private JLabel[][] matLabel = new JLabel[4][6];
    private JLabel[][] matLabelEnteties = new JLabel[4][6];
    private ImageIcon[] imagen = new ImageIcon[10];
    private ImageIcon[] imagenTile = new ImageIcon[20];
    private ImageIcon[] imagenEntidades = new ImageIcon[20];
    private ImageIcon[] imagenPregunta = new ImageIcon[20];
    private Sound music = new Sound();
    private Random rand = new Random();

    public Nivel1() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Nivel 1");
        setSize(780, 530);// para imagenes tiene tantos menos pixeles en el eje: X:-16px Y:-39px pero si
                          // empiezan en (0.0)
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);
        setIconImage(new ImageIcon(getClass().getResource("images/KeyIcon.png")).getImage());

        if (numLav > 3)
            numLav = 1;

        getContentPane().setBackground(new Color(50, 80, 100));

        InicializarMat();// inicializa matriz en 0
        MatrizObjetoEnemigo();// inseta las entidades en la posicion adecuada
        Tiles();// dibuja el laverinto
        LabelsPreguntas();

        imagen[1] = new ImageIcon("images/bkg1.PNG");
        arrayLabel[0] = new JLabel(imagen[1]);
        arrayLabel[0].setBounds(0, 0, 767, 529);

        arrayLabel[1] = new JLabel("VIDA:");
        arrayLabel[1].setBounds(10, 10, 50, 17);
        arrayLabel[1].setFont(new Font("Arial Black", 0, 15));
        arrayLabel[1].setForeground(new Color(255, 255, 255));

        imagen[2] = new ImageIcon("images/Life1.gif");
        imagen[3] = new ImageIcon("images/Life2.gif");

        arrayLabel[2] = new JLabel(imagen[2]);// heart rojo
        arrayLabel[2].setBounds(70, 5, 25, 28);

        arrayLabel[3] = new JLabel(imagen[2]);// heart rojo
        arrayLabel[3].setBounds(105, 5, 25, 28);

        arrayLabel[4] = new JLabel(imagen[3]);// heart empty
        arrayLabel[4].setBounds(70, 5, 25, 28);

        arrayLabel[5] = new JLabel(imagen[3]);// heart empty
        arrayLabel[5].setBounds(105, 5, 25, 28);

        arrayLabel[6] = new JLabel();
        arrayLabel[6].setOpaque(true);
        arrayLabel[6].setBackground(new Color(0, 0, 0));
        arrayLabel[6].setBounds(5, 2, 140, 34);

        arrayLabel[13] = new JLabel("FACIL");
        arrayLabel[13].setOpaque(true);
        arrayLabel[13].setBounds(317, 4, 118, 38);
        arrayLabel[13].setFont(new Font("Copperplate Gothic Bold", 0, 33));
        arrayLabel[13].setForeground(Color.black);
        arrayLabel[13].setBackground(new Color(255, 0, 0));

        arrayLabel[7] = new JLabel("FACIL");
        // arrayLabel[7].setOpaque(true);
        arrayLabel[7].setBounds(320, 4, 118, 38);
        arrayLabel[7].setFont(new Font("Copperplate Gothic Bold", 0, 33));
        arrayLabel[7].setForeground(new Color(255, 255, 255));
        // arrayLabel[7].setBackground(new Color(255,0,0));

        arrayLabel[11] = new JLabel();
        arrayLabel[11].setOpaque(true);
        arrayLabel[11].setBackground(new Color(255, 255, 255));
        arrayLabel[11].setBounds(597, 402, 96, 44);

        arrayLabel[8] = new JLabel("  Regresar");
        arrayLabel[8].setOpaque(true);
        arrayLabel[8].setBounds(600, 405, 90, 38);
        arrayLabel[8].setFont(new Font("Agency FB", 0, 26));
        arrayLabel[8].setForeground(new Color(255, 255, 255));
        arrayLabel[8].setBackground(new Color(0, 0, 255));
        arrayLabel[8].addMouseListener(this);

        arrayLabel[12] = new JLabel();
        arrayLabel[12].setOpaque(true);
        arrayLabel[12].setBackground(new Color(255, 255, 255));
        arrayLabel[12].setBounds(327, 402, 98, 44);

        arrayLabel[9] = new JLabel("  Iniciar");
        arrayLabel[9].setOpaque(true);
        arrayLabel[9].setBounds(330, 405, 92, 38);
        arrayLabel[9].setFont(new Font("Arial", 1, 23));
        arrayLabel[9].setForeground(new Color(255, 255, 255));
        arrayLabel[9].setBackground(new Color(150, 150, 150));
        arrayLabel[9].addMouseListener(this);

        arrayLabel[10] = new JLabel("  Movimentos: " + moviminetos);
        arrayLabel[10].setOpaque(true);
        arrayLabel[10].setBounds(30, 405, 130, 38);
        arrayLabel[10].setFont(new Font("Agency FB", 0, 23));
        arrayLabel[10].setForeground(Color.white);
        arrayLabel[10].setBackground(Color.black);

        arrayLabel[14] = new JLabel();
        arrayLabel[14].setOpaque(true);
        arrayLabel[14].setBackground(new Color(255, 255, 255));
        arrayLabel[14].setBounds(520, 70, 110, 100);

        arrayLabel[15] = new JLabel();
        arrayLabel[15].setOpaque(true);
        arrayLabel[15].setBackground(new Color(255, 255, 255));
        arrayLabel[15].setBounds(640, 70, 110, 100);

        arrayLabel[16] = new JLabel(imagenEntidades[0]);// candle
        arrayLabel[16].setOpaque(true);
        arrayLabel[16].setBackground(Color.black);
        arrayLabel[16].setBounds(523, 73, 104, 94);
        arrayLabel[16].addMouseListener(this);

        arrayLabel[17] = new JLabel(imagenEntidades[1]);// bomb
        arrayLabel[17].setOpaque(true);
        arrayLabel[17].setBackground(Color.black);
        arrayLabel[17].setBounds(643, 73, 104, 94);
        arrayLabel[17].addMouseListener(this);

        canS = Integer.toString(candle);
        bombS = Integer.toString(bomb);

        arrayLabel[20] = new JLabel("          " + canS);// cantidad candle
        arrayLabel[20].setOpaque(true);
        arrayLabel[20].setBounds(520, 170, 110, 20);
        arrayLabel[20].setForeground(Color.white);
        arrayLabel[20].setFont(new Font("Arial Black", 0, 15));
        arrayLabel[20].setForeground(new Color(0, 0, 0));

        arrayLabel[21] = new JLabel("          " + bombS);// cantidad bombs
        arrayLabel[21].setOpaque(true);
        arrayLabel[21].setBounds(640, 170, 110, 20);
        arrayLabel[21].setForeground(Color.white);
        arrayLabel[21].setFont(new Font("Arial Black", 0, 15));
        arrayLabel[21].setForeground(new Color(0, 0, 0));

        arrayLabel[22] = new JLabel();// barras salida
        arrayLabel[22].setOpaque(true);
        arrayLabel[22].setBackground(new Color(234, 100, 86));
        arrayLabel[22].setBounds(5, 295, 25, 5);

        arrayLabel[23] = new JLabel();// barras salida
        arrayLabel[23].setOpaque(true);
        arrayLabel[23].setBackground(new Color(234, 100, 86));
        arrayLabel[23].setBounds(5, 365, 26, 5);

        arrayLabel[24] = new JLabel(imagenEntidades[8]);// link
        arrayLabel[24].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
        add(arrayLabel[24]);

        arrayLabel[25] = new JLabel(imagenEntidades[9]);// link2
        arrayLabel[25].setBounds(-100, 0, 80, 80);
        add(arrayLabel[25]);

        arrayLabel[26] = new JLabel(imagenEntidades[10]);// link3
        arrayLabel[26].setBounds(-100, 0, 80, 80);
        add(arrayLabel[26]);

        imagen[4] = new ImageIcon("images/fog.png");// niebla
        arrayLabel[27] = new JLabel(imagen[4]);
        arrayLabel[27].setBounds(2000, 0, 1500, 870);

        imagen[5] = new ImageIcon("images/fog2.png");// niebla 2
        arrayLabel[38] = new JLabel(imagen[5]);
        arrayLabel[38].setBounds(2000, 0, 1500, 870);

        arrayLabel[28] = new JLabel(imagenEntidades[0]);// candle 2
        arrayLabel[28].setBounds(-200, 0, 80, 80);
        add(arrayLabel[28]);

        arrayLabel[29] = new JLabel(imagenEntidades[1]);// bomb 2
        arrayLabel[29].setBounds(-200, 0, 80, 80);
        add(arrayLabel[29]);

        arrayLabel[30] = new JLabel(imagenEntidades[2]);// heart 2
        arrayLabel[30].setBounds(-200, 0, 80, 80);
        add(arrayLabel[30]);

        arrayLabel[31] = new JLabel("OBTUVISTE");
        arrayLabel[31].setFont(new Font("Copperplate Gothic Bold", 0, 12));
        arrayLabel[31].setForeground(Color.black);
        arrayLabel[31].setBounds(-200, 0, 118, 50);
        add(arrayLabel[31]);

        arrayLabel[34] = new JLabel("PREGUNTA");
        arrayLabel[34].setFont(new Font("Copperplate Gothic Bold", 0, 12));
        arrayLabel[34].setForeground(Color.black);
        // arrayLabel[34].setBounds(595,200,100,20);
        arrayLabel[34].setBounds(-595, 200, 100, 20);
        add(arrayLabel[34]);

        arrayLabel[33] = new JLabel();// barra negra
        arrayLabel[33].setOpaque(true);
        arrayLabel[33].setBackground(Color.black);
        // arrayLabel[33].setBounds(520,265,230,10);
        arrayLabel[33].setBounds(-520, 265, 230, 10);
        add(arrayLabel[33]);

        arrayLabel[32] = new JLabel();// cuadro de preguntas
        arrayLabel[32].setOpaque(true);
        arrayLabel[32].setBackground(Color.white);
        // arrayLabel[32].setBounds(520,200,230,190);
        arrayLabel[32].setBounds(-520, 200, 230, 190);
        add(arrayLabel[32]);

        arrayLabel[35] = new JLabel(imagenEntidades[7]);// tomb
        arrayLabel[35].setBounds(-200, 0, 80, 80);
        add(arrayLabel[35]);

        arrayLabel[36] = new JLabel(" CORRECTO");
        arrayLabel[36].setFont(new Font("Copperplate Gothic Bold", 0, 15));
        arrayLabel[36].setForeground(Color.RED);
        arrayLabel[36].setOpaque(true);
        arrayLabel[36].setBackground(Color.white);
        arrayLabel[36].setBounds(-200, 0, 130, 20);
        add(arrayLabel[36]);

        arrayLabel[37] = new JLabel(" INCORRECTO");
        arrayLabel[37].setFont(new Font("Copperplate Gothic Bold", 0, 15));
        arrayLabel[37].setForeground(Color.RED);
        arrayLabel[37].setOpaque(true);
        arrayLabel[37].setBackground(Color.white);
        arrayLabel[37].setBounds(-200, 0, 130, 20);
        add(arrayLabel[37]);

        arrayLabel[39] = new JLabel(" FALLASTE");
        arrayLabel[39].setFont(new Font("Copperplate Gothic Bold", 0, 30));
        arrayLabel[39].setForeground(Color.RED);
        arrayLabel[39].setOpaque(true);
        arrayLabel[39].setBackground(Color.black);
        arrayLabel[39].setBounds(-2000, 0, 195, 30);
        add(arrayLabel[39]);

        arrayLabel[40] = new JLabel(" GANASTE");
        arrayLabel[40].setFont(new Font("Copperplate Gothic Bold", 0, 30));
        arrayLabel[40].setForeground(Color.green);
        arrayLabel[40].setOpaque(true);
        arrayLabel[40].setBackground(Color.black);
        arrayLabel[40].setBounds(-2000, 0, 195, 30);
        add(arrayLabel[40]);

        add(arrayLabel[21]);
        add(arrayLabel[20]);
        add(arrayLabel[17]);
        add(arrayLabel[16]);
        add(arrayLabel[15]);
        add(arrayLabel[14]);
        add(arrayLabel[10]);
        add(arrayLabel[9]);// boton iniciar
        add(arrayLabel[12]);
        add(arrayLabel[8]);// regresar
        add(arrayLabel[11]);
        add(arrayLabel[7]);// L facil
        add(arrayLabel[13]);
        add(arrayLabel[3]);
        add(arrayLabel[2]);
        add(arrayLabel[5]);
        add(arrayLabel[4]);
        add(arrayLabel[1]);
        add(arrayLabel[6]);// fondo vida
        add(arrayLabel[27]);// fog
        add(arrayLabel[38]);// fog2
        add(arrayLabel[22]);// barra roja
        add(arrayLabel[23]);
        DibujaTileEntidades();
        add(arrayLabel[0]);// backgroud

    }

    public void Tiles() {// pone las imagenes en los Labels adecuados

        imagenTile[0] = new ImageIcon("images/tile0.PNG");
        imagenTile[1] = new ImageIcon("images/tile1_1.PNG");
        imagenTile[2] = new ImageIcon("images/tile1_2.PNG");
        imagenTile[3] = new ImageIcon("images/tile1_3.PNG");
        imagenTile[4] = new ImageIcon("images/tile1_4.PNG");
        imagenTile[5] = new ImageIcon("images/tile2_1.PNG");
        imagenTile[6] = new ImageIcon("images/tile2_2.PNG");
        imagenTile[7] = new ImageIcon("images/tile2_3.PNG");
        imagenTile[8] = new ImageIcon("images/tile2_4.PNG");
        imagenTile[9] = new ImageIcon("images/tile3_1.PNG");
        imagenTile[10] = new ImageIcon("images/tile3_2.PNG");
        imagenTile[11] = new ImageIcon("images/tile4_1.PNG");
        imagenTile[12] = new ImageIcon("images/tile4_2.PNG");
        imagenTile[13] = new ImageIcon("images/tile4_3.PNG");
        imagenTile[14] = new ImageIcon("images/tile4_4.PNG");

        switch (numLav) {// creacion del laberinto
            case 1:
                int tipoTile[] = { 13, 5, 10, 10, 6, 13, 9, 11, 5, 6, 4, 2, 4, 10, 2, 8, 7, 9, 7, 12, 3, 14, 12, 7 };
                AjustarTipoTile(tipoTile);
                break;
            case 2:
                int tipoTile2[] = { 12, 10, 6, 12, 1, 14, 5, 6, 9, 13, 9, 13, 9, 9, 8, 0, 3, 2, 7, 8, 10, 7, 12, 7 };
                AjustarTipoTile(tipoTile2);
                break;
            case 3:
                int tipoTile3[] = { 5, 1, 6, 5, 10, 6, 9, 9, 8, 7, 13, 9, 11, 11, 5, 10, 3, 2, 10, 10, 7, 12, 10, 7 };
                AjustarTipoTile(tipoTile3);
                break;
            default:
                System.out.println("Error en integer numLav");
        }

    }

    public void MatrizObjetoEnemigo() {// entities
        imagenEntidades[0] = new ImageIcon("images/Candle.gif");
        imagenEntidades[1] = new ImageIcon("images/Bomb.gif");
        imagenEntidades[2] = new ImageIcon("images/Heart.gif");
        imagenEntidades[3] = new ImageIcon("images/T_keese.png");
        imagenEntidades[4] = new ImageIcon("images/T_Stalfos.png");
        imagenEntidades[5] = new ImageIcon("images/T_Tektite.png");
        imagenEntidades[6] = new ImageIcon("images/T_Darknut.png");
        imagenEntidades[7] = new ImageIcon("images/T_Tomb.png");
        imagenEntidades[8] = new ImageIcon("images/Link_1.png");
        imagenEntidades[9] = new ImageIcon("images/Link_2.png");
        imagenEntidades[10] = new ImageIcon("images/Link_3.png");

        switch (numLav) {// Candle:0 Bomb:1 Hearth:2 K:3 S:4 T:5 D:6
            case 1:
                matEntities[0][0] = 4;
                matEntities[1][2] = 3;
                matEntities[1][1] = 1;
                matEntities[3][4] = 0;
                break;
            case 2:
                matEntities[0][2] = 1;
                matEntities[0][3] = 0;
                matEntities[2][1] = 4;
                matEntities[2][2] = 3;
                matEntities[3][4] = 0;
                break;
            case 3:
                matEntities[0][2] = 3;
                matEntities[1][0] = 1;
                matEntities[1][4] = 0;
                matEntities[2][1] = 0;
                matEntities[2][3] = 4;
                break;
            default:
                System.out.println("Error en integer numLav");
        }

    }

    public void AjustarTipoTile(int x[]) {
        int c = 0;
        for (j = 0; j < 4; j++) {
            for (i = 0; i < 6; i++) {
                matLabel[j][i] = new JLabel(imagenTile[x[c]]);
                matParedes[j][i] = x[c];
                c++;
            }
        }
    }

    public void DibujaTileEntidades() {

        for (j = 0; j < 4; j++) {// dibujo de tiles
            for (i = 0; i < 6; i++) {

                if (matEntities[j][i] == 0) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[0]);
                    matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 1) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[1]);
                    matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 2) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[2]);
                    matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 3) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[3]);
                    matLabelEnteties[j][i].setBounds(-1000, -1000, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 4) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[4]);
                    matLabelEnteties[j][i].setBounds(-1000, -1000, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 5) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[5]);
                    matLabelEnteties[j][i].setBounds(-1000, -1000, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 6) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[6]);
                    matLabelEnteties[j][i].setBounds(-1000, -1000, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                matLabel[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                this.add(matLabel[j][i]);
            }
        }
    }

    public void AgregarEnemigos() {

        for (j = 0; j < 4; j++) {
            for (i = 0; i < 6; i++) {
                switch (matEntities[j][i]) {
                    case 3:
                        matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                        break;
                    case 4:
                        matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                        break;
                    case 5:
                        matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                        break;
                    case 6:
                        matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                        break;
                }
            }
        }
    }

    public void InicializarMat() {

        for (j = 0; j < 4; j++) {
            for (i = 0; i < 6; i++) {
                matEntities[j][i] = -1;
            }
        }
    }

    // eventos mouse
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == arrayLabel[8]) {// regresar
            Inicio v = new Inicio();
            v.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource() == arrayLabel[9]) {// iniciar juego
            play = true;
            arrayLabel[9].setBounds(-1000, 0, 0, 0);
            arrayLabel[12].setBounds(-1000, 0, 0, 0);
            AgregarEnemigos();
            arrayLabel[27].setBounds(-690 + (80 * posX), -342 + (80 * posY), 1500, 870);
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][1]) {// boton respuesta a
            switch (numPregunta) {// revisa si es correcta en cada pregunta
                case 0:
                    Correcto(false);
                    break;
                case 1:
                    Correcto(true);
                    break;
                case 2:
                    Correcto(false);
                    break;
                case 3:
                    Correcto(true);
                    break;
                case 4:
                    Correcto(false);
                    break;
                default:
                    System.out.println("no jalo");
            }
            arrayLabel[34].setBounds(-595, 200, 100, 20);// quita cuadro de pregunta
            arrayLabel[33].setBounds(-520, 265, 230, 10);
            arrayLabel[32].setBounds(-520, 200, 230, 190);
            matLabelPreguntas[numPregunta][0].setBounds(-520, 220, 230, 40);
            matLabelPreguntas[numPregunta][1].setBounds(-520, 280, 230, 33);
            matLabelPreguntas[numPregunta][2].setBounds(-520, 317, 230, 33);
            matLabelPreguntas[numPregunta][3].setBounds(-520, 353, 230, 33);
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][2]) {// boton respuestas b
            switch (numPregunta) {// revisa si es correcta en cada pregunta
                case 0:
                    Correcto(true);
                    break;
                case 1:
                    Correcto(false);
                    break;
                case 2:
                    Correcto(true);
                    break;
                case 3:
                    Correcto(false);
                    break;
                case 4:
                    Correcto(false);
                    break;
            }
            arrayLabel[34].setBounds(-595, 200, 100, 20);// quita cuadro de pregunta
            arrayLabel[33].setBounds(-520, 265, 230, 10);
            arrayLabel[32].setBounds(-520, 200, 230, 190);
            matLabelPreguntas[numPregunta][0].setBounds(-520, 220, 230, 40);
            matLabelPreguntas[numPregunta][1].setBounds(-520, 280, 230, 33);
            matLabelPreguntas[numPregunta][2].setBounds(-520, 317, 230, 33);
            matLabelPreguntas[numPregunta][3].setBounds(-520, 353, 230, 33);
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][3]) {// botone respuesta c
            switch (numPregunta) {// revisa si es correcta en cada pregunta
                case 0:
                    Correcto(false);
                    break;
                case 1:
                    Correcto(false);
                    break;
                case 2:
                    Correcto(false);
                    break;
                case 3:
                    Correcto(false);
                    break;
                case 4:
                    Correcto(true);
                    break;
            }
            arrayLabel[34].setBounds(-595, 200, 100, 20);// quita cuadro de pregunta
            arrayLabel[33].setBounds(-520, 265, 230, 10);
            arrayLabel[32].setBounds(-520, 200, 230, 190);
            matLabelPreguntas[numPregunta][0].setBounds(-520, 220, 230, 40);
            matLabelPreguntas[numPregunta][1].setBounds(-520, 280, 230, 33);
            matLabelPreguntas[numPregunta][2].setBounds(-520, 317, 230, 33);
            matLabelPreguntas[numPregunta][3].setBounds(-520, 353, 230, 33);
        }
        if (e.getSource() == arrayLabel[16]) {// candle boton
            if (play == true && candle != 0) {
                music.Play("music/Candle.wav");
                fogTurns = 3;
                Fog(1);
                candle--;
                canS = Integer.toString(candle);
                arrayLabel[20].setText("          " + canS);

            }
        }
        if (e.getSource() == arrayLabel[17]) {// bomb buton
            if (preguntaActiva == true && bomb != 0) {
                music.Play("music/BombBlow.wav");
                play = true;
                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                MovePlayerFace(1);
                matEntities[posY][posX] = -1;
                arrayLabel[34].setBounds(-595, 200, 100, 20);// quita cuadro de pregunta
                arrayLabel[33].setBounds(-520, 265, 230, 10);
                arrayLabel[32].setBounds(-520, 200, 230, 190);
                matLabelPreguntas[numPregunta][0].setBounds(-520, 220, 230, 40);
                matLabelPreguntas[numPregunta][1].setBounds(-520, 280, 230, 33);
                matLabelPreguntas[numPregunta][2].setBounds(-520, 317, 230, 33);
                matLabelPreguntas[numPregunta][3].setBounds(-520, 353, 230, 33);
                preguntaActiva = false;
                bomb--;
                bombS = Integer.toString(bomb);
                arrayLabel[21].setText("          " + bombS);
            }

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == arrayLabel[8]) {
            arrayLabel[8].setBackground(new Color(0, 197, 255));
            music.Play("music/Rupee.wav");
        }
        if (e.getSource() == arrayLabel[9]) {
            arrayLabel[9].setBackground(new Color(200, 200, 200));
            music.Play("music/Rupee.wav");
        }
        if (e.getSource() == arrayLabel[16]) {// candle boton
            if (play == true && candle != 0) {
                arrayLabel[16].setBackground(new Color(100, 100, 100));
                music.Play("music/Rupee.wav");

            }
        }
        if (e.getSource() == arrayLabel[17]) {// bomb buton
            if (bomb != 0 && preguntaActiva == true) {
                arrayLabel[17].setBackground(new Color(100, 100, 100));
                music.Play("music/Rupee.wav");
            }
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][1]) {// botone respuestas
            matLabelPreguntas[numPregunta][1].setBackground(Color.red);
            music.Play("music/Rupee.wav");
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][2]) {// botone respuestas
            matLabelPreguntas[numPregunta][2].setBackground(Color.red);
            music.Play("music/Rupee.wav");
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][3]) {// botone respuestas
            matLabelPreguntas[numPregunta][3].setBackground(Color.red);
            music.Play("music/Rupee.wav");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == arrayLabel[8]) {
            arrayLabel[8].setBackground(new Color(0, 0, 255));
        }
        if (e.getSource() == arrayLabel[9]) {
            arrayLabel[9].setBackground(new Color(150, 150, 150));
        }
        if (e.getSource() == arrayLabel[16]) {
            arrayLabel[16].setBackground(new Color(0, 0, 0));
        }
        if (e.getSource() == arrayLabel[17]) {
            arrayLabel[17].setBackground(new Color(0, 0, 0));
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][1]) {// botone respuestas
            matLabelPreguntas[numPregunta][1].setBackground(Color.gray);
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][2]) {// botone respuestas
            matLabelPreguntas[numPregunta][2].setBackground(Color.gray);
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][3]) {// botone respuestas
            matLabelPreguntas[numPregunta][3].setBackground(Color.gray);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    // eventos teclado
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (play == true) {
            arrayLabel[31].setBounds(-200, 0, 80, 80);
            arrayLabel[31].setText("OBTUVISTE");
            arrayLabel[28].setBounds(-200, 0, 80, 80);
            arrayLabel[29].setBounds(-200, 0, 80, 80);
            arrayLabel[30].setBounds(-200, 0, 80, 80);
            arrayLabel[36].setBounds(-800, 0, 80, 80);
            arrayLabel[37].setBounds(-800, 0, 80, 80);
            switch (e.getKeyCode()) {
                case 37: // izquierda
                    switch (matParedes[posY][posX]) {
                        case 4:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 5:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 8:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 9:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 11:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 12:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 13:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        default:
                            moved = true;
                    }
                    if (moved == true) {
                        posX--;
                        if (posX == -1 && posY == 3) {
                            MovePlayerFace(3);
                            music.Play("music/Escape.wav");
                            play = false;
                            arrayLabel[27].setBounds(-6000, 0, 1500, 870);
                            arrayLabel[38].setBounds(2000, 0, 1500, 870);
                            arrayLabel[40].setBounds(290, 420, 195, 30);
                        } else {
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            switch (matEntities[posY][posX]) {
                                case -1:// no entitie
                                    MovePlayerFace(3);
                                    music.Play("music/Low.wav");
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    break;
                                case 0:// candle
                                    music.Play("music/Item.wav");
                                    matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                    arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                    arrayLabel[28].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    matEntities[posY][posX] = -1;
                                    candle++;
                                    canS = Integer.toString(candle);
                                    arrayLabel[20].setText("          " + canS);
                                    MovePlayerFace(3);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    break;
                                case 1:// bomb
                                    music.Play("music/Item.wav");
                                    matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                    arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 38, 80, 80);
                                    arrayLabel[29].setBounds(80 * posX + 25, 80 * posY - 5, 80, 80);
                                    matEntities[posY][posX] = -1;
                                    bomb++;
                                    bombS = Integer.toString(bomb);
                                    arrayLabel[21].setText("          " + bombS);
                                    MovePlayerFace(3);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    break;
                                case 2:// heart
                                    if (vida == 2) {
                                        music.Play("music/Deflect.wav");
                                        arrayLabel[31].setText("VIDA LLENA");
                                        arrayLabel[31].setBounds(80 * posX + 23, 80 * posY - 18, 90, 80);
                                        arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                        MovePlayerFace(3);
                                        if (fogTurns > 0) {
                                            Fog(1);
                                            fogTurns--;
                                        } else
                                            Fog(0);
                                    } else {
                                        music.Play("music/GetHeart.wav");
                                        matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                        Corazon(1);
                                        arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                        arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                        MovePlayerFace(3);
                                        if (fogTurns > 0) {
                                            Fog(1);
                                            fogTurns--;
                                        } else
                                            Fog(0);
                                        matEntities[posY][posX] = -1;
                                    }
                                    break;
                                case 3:// Enemies
                                case 4:
                                case 5:
                                case 6:
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    MovePlayerFace(4);
                                    music.Play("music/Enemy.wav");
                                    play = false;
                                    Preguntas();

                                    break;
                            }

                        }
                    }
                    moved = false;
                    break;

                case 38: // arriba
                    switch (matParedes[posY][posX]) {
                        case 1:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 5:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 6:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 10:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 12:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 13:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 14:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;

                        default:
                            moved = true;
                    }
                    if (moved == true) {
                        posY--;
                        moviminetos++;
                        arrayLabel[10].setText("  Movimentos: " + moviminetos);
                        switch (matEntities[posY][posX]) {
                            case -1:// no entitie
                                MovePlayerFace(1);
                                music.Play("music/Low.wav");
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 0:// candle
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                arrayLabel[28].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                matEntities[posY][posX] = -1;
                                candle++;
                                canS = Integer.toString(candle);
                                arrayLabel[20].setText("          " + canS);
                                MovePlayerFace(1);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 1:// bomb
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 38, 80, 80);
                                arrayLabel[29].setBounds(80 * posX + 25, 80 * posY - 5, 80, 80);
                                matEntities[posY][posX] = -1;
                                bomb++;
                                bombS = Integer.toString(bomb);
                                arrayLabel[21].setText("          " + bombS);
                                MovePlayerFace(1);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 2:// heart
                                if (vida == 2) {
                                    music.Play("music/Deflect.wav");
                                    arrayLabel[31].setText("VIDA LLENA");
                                    arrayLabel[31].setBounds(80 * posX + 23, 80 * posY - 18, 90, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(1);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                } else {
                                    music.Play("music/GetHeart.wav");
                                    matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                    Corazon(1);
                                    arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(1);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    matEntities[posY][posX] = -1;
                                }
                                break;
                            case 3:// Enemies
                            case 4:
                            case 5:
                            case 6:
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                MovePlayerFace(4);
                                music.Play("music/Enemy.wav");
                                play = false;
                                Preguntas();

                                break;
                        }
                    }
                    moved = false;
                    break;

                case 39: // derecha
                    switch (matParedes[posY][posX]) {
                        case 2:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 6:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 7:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 9:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 11:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 13:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 14:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;

                        default:
                            moved = true;
                    }
                    if (moved == true) {
                        posX++;
                        moviminetos++;
                        arrayLabel[10].setText("  Movimentos: " + moviminetos);
                        switch (matEntities[posY][posX]) {
                            case -1:// no entitie
                                MovePlayerFace(2);
                                music.Play("music/Low.wav");
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 0:// candle
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                arrayLabel[28].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                matEntities[posY][posX] = -1;
                                candle++;
                                canS = Integer.toString(candle);
                                arrayLabel[20].setText("          " + canS);
                                MovePlayerFace(2);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 1:// bomb
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 38, 80, 80);
                                arrayLabel[29].setBounds(80 * posX + 25, 80 * posY - 5, 80, 80);
                                matEntities[posY][posX] = -1;
                                bomb++;
                                bombS = Integer.toString(bomb);
                                arrayLabel[21].setText("          " + bombS);
                                MovePlayerFace(2);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 2:// heart
                                if (vida == 2) {
                                    music.Play("music/Deflect.wav");
                                    arrayLabel[31].setText("VIDA LLENA");
                                    arrayLabel[31].setBounds(80 * posX + 23, 80 * posY - 18, 90, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(2);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                } else {
                                    music.Play("music/GetHeart.wav");
                                    matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                    Corazon(1);
                                    arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(2);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    matEntities[posY][posX] = -1;
                                }
                                break;
                            case 3:// Enemies
                            case 4:
                            case 5:
                            case 6:
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                MovePlayerFace(4);
                                music.Play("music/Enemy.wav");
                                play = false;
                                Preguntas();

                                break;
                        }
                    }
                    moved = false;
                    break;

                case 40: // abajo
                    switch (matParedes[posY][posX]) {
                        case 3:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 7:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 8:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 10:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 12:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 11:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 14:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;

                        default:
                            moved = true;
                    }
                    if (moved == true) {
                        posY++;
                        moviminetos++;
                        arrayLabel[10].setText("  Movimentos: " + moviminetos);
                        switch (matEntities[posY][posX]) {
                            case -1:// no entitie
                                MovePlayerFace(1);
                                music.Play("music/Low.wav");
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 0:// candle
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                arrayLabel[28].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                matEntities[posY][posX] = -1;
                                candle++;
                                canS = Integer.toString(candle);
                                arrayLabel[20].setText("          " + canS);
                                MovePlayerFace(1);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 1:// bomb
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 38, 80, 80);
                                arrayLabel[29].setBounds(80 * posX + 25, 80 * posY - 5, 80, 80);
                                matEntities[posY][posX] = -1;
                                bomb++;
                                bombS = Integer.toString(bomb);
                                arrayLabel[21].setText("          " + bombS);
                                MovePlayerFace(1);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 2:// heart
                                if (vida == 2) {
                                    music.Play("music/Deflect.wav");
                                    arrayLabel[31].setText("VIDA LLENA");
                                    arrayLabel[31].setBounds(80 * posX + 23, 80 * posY - 18, 90, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(1);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                } else {
                                    music.Play("music/GetHeart.wav");
                                    matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                    Corazon(1);
                                    arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(1);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    matEntities[posY][posX] = -1;
                                }
                                break;
                            case 3:// Enemies
                            case 4:
                            case 5:
                            case 6:
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                MovePlayerFace(4);
                                music.Play("music/Enemy.wav");
                                play = false;
                                Preguntas();

                                break;
                        }
                    }
                    moved = false;
                    break;
            }
        }
    }

    public void MovePlayerFace(int a) {
        switch (a) {
            case 1:// ariba, abajo
                arrayLabel[24].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                arrayLabel[25].setBounds(-200, 0, 80, 80);
                arrayLabel[26].setBounds(-200, 0, 80, 80);
                break;
            case 2:// derecha
                arrayLabel[24].setBounds(-200, 0, 80, 80);
                arrayLabel[25].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                arrayLabel[26].setBounds(-200, 0, 80, 80);
                break;
            case 3:// izquierda
                arrayLabel[24].setBounds(-200, 0, 80, 80);
                arrayLabel[25].setBounds(-200, 0, 80, 80);
                arrayLabel[26].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                break;
            case 4:// quitar todos
                arrayLabel[24].setBounds(-200, 0, 80, 80);
                arrayLabel[25].setBounds(-200, 0, 80, 80);
                arrayLabel[26].setBounds(-200, 0, 80, 80);
                break;

        }
    }

    public void LabelsPreguntas() {
        int c = 0;

        imagenPregunta[0] = new ImageIcon("images/preguntas/E1.PNG");
        imagenPregunta[1] = new ImageIcon("images/preguntas/E1_1.PNG");
        imagenPregunta[2] = new ImageIcon("images/preguntas/E1_2.PNG");
        imagenPregunta[3] = new ImageIcon("images/preguntas/E1_3.PNG");
        imagenPregunta[4] = new ImageIcon("images/preguntas/E2.PNG");
        imagenPregunta[5] = new ImageIcon("images/preguntas/E2_1.PNG");
        imagenPregunta[6] = new ImageIcon("images/preguntas/E2_2.PNG");
        imagenPregunta[7] = new ImageIcon("images/preguntas/E2_3.PNG");
        imagenPregunta[8] = new ImageIcon("images/preguntas/E3.PNG");
        imagenPregunta[9] = new ImageIcon("images/preguntas/E3_1.PNG");
        imagenPregunta[10] = new ImageIcon("images/preguntas/E3_2.PNG");
        imagenPregunta[11] = new ImageIcon("images/preguntas/E3_3.PNG");
        imagenPregunta[12] = new ImageIcon("images/preguntas/E4.PNG");
        imagenPregunta[13] = new ImageIcon("images/preguntas/E4_1.PNG");
        imagenPregunta[14] = new ImageIcon("images/preguntas/E4_2.PNG");
        imagenPregunta[15] = new ImageIcon("images/preguntas/E4_3.PNG");
        imagenPregunta[16] = new ImageIcon("images/preguntas/E5.PNG");
        imagenPregunta[17] = new ImageIcon("images/preguntas/E5_1.PNG");
        imagenPregunta[18] = new ImageIcon("images/preguntas/E5_2.PNG");
        imagenPregunta[19] = new ImageIcon("images/preguntas/E5_3.PNG");

        for (j = 0; j < 5; j++) {
            for (i = 0; i < 4; i++) {
                matLabelPreguntas[j][i] = new JLabel(imagenPregunta[c]);
                this.add(matLabelPreguntas[j][i]);
                c++;
            }
        }
    }

    public void Preguntas() {
        int c = 0, a, b;
        preguntaActiva = true;

        for (i = 0; i < 5; i++) {// revisa que todas no se allan preguntado
            if (pregunta[i] == 0)
                c++;
        }
        if (c == 5) {
            for (i = 0; i < 5; i++) {
                pregunta[i] = 1;
            }
        }
        c = 0;
        do {// consigue una pregunta no usada anteriormente
            a = rand.nextInt(5);
            // System.out.println(a+" ran");
            b = pregunta[a];
            // System.out.println(b+" libre");
            // System.out.println(c+" contador");
            // c++;
        } while (b == 0);

        pregunta[a] = 0;

        arrayLabel[34].setBounds(595, 200, 100, 20);// cuadro de pregunta
        arrayLabel[33].setBounds(520, 265, 230, 10);
        arrayLabel[32].setBounds(520, 200, 230, 190);

        matLabelPreguntas[a][0].setBounds(520, 220, 230, 40);

        matLabelPreguntas[a][1].setBounds(520, 280, 230, 33);
        matLabelPreguntas[a][1].setOpaque(true);
        matLabelPreguntas[a][1].setBackground(Color.gray);
        matLabelPreguntas[a][1].addMouseListener(this);

        matLabelPreguntas[a][2].setBounds(520, 317, 230, 33);
        matLabelPreguntas[a][2].setOpaque(true);
        matLabelPreguntas[a][2].setBackground(Color.gray);
        matLabelPreguntas[a][2].addMouseListener(this);

        matLabelPreguntas[a][3].setBounds(520, 353, 230, 33);
        matLabelPreguntas[a][3].setOpaque(true);
        matLabelPreguntas[a][3].setBackground(Color.gray);
        matLabelPreguntas[a][3].addMouseListener(this);

        numPregunta = a;
    }

    public void Correcto(boolean acierto) {
        if (acierto == true) {
            music.Play("music/EnemyKill.wav");
            arrayLabel[36].setBounds(80 * posX + 10, 80 * posY + 10, 110, 20);
            play = true;
            MovePlayerFace(1);
        }
        if (acierto == false) {
            arrayLabel[37].setBounds(80 * posX + 10, 80 * posY + 10, 125, 20);
            Corazon(-1);
            if (vida == 1) {
                music.Play("music/wrong.wav");
                play = true;
                MovePlayerFace(1);
            }
            if (vida == 0) {
                GameOver();
            }
        }
        matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
        matEntities[posY][posX] = -1;
        preguntaActiva = false;
    }

    public void Fog(int a) {
        if (a == 0) {// fog 1
            arrayLabel[27].setBounds(-690 + (80 * posX), -342 + (80 * posY), 1500, 870);
            arrayLabel[38].setBounds(-60000, 0, 1500, 870);
        }
        if (a == 1) {// fog 2
            arrayLabel[27].setBounds(-60000, 0, 1500, 870);
            arrayLabel[38].setBounds(-690 + (80 * posX), -342 + (80 * posY), 1500, 870);
        }
    }

    public void GameOver() {
        play = false;
        music.Play("music/Die.wav");
        MovePlayerFace(4);
        arrayLabel[27].setBounds(2000, 0, 1500, 870);
        arrayLabel[38].setBounds(2000, 0, 1500, 870);
        arrayLabel[35].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
        arrayLabel[37].setBounds(-200, 0, 130, 20);
        arrayLabel[36].setBounds(-200, 0, 130, 20);
        arrayLabel[39].setBounds(290, 420, 195, 30);
    }

    public void Corazon(int a) {
        vidaAntigua = vida;
        vida = vida + a;
        if (vida == 1 && vidaAntigua == 2) {
            arrayLabel[3].setBounds(0, -100, 25, 28);
        }
        if (vida == 0 && vidaAntigua == 1) {
            arrayLabel[2].setBounds(0, -100, 25, 28);
        }
        if (vida == 2 && vidaAntigua == 1) {
            arrayLabel[3].setBounds(105, 5, 25, 28);
        }
        /*
         * if(vida==1 && vidaAntigua==0){
         * arrayLabel[2].setBounds(70,5,25,28);
         * }
         */
    }
}

class Nivel2 extends JFrame implements MouseListener, KeyListener {
    public static int numLav;
    private int i, j, candle = 0, bomb = 0, posX = 9, posY = 0, vida = 2, vidaAntigua, moviminetos = 0, numPregunta,
            fogTurns;
    private int[] pregunta = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
    private int[][] matEntities = new int[6][10];
    private int[][] matParedes = new int[6][10];
    private String canS, bombS;
    private boolean play = false, moved = false, preguntaActiva = false;
    private JLabel[] arrayLabel = new JLabel[50];
    private JLabel[][] matLabelPreguntas = new JLabel[10][4];
    private JLabel[][] matLabel = new JLabel[6][10];
    private JLabel[][] matLabelEnteties = new JLabel[6][10];
    private JLabel[][] matLabelEncubrir = new JLabel[6][10];
    private ImageIcon[] imagen = new ImageIcon[10];
    private ImageIcon[] imagenTile = new ImageIcon[20];
    private ImageIcon[] imagenEntidades = new ImageIcon[20];
    private ImageIcon[] imagenPregunta = new ImageIcon[40];
    private Sound music = new Sound();
    private Random rand = new Random();

    public Nivel2() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Nivel 2");
        setSize(1100, 660);// para imagenes tiene tantos menos pixeles en el eje: X:-16px Y:-39px pero si
                           // empiezan en (0.0)
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(this);
        setIconImage(new ImageIcon(getClass().getResource("images/KeyIcon.png")).getImage());

        if (numLav > 3)
            numLav = 1;

        getContentPane().setBackground(new Color(50, 80, 100));

        InicializarMat();// inicializa matriz en 0
        MatrizObjetoEnemigo();// inseta las entidades en la posicion adecuada
        Tiles();// dibuja el laverinto
        LabelsPreguntas();

        imagen[1] = new ImageIcon("images/bkg2.PNG");
        arrayLabel[0] = new JLabel(imagen[1]);
        arrayLabel[0].setBounds(0, 0, 767, 529);

        arrayLabel[41] = new JLabel(imagen[1]);
        arrayLabel[41].setBounds(767, 0, 767, 529);

        arrayLabel[42] = new JLabel(imagen[1]);
        arrayLabel[42].setBounds(0, 529, 767, 529);

        arrayLabel[43] = new JLabel(imagen[1]);
        arrayLabel[43].setBounds(767, 529, 767, 529);

        arrayLabel[1] = new JLabel("VIDA:");
        arrayLabel[1].setBounds(10, 10, 50, 17);
        arrayLabel[1].setFont(new Font("Arial Black", 0, 15));
        arrayLabel[1].setForeground(new Color(255, 255, 255));

        imagen[2] = new ImageIcon("images/Life1.gif");
        imagen[3] = new ImageIcon("images/Life2.gif");

        arrayLabel[2] = new JLabel(imagen[2]);// heart rojo
        arrayLabel[2].setBounds(70, 5, 25, 28);

        arrayLabel[3] = new JLabel(imagen[2]);// heart rojo
        arrayLabel[3].setBounds(105, 5, 25, 28);

        arrayLabel[4] = new JLabel(imagen[3]);// heart empty
        arrayLabel[4].setBounds(70, 5, 25, 28);

        arrayLabel[5] = new JLabel(imagen[3]);// heart empty
        arrayLabel[5].setBounds(105, 5, 25, 28);

        arrayLabel[6] = new JLabel();
        arrayLabel[6].setOpaque(true);
        arrayLabel[6].setBackground(new Color(0, 0, 0));
        arrayLabel[6].setBounds(5, 2, 140, 34);

        arrayLabel[13] = new JLabel("NORMAL");
        arrayLabel[13].setOpaque(true);
        arrayLabel[13].setBounds(467, 4, 178, 38);
        arrayLabel[13].setFont(new Font("Copperplate Gothic Bold", 0, 33));
        arrayLabel[13].setForeground(Color.black);
        arrayLabel[13].setBackground(new Color(255, 0, 0));

        arrayLabel[7] = new JLabel("NORMAL");
        arrayLabel[7].setBounds(470, 4, 178, 38);
        arrayLabel[7].setFont(new Font("Copperplate Gothic Bold", 0, 33));
        arrayLabel[7].setForeground(new Color(255, 255, 255));

        arrayLabel[11] = new JLabel();
        arrayLabel[11].setOpaque(true);
        arrayLabel[11].setBackground(new Color(255, 255, 255));
        arrayLabel[11].setBounds(597, 552, 96, 44);

        arrayLabel[8] = new JLabel("  Regresar");
        arrayLabel[8].setOpaque(true);
        arrayLabel[8].setBounds(600, 555, 90, 38);
        arrayLabel[8].setFont(new Font("Agency FB", 0, 26));
        arrayLabel[8].setForeground(new Color(255, 255, 255));
        arrayLabel[8].setBackground(new Color(0, 0, 255));
        arrayLabel[8].addMouseListener(this);

        arrayLabel[12] = new JLabel();
        arrayLabel[12].setOpaque(true);
        arrayLabel[12].setBackground(new Color(255, 255, 255));
        arrayLabel[12].setBounds(327, 552, 98, 44);

        arrayLabel[9] = new JLabel("  Iniciar");
        arrayLabel[9].setOpaque(true);
        arrayLabel[9].setBounds(330, 555, 92, 38);
        arrayLabel[9].setFont(new Font("Arial", 1, 23));
        arrayLabel[9].setForeground(new Color(255, 255, 255));
        arrayLabel[9].setBackground(new Color(150, 150, 150));
        arrayLabel[9].addMouseListener(this);

        arrayLabel[10] = new JLabel("  Movimentos: " + moviminetos);
        arrayLabel[10].setOpaque(true);
        arrayLabel[10].setBounds(30, 555, 130, 38);
        arrayLabel[10].setFont(new Font("Agency FB", 0, 23));
        arrayLabel[10].setForeground(Color.white);
        arrayLabel[10].setBackground(Color.black);

        arrayLabel[14] = new JLabel();
        arrayLabel[14].setOpaque(true);
        arrayLabel[14].setBackground(new Color(255, 255, 255));
        arrayLabel[14].setBounds(840, 70, 110, 100);

        arrayLabel[15] = new JLabel();
        arrayLabel[15].setOpaque(true);
        arrayLabel[15].setBackground(new Color(255, 255, 255));
        arrayLabel[15].setBounds(960, 70, 110, 100);

        arrayLabel[16] = new JLabel(imagenEntidades[0]);// candle
        arrayLabel[16].setOpaque(true);
        arrayLabel[16].setBackground(Color.black);
        arrayLabel[16].setBounds(843, 73, 104, 94);
        arrayLabel[16].addMouseListener(this);

        arrayLabel[17] = new JLabel(imagenEntidades[1]);// bomb
        arrayLabel[17].setOpaque(true);
        arrayLabel[17].setBackground(Color.black);
        arrayLabel[17].setBounds(963, 73, 104, 94);
        arrayLabel[17].addMouseListener(this);

        canS = Integer.toString(candle);
        bombS = Integer.toString(bomb);

        arrayLabel[20] = new JLabel("          " + canS);// cantidad candle
        arrayLabel[20].setOpaque(true);
        arrayLabel[20].setBounds(840, 170, 110, 20);
        arrayLabel[20].setForeground(Color.white);
        arrayLabel[20].setFont(new Font("Arial Black", 0, 15));
        arrayLabel[20].setForeground(new Color(0, 0, 0));

        arrayLabel[21] = new JLabel("          " + bombS);// cantidad bombs
        arrayLabel[21].setOpaque(true);
        arrayLabel[21].setBounds(960, 170, 110, 20);
        arrayLabel[21].setForeground(Color.white);
        arrayLabel[21].setFont(new Font("Arial Black", 0, 15));
        arrayLabel[21].setForeground(new Color(0, 0, 0));

        arrayLabel[22] = new JLabel();// barras salida
        arrayLabel[22].setOpaque(true);
        arrayLabel[22].setBackground(new Color(234, 100, 86));
        arrayLabel[22].setBounds(5, 455, 25, 5);

        arrayLabel[23] = new JLabel();// barras salida
        arrayLabel[23].setOpaque(true);
        arrayLabel[23].setBackground(new Color(234, 100, 86));
        arrayLabel[23].setBounds(5, 525, 26, 5);

        arrayLabel[24] = new JLabel(imagenEntidades[8]);// link
        arrayLabel[24].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
        add(arrayLabel[24]);

        arrayLabel[25] = new JLabel(imagenEntidades[9]);// link2
        arrayLabel[25].setBounds(-100, 0, 80, 80);
        add(arrayLabel[25]);

        arrayLabel[26] = new JLabel(imagenEntidades[10]);// link3
        arrayLabel[26].setBounds(-100, 0, 80, 80);
        add(arrayLabel[26]);

        imagen[4] = new ImageIcon("images/fog.png");// niebla
        arrayLabel[27] = new JLabel(imagen[4]);
        arrayLabel[27].setBounds(2000, 0, 1500, 870);

        imagen[5] = new ImageIcon("images/fog2.png");// niebla 2
        arrayLabel[38] = new JLabel(imagen[5]);
        arrayLabel[38].setBounds(2000, 0, 1500, 870);

        imagen[6] = new ImageIcon("images/fog3.png");// niebla 3
        arrayLabel[44] = new JLabel(imagen[6]);
        arrayLabel[44].setBounds(5000, 0, 1500, 870);

        arrayLabel[28] = new JLabel(imagenEntidades[0]);// candle 2
        arrayLabel[28].setBounds(-200, 0, 80, 80);
        add(arrayLabel[28]);

        arrayLabel[29] = new JLabel(imagenEntidades[1]);// bomb 2
        arrayLabel[29].setBounds(-200, 0, 80, 80);
        add(arrayLabel[29]);

        arrayLabel[30] = new JLabel(imagenEntidades[2]);// heart 2
        arrayLabel[30].setBounds(-200, 0, 80, 80);
        add(arrayLabel[30]);

        arrayLabel[31] = new JLabel("OBTUVISTE");
        arrayLabel[31].setFont(new Font("Copperplate Gothic Bold", 0, 12));
        arrayLabel[31].setForeground(Color.black);
        arrayLabel[31].setBounds(-200, 0, 118, 50);
        add(arrayLabel[31]);

        arrayLabel[34] = new JLabel("PREGUNTA");
        arrayLabel[34].setFont(new Font("Copperplate Gothic Bold", 0, 12));
        arrayLabel[34].setForeground(Color.black);
        // arrayLabel[34].setBounds(595,200,100,20);
        arrayLabel[34].setBounds(-595, 200, 100, 20);
        add(arrayLabel[34]);

        arrayLabel[33] = new JLabel();// barra negra
        arrayLabel[33].setOpaque(true);
        arrayLabel[33].setBackground(Color.black);
        // arrayLabel[33].setBounds(520,265,230,10);
        arrayLabel[33].setBounds(-520, 265, 230, 10);
        add(arrayLabel[33]);

        arrayLabel[32] = new JLabel();// cuadro de preguntas
        arrayLabel[32].setOpaque(true);
        arrayLabel[32].setBackground(Color.white);
        arrayLabel[32].setBounds(-520, 200, 230, 190);
        add(arrayLabel[32]);

        arrayLabel[35] = new JLabel(imagenEntidades[7]);// tomb
        arrayLabel[35].setBounds(-200, 0, 80, 80);
        add(arrayLabel[35]);

        arrayLabel[36] = new JLabel(" CORRECTO");
        arrayLabel[36].setFont(new Font("Copperplate Gothic Bold", 0, 15));
        arrayLabel[36].setForeground(Color.RED);
        arrayLabel[36].setOpaque(true);
        arrayLabel[36].setBackground(Color.white);
        arrayLabel[36].setBounds(-200, 0, 130, 20);
        add(arrayLabel[36]);

        arrayLabel[37] = new JLabel(" INCORRECTO");
        arrayLabel[37].setFont(new Font("Copperplate Gothic Bold", 0, 15));
        arrayLabel[37].setForeground(Color.RED);
        arrayLabel[37].setOpaque(true);
        arrayLabel[37].setBackground(Color.white);
        arrayLabel[37].setBounds(-200, 0, 130, 20);
        add(arrayLabel[37]);

        arrayLabel[39] = new JLabel(" FALLASTE");
        arrayLabel[39].setFont(new Font("Copperplate Gothic Bold", 0, 30));
        arrayLabel[39].setForeground(Color.RED);
        arrayLabel[39].setOpaque(true);
        arrayLabel[39].setBackground(Color.black);
        arrayLabel[39].setBounds(-2000, 0, 195, 30);
        add(arrayLabel[39]);

        arrayLabel[40] = new JLabel(" GANASTE");
        arrayLabel[40].setFont(new Font("Copperplate Gothic Bold", 0, 30));
        arrayLabel[40].setForeground(Color.green);
        arrayLabel[40].setOpaque(true);
        arrayLabel[40].setBackground(Color.black);
        arrayLabel[40].setBounds(-2000, 0, 195, 30);

        add(arrayLabel[40]);
        add(arrayLabel[21]);
        add(arrayLabel[20]);
        add(arrayLabel[17]);
        add(arrayLabel[16]);
        add(arrayLabel[15]);
        add(arrayLabel[14]);
        add(arrayLabel[10]);
        add(arrayLabel[9]);// boton iniciar
        add(arrayLabel[12]);
        add(arrayLabel[8]);// regresar
        add(arrayLabel[11]);
        add(arrayLabel[7]);// L facil
        add(arrayLabel[13]);
        add(arrayLabel[3]);
        add(arrayLabel[2]);
        add(arrayLabel[5]);
        add(arrayLabel[4]);
        add(arrayLabel[1]);
        add(arrayLabel[6]);// fondo vida
        add(arrayLabel[27]);// fog
        add(arrayLabel[38]);// fog2
        add(arrayLabel[44]);// fog3
        add(arrayLabel[22]);// barra roja
        add(arrayLabel[23]);
        // DibujaTileEncubrir();
        DibujaTileEntidades();
        add(arrayLabel[0]);// backgroud
        add(arrayLabel[41]);
        add(arrayLabel[42]);
        add(arrayLabel[43]);

    }

    public void Tiles() {// pone las imagenes en los Labels adecuados

        imagenTile[0] = new ImageIcon("images/tile0.PNG");
        imagenTile[1] = new ImageIcon("images/tile1_1.PNG");
        imagenTile[2] = new ImageIcon("images/tile1_2.PNG");
        imagenTile[3] = new ImageIcon("images/tile1_3.PNG");
        imagenTile[4] = new ImageIcon("images/tile1_4.PNG");
        imagenTile[5] = new ImageIcon("images/tile2_1.PNG");
        imagenTile[6] = new ImageIcon("images/tile2_2.PNG");
        imagenTile[7] = new ImageIcon("images/tile2_3.PNG");
        imagenTile[8] = new ImageIcon("images/tile2_4.PNG");
        imagenTile[9] = new ImageIcon("images/tile3_1.PNG");
        imagenTile[10] = new ImageIcon("images/tile3_2.PNG");
        imagenTile[11] = new ImageIcon("images/tile4_1.PNG");
        imagenTile[12] = new ImageIcon("images/tile4_2.PNG");
        imagenTile[13] = new ImageIcon("images/tile4_3.PNG");
        imagenTile[14] = new ImageIcon("images/tile4_4.PNG");

        switch (numLav) {// creacion del laberinto
            case 1:
                int tipoTile[] = { 12, 10, 6, 5, 10, 14, 12, 1, 6, 13, 5, 6, 9, 9, 5, 10, 10, 2, 8, 7, 9, 9, 8, 3, 2,
                        12, 6, 9, 5, 6, 9, 4, 10, 1, 7, 12, 3, 0, 7, 9, 9, 9, 13, 11, 5, 1, 14, 9, 5, 7, 7, 8, 3, 10, 7,
                        11, 12, 7, 8, 14 };
                AjustarTipoTile(tipoTile);
                break;
            case 2:
                int tipoTile2[] = { 5, 10, 10, 6, 13, 5, 10, 14, 13, 13, 9, 12, 6, 8, 2, 9, 5, 10, 3, 2, 4, 10, 0, 6, 8,
                        7, 9, 5, 6, 9, 9, 13, 9, 4, 1, 1, 0, 2, 8, 7, 8, 7, 8, 7, 9, 9, 11, 8, 6, 13, 10, 10, 10, 10, 7,
                        11, 12, 10, 3, 7 };
                AjustarTipoTile(tipoTile2);
                break;
            case 3:
                int tipoTile3[] = { 12, 10, 6, 12, 1, 14, 5, 10, 1, 14, 5, 6, 4, 10, 2, 13, 9, 13, 8, 6, 11, 4, 3, 14,
                        4, 3, 7, 4, 10, 7, 5, 7, 5, 1, 7, 12, 10, 3, 1, 6, 9, 12, 2, 4, 10, 14, 5, 6, 9, 9, 3, 10, 7, 8,
                        10, 14, 8, 3, 3, 7 };
                AjustarTipoTile(tipoTile3);
                break;
            default:
                System.out.println("Error en integer numLav");
        }

    }

    public void MatrizObjetoEnemigo() {// entities
        imagenEntidades[0] = new ImageIcon("images/Candle.gif");
        imagenEntidades[1] = new ImageIcon("images/Bomb.gif");
        imagenEntidades[2] = new ImageIcon("images/Heart.gif");
        imagenEntidades[3] = new ImageIcon("images/T_keese.png");
        imagenEntidades[4] = new ImageIcon("images/T_Stalfos.png");
        imagenEntidades[5] = new ImageIcon("images/T_Tektite.png");
        imagenEntidades[6] = new ImageIcon("images/T_Darknut.png");
        imagenEntidades[7] = new ImageIcon("images/T_Tomb.png");
        imagenEntidades[8] = new ImageIcon("images/Link_1.png");
        imagenEntidades[9] = new ImageIcon("images/Link_2.png");
        imagenEntidades[10] = new ImageIcon("images/Link_3.png");

        switch (numLav) {// Candle:0 Bomb:1 Heart:2 K:3 S:4 T:5 D:6
            case 1:
                matEntities[0][0] = 0;
                matEntities[0][5] = 2;
                matEntities[0][6] = 0;
                matEntities[2][4] = 5;
                matEntities[2][7] = 5;
                matEntities[3][0] = 6;
                matEntities[4][2] = 1;
                matEntities[5][1] = 6;
                matEntities[5][6] = 0;
                matEntities[5][5] = 2;
                break;
            case 2:
                matEntities[0][2] = 6;
                matEntities[0][7] = 1;
                matEntities[1][1] = 0;
                matEntities[2][7] = 5;
                matEntities[3][1] = 0;
                matEntities[4][9] = 1;
                matEntities[5][3] = 6;
                matEntities[5][5] = 2;
                matEntities[3][3] = 6;
                break;
            case 3:
                matEntities[0][3] = 1;
                matEntities[2][0] = 2;
                matEntities[2][1] = 5;
                matEntities[2][3] = 0;
                matEntities[2][7] = 6;
                matEntities[4][3] = 5;
                matEntities[4][5] = 1;
                matEntities[4][6] = 0;
                matEntities[5][1] = 6;
                break;
            default:
                System.out.println("Error en integer numLav");
        }

    }

    public void AjustarTipoTile(int x[]) {
        int c = 0;
        for (j = 0; j < 6; j++) {
            for (i = 0; i < 10; i++) {
                matLabel[j][i] = new JLabel(imagenTile[x[c]]);
                matParedes[j][i] = x[c];
                c++;
            }
        }
    }

    public void DibujaTileEncubrir() {
        imagen[7] = new ImageIcon("images/tile0.PNG");
        for (j = 0; j < 6; j++) {
            for (i = 0; i < 10; i++) {
                matLabelEncubrir[j][i] = new JLabel(imagen[7]);
                matLabelEncubrir[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                this.add(matLabelEncubrir[j][i]);
            }
        }
    }

    public void QuitarTileEncubrir() {
        for (j = 0; j < 6; j++) {
            for (i = 0; i < 10; i++) {
                matLabelEncubrir[j][i].setBounds(-500, 0, 80, 80);
            }
        }
    }

    public void DibujaTileEntidades() {

        for (j = 0; j < 6; j++) {// dibujo de tiles
            for (i = 0; i < 10; i++) {

                if (matEntities[j][i] == 0) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[0]);
                    matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 1) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[1]);
                    matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 2) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[2]);
                    matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 3) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[3]);
                    matLabelEnteties[j][i].setBounds(-1000, -1000, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 4) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[4]);
                    matLabelEnteties[j][i].setBounds(-1000, -1000, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 5) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[5]);
                    matLabelEnteties[j][i].setBounds(-1000, -1000, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                if (matEntities[j][i] == 6) {
                    matLabelEnteties[j][i] = new JLabel(imagenEntidades[6]);
                    matLabelEnteties[j][i].setBounds(-1000, -1000, 80, 80);
                    this.add(matLabelEnteties[j][i]);
                }
                matLabel[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                this.add(matLabel[j][i]);
            }
        }
    }

    public void AgregarEnemigos() {

        for (j = 0; j < 6; j++) {
            for (i = 0; i < 10; i++) {
                switch (matEntities[j][i]) {
                    case 3:
                        matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                        break;
                    case 4:
                        matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                        break;
                    case 5:
                        matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                        break;
                    case 6:
                        matLabelEnteties[j][i].setBounds(80 * i + 25, 80 * j + 55, 80, 80);
                        break;
                }
            }
        }
    }

    public void InicializarMat() {

        for (j = 0; j < 6; j++) {
            for (i = 0; i < 10; i++) {
                matEntities[j][i] = -1;
            }
        }
    }

    // eventos mouse
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == arrayLabel[8]) {// regresar
            Inicio v = new Inicio();
            v.setVisible(true);
            this.setVisible(false);
        }

        if (e.getSource() == arrayLabel[9]) {// iniciar juego
            arrayLabel[9].setBounds(-1000, 0, 0, 0);
            arrayLabel[12].setBounds(-1000, 0, 0, 0);
            // Wait.mili(2);
            // QuitarTileEncubrir();

            AgregarEnemigos();
            arrayLabel[27].setBounds(-690 + (80 * posX), -342 + (80 * posY), 1500, 870);// fog
            arrayLabel[44].setBounds(-2049 + (80 * posX), -1414 + (80 * posY), 4000, 3000);// fog3
            play = true;
        }

        if (e.getSource() == matLabelPreguntas[numPregunta][1]) {// boton respuesta a
            switch (numPregunta) {// revisa si es correcta en cada pregunta
                case 0:
                    Correcto(true);
                    break;
                case 1:
                    Correcto(true);
                    break;
                case 2:
                    Correcto(true);
                    break;
                case 3:
                    Correcto(true);
                    break;
                case 4:
                    Correcto(true);
                    break;
                case 5:
                    Correcto(true);
                    break;
                case 6:
                    Correcto(true);
                    break;
                case 7:
                    Correcto(true);
                    break;
                case 8:
                    Correcto(true);
                    break;
                case 9:
                    Correcto(true);
                    break;
                default:
                    System.out.println("no jalo");
            }
            arrayLabel[34].setBounds(-595, 200, 100, 20);// quita cuadro de pregunta
            arrayLabel[33].setBounds(-520, 265, 230, 10);
            arrayLabel[32].setBounds(-520, 200, 230, 190);
            matLabelPreguntas[numPregunta][0].setBounds(-520, 220, 230, 40);
            matLabelPreguntas[numPregunta][1].setBounds(-520, 280, 230, 33);
            matLabelPreguntas[numPregunta][2].setBounds(-520, 317, 230, 33);
            matLabelPreguntas[numPregunta][3].setBounds(-520, 353, 230, 33);
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][2]) {// boton respuestas b
            switch (numPregunta) {// revisa si es correcta en cada pregunta
                case 0:
                    Correcto(false);
                    break;
                case 1:
                    Correcto(false);
                    break;
                case 2:
                    Correcto(false);
                    break;
                case 3:
                    Correcto(false);
                    break;
                case 4:
                    Correcto(false);
                    break;
                case 5:
                    Correcto(false);
                    break;
                case 6:
                    Correcto(false);
                    break;
                case 7:
                    Correcto(false);
                    break;
                case 8:
                    Correcto(false);
                    break;
                case 9:
                    Correcto(false);
                    break;
            }
            arrayLabel[34].setBounds(-595, 200, 100, 20);// quita cuadro de pregunta
            arrayLabel[33].setBounds(-520, 265, 230, 10);
            arrayLabel[32].setBounds(-520, 200, 230, 190);
            matLabelPreguntas[numPregunta][0].setBounds(-520, 220, 230, 40);
            matLabelPreguntas[numPregunta][1].setBounds(-520, 280, 230, 33);
            matLabelPreguntas[numPregunta][2].setBounds(-520, 317, 230, 33);
            matLabelPreguntas[numPregunta][3].setBounds(-520, 353, 230, 33);
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][3]) {// botone respuesta c
            switch (numPregunta) {// revisa si es correcta en cada pregunta
                case 0:
                    Correcto(false);
                    break;
                case 1:
                    Correcto(false);
                    break;
                case 2:
                    Correcto(false);
                    break;
                case 3:
                    Correcto(false);
                    break;
                case 4:
                    Correcto(false);
                    break;
                case 5:
                    Correcto(false);
                    break;
                case 6:
                    Correcto(false);
                    break;
                case 7:
                    Correcto(false);
                    break;
                case 8:
                    Correcto(false);
                    break;
                case 9:
                    Correcto(false);
                    break;
            }
            arrayLabel[34].setBounds(-595, 200, 100, 20);// quita cuadro de pregunta
            arrayLabel[33].setBounds(-520, 265, 230, 10);
            arrayLabel[32].setBounds(-520, 200, 230, 190);
            matLabelPreguntas[numPregunta][0].setBounds(-520, 220, 230, 40);
            matLabelPreguntas[numPregunta][1].setBounds(-520, 280, 230, 33);
            matLabelPreguntas[numPregunta][2].setBounds(-520, 317, 230, 33);
            matLabelPreguntas[numPregunta][3].setBounds(-520, 353, 230, 33);
        }
        if (e.getSource() == arrayLabel[16]) {// candle boton
            if (play == true && candle != 0) {
                music.Play("music/Candle.wav");
                fogTurns = 3;
                Fog(1);
                candle--;
                canS = Integer.toString(candle);
                arrayLabel[20].setText("          " + canS);

            }
        }
        if (e.getSource() == arrayLabel[17]) {// bomb buton
            if (preguntaActiva == true && bomb != 0) {
                music.Play("music/BombBlow.wav");
                play = true;
                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                MovePlayerFace(1);
                matEntities[posY][posX] = -1;
                arrayLabel[34].setBounds(-595, 200, 100, 20);// quita cuadro de pregunta
                arrayLabel[33].setBounds(-520, 265, 230, 10);
                arrayLabel[32].setBounds(-520, 200, 230, 190);
                matLabelPreguntas[numPregunta][0].setBounds(-520, 220, 230, 40);
                matLabelPreguntas[numPregunta][1].setBounds(-520, 280, 230, 33);
                matLabelPreguntas[numPregunta][2].setBounds(-520, 317, 230, 33);
                matLabelPreguntas[numPregunta][3].setBounds(-520, 353, 230, 33);
                preguntaActiva = false;
                bomb--;
                bombS = Integer.toString(bomb);
                arrayLabel[21].setText("          " + bombS);
            }

        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == arrayLabel[8]) {
            arrayLabel[8].setBackground(new Color(0, 197, 255));
            music.Play("music/Rupee.wav");
        }
        if (e.getSource() == arrayLabel[9]) {
            arrayLabel[9].setBackground(new Color(200, 200, 200));
            music.Play("music/Rupee.wav");
        }
        if (e.getSource() == arrayLabel[16]) {// candle boton
            if (play == true && candle != 0) {
                arrayLabel[16].setBackground(new Color(100, 100, 100));
                music.Play("music/Rupee.wav");

            }
        }
        if (e.getSource() == arrayLabel[17]) {// bomb buton
            if (bomb != 0 && preguntaActiva == true) {
                arrayLabel[17].setBackground(new Color(100, 100, 100));
                music.Play("music/Rupee.wav");
            }
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][1]) {// botone respuestas
            matLabelPreguntas[numPregunta][1].setBackground(Color.red);
            music.Play("music/Rupee.wav");
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][2]) {// botone respuestas
            matLabelPreguntas[numPregunta][2].setBackground(Color.red);
            music.Play("music/Rupee.wav");
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][3]) {// botone respuestas
            matLabelPreguntas[numPregunta][3].setBackground(Color.red);
            music.Play("music/Rupee.wav");
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == arrayLabel[8]) {
            arrayLabel[8].setBackground(new Color(0, 0, 255));
        }
        if (e.getSource() == arrayLabel[9]) {
            arrayLabel[9].setBackground(new Color(150, 150, 150));
        }
        if (e.getSource() == arrayLabel[16]) {
            arrayLabel[16].setBackground(new Color(0, 0, 0));
        }
        if (e.getSource() == arrayLabel[17]) {
            arrayLabel[17].setBackground(new Color(0, 0, 0));
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][1]) {// botone respuestas
            matLabelPreguntas[numPregunta][1].setBackground(Color.gray);
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][2]) {// botone respuestas
            matLabelPreguntas[numPregunta][2].setBackground(Color.gray);
        }
        if (e.getSource() == matLabelPreguntas[numPregunta][3]) {// botone respuestas
            matLabelPreguntas[numPregunta][3].setBackground(Color.gray);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    // eventos teclado
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (play == true) {
            arrayLabel[31].setBounds(-200, 0, 80, 80);
            arrayLabel[31].setText("OBTUVISTE");
            arrayLabel[28].setBounds(-200, 0, 80, 80);
            arrayLabel[29].setBounds(-200, 0, 80, 80);
            arrayLabel[30].setBounds(-200, 0, 80, 80);
            arrayLabel[36].setBounds(-800, 0, 80, 80);
            arrayLabel[37].setBounds(-800, 0, 80, 80);
            switch (e.getKeyCode()) {
                case 37: // izquierda
                    switch (matParedes[posY][posX]) {// condiciones de paredes
                        case 4:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 5:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 8:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 9:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 11:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 12:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 13:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(3);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        default:
                            moved = true;
                    }
                    if (moved == true) {// condiciones de movimento
                        posX--;
                        if (posX == -1 && posY == 5) {// condicion de ganar
                            MovePlayerFace(3);
                            music.Play("music/Escape.wav");
                            play = false;
                            arrayLabel[27].setBounds(-6000, 0, 1500, 870);
                            arrayLabel[38].setBounds(2000, 0, 1500, 870);
                            arrayLabel[40].setBounds(290, 570, 195, 30);
                            arrayLabel[44].setBounds(-6000, 0, 1500, 870);
                        } else {
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            switch (matEntities[posY][posX]) {
                                case -1:// no entitie
                                    MovePlayerFace(3);
                                    music.Play("music/Low.wav");
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    break;
                                case 0:// candle
                                    music.Play("music/Item.wav");
                                    matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                    arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                    arrayLabel[28].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    matEntities[posY][posX] = -1;
                                    candle++;
                                    canS = Integer.toString(candle);
                                    arrayLabel[20].setText("          " + canS);
                                    MovePlayerFace(3);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    break;
                                case 1:// bomb
                                    music.Play("music/Item.wav");
                                    matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                    arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 38, 80, 80);
                                    arrayLabel[29].setBounds(80 * posX + 25, 80 * posY - 5, 80, 80);
                                    matEntities[posY][posX] = -1;
                                    bomb++;
                                    bombS = Integer.toString(bomb);
                                    arrayLabel[21].setText("          " + bombS);
                                    MovePlayerFace(3);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    break;
                                case 2:// heart
                                    if (vida == 2) {
                                        music.Play("music/Deflect.wav");
                                        arrayLabel[31].setText("VIDA LLENA");
                                        arrayLabel[31].setBounds(80 * posX + 23, 80 * posY - 18, 90, 80);
                                        arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                        MovePlayerFace(3);
                                        if (fogTurns > 0) {
                                            Fog(1);
                                            fogTurns--;
                                        } else
                                            Fog(0);
                                    } else {
                                        music.Play("music/GetHeart.wav");
                                        matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                        Corazon(1);
                                        arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                        arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                        MovePlayerFace(3);
                                        if (fogTurns > 0) {
                                            Fog(1);
                                            fogTurns--;
                                        } else
                                            Fog(0);
                                        matEntities[posY][posX] = -1;
                                    }
                                    break;
                                case 3:// Enemies
                                case 4:
                                case 5:
                                case 6:
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    MovePlayerFace(4);
                                    music.Play("music/Enemy.wav");
                                    play = false;
                                    Preguntas();

                                    break;
                            }

                        }
                    }
                    moved = false;
                    break;

                case 38: // arriba
                    switch (matParedes[posY][posX]) {
                        case 1:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 5:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 6:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 10:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 12:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 13:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 14:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;

                        default:
                            moved = true;
                    }
                    if (moved == true) {
                        posY--;
                        moviminetos++;
                        arrayLabel[10].setText("  Movimentos: " + moviminetos);
                        switch (matEntities[posY][posX]) {
                            case -1:// no entitie
                                MovePlayerFace(1);
                                music.Play("music/Low.wav");
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 0:// candle
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                arrayLabel[28].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                matEntities[posY][posX] = -1;
                                candle++;
                                canS = Integer.toString(candle);
                                arrayLabel[20].setText("          " + canS);
                                MovePlayerFace(1);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 1:// bomb
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 38, 80, 80);
                                arrayLabel[29].setBounds(80 * posX + 25, 80 * posY - 5, 80, 80);
                                matEntities[posY][posX] = -1;
                                bomb++;
                                bombS = Integer.toString(bomb);
                                arrayLabel[21].setText("          " + bombS);
                                MovePlayerFace(1);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 2:// heart
                                if (vida == 2) {
                                    music.Play("music/Deflect.wav");
                                    arrayLabel[31].setText("VIDA LLENA");
                                    arrayLabel[31].setBounds(80 * posX + 23, 80 * posY - 18, 90, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(1);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                } else {
                                    music.Play("music/GetHeart.wav");
                                    matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                    Corazon(1);
                                    arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(1);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    matEntities[posY][posX] = -1;
                                }
                                break;
                            case 3:// Enemies
                            case 4:
                            case 5:
                            case 6:
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                MovePlayerFace(4);
                                music.Play("music/Enemy.wav");
                                play = false;
                                Preguntas();

                                break;
                        }
                    }
                    moved = false;
                    break;

                case 39: // derecha
                    switch (matParedes[posY][posX]) {
                        case 2:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 6:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 7:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 9:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 11:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 13:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 14:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(2);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;

                        default:
                            moved = true;
                    }
                    if (moved == true) {
                        posX++;
                        moviminetos++;
                        arrayLabel[10].setText("  Movimentos: " + moviminetos);
                        switch (matEntities[posY][posX]) {
                            case -1:// no entitie
                                MovePlayerFace(2);
                                music.Play("music/Low.wav");
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 0:// candle
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                arrayLabel[28].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                matEntities[posY][posX] = -1;
                                candle++;
                                canS = Integer.toString(candle);
                                arrayLabel[20].setText("          " + canS);
                                MovePlayerFace(2);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 1:// bomb
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 38, 80, 80);
                                arrayLabel[29].setBounds(80 * posX + 25, 80 * posY - 5, 80, 80);
                                matEntities[posY][posX] = -1;
                                bomb++;
                                bombS = Integer.toString(bomb);
                                arrayLabel[21].setText("          " + bombS);
                                MovePlayerFace(2);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 2:// heart
                                if (vida == 2) {
                                    music.Play("music/Deflect.wav");
                                    arrayLabel[31].setText("VIDA LLENA");
                                    arrayLabel[31].setBounds(80 * posX + 23, 80 * posY - 18, 90, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(2);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                } else {
                                    music.Play("music/GetHeart.wav");
                                    matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                    Corazon(1);
                                    arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(2);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    matEntities[posY][posX] = -1;
                                }
                                break;
                            case 3:// Enemies
                            case 4:
                            case 5:
                            case 6:
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                MovePlayerFace(4);
                                music.Play("music/Enemy.wav");
                                play = false;
                                Preguntas();

                                break;
                        }
                    }
                    moved = false;
                    break;

                case 40: // abajo
                    switch (matParedes[posY][posX]) {
                        case 3:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 7:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 8:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 10:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 12:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 11:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;
                        case 14:
                            music.Play("music/Hit.wav");
                            MovePlayerFace(1);
                            moviminetos++;
                            arrayLabel[10].setText("  Movimentos: " + moviminetos);
                            break;

                        default:
                            moved = true;
                    }
                    if (moved == true) {
                        posY++;
                        moviminetos++;
                        arrayLabel[10].setText("  Movimentos: " + moviminetos);
                        switch (matEntities[posY][posX]) {
                            case -1:// no entitie
                                MovePlayerFace(1);
                                music.Play("music/Low.wav");
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 0:// candle
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                arrayLabel[28].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                matEntities[posY][posX] = -1;
                                candle++;
                                canS = Integer.toString(candle);
                                arrayLabel[20].setText("          " + canS);
                                MovePlayerFace(1);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 1:// bomb
                                music.Play("music/Item.wav");
                                matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 38, 80, 80);
                                arrayLabel[29].setBounds(80 * posX + 25, 80 * posY - 5, 80, 80);
                                matEntities[posY][posX] = -1;
                                bomb++;
                                bombS = Integer.toString(bomb);
                                arrayLabel[21].setText("          " + bombS);
                                MovePlayerFace(1);
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                break;
                            case 2:// heart
                                if (vida == 2) {
                                    music.Play("music/Deflect.wav");
                                    arrayLabel[31].setText("VIDA LLENA");
                                    arrayLabel[31].setBounds(80 * posX + 23, 80 * posY - 18, 90, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(1);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                } else {
                                    music.Play("music/GetHeart.wav");
                                    matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
                                    Corazon(1);
                                    arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
                                    arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
                                    MovePlayerFace(1);
                                    if (fogTurns > 0) {
                                        Fog(1);
                                        fogTurns--;
                                    } else
                                        Fog(0);
                                    matEntities[posY][posX] = -1;
                                }
                                break;
                            case 3:// Enemies
                            case 4:
                            case 5:
                            case 6:
                                if (fogTurns > 0) {
                                    Fog(1);
                                    fogTurns--;
                                } else
                                    Fog(0);
                                MovePlayerFace(4);
                                music.Play("music/Enemy.wav");
                                play = false;
                                Preguntas();

                                break;
                        }
                    }
                    moved = false;
                    break;
            }
        }
    }

    public void MovePlayerFace(int a) {
        switch (a) {
            case 1:// ariba, abajo
                arrayLabel[24].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                arrayLabel[25].setBounds(-200, 0, 80, 80);
                arrayLabel[26].setBounds(-200, 0, 80, 80);
                break;
            case 2:// derecha
                arrayLabel[24].setBounds(-200, 0, 80, 80);
                arrayLabel[25].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                arrayLabel[26].setBounds(-200, 0, 80, 80);
                break;
            case 3:// izquierda
                arrayLabel[24].setBounds(-200, 0, 80, 80);
                arrayLabel[25].setBounds(-200, 0, 80, 80);
                arrayLabel[26].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                break;
            case 4:// quitar todos
                arrayLabel[24].setBounds(-200, 0, 80, 80);
                arrayLabel[25].setBounds(-200, 0, 80, 80);
                arrayLabel[26].setBounds(-200, 0, 80, 80);
                break;

        }
    }

    public void LabelsPreguntas() {
        int c = 0;

        imagenPregunta[0] = new ImageIcon("images/preguntas/M1.PNG");
        imagenPregunta[1] = new ImageIcon("images/preguntas/M1_1.PNG");
        imagenPregunta[2] = new ImageIcon("images/preguntas/M1_2.PNG");
        imagenPregunta[3] = new ImageIcon("images/preguntas/M1_3.PNG");
        imagenPregunta[4] = new ImageIcon("images/preguntas/M2.PNG");
        imagenPregunta[5] = new ImageIcon("images/preguntas/M2_1.PNG");
        imagenPregunta[6] = new ImageIcon("images/preguntas/M2_2.PNG");
        imagenPregunta[7] = new ImageIcon("images/preguntas/M2_3.PNG");
        imagenPregunta[8] = new ImageIcon("images/preguntas/M3.PNG");
        imagenPregunta[9] = new ImageIcon("images/preguntas/M3_1.PNG");
        imagenPregunta[10] = new ImageIcon("images/preguntas/M3_2.PNG");
        imagenPregunta[11] = new ImageIcon("images/preguntas/M3_3.PNG");
        imagenPregunta[12] = new ImageIcon("images/preguntas/M4.PNG");
        imagenPregunta[13] = new ImageIcon("images/preguntas/M4_1.PNG");
        imagenPregunta[14] = new ImageIcon("images/preguntas/M4_2.PNG");
        imagenPregunta[15] = new ImageIcon("images/preguntas/M4_3.PNG");
        imagenPregunta[16] = new ImageIcon("images/preguntas/M5.PNG");
        imagenPregunta[17] = new ImageIcon("images/preguntas/M5_1.PNG");
        imagenPregunta[18] = new ImageIcon("images/preguntas/M5_2.PNG");
        imagenPregunta[19] = new ImageIcon("images/preguntas/M5_3.PNG");
        imagenPregunta[20] = new ImageIcon("images/preguntas/M6.PNG");
        imagenPregunta[21] = new ImageIcon("images/preguntas/M6_1.PNG");
        imagenPregunta[22] = new ImageIcon("images/preguntas/M6_2.PNG");
        imagenPregunta[23] = new ImageIcon("images/preguntas/M6_3.PNG");
        imagenPregunta[24] = new ImageIcon("images/preguntas/M7.PNG");
        imagenPregunta[25] = new ImageIcon("images/preguntas/M7_1.PNG");
        imagenPregunta[26] = new ImageIcon("images/preguntas/M7_2.PNG");
        imagenPregunta[27] = new ImageIcon("images/preguntas/M7_3.PNG");
        imagenPregunta[28] = new ImageIcon("images/preguntas/M8.PNG");
        imagenPregunta[29] = new ImageIcon("images/preguntas/M8_1.PNG");
        imagenPregunta[30] = new ImageIcon("images/preguntas/M8_2.PNG");
        imagenPregunta[31] = new ImageIcon("images/preguntas/M8_3.PNG");
        imagenPregunta[32] = new ImageIcon("images/preguntas/M9.PNG");
        imagenPregunta[33] = new ImageIcon("images/preguntas/M9_1.PNG");
        imagenPregunta[34] = new ImageIcon("images/preguntas/M9_2.PNG");
        imagenPregunta[35] = new ImageIcon("images/preguntas/M9_3.PNG");
        imagenPregunta[36] = new ImageIcon("images/preguntas/M10.PNG");
        imagenPregunta[37] = new ImageIcon("images/preguntas/M10_1.PNG");
        imagenPregunta[38] = new ImageIcon("images/preguntas/M10_2.PNG");
        imagenPregunta[39] = new ImageIcon("images/preguntas/M10_3.PNG");

        for (j = 0; j < 10; j++) {
            for (i = 0; i < 4; i++) {
                matLabelPreguntas[j][i] = new JLabel(imagenPregunta[c]);
                this.add(matLabelPreguntas[j][i]);
                c++;
            }
        }
    }

    public void Preguntas() {
        int c = 0, a, b;
        preguntaActiva = true;

        for (i = 0; i < 10; i++) {// revisa que todas no se hayan preguntado
            if (pregunta[i] == 0)
                c++;
        }
        if (c == 10) {
            for (i = 0; i < 10; i++) {
                pregunta[i] = 1;
            }
        }
        // c=0;
        do {// consigue una pregunta no usada anteriormente
            a = rand.nextInt(10);
            // System.out.println(a+" ran");
            b = pregunta[a];
            // System.out.println(b+" libre");
            // System.out.println(c+" contador");
            // c++;
        } while (b == 0);

        pregunta[a] = 0;

        arrayLabel[34].setBounds(905, 200, 100, 20);// cuadro de pregunta
        arrayLabel[33].setBounds(840, 265, 230, 10);
        arrayLabel[32].setBounds(840, 200, 230, 235);

        matLabelPreguntas[a][0].setBounds(840, 220, 230, 40);

        matLabelPreguntas[a][1].setBounds(840, 280, 230, 45);
        matLabelPreguntas[a][1].setOpaque(true);
        matLabelPreguntas[a][1].setBackground(Color.gray);
        matLabelPreguntas[a][1].addMouseListener(this);

        matLabelPreguntas[a][2].setBounds(840, 330, 230, 45);
        matLabelPreguntas[a][2].setOpaque(true);
        matLabelPreguntas[a][2].setBackground(Color.gray);
        matLabelPreguntas[a][2].addMouseListener(this);

        matLabelPreguntas[a][3].setBounds(840, 380, 230, 45);
        matLabelPreguntas[a][3].setOpaque(true);
        matLabelPreguntas[a][3].setBackground(Color.gray);
        matLabelPreguntas[a][3].addMouseListener(this);

        numPregunta = a;
    }

    public void Correcto(boolean acierto) {
        if (acierto == true) {
            music.Play("music/EnemyKill.wav");
            arrayLabel[36].setBounds(80 * posX + 10, 80 * posY + 10, 110, 20);
            play = true;
            MovePlayerFace(1);
        }
        if (acierto == false) {
            arrayLabel[37].setBounds(80 * posX + 10, 80 * posY + 10, 125, 20);
            Corazon(-1);
            if (vida == 1) {
                music.Play("music/wrong.wav");
                play = true;
                MovePlayerFace(1);
            }
            if (vida == 0) {
                GameOver();
            }
        }
        matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
        matEntities[posY][posX] = -1;
        preguntaActiva = false;
    }

    public void Fog(int a) {
        if (a == 0) {// fog 1
            arrayLabel[27].setBounds(-690 + (80 * posX), -342 + (80 * posY), 1500, 870);
            arrayLabel[38].setBounds(-60000, 0, 1500, 870);
            arrayLabel[44].setBounds(-1949 + (80 * posX), -1314 + (80 * posY), 4000, 3000);
        }
        if (a == 1) {// fog 2
            arrayLabel[27].setBounds(-60000, 0, 1500, 870);
            arrayLabel[38].setBounds(-690 + (80 * posX), -342 + (80 * posY), 1500, 870);
            arrayLabel[44].setBounds(-1949 + (80 * posX), -1314 + (80 * posY), 4000, 3000);
        }
    }

    public void GameOver() {
        play = false;
        music.Play("music/Die.wav");
        MovePlayerFace(4);
        arrayLabel[27].setBounds(2000, 0, 1500, 870);
        arrayLabel[44].setBounds(-6000, 0, 1500, 870);
        arrayLabel[38].setBounds(2000, 0, 1500, 870);
        arrayLabel[35].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);// tomb
        arrayLabel[37].setBounds(-200, 0, 130, 20);
        arrayLabel[36].setBounds(-200, 0, 130, 20);
        arrayLabel[39].setBounds(290, 570, 195, 30);
    }

    public void Corazon(int a) {
        vidaAntigua = vida;
        vida = vida + a;
        if (vida == 1 && vidaAntigua == 2) {
            arrayLabel[3].setBounds(0, -100, 25, 28);
        }
        if (vida == 0 && vidaAntigua == 1) {
            arrayLabel[2].setBounds(0, -100, 25, 28);
        }
        if (vida == 2 && vidaAntigua == 1) {
            arrayLabel[3].setBounds(105, 5, 25, 28);
        }
        /*
         * if(vida==1 && vidaAntigua==0){
         * arrayLabel[2].setBounds(70,5,25,28);
         * }
         */
    }
}

class Sound {

    public void Play(String location) {
        try {
            File musicPath = new File(location);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
            } else {
                System.out.println("File not found");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Loop(String location) {
        try {
            File musicPath = new File(location);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                System.out.println("File not found");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
