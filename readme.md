### 项目介绍
API开放平台，管理员可以接入并发布接口，可视化结构使用情况。用户可以在线调试接口，通过接入SDK轻松调用接口<br>
技术架构:Spring Boot + Dubbo + Spring Cloud Gateway + Redis + Mysql + React + Ant Design Pro<br>
功能模块:接口管理、接口调试、接口监控、接口统计、接口文档、接口SDK<br>

### 作者信息
作者: 云淡风轻<br>
邮箱: 1026771081@qq.com<br>
博客: http://blog.winkovo.top/

### 目录结构<br>
api-client: 客户端<br>
api-cloud: 服务端<br>
api-gateway: 网关<br>
api-interface: 接口<br>
api-common: 公共模块<br>




### 启动流程
#### 启动api-interface项目<br>
#### 启动api-cloud项目<br>
#### 启动api-gateway项目<br>


### 启动服务类和网关记得修改配置文件<br>
api-cloud: application.yml<br>
api-gateway: application.yml<br>
修改配置文件中的Nacos连接信息<br>

