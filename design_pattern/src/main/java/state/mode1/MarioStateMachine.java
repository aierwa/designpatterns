package state.mode1;

/**
 * using if-else to transfer state
 * if state is much more, it's not maintainable
 *
 * @author xuxiang
 */
public class MarioStateMachine {
    private int score;
    private State currentState;


    public MarioStateMachine() {
        score = 0;
        currentState = State.SMALL;
    }

    public void obtainMushRoom() {
        if (currentState == State.SMALL) {
            currentState = State.SUPER;
            score += 100;
        }
    }

    public void obtainCape() {
        if (currentState == State.SMALL || currentState == State.SUPER) {
            currentState = State.CAPE;
            score += 200;
        }
    }

    public void obtainFireFlower() {
        if (currentState.equals(State.SMALL) || currentState.equals(State.SUPER)) {
            currentState = State.FIRE;
            score += 300;
        }
    }

    public void meetMonster() {
        if (currentState.equals(State.SUPER)) {
            this.currentState = State.SMALL;
            this.score -= 100;
            return;
        }

        if (currentState.equals(State.CAPE)) {
            this.currentState = State.SMALL;
            this.score -= 200;
            return;
        }

        if (currentState.equals(State.FIRE)) {
            this.currentState = State.SMALL;
            this.score -= 300;
            return;
        }
    }

    public int getScore() {
        return score;
    }

    public State getCurrentState() {
        return currentState;
    }
}
