=======================================回顾和复习
1）EL表达式：
	1）格式：${表达式}
	2）功能：
			* 执行运算
			* 获取作用域中的数据
	3）隐式对象：11个，pageContext
2）JSTL标签：
	1）使用前，需要引入JSTL的相关jar包的
	2）在页面引入jstl标签库
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	3）常用标签：
			c:if	
			c:choose(c:when,c:otherwise)
			c:forEach
3）三层架构
	web层(表现层、界面层)： 《===》	V， C
	service层：《===》M
	dao层：《===》M

=======================================内容介绍
***** 用户的CRUD
		1）基本功能
				登录
					核心：
						1、先比较验证码，如果不一致，则返回登录页面，提示验证码错误
						2、如果验证码一致，则验证码正确
								根据账号和密码，进行数据库数据检索，得到一个User对象
						3、如果User对象为null，则账号密码错误，跳转到登录页面，提示账号密码错误
						4、如果User对象不为null，则账号密码正确，跳转到index.jsp
					注意：
						1）登录成功后，将登录的账号信息存储在session中
						2）重定向
				增删改，查(已完成)
					增加：
						注意：在添加数据完成后，一定是重定向，否则会重复添加数据 ====》重复提交
					删除：
						1）要删除的用户id的传递
						2）在删除数据之前，一般都会有提示，防止用户误操作
						3）a标签的href属性中是可以写js代码，要求这个js代码只有一行。
					修改 ：
						1）修改前根据id查询
								* 回显数据
									input框 数据回显：设置value属性
									textarea框数据回显：设置标签体内容
								* 单选框、下拉框等数据回显如何做
									单选框：
										<c:if test="${user.gender == '男'}">
											<input type="radio" name="gender" value="男" checked/>男
											<input type="radio" name="gender" value="女"/>女
										</c:if>
										<c:if test="${user.gender == '女'}">
											<input type="radio" name="gender" value="男"/>男
											<input type="radio" name="gender" value="女" checked/>女
										</c:if>
									下拉框：
										* 判断的另外一种写法：
											<option value="陕西" <c:if test="${user.address == '陕西'}">selected</c:if>>陕西</option>
											<option value="北京" <c:if test="${user.address == '北京'}">selected</c:if>>北京</option>
											<option value="上海" <c:if test="${user.address == '上海'}">selected</c:if>>上海</option>
										* 判断的另外一种写法2：
											<option value="陕西" ${user.address == '陕西' ? "selected" : ""}>陕西</option>
											<option value="北京" ${user.address == '北京' ? "selected" : ""}>北京</option>
											<option value="上海" ${user.address == '上海' ? "selected" : ""}>上海</option>
								* 隐藏域存储id
										<input type="hidden" name="id" value="${user.id}">
						2）修改数据:
								类似于数据添加
		2）复杂功能
				删除选中的条目(批量删除)
					* 如何获取要删除数据的ID并且传递给Servlet？
							1）要将数据的id绑定在checkbox的value属性上
							2）表单方式提交(表单中选中的checkbox会默认提交)
					* 细节处理：
							1）全选全不选的效果
							2）删除是的提示信息
							3）Service中遍历删除时程序的健壮性判断(先判断下ids集合是否为null)
				分页查询
					* 分页的方式：
						* 物理分页 ：使用sql语句，每次查询数据库数据的时候，数据量是给定的。【常用】 MySQL的分页查询语法：limit 
								优势：服务器压力小，资源消耗低
								劣势：和数据库的交互比较频繁
						* 逻辑分页 ：一次性将数据全部查询出来封装在一个list集合中，然后根据页码的不同进行集合的截取，得到每一页的数据
								优势：只和数据库交互一次
								劣势：服务器 压力大，很有可能程序直接崩溃(OOM异常)
					* 数据流向以及数据的种类
						* 浏览器==》服务器 
								currentPage 当前页
								rows	每页显示的数据条数
						* 服务器==》浏览器
								列表数据	List	需要查询数据库
								总页数		int		计算出来
								总记录数	int		数据库直接查询得到	
								当前页码	int		浏览器传过来的 
								每页记录数	int		可以由浏览器传递，也可以在服务器端直接默认

								* 将这些数据封装在一个PageBean的对象中，也就是说服务器只需要向浏览器传递一个PageBean对象即可。
				
						* 代码逻辑
								* 分页条逻辑
									1）分页条页码展示，要注意当前页码的样式问题
										<c:forEach begin="1" end="${pb.totalPage}" var="i" >
											<c:if test="${pb.currentPage == i}">
												<li class="active"><a href="javascript:void(0);">${i}</a></li><!-- 如果已经是当前页，就不需要点击了 -->
											</c:if>
											<c:if test="${pb.currentPage != i}">
												<li><a href="${pageContext.request.contextPath}/findUserByPageServlet?currentPage=${i}&rows=5">${i}</a></li>
											</c:if>
										</c:forEach>
									2）上一页的处理：如果是第一页，就不需要点击上一页了
										设置href="javascript:void(0);"
									3）下一页的处理：如果已经是最后一页，就不需要点击下一页了
										设置href="javascript:void(0);"
								* 后台代码逻辑
									1）Servlet：
											* 接收参数：currentPage、rows
											* 调用service得到一个PageBean对象
											* 将PageBean对象存储到request中
											* 转发到list.jsp
									2）service：
											* 创建一个PageBean对象
											* 设置参数
													当前页码		：浏览器传递的
													每页显示条数	：浏览器传递的
													总记录数		：查询数据库，需要dao提供相关的方法
													总页数			：根据总记录数和每页显示条数计算得到的
													分页列表数据	：查询数据库,需要dao提供相对应的方法
																			start = (currentPage - 1) * rows
											* 返回PageBean对象即可
									3）dao：
											* 提供查询总记录数的方法
													template.queryForObject("select count(*) from user", Integer.class);
											* 提供查询分页数据的方法
													template.query("select * from user limit ?, ?", new BeanPropertyRowMapper<User>(User.class), start, rows)

				条件查询带分页