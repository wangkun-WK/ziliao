=======================================回顾和复习
HTMl标签
	1）介绍
		HTML：超文本标记(标签)语言。
			超文本：超级文本，超越了普通文本的功能范畴。
			标记(标签)语言：用标签构成的语言
	2）常用标签
			文本标签：
			图片标签：
			链接标签：
			列表标签：
			表格标签：

=======================================内容介绍
1）表单标签【掌握】
	1）表单介绍
			：定义用户数据的采集范围，就可以将这些数据提交给指定的请求来处理
	2）表单标签
			<form> ：表单标签，定义了采集数据的范围
				action属性：定义数据提交给谁？指定一个url
				method属性：定义表单的提交方式，一般有GET/POST提交
					GET和POST区别：
						GET：请求参数是在地址栏显示的，是有大小限制的，安全性低
						POST：请求参数不在地址栏显示，无大小限制，相对GET比较安全
				enctype属性：默认application/x-www-form-urlencoded，表示表单提交的数据是以key-value键值对形式提交
							 multipart/form-data：文件上传时使用
			表单项标签：表单中所有的数据其实都是存储在表单项中
				<input>:
					属性：
						name ：1）提交数据的表单项必须有name属性	2）在单选框中用来表示单选效果，即neme相同的单选框是一组，可以实现单选。
						value	：表单项的值。如果是单选框和复选框，那么必须指定value的值，否则提交的数据是on，没有任何效果
						placeholder ：默认文本框的提示信息。html5的属性
						type ：表示表单项的不同状态
						checked ：在单选框/复选框中表示默认选中
				<select>:
					1）<select>定义下拉列表，如果需要提交数据，在这个标签上添加name属性
							1）默认单选下拉列表
							2）如果定义了multiple属性，则就是多选列表
					2）<option> 定义下拉列表项，一般会定义option的value属性，用于提交数据	
					  		如果需要默认选中一个option，则可以使用selected属性，用法类似于checked					
				<textarea>:
					1）可以定义name属性，要提交的数据就是这个标签体内容，如果这个标签需要默认值，就修改这个标签体内容即可
					2）cols / rows
2）CSS
	1）介绍
		层叠样式表，多个样式可以作用在同一个标签上。
		优势：比html属性更强大(样式定义灵活)，将内容展示和样式控制分离。
	2）HTML中引入CSS【掌握】
		1）内联样式：style属性			只对当前元素有效
		2）内部样式：使用<style>css代码</style>		对当前页面中的元素有效
		3）外部样式：1）<link rel="stylesheet" href="css/a.css">  2）<style> @import "css/a.css" 对所有引入了该样式的页面元素有效
	3）CSS语法【应用】：
		选择器｛属性1:值1;...;属性n:值n;｝
		1）选择器
				基础选择器：
					#id{...}
					.className{...}
					element{...}
					selector1,selector2,...,selectorn{...} 并集选择器，选择的是所有选择器选中的元素
					*{...} 所有元素
				层级选择器：
					element element 
						div p :选择 <div> 元素内部的所有 <p> 元素。 
					element>element 
						div>p :选择父元素为 <div> 元素的所有 <p> 元素。 
				属性选择器：
					selector[属性名="属性值"]	：寻找所有selector表示的元素，并且筛选元素的属性等于指定的属性值的元素
						input[name="hobby"]	: 找所有的input元素，并且元素的name属性是hobby的
				伪类选择器：
					元素:状态{...}
					a元素的伪类：
						* link：初始化的状态
						* hover：鼠标悬浮状态
						* active：正在访问状态
						* visited：被访问过的状态
		2）属性	
			1）常用属性
					color：字体颜色
					font-size：字体大小
					background：背景颜色或者图片
					width：宽度
					height：高度
			2）盒子模型相关属性
					盒子模型：研究元素和元素之间的位置关系
						内边距：padding
						外边距：margin
						边框：border    
					浮动：float
			3）让元素隐藏的属性：
					display ：none	隐藏
							  block	显示，表示块级块标签	自动换行
							  inline 显示，表示内联元素		不自动换行
					例子(margin和padding的使用类似)：
						margin:10px 5px 15px 20px;
							上外边距是 10px
							右外边距是 5px
							下外边距是 15px
							左外边距是 20px
						margin:10px 5px 15px;
							上外边距是 10px
							右外边距和左外边距是 5px
							下外边距是 15px
						margin:10px 5px;
							上外边距和下外边距是 10px
							右外边距和左外边距是 5px
						margin:10px;
							所有 4 个外边距都是 10px
						border 1px solid red;
							四边都是1px宽，实线，颜色是red


