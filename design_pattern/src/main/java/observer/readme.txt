
观察者模式

scene1： 用户注册 运用观察者模式
    - 注册后 发放体验金
    - 注册后 发送站内信

scene2： 手动实现 EventBus
核心类：
    - EventBus：同步总线
    - AsyncEventBus：异步总线
    - Subscribe：定义订阅
    - ObserverAction：类及函数方法的信息对象类
    - ObserverRegistry：存储注册 消息类型 和 可接受类函数 的映射信息

