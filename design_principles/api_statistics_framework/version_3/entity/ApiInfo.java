package api_statistics_framework.version_3.entity;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class ApiInfo {
    private String api;
    private long responseTime;
    private long timestamp;

    public ApiInfo(String api, long responseTime, long timestamp) {
        this.api = api;
        this.responseTime = responseTime;
        this.timestamp = timestamp;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "ApiInfo{" +
                "api='" + api + '\'' +
                ", responseTime=" + responseTime +
                ", timestamp=" + timestamp +
                '}';
    }
}
