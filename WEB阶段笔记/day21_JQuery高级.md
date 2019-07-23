=======================================回顾和复习
1）敏感词汇过滤
		* 实质：需要对request获取参数的方法进行增强
		* 方法：动态代理
					要求：真实对象必须要实现接口
					实现：代理对象 = Proxy.newProxyInstance(ClassLoader classLoader, Class<?>[] interfaces, InvocationHandler ivh)

2）Listener
		* 事件监听机制：
				事件：
				事件源：
				监听器：
				注册监听器：
		* JavaWEB中的监听器的作用：三个域对象的创建和销毁以及域对象中数据的变更
		* 开发监听器：
				1）写一个类，实现ServletContextListener接口，这个监听器就是用来监听ServletContext对象的创建和销毁
					创建的方法中：可以进行项目或者环境的初始化操作
					销毁方法中：一般用于清理工作
				2）配置监听器
					web.xml中配置：
							<listener>
								<listener-class>监听器的全类名</listener-class>
							</listener>
					注解配置:
						@WebListener
3）jQuery入门
	* 概述：js框架，简化js代码开发
	* js对象和jQuery对象的转换：
	* 事件绑定：jQuery对象.click(function(){//单击事件})
	* 入口函数：$(function(){//入口函数，文档加载就绪事件触发执行});
	* 样式控制：jQuery对象.css("属性", "属性值")
	* 选择器：快速的获取标签对象
			$("#id"),$(".className"),$("element"),
			$("parent child"),$("parent > child"),
			$("[attr]"),$("[attr=value]"),
			:checked, option:selected
	* 内容操作：
			text()/html()
	* 属性操作：
			attr()/removeAttr()
			prop()/removeProp()
	* 特殊属性操作
			表单标签的value属性：
				val()
			class属性：
				addClass()/removeClass()/toggleClass()
	* 添加元素：
			append()/appentTo()
	* 移除元素：
			remove()
	* 清空元素的标签体内容：
			empty()
	* 克隆元素：
			clone()

=======================================内容介绍
1）案例
2）动画(元素的显示和隐藏的效果)【应用】
		默认显示和隐藏：
			show()/hide()/toggle()
		滑动显示和隐藏：
			slideDown()/slideUp()/slideToggle()
		淡入淡出显示和隐藏：
			fadeIn()/fadeOut()/fadeToggle()
3）for循环(jQuery对象.each(), $.each())【应用】
		1）jQuery对象.each(function(index, element){
				//index:表示当期元素在集合中索引
				//element/this: jQuery对象[index]	==> js对象
				//如果该函数返回true，结束当前循环，进入下一次循环，类似于continue;
				//如果该函数返回false，结束该循环，类似于break
			})
		2）$.each(遍历的集合, function(index, element){
				//index:表示当期元素在集合中索引
				//element/this: jQuery对象[index]	==> js对象
				//如果该函数返回true，结束当前循环，进入下一次循环，类似于continue;
				//如果该函数返回false，结束该循环，类似于break
			})
4）jQuery中事件【应用】
		* jQuery中的事件都没有on。比如js中是onclick，那么jQuery就是click
		* 事件绑定：
			jQuery对象.click(function(){//事件所对应的的函数 })	【常用】
			jQuery对象.on(事件名称, function(){//事件对应的函数})
		* 事件解除绑定
			jQuery对象.off("事件名称")
		* 事件切换
			toggle()	:1.9之后，只支持元素的显示和隐藏了。如果需要事件切换的功能需要使用jQuery migrate插件。
			hover()		:就是mouseover和mouseout的组合体
5）jQuery的插件机制【了解】
		* 对象级别，使用jQuery对象来调用
				$.fn.extend({方法1:function(){//方法实现}, 方法2:function(){//方法实现}, .... })
		* 全局方法，使用$来调用
				$.extend({方法1:function(){//方法实现}, 方法2:function(){//方法实现}, .... })
6）Ajax
	* 概述(同步和异步)【理解】
		同步：在服务器处理客户端请求时，客户端处于等待状态，什么事情也不能做。即中断了用户体验
		异步：在服务器处理客户端请求时，客户端依然可以处理其他事情。即不中断用户体验
			  作用：在不刷新页面的情况下，局部更新页面的内容。
	* 使用原生JS来实现Ajax【了解】
		明确：ajax程序中，servlet响应的数据都是以文本形式被XMLHttpRequest的responseText|responseXML接收到。
		1）步骤：
				1）创建XMLHttpRequest对象，专门用来进行异步交互的对象
					var xmlhttp;
					if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
						xmlhttp=new XMLHttpRequest();
					}else{// code for IE6, IE5
						xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
					}
				2）建立连接，使用open()
				3）发送请求，使用send()
					GET请求：
						xmlhttp.open("GET","ajaxServlet?username=tom",true);
						xmlhttp.send(null);
					POST请求：
						xmlhttp.open("POST","ajaxServlet",true);
						xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
						xmlhttp.send("fname=Bill&lname=Gates");
				
				4）接收响应数据，设置监听器，在监听器中使用双保险，获取数据
						xmlhttp.onreadystatechange=function(){
							//双保险 xmlhttp.readyState==4 && xmlhttp.status==200
							if (xmlhttp.readyState==4 && xmlhttp.status==200){
								
								//document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
								//对于响应的结果的处理
							}
						}
		2）API：
				XMLHttpRequest对象，可以实现异步
					属性：
						responseText：获取响应的文本数据
						responseXML：获取响应的xml文本数据
						readystatechange：监听器，监听XMLHttpRequest的状态
						readyState：请求状态，状态码：
												4: 请求已完成，且响应已就绪
						status：响应的状态，状态码：
												200: "OK"
					方法：
						open()	:建立连接，设置请求参数
						send()	:发送请求
						setRequestHeader()	:post请求时，必须调用 该方法设置Content-type请求头，服务器端才能获取到请求参数
	* jQuery中的ajax【应用】
			$.ajax():
				$.ajax({
					url: '', //请求路径
					data: {key: "value", key: "value", ...} , //请求参数
					type: 'GET', //请求方式，默认是GET
					dataType: 'text', //响应的数据的类型，text、xml、json、...
					success: function(data){
						//异步成功后的回调函数，在这个函数中对响应的数据进行处理
						//响应的数据就是data
					},
					error: function(){
						//请求错误时的回调函数
					}
				});
			$.get()		:对应的是GET请求的异步【常用】
				$.get(请求的路径, 请求的参数, 请求成功后的回调函数(data), 响应的数据类型)	：如果请求出错了，只能抓包查看
					$.get("ajaxServlet", {username:"rose", age: 23}, function(data){
						//data：响应的数据
						//响应成功后的回调函数
					}, 'text')
			$.post()	:对应的是POST请求的异步【常用】
					和$.get()类似
=======================================课堂代码：
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="../js/jquery-3.3.1.min.js"></script>
    <script>
        $(function(){
            $("h1").hover(function () {
                $("div").slideDown(2000);
            }, function () {
                $("div").slideUp(2000);
            })

        });
    </script>
</head>
<body>
<h1 style="color: red;">清凉一夏，倾情奉献</h1>
<div style="display: none;">
    <img src="../img/adv.jpg" id="img" width="100%">
</div>

</body>
</html>


