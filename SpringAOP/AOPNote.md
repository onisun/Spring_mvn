## AOP: 面向切面编程

按照软件重构思想的理念，在OOP中通过抽象把相同的代码抽取到父类中（纵向抽取），但无法通过抽象父类的方式消除重复性的横切代码（如事务处理这种非业务性的重复代码），而AOP就是为了解决将分散在各个业务逻辑代码中的相同代码通过横向切割的方式抽取到一个独立的模块中。

AOP面向切面编程，并不是要替代OOP，仅做为OOP的有益补充。 利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发的效率。



OOP面向对象编程关注点在于对象，AOP面向切面编程关注点在于切面。

AOP只适应于有横切逻辑的特定场景，如：性能检测，访问控制，事务控制，日志记录等



### 什么是切面？

举个例子：我现在要实现一个删除功能，在Servlet里 调用了 业务逻辑层里的删除方法。而在业务逻辑层Service实现类里，需要在删除方法前进行权限检查，在删除方法后进行日志记录。那我就将权限检查和日志记录两个方法提取出来，放到单独的一个类里去 ，而不是跟删除的业务代码杂糅在一块。最后在通过AOP技术动态织入到删除方法周围。在service实现类里的删除方法就是切点/连接点（连接点范围更大，管符合一定条件规则的连接点叫切点）；而权限检查和日志记录就是切面；切面的工作内容叫做通知 同时通知也规定了什么时候执行切面。



### 3.AOP中的几个要素

1） Aspect ：切面，切入系统的一个切面。比如事务管理是一个切面，权限管理也是一个切面；

2） Join point ：连接点，也就是可以进行横向切入的位置；

3） Advice ：通知，切面在某个连接点执行的操作(分为: Before advice , After returning advice , After throwing advice , After (finally) advice , Around advice )；

4） Pointcut ：切点，符合切点表达式的连接点，也就是真正被切入的地方；



### 使用：

#### 引入命名空间：aop

```xml
xmlns:aop="http://www.springframework.org/schema/aop"
http://www.springframework.org/schema/aop
http://www.springframework.org/schema/aop/spring-aop.xsd
```

开启基于注解的aop的功能

```
<aop:aspectj-autoproxy/>
 <aop:config proxy-target-class="true"> 
 如果这样配置则是强制使用CGLIB方式进行代理不写或者设置为false默认使用 ： jdk方式进行代理
```



#### 定义切面类：

使用@Aspect注解

```java
@Component
@Aspect   //将该类设置为切面类
public class LogUtil { 
}
```



#### Execution表达式语法：

execution(<修饰符模式>？<返回类型模式><方法名模式>（<参数模式>）)<异常模式>？)

​	除了返回类型模式，方法名模式和参数模式外，其他项都是可选的

```
@Before("execution( public Integer com.onisun.service.impl.CalcImpl.*(..))")
public static void start(){
    System.out.println("方法开始执行：参数是");
}
//修饰符可以省略 *可以代替返回类型，表示任意返回类型 如：
//execution(* com.onisun.service.impl.CalcImpl.*(..))
//*只能匹配一层路径，如果项目路径下有多层目录，那么*只能匹配一层路径  
//参数可以使用..表示省略类型的可变参数
//除此之外，在表达式中还支持 &&、||、！的方式
```



#### 获取连接点的方法信息

需要在切入的方法中写入  JoinPoint 参数 如：

```java
@Before("execution( public Integer com.onisun.service.impl.CalcImpl.*(..))")
public static void start(JoinPoint joinPoint){
    Object[] args = joinPoint.getArgs();//获取所有参数
    String methodName = joinPoint.getSignature().getName();//获取方法名
    System.out.println(methodName + "方法开始执行：参数是" + Arrays.asList(args));
}
```



#### 获取返回值

```java
@AfterReturning(value = "execution( public Integer com.onisun.service.impl.CalcImpl.*(..))",returning = "result" )
public static void stop(JoinPoint joinPoint,int result){
    String methodName = joinPoint.getSignature().getName();
    System.out.println(methodName + "方法执行结束，结果是：" + result);
}
```



#### 表达式的抽取

在使用过程中，我们发现每个方法上面的表达式都是一样的，那么我们就可以进行抽取

j将@PointCut注解定义到一个空方法上

```java
    @Pointcut("execution( public Integer com.onisun.service.impl.CalcImpl.*(..))")
    public void myPointCut(){
    }

//    @Before("execution( public Integer com.onisun.service.impl.CalcImpl.*(..))")
    @Before("myPointCut()")
    public static void start(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "方法开始执行：参数是" + Arrays.asList(args));
    }
```



#### 多切面运行的顺序

在spring中，默认是按照切面名称的字典顺序进行执行的，但是如果想自己改变具体的执行顺序的话，可以使用@Order注解来解决，数值越小，优先级越高。

```java
@Component
@Aspect
@Order(2)
public class LogUtil {
}
```

```java
@Component
@Aspect
@Order(1)
public class SecurityAspect {

}
```

SecurityAspect类的@Order值较小，所以SecurityAspect类的切面会先执行

