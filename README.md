## 人事管理系统
## v0.6-snapshot
### 完成的功能
1. 员工管理基本功能实现
2. 部门管理基本功能实现
3. 统一了返回结构
4. 添加了aop日志打印
### 问题
1. MyBatis-Plus 与 Spring Boot 3.x 版本兼容性问题
   参考https://blog.csdn.net/qq_57682309/article/details/149295836 解决
2. delete和insert方法不成功
   @Transactional(readOnly = true)只读写在了最外层
   外层删掉写到里面解决
3. status字段是枚举类型,用cast as解决
   status=CAST(#{status} AS emp_status)
4. 添加逻辑删除,以及一些字段的正常接收映射解析
5. 解决typehandler不能使用的问题
