=======================================回顾和复习
SQL：结构化查询语言，是专门用来操作关系型数据库的，分类：
	DDL/DML/DQL/DCL
MySQL的存储结构：
	一个mysql数据库服务器上，会有多个数据库
	一个数据库下会有多张表
	一张表中会有多条记录，表中的记录就是我们所说的数据
SQL操作数据库：
	创建：create database 数据库名
	删除：drop database 数据库名
	查看：show databases;
		  show create database 数据库名;
		  select database();
SQL操作数据库表
	1）常见的数据类型
			数值型	：int double float
			字符串型：varchar char
			日期型：date datatime timestamp
	2）建表
			create table 表名 (字段1 类型1, ... , 字段n 类型n);
	   修改
	   		alter table 表名 ...
	   查看
	   		show tables;
			show create table 表名;
	   删除 
	   		drop table 表名
SQL操作表数据【重点】
	添加数据：
		insert into 表名 [(字段1, 字段2, ... ,字段n )] values (值1, 值2, ... , 值n)
		复制表以及数据【了解】：
			第一种写法：
				create table 新表 like 原始表; -- 复制表结构
				insert into 新表 select * from 原始表
			第二种写法：
				create table 新表 as select * from 原始表
	删除数据：
		delete from 表 [where 条件]	
		truncate table 表
	修改数据：
		update 表 set 字段1= 值1, 字段2= 值2, ... ,字段n= 值n [where 条件]
	查询：
		select [distinct] *|[字段1, 字段2, ..., 字段n] from 表 [where 条件]

=======================================内容介绍
1）查询(DQL)【掌握】
	1）排序查询
		关键字：order by 字段 排序规则,字段 排序规则,字段 排序规则,...
		排序规则： ASC 升序(默认)	DESC(降序)
	2）聚合函数和分组
		1）聚合函数
				count	:表示记录数
				sum/max/min/avg	：对一列进行数学运算。使用这些聚合函数运算的列一定是数值列
						ifnull()	：将null值替换成指定的值
		2）分组函数
				关键字：group by
				写法：select字句后面跟的一定是分组的条件或者是聚合函数
					  如果在分组之前进行条件筛选，那么就在group by之前定义where子句；如果对分组聚合之后的结果进行筛选，那么就需要在group by之后添加having
					
	3）分页查询
			关键字：limit a, b
					a ：起始索引，mysql中数据索引从0开始	a的计算公式：(当前页-1)*每页记录数
					b ：查多少条记录
			特殊写法：
					limit 5	：查询前五条记录

	通用的sql：
		S(select) ... F(from) ... W(where) ... G(group by) ... H(having) ... O(order by) ... l(limit)	

2）约束【应用】
	概念：对数据表中的数据定义一些必须遵守的规则，保证数据的正确性、有效性和完整性。
	添加约束的方式：
		1）在建表的时候添加
		2）修改表的字段添加
	单表：
		主键约束:
			1）非空且唯一，表示一条记录唯一区别于其他记录的标记。
			2）一张表中只能有一个主键，主键的列可以是一个列，也可以是多个列(联合主键)
			3）添加主键约束
				建表时添加：
					create table stu(id int primary key , name varchar(20))		-- 单列主键
					create table stu(id int, cid int, name varchar(20), primary key (id, cid)) -- 联合主键
				修改字段时添加：
					ALTER TABLE stu MODIFY id INT PRIMARY KEY;
			4）删除主键
					alter table stu drop primary key;
		唯一约束: 列的值是唯一的
			1）唯一约束对null值无效
			2）建表时添加：
					CREATE TABLE stu(
						id INT,
						phone_number VARCHAR(20) UNIQUE -- 添加了唯一约束
					
					);
				修改字段时添加：
					ALTER TABLE stu MODIFY phone_number VARCHAR(20) UNIQUE;

			3）删除：ALTER TABLE stu DROP INDEX 字段;

		非空约束: 列的值不能为null
			1）添加非空约束
					建表时添加
						CREATE TABLE stu(
							id INT,
							phone_number VARCHAR(20) not null -- 添加了非空约束
						
						);
					修改字段时添加
						ALTER TABLE stu MODIFY NAME VARCHAR(20) NOT NULL;
			2）删除非空约束
					ALTER TABLE stu MODIFY NAME VARCHAR(20);
	多表
		外键约束:用来表示表与表之间的关系,时为了保证表与表之间的数据的完整性
			创建：
				create table 表名(
					....,
					constraint 外键名称 foreign key (外键列名称) references 主表名称(主表列名称)
				);
				或者
				alter table 表 add constraint 外键名称 foreign key (外键列名称) references 主表名称(主表主键列名称);
			删除：
				alter table tb_emp drop foreign key 外键名称;

			级联操作【了解·慎用】
				级联更新：ON UPDATE CASCADE
				级联删除：ON UPDATE CASCADE
				ALTER TABLE 表名 ADD CONSTRAINT 外键名称 
					FOREIGN KEY (外键字段名称) REFERENCES 主表名称(主表列名称) ON UPDATE CASCADE ON DELETE CASCADE  ;
		
3）多表的关系以及表的建立原则【应用】
	一对一【了解】
		建表原则：在任意一方建立外键，指向另一张表的主键。并且设置外键非空唯一。
			一般会在一张表的主键上在建立外键，指向另一张表的主键。
	一对多
		建表原则：在多的一方建立外键，指向一的一方的主键
	多对多
		建表原则：建立第三张表，至少有两个外键，分别指向两张表的主键
4）数据库三大范式【了解】
	1）范式：数据库设计的一些规则，当我们遵守了这些规则之后，我们设计的数据库将更加有条理、更加请清晰，让程序能有更高效的运行。
	2）范式有六种，咱们只关心前三种:
		1NF：列是原子的，不能在分
		2NF：在1NF基础上，消除冗余数据，但是数据之间的依赖还存在
		3NF：以上的所有问题都能解决
		总结：当我们遵守了三大范式，我们在数据库设计过程中出现的数据冗余、数据的修改时的相互影响就会被消除掉。
5）数据库数据的备份和还原【应用】