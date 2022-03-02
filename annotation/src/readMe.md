## **Spring中的4种注解**

​	@Controller
​	@Service
​	@Repository
​	@Component
4个注解完成的功能都是一直的，我们习惯给不同的层添加不同的注解，以作区分



**使用注解**

​	添加以上注解的任意一个

​	添加自动扫描注解组件需要依赖的Context命名空间

​	添加自动扫描的标签：context:component-scan



使用的注解默认情况是单例的，如果需要使用多例，可以在注解下添加@Scope注解



配置自动扫描：

```xml
  <context:component-scan base-package="com.onisun" use-default-filters="true">
<!--        <context:exclude-filter type="assignable" expression="com.onisun.dao.PersonDao"/>-->
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
```

base-package：表示扫描哪个包下的注解

use-default-filters: 默认是true 表示扫描该包下的所有注解 

exclude-filter：排除要扫描的组件

​		type:

​				assignable:指定排除某个类

​				annotation：指定排除某个注解

include-filter：指定要扫描的组件



## **自动注入@Autowired**

​	自动注入有3种方式：

​		通过Field注入

```
@Autowired
private PersonService personService;
```

​		通过构造器注入

```
@Autowired
public PersonController(PersonService personService) {
    this.personService = personService;
}
```

​		通过setter注入

```
@Autowired
public void setPersonService(PersonService personService) {
    this.personService = personService;
}
```



![image-20220302215532859](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220302215532859.png)



在通过字段注入的时候idea提示Field injection is not recommended(不推荐使用字段注入)

在一个类出现了大量依赖的时候，通常意味着这个类需要承担更多的责任，这**明显违背了单一职责设计原则**，使用字段注入不容易发现这样的危险信号

参考：https://www.jianshu.com/p/36db3e167958



**注意：**

Spring会在项目启动的过程中，自动调用一次加了@Autowired注解的方法，我们可以在该方法做一些初始化的工作。





## **自动注入@Autowired和@Resource的区别**

1.@Autowired是Spring提供的注解，只适用于Spring框架中使用，@Resource是JDK的，扩展性更好

2.@Autowired默认是按照类型(byType) 进行装配的，默认情况下要求依赖的对象必须存在，@Resource默认是按照名称(byName)进行装配的，同时可以指定name属性



以下摘自知乎：https://www.zhihu.com/question/39356740

@Autowired默认按byType自动装配，而@Resource默认byName自动装配。

@Autowired只包含一个参数：required，表示是否开启自动准入，默认是true。而@Resource包含七个参数，其中最重要的两个参数是：name 和 type。

@Autowired如果要使用byName，需要使用@Qualifier一起配合。而@Resource如果指定了name，则用byName自动装配，如果指定了type，则用byType自动装配。

@Autowired能够用在：构造器、方法、参数、成员变量和注解上，而@Resource能用在：类、成员变量和方法上。

@Autowired是spring定义的注解，而@Resource是JSR-250定义的注解。

**@Autowired的装配顺序如下：**

![img](https://pic3.zhimg.com/80/v2-add99da54a13637ee3ff586724a0357f_720w.jpg?source=1940ef5c)

**@Resource的装配顺序如下：**

1.  如果同时指定了name和type：

    ![image-20220302222959729](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220302222959729.png)



1.  如果指定了name：

![image-20220302223036692](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220302223036692.png)



1.  如果指定了type：

![img](https://pic1.zhimg.com/50/v2-24b42f928aeeedb85bde4c7c1dda554c_720w.jpg?source=1940ef5c)



1.  如果既没有指定name，也没有指定type：

![img](https://pic1.zhimg.com/50/v2-95ca59f07a4ccdb6deedbbd95c426332_720w.jpg?source=1940ef5c)



作者：苏三说技术
链接：https://www.zhihu.com/question/39356740/answer/1907479772
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

------------------------------------------------------------------------------------------------------------------------------------



