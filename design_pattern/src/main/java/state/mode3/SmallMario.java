package state.mode3;

/**
 * using singleton
 *
 * @author xuxiang
 */
public class SmallMario implements IMario {
    private static final SmallMario instance = new SmallMario();

    public static SmallMario getInstance() {
        return instance;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    @Override
    public void obtainMushRoom(MarioStateMachine stateMachine) {
        stateMachine.setCurrentMario(SuperMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape(MarioStateMachine stateMachine) {
        stateMachine.setCurrentMario(CapeMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower(MarioStateMachine stateMachine) {
        stateMachine.setCurrentMario(FireMario.getInstance());
        stateMachine.setScore(stateMachine.getScore() + 300);
    }
}
