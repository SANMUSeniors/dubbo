# dubbo
期末复习考试，好久没有更新博客。那就再来更新一次吧。

这个博客是在https://blog.csdn.net/Crazer_cy/article/details/80397649篇文章上的基础上，自己学习用的。

1.Zookeeper为dubbo的注册中心，dubbo服务的生产者和消费者都需要在Zookeeper进行注册；
2.下载zookeeper压缩包并解压；
3.进入conf目录将 zoo_sample.cfg 改名为 zoo.cfg；
4.进入bin目录双击zkServer.cmd，若启动成功，则windows单机版zookeeper搭建成功！ 

5.使用duboo-admin 
1.使用IntelliJ IDEA搭建Dubbo:创建一个maven空项目，作为项目的父工程
​​


2.在pom.xml添加以下公共的依赖：

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
 
    <groupId>com.dubbo</groupId>
    <artifactId>dubbo_demo</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>
 
    <properties>
        <motan.version>0.3.0</motan.version>
        <dubbo.version>2.5.3</dubbo.version>
        <dubbox.version>2.8.4</dubbox.version>
        <spring.version>4.3.6.RELEASE</spring.version>
        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>
 
    <dependencies>
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>dubbo</artifactId>
            <version>2.5.3</version>
            <exclusions>
                <exclusion>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>com.github.sgroschupf</groupId>
            <artifactId>zkclient</artifactId>
            <version>0.1</version>
        </dependency>
        <!-- spring相关 -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-orm</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jms</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>1.6.11</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.6.11</version>
        </dependency>
    </dependencies>
 
    <modules>
        <module>dubbo_api</module>
        <module>dubbo_consumer</module>
        <module>dubbo_provider</module>
    </modules>
</project>
3.在刚才创建的dubbo_demo下创建一个新的Module:dubbo_api（服务接口）



4.dubbo_api的pom.xml文件如下：

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>dubbo_demo</artifactId>
        <groupId>com.dubbo</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
 
    <modelVersion>4.0.0</modelVersion>
 
    <artifactId>dubbo_api</artifactId>
 
    <packaging>jar</packaging>
 
</project>
5.重复3、4步骤，创建dubbo_provider（服务生产者）,对应的pom.xml文件：

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>dubbo_demo</artifactId>
        <groupId>com.dubbo</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
 
    <artifactId>dubbo_provider</artifactId>
 
    <dependencies>
        <dependency>
            <groupId>com.dubbo</groupId>
            <artifactId>dubbo_api</artifactId>
            <version>1.0-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>
 
</project>
6.再重复3、4步骤，创建dubbo_consumer（服务消费者），对应pom.xml文件如下：

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>dubbo_demo</artifactId>
        <groupId>com.dubbo</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>
 
    <artifactId>dubbo_consumer</artifactId>
 
    <dependencies>
        <dependency>
            <groupId>com.dubbo</groupId>
            <artifactId>dubbo_api</artifactId>
            <version>1.0-SNAPSHOT</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>
 
</project>
7.最后项目结构如下：



8.框架搭建起来之后，开始写代码和配置文件，首先是dubbo_api：需要定义服务接口：

package com.api.service;
 
/**
 * 定义服务接口
 */
public interface DemoService {
    String sayHello(String name);
}
9.然后再dubbo_provider中实现上述接口（由于在pom.xml文件中，将dubbo_api作为依赖，故能引入上述接口）：

package com.provider.service;
 
import com.api.service.DemoService;
 
public class DemoServiceImpl  implements DemoService {
    public String sayHello(String name) {
        return "Hello "+name;
    }
}
10.dubbo_provider项目中的resource文件包含dubbo-provider.xml和springmvc.xml配置文件，其中dubbo-provider.xml如下：

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
    http://code.alibabatech.com/schema/dubbo
    http://code.alibabatech.com/schema/dubbo/dubbo.xsd">
 
    <!-- 提供方应用信息，用于计算依赖关系 -->
    <dubbo:application name="dubbo_provider"  />
 
    <!-- 使用zookeeper注册中心暴露服务地址 -->
    <dubbo:registry address="zookeeper://127.0.0.1:2181" />
 
    <!-- 用dubbo协议在20880端口暴露服务 -->
    <dubbo:protocol name="dubbo" port="20880" />
 
    <!-- 声明需要暴露的服务接口 -->
    <dubbo:service interface="com.api.service.DemoService" ref="demoService" />
 
    <!-- 接口实现类-->
    <bean id="demoService" class="com.provider.service.DemoServiceImpl"/>
 
</beans>
 
springmvc.xml如下：

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:util="http://www.springframework.org/schema/util" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop-4.0.xsd
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context-4.0.xsd
        http://www.springframework.org/schema/util
        http://www.springframework.org/schema/util/spring-util-4.0.xsd"
       default-autowire="byName">
 
    <aop:aspectj-autoproxy />
    <context:component-scan base-package="com" />
    <import resource="classpath:dubbo-provider.xml" />
</beans>
再在该工程下写一个测试类，后面测试用到：

package com.provider.test;
 
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import java.io.IOException;
 
public class ProviderTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:springmvc.xml");
        context.start();
 
        System.out.println("Dubbo provider start...");
 
        try {
            System.in.read();   // 按任意键退出
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
11.接下来开始写消费者——dubbo_consumer的代码和配置文件：resource中的dubbo-consumer.xml:

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:dubbo="http://code.alibabatech.com/schema/dubbo"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://code.alibabatech.com/schema/dubbo
        http://code.alibabatech.com/schema/dubbo/dubbo.xsd ">
    <!-- 消费方应用名，用于计算依赖关系，不是匹配条件，不要与提供方一样 -->
    <dubbo:application name="dubbo_consumer" />
    <!-- 使用multicast广播注册中心暴露发现服务地址 -->
    <dubbo:registry  protocol="zookeeper" address="zookeeper://127.0.0.1:2181" />
    <!-- 生成远程服务代理，可以和本地bean一样使用demoService -->
    <dubbo:reference id="demoService" interface="com.api.service.DemoService" />
</beans>
springmvc.xml:

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:util="http://www.springframework.org/schema/util" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/aop
        http://www.springframework.org/schema/aop/spring-aop-4.0.xsd
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans-4.0.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context-4.0.xsd
        http://www.springframework.org/schema/util
        http://www.springframework.org/schema/util/spring-util-4.0.xsd"
       default-autowire="byName">
 
    <aop:aspectj-autoproxy />
    <context:component-scan base-package="com" />
    <import resource="classpath:/dubbo-consumer.xml" />
</beans>
12然后写消费者的测试

package com.consumer;
 
import com.api.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import java.io.IOException;
 
public class ConsumerTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath:springmvc.xml" });
 
        context.start();
        DemoService demoService = (DemoService) context.getBean("demoService");
 
        System.out.println(demoService.sayHello("哈哈哈"));
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
13.到现在整个代码就开发完成了，按照先后顺序，首先启动Zookeeper：zkServer.cmd      然后启动服务生产者测试类，最后启动服务消费者的测试类，当控制台输出以下结果，则代表成功。

服务生产者测试类控制台输出：



服务消费者测试了控制台输出：



使用dubbo-admin管理平台查看运行情况。





