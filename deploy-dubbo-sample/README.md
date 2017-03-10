### install:
- mvn install:install-file  -Dfile=../lib/dubbo-2.8.5-SNAPSHOT.jar  -DgroupId=com.alibaba  -DartifactId=dubbo -Dversion=2.8.5-SNAPSHOT -Dpackaging=jar
- mvn install:install-file  -Dfile=../lib/zkclient-0.8.1-SNAPSHOT.jar  -DgroupId=com.alibaba  -DartifactId=zkclient -Dversion=0.8.1-SNAPSHOT -Dpackaging=jar

### build：
- mvn clean package -pl sample-consumer/web-client/pom.xml -am
- mvn clean package -pl sample-api/pom.xml -amd

### deploy
- dubbo-service 打包成单个可执行的jar(含依赖项)
- muti-service 打包成可执行的jar(依赖项拷贝到lib目录中)
- rest-service 打包成带执行脚本(.sh或.bat)的发布目录,内嵌tomcat运行
    - rest-service
        - bin  运行脚本
        - conf 配置文件
        - lib  jar包
- rest-service-web 打包成war包(需要放到servlet容器中,如:tomcat)
- dubbo-client 打包成带执行脚本(.sh或.bat)的发布目录
- web-client 打包成war包
