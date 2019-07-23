=======================================回顾和复习
1）BaseServlet
		要求：
				1、BaseServlet只是一个工具类，不需要配置
				2、自定义的Servlet都需要继承BaseServlet，定义自己的业务方法：public void 方法名(HttpServletRequest req, HttpServletResponse resp){}
				3、servlet的访问路径： /模块名/*，在访问的时候，*用方法名来替换
2）旅游线路分类的类别数据的展示(导航菜单)
		思想：缓存的思想(redis)
		Tuple：封装了redis中sortedset中的一组键值对。getElement() 获取元素，getScore()获取分数
3）分类下的旅游线路的分页查询
		1）location.search	：获取请求路径的参数字符串，从?开始
		2）分页的流程：
				数据流：
				结果处理：需要将PageBean对象转换成json字符串，输出到浏览器，在浏览器进行解析。
		3）分页条的前5后4
=======================================内容介绍
1）旅游线路关键字检索
	1）关键字的传递
			事件：搜索按钮的点击事件
	2）获取url中的参数
			getParameter(name)	方法来获取请求参数，在getParameter.js中定义
	3）动态sql
			cid和rname条件动态
	4）rname乱码问题
			//接收rname 线路名称
			String rname = request.getParameter("rname");
			if(rname != null){
				rname = new String(rname.getBytes("iso-8859-1"),"utf-8");//tomcat7以及以前版本处理get乱码
			}

			或者在tomcat7插件中添加：<uriEncoding>UTF-8</uriEncoding>
	5）cid和rname是否为“null”
			* 在首页直接关键字检索，则cid在后台就是"null"
			* 直接点击国内游，再接着点击分页条，就会出现在后台rname是"null",需要在dao中添加一个判断，提出是"null"的情况
					if(rname != null && rname.length() > 0 && !"null".equals(rname)){
						sb.append(" and rname like ? ");
						params.add("%"+rname+"%");
					}

2）旅游线路详情信息显示
	1）数据来源：
		* tab_route表
		* tab_route_img表
		* tab_seller表
	2）在service中，使用三张表对应的dao分别查询数据，最后将数据都封装到一个Route的对象中，序列化

3）点击收藏
	1）明确“收藏按钮”
			* 在登录后，并且当前用户已经收藏了该线路的情况下，按钮不可点击
			* 未登录或者是当前登录的用户没有收藏该线路
			* 收藏功能只有在登录的情况下才有
	2）判断是否收藏的逻辑
			* 表：tab_favorite表
					rid	：tab_route表中的rid
					uid	：tab_user表中的uid
			* boolean flag = false;
			  if(user == null){//用户未登录
					flag = false;
			  }else{//用户已经登录
					flag = favoriteService.isFavorite(rid, uid);

			  }
	3）收藏次数
			* select count(*) from tab_favorite where rid = ?

	4）点击收藏
			* 用户是否登录
					否：跳转到登录页面
					是：完成收藏的逻辑
							刷新页面
								置灰按钮
								剔除按钮的单击事件

=======================================安装linux
注意：电脑的虚拟化是否开启(BIOS)