# 配置
修改  `application-dev.yml.example` 文件为`application-dev.yml`进行使用


# maven 启动
1.使用idea自带工具启动

2.使用`mvn spring-boot:run`启动

3.使用`mvn install`编译,然后进入target目录中运行
`java -jar xxx.jar`,使用指定配置文件进行启动
`java -jar target/xxx.jar --spring.profile.active=prod`

# 注解
`@Value` 读取配置

`@Compace` 自动注入配置

`@ConfigurationProperties` 配置文件类

`@Controller` 处理http请求

`@RestController` Spring4之后新加的注解,原来返回json需要`@ResponseBody`配合`@Controller`

`@PathVariable` 获取URL中的参数

`@RequestParam` 获取请求参数

`@GetMapping` 组合注解

# 测试

1.maven 打包的时候自动测试
2.使用IDEA进行测试

跳过单元测试:mvn clean package -Dmaven.test.skip=true

# Git
git clone git@github.com:z1577121881/girl01.git