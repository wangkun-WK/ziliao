=======================================�ع˺͸�ϰ
1��������ʽ����
		1������	��new RegExp("������ʽ")
				  /^������ʽ$/	�����á�
		2������ ��test()
		3��������ʽ��
			\w	\d	+	*	?	{m, n}	[]
2��Global����ķ���(ȫ�ַ���)
		
3��BOM�������������ģ�ͣ����������ÿһ���ַ�װ��һ�����󣬷��������	
		Window	��Location��	History	��Screen��	Navigator

4��DOM����
		DOM	���ĵ�����ģ�ͣ�����������ĵ����ص��ڴ����γ�һ�����νṹ��������Խṹ����document��
		���ࣺ����DOM��XML DOM��HTML DOM
			* ���еı�ǩ����Ԫ��(Element)
			* ��ȡԪ�ض���
					getElementById()
					getElementsByTagName()
					getElementsByClassName()
					getElementsByName()
			* �޸�Ԫ��
					* �޸�Ԫ�ص�����ֵ��Ԫ�ض���.���� = ֵ
					* �޸�Ԫ�صı�ǩ������	��Ԫ�ض���.innerHTML = ֵ(HTML����)

=======================================���ݽ���
1��DOM����⡤���ա�
	1��Element
		������setAttribute(attrName, attrValue)
			  removeAttrbute(attrName)
	2������Element
			setAttribute(attrName, attrValue)
			removeAttrbute(attrName)
			removeChild()
			appendChild()

	3��Node���˽⡿
			* ���е�DOM����ĸ�����
			* ���ڵ�.removeChild(�ӽڵ�)
			* ���ڵ�.appendChild(�ӽڵ�)
			* parentNode	����ȡ��ǰ�ڵ�ĸ��ڵ�

	4��<a href="javascript:void(0);" onclick="delTr(this);">ɾ��</a>
			* �����this������ǵ�ǰ��������¼������(�¼�Դ)������������this�ʹ������a��ǩ����

	5���޸Ļ��߻�ȡhtml�ı�ǩ������
			* innerHTML	�������б�ǩ������û�б�ǩ����Щ��ǩҲ�ᱻ���������
			* innerText ����ȡ��ʱ����Ա�ǩ�����õ�ʱ���ǩ���ᱻ�����������ֻ����Ϊһ����ͨ�ַ�������
	6���޸�Ԫ�ص���ʽ
			* Ԫ�ض���.style.attrName = attrValue;		:����ж����ʽ���ԣ������ǲ������
			* Ԫ�ض���.className = "className"			:���ֵ��ʱ��ȽϷ���

2��JS�¼���Ӧ�á�
	1���¼���������
			�¼���
			�¼�Դ��
			��������
			ע�������
	2���¼��İ�
			* <input onclick="����();">
			* ��ǩ����.onclick = function(){}
	3�����õ��¼�
			* onclick	�������¼�
			* onload	��ҳ�������ɺ�ִ��
			* onsubmit	�����ύʱ����ִ��
					��form.onsubmit = function(){return true|false;}	:����false����ֹ���ύ��������ύ
					��<form action="" method="get" id="form1" onsubmit="return checkForm();">	:onsubmit���Ա�����һ��js���룬�з���ֵ������false����ֹ���ύ��������ύ
	
3��BootStrap��Ӧ�á�
	1�����ܣ�
		* ǰ�˵�֧����Ӧʽ���ֵĿ�ܣ�����HTML��CSS��JS��
		* ���ƣ�
				1��������һ���׵���ʽ�Լ���������ǿ�������ҳ��ֱ��ʹ�ã����Ч������
				2��֧����Ӧʽ��һ��ҳ�棬���ݲ�ͬ�ķֱ��ʵ��豸������
		* �������ţ�
				* Ŀ¼��
					js	������Ĳ���Լ���������Ч��jsʵ��
					css	����ʽ�ļ���
					fonts �������ͼƬ����ʽ
				* Bootstrap ������ JavaScript ��������� jQuery����� jQuery ������ Bootstrap ֮ǰ���롣
					bower.json  ==��"jquery": "1.9.1 - 3"
				* ������Դ��
					css/bootstrap.min.css
					js/jquery.min.js
					js/bootstrap.min.js
	2��դ��ϵͳ
		* ������(.container, .container-fluid)�е�һ��(.row)�ֳ�12�ȷ֡��ڲ���Ԫ�ص�ʱ��ֻ��Ҫ����bootstrap���Ԫ��ռ��һ�еļ���դ�񼴿�(.col-��Ļ����-������)
				container���̶���ȣ���������
				container-fluid��������Ļ
		* ��bootstrap�У�����ʵ�г��������ø��ݷֱ��ʷֳ���4�ࣺ
					��С��Ļ �ֻ� (<768px)			��xs
					С��Ļ ƽ�� (��768px)			��sm
					�е���Ļ ������ʾ�� (��992px)	��md
					����Ļ ��������ʾ�� (��1200px)	��lg
		* ʹ�ã�
				���� -> �� -> �� -> �� -> ��
		* ע�⣺
				* ÿһ��12�У�����12�л���
				* ����ʽ���ϼ��ݣ�����Ĭ��һ��Ԫ��ռһ��
	3����ʽ������������ʹ��