### install:
- mvn install:install-file  -Dfile=../lib/dubbo-2.8.5-SNAPSHOT.jar  -DgroupId=com.alibaba  -DartifactId=dubbo -Dversion=2.8.5-SNAPSHOT -Dpackaging=jar
- mvn install:install-file  -Dfile=../lib/zkclient-0.8.1-SNAPSHOT.jar  -DgroupId=com.alibaba  -DartifactId=zkclient -Dversion=0.8.1-SNAPSHOT -Dpackaging=jar

### build：
- mvn clean package -pl shop-service/pom.xml -am
- mvn clean package -pl shop-web/pom.xml -am
- mvn clean package -pl shop-service/shop-api/pom.xml -amd

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


### 项目说明
- product-service
  > [低版本springboot与mybatis集成](http://blog.csdn.net/catoop/article/details/50684676)
