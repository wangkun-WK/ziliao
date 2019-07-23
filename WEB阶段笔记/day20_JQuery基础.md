=======================================回顾和复习
1）案例：带条件的分页查询
	1）数据流向
			浏览器 ==》服务器：currentPage、rows、条件(0-多)
			服务器 ==》浏览器：list、totalPage、currentPage、totalCount、rows  ===》PageBean
2）过滤器 
	1）开发过滤器
			* 写一个类，实现 Filter接口
			* 配置：
					1）在 web.xml中配置
					2）可以使用注解配置
			* 注意：对于同一个过滤器，如果使用了注解方式，就不需要使用配置方式。即注解和配置方式二者选一
	2）细节：
		配置：
			拦截路径：
			先后顺序：
		过滤器链：
	4）动态代理：
			Proxy.newProxyInstance(ClassLoader classLoader, Classd<?>[] interfaces, InvocationHandler ivh)
					classLoader:是和被代理对象(真实对象)有相同的类加载器，即由真实对象获取
					interfaces:被代理对象(真实对象)实现的所有的接口字节码文件对象，即由真实对象获取
					ivh:接口，执行所有的代理对象的方法时，都会执行ivh中的invoke方法，我们要进行方法的增强其实质就是在invoke方法中执行原方法的前后添加业务逻辑代码

=======================================内容介绍
1）监听器【了解】
		1）事件监听机制：
				事件
				事件源
				监听器
				注册监听器
		2）Javaweb中的监听器：
				* 作用：用来监听三个域对象(ServletContext、HttpSession、ServletRequest)的创建和销毁以及数据的变更的。
				* 分类：三类八种，只需要关注ServletContextListener
						1）监听域对象的创建和销毁
								ServletContextListener：监听ServletContext对象的创建和销毁
								HttpSessionListener：监听HttpSession对象的创建和销毁
								ServletRequestListener:监听ServletRequest对象的创建和销毁
						2）监听域对象的数据的变更
								ServletContextAttributeListener：监听ServletContext对象的创建和销毁
								HttpSessionAttributeListener：监听HttpSession对象的创建和销毁
								ServletRequestAttributeListener:监听ServletRequest对象的创建和销毁
						3）监听HttpSession中JavaBean对象的
								HttpSessionBindingListener：监听JavaBean对象绑定和接触绑定到HttpSession对象
								HttpSessionActivationListener：监听HttpSession对象的钝化和活化
						注意：这三类监听器第一类和第二类需要进行配置的，第三类只需要在JavaBean对象上实现即可
		3）开发监听器
				1）写一个类，实现监听器接口
				2）配置监听器【掌握】
						* 可以使用web.xml中<listener>标签来配置
						* 可以使用@WebListener来配置
						* 注意：web.xml配置和@WebListener二者选一
				3）配置全局初始化参数
						在web.xml中使用<context-param>来配置，可以有多个，这些参数数据的获取可以通过ServletContext.getInitParameter() 来获取

2）jQuery入门
	1）概述
			* 是js的框架，封装了原生的js的一些操作，让我们的js编程变得简单。
			* js框架，本质就是一些js文件。
			* 使用jQuery
					* jQuery框架也就是一些js文件，我们在项目中如果要使用jQuery框架，那么就必须在页面使用<script src="js/jquery-3.3.1.min.js"></script>来引入jQuery框架
					* $表示jQuery核心方法，是一个方法名称
	2）基本语法
			* js对象和jQuery对象的转换
				* js对象：使用原生js方式获取的对象，可以调用js的一些方法和属性
				* jQuery对象：使用jQuery提供的方法获取的对象，可以调用jQuery提供的方法和属性
				* 注意：js对象和jQuery对象，不能相互调用对方的属性和方法，要想混用，那么就必须先要进行对象的转换：
					js对象 ==》jQuery对象：$(js对象)
					jQuery对象 ==》js对象：jQuery对象[索引]或者jQuery对象.get(索引)

				* 以后再真正开发过程中，我们经常会将js对象和jQuery对象混用来实现一些效果。
			* 事件绑定&入口函数(文档就绪函数)&样式修改
				1）事件绑定  
						1）<input type="button" value="按钮" id="btn" onclick="test();">
						2）$("#btn").click(function(){//单击事件对应的方法}) 【常用】
				2）文档就绪函数,和window.onload类似
						jQuery(document).ready(function(){//文档就绪后执行})，可以简化为
						$(function(){//文档就绪后执行}) 【常用】
						注意：$ == jQuery
				3）样式控制的方法(jQuery对象可以使用)
						css("样式属性名", "样式值")			:设置一个样式
						css({"样式1":"值1", "样式2":"值2"})	:设置一组样式
			* 选择器：快速获取标签【应用】
				格式：$("选择器")，获取选择器选中的所有的元素(标签/节点)
					选择器的分类：
						基本选择器：
							$("#id"), $(".className"), $("elementName"), $("sel1, sel2, ...., seln")
						层级选择器：
							$("parent child"),$("parent > child")
						属性选择器
							$("[属性名]"), $("div[id='div1']")
						过滤选择器
							$("div:first")
							$("tr:odd")/$("tr:even")
						表单过滤器选择器
							$("[type='checkbox']:checked")
							$("option:selected")

							if($("input[name='uid']:checked").length > 0){//有条目被选中
								//表单提交
								document.getElementById("form").submit();
							}
				
			* 对DOM的操作
				文本内容操作的方法：
					val()	:获取或者设置标签的value属性的值
					html()	:获取或者设置标签的标签体内容，可以有html标签	相当于innerHTML	【常用】
					text()	:获取或者设置标签的标签体纯文本内容，不支持html标签	 相当于innerText
				属性的通用操作
					attr()/removeAttr()	:设置或者删除属性
					prop()/removeProp()	:设置或者删除属性
					自定义数据和固有属性？
						自定义属性是固有属性之外的一些属性。那么固有属性就是文档中列出来的。
				对于class属性的操作
					addClass()		:添加class
					removeClass()	:移除class
					toggleClass()	:有，则移除；无则添加
					css()			:直接对样式属性操作
				添加节点：
					append()	:父子节点操作
					appendTo()	:子父节点操作
					remove()	:谁调用我，我删除谁
					empty()		:相当于innerHTML = '';