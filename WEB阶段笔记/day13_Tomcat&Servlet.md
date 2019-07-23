=======================================回顾和复习
1）BootStrap
	组件：导航条、分页条
	插件：轮播图
2）XML：
	1）XML简介
		：可扩展标记语言，使用标签来构造一些事情。所有的标签都是自定义的，主要是用来存储数据的(1、网络传输；2、配置文件)
	2）XML基本语法
		：基本语法：
		：组成
		：约束，DTD、Schema
	3）XML解析
		1）思想：DOM	SAX
		2）常见xml的解析器
			JAXP、DOM4j、Jsoup、PULL
	4）JSoup
		1）步骤：
			* 读取xml文件到内存，得到Document对象
			* 通过Document获取Element
			* 通过Element获取属性和文本
		2）对象：
			* Jsoup.parse()
			* Document.getElementById()
			* Element/Elements
			* Element.attr()/ELement.text()
			* select()

=======================================内容介绍
1）Jsoup的xpath语法【应用】
	* xpath，xml的路径语法。
	* jsoup中要使用xpath，必须要引入一个jar包：JsoupXpath-0.3.2.jar，并且Document对象要进行一次包装：
			Document document = Jsoup.parse(new File(path), "utf-8");	//Document不支持xpath
			JXDocument jxDocument = new JXDocument(document);	//jxDocument支持xpath
	* xpath语法
			//student	:所有的student标签元素
			//student[@id='itcat']	:所有的student元素，并且有属性id，并且值是itcast

2）web相关概念的复习【理解】
	* 软件架构：
			C/S		B/S
	* web应用的组成：
			web客户端：一般都是由浏览器充当
			web服务器：1）只有经过web服务器发布的资源，我们才能通过网络去访问
					   2）web服务器发布的资源有两类
					   			静态资源：html、css、js、image、..., 浏览器能直接解析
								动态资源：servlet/jsp,必须经过服务器，先将动态资源转换为静态资源，然后浏览器才能解析。
	* 网络通讯的三要素
		1） IP	：唯一确定网络中的一台设备(计算机)
		2） 端口 ：唯一确定设备上的一个应用
		3） 传输协议 ：客户端和服务器端要进行通讯，就必须遵守的规范
				TCP协议/UDP协议
	
	* JavaWeb：使用java语言开发的基于网络的应用

	* JavaEE：使用Java开发企业级应用中要遵守的规范，共计13项。

	* web服务器：一台安装了web服务器软件的高配电脑。主要的功能：发布web应用，让用户能使用浏览器来访问。
			1）web服务器软件：
					Tomcat	：Apache基金组织  免费的  开源的  轻量的 【练习用】
					WebLogic	：收费的，支持JavaEE所有规范
					WebSphere	：收费的，支持JavaEE所有规范
					JBoss		：部分服务是收费
			2）Tomcat：
					安装：解压即可(Tomcat的解压缩目录建议不要有中文、空格等特殊字符)
					启动：双击 bin/startup.bat
						  可能在启动时报错：
						  		* 黑窗口一闪而过：
								* 启动报错(端口被占用)：
					访问：在浏览器输入：http://localhost:8080	,localhost代表自己的电脑，8080是tomcat的默认端口
					目录：bin	：二进制可执行文件的存放目录。
						  conf	：配置文件目录
						  logs	：日志目录
						  lib	：运行时依赖的jar
						  temp	：临时数据文件
						  webapps ：发布web应用的目录
						  work	：运行动态资源时，产生的临时文件
					发布web应用【掌握】
						1） 直接将项目放到webapps目录下即可。
							* /hello：项目的访问路径-->虚拟目录
							* 简化部署：将项目打成一个war包，再将war包放置到webapps目录下。
								* war包会自动解压缩

						2） 配置conf/server.xml文件
							在<Host>标签体中配置
							<Context docBase="D:\hello" path="/hehe" />
								* docBase:项目存放的路径
								* path：虚拟目录

						3） 在conf\Catalina\localhost创建任意名称的xml文件。在文件中编写
							<Context docBase="D:\hello" />
								* 虚拟目录：xml文件的名称
	* 动态web项目的目录结构：
			website
				|-----WEB-INF
						|-----web.xml
						|-----classes
						|-----lib

	* Idea中集成Tomcat
		1）配置tomcat到Idea
		2）在Idea中创建web应用
		3）将web应用部署到tomcat，启动Tomcat
				访问路径：http://localhost:8080/虚拟目录/资源名称

3）Servlet入门
	1）概述：运行在服务器端的一个小的java程序，主要用来接收浏览器的请求，并对请求作出响应。
			 要接收浏览器的请求那么这个java程序就必须得实现JavaEE的一个规范：Servlet
	2）快速入门：
			1）Servlet的创建【掌握】
					前提：JavaWeb项目
					1）创建一个类，实现javax.servlet.Servlet接口，就会实现5个方法，其中，我们只关注service方法即可
					2）配置servlet
							目的：再浏览器中访问一个资源名称的时候，能执行这个Servlet
							配置：在web.xml中：
								<!--配置Servlet -->
								<servlet>
									<servlet-name>demo1</servlet-name>
									<servlet-class>cn.itcast.web.servlet.ServletDemo1</servlet-class>
								</servlet>
								<servlet-mapping>
									<servlet-name>demo1</servlet-name>
									<url-pattern>/demo1</url-pattern>
								</servlet-mapping>
			2）执行原理：
					1） 当服务器接受到客户端浏览器的请求后，会解析请求URL路径，获取访问的Servlet的资源路径
					2） 查找web.xml文件，是否有对应的<url-pattern>标签体内容。
					3） 如果有，则在找到对应的<servlet-class>全类名
					4） tomcat会将字节码文件加载进内存，并且创建其对象
					5） 调用其方法
			3）生命周期：
					1）涉及到生命周期的方法
							init	:servlet创建的时候被执行，只执行一次
							service	:servlet提供服务的时候被执行，每一次访问都会被执行一次
							destroy	:servlet销毁之前执行，执行一次
					2）生命周期：
							何时创建：默认首次访问servlet时被创建。如果定义了<load-on-startup>并且值是正整数，从2开始，这个时候servlet是在服务器启动的时候创建
											<load-on-startup>的值越小，表示servlet越先被创建
							何时销毁：服务器正常关闭，调用destroy方法销毁

			4）Servlet 3.0的注解开发
					1）servlet 3.0以及以上版本才支持Servlet的注解开发。即我们在创建web项目的时候，JavaEE版本最低要选择JavaEE6
					2）使用了注解开发，那么tomcat的版本必须是7以及以上版本
							tomcat 6.x-	：支持的是servlet 2.5规范
							tomcat 7.x+ ：支持Servlet3.0以及以上规范
					3）@WebServlet
							用法：在servlet类上，直接定义：@WebServlet("资源路径")
					4）如果使用注解开发，就可以不需要web.xml

4）Idea的使用
	1）每次创建一个新的web工程，Idea就会默认将这个web工程部署到tomcat中
	2）Idea中创建的web工程和tomcat中运行的工程不是一个
			* tomcat真正访问的是“tomcat部署的web项目”，"tomcat部署的web项目"对应着"工作空间项目" 的web目录下的所有资源
	3）WEB-INF目录下的资源不能被浏览器直接访问。


