package state.mode3;

/**
 * @author xuxiang
 */
public class CapeMario implements IMario {
    private static final CapeMario instance = new CapeMario();

    public static CapeMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.CAPE;
    }

    @Override
    public void meetMonster(MarioStateMachine stateMachine) {
        stateMachine.setCurrentMario(SmallMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() - 200);
    }
}
