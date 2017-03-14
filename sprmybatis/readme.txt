主要知识点：
1、spring+mybatis+pagehelper;
2、spring transaction;
3、spring dao test and auto rollback;
4、multi-datasource and read write separated;
5、alibaba druid connection pool；


关于mybatis多个数据源的配置：
case 1:
不同数据源且表和业务对象都不同
可以把dao和mapping文件拆分到不同package，
然后配置不同的datasource、sessionFactory和transaction manager，之后代码使用跟但数据源一致，
唯一不同是在使用事务管理器时需指定管理器：@Transactional("xxx")
见示例配置：keep-spring-jdbc-multi.xml

case2：
读写分离，数据库实例不一样但是表和业务对象都一样
然后配置不同的datasource、sessionFactory和transaction manager，以及SqlSessionTemplate：

    <bean id="sqlSessionTemplateMaster" class="org.mybatis.spring.SqlSessionTemplate" scope="prototype">
        <constructor-arg index="0" ref="sqlSessionFactory1"/>
    </bean>
    
    <bean id="sqlSessionTemplateSlave" class="org.mybatis.spring.SqlSessionTemplate" scope="prototype">
        <constructor-arg index="0" ref="sqlSessionFactory2"/>
    </bean>
    
之后在使用到dao的service类中如下使用：
    @Resource
    private App_info_Mapper rdao;
    
    @Resource
    private App_info_Mapper wdao;
    
    @Resource(name = "sqlSessionTemplateMaster")
    public void setWdao(SqlSession sqlSession) {
        this.wdao = sqlSession.getMapper(App_info_Mapper.class);
    }
    
    @Resource(name = "sqlSessionTemplateSlave")
    public void setRdao(SqlSession sqlSession) {
        this.rdao = sqlSession.getMapper(App_info_Mapper.class);
    }
    
见示例配置：keep-spring-jdbc-rw.xml    