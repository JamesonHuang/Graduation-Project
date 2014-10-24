websocket：android客户端andjava服务器信息交互demo
==================
###websocketTest.rar文件说明：
    1.android客户端：WebSocketTest1文件夹
    2.java服务器端：WebSocketWebTest文件夹

###在AndroidManifest.xml中，加上这一句话，取得权限（原因:建立的套接字没有限权对外连接）：
    1.<uses-permission android:name="android.permission.INTERNET" />
    
[android-websocket包下载地址，websocket源码及安卓websocket包(在文件夹中搜索“autobohn.jar”）](https://github.com/tavendo/AutobahnAndroid)

[JSR-356 WebSocket API规范中文版](http://www.jmatrix.org/java/382.html)

[websocket源码及安卓websocket包(在文件夹中搜索“autobohn.jar”）](https://github.com/tavendo/AutobahnAndroid)

[http协议状态码详解](http://www.cnblogs.com/tankxiao/archive/2013/01/08/2818542.html#WhatsStatusCode)

[websocket原理](http://www.cnblogs.com/yjf512/archive/2013/03/11/2953483.html)

[客户端（html）javaee服务器tomcat8websocket实现（能调通）](http://blog.csdn.net/xiejx618/article/details/14519359)

[Android-----SharePreference](http://blog.sina.com.cn/s/blog_7f37847b0100yt31.html)

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
    

