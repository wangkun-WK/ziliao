=======================================回顾和复习
1）表单：用来规定用户采集数据的范围，在这个范围内的表单项中的数据，都可以提交。
2）标签：
	<form>	:表单标签
		属性：action	提交的URL，method	：提交数据的时候的请求方式，默认GET。常用的取值GET|POST
	<input>	:输入标签
		type	：text/password/radio/checkbox/file/hidden/submit/button	默认text
		name	：提交表单项的时候，必须的属性
				  在单选按钮中，name相同的一组单选按钮，就可以实现单选效果
		value	：值
		checked	：在单选按钮和复选框时，默认让这个组件选中
	<select>	：下拉列表
		<option>	：下拉列表项
			属性	：value，代表列表项的值，提交的时候就提交的是这个数据
	<textarea>	：
		注意：只有name属性，没有value属性。值就是文本域标签的内容体部分
3）CSS
	1）HTML中引入CSS？
		1）内联样式	：标签的style属性
		2）内部样式	：在<head>标签中，定义<style>标签，标签体内容就是样式，在标签中使用class来引用定义好的样式
		3）外部样式 ：在<head>标签中，使用<link>标签，引入外部样式文件
	2）样式定义语法：
		格式：样式选择器{属性名1：值1;属性名2：值2, ... , 属性名n：值n;}
		选择器：功能：筛选类似特征的元素
			#id{}	:
			.className{}	:
			element{}		:
			* {}
			s1, s2, ... , sn {}	:
			parent child{}
			parent > child{}
			s1[attr='value']
		属性：
			background/backgroundColor/backgroundImage
			font-size
			color
			text-align
			width
			height
			border
			padding
			margin
=======================================内容介绍
JavaScript
	1）简介
		1）是一个客户端脚本语言，可以在浏览器端直接解释执行。
		2）作用：增加页面的动态效果；表单校验。
	2）JavaScript的组成：
			ECMASCript	：基础
			BOM			：浏览器对象模型
			DOM			：文档对象模型
	3）JavaScript基础(ECMASCript)【理解·掌握】
			1）html引入js【掌握】
				* html文档在被解析的时候是自上而下，顺序执行
				* 引入js：
						内部js： <script>  js代码  </script>
						外部js： 1）js文件以.js为扩展名	
								 2）引入外部js，使用<script src="外部的js文件路径"></script>
						注意：外部js和内部js在一个</script>标签中只能选一个
			2）注释，和java类似，只是少了文档注释
			3）数据类型
				1）原始数据类型
						number		：数值型(数字和NaN)
						string		：字符串
						boolean		：布尔型
						null		：一个为null的对象
						undefined	：变量为定义
				2）引用数据类型--->jS对象
			4）变量定义
				1）定义变量的时候不需要指定类型:var 变量名 = 初始值;
				2）获取指定变量的数据类型：typeof()
						typeof(null)  ---> object
			5）运算符
				1）==	：判断的是值是否相等，如果两个类型不一致，会先将类型转换为同一类型
				2）===	：全等。值要等并且类型相等
				3）没有&、|位运算符号。只有&& || !
						当使用“!”，如果不是boolean，则会转换，转换的规则【应用】
							number->boolean: 0|NaN -> false, 其他true
							string->boolean: null|undefined|"" -> false, 其他true
							object->boolean: null|undefined -> false, 对象存在则true
				4）switch语句中可以接收的数据类型是所有原始数据类型
						number
						string
						boolean
						null
						undefined
				5）方法对象Function
						定义方法：	function 方法名(参数列表){}/var 方法名 = function(){}
						特点：
							1）方法的参数没有类型，返回也不需要定义类型
							2）方法名如果一样，则后面的定义覆盖前面的定义
							3）方法调用只和方法名称相关
							4）方法有内置对象arguments,表示方法接收到的实际参数组成的数组
				6）数组Array
						定义：new Array()/[el1,el2, ..., eln]/new Array(el1,el2, ... , eln)/new Array(size)
						属性：length
						方法：join()， push()
						特点：1）可以存放任意数组 2）长度可变
				7）日期对象
						创建：new Date()
						方法：getTime()	获取时间戳
				8）数学对象Math
						认识：Math对象直接用即可
						方法：random()	/	round()	/ceil()	/floor()