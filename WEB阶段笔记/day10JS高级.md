=======================================回顾和复习
1）JavaScript
	1）介绍：客户端脚本语言，需要嵌入到浏览器中，让浏览器解释执行。其作用：1）完成页面的动态效果 2）表单校验
	2）JavaScript的组成：
			ECMAScript + BOM + DOM
	3）JS基础：
			1）HTML引入JS	：<script>
					* <script>JS代码</script>
					* <script src="js路径"></script>
			2）注释	
			3）变量的定义
					* 数据类型：
					* 变量定义：
			4）运算符
			5）流程控制语句
			6）函数
					定义：
						* function 函数名(参数列表){}
						* var 函数名 = function(参数列表){}
					调用：
						函数名(参数)
			7）数组：
					定义：
						* [el1, el2, ... , eln]
						* new Array();
						* new Array(el1, el2, ... , eln)
						* new Array(size)
					方法：
						* join()
						* push()
			8）日期对象：
					创建：
						* new Date()
					方法：
						* getTime()
			9）Math对象：工具，不需要创建，直接使用
					方法：
						* ceil()
						* floor()
						* round()

=======================================内容介绍
1）JS基础(对象)【应用】：
	1）正则表达式对象[了解]：
			* 正则表达式：主要是校验字符串是否否和规则，一般用在表单校验时。
				[0-9a-zA-Z_]
				\w
				\d
				n{m, n}
				+
				*
				?
			* 正则表达式对象：用正则表达式创建的对象，通过这个对象提供的方法，可以对已知的字符串进行校验，判断字符串格式是否符合规则
					创建:
						new RegExp("正则表达式")
						/正则表达式/	【常用】
								注意：/正则表达式/，普通正则表达式对象，作用是只要字符串中有一个符合要求的就返回true
									  /^正则表达式$/,所有的字符串必须都符合要求，才返回true。【常用】
					方法:
						test() :验证字符串是否符合规则，如果符合则返回true
	2）Global中方法：
			encodeURI()/decodeURI()	:将url请求中的参数部分进行URL编码/解码
			encodeURIComponent()/decodeURIComponent()	：将url整个进行URL编码/解码
			parseInt()	：解析字符串型的数值数据，返回整数。如果起始位就是非数值，则会返回NaN，否则，会按照字面值逐一转换
			seFloat()	
			eval()	：将一段字符串形式的js代码直接执行
2）BOM对象
	1）DOM的简单操作：
		* 获取元素对象
			document.getElementById("id的属性值")
		* 修改元素的属性和内容
			属性：对象.属性 = 新的值
			标签体内容：对象.innerHTML = 新的HTML代码
	2）事件的简单操作：
		* 给元素绑定一个单击事件
			1）在元素的开始标签内，使用事件属性(onclick)定义，属性的值就是一段js代码
					<input type="button" onclick="函数();">
			2）给元素的onclick属性重新赋值(函数)
					元素.onclick = function(){}
	3）BOM，浏览器对象模型，将浏览器的各个组成封装成一个一个的对象
	4）分类：
			* Window	：直接使用即可 window，并且window是可以省略的。
					方法:
						alert()/confirm()	
						open()/close()
						setTimeout()/clearTimeout()
						setInterval()/clearInterval()
					属性：
						location
						history
						document
			* Location	：直接使用location，或者是window.location
					方法：
						reload()	:手动刷新
					属性：
						href		:一般情况下，通过这个属性设置一个URL，让页面跳转到指定的URL
								注意:如果跳转的是别的网站的资源，那么就必须添加http://。
			* History	：直接使用history，或者是window.history
					方法：go(数字)	
								go(1)	<===>  forward()	前进一个历史记录
								go(-1)	<===>  back()		后退一个历史记录
					属性：length	历史记录数
			* Screen【略过】
			* Navigator【略过】
3）DOM对象
	1）概念：Document Object Model，文档对象模型。它研究的对象是标记语言文档，将整个标记语言文档加载到内存中，形成一个树形结构。我们可以通过对树形结构的元素的操作，来操作这个文档。
	2）DOM的分类
			* DOM核心	：
			* HTML DOM	：
					注意：一个标签就是一个HTML DOM对象
					Document	：树形结构
						方法：
							1）获取Element对象：
								1. getElementById()	： 根据id属性值获取元素对象。id属性值一般唯一
								2. getElementsByTagName()：根据元素名称获取元素对象们。返回值是一个数组
								3. getElementsByClassName():根据Class属性值获取元素对象们。返回值是一个数组
								4. getElementsByName(): 根据name属性值获取元素对象们。返回值是一个数组
							2）创建其他DOM对象：
								createAttribute(name)
								createComment()
								createElement()
								createTextNode()
					Element		：标签(元素)
					Node		：节点(是所有DOM对象的父对象)
	


=======================================
https://www.cnblogs.com/sdream/p/5691176.html
