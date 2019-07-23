=======================================回顾和复习
1）多表联合查询
	连接查询：
		内连接查询：
		左/右外连接查询：
	子查询：
2）事务
	事务的概述以及事务的四大特性：
	事务的隔离级别：
3）mysql用户管理(DCL语句)
	用户操作：
	授权操作：

=======================================JDBC
1）概述：
	1）JDBC是一套使用Java连接数据库的规范(接口)。接口对应的实现类，由各数据库厂商提供，并封装在一个jar包中。
2）步骤：
	1）导入jar	
	2）注册驱动
		Class.forName("驱动类全限定类名")，MySQL的驱动类：com.mysql.jdbc.Driver
	3）获取连接
		DriverManager.getConnection("jdbc:mysql:///test", "root", "root")
	4）获取执行sql的对象
		conn.createStatement()
	5）执行sql
		stmt.execute(sql)/executeUpdate(sql)/executeQuery(sql)
	6）处理结果

	7）释放资源
		stmt.close()
		conn.close()
3）API：都在java.sql包下
	1、class DriverManager
			1）注册驱动，但是一般都用:Class.forName("驱动类全限定类名")
			2）获取连接
				方法：static Connection getConnection(String url, String user, String password) 
				url的介绍：
					语法：jdbc:mysql://ip地址(域名):端口号/数据库名称
						jdbc	：jdbc协议
						mysql	：子协议
					一般如果连接的是本地的mysql，并且端口是3306，那么url就可以简写：jdbc:mysql:///数据库名称
	2、interface Connection
			1. 获取执行sql 的对象
				* Statement createStatement()
				* PreparedStatement prepareStatement(String sql)  【常用】
			2. 管理事务：jdbc中事务是默认自动提交的
				* 开启事务：setAutoCommit(boolean autoCommit) ：调用该方法设置参数为false，即开启事务
				* 提交事务：commit() 
				* 回滚事务：rollback() 
	3、interface Statement
			1） 执行sql
				boolean execute(String sql) ：可以执行任意的sql 了解 
					false：执行了insert/update/delete语句，使用statement.getUpdateCount()获取影响的行数
					true：执行了select语句，使用statement.getResultSet()来获取结果集
				【重点】int executeUpdate(String sql) ：执行DML（insert、update、delete）语句、DDL(create，alter、drop)语句
					* 返回值：影响的行数，可以通过这个影响的行数判断DML语句是否执行成功 返回值>0的则执行成功，反之，则失败。
				【重点】ResultSet executeQuery(String sql)  ：执行DQL（select)语句
			2）执行批处理【了解】
				addBatch(String sql) ：将sql添加到批处理中
				clearBatch() ：清空批处理中的sql
				executeBatch() ：执行批处理中的sql
	4、interface ResultSet
			1）方法
					next()	:判断游标是否走到最后一行末尾，如果没有则返回true，如果有则返回false
					getXxx()	:getInt()/getString()/getDouble()/getDate().../getObject()
						参数：可以是数字，如果是数字表示列的编号，从1开始；如果是字符串表示列名
			2）遍历
					while(rs.next()){
						获取数据...
					}
							
	5、interface PreparedStatement
			1）sql的注入漏洞：
				在使用拼接的方式组织sql语句的时候，由于变量中含有sql关键字，导致sql结构发生了变化，得不到预期的结果
			2）sql的注入漏洞的解决：
				PreparedStatement：预编译sql对象，在传递sql的参数之前先将sql的格式固定下来，传递的变量值就只能是参数的值，就不会对sql格式产生影响
					1）预编译sql中以?占位
					2）获取PreparedStatement ： conn.prepareStatement(sql)
					3）设置参数
							setXxx(int index, Xxx value) index: 从1开始，表示?的位置。
					4）执行sql语句
							execute()/executeUpdate()/executeQuery() :都是无参的方法


4）JDBC工具类【应用】
	1）配置文件：一般将程序中的动态参数抽取，目的就是当修改参数的时候，不用修改类。那么类也就不用重新编译了。
			分类：
				属性配置文件：以.properties结尾，数据内容以键值对形式存放。一个键值对就是一行数据，键和值之间用“=”连接
					driver=com.mysql.jdbc.Driver
					注意：属性配置文件中所有的字符串不需要添加""来包含
				xml配置文件：后期再说
			解析配置文件：
				properties配置文件可以使用Properties对象来解析
					new Properties().load(文件的字节流对象)
			获取项目中的文件路径：
				使用类加载器
					String filePath = 类.class.getClassLoader().getResource("文件名").getPath();
					InputStream in = 类.class.getClassLoader().getResourceAsStream("文件名");
	2）工具类的抽取
		1）获取连接对象(隐藏了注册驱动)
		2）释放资源

5）CRUD操作【重点】：
	1）完成Statement的CURD
	2）完成PreparedStatement的CRUD
	