package command;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xuxiang
 * 2020/4/30
 */
public class GameApplication {
    private static final int MAX_HANDLED_REQ_COUNT_PER_LOOP = 100;
    private Queue<Command> commands = new LinkedList<>();

    public void mainloop() {
        while (true) {

            // transfer requests to commands...
            // This logic is similar to Strategy or Factory
            // commands.add(new GotDiamondCommand());

            int handleCount = 0;
            while (handleCount < MAX_HANDLED_REQ_COUNT_PER_LOOP) {
                if (commands.isEmpty()) {
                    break;
                }
                Command command = commands.poll();
                command.execute();
                handleCount++;
            }

        }
    }
}
