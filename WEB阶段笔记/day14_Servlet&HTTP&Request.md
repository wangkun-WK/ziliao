=======================================回顾和复习
1）JSoup中使用XPath
	1）明确原有的Jsoup不支持xpath，如果需要使用xpath，那么就需要引入一个jar
	2）Document document = Jsoup.parse(file, "UTF-8");
	   JxDocument doc = JxDocument(document);
	3）//book	:
	   //book[@id] :
	   //book[@id="val"] :
2）Web的相关概念
	1）常见的软件架构：
			C/S:
			B/S:
	2）web服务器资源
			B/S结构的软件：
					web服务器：
					web客户端：
			web服务器中可以发布的资源：
					静态资源：
					动态资源：
	3）网络通讯的三要素：
			IP	:确定网络中的唯一一台设备(计算机)
			Port	:确定服务器上唯一的一个程序
			传输协议	:规定浏览器和服务器通讯的规则
3）Tomcat服务器
	1）服务器：
	2）常见服务器软件：
	3）使用Tomcat
		1）目录结构
				bin		：
				conf	：
				lib		：
				logs	：
				temp	：
				webapps	：
				work	：
		2）Tomcat发布web项目的三种方式
			1）直接复制项目到webapps下
			2）在conf/server.xml中<Host>节点下添加<Context docBase="" path="">
			3）在conf/Catalina/localhost下，建立一个xml文件，内容<Context docBase="">
4）Servlet
	1）什么是Servlet？
	2）如何创建Servlet？
			1）建立一个类，实现Servlet的接口
			2）配置
					xml配置方式：
						web.xml中：<servlet>和<servlet-mapping>
					注解方式：
						在类上直接定义@WebServlet("路径")
	3）生命周期
			init		：
			service		：
			destroy		：
	4）执行流程

=======================================内容介绍
1）Servlet
	1）Servlet体系结构
		GenericServlet:和协议无关的Servlet，实现了servlet接口，将service方法抽象定义
		HttpServlet:和http协议相关的Servlet，将service方法重写，在service方法中根据请求方式的不同调用对应的doXxx()

		问题：如何优化Servlet的编写？
			* 定义类继承HttpServlet
			* 复写doGet/doPost方法

	2）Servlet配置
		1）1个servlet是可以配置多个映射路径的，不推荐
		2）路径配置的规则：【掌握】
			* /xxxx		:完全路径配置
			* /xxx/xxx	:目录配置，	有两个特殊情况： /*, /user/*
			* *.扩展名	:扩展名配置

2）Http协议【理解】
	* 概述：Hyper Text Transfer Protocol 超文本传输协议，定义了，客户端和服务器端通信时，发送数据的格式
	* 特点：1. 基于TCP/IP的高级协议
			2. 默认端口号:80
			3. 基于请求/响应模型的:一次请求对应一次响应
			4. 无状态的：每次请求之间相互独立，不能交互数据
	* 版本：
			* 1.0：每一次请求响应都会建立新的连接
			* 1.1：复用连接【现在在用的版本】
			* 2.0：
	1）请求(Request)：
		* 格式
			* 请求行
				1）格式：请求方式 请求url 请求协议/版本
				2）GET请求和POST请求的区别？
			* 请求头
				1）格式：请求头名称:请求头的值
				2）常见的请求头：
						User-Agent	：用它来判断客户端所是有的浏览器的类型
						Referer	：表示了请求当前资源的这个请求从哪里来
			* 请求空行
				分隔请求头和请求体的符号
			* 请求体【只有POST请求才有】
				Post请求的请求参数
3）Request对象(HttpServletRequest)
	原理：1）request和response对象都是由web容器创建
		  2）开发人员使用这两个对象：
		  			1）使用request来获取请求消息数据
					2）使用response来获取响应消息数据
	1）创建：有服务器创建的
	2）方法【掌握】
			String getContextPath()
			String getHeader(String headerName)	:注意headerName不区分大小写的。
			InputStream	getInputStream() ：在文件上传时使用，获取上传的文件的文件输入流

			1）获取请求参数的通用的方法：
				1）Map<String,String[]> getParameterMap():获取所有参数的map集合
				2）String getParameter(String name):根据参数名称获取参数值    username=zs&password=123
				3）String[] getParameterValues(String name):根据参数名称获取参数值的数组  hobby=xx&hobby=game
				4）Enumeration<String> getParameterNames():获取所有请求的参数名称

				中文乱码问题：
					* get方式：tomcat 8 已经将get方式乱码问题解决了
					* post方式：会乱码
						* 解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");

					补充：tomcat7 中文乱码的解决：
						post下乱码的解决和tomcat8是一样的：
								在获取参数前，设置request的编码request.setCharacterEncoding("utf-8");
						get下解决乱码，需要转码：
								new String(request.getParameter("username").getBytes("ISO-8859-1"), "UTF-8")

			2）请求转发：
				1）request.getRequestDispatcher(转发的路径).forward(request,response)
				2）特点：
					1. 浏览器地址栏路径不发生变化
					2. 只能转发到当前项目内部资源中。
					3. 转发是一次请求
				3）共享数据：
					1 域对象：一个有作用范围的对象，可以在范围内共享数据
					2 request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
					3 方法：
						void setAttribute(String name,Object obj):存储数据
						Object getAttribute(String name):通过键获取值
						void removeAttribute(String name):通过键移除键值对
	

	3）URI和URL：
		URI：统一资源标识符
		URL：统一资源定位符

=======================================
form中action的书写：
	虚拟路径+servlet的映射路径