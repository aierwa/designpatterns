
演示如何 通过编写单元测试 来 重构代码

一个极简的 电商系统 交易类

6 个测试用例：
- 正常情况下，交易执行成功，回填用于对账（交易与钱包的交易流水）用的 walletTransactionId，交易状态设置为 EXECUTED，函数返回 true。
- buyerId、sellerId 为 null、amount 小于 0，返回 InvalidTransactionException。
- 交易已过期（createTimestamp 超过 14 天），交易状态设置为 EXPIRED，返回 false。
- 交易已经执行了（status==EXECUTED），不再重复执行转钱逻辑，返回 true。
- 钱包（WalletRpcService）转钱失败，交易状态设置为 FAILED，函数返回 false。
- 交易正在执行着，不会被重复执行，函数直接返回 false。

重构前的代码不是很好编写完善的单元测试
重构后的代码比较好编写