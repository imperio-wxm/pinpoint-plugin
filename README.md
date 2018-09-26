# pinpoint-plugin
This a project for pinpoint-plugin

> 需要放在pinpoint——>plugins目录下，同项目一起编译。Jar包上pinpoint-web、pinpoint-collector、agent的lib下

## Plugin List

- simple-log

> 拦截程序中 `ch.qos.logback.classic.Logger.info` 下，日志内容中含有 `HDFS file size` 的日志进行trace
