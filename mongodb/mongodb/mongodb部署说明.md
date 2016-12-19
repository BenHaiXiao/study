# mongodb高可用部署说明

_撰写:肖本海_

本文旨在说明高可用部署流程和注意事项，实验机器为：172.27.137.12

## 部署结构

![alt text](http://www.plantuml.com/plantuml/png/AqXCpavCJrLGoitFIyzFINBEoKpDAp5GKgZcYaOLYjNLjOj-iNtzyoaRdytfVTgry4LNq_EcdR5SjLm5M0qnn3J4a6H3Z30DCS9Z2C8KJ7cGIGfOzBtVqm4sl_ZzdawmqIzRUv_lNGTHyd9s6r0-EJylBJCT9C-5LnQa-sb7s_FETeZH1a3Puep4eXG3qlKQmlGQagxN2ARN2AmNAN3nc08EQJHv0ms8j85ch8Ak0hgi8LJMK1FJVKXokkXoHb0v8qrDr4Z36NPWjprTqlkqOnjGFrI1HX7KMMWIXXf5O1TX5TQDVjgswSNYHcX0QHGPQQ844Cue61WdeCGahPq00000)

**路由服务节点**：数据库集群请求的入口，所有的请求都通过mongos进行协调，不需要在应用程序添加一个路由选择器，mongos自己就是一个请求分发中心，它负责把对应的数据请求请求转发到对应的shard服务器上；在生产环境通常有多mongos作为请求的入口，防止其中一个挂掉所有的mongodb请求都没有办法操作；

**配置服务节点**：存储所有数据库元信息（路由、分片）的配置。mongos本身没有物理存储分片服务器和数据路由信息，只是缓存在内存里，配置服务器则实际存储这些数据。mongos第一次启动或者关掉重启就会从 config server 加载配置信息，以后如果配置服务器信息变化会通知到所有的 mongos 更新自己的状态，这样 mongos 就能继续准确路由。在生产环境通常有多个 config server 配置服务器，因为它存储了分片路由的元数据，这个可不能丢失！就算挂掉其中一台，只要还有存货， mongodb集群就不会挂掉；

**分片节点**： 在mongodb集群只要设置好了分片规则，通过mongos操作数据库就能自动把对应的数据操作请求转发到对应的分片机器上；

**复制集节点**： 每一个复制集都是一个完整的备份，2个副本 + 1个仲裁重复保证了数据的完整可靠性；

## 安装目录详解

config目录为配置服务节点目录

data目录为分片节点目录

mongos目录为路由服务节点目录

scripts目录为启动**执行脚本**：start_mongo_cluster_init.sh和**重启执行脚本**：start_mongo_cluster.sh

## 账号密码

Mongodb(分片集群)
IP:172.27.137.12
PORT:50000
管理账号:admin
管理密码:admin

## 重启流程

运行启动脚本：
/data/mongodb/scripts/start_mongo_cluster.sh 

## 注意事项

1、keyFile文件为密码文件，需要修改其权限为400

2、mongodb3.4版本配置服务升级改为集群模式需要配置复制集。见config目录的mongo.conf文件

3、建议使用mongodb用户执行脚本，mongodb数据目录所有者建议修改为mongodb。

具体命令：su mongodb 

passward：mongodb

4、管理员账户和密码：

user：admin

password：admin

数据库读写授权流程：

 /usr/local/mongodb/bin/mongo 127.0.0.1:50000/admin

use admin

db.auth("admin","admin")

 db.createUser(
...      {
...       user: "用户名",
...        pwd: "密码",
...       roles: [
...          { role: "readWrite", db: "你要授权的db名字"}   
...       ]
...      }
...  )

例如：

 db.createUser(
...      {
...       user: "ylottery",
...        pwd: "ylottery",
...       roles: [
...          { role: "readWrite", db: "ylottery_record"}   
...       ]
...      }
...  )





















