package rule;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class ApiRule {
    private String api;
    private long maxTps;
    private long maxErrorCount;
    private long maxTimeoutTps;

    public ApiRule(String api, long maxTps, long maxErrorCount, long maxTimeoutTps) {
        this.api = api;
        this.maxTps = maxTps;
        this.maxErrorCount = maxErrorCount;
        this.maxTimeoutTps = maxTimeoutTps;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public long getMaxTps() {
        return maxTps;
    }

    public void setMaxTps(long maxTps) {
        this.maxTps = maxTps;
    }

    public long getMaxErrorCount() {
        return maxErrorCount;
    }

    public void setMaxErrorCount(long maxErrorCount) {
        this.maxErrorCount = maxErrorCount;
    }

    public long getMaxTimeoutTps() {
        return maxTimeoutTps;
    }

    public void setMaxTimeoutTps(long maxTimeoutTps) {
        this.maxTimeoutTps = maxTimeoutTps;
    }
}
