=======================================�ع˺͸�ϰ
SQL���ṹ����ѯ���ԣ���ר������������ϵ�����ݿ�ģ����ࣺ
	DDL/DML/DQL/DCL
MySQL�Ĵ洢�ṹ��
	һ��mysql���ݿ�������ϣ����ж�����ݿ�
	һ�����ݿ��»��ж��ű�
	һ�ű��л��ж�����¼�����еļ�¼����������˵������
SQL�������ݿ⣺
	������create database ���ݿ���
	ɾ����drop database ���ݿ���
	�鿴��show databases;
		  show create database ���ݿ���;
		  select database();
SQL�������ݿ��
	1����������������
			��ֵ��	��int double float
			�ַ����ͣ�varchar char
			�����ͣ�date datatime timestamp
	2������
			create table ���� (�ֶ�1 ����1, ... , �ֶ�n ����n);
	   �޸�
	   		alter table ���� ...
	   �鿴
	   		show tables;
			show create table ����;
	   ɾ�� 
	   		drop table ����
SQL���������ݡ��ص㡿
	������ݣ�
		insert into ���� [(�ֶ�1, �ֶ�2, ... ,�ֶ�n )] values (ֵ1, ֵ2, ... , ֵn)
		���Ʊ��Լ����ݡ��˽⡿��
			��һ��д����
				create table �±� like ԭʼ��; -- ���Ʊ�ṹ
				insert into �±� select * from ԭʼ��
			�ڶ���д����
				create table �±� as select * from ԭʼ��
	ɾ�����ݣ�
		delete from �� [where ����]	
		truncate table ��
	�޸����ݣ�
		update �� set �ֶ�1= ֵ1, �ֶ�2= ֵ2, ... ,�ֶ�n= ֵn [where ����]
	��ѯ��
		select [distinct] *|[�ֶ�1, �ֶ�2, ..., �ֶ�n] from �� [where ����]

=======================================���ݽ���
1����ѯ(DQL)�����ա�
	1�������ѯ
		�ؼ��֣�order by �ֶ� �������,�ֶ� �������,�ֶ� �������,...
		������� ASC ����(Ĭ��)	DESC(����)
	2���ۺϺ����ͷ���
		1���ۺϺ���
				count	:��ʾ��¼��
				sum/max/min/avg	����һ�н�����ѧ���㡣ʹ����Щ�ۺϺ����������һ������ֵ��
						ifnull()	����nullֵ�滻��ָ����ֵ
		2�����麯��
				�ؼ��֣�group by
				д����select�־�������һ���Ƿ�������������ǾۺϺ���
					  ����ڷ���֮ǰ��������ɸѡ����ô����group by֮ǰ����where�Ӿ䣻����Է���ۺ�֮��Ľ������ɸѡ����ô����Ҫ��group by֮�����having
					
	3����ҳ��ѯ
			�ؼ��֣�limit a, b
					a ����ʼ������mysql������������0��ʼ	a�ļ��㹫ʽ��(��ǰҳ-1)*ÿҳ��¼��
					b �����������¼
			����д����
					limit 5	����ѯǰ������¼

	ͨ�õ�sql��
		S(select) ... F(from) ... W(where) ... G(group by) ... H(having) ... O(order by) ... l(limit)	

2��Լ����Ӧ�á�
	��������ݱ��е����ݶ���һЩ�������صĹ��򣬱�֤���ݵ���ȷ�ԡ���Ч�Ժ������ԡ�
	���Լ���ķ�ʽ��
		1���ڽ����ʱ�����
		2���޸ı���ֶ����
	����
		����Լ��:
			1���ǿ���Ψһ����ʾһ����¼Ψһ������������¼�ı�ǡ�
			2��һ�ű���ֻ����һ���������������п�����һ���У�Ҳ�����Ƕ����(��������)
			3���������Լ��
				����ʱ��ӣ�
					create table stu(id int primary key , name varchar(20))		-- ��������
					create table stu(id int, cid int, name varchar(20), primary key (id, cid)) -- ��������
				�޸��ֶ�ʱ��ӣ�
					ALTER TABLE stu MODIFY id INT PRIMARY KEY;
			4��ɾ������
					alter table stu drop primary key;
		ΨһԼ��: �е�ֵ��Ψһ��
			1��ΨһԼ����nullֵ��Ч
			2������ʱ��ӣ�
					CREATE TABLE stu(
						id INT,
						phone_number VARCHAR(20) UNIQUE -- �����ΨһԼ��
					
					);
				�޸��ֶ�ʱ��ӣ�
					ALTER TABLE stu MODIFY phone_number VARCHAR(20) UNIQUE;

			3��ɾ����ALTER TABLE stu DROP INDEX �ֶ�;

		�ǿ�Լ��: �е�ֵ����Ϊnull
			1����ӷǿ�Լ��
					����ʱ���
						CREATE TABLE stu(
							id INT,
							phone_number VARCHAR(20) not null -- ����˷ǿ�Լ��
						
						);
					�޸��ֶ�ʱ���
						ALTER TABLE stu MODIFY NAME VARCHAR(20) NOT NULL;
			2��ɾ���ǿ�Լ��
					ALTER TABLE stu MODIFY NAME VARCHAR(20);
	���
		���Լ��:������ʾ�����֮��Ĺ�ϵ,ʱΪ�˱�֤�����֮������ݵ�������
			������
				create table ����(
					....,
					constraint ������� foreign key (���������) references ��������(����������)
				);
				����
				alter table �� add constraint ������� foreign key (���������) references ��������(��������������);
			ɾ����
				alter table tb_emp drop foreign key �������;

			�����������˽⡤���á�
				�������£�ON UPDATE CASCADE
				����ɾ����ON UPDATE CASCADE
				ALTER TABLE ���� ADD CONSTRAINT ������� 
					FOREIGN KEY (����ֶ�����) REFERENCES ��������(����������) ON UPDATE CASCADE ON DELETE CASCADE  ;
		
3�����Ĺ�ϵ�Լ���Ľ���ԭ��Ӧ�á�
	һ��һ���˽⡿
		����ԭ��������һ�����������ָ����һ�ű��������������������ǿ�Ψһ��
			һ�����һ�ű���������ڽ��������ָ����һ�ű��������
	һ�Զ�
		����ԭ���ڶ��һ�����������ָ��һ��һ��������
	��Զ�
		����ԭ�򣺽��������ű�����������������ֱ�ָ�����ű������
4�����ݿ�����ʽ���˽⡿
	1����ʽ�����ݿ���Ƶ�һЩ���򣬵�������������Щ����֮��������Ƶ����ݿ⽫�����������������������ó������и���Ч�����С�
	2����ʽ�����֣�����ֻ����ǰ����:
		1NF������ԭ�ӵģ������ڷ�
		2NF����1NF�����ϣ������������ݣ���������֮�������������
		3NF�����ϵ��������ⶼ�ܽ��
		�ܽ᣺����������������ʽ�����������ݿ���ƹ����г��ֵ��������ࡢ���ݵ��޸�ʱ���໥Ӱ��ͻᱻ��������
5�����ݿ����ݵı��ݺͻ�ԭ��Ӧ�á�