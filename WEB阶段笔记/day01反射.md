1、反射：
		介绍：将类的各个组成部分，封装成一个个对象。可以通过这些对象来调用类的方法和改变类的属性。
		类				Class
		属性			Field
		构造方法		Constructor
		方法			Method

		Object obj = Class.forName("类名").newInstance();
		Method method = clazz.getMethod(methodName, Class<?>... args)
		method.invoke(obj, args )

2、Junit
		测试分类：
			黑盒测试：功能级别的测试，主要关注功能
			白盒测试：代码级别的测试，主要关注代码的执行过程。需要写一些代码
		Junit：
			@Test：以@Test标注的方法能独立运行，称之为测试用例
				   以@Test标注的方法定义：
				   			public void test方法名() throws Exception{}

			@Before：以@Before标注的方法会在@Test方法之前执行
			@After：以@After标注的方法会在@Test方法之后执行
	
			注意：@Before/@After不是独立执行的，而是在执行@Test方法的时候自动执行

3、注解
	1）注解和注释的区别：
		注释：程序员写的，给其他程序员看的
		注解：程序员写的，给jvm看的
	2）注解介绍：
		JDK1.5之后的新特性
		可以使用在包、类、字段、方法、局部变量、方法参数等，以@开头，后面跟上注解名称，即@名称
	3）使用：
		1）JDK中预定义的一些注解
				* @Override	：检测被该注解标注的方法是否是继承自父类(接口)的
						jdk5版本中该注解只能用于继承时重写方法，jdk6之后可以用在实现上。
				* @Deprecated：该注解标注的内容，表示已过时
				* @SuppressWarnings：压制警告
					* 一般传递参数all  @SuppressWarnings("all")
		2）自定义注解【重点】
				关键字：@interface	本质：接口，继承了Annotation的接口
				定义：	public @interface 注解名称{
							属性列表
						}

				属性列表格式以及类型：
						属性的返回值类型有下列取值
							* 基本数据类型
							* String
							* Class
							* 枚举
							* 注解
							* 以上类型的一维数组
						格式：类型 属性() default 值;
				元注解：
					1）注解的有效范围
							RetentionPolicy.RUNTIME：表示运行阶段，在源码、编译期、运行期有效
								一般，自定义的注解，都定义为运行阶段。
							RetentionPolicy.CLASS：表示编译阶段，在源码、编译期有效，运行期无效
							RetentionPolicy.SOURCE：表示源码阶段，在源码阶段有效，编译期、运行期无效
					2）常见的元注解
							@Retention	：表示注解的存在的阶段
							@Target：表示注解存在的位置(类、方法、属性)
							@Documented：描述注解是否被抽取到api文档中
							@Inherited：描述注解是否被子类继承
	
		3）在程序使用(解析)注解【重点】：


=======================================补充
Junit环境的添加
1、在module中和src同级的地方建立lib文件夹
2、将Junit的jar包复制到lib中
3、在lib上点击“Add As Library”
4、在Level中选择Module Library
5、点击OK