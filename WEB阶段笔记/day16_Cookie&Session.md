=======================================回顾和复习
1）登录案例
	1）获取表单的数据
			getParameter()/getParameterMap()
	2）请求参数中文乱码
			在获取请求参数之前，设置流的字符集:setCharacterEncoding()
	3）BeanUtils工具类
			populate()	:将map中的数据封装到JavaBean中
				什么是JavaBean？什么是属性？成员变量和属性是否是一个？
	4）JdbcTemplate
			queryForObject()	:如果没有查询出数据或者是查询出了多条数据，都会报错
				在登录的案例中，需要使用try...catch进行异常的捕捉，如果有异常发生，则返回null
2）HTTP协议之响应
	1）响应response：是由web容器创建，程序员只需要通过response设置响应消息数据即可
	2）响应的消息数据格式：
			响应行：
				响应的状态码：一般由三位数字构成，常见的响应状态码：
						200	
						302
						304
						404
						405
						500
			响应头：
				常见的响应头：
						Content-Type:告诉浏览器响应的数据格式，并且让浏览器在解析这个数据的时候采用指定的字符集
						Content-Disposition:告诉浏览器这个数据打开方式：
									1）在浏览器上直接打开
									2）以附件形式打开----》文件下载
			响应空行：
			响应体：
3）Response(HttpServletResponse)
	方法：
		setStatus()	
		setHeader()
		sendRedirect()
		setContentType()

4）请求转发和重定向的区别以及联系
	1）联系：都可以完成资源跳转
	2）区别：
	3）路径的写法：
			1）相对路径		HTML
					./	:
					../	:
			2）绝对路径		Servlet/JSP
					以“/”开头，分两类：
						客户端路径	:添加虚拟目录
						服务器端路径	：不需要添加虚拟目录
5）验证码案例
	1）将图片以字节流的方式响应给浏览器
	2）<img src="servlet路径">	：servlet路径代表的是一张图片
	3）切换图片的时候，如果servlet路径不变，会出现验证码就不切换的问题。解决方案是：
			给servlet路径中添加一个时间戳参数
	4）URL的写法：
			http://localhost:8080/day15/servletDemo?xxxxx

=======================================内容介绍
1）ServletContext对象
	获取：servlet.getServletContext()
	1）ServletContext：web容器和项目之间通讯的桥梁。每个web项目都有一个ServletContext对象。功能：
			1）获取文件的MIME类型
					MIME类型：网络传输的文件类型。大类型/小类型	--》text/html
					getMimeType(String fileName)
			2）域对象
					范围：整个web应用
					何时创建：服务器启动的时候，会为每一个发布的项目创建一个ServletContext对象
					何时销毁：服务器关闭或者web应用被移除
					共享数据的方法：	
							setAttribute()	:存储数据
							getAttribute()	:获取数据
							removeAttribute()	:移除数据
			3）获取文件的真实路径(在tomcat中运行的项目文件的路径)【理解·掌握】
					获取java项目中的文件有两种办法：
							1）类加载器			java和javaweb都可以用
							2）ServletContext	javaweb项目
					方法：getRealPath(路径)
							注意：路径以"/"开头，"/"代表的就是web应用的根目录
2）文件下载：下载项目中的文件到本地
	文件下载的两种方式：
		1）超链接：直接执行项目资源，如果浏览器能解析这个资源，那么就会在浏览器上直接打开；否则才会弹出下载框
		2）后台Servlet编码方式
				以字节流形式将文件输出到浏览器，需要设置一个响应头：Content-Disposition
	思路：
		1）两个头
				Content-Type:
				Content-Disposition:
		2）一个流
				要下载的文件的字节输入流。
	
	问题：中文名称乱码
	解决：
		  原因：每个浏览器针对文件名的编码方式不同，所以我们给定了中文数据之后，由于解析的字符集和编码的字符集不一致导致乱码
		  解决：根据每个浏览器，给文件名进行不同的编码	DownloadUtils工具类

3）会话
	1）同一个浏览器首次访问服务器资源开始，会话建立。直到浏览器或者是服务器断开为止，这就是一次会话。会话的功能就是：
			一次会话的多次请求间进行数据的共享
	2）为什么要有会话技术：http协议是无状态的，需要使用会话技术来共享数据

	3）会话的分类：
			1）Cookie	：客户端会话技术
				1）创建Cookie		:Cookie(String name, String value)	
						:Cookie只能存储字符串数据
				2）回写Cookie给浏览器	:response.addCookie(cookie)
						:每调用一次方法，就会写一个Cookie到浏览器，这个方法可以调用很多次
				3）获取浏览器端的Cookie	:request.getCookies()
						:浏览器带过来的Cookie也可以有很多个。并且浏览器携带Cookie给服务器是自动的。
				4）原理：
					基于响应头Set-Cookie和请求头Cookie的。
				5）细节：
					1）服务器一次可以写多个Cookie到浏览器
							思考：如果是同名的Cookie？	---》后面的覆盖前面的
					2）Cookie的存活时间
						1）默认Cookie，会话结束Cookie消失
						2）将Cookie设置为持久级别的Cookie：setMaxAge(int second)
								正整数：cookie持久级别存储，存储的有效时长是second，单位秒
								0：告诉客户端，删除指定名称Cookie
						3）Cookie能否存储中文数据
								tomcat8之后是可以存储一部分中文数据的，一些特殊符号不能存储
								tomcat7以及之前的版本根本不能存储中文，如果要存储中文，那么就必须进行转码(中文==》非中文)。一般使用URL编码
										URLEncoder.encode("中文数据", "字符集")	：URL编码
										URLDecoder.decode("URL编码的中文数据", "编码时候使用的字符集")	：URL解码
						4）Cookie的有效范围：
								setPath()
									默认有效路径是当前项目(即设置的就是当前项目的虚拟目录)
									例子：setPath("/day16"),就是如果访问资源的路径是http://localhost:8080/day16/*目录以及子目录时，可以携带这个cookie
												访问  http://localhost:8080/day16，可以带着cookie
													  http://localhost:8080/day16/index.jsp ,可以带着cookie
													  http://localhost:8080/day16/user/userServlet, 可以带着cookie
													  http://localhost:8080/day15,不能携带Cookie
								setDomain()
									设置cookie的有效域名
									例子：setDomain(".baidu.com"),	那么只要是baidu.com的域名或者是baidu.com的子域名，那么就可以带着Cookie
												访问tieba.baidu.com和pan.baidu.com这些都会带着Cookie
												访问taobao.com	不会带着cookie
						5）Cookie的特点和作用
								1）cookie存储数据在客户端浏览器
								2）浏览器对于单个cookie 的大小有限制(4kb) 以及 对同一个域名下的总cookie数量也有限制(20个)
								* 作用：
									1）cookie一般用于存出少量的不太敏感的数据
									2）在不登录的情况下，完成服务器对客户端的身份识别
			2）Session	：服务器端会话技术

========================================
/**
 * 显示最后一次访问时间
 */
@WebServlet("/lastVistServlet")
public class LastVistServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //设置响应的消息体的数据格式以及编码
        resp.setContentType("text/html;charset=utf-8");

        //假定：存储访问时间的Cookie的名称是 lastvist
        //根据名称获取Cookie数据
        Cookie cookie = CookieUtils.findCookie(req.getCookies(), "lastvist");

        //判断cookie
        if(cookie == null){
            //是第一次访问，没有Cookie
            resp.getWriter().write("<h1>您好，欢迎您首次访问</h1>");
        }else{
            //不是第一次访问，有Cookie
            //获取cookie中存储的数据
            String lastvist = URLDecoder.decode(cookie.getValue(), "UTF-8");
            System.out.println("上一次访问时间：" + lastvist);
            resp.getWriter().write("<h1>欢迎回来，您上次访问时间为:"+lastvist+"</h1>");
        }

        String currDate = date2String();
        System.out.println("当前时间：" + currDate);

        //将本次访问时间存储到cookie中，写入浏览器
        cookie = new Cookie("lastvist", URLEncoder.encode(currDate, "UTF-8"));
        cookie.setMaxAge(60 * 60 * 24);
        resp.addCookie(cookie);
    }

    private String date2String(){
         return new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss").format(new Date());
    }
}


package cn.itcast.utils;

import javax.servlet.http.Cookie;

/**
 * Cookie的工具类
 */
public class CookieUtils {

    /**
     * 通过指定的Cookie名称，获取浏览器携带的Cookie
     * @param cookies
     * @param cookieName
     * @return
     */
    public static Cookie findCookie(Cookie[] cookies, String cookieName){
        // 当Cookie数组不为null，进行遍历查找
        if(cookies != null){
            for (Cookie cookie : cookies) {
                // 判断是否是指定的Cookie
                if(cookie.getName().equals(cookieName)){
                    //如果找到，则返回
                    return cookie;
                }
            }
        }
        //如果遍历后，还是没有则返回null
        return null;
    }

}