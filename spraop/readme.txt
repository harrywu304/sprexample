该示例演示了3种不同的方式来使用AOP：
1、使用aop:aspect配置；
2、使用自定义的advice和aop:advisor;
3、使用annotation;  (需通过spring配置 <aop:aspectj-autoproxy/> 开启）

方法1最简单但是实际用途不大，因为缺少必要的参数传递；
方法2最使用，稍微麻烦一点点；
方法3使用方便，功能满足；
实际使用可以考虑2/3方法；

使用Around可以对方法进行加强；

注意：
springaop有个大前提，被增强对象必须是ioc容器的bean。
所以，可以增强不是自己写的类，但得把它配置为bean。


在数据库访问中的aop应用实例：

    <!-- 拦截器方式配置事物 -->
    <tx:advice id="transactionAdvice" transaction-manager="transactionManager">
        <tx:attributes>
            <tx:method name="get*" propagation="SUPPORTS"/>
            <tx:method name="find*" propagation="SUPPORTS"/>
            <tx:method name="load*" propagation="SUPPORTS"/>
            <tx:method name="search*" propagation="SUPPORTS"/>
            <tx:method name="datagrid*" propagation="SUPPORTS"/>
            <tx:method name="select*" propagation="SUPPORTS"/>
            <tx:method name="*" propagation="REQUIRED" rollback-for="Exception"/>
        </tx:attributes>
    </tx:advice>

    <aop:config>
        <aop:pointcut id="transactionPointcut"
                      expression="execution(* com.fangdd.base.auth.service.*.*(..))"/>
        <aop:advisor pointcut-ref="transactionPointcut"
                     advice-ref="transactionAdvice"/>
    </aop:config>
    
    
    <!-- 配置druid监控spring jdbc -->
    <bean id="druid-stat-interceptor"
          class="com.alibaba.druid.support.spring.stat.DruidStatInterceptor">
    </bean>
    <bean id="druid-stat-pointcut" class="org.springframework.aop.support.JdkRegexpMethodPointcut"
          scope="prototype">
        <property name="patterns">
            <list>
                <value>
                    com.fangdd.base.auth.service.*
                </value>
                <value>com.fangdd.base.auth.dao.*</value>
            </list>
        </property>
    </bean>

    <aop:config>
        <aop:advisor advice-ref="druid-stat-interceptor" pointcut-ref="druid-stat-pointcut"/>
    </aop:config>