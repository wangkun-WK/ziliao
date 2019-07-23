=======================================�ع˺͸�ϰ
1��JDBC����
	JDBC:Java�������ݿ��һ�׹淶(�ӿ�),ʵ�����ɸ����ݿ⳧���ṩ,�����������������ݿ��ʱ����Ҫʹ�õ�����jar��
2��JDBC����
	׼������������jar��
	1��ע������
			Class.forName(�������ַ���)
	2����ȡ����
			DriverManager.getConnection(url, username, password);
				url����д��ʽ��
					jdbc:mysql://localhost:3306/db3	===��jdbc:mysql:///db3
	3������ִ��sql�Ķ���
			conn.createStatement();	������
			conn.prepareStatement(String sql);	�����ã������sqlע�����⡿
	4��ִ��sql
			Statement ��ִ��sql
			PreparedStatement	�����sql����?�ţ���Ҫ���ò��������������֮��ִ��sql
				execute(String sql)/execute()
				executeUpdate(String sql)/executeUpdate()
				executeQuery(String sql)/exeuteQuery()
	5��������

	6���ͷ���Դ
3��JDBC API
		DriverManager	��
		Connection		��
		Statement/PreparedStatement	��
		ResultSet		��

=======================================���ݽ���
1��JDBC���������Ӧ�á�
2�����ݿ����ӳء���⡿
		���ӳأ�����˺ܶ�����ӵļ��ϣ�������Ҫ�������ݿ��ʱ�򣬾ʹ����ӳ��л�ȡ�Ѿ���ʼ���õ�һ������ʹ�ã�����ִ����ɺ󣬹黹���ӵ����ӳء�
		���ƣ�������ӵĸ����ԣ��������ݿ���Դ������
		ʵ�֣�1�����е����ӳؼ�����ʵ����javax.sql.DataSource�ӿ�
			  2������
					��ȡ���ӣ�getConnection()
					�黹���ӣ�close()	,��ʵ�ʾ��������ڴ������ӵ�ʱ�򣬽����ӵ�close()������ǿ�ˣ������ǹرն��ǹ黹��
		���������ӳؼ�����
			C3P0	��
				���Ķ���ComboPooledDataSource
								������getConnection()
				�����ļ���
					1��c3p0.properties ���� c3p0-config.xml(����) �� ����һ�����ɡ�
					2������src��
				ʹ�ã�
					1��new ComboPooledDataSource() ʹ��Ĭ�����ã���xml�ļ���<default-config>�е�����
					2��new ComboPooledDataSource("configName") ʹ��ָ�����Ƶ����ã���xml�ļ��е�<named-config name="configName">�е����á�
								���configNameû�ж�Ӧ�����ã�����ʹ��Ĭ�ϵ�����
			Druid	��
				1���������ӳصķ�ʽ:	DruidDataSourceFactory.createDataSource(properties)
				2�������ļ�
					1�����������ļ� .properties
					2���κεط����κ����ƶ�����
					3���ֶ����������ļ�
3��JDBC�Ĺ����ࡾ���ա���JdbcTemplate	==��Spring�����
	1����ʶ������һ��jdbc�����࣬ʹ���������sql��ִ��
	2��������
			update(String sql, Object... args)	:insert/update/delete
			query(String sql, RowMapper<T> rowMapper, Object... args)	:select
				* ��ѯ���м�¼����ÿһ����¼��װ��һ��JavaBean���󣬲��ҽ���ЩJavaBean�����װ��һ��List��
				* RowMapper<T> :��һ����¼��װ��һ��T���󣬿����Լ�ʵ��Ҳ����ʹ������ʵ���ࡣ
						һ�����ǻ�ʹ������ʵ���ࣺBeanPropertyRowMapper,ʹ�����£�
						jdbcTemplate.query("select * from emp", new BeanPropertyRowMapper<Emp>(Emp.class))
			queryForObject(String sql, Class<T> clazz, Object... args)	:select, һ��ִ��һ���ۺϺ���
				* jdbcTemplate.queryForObject("select count(*) from emp", Integer.class)
				* ע�⣺������Ƿ���һ�����󣬷����ᱨ��
				* ���Բ�ѯһ������
						@Test
						public void test_queryForObject_Object(){
							String sql = "select * from tb_user where uid = ?";
							User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), 2);
							System.out.println(user);
						}
			queryForMap()		���˽⡿��ѯһ����¼������¼��װ��һ��Map���ֶ�����Ϊkey���ֶε�ֵΪvalue��
			queryForList()		���˽⡿��ѯ������¼����ÿһ����¼����װ��һ��Map���ٽ���ЩMap��װ��һ��List��
	3�����裺
		1������JdbcTemplate����	��  new JdbcTemplate(JDBCUtils.getDataSource())
		2���ṩsql�Լ�sql��Ҫ�Ĳ�����ִ��sql��䣺	������صķ���
		3��������

	4��Junit��jar
		hamcrest-core-1.3.jar
		junit-4.12.jar
=======================================����
emp��Ϊ����������ҵ����
	1����ѯ���е�Ա��
	2����ѯָ��id��Ա��
	3����ѯԱ������
	4����ѯ����Ա��

=======================================
public class TransactionTest {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //��ȡ����
            conn = JdbcUtils.getConnection();
            //��������
            conn.setAutoCommit(false);
            //����sql
            String sql = "update account set balance = balance + ? where name = ?";
            //Ԥ����sql
            pstmt = conn.prepareStatement(sql);
            //���ò���  ������ -500
            pstmt.setDouble(1, -500);
            pstmt.setString(2,"zhangsan");
            //ִ��sql
            pstmt.executeUpdate();

            int i = 1 / 0;

            //���õڶ������
            pstmt.setDouble(1, 500);
            pstmt.setString(2, "lisi");
            //ִ��sql
            pstmt.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            //����ع�
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