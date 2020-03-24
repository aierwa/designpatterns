# 目的
设计并实现一个积分兑换系统
# 需求设计
## 功能点梳理
- 积分获取
    - 积分获取渠道：订单、签到等
    - 积分获取规则：订单金额值即为积分值；每日签到一次即获取10个积分
- 积分消费
    - 积分消费渠道：订单抵现、优惠券兑换
    - 积分消费规则：订单100个积分抵 1 元；100 个积分可换取 5 元的优惠券
- 积分查询
    - 总积分查询
    - 积分获取及消费明细查询
- 其他
    - 积分有过期机制，过期的积分不能使用
## 用户用例
积分获取：
- 用户下单成功后，根据订单金额，向用户增加积分
- 用户签到成功后，向用户增加积分

积分消费：
- 下单时支持是否用积分抵用部分订单金额
- 优惠券可以使用积分兑换
- 积分消费只能消费在有效期内的
- 消费的积分不能大于用户剩余积分数

积分查询
- 可查询总积分、可用积分、已过期积分
- 可查询积分明细，包括获取和消费积分的明细
- 积分明细能够查看其过期时间和是否已过期


# 系统设计
##划分模块
划分原则：
- 单一职责原则
- 高内聚，低耦合
- 避免业务知识的耦合（比如积分系统不应该知道订单系统的知识）

如下：
- 业务系统（如订单系统、签到系统等），发生操作时，将需要增减积分的信息通知到消息中间件
- 营销系统，订阅积分增减的消息，收到后通过积分兑换规则，计算出需要增减的积分，并调用积分系统的接口操作
- 积分系统，提供操作接口，如增加积分、消费积分、查询积分等

##模块之间的交互
业务系统 -> 消息中间件 <- 营销系统 -> 积分系统；
对于查询来说，可直接调用积分系统得到积分明细。

##接口、数据库、业务模型
接口：

| 接口 | 参数 | 返回 |
|:----:|:----:|:----:|
|赚取积分|userId, channelId, eventId, credit, expiredTime|积分明细id|
|消费积分|userId, channelId, eventId, credit, expiredTime|积分明细id|
|查询积分|userId|总可用积分|
|查询总积分明细|userId, 分页参数|id, userId, channelId, eventId, credit, createTime, expiredTime|
|查询赚取积分明细|userId, 分页参数|id, userId, channelId, eventId, credit, createTime, expiredTime|
|查询消费积分明细|userId, 分页参数|id, userId, channelId, eventId, credit, createTime, expiredTime|

数据库-积分明细表：

|字段|描述|
|----|----|
|id|明细id|
|user_id|用户id|
|channel_id|赚取或消费的渠道id|
|event_id|相关事件id，如订单id，签到记录id|
|credit|积分值，正数为赚取，负数为消费|
|create_time|创建时间|
|expired_time|过期时间|
