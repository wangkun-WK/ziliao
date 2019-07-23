=======================================回顾和复习
1）DOM
	1）概念：DOM(Document Object Model, 文档对象模型)，主要针对标记型文档，会将整个标记型文档读入内存，形成一个DOM树结构。我们通过操作DOM树来操作这个文档。
	2）对象：
			Document	：DOM树，由window对象获取，window.document，也可以写作：document
			Element		：元素，获取的方式有：
								document.getElementById("id")	:根据id属性值获取，只会得到一个元素对象
								document.getElementsByTagName("elementName")	:根据元素名称获取，得到一个元素数组
								document.getElementsByClassName("className")	:根据class属性值获取，得到一个元素数组
								document.getElementsByName("name的值")	:根据标签的name属性值获取，得到一个元素数组
						  方法：
						  		setAttribute()	:设置属性
								removeAttribute()	:删除属性
								appendChild()	:添加一个子节点
								removeChild()	:移除一个子节点
						  属性：
						  		innerHTML/innerText	:设置或者获取标签体内容
								className	：获取或者设置标签的class样式引用
2）事件
	1）事件监听机制
			* 事件
			* 事件源
			* 监听器
			* 注册监听
	2）事件注册(绑定)
			有两种方式：
				1）在标签的开始标签中，使用事件属性直接定义。这种定义定的是js的代码
						<img id="light" src="img/off.gif"  onclick="fun();">
				2）使用元素对象.事件属性定义，这种定义是直接将原有的默认函数对象直接替换为我们自己写的函数对象
						document.getElementById("light2").onclick = function(){};
	3）常见的事件
			onclick	：单击事件
			onload	：文档就绪事件，一般使用：window.onload = function(){//文档加载完成之后，执行以下代码}
			onsubmit ：表单在提交时触发的事件

3）BootStrap
	1）概述：前段的基于HTML、CSS、JS的一个支持响应式的框架。使用它的原因就是：
				它提供了强大的样式库、插件库、组件库，让我们在开发过程中网页开发这块的变得简单。它支持响应式布局
			 响应式布局：
			 	一个网页，可以兼容不同的分辨率的设备，在上面可以正常显示网页。
	2）使用：
			注意：BootStrap依赖于jquery，所以在使用BootStrap的时候，还需要引入jquery。并且jquery的版本是1.9+
			CSS：
			JS组件
			JS插件

=======================================内容介绍
1）BootStrap的js组件和插件的使用
	* 轮播图：
			1）如果要设置轮播图的循环的时间，需要添加：data-interval="number"  单位是毫秒
			2）轮播图中的小圆点个数要和图片个数一致
	* 案例：黑马旅游网的首页开发

2）XML
	1）XML的介绍【理解】
		* 是可扩展标记语言(自定义标签语言)，因为所有的标签都是自定义的。
		* 功能：与html展示数据不同，旨在存储数据
					* 网络传输
					* 用作配置文件
		* xml和html的区别【了解】
		* 基本语法：
				1. xml文档的后缀名 .xml
				2. xml第一行必须定义为文档声明
				3. xml文档中有且仅有一个根标签
				4. 属性值必须使用引号(单双都可)引起来
				5. 标签必须正确关闭
				6. xml标签名称区分大小写
		* xml的组成；
				* 文档声明：首行首列	version必须属性，值1.0
				* 指令：引入css样式的	xhtml
				* 元素：
				* 属性：
				* 文本：<![CDTA[ 数据 ]]>
	2）XML的约束【了解】：
		* 提供xml书写规范的文档。对于xml书写者，只需要能引入约束到xml中即可；简单读懂。
		* xml约束的分类：
			DTD：扩展名：.dtd
				引入：
					* 内部dtd：将约束规则定义在xml文档中
						* 外部dtd：将约束的规则定义在外部的dtd文件中
							* 本地：<!DOCTYPE 根标签名 SYSTEM "dtd文件的位置">
							* 网络：<!DOCTYPE 根标签名 PUBLIC "dtd文件名字" "dtd文件的位置URL">
				读懂：
					* ELEMENT 代表元素
					* ATTLIST 代表属性
					* #PCDATA 代表标签只有字符串文本内容
					* REQUIRED 代表的是必须
				
			Schema：扩展名：.xsd
				引入：在根标签中，引入：
					<根标签 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
							xmlns:别名="http://www.itcast.cn/xml"
							xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd" >
						<别名:元素></别名:元素>
					</根标签>

					说明：xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 固定写法。表明当前xml是一个xml文件，而非Schema约束文件
						  xsi:schemaLocation="http://www.itcast.cn/xml  student.xsd" 表示引入Schema约束
						  xmlns:别名="http://www.itcast.cn/xml" 表示给约束起别名(命名空间)，为避免多个约束中有相同的元素名称，导致结构混乱。
						  		每个xml中都可以有一个约束定义为空的别名。
	3）解析XML【理解】
		1）解析XML的思想【掌握】：
			1） DOM：将标记语言文档一次性加载进内存，在内存中形成一颗dom树
				* 优点：操作方便，可以对文档进行CRUD的所有操作
				* 缺点：占内存
			2） SAX：逐行读取，基于事件驱动的。
				* 优点：不占内存。
				* 缺点：只能读取，不能增删改
		2）常用的xml的解析器：
				1. JAXP：sun公司提供的解析器，支持dom和sax两种思想
				2. DOM4J：一款非常优秀的解析器
				3. Jsoup：jsoup 是一款Java 的HTML解析器，可直接解析某个URL地址、HTML文本内容。它提供了一套非常省力的API，可通过DOM，CSS以及类似于jQuery的操作方法来取出和操作数据。
				4. PULL：Android操作系统内置的解析器，sax方式的。
		3）使用JSoup来解析xml：
				思想：1）加载xml文件进内存，得到Document对象
					  2）通过Document对象，获取对应的Element元素
					  3）通过Element对象，获取属性的值和标签体内容

				1）JSoup对象以及方法
					Jsoup对象
							parse()	:加载文件进内存的方法
					Document对象
							获取符合条件的元素对象，在整个文档范围
							* getElementById​(String id)：根据id属性值获取唯一的element对象
							* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
							* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
							* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
					Elements对象：继承ArrayList,并且泛型是<Element>
					Element对象：
							* 获取子标签
								* getElementById​(String id)：根据id属性值获取唯一的element对象
								* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
								* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
								* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
							* 获取属性：
								* String attr(String key)：根据属性名称获取属性值
							* 获取标签体内容：
								* String text():获取文本内容
								* String html():获取标签体的所有内容(包括字标签的字符串内容)

				2）jSoup的快速查询
					1） selector:选择器
							* 使用的方法：Elements	select(String cssQuery)
								* 语法：参考Selector类中定义的语法
								