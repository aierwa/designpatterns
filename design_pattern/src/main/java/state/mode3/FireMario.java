package state.mode3;

/**
 * @author xuxiang
 */
public class FireMario implements IMario {
    private static final FireMario instance = new FireMario();

    public static FireMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.FIRE;
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentMario(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 300);
    }
}
