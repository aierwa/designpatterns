package state.mode3;


/**
 * using state design pattern
 *
 * @author xuxiang
 */
public class MarioStateMachine {

    private int score;
    private IMario currentMario;

    public MarioStateMachine() {
        score = 0;
        currentMario = SmallMario.getInstance();
    }

    public void obtainMushRoom() {
        currentMario.obtainMushRoom(this);
    }

    public void obtainCape() {
        currentMario.obtainCape(this);
    }

    public void obtainFireFlower() {
        currentMario.obtainFireFlower(this);
    }

    public void meetMonster() {
        currentMario.meetMonster(this);
    }


    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentMario.getName();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentMario(IMario currentMario) {
        this.currentMario = currentMario;
    }
}
