### Step 1: 下载

[下载release版本](https://github.com/alibaba/nacos/releases)

以 release nacos-server-0.9.0.zip 为例.

    unzip nacos-server-0.9.0.zip
    cd nacos/bin 
### Step 2: 启动 Server

以单例模式运行:
在Linux/Unix/Mac平台
    sh startup.sh -m standalone
在Windows平台,双击startup.cmd 运行.

    cmd startup.cmd -m standalone
详细请看 [quick-start](https://nacos.io/en-us/docs/quick-start.html "quick-start").