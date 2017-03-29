主要知识点：
1、springmvc（含静态资源过滤、请求timestamp str自动转换成timestamp对象）；
2、spring访问properties文件；
3、log4j2.0使用和配置；
4、spring unit test；
5、spring interceptor+threadlocal做latency检测;
6、UserAgentUtil；


静态资源的配置有两种方式：
1）web.xml配置，最高效，避免依赖spring框架来dispatch；
2）spring-mvc配置，最灵活，可以改变资源的物理存储位置；

web.xml中的加载顺序是：listener > filter > servlet