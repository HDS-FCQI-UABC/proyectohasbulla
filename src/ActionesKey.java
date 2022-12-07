import frame.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionesKey extends LaberintoB implements KeyListener {
    //eventos teclado
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (released == true) {//Solo cuando se suelta la tecla

            //Playing events
            if (play == true) {
                ResetGameElements();
                switch (e.getKeyCode()) {
                    case 37: //izquierda
                        switch (matParedes[posY][posX]) {
                            case 4:
                            case 5:
                            case 8:
                            case 9:
                            case 11:
                            case 12:
                            case 13:
                                PlayerHitWall(3);
                                break;
                            default:
                                moved = true;
                        }
                        PlayerMoves("X-", 3);
                        break;

                    case 38: //arriba
                        switch (matParedes[posY][posX]) {
                            case 1:
                            case 5:
                            case 6:
                            case 10:
                            case 12:
                            case 13:
                            case 14:
                                PlayerHitWall(1);
                                break;
                            default:
                                moved = true;
                        }
                        PlayerMoves("Y-", 1);
                        break;

                    case 39: //derecha
                        switch (matParedes[posY][posX]) {
                            case 2:
                            case 6:
                            case 7:
                            case 9:
                            case 11:
                            case 13:
                            case 14:
                                PlayerHitWall(2);
                                break;

                            default:
                                moved = true;
                        }
                        PlayerMoves("X+", 2);
                        break;

                    case 40: //abajo
                        switch (matParedes[posY][posX]) {
                            case 3:
                            case 7:
                            case 8:
                            case 10:
                            case 12:
                            case 11:
                            case 14:
                                PlayerHitWall(1);
                                break;

                            default:
                                moved = true;
                        }
                        PlayerMoves("Y+", 1);
                        break;

                    case 90: //x
                        PlayerUseCandle();
                        break;

                }
                released = false;
            }

            //Not playing events
            if (play == false) {
                //Game can start events
                if (game_can_start == true) {//start game case
                    switch (e.getKeyCode()) {
                        case 13:
                        case 10://enter both cases, while the game hasn't started
                            GameStart();
                            break;
                    }
                }

                //Question event
                else if (preguntaActiva == true) {
                    switch (e.getKeyCode()) {
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
                else if (game_over == true) {
                    switch (e.getKeyCode()) {
                        case 13:
                        case 10://enter
                            if (play_count == 2) GameWinner();
                            else GameRestart(posicion_inicial_player, 2);
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
                    if (preguntaActiva == true) music.Play("src/music/Deflect.wav");
                    break;
            }

            //System.out.println(e.getKeyCode()+" ");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            default:
                released = true;
        }
    }
}
