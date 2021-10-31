# Readme

### 项目简介

一个简单的新闻发布审核的后台管理系统。跟着教程一步步做的。只写了后端部分。前端以及 mapper 文件直接复制，并对 mapper 进行了简单修改。对原有教程中的 bug 进行了修复，并删除了验证码的功能。

### 项目意义

熟练应用 springboot ，对前后端联调有一定了解。

### 遇到的问题

* com.example.util.PageResult 中 开始的写法为 private List<?> data 。在调试过程中发现，前端已经获取数据，却无法渲染。

  解决思路如下：

  首先试着寻找前端中相关数据渲染的程序，查看其逻辑。但由于不熟悉，仅看懂大概，没有找到如何渲染。

  接着求助万能的搜索引擎，看到很多人给出的答案为 json 数据格式问题，于是找到教程源码，查看其 json 格式，发现该处 发送的字段名为 list 。尝试将上述属性重命名为 private List<?> list ，问题得到解决。

* 数据源连接释放时，未用 ssl 连接报错。简单解决为 useSSL=false。以后再详细了解。

### 下一步计划

学习如何根据已有的前端代码，在没有接口说明文档的前提下，得到前后端交互的 json 格式。



