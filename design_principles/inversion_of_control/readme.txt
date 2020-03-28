
控制反转，IOC，Inversion Of Control
将控制器移交给第三方（框架）

# 实例
## 需求
一个简易的测试框架

## 类设计
- TestCase：测试用例 抽象类
    - run()
    - doTest()

- JunitApplication
    - static testCaseList
    - register(TestCase testCase)
    - run()
