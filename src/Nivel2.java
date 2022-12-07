public class Nivel2 extends ActionesKey{

    public Nivel2(){
        posicion_inicial_player=9;

        nivel=2;
        cant_preguntas=10;
        largo_pantalla=1100; alto_pantalla=660;
        setElements(10,6,50);

        frame("Nivel 2",largo_pantalla,alto_pantalla);
        addKeyListener(this);

        //if(numLav>3) numLav=1;
        EntitiesObjectTiles();//crea los imageIcon de los enemigos y objetos
        Tiles();//crea los imageIcon de los tiles

        InicializarMat();//inicializa matriz en 0
        InicializarArrayTiles();//inicializa array de los tiles en 0
        LabelsPreguntas();

        canS = Integer.toString(candle);
        bombS = Integer.toString(bomb);

        AddAssetsPreguntas();
        Assets("NORMAL","src/images/bkg2.PNG");//crea los assets basicos
        setBackgroundGrande();
        SetQuestionBoxPos(CandleBombPosX,CandleBombPosY);

        AssetsCandleBomb(CandleBombPosX,CandleBombPosY);//crea los assets de Candle y bomba
        AssetsPlace(width_laberinto,height_laberinto);//add todos assets necesarios

        numLav=0;
        jugador_num=0;
        play_count=0;
        GameRestart(posicion_inicial_player,2);
    }
}
