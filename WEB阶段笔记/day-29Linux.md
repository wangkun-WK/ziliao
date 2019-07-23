========================================回顾和复习
1）案例：黑马旅游网
	* 1、为什么要使用HTML？HTML的数据是如何更新的？
	* 2、ajax使用
			jQuery框架异步方法：
					$.get()/$.post()
	* 3、使用js操作json数据
			* json的格式：
					{}	:表示一个对象，获取数据：对象.key/对象["key"]
					[]	:表示一个数组，获取数据：对象[index].key
			* 更新html数据
					jQuery的html()方法
2）javamail
		smtp.163.com	:
		pop3.163.com	:

=======================================内容介绍
1）Linux
		1）Linux的概述
				* Linux是一个开源免费操作系统，由c语言编写的基于Unix
				* 应用场景：
						服务器：web服务器、数据库服务器、...
				* 版本：
						内核版本:
						发行版本: CentOS
				* 环境搭建：
						前置条件：
							* 保证本机是支持虚拟化
									securable.exe 查看
							* 保证本机的虚拟化开发已开启
									BIOS中查看
							* Linux位数：32位
						安装虚拟机
							* 安装成功后，在网络连接处会出现两块虚拟网卡。
						安装Linux环境
							* Linux安装成功后，会内置一个root账号。我们在刚开始设置的密码就是root的密码
							* 后续创建的账号是普通用户，在练习阶段不用，使用root账号
							* 命令：ifconfig，查看linux的ip的
		2）Linux的目录结构
				/		:根目录
				/root	:root账号的家目录(宿主目录)，使用root账号连接linux默认的目录
				/home/用户	:普通用户的家目录
				/etc	:linux的配置文件目录
				/usr	:用户共享资源目录
		3）Linux的命令【应用】
				ifconfig：查看ip等信息	
				pwd		：列出当前目录
				ls		：列出文件列表
					参数：-a, 列出所有文件
					      -l, 以长列表显示(文件的详细信息)，  ls -l ==》ll
				cd		：目录切换：
							使用 cd app	切换到app目录
								cd ..	切换到上一层目录
								cd /		切换到系统根目录
								cd ~		切换到用户主目录
								cd -		切换到上一个所在目录
							使用tab键来补全文件路径
				mkdir	：创建目录
					参数：-p, 创建多级目录
				rmdir	：移除目录(空目录)
				cat/more/less	:浏览文件内容，cat全部展示，more/less是分页展示
				tail			:tail -f 日志文件	动态查看文件内容
				cp		：复制文件
							cp 原始文件 新文件	：复制带改名例如：cp a.txt b/c.txt
							cp 原始文件 目录	：复制文件到该目录下 cp a.txt c/ 
				mv		：移动文件
							mv 原始文件 新文件	：移动带改名例如：mv a.txt b/c.txt		：可以实现重命名文件的功能
							mv 原始文件 目录	：移动文件到该目录下 mv a.txt c/ 
				rm		：删除文件
							rm -rf ./*	：删除当前目录下的所有文件(夹)
				tar		：压缩和解压缩
							1）linux中的压缩包
									*.tar	:打包文件
									*.tar.gz:打包并压缩文件
							2）打包命令
									tar -cvf xxx.tar 文件/目录
									tar -zcvf xxx.tar.gz 文件/目录
							3）解压缩
									tar -xvf xxx.tar/xxx.tar.gz	解压缩
									tar -zxvf	xxx.tar.gz	解压缩
				find	：查找文件的位置
							find / -name my.cnf
				
				grep	：关键字检索
							grep lang anaconda-ks.cfg --color -A5 -B5
				clear/Ctrl+l	：清屏

				vi/vim编辑器	：进行文件编辑
						提供了三种模式：
								命令行模式	：使用 vi/vim 文件, 进入命令行模式
								插入模式	：在命令行模式输入： IOAioa
								底行模式	：在命令行模式，直接输入 : 进入底行模式
											  在插入模式下，按 Esc 键，切换到命令行模式，输入 : 进入底行模式
											  :wq 保存并退出
											  :q!强制退出
						在命令行模式,输入:/关键字，可以进行关键字检索
				
				> 和 >>		：重定向输出，前面命令的输出，追加到某个文件中
					>		：覆盖
					>>		：追加

				ps -ef | grep java
						: ps -ef , 查询所有的正在运行的进程
						: | , 管道，将前面的命令的输出，作为后面命令的输入
						: grep java ,查找 ps -ef列出的进程中有java关键字的进程

				kill	:杀进程
							kill -9 进程号	强制杀死进程

		4）linux权限系统
			1）由10位数表示，在ll命令后，第一部分内容就是
					第1位数	：代表文件类型
								-	：文件
								d	：目录
								l	：链接
					第2-4位数：表示当前用户所具有的的该文件的权限
					第5-7位数：表示当前用户所在组的其他用户所具有的的该文件的权限
					第8-10位数：表示其他组用户所具有的的该文件的权限

			2）权限：
					r(4)	:可读	
					w(2)	:可写
					x(1)	:可执行		7的故事

			3）修改权限：chmod
					chmod u=权限, g=权限 , o=权限  文件(目录)
					chmod 777 文件
		5）网络服务
			* /etc/syscofig/network-script/ifcfg-eth0		网卡配置文件
					ONBOOT=yes	：在Linux启动的时候，就是用这块网卡
			* 服务的命令
				service network restart	重启网络服务
				service iptables stop	关闭防火墙   ：防火墙 iptables


2）Linux
		1）发布黑马旅游网到linux服务器
				* 安装jdk
				* 安装tomcat
				* 安装mysql
				* 安装redis
				* 发布web应用
		2）Nginx
				* 安装Nginx
				* tomcat+Nginx 集群搭建