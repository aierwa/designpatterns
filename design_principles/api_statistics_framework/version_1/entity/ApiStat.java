package api_statistics_framework.version_1.entity;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class ApiStat {
    private long maxResponseTime;
    private long minResponseTime;
    private double avgResponseTime;
    private long p999ResponseTime;
    private long p99ResponseTime;
    private long count;
    private double tps;

    public long getMaxResponseTime() {
        return maxResponseTime;
    }

    public void setMaxResponseTime(long maxResponseTime) {
        this.maxResponseTime = maxResponseTime;
    }

    public long getMinResponseTime() {
        return minResponseTime;
    }

    public void setMinResponseTime(long minResponseTime) {
        this.minResponseTime = minResponseTime;
    }

    public double getAvgResponseTime() {
        return avgResponseTime;
    }

    public void setAvgResponseTime(double avgResponseTime) {
        this.avgResponseTime = avgResponseTime;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public double getTps() {
        return tps;
    }

    public void setTps(double tps) {
        this.tps = tps;
    }

    public long getP999ResponseTime() {
        return p999ResponseTime;
    }

    public void setP999ResponseTime(long p999ResponseTime) {
        this.p999ResponseTime = p999ResponseTime;
    }

    public long getP99ResponseTime() {
        return p99ResponseTime;
    }

    public void setP99ResponseTime(long p99ResponseTime) {
        this.p99ResponseTime = p99ResponseTime;
    }
}
