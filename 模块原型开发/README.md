websocket模块
==================
###开发环境：
    1.Eclipse
    2.jdk1.7
    3.android4.4.2
    4.tomcat8.0
    
###资料如下：

###在AndroidManifest.xml中，加上这一句话，取得权限（原因:建立的套接字没有限权对外连接）：
    1.<uses-permission android:name="android.permission.INTERNET" />
    
[android-websocket包下载地址，websocket源码及安卓websocket包(在文件夹中搜索“autobohn.jar”）](https://github.com/tavendo/AutobahnAndroid)

[JSR-356 WebSocket API规范中文版](http://www.jmatrix.org/java/382.html)

[websocket源码及安卓websocket包(在文件夹中搜索“autobohn.jar”）](https://github.com/tavendo/AutobahnAndroid)

[客户端（html）javaee服务器tomcat8websocket实现（能调通）](http://blog.csdn.net/xiejx618/article/details/14519359)

[jsr356 API](https://jcp.org/en/jsr/detail?id=356)

[websocket自定义数据类型](http://www.tuicool.com/articles/fIFz6v)

[Dos命令查看端口占用及关闭进程](http://www.cnblogs.com/rainman/p/3457227.html)

[github for windows使用教程](http://www.cnblogs.com/zfanlong1314/p/3715490.html)

###java服务器端使用json:
    1.String message（"{\"firstName\":\"Brett\"}"）;
    2.JSONObject json = JSONObject.fromObject(message);
    3.json.get("firstName")
###android客户端使用json：
    1. try {
    2.        json = new JSONObject(payload);
    3.        json.getString("firstName");
    4.       } catch (JSONException e) {
    5.        // TODO Auto-generated catch block
    6.        e.printStackTrace();
    7.     }
###解决 Eclipse项目红感叹号:
    1.原因：显示红色感叹号是因为jar包的路径不对
    2.解决：在项目上右击Build Path -> Configure Build Paht...(或Propertise->Java Build Path)，在Java Build  Path中Libraries，红色叉号的包为路径错误的包。
    4.处理好后返回刷新工程即可，这个问题一般是导入别人的项目或之前的一些JAR包移动了它的存储位置。
    5.PS: 工程上黄色盾牌感叹号，表示有引用了jar包，但是实际上没有使用这个jar包(可以理解为定义了变量，但从未 来使用过)
    

