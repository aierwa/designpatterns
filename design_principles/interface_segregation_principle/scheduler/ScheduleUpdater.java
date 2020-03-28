package interface_segregation_principle.scheduler;

import interface_segregation_principle.inter.Updater;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class ScheduleUpdater {
    private int initialDelay;
    private int periodSeconds;
    private Updater updater;
    private ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    public ScheduleUpdater(Updater updater, int initialDelay, int periodSeconds) {
        this.initialDelay = initialDelay;
        this.periodSeconds = periodSeconds;
        this.updater = updater;
    }

    public void run() {
        executor.scheduleAtFixedRate(() -> updater.update(), initialDelay, periodSeconds, TimeUnit.SECONDS);
    }

}
