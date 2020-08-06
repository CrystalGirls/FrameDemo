**简单的框架Demo**
使用Spring Boot 2.3.2搭建
Mysql 8.0数据库
配置主要使用yml文件配置，因此properties中的内容被注释掉。
由于使用hibernate，所以第一次运行的时候可以直接将ddl-auto参数值改为create，让程序自动创建数据库，
第一次运行完之后就需要改回去，否则每次启动都会重新创建一次表