### install:
- mvn install:install-file  -Dfile=../lib/dubbo-2.8.5-SNAPSHOT.jar  -DgroupId=com.alibaba  -DartifactId=dubbo -Dversion=2.8.5-SNAPSHOT -Dpackaging=jar
- mvn install:install-file  -Dfile=../lib/zkclient-0.8.1-SNAPSHOT.jar  -DgroupId=com.alibaba  -DartifactId=zkclient -Dversion=0.8.1-SNAPSHOT -Dpackaging=jar

### build：
- mvn clean package
