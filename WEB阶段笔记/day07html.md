=======================================�ع˺͸�ϰ
1���������
	Connection	��setAutoCommit(false)	��������, JDBCĬ�ϵ������������Զ���
				  commit()	�ύ����
				  rollback()	�ع�����
2�����ӳ�
	�淶��javax.sql.DataSource
	���ӳؼ�����
		C3P0	��
			1������c3p0-config.xml�ļ���λ��src��
			2���������ӳض���new ComboPooledDataSource()
		Druid	:
			1�����������ļ� *.properties��λ�����⣬һ���������src��
			2���������ӳض���
					1������Properties����	Properties pro = new Properties();
					2�����������ļ�			pro.load(��.class.getClassLoader().getResourceAsStream("�����ļ�"));
					3���������ӳض���		DruidDataSourceFactory.createDataSource(pro);
3��JdbcTemplate
	1������jdbctemplate		new JdbcTemplate(dataSource);
	2������
			int update(String sql, Object... args)	:ִ��insert/update/delete���
			List<T> query(String sql, RowMapper<T> rowMapper, Object... args)	:ִ��select���
						����ѯ������¼�����ҽ�ÿһ����¼����װ��һ��T����Ȼ��T����װ��list�����У����ء�
						��һ�㣬���Լ�ʵ��RowMapper��ʹ������ʵ���� BeanPropertyRowMapper
									new BeanPropertyRowMapper<Entity>(Entity.class)
			T queryForObject(String sql, Class<T> clazz, Object... args)	:ִ��select���
						��ִ�оۺϺ������ص�ֵ����
								Integer i = queryForObject("select count(*) from user", Integer.class);
						��ִ��select����ѯһ����¼�����ҽ�һ����¼��װ��һ������
								User user = queryForObject("select * from user where id = ?", new BeanPropertyRowMapper<User>(User.class), 1);
						��ע�⣺�����ѯ��һ����¼����ô�ͻᱨ��
=======================================
��̬��ҳ������
	HTML	CSS		JavaScript(JS)		BootStrap		xml

1��web��һЩ����֪ʶ
	web��������Ӧ�õ��ܳ�
	javaweb��ʹ��java����������Ӧ��
	javaee��ʹ��java����������Ӧ�õ�ʱ�����ص�һЩ�淶

	web�г���������ܹ���
		C/S	:	
				���ƣ������
				���ƣ�������ά����Ҫά�����������һ���Ƿ������������һ���ǿͻ���������ɱ��ߡ�
					  �����������������£���ô�ͻ��˾���Ҫ��������
		B/S	:	
				���ƣ�ֻ��Ҫ�����������˼��ɣ��ɱ���С
				���ƣ����еĿ������ڷ������ˣ���������ѹ���ܴ������Բ�
						�����ѹ����	��ajax���
						�����Բ�		��html5 + css3
	web����ɣ�
		web�ͻ���	��ʹ��������䵱
		web������	����װ��web����������ĵ��ԣ���������web��Դ���ͻ��˿���ͨ����ַ�����������Դ

	web����Դ��
		��̬��Դ���κ�ʱ���κη�ʽ������ͬһ����Դ��Ч������һ���ġ������ľ�̬��Դ�У�HTML��CSS��JS��ͼƬ����ý�塢...
				  �ص㣺���������ֱ�ӽ�����̬��Դ
		��̬��Դ��ʹ�ö�̬��ҳ������������Դ����java�г����Ķ�̬��Դ�У�JSP/Servlet
				  �ص㣺���뾭��������������̬��Դת��Ϊ��̬��Դ�����ܸ��ͻ���

	* ��̬��Դ��
		* HTML�����ڴ������ҳ��չʾҳ�������
		* CSS����������ҳ�棬����ҳ��
		* JavaScript������ҳ���Ԫ�أ���ҳ����һЩ��̬��Ч��

2��HTML��ѧϰ����Ҫѧϰ��ǩ��ʹ��
	1��html�������ı�������ҳ�����еĻ�������
			���ı������ı����ó����ӵķ����������ֲ�ͬ�ռ��������Ϣ��֯��һ�����״�ı�.
			�������(��ǩ����)�������ɱ�ǩ��ɡ���ǩ: <��ǩ����>
	2����������
		��չ����.htm(�ϰ汾)	.html�����á�
		��ǩ��Ƕ��ʹ��ʱ��˳����û�й̶���˵����
	3����ǩ
		1���ļ���ǩ(�ṹ��ǩ)
				<title>	:������ʾ����ҳ��ҳǩ��
				<body>	:������ʾ����ҳ��
		2���ı���ǩ
			font��ǩ
				���ԣ�size�������ı�����Ĵ�С	ȡֵ1~7
		3��ͼƬ��ǩ
			<img src="ͼƬ·��">
					ͼƬ·����д����
							���·�������á���	��.��ͷ��·�����Ե�ǰҳhtmlҳ������λ��Ϊ����
									./ ����ǰ·��
									../����һ��·��
							����·����  ��"/"��ͷ
		4���б�
			<ol>	�����б�
				���ԣ�type=����	start=����
			<ul>	�����б����á�
				���ԣ�type=����
			<li>	�б���

		5��������	<a>
			���ԣ�href�������У���ʾҪ��ת����ҳ��ַ�����Ϊ���ˣ���ת��ǰҳ��
						  ��ǰ�����������תҳ�棬�����е����Ч������ô������href="#"
				  target����ʾ���ĸ��ط���
				  			_self	:Ĭ�ϣ���ǰҳ���
							_blank	:�´�һ����ҳ
		6�����ǩ���˽⡿
			<span>	:�м����ǩ����������ݵĿ�ȣ����ỻ��
			<div>	:�鼶���ǩ��Ĭ�϶�ռһ��
		7�����廯��ǩ
			<header>
			<footer>
		8������ǩ	:���ã�1����ʾ�б�����	2������
			��ʽ��
				<table>				��������Χ
					<tr>			��������
						<td>|<th>	�����嵥Ԫ��	ע�⣺���ݶ���td����th�ĵ�Ԫ����
						...
					</tr>
					...
				</table>

			���ܣ�
			* table��������
				* width�����
				* border���߿�
				* cellpadding���������ݺ͵�Ԫ��ľ���
				* cellspacing�����嵥Ԫ��֮��ľ��롣���ָ��Ϊ0����Ԫ����߻��Ϊһ����
				* bgcolor������ɫ
				* align�����뷽ʽ
			* tr��������
				* bgcolor������ɫ
				* align�����뷽ʽ
			* td�����嵥Ԫ��
				* colspan���ϲ���
				* rowspan���ϲ���
			* th�������ͷ��Ԫ��
			* <caption>��������
			* <thead>����ʾ����ͷ����
			* <tbody>����ʾ�����岿��
			* <tfoot>����ʾ���ĽŲ���
			