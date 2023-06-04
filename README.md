# SHF
房多多是一个二手房管理服务平台，开放优质资源和线上能力，聚合线上线下二手房产资源，打造一个全方位二手房服务生态市场，为消费者提供优质房产服务资源。、

## 2、核心技术

| 基础框架：ssm                       |
| ----------------------------------- |
| 分布式框架：ssm + Dubbo + zk        |
| spring session redis实现session共享 |
| 图片服务器：七牛云                  |
| 后台管理权限控制：spring-security   |
| 前端用户登录判断：拦截器            |
| 后台管理模板：Thymeleaf             |
| 前端技术:Vue+Axios                  |

## 3、项目模块

最终分布式架构模块

shf-parent：根目录，管理子模块：

​	common-util：公共类模块

​	model：实体类模块

​	service：dubbo服务父节点

​		service-acl：权限服务模块

​		service-house：房源服务模块

​		service-user：用户服务模块

​	service-api：dubbo服务api接口

​	web：前端（dubbo服务消费者）

​		web-admin：后台管理系统

​		web-front：网站前端



模块调用关系，如图：

![images/1.搭建环境/image-20220214132059749](images/1.搭建环境/image-20220214132059749.png)
