=======================================�ع˺͸�ϰ
1��JavaScript
	1�����ܣ��ͻ��˽ű����ԣ���ҪǶ�뵽������У������������ִ�С������ã�1�����ҳ��Ķ�̬Ч�� 2����У��
	2��JavaScript����ɣ�
			ECMAScript + BOM + DOM
	3��JS������
			1��HTML����JS	��<script>
					* <script>JS����</script>
					* <script src="js·��"></script>
			2��ע��	
			3�������Ķ���
					* �������ͣ�
					* �������壺
			4�������
			5�����̿������
			6������
					���壺
						* function ������(�����б�){}
						* var ������ = function(�����б�){}
					���ã�
						������(����)
			7�����飺
					���壺
						* [el1, el2, ... , eln]
						* new Array();
						* new Array(el1, el2, ... , eln)
						* new Array(size)
					������
						* join()
						* push()
			8�����ڶ���
					������
						* new Date()
					������
						* getTime()
			9��Math���󣺹��ߣ�����Ҫ������ֱ��ʹ��
					������
						* ceil()
						* floor()
						* round()

=======================================���ݽ���
1��JS����(����)��Ӧ�á���
	1��������ʽ����[�˽�]��
			* ������ʽ����Ҫ��У���ַ����Ƿ��͹���һ�����ڱ�У��ʱ��
				[0-9a-zA-Z_]
				\w
				\d
				n{m, n}
				+
				*
				?
			* ������ʽ������������ʽ�����Ķ���ͨ����������ṩ�ķ��������Զ���֪���ַ�������У�飬�ж��ַ�����ʽ�Ƿ���Ϲ���
					����:
						new RegExp("������ʽ")
						/������ʽ/	�����á�
								ע�⣺/������ʽ/����ͨ������ʽ����������ֻҪ�ַ�������һ������Ҫ��ľͷ���true
									  /^������ʽ$/,���е��ַ������붼����Ҫ�󣬲ŷ���true�������á�
					����:
						test() :��֤�ַ����Ƿ���Ϲ�����������򷵻�true
	2��Global�з�����
			encodeURI()/decodeURI()	:��url�����еĲ������ֽ���URL����/����
			encodeURIComponent()/decodeURIComponent()	����url��������URL����/����
			parseInt()	�������ַ����͵���ֵ���ݣ����������������ʼλ���Ƿ���ֵ����᷵��NaN�����򣬻ᰴ������ֵ��һת��
			seFloat()	
			eval()	����һ���ַ�����ʽ��js����ֱ��ִ��
2��BOM����
	1��DOM�ļ򵥲�����
		* ��ȡԪ�ض���
			document.getElementById("id������ֵ")
		* �޸�Ԫ�ص����Ժ�����
			���ԣ�����.���� = �µ�ֵ
			��ǩ�����ݣ�����.innerHTML = �µ�HTML����
	2���¼��ļ򵥲�����
		* ��Ԫ�ذ�һ�������¼�
			1����Ԫ�صĿ�ʼ��ǩ�ڣ�ʹ���¼�����(onclick)���壬���Ե�ֵ����һ��js����
					<input type="button" onclick="����();">
			2����Ԫ�ص�onclick�������¸�ֵ(����)
					Ԫ��.onclick = function(){}
	3��BOM�����������ģ�ͣ���������ĸ�����ɷ�װ��һ��һ���Ķ���
	4�����ࣺ
			* Window	��ֱ��ʹ�ü��� window������window�ǿ���ʡ�Եġ�
					����:
						alert()/confirm()	
						open()/close()
						setTimeout()/clearTimeout()
						setInterval()/clearInterval()
					���ԣ�
						location
						history
						document
			* Location	��ֱ��ʹ��location��������window.location
					������
						reload()	:�ֶ�ˢ��
					���ԣ�
						href		:һ������£�ͨ�������������һ��URL����ҳ����ת��ָ����URL
								ע��:�����ת���Ǳ����վ����Դ����ô�ͱ������http://��
			* History	��ֱ��ʹ��history��������window.history
					������go(����)	
								go(1)	<===>  forward()	ǰ��һ����ʷ��¼
								go(-1)	<===>  back()		����һ����ʷ��¼
					���ԣ�length	��ʷ��¼��
			* Screen���Թ���
			* Navigator���Թ���
3��DOM����
	1�����Document Object Model���ĵ�����ģ�͡����о��Ķ����Ǳ�������ĵ�����������������ĵ����ص��ڴ��У��γ�һ�����νṹ�����ǿ���ͨ�������νṹ��Ԫ�صĲ���������������ĵ���
	2��DOM�ķ���
			* DOM����	��
			* HTML DOM	��
					ע�⣺һ����ǩ����һ��HTML DOM����
					Document	�����νṹ
						������
							1����ȡElement����
								1. getElementById()	�� ����id����ֵ��ȡԪ�ض���id����ֵһ��Ψһ
								2. getElementsByTagName()������Ԫ�����ƻ�ȡԪ�ض����ǡ�����ֵ��һ������
								3. getElementsByClassName():����Class����ֵ��ȡԪ�ض����ǡ�����ֵ��һ������
								4. getElementsByName(): ����name����ֵ��ȡԪ�ض����ǡ�����ֵ��һ������
							2����������DOM����
								createAttribute(name)
								createComment()
								createElement()
								createTextNode()
					Element		����ǩ(Ԫ��)
					Node		���ڵ�(������DOM����ĸ�����)
	


=======================================
https://www.cnblogs.com/sdream/p/5691176.html
