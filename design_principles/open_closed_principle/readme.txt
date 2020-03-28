
设计原则：开闭原则 OCP （Open Closed Principle）
对扩展开放，对修改关闭


示例：Api 接口监控报警

类设计：

- AlertRule：告警规则，可自由设置
    - apiRules
    - addApiRule(ApiRule apiRule)
    - getMatchedRule(String api)

- ApiRule：单个 api 接口的规则
    - api
    - maxTps
    - maxErrorCount
    - maxTimeoutTps
    - ...

- AlertHandler：告警处理抽象类
    - alertRule
    - notification
    - handle(ApiStatInfo apiStatInfo)

- Notification：通知类，及如何告警，告警方式
    - messageSenders
    - notify(AlertLevel alertLevel, String message)

- AlertMessageSender：消息发送抽象类
    - alertLevel
    - send(String message)
- ShortMessageSender
- MailMessageSender
- KafkaMessageSender
- ...

- AlertLevel：告警级别，不同级别对于不同通知方式，短信，邮件等。
    - code
    - isHigher(AlertLevel alertLevel)

- ApiStatInfo
    - api
    - requestCount
    - errorCount
    - durationSeconds
    - timeoutCount

- Alert：告警入口
    - alertRule
    - alertHandlers
    - initHandlers()
    - getInstance()
    - check(ApiStatInfo apiStatInfo)


总结：
- 抽象规则
- 抽象告警处理：根据规则，达到一定规则，触发通知告警，并且告警时表名告警的级别
- 抽象通知：通知就做一件事，把信息分发到各个发送端
- 抽象发送端（模板设计模式）：发送端有自己的默认告警级别，通知分发过来的级别高于自己定义的级别，就发送该消息，否则不发送
- 抽象告警级别：状态类，只比较级别高低
