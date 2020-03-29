
实战：通用 api 接口统计框架设计

框架设计的要求：
    - 易扩展
    - 易用
    - 性能

prototype：一个最小原型的实现（有助于理解整个系统的设计，以小见大）
    统计用户注册和登录的统计：响应时间（最大、最小、平均）、访问次数
    需要把每个接口调用存起来，然后在一定时间间隔进行统计

从 prototype 可总结整个流程：
    1. 生成原始数据 （各种调用时间等）
    2. 数据存储 （内存、DB、MQ等）
    3. 从存储的数据进行统计 （求平均、最大、最小、count等）
    4. 将统计结果进行输出 （控制台、发邮件、html文本等）

可进行抽象的模块？
    - 数据采集
    - 存储
    - 聚合统计
    - 显示

## 类设计

- MetricsCollector 采集器（不用定义成接口，组合 数据存储接口 就行）
    - collect(接口信息)
- ApiInfo 接口信息
    - api
    - requestTime
    - responseTime
- MetricsStorage 数据存储 接口 （可以实现为 mysql存储、HBase存储）
    - save(接口信息)
    - List<接口信息> query(时间区间)  ???? 拿出来统计还是在存储器里面统计？
- Aggregator 聚合统计器
    - 统计项列表
    - addItem()
    - startReport()
- 统计项抽象
    - startItemStat(List<接口信息>)
- Reporter 显示 抽象类
    - metrics
    - output()


version_1：
作者的实现是 统计逻辑直接写在 Aggregator 中。好不好维护呢？
重构：report 提取 BaseReporter

