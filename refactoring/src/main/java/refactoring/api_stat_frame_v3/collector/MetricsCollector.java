package refactoring.api_stat_frame_v3.collector;


import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import refactoring.api_stat_frame_v3.entity.ApiInfo;
import refactoring.api_stat_frame_v3.storage.MetricsStorage;
import refactoring.api_stat_frame_v3.storage.RedisMetricsStorage;

import java.util.concurrent.Executors;

/**
 * @Author xuxiang
 * @Date 2020/3/29
 */
public class MetricsCollector {
    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 10;
    private MetricsStorage metricsStorage;
    private EventBus eventBus;

    public MetricsCollector() {
        this(new RedisMetricsStorage());
    }

    public MetricsCollector(MetricsStorage metricsStorage) {
        this(metricsStorage, DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }

    public MetricsCollector(MetricsStorage metricsStorage, int storageThreadSize) {
        this.metricsStorage = metricsStorage;
        // define eventBus
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(storageThreadSize));
        // register an eventListener
        this.eventBus.register(new EventListener());

    }

    public void collect(ApiInfo apiInfo) {
        // 采集数据，进行存储
        if (apiInfo == null || apiInfo.getApi() == null || "".equals(apiInfo.getApi())) {
            return;
        }

        this.eventBus.post(apiInfo);
    }

    public class EventListener {
        @Subscribe
        public void saveApiInfo(ApiInfo apiInfo) {
            metricsStorage.saveApiInfo(apiInfo);
        }
    }
}
