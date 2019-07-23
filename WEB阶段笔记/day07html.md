=======================================回顾和复习
1）事务管理
	Connection	：setAutoCommit(false)	开启事务, JDBC默认的事务连接是自动的
				  commit()	提交事务
				  rollback()	回滚事务
2）连接池
	规范：javax.sql.DataSource
	连接池技术：
		C3P0	：
			1）建立c3p0-config.xml文件，位置src下
			2）创建连接池对象：new ComboPooledDataSource()
		Druid	:
			1）建立配置文件 *.properties，位置任意，一般情况都在src下
			2）创建连接池对象
					1）创建Properties对象	Properties pro = new Properties();
					2）加载配置文件			pro.load(类.class.getClassLoader().getResourceAsStream("配置文件"));
					3）创建连接池对象		DruidDataSourceFactory.createDataSource(pro);
3）JdbcTemplate
	1）创建jdbctemplate		new JdbcTemplate(dataSource);
	2）方法
			int update(String sql, Object... args)	:执行insert/update/delete语句
			List<T> query(String sql, RowMapper<T> rowMapper, Object... args)	:执行select语句
						：查询多条记录，并且将每一条记录都封装成一个T对象，然后将T对象装在list集合中，返回。
						：一般，不自己实现RowMapper，使用它的实现类 BeanPropertyRowMapper
									new BeanPropertyRowMapper<Entity>(Entity.class)
			T queryForObject(String sql, Class<T> clazz, Object... args)	:执行select语句
						：执行聚合函数返回单值单列
								Integer i = queryForObject("select count(*) from user", Integer.class);
						：执行select，查询一条记录，并且将一条记录封装成一个对象
								User user = queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<User>(User.class), 1);
						：注意：如果查询出一条记录，那么就会报错
=======================================
静态网页开发：
	HTML	CSS		JavaScript(JS)		BootStrap		xml

1）web的一些基础知识
	web：互联网应用的总称
	javaweb：使用java开发互联网应用
	javaee：使用java开发互联网应用的时候遵守的一些规范

	web中常见的软件架构：
		C/S	:	
				优势：体验好
				劣势：开发和维护需要维护两套软件，一套是服务器端软件，一条是客户端软件，成本高。
					  如果服务器端软件更新，那么客户端就需要立即更新
		B/S	:	
				优势：只需要开发服务器端即可，成本较小
				劣势：所有的开发都在服务器端，服务器端压力很大，体验稍差
						服务端压力大	：ajax解决
						体验稍差		：html5 + css3
	web的组成：
		web客户端	：使用浏览器充当
		web服务器	：安装了web服务器软件的电脑，用来发布web资源，客户端可以通过网址来访问这个资源

	web的资源：
		静态资源：任何时候任何方式看到的同一个资源，效果都是一样的。常见的静态资源有：HTML、CSS、JS、图片、多媒体、...
				  特点：浏览器可以直接解析静态资源
		动态资源：使用动态网页技术开发的资源，在java中常见的动态资源有：JSP/Servlet
				  特点：必须经过服务器，将动态资源转换为静态资源，才能给客户端

	* 静态资源：
		* HTML：用于搭建基础网页，展示页面的内容
		* CSS：用于美化页面，布局页面
		* JavaScript：控制页面的元素，让页面有一些动态的效果

2）HTML的学习：主要学习标签的使用
	1）html：超级文本，是网页开发中的基础语言
			超文本：超文本是用超链接的方法，将各种不同空间的文字信息组织在一起的网状文本.
			标记语言(标签语言)：都是由标签组成。标签: <标签名称>
	2）快速入门
		扩展名：.htm(老版本)	.html【常用】
		标签的嵌套使用时，顺序上没有固定的说法。
	3）标签
		1）文件标签(结构标签)
				<title>	:内容显示在网页的页签上
				<body>	:内容显示在网页上
		2）文本标签
			font标签
				属性：size，设置文本字体的大小	取值1~7
		3）图片标签
			<img src="图片路径">
					图片路径的写法：
							相对路径【常用】：	以.开头的路径，以当前页html页面所在位置为参照
									./ ：当前路径
									../：上一级路径
							绝对路径：  以"/"开头
		4）列表
			<ol>	有序列表
				属性：type=“”	start=“”
			<ul>	无序列表【常用】
				属性：type=“”
			<li>	列表项

		5）超链接	<a>
			属性：href，必须有，表示要跳转的网页地址，如果为空了，跳转当前页面
						  当前，如果不想跳转页面，还想有点击的效果，那么可以让href="#"
				  target，表示在哪个地方打开
				  			_self	:默认，当前页面打开
							_blank	:新打开一个网页
		6）块标签【了解】
			<span>	:行级块标签，宽度是内容的宽度，不会换行
			<div>	:块级块标签，默认独占一行
		7）语义化标签
			<header>
			<footer>
		8）表格标签	:作用：1、显示列表数据	2、布局
			格式：
				<table>				：定义表格范围
					<tr>			：定义行
						<td>|<th>	：定义单元格	注意：数据都在td或者th的单元格中
						...
					</tr>
					...
				</table>

			介绍：
			* table：定义表格
				* width：宽度
				* border：边框
				* cellpadding：定义内容和单元格的距离
				* cellspacing：定义单元格之间的距离。如果指定为0，则单元格的线会合为一条、
				* bgcolor：背景色
				* align：对齐方式
			* tr：定义行
				* bgcolor：背景色
				* align：对齐方式
			* td：定义单元格
				* colspan：合并列
				* rowspan：合并行
			* th：定义表头单元格
			* <caption>：表格标题
			* <thead>：表示表格的头部分
			* <tbody>：表示表格的体部分
			* <tfoot>：表示表格的脚部分
			