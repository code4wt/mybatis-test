# mybatis-test

## 1.简介

《一本小小的MyBatis源码分析书》一书的附属源码，该书以电子书的形式发布，可免费下载。下载途径如下：

百度网盘：[点击下载](https://pan.baidu.com/s/1d0JTkab0gHOApXrMUbHGuQ)

百度文库：[审核中，这里先放上我的个人主页](https://wenku.baidu.com/u/coolblog_xyz)

CSDN: [点击下载](https://download.csdn.net/download/weixin_43179483/10658977)

<img src="http://blog-pictures.oss-cn-shanghai.aliyuncs.com/shuji.png" width="200px"/>



## 2. 代码使用说明

mybatis-test 项目的文件结构大致如下：

```
.
├── sql
│   └── myblog.sql
├── src
    ├── main
    │   ├── java    
    │   └── resources
    └── test
        ├── java
        └── resources
```

使用步骤如下：

1. 执行 sql/myblog.sql 脚本，导入数据到数据库中
2. 修改 test/resources/log4j.properties 文件，将数据库配置改为你所使用的数据库
3. 执行 test/java/ 文件夹下的测试代码进行测试
