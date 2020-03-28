package entity;

/**
 * @Author xuxiang
 * @Date 2020/3/28
 */
public class ApiStatInfo {
    private String api;
    private long requestCount;
    private long errorCount;
    private long timeoutCount;
    private long durationSeconds;

    public ApiStatInfo(String api, long requestCount, long errorCount, long timeoutCount, long durationSeconds) {
        this.api = api;
        this.requestCount = requestCount;
        this.errorCount = errorCount;
        this.timeoutCount = timeoutCount;
        this.durationSeconds = durationSeconds;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public long getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }

    public long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(long errorCount) {
        this.errorCount = errorCount;
    }

    public long getTimeoutCount() {
        return timeoutCount;
    }

    public void setTimeoutCount(long timeoutCount) {
        this.timeoutCount = timeoutCount;
    }

    public long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }
}
