package state.mode3;

/**
 * @author xuxiang
 */
public interface IMario {
    State getName();

    // define events that mario may come across.
    // using default to provide default method.
    // refer MarioStateMachine so we can change the state and score.
    default void obtainMushRoom(MarioStateMachine stateMachine) {
    }

    default void obtainCape(MarioStateMachine stateMachine) {
    }

    default void obtainFireFlower(MarioStateMachine stateMachine) {
    }

    default void meetMonster(MarioStateMachine stateMachine) {
    }
}
