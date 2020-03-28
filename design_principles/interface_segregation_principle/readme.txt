
接口隔离原则，ISP，Interface Segregation Principle
不要依赖不需要的接口

# 实例

## 需求
程序中用到了几种服务的配置：redis，kafka，mysql
需要 redis 和 kafka 能够自动更新
需要 redis 和 mysql 能够被监控（即能输出配置）

## 类设计
- Updater 接口
    - update()
- Viewer 接口
    - output()
    - outputPlainText()

- RedisConfig
- KafkaConfig
- MysqlConfig

- ScheduleUpdater：周期更新
    - executor
    - initialDelay
    - periodSeconds
    - updater
    - run()

- SimpleHttpServlet：开启一个 servlet 容器

RedisConfig 和 KafkaConfig 实现 Updater 接口。
RedisConfig 和 MysqlConfig 实现 Viewer 接口。

## 总结
将 Updater Viewer 接口分开，比如 KafkaConfig 就不要去依赖不需要的 Viewer 接口， MysqlConfig 不去依赖不需要的 Updater 接口。