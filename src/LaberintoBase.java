import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class LaberintoBase extends FrameBase implements KeyListener {
    public static int numLav=1;
    public int i,j,candle=0,bomb=0,posX=5,posY=0,vida=2,vidaAntigua, movimientos_P1 =0, movimientos_P2 =0,numPregunta
            ,fogTurns,jugador_num,play_count,CandleBombPosX=0,CandleBombPosY=0,current_question=1,QuestionBoxPosX=0,QuestionBoxPosY=0
            ,a,width_laberinto,height_laberinto,c;
    public int [] pregunta =  {1,1,1,1,1},tipoTile = new int [50];
    public int [][] matEntities = new int[4][6];
    public int [][] matParedes = new int[4][6];
    public String canS,bombS,winner,player1_dead,player2_dead;

    public String newline = System.getProperty("line.separator");
    public boolean play=false,moved=false,preguntaActiva=false,released=true, game_over=false,game_can_start=true,
                    player1_die=false,player2_die=false;
    public JLabel[] arrayLabel = new JLabel[100];
    public JLabel [][] matLabelPreguntas = new JLabel[5][4];
    public JLabel [][] matLabel = new JLabel[4][6];
    public JLabel [][] matLabelEnteties = new JLabel[4][6];
    public ImageIcon [] imagen = new ImageIcon[40];
    public ImageIcon [] imagenTile = new ImageIcon[20];
    public ImageIcon [] imagenEntidades = new ImageIcon[20];
    public ImageIcon [] imagenPregunta = new ImageIcon[20];
    public Sound music = new Sound();
    public Random rand = new Random();

    public void SetQuestionBoxPos(int CandleBombPosX,int CandleBombPosY){
        QuestionBoxPosX=CandleBombPosX;
        QuestionBoxPosY=CandleBombPosY+150;
    }

    public void Assets(){
        imagen[1] = new ImageIcon("src/images/bkg1.PNG");
        arrayLabel[0] = new JLabel(imagen[1]);
        arrayLabel[0].setBounds(0,0,767,529);

        arrayLabel[1] = new JLabel("VIDA:");
        arrayLabel[1].setBounds(10,10,50,17);
        arrayLabel[1].setFont(new Font("Arial Black", 0 ,15));
        arrayLabel[1].setForeground(new Color(255,255,255));

        imagen[2] = new ImageIcon("src/images/Life1.gif");
        imagen[3] = new ImageIcon("src/images/Life2.gif");
        imagen[6] = new ImageIcon("src/images/Exit.gif");
        imagen[7] = new ImageIcon("src/images/Start.gif");
        imagen[8] = new ImageIcon("src/images/Question.gif");
        imagen[9] = new ImageIcon("src/images/Transparent.png");
        imagen[10] = new ImageIcon("src/images/PlayAgain.gif");

        arrayLabel[2] = new JLabel(imagen[2]);//heart rojo
        arrayLabel[2].setBounds(70,5,25,28);

        arrayLabel[3] = new JLabel(imagen[2]);//heart rojo
        arrayLabel[3].setBounds(105,5,25,28);

        arrayLabel[4] = new JLabel(imagen[3]);//heart empty
        arrayLabel[4].setBounds(70,5,25,28);

        arrayLabel[5] = new JLabel(imagen[3]);//heart empty
        arrayLabel[5].setBounds(105,5,25,28);

        arrayLabel[6] = new JLabel();
        arrayLabel[6].setOpaque(true);
        arrayLabel[6].setBackground(new Color(0,0,0));
        arrayLabel[6].setBounds(5,2,140,34);

        arrayLabel[13] = new JLabel("FACIL");
        arrayLabel[13].setOpaque(true);
        arrayLabel[13].setBounds(317,4,118,38);
        arrayLabel[13].setFont(new Font("Copperplate Gothic Bold",0,33));
        arrayLabel[13].setForeground(Color.black);
        arrayLabel[13].setBackground(new Color(255,0,0));

        arrayLabel[7] = new JLabel("FACIL");
        //arrayLabel[7].setOpaque(true);
        arrayLabel[7].setBounds(320,4,118,38);
        arrayLabel[7].setFont(new Font("Copperplate Gothic Bold",0,33));
        arrayLabel[7].setForeground(new Color(255,255,255));
        //arrayLabel[7].setBackground(new Color(255,0,0));

        arrayLabel[8] = new JLabel("SALIR");
        arrayLabel[8].setOpaque(true);
        arrayLabel[8].setBounds(600,405,115,38);
        arrayLabel[8].setFont(new Font("Agency FB",1,26));
        arrayLabel[8].setForeground(new Color(255, 253, 253));
        arrayLabel[8].setBackground(new Color(197, 12, 12));
        arrayLabel[8].setHorizontalAlignment(SwingConstants.CENTER);

        arrayLabel[12] = new JLabel("PRESIONA ESC");//
        arrayLabel[12].setOpaque(true);
        arrayLabel[12].setForeground(new Color(225, 255, 255));
        arrayLabel[12].setBackground(new Color(68, 62, 62));
        arrayLabel[12].setFont(new Font("Arial",0,13));
        arrayLabel[12].setBounds(600,443,115,27);
        arrayLabel[12].setHorizontalAlignment(SwingConstants.CENTER);

        arrayLabel[9] = new JLabel("JUGADOR "+jugador_num);
        arrayLabel[9].setOpaque(true);
        arrayLabel[9].setBounds(270,405,150,40);
        arrayLabel[9].setFont(new Font("Arial",1,23));
        arrayLabel[9].setForeground(new Color(25, 196, 6));
        arrayLabel[9].setBackground(new Color(0, 0, 0));
        arrayLabel[9].setHorizontalAlignment(SwingConstants.CENTER);

        arrayLabel[42] = new JLabel("PRESIONA ENTER");//
        arrayLabel[42].setOpaque(true);
        arrayLabel[42].setForeground(new Color(225, 255, 255));
        arrayLabel[42].setBackground(new Color(68, 62, 62));
        arrayLabel[42].setFont(new Font("Arial",0,13));
        arrayLabel[42].setBounds(270,445,150,35);
        arrayLabel[42].setHorizontalAlignment(SwingConstants.CENTER);

        arrayLabel[43] = new JLabel(imagen[7]);//
        arrayLabel[43].setBounds(265,400,160,85);

        arrayLabel[10] = new JLabel("  Movimientos: "+ movimientos_P1);
        arrayLabel[10].setOpaque(true);
        arrayLabel[10].setBounds(30,405,130,38);
        arrayLabel[10].setFont(new Font("Agency FB",0,23));
        arrayLabel[10].setForeground(Color.white);
        arrayLabel[10].setBackground(Color.black);

        arrayLabel[22] = new JLabel();//barras salida
        arrayLabel[22].setOpaque(true);
        arrayLabel[22].setBackground(new Color(234,100,86));
        arrayLabel[22].setBounds(5,295,25,5);


        arrayLabel[23] = new JLabel();//barras salida
        arrayLabel[23].setOpaque(true);
        arrayLabel[23].setBackground(new Color(234,100,86));
        arrayLabel[23].setBounds(5,365,26,5);

        arrayLabel[41] = new JLabel(imagen[6]);//barra gif
        arrayLabel[41].setBounds(5,295,30,75);


        arrayLabel[24] = new JLabel(imagenEntidades[8]);//link1
        arrayLabel[24].setBounds(80*posX+25,80*posY+55,80,80);

        arrayLabel[25] = new JLabel(imagenEntidades[9]);//link2
        arrayLabel[25].setBounds(-100,0,80,80);

        arrayLabel[26] = new JLabel(imagenEntidades[10]);//link3
        arrayLabel[26].setBounds(-100,0,80,80);

        arrayLabel[49] = new JLabel(imagenEntidades[11]);//link2_1
        arrayLabel[49].setBounds(-1000,-0,80,80);

        arrayLabel[50] = new JLabel(imagenEntidades[12]);//link2_2
        arrayLabel[50].setBounds(-100,0,80,80);

        arrayLabel[51] = new JLabel(imagenEntidades[13]);//link2_3
        arrayLabel[51].setBounds(-100,0,80,80);

        imagen[4] = new ImageIcon("src/images/fog.png");//niebla
        arrayLabel[27] = new JLabel(imagen[4]);
        arrayLabel[27].setBounds(2000,0,1500,870);

        imagen[5] = new ImageIcon("src/images/fog2.png");//niebla 2
        arrayLabel[38] = new JLabel(imagen[5]);
        arrayLabel[38].setBounds(2000,0,1500,870);


        arrayLabel[28] = new JLabel(imagenEntidades[0]);//candle 2
        arrayLabel[28].setBounds(-200,0,80,80);

        arrayLabel[29] = new JLabel(imagenEntidades[1]);//bomb 2
        arrayLabel[29].setBounds(-200,0,80,80);

        arrayLabel[30] = new JLabel(imagenEntidades[2]);//heart 2
        arrayLabel[30].setBounds(-200,0,80,80);

        arrayLabel[31] = new JLabel("OBTUVISTE");
        arrayLabel[31].setFont(new Font("Copperplate Gothic Bold",0,12));
        arrayLabel[31].setForeground(Color.black);
        arrayLabel[31].setBounds(-200,0,118,50);

        arrayLabel[34] = new JLabel("PREGUNTA");
        arrayLabel[34].setFont(new Font("Copperplate Gothic Bold",0,12));
        arrayLabel[34].setForeground(Color.black);
        //arrayLabel[34].setBounds(595,200,100,20);
        arrayLabel[34].setBounds(-595,200,100,20);

        arrayLabel[33] = new JLabel();//barra negra
        arrayLabel[33].setOpaque(true);
        arrayLabel[33].setBackground(Color.black);
        //arrayLabel[33].setBounds(520,265,230,10);
        arrayLabel[33].setBounds(-520,265,230,10);

        arrayLabel[32] = new JLabel();//cuadro de preguntas
        arrayLabel[32].setOpaque(true);
        arrayLabel[32].setBackground(Color.white);
        arrayLabel[32].setBounds(-520,200,230,190);

        arrayLabel[35] = new JLabel(imagenEntidades[7] );//tomb
        arrayLabel[35].setBounds(-200,0,80,80);

        arrayLabel[36] = new JLabel(" CORRECTO");
        arrayLabel[36].setFont(new Font("Copperplate Gothic Bold",0,15));
        arrayLabel[36].setForeground(Color.RED);
        arrayLabel[36].setOpaque(true);
        arrayLabel[36].setBackground(Color.white);
        arrayLabel[36].setBounds(-200,0,130,20);

        arrayLabel[37] = new JLabel(" INCORRECTO");
        arrayLabel[37].setFont(new Font("Copperplate Gothic Bold",0,15));
        arrayLabel[37].setForeground(Color.RED);
        arrayLabel[37].setOpaque(true);
        arrayLabel[37].setBackground(Color.white);
        arrayLabel[37].setBounds(-200,0,130,20);

        arrayLabel[39] = new JLabel("MORISTE");
        arrayLabel[39].setFont(new Font("Copperplate Gothic Bold",0,35));
        arrayLabel[39].setForeground(Color.RED);
        arrayLabel[39].setOpaque(true);
        arrayLabel[39].setBackground(Color.black);
        arrayLabel[39].setBounds(-2000,0,195,30);
        arrayLabel[39].setHorizontalAlignment(SwingConstants.CENTER);

        arrayLabel[40] = new JLabel("GANASTE");
        arrayLabel[40].setFont(new Font("Copperplate Gothic Bold",0,30));
        arrayLabel[40].setForeground(Color.green);
        arrayLabel[40].setOpaque(true);
        arrayLabel[40].setBackground(Color.black);
        arrayLabel[40].setBounds(-2000,0,195,30);
        arrayLabel[40].setHorizontalAlignment(SwingConstants.CENTER);

        arrayLabel[52] = new JLabel("PRESIONA ENTER");//cuadro gris Ganaste/Perdiste
        arrayLabel[52].setOpaque(true);
        arrayLabel[52].setForeground(new Color(225, 255, 255));
        arrayLabel[52].setBackground(new Color(68, 62, 62));
        arrayLabel[52].setFont(new Font("Arial",0,13));
        arrayLabel[52].setBounds(-2270,0,0,0);
        arrayLabel[52].setHorizontalAlignment(SwingConstants.CENTER);

        arrayLabel[53] = new JLabel(imagen[10]);//Play again seleccion
        arrayLabel[53].setBounds(-100,0,0,0);

        arrayLabel[45] = new JLabel(imagen[8]);//pregunta seleccion
        arrayLabel[45].setBounds(-100,0,0,0);

        arrayLabel[46] = new JLabel();//cuadro gris pregaunta
        arrayLabel[46].setOpaque(true);
        arrayLabel[46].setBounds(-520,280,230,33);
        arrayLabel[46].setBackground(Color.gray);

        arrayLabel[47] = new JLabel();//cuadro gris pregunta
        arrayLabel[47].setOpaque(true);
        arrayLabel[47].setBounds(-520,317,230,33);
        arrayLabel[47].setBackground(Color.gray);

        arrayLabel[48] = new JLabel();//cuadro gris pregunta
        arrayLabel[48].setOpaque(true);
        arrayLabel[48].setBounds(-520,353,230,33);
        arrayLabel[48].setBackground(Color.gray);

        arrayLabel[54] = new JLabel();//cuadro Ganador
        arrayLabel[54].setOpaque(true);
        arrayLabel[54].setFont(new Font("Arial",1,18));
        arrayLabel[54].setForeground(Color.white);
        arrayLabel[54].setBackground(Color.black);
        arrayLabel[54].setBounds(-520,0,0,0);
        arrayLabel[54].setHorizontalAlignment(SwingConstants.CENTER);

        arrayLabel[55] = new JLabel();//textoGanador
        arrayLabel[55].setOpaque(true);
        arrayLabel[55].setFont(new Font("Arial",1,18));
        arrayLabel[55].setBounds(-520,0,0,0);
        arrayLabel[55].setBackground(new Color(234,100,86, 0));
        arrayLabel[55].setHorizontalAlignment(SwingConstants.CENTER);

    }

    public void AssetsCandleBomb(int posX, int posY){ //x520 Y70
        arrayLabel[14] = new JLabel();
        arrayLabel[14].setOpaque(true);
        arrayLabel[14].setBackground(new Color(255,255,255));
        arrayLabel[14].setBounds(posX,posY,110,100);

        arrayLabel[15] = new JLabel();
        arrayLabel[15].setOpaque(true);
        arrayLabel[15].setBackground(new Color(255,255,255));
        arrayLabel[15].setBounds(posX+120,posY,110,100);

        arrayLabel[16] = new JLabel(imagenEntidades[0]);//candle
        arrayLabel[16].setOpaque(true);
        arrayLabel[16].setBackground(Color.black);
        arrayLabel[16].setBounds(posX+3,posY+3,104,94);

        arrayLabel[17] = new JLabel(imagenEntidades[1]);//bomb
        arrayLabel[17].setOpaque(true);
        arrayLabel[17].setBackground(Color.black);
        arrayLabel[17].setBounds(posX+123,posY+3,104,94);

        arrayLabel[20] = new JLabel(canS);//cantidad candle
        arrayLabel[20].setOpaque(true);
        arrayLabel[20].setBounds(posX,posY+100,110,20);
        arrayLabel[20].setForeground(Color.white);
        arrayLabel[20].setFont(new Font("Arial Black", 0 ,15));
        arrayLabel[20].setForeground(new Color(0,0,0));
        arrayLabel[20].setHorizontalAlignment(SwingConstants.CENTER);

        arrayLabel[11] = new JLabel("PRESIONA Z");//
        arrayLabel[11].setOpaque(true);
        arrayLabel[11].setForeground(new Color(225, 255, 255));
        arrayLabel[11].setBackground(new Color(68, 62, 62));
        arrayLabel[11].setFont(new Font("Arial",0,13));
        arrayLabel[11].setBounds(-1,-1,0,0);
        arrayLabel[11].setHorizontalAlignment(SwingConstants.CENTER);

        arrayLabel[21] = new JLabel(""+bombS);//cantidad bombs
        arrayLabel[21].setOpaque(true);
        arrayLabel[21].setBounds(posX+120,posY+100,110,20);
        arrayLabel[21].setForeground(Color.white);
        arrayLabel[21].setFont(new Font("Arial Black", 0 ,15));
        arrayLabel[21].setForeground(new Color(0,0,0));
        arrayLabel[21].setHorizontalAlignment(SwingConstants.CENTER);

        arrayLabel[44] = new JLabel("PRESIONA X");//
        arrayLabel[44].setOpaque(true);
        arrayLabel[44].setForeground(new Color(225, 255, 255));
        arrayLabel[44].setBackground(new Color(68, 62, 62));
        arrayLabel[44].setFont(new Font("Arial",0,13));
        arrayLabel[44].setBounds(-1,-1,0,0);
        arrayLabel[44].setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void AssetsPlace(int width_laberinto, int height_laberinto){
        add(arrayLabel[55]);//mensaje winner
        add(arrayLabel[54]);//cuadro winner
        add(arrayLabel[24]);//link1
        add(arrayLabel[25]);//link2
        add(arrayLabel[26]);//link3
        add(arrayLabel[49]);//link1_1
        add(arrayLabel[50]);//link2_1
        add(arrayLabel[51]);//link1_3
        add(arrayLabel[28]);
        add(arrayLabel[29]);//heart 1
        add(arrayLabel[30]);//heart 2
        add(arrayLabel[31]);//texto obtuviste
        add(arrayLabel[34]);//texto pregunta
        add(arrayLabel[33]);//barra negra
        add(arrayLabel[45]);//pregunta seleccion
        add(arrayLabel[46]);//cuadro gris pregunta
        add(arrayLabel[47]);//cuadro gris pregunta
        add(arrayLabel[48]);//cuadro gris pregunta
        add(arrayLabel[32]);//cuadro preguntas
        add(arrayLabel[35]);//tomb
        add(arrayLabel[36]);
        add(arrayLabel[37]);
        add(arrayLabel[39]);//fallaste
        add(arrayLabel[40]);//ganaste
        add(arrayLabel[52]);//cuadro gris ganaste/perdiste
        add(arrayLabel[53]);//play again
        add(arrayLabel[21]);//cantidad bombs
        add(arrayLabel[44]);
        add(arrayLabel[20]);
        add(arrayLabel[17]);
        add(arrayLabel[16]);
        add(arrayLabel[11]);
        add(arrayLabel[15]);
        add(arrayLabel[14]);
        add(arrayLabel[10]);
        add(arrayLabel[9]);//boton Jugador
        add(arrayLabel[8]);//regresar
        add(arrayLabel[12]);//presiona esc
        add(arrayLabel[7]);//L facil
        add(arrayLabel[13]);
        add(arrayLabel[3]);
        add(arrayLabel[2]);
        add(arrayLabel[5]);
        add(arrayLabel[4]);
        add(arrayLabel[1]);
        add(arrayLabel[6]);//fondo vida
        add(arrayLabel[27]);//fog
        add(arrayLabel[38]);//fog2
        add(arrayLabel[22]);//barra roja
        add(arrayLabel[23]);//barra roja 2
        AddTiles(width_laberinto,height_laberinto);
        add(arrayLabel[41]);//barra gif
        add(arrayLabel[42]);//PREIOSNA enter
        add(arrayLabel[43]);
        add(arrayLabel[0]);//backgroud
    }
    
    //elementos laverinto
    public void AgregarEnemigos(){

        for(j=0;j<4;j++){
            for(i=0;i<6;i++){
                switch(matEntities[j][i]){
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        matLabelEnteties[j][i].setBounds(80*i+25,80*j+55,80,80);
                        break;
                }
            }
        }
    }

    public void InicializarMat(){

        for(j=0;j<4;j++){
            for(i=0;i<6;i++){
                matEntities[j][i] = -1;
            }
        }
    }

    public void Tiles(){//pone las imagenes en los Labels adecuados

        imagenTile[0] = new ImageIcon("src/images/tile0.PNG");
        imagenTile[1] = new ImageIcon("src/images/tile1_1.PNG");
        imagenTile[2] = new ImageIcon("src/images/tile1_2.PNG");
        imagenTile[3] = new ImageIcon("src/images/tile1_3.PNG");
        imagenTile[4] = new ImageIcon("src/images/tile1_4.PNG");
        imagenTile[5] = new ImageIcon("src/images/tile2_1.PNG");
        imagenTile[6] = new ImageIcon("src/images/tile2_2.PNG");
        imagenTile[7] = new ImageIcon("src/images/tile2_3.PNG");
        imagenTile[8] = new ImageIcon("src/images/tile2_4.PNG");
        imagenTile[9] = new ImageIcon("src/images/tile3_1.PNG");
        imagenTile[10] = new ImageIcon("src/images/tile3_2.PNG");
        imagenTile[11] = new ImageIcon("src/images/tile4_1.PNG");
        imagenTile[12] = new ImageIcon("src/images/tile4_2.PNG");
        imagenTile[13] = new ImageIcon("src/images/tile4_3.PNG");
        imagenTile[14] = new ImageIcon("src/images/tile4_4.PNG");
    }

    public void InicializarArrayTiles(){
        for(i=0;i<50;i++){
            tipoTile[i]=0;
        }
    }

    public void AddTiles(int width,int height){
        for(j=0;j<height;j++){//agrega los labels
            for(i=0;i<width;i++){
                matLabelEnteties[j][i] = new JLabel(imagenEntidades[0]);
                matLabelEnteties[j][i].setBounds(-1000,0,0,0);
                this.add(matLabelEnteties[j][i]);

                matLabel[j][i] = new JLabel();
                matLabel[j][i].setBounds(-1000,80*j+55,80,80);
                this.add(matLabel[j][i]);
            }
        }
    }

    public void DibujaTileAndEntidades(int width, int height){
        for(j=0;j<height;j++){//dibujo de tiles
            for(i=0;i<width;i++){

                if(matEntities[j][i]==0){
                    matLabelEnteties[j][i].setIcon(imagenEntidades[0]);
                    matLabelEnteties[j][i].setBounds(80*i+25,80*j+55,80,80);
                }
                else if(matEntities[j][i]==1){
                    matLabelEnteties[j][i].setIcon(imagenEntidades[1]);
                    matLabelEnteties[j][i].setBounds(80*i+25,80*j+55,80,80);
                }
                else if(matEntities[j][i]==2){
                    matLabelEnteties[j][i].setIcon(imagenEntidades[2]);
                    matLabelEnteties[j][i].setBounds(80*i+25,80*j+55,80,80);
                }
                else if(matEntities[j][i]==3){
                    matLabelEnteties[j][i].setIcon(imagenEntidades[3]);
                    matLabelEnteties[j][i].setBounds(-1000,-1000,80,80);
                }
                else if(matEntities[j][i]==4){
                    matLabelEnteties[j][i].setIcon(imagenEntidades[4]);
                    matLabelEnteties[j][i].setBounds(-1000,-1000,80,80);
                }
                else if(matEntities[j][i]==5){
                    matLabelEnteties[j][i].setIcon(imagenEntidades[5]);
                    matLabelEnteties[j][i].setBounds(-1000,-1000,80,80);
                }
                else if(matEntities[j][i]==6){
                    matLabelEnteties[j][i].setIcon(imagenEntidades[6]);
                    matLabelEnteties[j][i].setBounds(-1000,-1000,80,80);
                }
                else{
                    matLabelEnteties[j][i].setIcon(imagen[9]);
                    matLabelEnteties[j][i].setBounds(-1000,-1000,80,80);
                }
                matLabel[j][i].setBounds(80*i+25,80*j+55,80,80);
            }
        }
    }

    public void CrearLaberinto(){
        a = -1;
        switch(numLav){//cada laverinto diferente
			/*WALLS: see /images
			  ITEMS: Nothing:a Candle:0 Bomb:1 Hearth:2
			  ENEMIES: K:3 S:4 T:5 D:6
			  TILES:  0 1 2 3 4 5
				     0* * * * * *
				     1* * * * * *
				     2* * * * * *
				     3* * * * * *
			*/
            case 1:
                InsertTypeTileWalls(13,5,10,10,6,13,9,11,5,6,4,2,4,10,2,8,7,9,7,12,3,14,12,7);
                InsertEnemiesAndItemsMatrix(4,a,a,a,a,a,
                                            a,1,3,a,a,a,
                                            a,a,a,a,a,a,
                                            a,a,a,a,0,a); break;
            case 2:
                InsertTypeTileWalls(12,10,6,12,1,14,5,6,9,13,9,13,9,9,8,0,3,2,7,8,10,7,12,7);
                InsertEnemiesAndItemsMatrix(a,a,1,0,a,a,
                                            a,a,a,a,a,a,
                                            a,4,3,a,a,a,
                                            a,a,a,a,0,a); break;
            case 3:
                InsertTypeTileWalls(5,1,6,5,10,6,9,9,8,7,13,9,11,11,5,10,3,2,10,10,7,12,10,7);
                InsertEnemiesAndItemsMatrix(a,a,3,a,a,a,
                                            1,a,a,a,0,a,
                                            a,0,a,4,a,a,
                                            a,a,a,a,a,a); break;
            default:
                System.out.println("Error en integer numLav(numero de laverinto): "+numLav);
                InsertTypeTileWalls(0,0,0,0,12,14,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
                InsertEnemiesAndItemsMatrix(a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a);
        }

    }
    
    public void InsertTypeTileWalls(int t1 , int t2 , int t3 , int t4 , int t5 , int t6 , int t7 , int t8, int t9 , int t10 , int t11 , int t12 , int t13 , int t14 , int t15 , int t16, int t17 , int t18 , int t19 , int t20 , int t21 , int t22 , int t23 , int t24){//creacion del laberinto
        for(i=1;i<=24;i++){//
            switch (i){
                case 1: tipoTile[i-1]=t1; break;
                case 2: tipoTile[i-1]=t2; break;
                case 3: tipoTile[i-1]=t3; break;
                case 4: tipoTile[i-1]=t4; break;
                case 5: tipoTile[i-1]=t5; break;
                case 6: tipoTile[i-1]=t6; break;
                case 7: tipoTile[i-1]=t7; break;
                case 8: tipoTile[i-1]=t8; break;
                case 9: tipoTile[i-1]=t9; break;
                case 10: tipoTile[i-1]=t10; break;
                case 11: tipoTile[i-1]=t11; break;
                case 12: tipoTile[i-1]=t12; break;
                case 13: tipoTile[i-1]=t13; break;
                case 14: tipoTile[i-1]=t14; break;
                case 15: tipoTile[i-1]=t15; break;
                case 16: tipoTile[i-1]=t16; break;
                case 17: tipoTile[i-1]=t17; break;
                case 18: tipoTile[i-1]=t18; break;
                case 19: tipoTile[i-1]=t19; break;
                case 20: tipoTile[i-1]=t20; break;
                case 21: tipoTile[i-1]=t21; break;
                case 22: tipoTile[i-1]=t22; break;
                case 23: tipoTile[i-1]=t23; break;
                case 24: tipoTile[i-1]=t24; break;
            }

        }
        ResetTipoTileImage(tipoTile);
        AjustarTipoTile(tipoTile);
    }

    public void ResetTipoTileImage(int x[]){
        for(j=0;j<4;j++){
            for(i=0;i<6;i++){
                matLabel[j][i].setIcon(imagen[9]);
                matParedes[j][i] = -1;
            }
        }
    }

    public void AjustarTipoTile(int x[]){
        c=0;
        for(j=0;j<4;j++){
            for(i=0;i<6;i++){
                matLabel[j][i].setIcon(imagenTile[x[c]]);
                matParedes[j][i] = x[c];
                c++;
            }
        }
    }

    public void InsertEnemiesAndItemsMatrix(int t1 ,int t2 ,int t3 ,int t4 ,int t5 ,int t6 ,int t7 ,int t8,int t9 ,int t10 ,int t11 ,int t12 ,int t13 ,int t14 ,int t15 ,int t16,int t17 ,int t18 ,int t19 ,int t20 ,int t21 ,int t22 ,int t23 ,int t24){
        for(j=0;j<4;j++){//
            for(i=0;i<6;i++){
                switch (j){
                    case 0:
                        switch (i){
                            case 0: matEntities[j][i] = t1; break;
                            case 1: matEntities[j][i] = t2; break;
                            case 2: matEntities[j][i] = t3; break;
                            case 3: matEntities[j][i] = t4; break;
                            case 4: matEntities[j][i] = t5; break;
                            case 5: matEntities[j][i] = t6; break;
                        }
                        break;
                    case 1:
                        switch (i){
                            case 0: matEntities[j][i] = t7; break;
                            case 1: matEntities[j][i] = t8; break;
                            case 2: matEntities[j][i] = t9; break;
                            case 3: matEntities[j][i] = t10; break;
                            case 4: matEntities[j][i] = t11; break;
                            case 5: matEntities[j][i] = t12; break;
                        }
                        break;
                    case 2:
                        switch (i){
                            case 0: matEntities[j][i] = t13; break;
                            case 1: matEntities[j][i] = t14; break;
                            case 2: matEntities[j][i] = t15; break;
                            case 3: matEntities[j][i] = t16; break;
                            case 4: matEntities[j][i] = t17; break;
                            case 5: matEntities[j][i] = t18; break;
                        }
                        break;
                    case 3:
                        switch (i){
                            case 0: matEntities[j][i] = t19; break;
                            case 1: matEntities[j][i] = t20; break;
                            case 2: matEntities[j][i] = t21; break;
                            case 3: matEntities[j][i] = t22; break;
                            case 4: matEntities[j][i] = t23; break;
                            case 5: matEntities[j][i] = t24; break;
                        }
                        break;
                }
            }

        }
    }

    public void EntitiesObjectTiles(){//entities
        imagenEntidades[0] = new ImageIcon("src/images/Candle.gif");
        imagenEntidades[1] = new ImageIcon("src/images/Bomb.gif");
        imagenEntidades[2] = new ImageIcon("src/images/Heart.gif");
        imagenEntidades[3] = new ImageIcon("src/images/T_keese.png");
        imagenEntidades[4] = new ImageIcon("src/images/T_Stalfos.png");
        imagenEntidades[5] = new ImageIcon("src/images/T_Tektite.png");
        imagenEntidades[6] = new ImageIcon("src/images/T_Darknut.png");
        imagenEntidades[7] = new ImageIcon("src/images/T_Tomb.png");
        imagenEntidades[8] = new ImageIcon("src/images/Link_1.png");
        imagenEntidades[9] = new ImageIcon("src/images/Link_2.png");
        imagenEntidades[10] = new ImageIcon("src/images/Link_3.png");
        imagenEntidades[11] = new ImageIcon("src/images/Link2_1.png");
        imagenEntidades[12] = new ImageIcon("src/images/Link2_2.png");
        imagenEntidades[13] = new ImageIcon("src/images/Link2_3.png");
    }



    //eventos juego

    public void ResetGameElements(){
        arrayLabel[31].setBounds(-200, 0, 80, 80);
        arrayLabel[31].setText("OBTUVISTE");
        arrayLabel[28].setBounds(-200, 0, 80, 80);
        arrayLabel[29].setBounds(-200, 0, 80, 80);
        arrayLabel[30].setBounds(-200, 0, 80, 80);
        arrayLabel[36].setBounds(-800, 0, 80, 80);
        arrayLabel[37].setBounds(-800, 0, 80, 80);
    }

    public void AddPlayerMovement(){
        switch(jugador_num){
            case 1:
                movimientos_P1++;
                arrayLabel[10].setText("  Movimientos: " + movimientos_P1);
                break;
            case 2:
                movimientos_P2++;
                arrayLabel[10].setText("  Movimientos: " + movimientos_P2);
                break;
        }
    }

    public void PlayerHitWall(int player_face){
        music.Play("src/music/Hit.wav");
        MovePlayerFace(player_face);
        AddPlayerMovement();
    }

    public void PlayerMoves(String XorY_direction, int player_face){

        if (moved == true) {
            switch (XorY_direction){
                case "Y-":
                    posY--; break;
                case "Y+":
                    posY++; break;
                case "X-":
                    posX--; break;
                case "X+":
                    posX++; break;
            }
            if (XorY_direction=="X-" && posX == -1 && posY == 3) {//si se movio a la izquierda, posible caso de ganar
                MovePlayerFace(3);
                Win();
            }
            else {//not win case
                AddPlayerMovement();
                switch (matEntities[posY][posX]) {
                    case -1://no entitie
                        MovePlayerFace(player_face);
                        music.Play("src/music/Low.wav");
                        CheckNoFogTurns();
                        break;
                    case 0://candle
                        PlayerGetCandle();
                        MovePlayerFace(player_face);
                        CheckNoFogTurns();
                        break;
                    case 1://bomb
                        PlayerGetBomb();
                        MovePlayerFace(player_face);
                        CheckNoFogTurns();
                        break;
                    case 2://heart
                        PlayerGetHeart();
                        break;
                    case 3://Enemies
                    case 4:
                    case 5:
                    case 6:
                        CheckNoFogTurns();
                        MovePlayerFace(4);
                        PlayerHitEnemy();
                        Preguntas();

                        break;
                }
            }
        }
        moved = false;
    }

    public void PlayerGetCandle(){
        music.Play("src/music/Item.wav");
        matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
        arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);//obtuviste
        arrayLabel[28].setBounds(80 * posX + 25, 80 * posY, 80, 80);//candle 2
        matEntities[posY][posX] = -1;
        candle++;
        canS = Integer.toString(candle);
        arrayLabel[20].setText(canS);
    }

    public void PlayerGetBomb(){
        music.Play("src/music/Item.wav");
        matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
        arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 38, 80, 80);
        arrayLabel[29].setBounds(80 * posX + 25, 80 * posY - 5, 80, 80);
        matEntities[posY][posX] = -1;
        bomb++;
        bombS = Integer.toString(bomb);
        arrayLabel[21].setText(bombS);
    }

    public void PlayerGetHeart(){
        if (vida == 2) {
            music.Play("src/music/Deflect.wav");
            arrayLabel[31].setText("VIDA LLENA");
            arrayLabel[31].setBounds(80 * posX + 23, 80 * posY - 18, 90, 80);
            arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
            MovePlayerFace(3);
            CheckNoFogTurns();
        } else {
            music.Play("src/music/GetHeart.wav");
            matLabelEnteties[posY][posX].setBounds(-200, 0, 80, 80);
            Corazon(1);
            arrayLabel[31].setBounds(80 * posX + 25, 80 * posY - 33, 80, 80);
            arrayLabel[30].setBounds(80 * posX + 25, 80 * posY, 80, 80);
            MovePlayerFace(3);
            CheckNoFogTurns();
        }
    }

    public void PlayerHitEnemy(){
        music.Play("src/music/Enemy.wav");
        play = false;
    }

    public void PlayerUseCandle(){
        if(candle!=0){
            music.Play("src/music/Candle.wav");
            fogTurns=3;
            Fog(1);
            candle--;
            canS = Integer.toString(candle);
            arrayLabel[20].setText(canS);
        }
        else{
            music.Play("src/music/Deflect.wav");
        }
    }

    public void PlayerUseBomb(){
        //System.out.println(preguntaActiva + " " +bomb);
        if(preguntaActiva==true && bomb!=0){
            music.Play("src/music/BombBlow.wav");
            play=true;
            matLabelEnteties[posY][posX].setBounds(-200,0,80,80);
            MovePlayerFace(1);
            matEntities[posY][posX] = -1;
            RemoveQuestionBox();
            preguntaActiva=false;
            current_question=1;
            bomb--;
            bombS = Integer.toString(bomb);
            arrayLabel[21].setText(""+bombS);
        }
        else if(play==true || preguntaActiva==true){
            music.Play("src/music/Deflect.wav");
        }
    }

    public void CheckNoFogTurns(){
        if (fogTurns > 0) {
            Fog(1);
            fogTurns--;
        } else Fog(0);
    }

    public void MoveQuestionSelect(){
        if (current_question>3) current_question=1;
        if (current_question<1) current_question=3;
        switch (current_question) {
            case 1: arrayLabel[45].setBounds(QuestionBoxPosX, QuestionBoxPosY+80, 230, 33); break;
            case 2: arrayLabel[45].setBounds(QuestionBoxPosX, QuestionBoxPosY+117, 230, 33); break;
            case 3: arrayLabel[45].setBounds(QuestionBoxPosX, QuestionBoxPosY+153, 230, 33); break;
        }
        music.Play("src/music/Low.wav");
    }

    public void QuestionSelected(){
        switch (current_question){
            case 1:
                switch(numPregunta){//inciso a
                    case 0: Correcto(false);
                        break;
                    case 1: Correcto(true);
                        break;
                    case 2: Correcto(false);
                        break;
                    case 3: Correcto(true);
                        break;
                    case 4: Correcto(false);
                        break;
                    default:System.out.println("no jalo");
                }
                RemoveQuestionBox();
                break;
            case 2:
                switch(numPregunta){//revisa si es correcta en cada pregunta
                    case 0: Correcto(true);
                        break;
                    case 1: Correcto(false);
                        break;
                    case 2: Correcto(true);
                        break;
                    case 3: Correcto(false);
                        break;
                    case 4: Correcto(false);
                        break;
                }
                RemoveQuestionBox();
                break;
            case 3:
                switch(numPregunta){//revisa si es correcta en cada pregunta
                    case 0: Correcto(false);
                        break;
                    case 1: Correcto(false);
                        break;
                    case 2: Correcto(false);
                        break;
                    case 3: Correcto(false);
                        break;
                    case 4: Correcto(true);
                        break;
                }
                RemoveQuestionBox();
                break;
        }
    }

    public void SetQuestionBox(int a){
        arrayLabel[32].setBounds(QuestionBoxPosX,QuestionBoxPosY,230,190);//cuadro pregunta
        arrayLabel[34].setBounds(QuestionBoxPosX+75,QuestionBoxPosY,100,20);//cuadro de texto
        arrayLabel[33].setBounds(QuestionBoxPosX,QuestionBoxPosY+65,230,10);
        arrayLabel[46].setBounds(QuestionBoxPosX,QuestionBoxPosY+80,230,33);//cuadro gris
        arrayLabel[47].setBounds(QuestionBoxPosX,QuestionBoxPosY+117,230,33);//cuadro gris
        arrayLabel[48].setBounds(QuestionBoxPosX,QuestionBoxPosY+153,230,33);//cuadro gris

        arrayLabel[45].setBounds(QuestionBoxPosX,QuestionBoxPosY+80,230,33);//cuadro seleccion

        matLabelPreguntas[a][0].setBounds(QuestionBoxPosX,QuestionBoxPosY+20,230,40);

        matLabelPreguntas[a][1].setBounds(QuestionBoxPosX,QuestionBoxPosY+80,230,33);
        matLabelPreguntas[a][1].setHorizontalAlignment(SwingConstants.CENTER);

        matLabelPreguntas[a][2].setBounds(QuestionBoxPosX,QuestionBoxPosY+117,230,33);
        matLabelPreguntas[a][2].setHorizontalAlignment(SwingConstants.CENTER);

        matLabelPreguntas[a][3].setBounds(QuestionBoxPosX,QuestionBoxPosY+153,230,33);
        matLabelPreguntas[a][3].setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void RemoveQuestionBox(){
        arrayLabel[34].setBounds(-100,0,0,0);//quita cuadro de pregunta
        arrayLabel[33].setBounds(-100,0,0,0);//barra negra
        arrayLabel[32].setBounds(-100,0,0,0);//cuadro de pregunta
        arrayLabel[45].setBounds(-100,0,0,0);//cuadro seleccion
        arrayLabel[46].setBounds(-520,280,230,33);
        arrayLabel[47].setBounds(-520,280,230,33);
        arrayLabel[48].setBounds(-520,280,230,33);
        matLabelPreguntas[numPregunta][0].setBounds(-520,220,230,40);
        matLabelPreguntas[numPregunta][1].setBounds(-520,280,230,33);
        matLabelPreguntas[numPregunta][2].setBounds(-520,317,230,33);
        matLabelPreguntas[numPregunta][3].setBounds(-520,353,230,33);
    }


    //eventos teclado
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyPressed(KeyEvent e) {
        if (released==true) {//Solo cuando se suelta la tecla

            //Playing events
            if (play == true) {
                ResetGameElements();
                switch (e.getKeyCode()) {
                    case 37: //izquierda
                        switch (matParedes[posY][posX]) {
                            case 4: case 5:	case 8: case 9: case 11: case 12: case 13:
                                PlayerHitWall(3);
                                break;
                            default:
                                moved = true;
                        }
                        PlayerMoves("X-",3);
                        break;

                    case 38: //arriba
                        switch (matParedes[posY][posX]) {
                            case 1: case 5: case 6: case 10: case 12: case 13: case 14:
                                PlayerHitWall(1);
                                break;
                            default:
                                moved = true;
                        }
                        PlayerMoves("Y-",1);
                        break;

                    case 39: //derecha
                        switch (matParedes[posY][posX]) {
                            case 2: case 6: case 7: case 9: case 11: case 13: case 14:
                                PlayerHitWall(2);
                                break;

                            default:
                                moved = true;
                        }
                        PlayerMoves("X+",2);
                        break;

                    case 40: //abajo
                        switch (matParedes[posY][posX]) {
                            case 3: case 7: case 8: case 10: case 12: case 11: case 14:
                                PlayerHitWall(1);
                                break;

                            default:
                                moved = true;
                        }
                        PlayerMoves("Y+",1);
                        break;

                    case 90: //x
                        PlayerUseCandle();
                        break;

                }
                released = false;
            }

            //Not playing events
            if (play == false){
                //Game can start events
                if (game_can_start==true){//start game case
                    switch (e.getKeyCode()) {
                        case 13:
                        case 10://enter both cases, while the game hasn't started
                        GameStart();
                        break;
                    }
                }

                //Question event
                else if (preguntaActiva==true){
                    switch (e.getKeyCode()){
                        case 38://arriba
                            current_question--;
                            MoveQuestionSelect();
                            break;
                        case 40://abajo
                            current_question++;
                            MoveQuestionSelect();
                            break;
                        case 13://ambos enter
                        case 10:
                            QuestionSelected();
                            break;
                    }
                }

                //Game over wait event
                else if (game_over==true){
                    switch (e.getKeyCode()) {
                        case 13:
                        case 10://enter
                            if (play_count==2) GameWinner();
                            else GameRestart(5,2);
                            break;
                    }
                }
            }

            //Eventos cualquier situacion
            switch (e.getKeyCode()) {//eventos de teclado en cualquier situacion
                case 27://esc
                    Inicio v = new Inicio();
                    v.setVisible(true);
                    this.setVisible(false);
                    break;
                case 88: //x
                    PlayerUseBomb();
                    break;
                case 90://z
                    if(preguntaActiva==true) music.Play("src/music/Deflect.wav");
                    break;
            }

            //System.out.println(e.getKeyCode()+" ");
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()) {
            default:
                released=true;
        }
    }

    public void MovePlayerFace(int a){
        switch(a){
            case 1://ariba, abajo
                if (jugador_num==1) {
                    arrayLabel[24].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                    arrayLabel[25].setBounds(-200, 0, 80, 80);
                    arrayLabel[26].setBounds(-200, 0, 80, 80);
                }
                if (jugador_num==2) {
                    arrayLabel[49].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                    arrayLabel[50].setBounds(-200, 0, 80, 80);
                    arrayLabel[51].setBounds(-200, 0, 80, 80);
                }
                break;
            case 2://derecha
                if (jugador_num==1) {
                    arrayLabel[24].setBounds(-200, 0, 80, 80);
                    arrayLabel[25].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                    arrayLabel[26].setBounds(-200, 0, 80, 80);
                }
                if (jugador_num==2) {
                    arrayLabel[49].setBounds(-200, 0, 80, 80);
                    arrayLabel[50].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                    arrayLabel[51].setBounds(-200, 0, 80, 80);
                }
                break;
            case 3://izquierda
                if (jugador_num==1) {
                    arrayLabel[24].setBounds(-200, 0, 80, 80);
                    arrayLabel[25].setBounds(-200, 0, 80, 80);
                    arrayLabel[26].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                }
                if (jugador_num==2) {
                    arrayLabel[49].setBounds(-200, 0, 80, 80);
                    arrayLabel[50].setBounds(-200, 0, 80, 80);
                    arrayLabel[51].setBounds(80 * posX + 25, 80 * posY + 55, 80, 80);
                }
                break;
            case 4://quitar todos
                arrayLabel[24].setBounds(-200,0,80,80);
                arrayLabel[25].setBounds(-200,0,80,80);
                arrayLabel[26].setBounds(-200,0,80,80);
                arrayLabel[49].setBounds(-200,0,80,80);
                arrayLabel[50].setBounds(-200,0,80,80);
                arrayLabel[51].setBounds(-200,0,80,80);
                break;

        }
    }

    public void LabelsPreguntas(){
        imagenPregunta[0] = new ImageIcon("src/images/preguntas/E1.PNG");
        imagenPregunta[1] = new ImageIcon("src/images/preguntas/E1_1.PNG");
        imagenPregunta[2] = new ImageIcon("src/images/preguntas/E1_2.PNG");
        imagenPregunta[3] = new ImageIcon("src/images/preguntas/E1_3.PNG");
        imagenPregunta[4] = new ImageIcon("src/images/preguntas/E2.PNG");
        imagenPregunta[5] = new ImageIcon("src/images/preguntas/E2_1.PNG");
        imagenPregunta[6] = new ImageIcon("src/images/preguntas/E2_2.PNG");
        imagenPregunta[7] = new ImageIcon("src/images/preguntas/E2_3.PNG");
        imagenPregunta[8] = new ImageIcon("src/images/preguntas/E3.PNG");
        imagenPregunta[9] = new ImageIcon("src/images/preguntas/E3_1.PNG");
        imagenPregunta[10] = new ImageIcon("src/images/preguntas/E3_2.PNG");
        imagenPregunta[11] = new ImageIcon("src/images/preguntas/E3_3.PNG");
        imagenPregunta[12] = new ImageIcon("src/images/preguntas/E4.PNG");
        imagenPregunta[13] = new ImageIcon("src/images/preguntas/E4_1.PNG");
        imagenPregunta[14] = new ImageIcon("src/images/preguntas/E4_2.PNG");
        imagenPregunta[15] = new ImageIcon("src/images/preguntas/E4_3.PNG");
        imagenPregunta[16] = new ImageIcon("src/images/preguntas/E5.PNG");
        imagenPregunta[17] = new ImageIcon("src/images/preguntas/E5_1.PNG");
        imagenPregunta[18] = new ImageIcon("src/images/preguntas/E5_2.PNG");
        imagenPregunta[19] = new ImageIcon("src/images/preguntas/E5_3.PNG");
    }

    public void AddAssetsPreguntas(){
        int c=0;
        for(j=0;j<5;j++){
            for(i=0;i<4;i++){
                matLabelPreguntas[j][i] = new JLabel(imagenPregunta[c]);
                this.add(matLabelPreguntas[j][i]);
                c++;
            }
        }
    }

    public void Preguntas(){
        int c=0,a,b;
        preguntaActiva=true;

        for(i=0;i<5;i++){//revisa que todas no se allan preguntado
            if(pregunta[i]==0) c++;
        }
        if(c==5){
            for(i=0;i<5;i++){
                pregunta[i]=1;
            }
        }
        c=0;
        do{//consigue una pregunta no usada anteriormente
            a = rand.nextInt(5);
            //System.out.println(a+" ran");
            b = pregunta[a];
            //System.out.println(b+" libre");
            //System.out.println(c+" contador");
            //c++;
        }while(b==0);

        pregunta[a]=0;

        SetQuestionBox(a);

        numPregunta=a;
    }

    public void Correcto(boolean acierto){
        if(acierto==true){
            music.Play("src/music/EnemyKill.wav");
            arrayLabel[36].setBounds(80*posX+10,80*posY+10,110,20);
            play=true;
            MovePlayerFace(1);
        }
        if(acierto==false){
            arrayLabel[37].setBounds(80*posX+10,80*posY+10,125,20);
            Corazon(-1);
            if(vida==1){
                music.Play("src/music/wrong.wav");
                play=true;
                MovePlayerFace(1);
            }
            if(vida==0){
                GameOver();
            }
        }
        matLabelEnteties[posY][posX].setBounds(-200,0,80,80);//quitar enemigo
        matEntities[posY][posX] = -1;//cuadro vacio

        current_question=1;
        preguntaActiva=false;
    }

    public void Fog(int a){
        if(a==0){//fog 1
            arrayLabel[27].setBounds(-690+(80*posX),-342+(80*posY),1500,870);
            arrayLabel[38].setBounds(-60000,0,1500,870);
        }
        if(a==1){//fog 2
            arrayLabel[27].setBounds(-60000,0,1500,870);
            arrayLabel[38].setBounds(-690+(80*posX),-342+(80*posY),1500,870);
        }
    }

    public void Corazon(int a){
        vidaAntigua=vida;
        vida=vida+a;
        if(vida==1 && vidaAntigua==2){
            arrayLabel[3].setBounds(0,-100,25,28);
        }
        if(vida==0 && vidaAntigua==1){
            arrayLabel[2].setBounds(0,-100,25,28);
        }
        if(vida==2 && vidaAntigua==1){
            arrayLabel[3].setBounds(105,5,25,28);
        }
		/*if(vida==1 && vidaAntigua==0){
			arrayLabel[2].setBounds(70,5,25,28);
		}*/
    }

    public void GameStart(){
        music.Play("src/music/Rupee.wav");
        play = true;
        AgregarEnemigos();
        arrayLabel[27].setBounds(-690 + (80 * posX), -342 + (80 * posY), 1500, 870);//fog

        arrayLabel[42].setBounds(-100,-100,0,0);//presiona enter
        arrayLabel[43].setBounds(-100,-100,0,0);
        arrayLabel[44].setBounds(CandleBombPosX+120,CandleBombPosY+120,110,22);
        arrayLabel[11].setBounds(CandleBombPosX,CandleBombPosY+120,110,22);

        game_can_start=false;
    }

    //game-over events

    public void GetWinner(){
        if (movimientos_P1<movimientos_P2){
            if (player1_die==false) {
                GameWinnerMessage("P1");
            }
            else if (player2_die==false){
                GameWinnerMessage("P2");
            }
            else GameWinnerMessage("none");
        }
        if (movimientos_P1>movimientos_P2){
            if (player2_die==false) {
                GameWinnerMessage("P2");
            }
            else if (player1_die==false){
                GameWinnerMessage("P1");
            }
            else GameWinnerMessage("none");
        }
        if (movimientos_P1==movimientos_P2){
            if (player2_die==false&&player1_die==true) {
                GameWinnerMessage("P2");
            }
            else if (player1_die==false&&player2_die==true){
                GameWinnerMessage("P1");
            }
            else GameWinnerMessage("none");
        }
    }

    public void GameWinnerMessage(String w){
        switch (w){
            case "P1":
                winner = "JUGADOR 1";
                arrayLabel[55].setForeground(new Color(25, 196, 6));
                break;
            case "P2":
                winner="JUGADOR 2";
                arrayLabel[55].setForeground(new Color(204, 20, 25));
                break;
            case "none":
                winner="EMPATE";
                arrayLabel[55].setForeground(new Color(15, 72, 187));
                break;
            default:
                System.out.println("Error con atributo winner: "+w);
        }

    }

    public void StringPlayerDead(){
        if (player1_die==true) player1_dead="Si";
        else player1_dead="No";

        if (player2_die==true) player2_dead="Si";
        else player2_dead="No";
    }
    public void GameWinner(){
        RemoveWinLoseAndLink();

        StringPlayerDead();

        GetWinner();

        arrayLabel[54].setText("<html>  JUGADOR 1:<br/>Movimientos: "+movimientos_P1+"<br/>Muerte: "+player1_dead+"<br/><br/>  JUGADOR 2:<br/>Movimientos: "+movimientos_P2+"<br/>Muerte: "+player2_dead+"<br/><br/><hr><br/><br/></html>");
        arrayLabel[54].setBounds(QuestionBoxPosX,QuestionBoxPosY,230,230);//cuadro ganador
        arrayLabel[55].setText("GANADOR: "+winner);
        arrayLabel[55].setBounds(QuestionBoxPosX,QuestionBoxPosY+200,230,20);
        movimientos_P1=0;
        movimientos_P2=0;
        play_count=0;
        player1_die=false;player2_die=false;
    }

    public void GameRestart(int posicionXPlayer, int life){
        game_can_start=true;
        game_over=false;
        candle=0;bomb=0;posX= posicionXPlayer;posY=0;vida=life;//movimientos_P1=0;moviminetos_P2=0;
        numLav++;
        play_count++;
        if(numLav>3) numLav=1;


        arrayLabel[2].setBounds(70,5,25,28);//corazon1 lleno
        arrayLabel[3].setBounds(105,5,25,28);//corazon2 lleno

        RemoveWinLoseAndLink();

        CrearLaberinto();
        DibujaTileAndEntidades(width_laberinto,height_laberinto);
        ResetPLayerPressEnterMessage();

        canS = Integer.toString(candle);
        bombS = Integer.toString(bomb);
        arrayLabel[20].setText(canS);//cantidad candle
        arrayLabel[21].setText(bombS);//cantidad  bombs

        switch (jugador_num){
            case 1:
                arrayLabel[24].setBounds(80*posX+25,80*posY+55,80,80);
                arrayLabel[10].setText("  Movimientos: "+ movimientos_P1); break;
            case 2:
                arrayLabel[49].setBounds(80*posX+25,80*posY+55,80,80);
                arrayLabel[10].setText("  Movimientos: "+ movimientos_P2); break;
        }
        //System.out.println("numlav:"+numLav+" Jugador:"+jugador_num);
    }

    public void ResetPLayerPressEnterMessage(){
        jugador_num++;
        if(jugador_num>2) jugador_num=1;
        switch(jugador_num){
            case 1:
                arrayLabel[9].setForeground(new Color(25, 196, 6));
                break;
            case 2:
                arrayLabel[9].setForeground(new Color(204, 20, 25));
                break;
        }
        arrayLabel[9].setText("JUGADOR "+jugador_num);
        arrayLabel[42].setBounds(270,445,150,35);//mensaje enter
        arrayLabel[43].setBounds(265,400,160,85);//parpadeo
    }

    public void SetWinLoseMessage(){
        if(vida<=0) arrayLabel[39].setBounds(QuestionBoxPosX+20,QuestionBoxPosY+50,200,36);//mensaje fallaste
        else arrayLabel[40].setBounds(QuestionBoxPosX+20, QuestionBoxPosY+50, 200, 36);//ganar mensaje
        arrayLabel[52].setBounds(QuestionBoxPosX+20,QuestionBoxPosY+50+36,200,30);
        arrayLabel[53].setBounds(QuestionBoxPosX+15,QuestionBoxPosY+45,210,76);
    }

    public void RemoveWinLoseAndLink(){
        arrayLabel[39].setBounds(-1000,-1000,200,38);//mensaje fallaste
        arrayLabel[40].setBounds(-1000,-1000,200,38);//mensaje ganaste
        arrayLabel[52].setBounds(-2270,0,0,0);//cuadro gris
        arrayLabel[53].setBounds(-2270,0,0,0);//play again gif
        arrayLabel[26].setBounds(-100,0,0,0);//link1_3
        arrayLabel[51].setBounds(-100,0,0,0);//link2_3
        arrayLabel[35].setBounds(-200,0,0,0);//tomb
        arrayLabel[54].setBounds(-100,0,0,0);//cuadro ganador
        arrayLabel[55].setBounds(-100,0,0,0);//cuadro ganador
    }

    public void GameOver(){
        game_over=true;
        play=false;
        music.Play("src/music/Die.wav");
        MovePlayerFace(4);
        arrayLabel[27].setBounds(2000,0,1500,870);
        arrayLabel[38].setBounds(2000,0,1500,870);
        arrayLabel[35].setBounds(80*posX+25,80*posY+55,80,80);//tomb
        arrayLabel[37].setBounds(-200,0,130,20);
        arrayLabel[36].setBounds(-200,0,130,20);
        SetWinLoseMessage();
        switch (jugador_num) {
            case 1:
                player1_die = true;
                break;
            case 2:
                player2_die = true;
                break;
        }
    }

    public void Win(){
        game_over = true;
        play = false;
        moved = false;
        music.Play("src/music/Escape.wav");

        arrayLabel[27].setBounds(-6000, 0, 1500, 870);//fog
        arrayLabel[38].setBounds(2000, 0, 1500, 870);//fog2 ??
        SetWinLoseMessage();

        arrayLabel[44].setBounds(-1,-1,0,0);//presiona x
        arrayLabel[11].setBounds(-1,-1,0,0);//presiona z

        //ResetPLayerPressEnterMessage();
    }
}