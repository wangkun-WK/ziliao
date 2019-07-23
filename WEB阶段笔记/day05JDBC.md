=======================================�ع˺͸�ϰ
1��������ϲ�ѯ
	���Ӳ�ѯ��
		�����Ӳ�ѯ��
		��/�������Ӳ�ѯ��
	�Ӳ�ѯ��
2������
	����ĸ����Լ�������Ĵ����ԣ�
	����ĸ��뼶��
3��mysql�û�����(DCL���)
	�û�������
	��Ȩ������

=======================================JDBC
1��������
	1��JDBC��һ��ʹ��Java�������ݿ�Ĺ淶(�ӿ�)���ӿڶ�Ӧ��ʵ���࣬�ɸ����ݿ⳧���ṩ������װ��һ��jar���С�
2�����裺
	1������jar	
	2��ע������
		Class.forName("������ȫ�޶�����")��MySQL�������ࣺcom.mysql.jdbc.Driver
	3����ȡ����
		DriverManager.getConnection("jdbc:mysql:///test", "root", "root")
	4����ȡִ��sql�Ķ���
		conn.createStatement()
	5��ִ��sql
		stmt.execute(sql)/executeUpdate(sql)/executeQuery(sql)
	6��������

	7���ͷ���Դ
		stmt.close()
		conn.close()
3��API������java.sql����
	1��class DriverManager
			1��ע������������һ�㶼��:Class.forName("������ȫ�޶�����")
			2����ȡ����
				������static Connection getConnection(String url, String user, String password) 
				url�Ľ��ܣ�
					�﷨��jdbc:mysql://ip��ַ(����):�˿ں�/���ݿ�����
						jdbc	��jdbcЭ��
						mysql	����Э��
					һ��������ӵ��Ǳ��ص�mysql�����Ҷ˿���3306����ôurl�Ϳ��Լ�д��jdbc:mysql:///���ݿ�����
	2��interface Connection
			1. ��ȡִ��sql �Ķ���
				* Statement createStatement()
				* PreparedStatement prepareStatement(String sql)  �����á�
			2. ��������jdbc��������Ĭ���Զ��ύ��
				* ��������setAutoCommit(boolean autoCommit) �����ø÷������ò���Ϊfalse������������
				* �ύ����commit() 
				* �ع�����rollback() 
	3��interface Statement
			1�� ִ��sql
				boolean execute(String sql) ������ִ�������sql �˽� 
					false��ִ����insert/update/delete��䣬ʹ��statement.getUpdateCount()��ȡӰ�������
					true��ִ����select��䣬ʹ��statement.getResultSet()����ȡ�����
				���ص㡿int executeUpdate(String sql) ��ִ��DML��insert��update��delete����䡢DDL(create��alter��drop)���
					* ����ֵ��Ӱ�������������ͨ�����Ӱ��������ж�DML����Ƿ�ִ�гɹ� ����ֵ>0����ִ�гɹ�����֮����ʧ�ܡ�
				���ص㡿ResultSet executeQuery(String sql)  ��ִ��DQL��select)���
			2��ִ���������˽⡿
				addBatch(String sql) ����sql��ӵ���������
				clearBatch() ������������е�sql
				executeBatch() ��ִ���������е�sql
	4��interface ResultSet
			1������
					next()	:�ж��α��Ƿ��ߵ����һ��ĩβ�����û���򷵻�true��������򷵻�false
					getXxx()	:getInt()/getString()/getDouble()/getDate().../getObject()
						���������������֣���������ֱ�ʾ�еı�ţ���1��ʼ��������ַ�����ʾ����
			2������
					while(rs.next()){
						��ȡ����...
					}
							
	5��interface PreparedStatement
			1��sql��ע��©����
				��ʹ��ƴ�ӵķ�ʽ��֯sql����ʱ�����ڱ����к���sql�ؼ��֣�����sql�ṹ�����˱仯���ò���Ԥ�ڵĽ��
			2��sql��ע��©���Ľ����
				PreparedStatement��Ԥ����sql�����ڴ���sql�Ĳ���֮ǰ�Ƚ�sql�ĸ�ʽ�̶����������ݵı���ֵ��ֻ���ǲ�����ֵ���Ͳ����sql��ʽ����Ӱ��
					1��Ԥ����sql����?ռλ
					2����ȡPreparedStatement �� conn.prepareStatement(sql)
					3�����ò���
							setXxx(int index, Xxx value) index: ��1��ʼ����ʾ?��λ�á�
					4��ִ��sql���
							execute()/executeUpdate()/executeQuery() :�����޲εķ���


4��JDBC�����ࡾӦ�á�
	1�������ļ���һ�㽫�����еĶ�̬������ȡ��Ŀ�ľ��ǵ��޸Ĳ�����ʱ�򣬲����޸��ࡣ��ô��Ҳ�Ͳ������±����ˡ�
			���ࣺ
				���������ļ�����.properties��β�����������Լ�ֵ����ʽ��š�һ����ֵ�Ծ���һ�����ݣ�����ֵ֮���á�=������
					driver=com.mysql.jdbc.Driver
					ע�⣺���������ļ������е��ַ�������Ҫ���""������
				xml�����ļ���������˵
			���������ļ���
				properties�����ļ�����ʹ��Properties����������
					new Properties().load(�ļ����ֽ�������)
			��ȡ��Ŀ�е��ļ�·����
				ʹ���������
					String filePath = ��.class.getClassLoader().getResource("�ļ���").getPath();
					InputStream in = ��.class.getClassLoader().getResourceAsStream("�ļ���");
	2��������ĳ�ȡ
		1����ȡ���Ӷ���(������ע������)
		2���ͷ���Դ

5��CRUD�������ص㡿��
	1�����Statement��CURD
	2�����PreparedStatement��CRUD
	