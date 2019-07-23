=======================================回顾和复习
1）Servlet
	1）体系结构：
			* 创建一个Servlet，需要继承HttpServlet，重写的doGet/doPost
			* 配置
	2）配置
			* 一个Servlet可以有多个映射路径
			* 映射路径的配置：
					/xxxx，/dir/xxxx，/dir/*，/*，*.xxx
2）HTTP协议之请求
	1）什么是HTTP协议？
	2）请求消息数据格式：
			请求行
			请求头
			请求空行
			请求体
			注意：GET请求没有请求体，POST请求有请求体，请求体中存放的是POST请求的请求参数
3）Request
	1）原理：
		* request对象是web容器创建，封装了请求消息数据
		* 使用request来获取请求消息数据
		* request的类型HttpServletRequest
	2）方法：
		* getContextPath()	:获取虚拟目录
		* getParameter(String name)	:获取一个name对应一个值的请求参数数据
		* getParameterValues(String name)	:获取一个name对应多个值的请求参数数据
		* getParameterMap()	:获取所有的请求参数名称以及数据，并且以键值对方式存储在Map<String, String[]>中
		* getParameterNames()	:获取所有的请求参数的名称，将这个名称封装在一个迭代器
		* request.getRequestDispatcher("跳转的资源路径").forward(request, response)
		* setAttribute(String name, Object value)	:向request域中存储数据
		* getAttribute(String name)	:从request域获取数据
		* removeAttribute(String name)	:从request域中移除指定的键值对数据
		* getServletContext()	:获取servletContext对象
=======================================内容介绍
1）request应用之登录
	1）登录功能实现的思路
			* web项目的jar包一定是在WEB-INF/lib中，并且要“Add As Library”
			* 一般一个数据表总会对应一个Java类(实体类)，主要用来封装数据。一般我们放在domain
			* 获取src下的文件输入流：ClassLoader
			* 使用JdbcTemplate.queryForObject()获取用户数据，即便是没有查询出来，那么程序也是正确的，所有这段代码需要使用try...catch包裹。
				    public User login(User loginUser){
						try {
							user = ... ;
							return user;
						} catch (DataAccessException e) {
							e.printStackTrace();//记录日志
						}
						return null;
					}
	2）登录的代码编写
	3）BeanUtils工具类
			* 需要jar ：commons-beanutils.jar
			* BeanUtils.populate(object, map )	:将map中的数据封装到object对象中，map中的key就是object中的属性，即对象的属性和map的key是一致的。
					* JavaBean	：标准的Java类
						要求：类必须被public修饰；必须提供空参的构造器；成员变量必须使用private修饰；提供公共setter和getter方法
						功能：封装数据
					* 属性：一般情况下，属性就是成员变量。实质上属性指的是getter/setter方法截取后的字符串

2）HTTP协议之响应
	1）响应：服务器向浏览器输出的数据的封装
	2）格式：
			响应行	：
				1）组成：协议/版本 响应状态码 状态码描述
				2）状态码：以三位数表示，有5类。常见的状态码： 
								404：检查路径是否有错误，500：代码错误
			响应头	：描述响应体数据的信息的
				1）格式：头名称： 值
				2）常见响应头：
					Content-Type:服务器告诉客户端本次响应体数据格式以及编码格式，值：text/html;charset=UTF-8
					Content-Disposition:服务器告诉客户端以什么格式打开响应体数据。方式有：
							in-line:默认值,在当前页面内打开
							attachment;filename=xxx：以附件形式打开响应体，xxx为附件的文件名。常用于文件下载
			响应空行：分隔符
			响应体	：响应体就是服务器传递给浏览器的数据

3）Response(HttpServletResponse)
	方法：
		1）重定向
			response.setStatus(302);
			response.setHeader("Location", "要跳转的路径");		<====>  response.sendRedirect("要跳转的路径");
				路径：
					相对路径：html中使用相对路径
						重点：获取参照物。写法：./ 表示当前路径，.可以省略； ../ 表示上一层路径
					绝对路径：servlet、jsp中使用绝对路径
						1）以"/"开头 。分类：客户端路径，需要添加虚拟目录；服务器端路径，不需要添加虚拟目录。
						2）一般使用request.getContextPath()动态获取虚拟目录。
		2）响应字符数据到浏览器
			1）响应数据
				response.getWriter().write(...)
			2）响应中文数据乱码：
				response.setCharacterEncoding("UTF-8");	//设置流的编码
				response.setHeader("Content-Type", "text/html;charset=UTF-8")	//服务器告诉客户端本次响应体数据格式以及编码格式
				等价于：response.setContentType("text/html;charset=UTF-8")
		3）响应字节数据到浏览器
			1）response.getOutputStream()
			2）中文乱码：
					response.setContentType("text/html;charset=UTF-8")
					response.getOutputStream().write("数据".getBytes("UTF-8"))
			3）案例：验证码
				1）验证码介绍：
						实质：就是一张图片
						作用：防止恶意的数据提交
				2）在页面接收验证码
						<img src="生成验证码的servlet的访问路径">
				3）点击切换验证码
						问题：验证码没有变化	--》浏览器缓存了这张图片
						解决：让每一次访问这个servlet的时候的路径都不一样，以时间戳作为参数




=======================================BeanUtils的基本实现
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 使用内省机制，模拟Apache BeanUtils工具的populate的方法
 * Java中的内省机制：
 *      是Java语言对于JavaBean对象的属性进行操作
 *          执行属性的setter和getter方法
 *      是基于Java反射的
 * Java中的反射：在运行时可以动态的获取Java类中的属性、方法，并且进行操作
 */
public class BeanUtils {

    /**
     * 模拟BeanUtils的populate方法
     * @param bean
     * @param map
     */
    public static void populate(Object bean, Map<String, String[]> map) throws Exception{
        //判断JavaBean对象和数据map都不为null
        if(map != null || bean != null){
            //获取JavaBean对象的BeanInfo对象
            //通过BeanInfo对象可以获取JavaBean中的属性
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            //获取JavaBean中定义的属性集合：属性是由getter和setter方法决定的
            //一个属性就是一个PropertyDescriptor对象
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            //遍历属性
            for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                //获取属性的名称
                String propertyName = propertyDescriptor.getName();
                //通过属性名，从Map中获取数据。要注意：对象的属性和map中的键值要一样，这样才能完成数据封装
                //判断Map中是否存在该属性对应的值
                if(map.containsKey(propertyName)){
                    //存在，则获取Map中该属性对应的值
                    String[] propertyValue = map.get(propertyName);
                    //当该属性的值存在
                    if(propertyValue != null && propertyValue.length > 0){
                        //获取JavaBean的该属性对应的setter方法
                        Method writeMethod = propertyDescriptor.getWriteMethod();

                        //调用属性对应的setter方法，给属性赋值。需要判断数据类型
                        //获取参数类型
                        Class<?>[] parameterTypes = writeMethod.getParameterTypes();
                        //System.out.println(parameterTypes[0]);
    
                        //如果是字符串数据
                        if(parameterTypes[0] == String.class){
                            //调用属性对应的setter方法，给字符串型的属性赋值
                            writeMethod.invoke(bean, propertyValue[0]);
                        }else if (parameterTypes[0] == Integer.class){
                            //调用属性对应的setter方法，给Integer型的属性赋值
                            writeMethod.invoke(bean, Integer.valueOf(propertyValue[0]));
                        }else if (parameterTypes[0].isArray()){
                            //调用属性对应的setter方法，给字符串数组型的属性赋值
                            writeMethod.invoke(bean, new Object[]{propertyValue});
                        }
                    }
                }
            }
        }
    }
}