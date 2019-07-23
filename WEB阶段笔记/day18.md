=======================================回顾和复习
1）session
	1）概述：服务器端会话技术，依赖于cookie。作用是用来共享一次会话的多次请求间的数据的
	2）范围：一次会话
	3）共享数据的方法：
			存储：setAttribute(String name, Object value)
			获取：getAttribute(String name)
	4）session的类类型：HttpSession
	5）获取session对象：request.getSession()
			* getSession()	:如果没有，则先创建session对象，并且将session对象返回；如果有，则直接返回
	6）销毁session：
			* session过期了
			* 调用了session.invalidate()
			* 服务器关闭
	7）验证码：
			* 生成的验证码存储在哪里？	session
			* 验证码是一次性的？		是
			* 校验验证码的逻辑？
					* 获取session中存储的验证码数据，获取表单提交过来的验证码数据
					* 比较这两个验证码
							相同：验证码是争取的，可以进行下面的逻辑
							不同：验证码错误，返回登录页面
2）JSP
	1）JSP：Java服务器页面，是SUN公司推出的一个动态网页技术，替代servlet用来显示数据的短板
			实质上就是一个Servlet，执行过程：JSP --> Java --> class -->执行
	2）3：3个指令
			* page	：配置页面的参数的
			* include	：包含页面的
			* taglib	：引入标签库资源
	3）9：9个内置对象
			* pageContext
			* request
			* session
			* application
			* response
			* out
			* page
			* config
			* exception
	4）4：4个作用域
			* page域	：pageScope				页面范围
			* 请求域	：requestScope			一次请求内
			* 会话域	：sessionScope			一次会话内
			* 应用域	：applicationScope		整个web项目
3）MVC开发模式
	目的：分层解耦，提高效率
	思想：从软件架构的层面，将整个软件分成了三个模块：
			M(Model, 模型)	：主要进行数据封装、业务逻辑处理	JavaBean
			V(View, 视图)	：主要用来呈现数据		JSP
			C(Controller, 控制器)	：主要进行调度(让M和V联系起来)		Servlet

=======================================内容介绍
1）EL表达式【应用】
	1）格式：${表达式}
		* 注意：JSP的低版本默认是不支持EL表达式，要想支持就必须设置：isELIgnored="false"
				JSP的高版本默认是支持EL表达式，要想不支持设置：isELIgnored="true"	【常用】
	2）功能：用来替换JSP页面中的一些Java代码的，有：
			1）执行运算
					* 数学运算
					* 逻辑运算
					* 空运算
			2）获取作用域中的数据
					* JSP的作用域有四个，也就是EL表达式只能从这四个作用域中获取数据
					* ${键名称}【常用】，一次从page域、request域、session域、application域查找指定名称的数据，找到为止；如果找到了application域，还没有找到，则返回一个“”。
					  ${域名称.键名称}，从指定域找数据
					* 域名称：
						1. pageScope		--> pageContext
						2. requestScope 	--> request
						3. sessionScope 	--> session
						4. applicationScope --> application（ServletContext）
					* 获取对象的数据
						${user.username}	:获取作用域中名称为user的数据，调用这个数据对象的getUsername()方法获取username属性的值
					* List和Map的数据获取：
						List：一般使用EL表达式获取到这个list集合就OK，遍历我们会使用一些其他的办法：比如jstl标签
							${list[0]}	:表示获取list集合的第一个元素
						Map：获取数据的方式：
							${map.key}	:获取map中key对应的数据
							${map['key']}	:获取map中key对应的数据，如果key这个字符串中存在一些特殊符号，比如空格，只能使用这种方式比如：
								

2）JSTL标签【应用】
	1）功能：就是和EL表达式一起替换JSP中的Java代码
	2）介绍：JSP标准标签库，是Apache提供的，属于第三方。所以要在项目中使用就必须要引入相关的jar包
				javax.servlet.jsp.jstl.jar
				jstl-impl.jar
	3）使用jstl：
		* 必须在jsp页面中引入标签库(c标签，也叫做核心标签库)
				<%@ taglib prefix="前缀/别名" uri="标签库的路径"%>
		* 在jsp页面中使用：
				<前缀:标签>
		* 常用标签：
				c:if: 表示判断，没有else
						<c:if test="${number % 2 == 0 }"></c:if>
				c:choose: 表示switch..case..逻辑
					c:when
					c:otherwise
				c:forEach: 表示循环
					循环：<c:forEach begin="" end="" var=""></c:forEach>
					遍历集合：<c:forEach items="" var="" varStatus=""></c:forEach>
					练习：输出100-300的数字，如果这个数字是3的倍数，那么就给这个数字设置为蓝色。
		* jstl的版本
				1.0	:不支持el表达式		http://java.sun.com/jstl/core
				1.1/1.2	：支持el表达式【常用】	http://java.sun.com/jsp/jstl/core

	4）三层架构：
			1）三层架构是SUN公司提出的在开发Javaweb项目的时候所使用的的一个软件架构，它将整个软件分为三层
				web层(表现层)
				service层(业务层)
				dao层(数据访问层/持久层)
			2）三层架构也符合MVC的开发模式
			3）MVC开发模式是web(Javaweb/php/c#...)开发人员提出的一种软件架构
			4）三层架构下的Javaweb项目结构
					cn.itcast.proname					主目录，域名倒写(公司或者组织的名称, cn.itcast)和项目名称(proname)组成
								|---  web	web层
								|	   |---	servlet/controller		servlet目录
								|	   |---	listener				监听器目录
								|	   |---	filter					过滤器目录
								|---  service						service层，定义业务接口
								|      |--- impl					业务接口实现类
								|---  dao							dao层，定义数据访问接口
								|	   |--- impl					定义数据访问接口实现类
								|---  domain/entity					实体类
								|---  util							工具包
					* 面向接口编程，方便扩展和维护，以及底层切换
					
3）将数据表中的数据显示到JSP页面【掌握】
	1）需求：用户信息的增删改查
				本案例：只做用户信息查询
	2）使用作用域的原则：能小尽量小
	3）要想在jsp中显示数据库(真实)数据，一定需要先访问servlet，由servlet调用service获取数据，并且将数据通过作用域对象传递给jsp