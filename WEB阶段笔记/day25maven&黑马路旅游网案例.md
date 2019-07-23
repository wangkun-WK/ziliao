=======================================回顾和复习
1）redis持久化机制
		RDB：默认。在一段时间内，检测key的变化，如果达到指定的变化的次数，就持久化一次
		AOF：日志记录方式。每次一次操作都会有持久化，默认关闭的。

2）Jedis：使用Java操作Redis的工具(客户端)
		1）步骤：
				* 创建Jedis对象
				* 使用Jedis调用相关方法
						-- Jedis提供的操作数据的方法和Redis的命令的名称是一样
				* 释放资源
		2）Jedis的连接池
				* 类似于JDBC的连接池的使用
		3）缓存的思想：
3）Maven
		1）是apache提供的项目管理工具，提供了
				* 一个项目对象模型
				* 一个依赖管理系统
				* 一组标准集合
				* 一组项目的生命周期
				* 插件
		2）使用Maven
				1）环境搭建
						* 下载、安装、配置MAVEN_HOME的环境变量 
				2）配置本地仓库 
						* 本地的Maven工程在运行时所需要的jar包/插件，都在本地仓库中。工程在使用的时候只需要提供坐标即可
								* 坐标
						* 仓库分类
								本地仓库、[远程仓库]、中央仓库
				3）mavne的常用命令
						clean、compile、test、package、install
				4）生命周期
						* 清理生命周期
						* 默认生命周期(后面的命令在执行的时候，前面的命令一定是需要执行的)
						* 站点生命周期
				5）在idea中集成maven
				6）使用Maven创建工程
						* 创建jar工程
						* 创建war工程

=======================================内容介绍
1）Maven创建war工程
		* 在Maven工程中引入第三方jar：熟悉坐标
				<dependencies>
					<!-- 引入jar包，也叫做对jar包的依赖，可以有多个 -->
					<dependency>
						<groupId>junit</groupId>
						<artifactId>junit</artifactId>
						<version>4.12</version>
					</dependency>
				</dependencies>
		* 修改Maven依赖的jdk版本：Maven的编译插件
				在build/plugins下添加插件编译插件，来修改 jdk版本
		            <plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-compiler-plugin</artifactId>
						<version>3.1</version>
						<configuration>
							<source>1.8</source>
							<target>1.8</target>
							<encoding>utf-8</encoding>
						</configuration>
					</plugin>
				* 扩展：可以在idea中添加此插件的模板，成功后就可以使用自动联想功能添加。
					添加动态模板：
						File | Settings | Editor | Live Templates
		* 创建web工程【熟练】
				1）不使用骨架
						* 创建工程
						* 在pom.xml中，添加<packaging>war</packaging>
						* 在src/main下，创建一个webapp的目录，并且设置webapp目录为web资源目录
								备注：如果创建了webapp目录，目录图标是灰的，就需要自己在模块中添加web配置信息
				2）使用骨架
						* maven-archetype-webapp
				3）前提：一定需要联网
				4）jar出错:找到这个jar包目录，将这个目录删除，让mavne重新下载即可。
				5）启动web工程
						1）配置tomcat插件
							 <plugin>
								  <groupId>org.apache.tomcat.maven</groupId>
								  <artifactId>tomcat7-maven-plugin</artifactId>
								  <version>2.2</version>
								  <configuration>
									  <port>80</port>
									  <path>/</path>
								  </configuration>
							  </plugin>
							可以将此配置作为动态模板。类似于maven的编译插件。
						2）可以使用外部的tomcat服务器来发布war工程
				6）给Maven的war工程添加servlet依赖
						<dependency>
							<groupId>javax.servlet</groupId>
							<artifactId>javax.servlet-api</artifactId>
							<version>3.1.0</version>
							<!-- 让这个依赖在编译时有效，在运行时无效，即运行项目的时候，不需要该jar -->
							<scope>provided</scope>
						</dependency>

		* jar的依赖范围
				* compile	默认，在编译、测试、运行阶段都有效
				* test		测试阶段有效
				* provided	编译、测试阶段有效
				* runtime	测试、运行阶段有效
				* system	找本地仓库之外的jar包

=======================================综合案例阶段
1）目的：对于之前学习的知识点的一个综合使用		
		 学习项目中的逻辑(经验)

2）项目的准备：
	1）在idea中引入maven工程：添加pom.xml即可
	2）如何进行技术选型？
	3）数据环境
			tab_user	：用户表，存储注册的用户信息
			tab_category：旅游线路的分类表
			tab_route	：旅游线路表
			tab_route_img	：旅游线路图片表
			tab_seller	：商家表
			tab_favorite：旅游线路收藏表
	4）项目的流程
			1、立项
			2、需求分析		产出：需求包
			3、设计(概要设计、详细设计)		产出：界面原型，数据库设计
			4、编码		产出：项目	程序员涉入
			5、测试		产出：测试报告	测试团队
			6、部署、上线	
3）注册
	1）前台：
			* JS校验数据是否合格
			* 异步提交表单数据到后台，并且对响应的结果进行显示
					$(this).serialize() ：将表单数据进行序列化，即转成username=zhangsan&password=123的格式

	2）后台：
			servlet：
				* 接收参数
				* 调用业务层进行账号的注册，得到结果
				* 响应结果到前台
			service：
				* 如果账号有重复，不能注册
				* 如果账号没有重复，则添加账号数据到数据库
			dao：
				* 提供两个方法
					1）根据用户名查询用户，返回用户对象
					2）将数据数据保存到数据库
4）登录
5）退出
