# utils基础库

1：AppUtils：meta-data数据获取，获取应用版本 包名 签名信息
2：DeviceUtils：获取设备标识符 语言 国家 mac地主 硬件信息
3：NetworkUtils：网络状态 wifi 数据网 是否可用
4：EncodeUtils：数据加密
5：FileUtils：文件读写
6：MmKvUtil：储存单例入口
7：PermissionUtils：权限检查 申请
8：PropertiesUtils：properties配置文件读写
9：ResUtils：res资源文件读取
10：Logger：日志工具


# MMKV 是腾讯开源的一款基于mmap内存映射的 key-value 组件，底层序列化/反序列化使用 protobuf 实现，性能高，稳定性强，从 2015 年中至今在微信上使用，其性能和稳定性经过了时间的验证。
# GitHub地址：https://github.com/Tencent/MMKV
# 为什么要替代SharedPreferences？
1，数据加密。 在 Android 环境里，数据加密是非常必须的，SP实际上是把键值对放到本地文件中进行存储。如果要保证数据安全需要自己加密，MMKV 使用了 AES CFB-128 算法来加密/解密。
2，多进程共享。系统自带的 SharedPreferences 对多进程的支持不好。现有基于 ContentProvider 封装的实现，虽然多进程是支持了，但是性能低下，经常导致 ANR。考虑到 mmap 共享内存本质上是多进程共享的，MMKV 在这个基础上，深入挖掘了 Android 系统的能力，提供了可能是业界最高效的多进程数据共享组件。
3，匿名内存。 在多进程共享的基础上，考虑到某些敏感数据(例如密码)需要进程间共享，但是不方便落地存储到文件上，直接用 mmap 不合适。而Android 系统提供了 Ashmem 匿名共享内存的能力，它在进程退出后就会消失，不会落地到文件上，非常适合这个场景。MMKV 基于此也提供了 Ashmem(匿名共享内存) MMKV 的功能。
4，效率更高。MMKV 使用protobuf进行序列化和反序列化，比起SP的xml存放方式，更加高效。
5，支持从 SP迁移，如果你之前项目里面都是使用SP，现在想改为使用MMKV，只需几行代码即可将之前的SP实现迁移到MMKV。
