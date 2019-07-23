=======================================回顾和复习
1）查询
	1）排序查询：order by ， 默认ASC(升序)、DESC(降序)
	2）聚合函数：count/sum/max/min/avg	
	3）分组查询：group by， select后必须是分组的条件或者是聚合函数
	4）分页查询：limit a, b	
	通用的查询sql语法：
		S(select) .. F(from) .. W(where) .. G(group by) .. H(having) .. O(order by) .. L(limit)
2）约束
	1）非空约束
	2）唯一约束
	3）主键约束
		自动增长：auto_increment
	4）外键约束
3）数据库设计
	1）表与表的关系
	2）建表原则
	3）数据库范式
	4）数据的备份和还原

=======================================内容介绍
1）数据的备份和还原
	备份：
		命令行：mysqldump -uroot -proot day04 > d:/a.sql
	还原：
		命令行：
			1）create database db; use db; source d:/a.sql
			2）在cmd窗口不登录mysql的情况下：mysql -uroot -proot day04 <  d:/a.sql，要求：day03必须存在

2）多表查询
	1）连接查询【重点】：找外键
		内连接：两张表共有的数据
			1）隐式内连接查询(常用)：where
			2）显式内连接：[inner] join
		左/右外连接：左/右表以及两张表交集的数据
			1）左表 left/right join 右表 on 连接条件	
	2）子查询【理解】：嵌套查询，即有2个或者2个以上的的select。
		查询的数据情况：
			单行单列	：where条件中		> = < >= <= <> !=
			多行单列	：where条件中		in
			多行多列	：from的子句中	，把子查询的结果作为一张表，再次参与查询
		分类：
			where子句的子查询
				：子查询的select出现在where条件中
			from子句子查询
				：子查询的select出现在from后面
			select子句子查询
				：子查询的select出现在select后面
					-- 查询员工信息，并且将员工所属的部门也查询出来
					select e.*, 
						  (select d.dname from dept d where d.id = e.dept_id) dname 
					  from emp e;
3）事务
	概念【重点】：如果一个包含多个步骤的业务操作(增删改)，被事务管理，那么这些操作要么同时成功，要么同时失败。
	事务操作：
		开启事务： start transaction;
		提交：commit;
		回滚：rollback;
	MySQL数据库中，事务是默认自动提交的：即当执行了一条增删改的语句后，事务就会提交。【了解】
		如果手动开启了事务，但是没有结束，这时如果关闭了sqlyog工具，默认数据会回滚。
		查询数据库的事务提交方式：
			SELECT @@autocommit; -- 1 代表自动提交  0 代表手动提交
		修改数据库事务的提交方式：
			set @@autocommit = 0;
	事务四大特性(ACID/酸性)【重点】：
		原子性(Atomicity)：在事务中的各个逻辑操作，或者都成功，或者都失败，状态都是统一的。
		一致性(Consistency)：在事务前后，数据的总量是不变的
		隔离性(Isolation)：理论上一个事务的执行，不应该受到其他事务的干扰
		持久性(Durability)：一旦事务结束(提交/回滚)，数据就会持久的保存到数据库中

4）隔离级别
	1）介绍：如果不考虑隔离性，则在事务并发时，如果操作同一份数据，就会产生数据安全性问题。要解决这些问题，就需要设置隔离级别
	2）涉及的问题
			脏读
			不可重复读/虚读
			幻读
	3）隔离级别
			read uncommitted：读未提交
			read committed：读已提交 （Oracle）
			repeatable read：可重复读 （MySQL默认）
			serializable：串行化
	
5）MySQL中的用户管理
	1、增删改查用户
		1）mysql中的用户都存在于mysql数据库的user表中
		2）创建：CREATE USER '用户名'@'主机名' IDENTIFIED BY '密码';
				% ：表示任意主机，即我们可以在任何机器上，使用该账号来访问mysql数据库
		3）删除：DROP USER '用户名'@'主机名';
		4）修改：
				UPDATE USER SET PASSWORD = PASSWORD('新密码') WHERE USER = '用户名';【推荐】
					PASSWORD() ：mysql内置函数，它会将数据进行加密
				SET PASSWORD FOR '用户名'@'主机名' = PASSWORD('新密码');
		5）查询：SELECT * FROM USER;		
	2、用户权限管理
		1）查询：SHOW GRANTS FOR '用户名'@'主机名'; 或者 SHOW GRANTS FOR 'lisi'@'%';
		2）授权：grant 权限列表|all on 数据库名.表名 to '用户名'@'主机名';
				例子：GRANT ALL ON *.* TO 'zhangsan'@'localhost';
		3）撤销：revoke 权限列表|all on 数据库名.表名 from '用户名'@'主机名';

	3、重置root账号的密码【建议不要频繁操作】

https://dev.mysql.com/doc/refman/5.7/en/