=======================================回顾和复习
1、Junit
	1）测试分类
		黑盒测试：
		白盒测试：
	2）Junit使用：
		1）引入Junit环境	2个jar包
		2）给需要执行的测试方法上添加@Test注解
				@Before
				@After
2、注解
	介绍：
	定义：
		元注解
		public @interface 注解名称{
			属性
		}
		
		属性的定义：
			数据类型 属性名() [default 值];
				数据类型
					1）基本数据类型
					2）字符串类型
					3）注解类型
					4）枚举类型
					5）Class类型
					6）以上类型的一维数组
		元注解
			@Target	：
			@Rentention	：

3、反射
	1）获取Class对象
			类名.class
			对象.getClass()
			Class.forName("全限定类名")
	2）获取Method对象
			Class对象的getMethod(String methodName, Class<?> paramterClass)/getMethods()
	3）执行方法
			方法对象method.invoke(Object 对象, Object[]参数)

=======================================MySQL
1、数据库介绍
		数据库：数据仓库，可以看作是一个文件系统。
		常用的数据库软件：
			Oracle、MySQL、DB2

2、MySQL安装与卸载
		启停MySQL服务
			1）cmd窗口
					net start mysql/net stop mysql
			2）在服务界面，手动点击启停。
		登录mysql
			cmd窗口，mysql -uroot -proot
		
		MySQL目录介绍
			1）核心配置文件：my.ini
			2）存储数据的结构
					MySQL服务器	：安装了MySQL数据库软件的电脑
					存储结构：
						1）一台MySQL服务器上，可以有多个数据库
						2）一个数据库中可以有很多张表，我们将数据就是存储在这些表中
						3）表里的一条记录就是我们所说的数据

3、SQL
	概念：SQL操作关系型数据库的标准，叫做结构化查询语言
	通用语法：
		1）以";"结尾
		2）注释
				如果是--注释，那么--后面必须有至少一个空格

	数据库操作【理解】：
		创建：create database [if not exists] 数据库名;
		查询：
			显示所有数据库：show databases;
			显示某个数据库的创建语句：show create database 数据库名
			查询当前正在使用的数据库：select database();
		修改：alter database 数据库名 character set 字符集【了解】
			字符集(gbk, uft8)
		删除：drop database [if exists] 数据库名称;
		切换数据库：use 数据库名;
	
	数据表的操作【重点】
		查询：
			显示数据库下所有的表：
				show tables;
			查询某一张表的结构：
				desc 表名
		创建【掌握】：
			1）MySQL数据库中数据的常用类型
				                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     		数值：int 、double
						字符串：varchar(长度)、char(长度)
									varchar：可变长度，长度其实就是字符串的真实长度
									char：定长字符，长度是指定的，如果字符串的长度不够，则用空格补充
						日期：date、datetime
			2）创建表
					create table 表名(列名1 数据类型(长度), 列名2 数据类型(长度), ..., 列名n 数据类型(长度));
		删除：
			drop table if exists 表名
		修改：修改表结构：字段、类型、表名
				1. 修改表名
					alter table 表名 rename to 新的表名;
				2. 修改表的字符集
					show create table 表名; -- 查看建表语句，其中就有字符集
					alter table 表名 character set 字符集名称;
				3. 添加一列【常用】
					alter table 表名 add 列名 数据类型;
				4. 修改列名称 类型【常用】
					alter table 表名 change 列名 新列别 新数据类型;
					alter table 表名 modify 列名 新数据类型;
				5. 删除列
					alter table 表名 drop 列名;
	数据的操作【重点】
		增加：
			insert into 表名 [(列1,列2, ... , 列n)] values (值1,值2, ... 值n);
				1）列是可以省略的，如果不写列名，默认给所有列添加数据
				2）列的个数和值的个数是要匹配，并且类型要匹配
				3）字符串和日期型数据需要用引号引起来
		删除：
			1）delete from 表名 [where 条件];
			2）truncate table 表名;
		修改：
			1）update 表名 set 列名1 = 值1, 列名2 = 值2, ... 列名n = 值n [where 条件];
		
		查询：
			1）查询所有的数据
					select distinct *|[列1,列2, ..., 列n] from 表 where 条件;
					1）可以在sql中进行数学运算，要注意如果有null参与，那么结构就是null，所以在sql语句中我们经常需要进行判断是否为null，可以使用函数ifnull.
					2）ifnull(字段, 默认值)
							如果字段值为null，则使用默认值，一般用于列之间的数学运算