
代理模式

dynamicproxy：使用 JDK 动态代理，生成一个类的代理，打印执行耗时日志（缺点：只能代理实现了接口的类）
dynamicproxyCglib：使用 CGlib 动态代理，生成一个类的代理，打印执行耗时日志（优点：可代理无接口类）

rpc：基于动态代理，将本地对接口的调用转为对远程的 socket 通信，即为“远程过程调用”！
核心类：
    - RpcServer：负责将服务通过 socket 进行暴露
    - RpcClient：负责通过动态代理将本地调用转到 socket

