=======================================回顾和复习
1）jQuery动画
	* 指的是元素显示和隐藏的效果
			show()/hide()/toggle()
			slideDown()/slideUp()/slideToggle()
			fadeIn()/fadeOut()/fadeToggle()
2）jQuery循环
	* jQuery对象.each(function(index, element){});
	* $.each(object, function(index, element){});
3）jQuery事件
	* 明确：jQuery中事件和js事件相比较，名称少了on。例如：js的事件onkeydown	jQuery事件keydown
	* 事件绑定：
			jQuery对象.事件函数(function(){//事件处理函数})，例如：$("#btn").click(function(){//事件处理});
			jQuery对象.on('事件名称', 事件的处理函数)，例如：$("#btn").on('click', function(){//事件处理});
	* 事件移除：
			jQuery对象.off('事件名称')
	* 时间切换函数：
			toggle()	:事件切换，每触发一次事件，就会顺序执行一个函数。这个功能在1.9版本之后被移除了。如果需要使用，需要引入一个插件 jQuery migrate
			hover()		:模拟鼠标悬停，即鼠标移动到元素之上(mouseover事件)和鼠标离开元素(mouseout事件)
4）jQuery插件机制
	* $.fn.extend({方法名:function(){}, ....})	:对象级别的插件，这里面定义的方法必须要使用jQuery对象来调用
	* $.extend({方法名:function(){}, ....})		:全局方法，直接$来调用
5）ajax介绍
	* 作用：不刷新页面的情况下，完成页面内容的部分更新
	* 概念：
			同步：中断用户的体验
			异步：不中断用户的体验
	* 实现：通过js中的XMLHTTPRequest对象来完成异步
6）原生ajax实现
	* 步骤：
			1）创建XMLHTTPRequest对象
			2）设置请求参数(打开链接) XMLHTTPRequest.open()
			3）发送请求 XMLHTTPRequest.send()
			4）设置监听器，监听请求和响应的状态 
					//XMLHTTPRequest.readyState==4 && XMLHTTPRequest.status==200,说明请求ok响应也ok，可以获取数据
					XMLHTTPRequest.onreadystatechange = function(){
						if(XMLHTTPRequest.readyState==4 && XMLHTTPRequest.status==200)
					}
					
7）jQuery ajax
	* 方法：
			$.ajax({})
			$.get(url, data, function(data){}, dataType)
			$.post(url, data, function(data){}, dataType)

=======================================内容介绍
1）JSON：
	* JSON概述【应用】
		* 概念：JavaScript的对象表示法，用json的格式来表示一个js中的对象
		* 作用：在网络间进行数据传输
		* 定义：
			1） {"username":"zhangsan", "age":23}	==>对象
			2） {"username":"zhangsan", "age":23, "groups":[{"username":"lisi", "age":23}, {"username":"wangwu", "age":23}]}
			3） [{"username":"lisi", "age":23}, {"username":"wangwu", "age":23}]
		* 数据获取：
			* {}	:对象.key/对象["key"]
			* []	:对象[index]

	* 常见的JSON解析器：jackson(spring mvc框架内置)、jsonlib、fastjson、GSON
			jackson的使用：【应用】
				* 引入相关jar包(3个)
				* 使用：
						1）将java对象转换为json字符串【常用】
								* 创建解析器类：ObjectMapper mapper = new ObjectMapper();
								* 调用方法：
										writeValueAsString(Object obj)	：将java对象转换为json字符串
										writeValue(File file, Object obj)	:将java对象转换为json字符串，并且计入到文件中
										writeValue(OutputStream os, Object obj)	:将java对象转换为json字符串，输出到outputstream中
										writeValue(Writer writer, Object obj)	:将java对象转换为json字符串，输出到writer中
								* 对象/map	===> {}, 对象.属性/对象["属性"]
								* list集合	===> [{},{},...], 对象[index].属性/对象[index]["属性"]
		
						2）将json字符串转换为java对象【了解】
								readValue(String jsonStr, Class clazz)
2）异步校验用户名是否存在(仿百度注册的账号校验)【掌握】
	* 注册页面，当输入了账号后，异步向后台(服务器)发送一个请求，进行数据库检索，如果能查到数据，那么就说明账号被使用；否则账号没有被使用
	* 步骤：
		定义失去焦点事件
		获取账号，发送异步请求
		处理响应的结果
	* 注意：
		1）服务器向浏览器传递的数据只能是字符串，要想让这段json的字符串在浏览器端被认为是json对象，就需要
				* 在jQuery的异步方法中指定
						$.get(url, data, function(data){}, 'json')
						$.ajax({url: url, dataType: 'json', success:function(data){}})
				* 在服务器端指定数据的MIME类型
						response.setContentType("application/json;charset=utf-8")
				* 二者选一即可
		2）响应的数据类型可以是任意形式的字符串
				response.getWriter().write(普通字符串/带有html标签的字符串/json字符串)

3）省市二级联动【应用】
	要求：
		1）访问index.jsp页面，省份下拉框需要填充省份数据，并且该数据是从数据库查询得到的。
		2）选择省份后，根据选择的省份更新城市下拉列表数据
4）redis
	* redis介绍
		NoSQL系列的数据库介绍：
			* 关系型数据库：数据和数据之间是有关系的，数据是存储在磁盘上的。
			* NoSQL数据库：是一个系列的数据库，非关系型数据库。数据是存储在内存中，数据与数据之间没有任何联系
			* 一般：在项目中我们使用关系型数据库存储数据，使用NoSQL数据库类备份数据。即关系型数据库和NoSQL数据库是相辅相成的关系。
		redis：
			* 是一款高性能的NoSQL系列的数据库产品。当前我们使用redis的场景：缓存
			* redis的应用场景
				•	缓存（数据查询、短连接、新闻内容、商品内容等等）
				•	聊天室的在线好友列表
				•	任务队列。（秒杀、抢购、12306等等）
				•	应用排行榜
				•	网站访问统计
				•	数据过期处理（可以精确到毫秒
				•	分布式集群架构中的session分离
		搭建redis环境：
			* 在真正的项目中，redis一般都是安装在linux服务器上。我们在学习阶段使用windows版
			* redis解压即可(建议：解压的目录不要有中文和特殊符号，并且层次不要太深)
			* redis有客户端和服务器端两部分：
					* 启动服务器端	redis-server.exe,默认端口 6379
					* 启动客户端	redis-cli.exe, 我们通过redis客户端来操作redis数据
					* 问题：如果双击redis服务器的exe程序，不能启动redis，那么一般情况下都是windows给redis分配的内容不够，需要修正redis启动时占用的内容
							打开：redis.windows.conf文件
							添加：maxmemory 120MB 
					  在cmd窗口，进入redis目录，使用：redis-server.exe redis.windows.conf 启动
		redis支持的数据类型：
			* redis存储的是：key,value格式的数据，其中key都是字符串，value有5种不同的数据结构
					value的数据结构：
						1) 字符串类型 string
						2) 哈希类型 hash ： map格式  
						3) 列表类型 list ： linkedlist格式。支持重复元素
						4) 集合类型 set  ： 不允许重复元素
						5) 有序集合类型 sortedset：不允许重复元素，且元素有顺序
	* redis命令(对应五种数据类型)【应用】
					字符串类型		哈希类型	列表类型	集合类型	有序集合类型
		1）存储
		2）获取
		3）删除
		4）替换：如果设置两次数据，并且两次数据的key是相同的，那么后面的数据会将前面的数据覆盖。即修改也是使用存储的命令

		常用命令：
			keys *	：
			type key：
			del key	：