=======================================回顾和复习
1）正则表达式对象
		1）创建	：new RegExp("正则表达式")
				  /^正则表达式$/	【常用】
		2）方法 ：test()
		3）正则表达式：
			\w	\d	+	*	?	{m, n}	[]
2）Global对象的方法(全局方法)
		
3）BOM对象：浏览器对象模型，将浏览器的每一部分封装成一个对象，方便操作。	
		Window	、Location、	History	、Screen、	Navigator

4）DOM对象
		DOM	：文档对象模型，将标记语言文档加载到内存中形成一个树形结构，这个属性结构就是document。
		分类：核心DOM，XML DOM，HTML DOM
			* 所有的标签都是元素(Element)
			* 获取元素对象
					getElementById()
					getElementsByTagName()
					getElementsByClassName()
					getElementsByName()
			* 修改元素
					* 修改元素的属性值：元素对象.属性 = 值
					* 修改元素的标签体内容	：元素对象.innerHTML = 值(HTML代码)

=======================================内容介绍
1）DOM【理解·掌握】
	1）Element
		方法：setAttribute(attrName, attrValue)
			  removeAttrbute(attrName)
	2）操作Element
			setAttribute(attrName, attrValue)
			removeAttrbute(attrName)
			removeChild()
			appendChild()

	3）Node【了解】
			* 所有的DOM对象的父对象
			* 父节点.removeChild(子节点)
			* 父节点.appendChild(子节点)
			* parentNode	：获取当前节点的父节点

	4）<a href="javascript:void(0);" onclick="delTr(this);">删除</a>
			* 这里的this代表的是当前触发这个事件的组件(事件源)，在这句代码中this就代表这个a标签对象。

	5）修改或者获取html的标签体内容
			* innerHTML	：可以有标签，可以没有标签。这些标签也会被浏览器解析
			* innerText ：获取的时候忽略标签，设置的时候标签不会被浏览器解析，只会作为一段普通字符串存在
	6）修改元素的样式
			* 元素对象.style.attrName = attrValue;		:如果有多个样式属性，定义是不方便的
			* 元素对象.className = "className"			:多个值的时候比较方便

2）JS事件【应用】
	1）事件监听机制
			事件：
			事件源：
			监听器：
			注册监听：
	2）事件的绑定
			* <input onclick="函数();">
			* 标签对象.onclick = function(){}
	3）常用的事件
			* onclick	：单击事件
			* onload	：页面加载完成后执行
			* onsubmit	：表单提交时触发执行
					：form.onsubmit = function(){return true|false;}	:返回false，阻止表单提交，否则表单提交
					：<form action="" method="get" id="form1" onsubmit="return checkForm();">	:onsubmit属性必须是一行js代码，有返回值。返回false，阻止表单提交，否则表单提交
	
3）BootStrap【应用】
	1）介绍：
		* 前端的支持响应式布局的框架，基于HTML、CSS、JS。
		* 优势：
				1）定义了一整套的样式以及插件，我们可以在网页中直接使用，完成效果呈现
				2）支持响应式（一套页面，兼容不同的分辨率的设备）布局
		* 快速入门：
				* 目录：
					js	：定义的插件以及组件相关特效的js实现
					css	：样式文件夹
					fonts ：特殊的图片等样式
				* Bootstrap 的所有 JavaScript 插件都依赖 jQuery，因此 jQuery 必须在 Bootstrap 之前引入。
					bower.json  ==》"jquery": "1.9.1 - 3"
				* 引入资源：
					css/bootstrap.min.css
					js/jquery.min.js
					js/bootstrap.min.js
	2）栅格系统
		* 将容器(.container, .container-fluid)中的一行(.row)分成12等分。在布局元素的时候，只需要告诉bootstrap这个元素占这一行的几个栅格即可(.col-屏幕代码-格子数)
				container：固定宽度，两边留白
				container-fluid：铺满屏幕
		* 在bootstrap中，将现实中常见的设置根据分辨率分成了4类：
					超小屏幕 手机 (<768px)			：xs
					小屏幕 平板 (≥768px)			：sm
					中等屏幕 桌面显示器 (≥992px)	：md
					大屏幕 大桌面显示器 (≥1200px)	：lg
		* 使用：
				容器 -> 行 -> 列 -> 行 -> 列
		* 注意：
				* 每一行12列，大于12列换行
				* 列样式向上兼容，向下默认一个元素占一行
	3）样式、组件、插件的使用