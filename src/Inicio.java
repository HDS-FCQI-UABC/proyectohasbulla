import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import frame.*;

public class Inicio extends BaseFrame  implements KeyListener{
    public static int reset=0;
    private JLabel label0,label1,label_shield_select,label4,label7,label_instruction,label_shield,label_shield_2,label11,label_instruction_select,label_instruction_bckgnd;
    private ImageIcon imagen0,imagen1,imagen2,imagen3,imagen4,imagen5,imagen6;
    private Sound music = new Sound();
    private int select_pos=1;
    private boolean released=true,select_instruc=false;

    public Inicio(){
        frame("Menu principal",716,497);
        addKeyListener(this);


        getContentPane().setBackground(new Color(0, 204, 255));

        imagen0 = new ImageIcon("src/images/TitleScreen.png");
        label0 = new JLabel(imagen0);
        label0.setBounds(0,-2,700,500);// x , y; Ubicacion Tamaño


        label1 = new JLabel("LABERINTO");
        label1.setBounds(235,30,500,40);
        label1.setFont(new Font("Copperplate Gothic Bold", 0, 35));
        label1.setForeground(new Color(225,0,0));

        imagen1 = new ImageIcon("src/images/Shield3.gif");
        label_shield_select = new JLabel(imagen1);
        label_shield_select.setBounds(165,155,140,190);

        imagen3 = new ImageIcon("src/images/Shield1.png");
        label_shield = new JLabel(imagen3);
        label_shield.setBounds(185,175,100,150);

        label_shield_2 = new JLabel(imagen3);
        label_shield_2.setBounds(425,175,100,150);

        label4 = new JLabel("FACIL");
        label4.setBounds(205,330,100,30);
        label4.setFont(new Font("Bahnschrift", 0, 20));
        label4.setForeground(Color.blue);

        label7 = new JLabel("NORMAL");
        label7.setBounds(435,330,100,30);
        label7.setFont(new Font("Bahnschrift", 0, 20));
        label7.setForeground(new Color(14, 211, 0));

        label_instruction = new JLabel(" Instruciones");
        label_instruction.setOpaque(true);
        label_instruction.setBounds(20,400,95,40);
        label_instruction.setFont(new Font("Agency FB", 1, 22));
        label_instruction.setForeground(new Color(225,255,255, 255));
        label_instruction.setBackground(new Color(0,142,211));

        label_instruction_bckgnd = new JLabel();
        label_instruction_bckgnd.setOpaque(true);
        label_instruction_bckgnd.setBounds(15,395,105,50);
        label_instruction_bckgnd.setBackground(new Color(225, 255, 255));

        imagen6 = new ImageIcon("src/images/Intructions.gif");
        label_instruction_select = new JLabel(imagen6);
        label_instruction_select.setBounds(-100,-100,0,0);

        add(label7);
        add(label4);
        add(label_instruction);
        add(label_instruction_select);
        add(label_instruction_bckgnd);
        add(label_shield_select);
        add(label1);
        add(label_shield_2);
        add(label_shield);
        add(label0);
    }

    //label changes
    public void shieldSelected(int pos){
        switch(pos){
            case 1:
                label_shield_select.setBounds(165, 155, 140, 190);
                music.Play("src/music/Low.wav");
                break;
            case 2:
                label_shield_select.setBounds(405, 155, 140, 190);
                music.Play("src/music/Low.wav");
        }
    }
    public void instructionsSelected(boolean not_selected){
        if(not_selected==true){
            label_instruction.setBackground(new Color(0,142,211));
            label_instruction_select.setBounds(-100,-100,95,40);
        }
        else{
            label_instruction.setBackground(new Color(225, 255, 255, 0));
            label_instruction_select.setBounds(20,400,95,40);
        }
    }

    //eventos teclado
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        if (released==true){
            switch(e.getKeyCode()) {
                case 37://izquierda
                case 39://derecha
                    if(select_instruc==false) {
                        label_shield_select.setBounds(-100, 230, 0, 0);
                        select_pos++;
                        if (select_pos > 2) {
                            select_pos = 1;
                        }
                        if (select_pos < 1) {
                            select_pos = 2;
                        }
                        switch (select_pos) {
                            case 1:
                                shieldSelected(1);
                                break;
                            case 2:
                                shieldSelected(2);
                                break;

                        }
                    }
                    else if(select_instruc==true) {
                        switch (select_pos) {
                            case 1:
                                shieldSelected(1);
                                break;
                            case 2:
                                shieldSelected(2);
                                break;
                        }
                        instructionsSelected(true);
                        select_instruc=false;
                    }
                    released = false;
                    break;
                case 38://arriba
                case 40://abajo
                    if(select_instruc==false){
                        label_shield_select.setBounds(-1000, -1000, 0, 0);
                        instructionsSelected(false);
                        music.Play("src/music/Low.wav");
                        select_instruc=true;
                    }
                    else if(select_instruc==true){
                        switch (select_pos){// acomoda el shield en su lugar
                            case 1:
                                shieldSelected(1);
                                break;
                            case 2:
                                shieldSelected(2);
                                break;
                        }
                        instructionsSelected(true);
                        select_instruc=false;
                    }
                    released = false;
                    break;
                case 10://enter
                case 13:
                    if(select_instruc==false) {
                        switch (select_pos) {
                            case 1:
                                music.Play("src/music/Rupee.wav");
                                this.setVisible(false);
                                //Nivel1.numLav++;
                                Nivel1 n = new Nivel1();
                                n.setVisible(true);
                                break;
                            case 2:
                                music.Play("src/music/Deflect.wav");
                                this.setVisible(false);
                                Nivel2.numLav++;
                                Nivel2 n2 = new Nivel2();
                                n2.setVisible(true);
                                break;
                        }
                    }
                    if(select_instruc==true) {
                        music.Play("src/music/Rupee.wav");
                        this.setVisible(false);
                        Instrucciones ins = new Instrucciones();
                        ins.setVisible(true);
                    }
                    released = false;
                    break;
                default:
                    System.out.println(e.getKeyCode() + " default");
                    released = false;
                    break;
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            default:
                released=true;
        }
    }
}