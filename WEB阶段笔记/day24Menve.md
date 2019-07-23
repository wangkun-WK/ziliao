=======================================回顾和复习
1）JSON
	1）作用：存储和传输数据
	2）语法：{"username":"zhangsan", "gender":"male", ...}
			 [{"username":"zhangsan", "gender":"male"}, {"username":"zhangsan", "gender":"male"}, ...]
	3）获取数据：
			{}	:对象.属性/对象["属性"]
			[]	:对象[index].属性/对象[index]["属性"]
	4）JSON解析器
			1）常见的：JsonLib，fastjson，jackson，gson
			2）jackson的使用：
					前提：ObjectMapper mapper = new ObjectMapper()
					1）将java对象转换为json字符串
							* writeValue(File/OutputStream/Writer args1, Object args2)
									:将java对象转换为json字符串，并且输出到指定的地方
							* writeValueAsString(Object obj)
									:将java对象转换为json字符串，返回
					2）将json字符串转换为java对象【了解】
							* readValue(String jsonStr, Class<?> clazz)
2）redis
	1）概述：
			* NoSQL，非关系型数据库。
					关系型数据库：	数据和数据是有关系的。
					非关系型数据库：数据是独立的
			* 使用思路：
					使用关系型数据库持久化存储数据，使用非关系型数据库来备份项目运行时的数据
			* redis:
					是一款非关系型、高效基于内存的数据库，是由c开发的。
					应用场景：缓存
	2）环境搭建：
			* 解压即可
			* 组成部分：
					服务器端：redis-server.exe	,只需要双击该程序，就能启动redis服务器
					客户端：redis-cli.exe, 双击该程序，启动redis客户端，我们通过客户端来操作redis
			* 配置文件：
					redis.windows.conf	redis的配置文件
	3）使用redis
			* redis的数据结构
					是key-value格式的数据库，key是字符串，value可以支持五种数据类型：
							* 字符串类型	string
							* 哈希类型		hash
							* 列表类型		list
							* 集合类型		set
							* 有序集合类型	sortedset
			* 命令行
					存储：
					获取：
					删除：

			* java操作redis

=======================================内容介绍
* 账号：java41  密码：1423

1）redis数据持久化机制【了解】：
		RDB[redis默认]：默认方式，不需要进行配置，默认就使用这种机制
			* 在一定的间隔时间中，检测key的变化情况，然后持久化数据
				例如：save 900 1
		AOF: 日志记录的方式，可以记录每一条命令的操作。可以每一次命令操作后，持久化数据。
			 默认是关闭的：appendonly no
2）使用Java操作redis：jedis【应用】
	1）Jedis：java语言操作redis的工具(客户端)，类似于jdbc驱动
	2）使用Jedis操作redis的步骤：
			* 核心：Jedis
			* 步骤：1）创建Jedis对象
							new Jedis()	:默认localhost，默认端口：6379
							new Jedis(String ip, int port)	：指定ip和端口
					2）使用Jedis的相关方法操作redis
							相关的方法名称和命令的名称是一样的。即有哪些命令那么就有哪些方法。
					3）释放资源
	3）缓存的思想【理解】：
			对于一些经常要查询的数据，并且这些数据几乎不怎么变化，或者是压根不变的数据，我们可以将这些数据在首次查询后，缓存起来。以后每次查询只需要从缓存中获取数据即可。

3）Maven入门【应用】
	1）什么是Maven？
			是Apache提供的一款项目管理工具，主要就是用来管理项目，包含有以下部分内容
					* 项目对象模型	
					* 一组标准集合
					* 一个项目生命周期(Project Lifecycle)
					* 一个依赖管理系统(Dependency Management System)
					* 运行时需要的插件
	2）Maven环境搭建
			1）下载与安装
					下载：http://maven.apache.org/download.cgi
					安装：解压即可(建议：路径不要太深，不要含有中文或者是特殊符号)
			2）相关配置
					* 配置MVAEN环境变量
							添加：MAVEN_HOME的环境变量	--->MAVEN主目录
							追加：在path中追加： %MAVEN_HOME%\bin		-->要在任何地方mvn的命令都能使用
					* MAVEN仓库：
							1）仓库分类：
								本地仓库		[远程仓库]		中央仓库
								如果本地仓库没有需要的jar，就需要从远程仓库|中央仓库下载。如果本地仓库已经有了，那么就直接使用本地仓库的jar即可。
							2）本地仓库配置：
								%MAVEN_HOME%\conf\settings.xml中修改：
									<localRepository>本地仓库路径(建议：该路径没有中文没有特出符号，并且层次不会太深)</localRepository>
							3）默认下载jar包的路径是中央仓库，就会存在下载慢或者是下载中端的问题，要解决这个问题，我们需要设置国内的远程仓库路径
								%MAVEN_HOME%\conf\settings.xml，给<mirrors>标签中添加：
										 <mirror>
											<id>nexus-aliyun</id>
											<mirrorOf>central</mirrorOf>
											<name>Nexus aliyun</name>
											<url>http://maven.aliyun.com/nexus/content/groups/public</url>
										 </mirror>
					* MAVEN工程的目录结构
							1）MAVEN创建的jar工程(java工程)
							2）MAVEN创建的war工程(javaweb工程)

	3）MAVEN的使用
		1）常用命令【了解】
				mvn clean		清理
				mvn compile		编译
				mvn package		打包
				mvn install		安装(将项目打包，并且将包上传到本地仓库)
		2）生命周期
				:主要是maven用来管理项目的，从项目开始到项目发布的整个过程。
				:分三套：
					清理生命周期	clean
					默认生命周期	编译	测试	打包	安装
							注意：一套生命周期内，后面的命令在执行时，总会顺序执行前面的命令
					站点生命周期：	【了解】
	4）idea集成maven
			设置：File | Settings | Build, Execution, Deployment | Build Tools | Maven | Runner | VM Options中添加：
			-DarchetypeCatalog=internal 默认先从本地找相关插件。maven默认先从网络寻找相关资源，我们就需要设置让maven先从本地寻找相关资源。
			
			* Maven的坐标
					1）jar包的坐标
					2）插件的坐标
					组成：
						groupId	
						artifactId	
						version
						位置：%本地仓库%/groupId/artifactId/version/artifactId-version.jar
			
			1）使用idea创建maven的jar工程【掌握】
			
			2）使用idea创建maven的war工程【掌握】
=======================================资源
redis命令集合：
https://www.redis.net.cn/order/
https://www.runoob.com/redis/redis-tutorial.html
