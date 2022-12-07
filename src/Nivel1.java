
public class Nivel1 extends ActionesKey{

    public Nivel1(){
        posicion_inicial_player=5;

        nivel=1;
        cant_preguntas=5;
        largo_pantalla=780; alto_pantalla=530;
        setElements(6,4,50);

        frame("Nivel 1",largo_pantalla,alto_pantalla);
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
        Assets("FACIL","src/images/bkg1.PNG");//crea los assets basicos
        SetQuestionBoxPos(CandleBombPosX,CandleBombPosY);

        AssetsCandleBomb(CandleBombPosX,CandleBombPosY);//crea los assets de Candle y bomba
        AssetsPlace(width_laberinto,height_laberinto);//add todos assets necesarios

        numLav=0;
        jugador_num=0;
        play_count=0;
        GameRestart(posicion_inicial_player,2);
    }
}