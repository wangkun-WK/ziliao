=======================================�ع˺͸�ϰ
1�����������涨�û��ɼ����ݵķ�Χ���������Χ�ڵı����е����ݣ��������ύ��
2����ǩ��
	<form>	:����ǩ
		���ԣ�action	�ύ��URL��method	���ύ���ݵ�ʱ�������ʽ��Ĭ��GET�����õ�ȡֵGET|POST
	<input>	:�����ǩ
		type	��text/password/radio/checkbox/file/hidden/submit/button	Ĭ��text
		name	���ύ�����ʱ�򣬱��������
				  �ڵ�ѡ��ť�У�name��ͬ��һ�鵥ѡ��ť���Ϳ���ʵ�ֵ�ѡЧ��
		value	��ֵ
		checked	���ڵ�ѡ��ť�͸�ѡ��ʱ��Ĭ����������ѡ��
	<select>	�������б�
		<option>	�������б���
			����	��value�������б����ֵ���ύ��ʱ����ύ�����������
	<textarea>	��
		ע�⣺ֻ��name���ԣ�û��value���ԡ�ֵ�����ı����ǩ�������岿��
3��CSS
	1��HTML������CSS��
		1��������ʽ	����ǩ��style����
		2���ڲ���ʽ	����<head>��ǩ�У�����<style>��ǩ����ǩ�����ݾ�����ʽ���ڱ�ǩ��ʹ��class�����ö���õ���ʽ
		3���ⲿ��ʽ ����<head>��ǩ�У�ʹ��<link>��ǩ�������ⲿ��ʽ�ļ�
	2����ʽ�����﷨��
		��ʽ����ʽѡ����{������1��ֵ1;������2��ֵ2, ... , ������n��ֵn;}
		ѡ���������ܣ�ɸѡ����������Ԫ��
			#id{}	:
			.className{}	:
			element{}		:
			* {}
			s1, s2, ... , sn {}	:
			parent child{}
			parent > child{}
			s1[attr='value']
		���ԣ�
			background/backgroundColor/backgroundImage
			font-size
			color
			text-align
			width
			height
			border
			padding
			margin
=======================================���ݽ���
JavaScript
	1�����
		1����һ���ͻ��˽ű����ԣ��������������ֱ�ӽ���ִ�С�
		2�����ã�����ҳ��Ķ�̬Ч������У�顣
	2��JavaScript����ɣ�
			ECMASCript	������
			BOM			�����������ģ��
			DOM			���ĵ�����ģ��
	3��JavaScript����(ECMASCript)����⡤���ա�
			1��html����js�����ա�
				* html�ĵ��ڱ�������ʱ�������϶��£�˳��ִ��
				* ����js��
						�ڲ�js�� <script>  js����  </script>
						�ⲿjs�� 1��js�ļ���.jsΪ��չ��	
								 2�������ⲿjs��ʹ��<script src="�ⲿ��js�ļ�·��"></script>
						ע�⣺�ⲿjs���ڲ�js��һ��</script>��ǩ��ֻ��ѡһ��
			2��ע�ͣ���java���ƣ�ֻ�������ĵ�ע��
			3����������
				1��ԭʼ��������
						number		����ֵ��(���ֺ�NaN)
						string		���ַ���
						boolean		��������
						null		��һ��Ϊnull�Ķ���
						undefined	������Ϊ����
				2��������������--->jS����
			4����������
				1�����������ʱ����Ҫָ������:var ������ = ��ʼֵ;
				2����ȡָ���������������ͣ�typeof()
						typeof(null)  ---> object
			5�������
				1��==	���жϵ���ֵ�Ƿ���ȣ�����������Ͳ�һ�£����Ƚ�����ת��Ϊͬһ����
				2��===	��ȫ�ȡ�ֵҪ�Ȳ����������
				3��û��&��|λ������š�ֻ��&& || !
						��ʹ�á�!�����������boolean�����ת����ת���Ĺ���Ӧ�á�
							number->boolean: 0|NaN -> false, ����true
							string->boolean: null|undefined|"" -> false, ����true
							object->boolean: null|undefined -> false, ���������true
				4��switch����п��Խ��յ���������������ԭʼ��������
						number
						string
						boolean
						null
						undefined
				5����������Function
						���巽����	function ������(�����б�){}/var ������ = function(){}
						�ص㣺
							1�������Ĳ���û�����ͣ�����Ҳ����Ҫ��������
							2�����������һ���������Ķ��帲��ǰ��Ķ���
							3����������ֻ�ͷ����������
							4�����������ö���arguments,��ʾ�������յ���ʵ�ʲ�����ɵ�����
				6������Array
						���壺new Array()/[el1,el2, ..., eln]/new Array(el1,el2, ... , eln)/new Array(size)
						���ԣ�length
						������join()�� push()
						�ص㣺1�����Դ���������� 2�����ȿɱ�
				7�����ڶ���
						������new Date()
						������getTime()	��ȡʱ���
				8����ѧ����Math
						��ʶ��Math����ֱ���ü���
						������random()	/	round()	/ceil()	/floor()