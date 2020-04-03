
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


# version_1

- MetricsCollector 负责采集
- MetricsStorage 负责存和取数据
- Aggregator 负责聚合统计（工具类）
- ConsoleReporter 和 EmailReporter 相当于是个上帝类（God Class），组合各种功能（定时 取数据 + 聚合统计 + 输出）

作者的实现是 统计逻辑直接写在 Aggregator 中。好不好维护呢？
自己想的重构：report 提取 BaseReporter


# version_2

着重看一下 Aggregator ConsoleReporter EmailReporter
- Aggregator:
    - 把统计项的函数进行封装（方便添加新函数功能）
    - 支持 api 为 key 的 map 型数据，丰富功能
    - 从只提供静态函数的工具类 转换为 普通类，提高可测试性
- ConsoleReporter EmailReporter
    - 将显示逻辑独立出来，StatView 类，方便修改维护
    - 形成了 存储 + 统计 + 显示 三类各司其职的结果，结构更清晰
    - Reporter 类只负责组装流程，然后提供定时触发功能

# version_3
- 解决 ConsoleReporter EmailReporter 代码重复问题
- 性能问题？
    - collect 时的存储性能：改为异步，引入 guava eventBus
    - storage.getApiInfos 数据太大问题：分段统计，再聚合（代码要稍微复杂一些）









