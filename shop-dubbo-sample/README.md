### 项目说明
- 服务接口
  - shop-api 服务接口（普通java接口，单独打包jar）
  
- 服务提供者
  - shop-service
    - user-service 用户服务（基于spring4.2.4实现）
    - product-service 商品服务（[基于springboot1.3.2与mybatis集成](http://blog.csdn.net/catoop/article/details/50684676)）
    - order-service 订单服务（基于springboot1.4.3与mybatis集成,采用高版本集成会简单很多,推荐使用）

- 服务消费者
  - shop-app 普通jar程序（基于spring实现）
  - shop-website 普通web程序（基于springmvc实现-[零配置](http://hanqunfeng.iteye.com/blog/2113820),需部署到Web容器）

- 依赖关系
  - 服务提供者 -----> 服务接口
  - 服务消费者 -----> 服务接口


### install:
- mvn install:install-file  -Dfile=../lib/dubbo-2.8.5-SNAPSHOT.jar  -DgroupId=com.alibaba  -DartifactId=dubbo -Dversion=2.8.5-SNAPSHOT -Dpackaging=jar
- mvn install:install-file  -Dfile=../lib/zkclient-0.8.1-SNAPSHOT.jar  -DgroupId=com.alibaba  -DartifactId=zkclient -Dversion=0.8.1-SNAPSHOT -Dpackaging=jar

### build：
- mvn clean package -pl shop-service/pom.xml -am
- mvn clean package -pl shop-web/pom.xml -am
- mvn clean package -pl shop-service/shop-api/pom.xml -amd

### run
0. 打包各项目,参考deploy-dubbo-sample示例
1. 先启动Zookeeper本地集群
2. 启动服务提供者
3. 启动服务消费者
4. 启动dubbo监控服务，dubbokeeper-server
5. 启动dubbo管理后台，dubbokeeper-ui

### IDEA插件
- [Mybatis Plugin破解](https://github.com/myoss/profile)
- Lombok plugin
- Markdown support
- CheckStyle
- FindBugs
- Maven Helper
- .ignore
- GsonFormat

### 文档
- [mybatis3](http://www.mybatis.org/mybatis-3/zh/index.html)
