package api_statistics_framework.version_3;

import api_statistics_framework.version_3.collector.MetricsCollector;
import api_statistics_framework.version_3.entity.ApiInfo;
import api_statistics_framework.version_3.reporter.ConsoleReporter;

/**
 * @author xuxiang
 */
public class TestMain {
    public static void main(String[] args) {
        MetricsCollector metricsCollector = new MetricsCollector();
        ConsoleReporter consoleReporter = new ConsoleReporter();
        consoleReporter.startRepeatableReport(20, 60);

        metricsCollector.collect(new ApiInfo("/login", 100, System.currentTimeMillis()));
        metricsCollector.collect(new ApiInfo("/login", 150, System.currentTimeMillis()));
        metricsCollector.collect(new ApiInfo("/register", 150, System.currentTimeMillis()));
        metricsCollector.collect(new ApiInfo("/register", 200, System.currentTimeMillis()));
    }
}
