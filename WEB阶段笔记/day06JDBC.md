=======================================回顾和复习
1）JDBC介绍
	JDBC:Java连接数据库的一套规范(接口),实现类由各数据库厂商提供,所以我们在连接数据库的时候，需要使用到驱动jar包
2）JDBC步骤
	准备：引入驱动jar包
	1）注册驱动
			Class.forName(驱动类字符串)
	2）获取连接
			DriverManager.getConnection(url, username, password);
				url的书写格式：
					jdbc:mysql://localhost:3306/db3	===》jdbc:mysql:///db3
	3）创建执行sql的对象
			conn.createStatement();	不常用
			conn.prepareStatement(String sql);	【常用，解决了sql注入问题】
	4）执行sql
			Statement ：执行sql
			PreparedStatement	：如果sql中有?号，需要设置参数，设置完参数之后，执行sql
				execute(String sql)/execute()
				executeUpdate(String sql)/executeUpdate()
				executeQuery(String sql)/exeuteQuery()
	5）处理结果

	6）释放资源
3）JDBC API
		DriverManager	：
		Connection		：
		Statement/PreparedStatement	：
		ResultSet		：

=======================================内容介绍
1）JDBC的事务管理【应用】
2）数据库连接池【理解】
		连接池：存放了很多个连接的集合，当程序要连接数据库的时候，就从连接池中获取已经初始化好的一个连接使用，程序执行完成后，归还连接到连接池。
		优势：提高连接的复用性，降低数据库资源的消耗
		实现：1）所有的连接池技术都实现了javax.sql.DataSource接口
			  2）方法
					获取连接：getConnection()
					归还连接：close()	,其实质就是连接在创建连接的时候，将连接的close()方法增强了，不再是关闭而是归还。
		常见的连接池技术：
			C3P0	：
				核心对象：ComboPooledDataSource
								方法：getConnection()
				配置文件：
					1）c3p0.properties 或者 c3p0-config.xml(常用) ， 任意一个即可。
					2）放在src下
				使用：
					1）new ComboPooledDataSource() 使用默认配置，即xml文件中<default-config>中的配置
					2）new ComboPooledDataSource("configName") 使用指定名称的配置，即xml文件中的<named-config name="configName">中的配置。
								如果configName没有对应的配置，它会使用默认的配置
			Druid	：
				1）创建连接池的方式:	DruidDataSourceFactory.createDataSource(properties)
				2）配置文件
					1）属性配置文件 .properties
					2）任何地方，任何名称都可以
					3）手动加载配置文件
3）JDBC的工具类【掌握】：JdbcTemplate	==》Spring框架中
	1）认识：就是一个jdbc工具类，使用它来完成sql的执行
	2）方法：
			update(String sql, Object... args)	:insert/update/delete
			query(String sql, RowMapper<T> rowMapper, Object... args)	:select
				* 查询所有记录，将每一条记录封装成一个JavaBean对象，并且将这些JavaBean对象封装到一个List中
				* RowMapper<T> :将一条记录封装成一个T对象，可以自己实现也可以使用它的实现类。
						一般我们会使用它的实现类：BeanPropertyRowMapper,使用如下：
						jdbcTemplate.query("select * from emp", new BeanPropertyRowMapper<Emp>(Emp.class))
			queryForObject(String sql, Class<T> clazz, Object... args)	:select, 一般执行一个聚合函数
				* jdbcTemplate.queryForObject("select count(*) from emp", Integer.class)
				* 注意：如果不是返回一个对象，方法会报错
				* 可以查询一个对象：
						@Test
						public void test_queryForObject_Object(){
							String sql = "select * from tb_user where uid = ?";
							User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), 2);
							System.out.println(user);
						}
			queryForMap()		【了解】查询一条记录，将记录封装成一个Map，字段名称为key，字段的值为value，
			queryForList()		【了解】查询多条记录，将每一条记录都封装成一个Map，再将这些Map封装到一个List中
	3）步骤：
		1）创建JdbcTemplate对象	：  new JdbcTemplate(JDBCUtils.getDataSource())
		2）提供sql以及sql需要的参数，执行sql语句：	调用相关的方法
		3）处理结果

	4）Junit的jar
		hamcrest-core-1.3.jar
		junit-4.12.jar
=======================================需求
emp表为例【课外作业】：
	1）查询所有的员工
	2）查询指定id的员工
	3）查询员工总数
	4）查询张姓员工

=======================================
public class TransactionTest {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //获取连接
            conn = JdbcUtils.getConnection();
            //开启事务
            conn.setAutoCommit(false);
            //定义sql
            String sql = "update account set balance = balance + ? where name = ?";
            //预编译sql
            pstmt = conn.prepareStatement(sql);
            //设置参数  给张三 -500
            pstmt.setDouble(1, -500);
            pstmt.setString(2,"zhangsan");
            //执行sql
            pstmt.executeUpdate();

            int i = 1 / 0;

            //设置第二组参数
            pstmt.setDouble(1, 500);
            pstmt.setString(2, "lisi");
            //执行sql
            pstmt.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            //事务回滚
            try {
                if(conn != null) {
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.releaseResources(pstmt, conn);
        }
    }
}