========================================内容介绍
1、JSP基本入门
	1）Servlet/JSP都是SUN公司推出的动态网页技术，JSP是为了替代Servlet用于网页显示的短板而推出的技术。
	2）JSP概述：
			* JSP：Java服务器页面，主要用来显示数据。其实质就是为了简化Servlet的书写的。
			* 就是一个Servlet
			* 运行过程：JSP --> Java  -->  class  --> 执行
	3）JSP的脚本：JSP定义Java代码的方式
		1. <%  代码片段 %>：定义的java代码，在service方法中。service方法中可以定义什么，该脚本中就可以定义什么。
		2. <%= 表达式 %>：定义的java代码，会输出到页面上。输出语句中可以定义什么，该脚本中就可以定义什么。
		3. <%! 代码 %>：定义的java代码，在jsp转换后的java类的成员位置。【了解】
	4）JSP的内置对象：<%  代码片段 %>和<%= 表达式 %>中能直接用的对象
		request		：
		response	：
		out			：字符输出流对象，主要功能：将数据输出到浏览器页面
			out和response.getWriter()的却别：
				
2、Session【重点】：HttpSession，在一次会话的多次请求之间共享当前用户的数据。
	快速入门：
		1）获取Session	：request.getSession()
		2）共享数据：
				范围	：一次会话
				存数据	；setAttribute(String name, Object value)
				取数据	：getAttribute(String name)
	原理：
		1）session是依赖于cookie的。
				因为在cookie中总会有一个名称为JSESSIONID的cookie，这个Cookie存储的就是session的id
		2）getSession():
				首次调用，会在服务器端创建一个Session对象，并且将该session对象的id通过cookie存储到浏览器端
				非首次访问，就会通过浏览器带过来的cookie中的sessionid来寻找session对象
	细节：
		1. 当客户端关闭后，服务器不关闭，两次获取session是否为同一个？
			* 默认情况下。不是。
			* 如果需要相同，则可以创建Cookie,键为JSESSIONID，设置最大存活时间，让cookie持久化保存。
				 Cookie c = new Cookie("JSESSIONID",session.getId());
				 c.setMaxAge(60*60);
				 response.addCookie(c);

		2. 客户端不关闭，服务器关闭后，两次获取的session是同一个吗？
			* 不是同一个，但是要确保数据不丢失。tomcat自动完成以下工作
				* session的钝化：
					* 在服务器正常关闭之前，将session对象系列化到硬盘上
				* session的活化：
					* 在服务器启动后，将session文件转化为内存中的session对象即可。
				
		3. session什么时候被销毁？
			1. 服务器关闭
			2. session对象调用invalidate() 。
			3. session默认失效时间 30分钟
				选择性配置修改：当前项目下的web.xml中：	
				<session-config>
					<session-timeout>30</session-timeout>
				</session-config>

		总结：session是一个域对象，用来共享一次会话的多次请求之间的数据的
					范围：一次会话
					何时创建：服务器端首次调用getSession()方法时创建
					何时销毁：
						有三种情况，都可以销毁session
							1）服务器关闭
							2）执行session.invalidate()
							3）过期了(默认30分钟，web.xml中有配置)
	登录案例(带验证码)
		1）书写习惯
			* 验证码存放在session中，判断验证码是否正确，就是将session中存储的验证码和表单提交时填写的验证码进行比较，一致则验证码正确否则验证码错误
			* 在登录失败后，使用request域存储信息，转发到登录页面，在页面显示错误信息
			* 在登录成功后，用户信息存储在session中，重定向到一个页面
		2）验证码逻辑
			* 从表单中获取的验证码和从session中获取的验证码比较
					一致：验证码正确
					不一致：验证码错误
			* 不管正确与否，都需要在从session中获取了验证码之后，将session中存储的验证码清楚，因为这个验证码是一次性的

JSP【应用】：
	* JSP = Java + HTML + JSP自身的一些部分
	1）JSP指令(3个)
			* 作用：配置页面参数或者是配置页面行为(包含其他页面，引入标签库资源)
			三个指令：
				page	：
				include	：
				taglib	：
			JSP的注释：
				<!--  -->	:只适用于HTML代码
				<%--  --%>	:用于所有代码
	2）JSP内置对象(9个)【面试题】：参考jsp翻译后的java源文件的_jspService方法。
				变量名					真实类型						作用
			* pageContext				PageContext					当前页面共享数据，还可以获取其他八个内置对象
			* request					HttpServletRequest			一次请求访问的多个资源(转发)
			* session					HttpSession					一次会话的多个请求间
			* application				ServletContext				所有用户间共享数据
			* response					HttpServletResponse			响应对象
			* page						Object						当前页面(Servlet)的对象  this
			* out						JspWriter					输出对象，数据输出到页面上
			* config					ServletConfig				Servlet的配置对象
			* exception					Throwable					异常对象。当jsp中isErrorPage=true，才能使用

	3）JSP作用域(4个)
			page域		：pageContext操作数据，一个页面内
			request域	：request操作数据，一次请求内
			session域	：session操作数据，一次会话内
			application域	：application操作数据，整个应用范围
	4）MVC开发模式：从软件架构层面解决了业务逻辑、数据、呈现的耦合性高的问题
			M(Model, 模型)	：用于处理业务逻辑，封装数据，使用JavaBean充当
					* 处理业务逻辑
					* 封装数据
			V(View, 视图)	：用于展示数据，JSP充当
					* 展示数据
			C(Controller, 控制器)	：给M和V之间建立一种连接关系(桥梁)，Servlet充当
					* 获取请求参数
					* 调用M的方法执行业务逻辑得到数据
					* 将数据通过作用域传输给V，V来展示数据

						