SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Records of demo_robot_job
-- ----------------------------
INSERT INTO `demo_robot_job` VALUES ('1', '1', '2017-04-17 10:38:55', '2017-04-17 10:38:58', '1', '222.0000', '112', null, '00000000', '0', '2017-04-17 10:57:13', null);
-- ----------------------------
-- Records of demo_robot_main
-- ----------------------------
INSERT INTO `demo_robot_main` VALUES ('1', 'sssdd', '12.00', 'sss', '34', 'sss', '2017-04-17', '0000000', '0', '2017-09-06 16:50:35', null);
INSERT INTO `demo_robot_main` VALUES ('2', '12', '12.00', '12', '12', '12', '2017-09-06', '0', '1', '2017-09-06 16:36:33', null);
INSERT INTO `demo_robot_main` VALUES ('3', '12', '1.00', '2', '1', '1', '2017-09-06', '0', '1', '2017-09-06 16:32:36', null);
-- ----------------------------
-- Records of msg_info
-- ----------------------------
INSERT INTO `msg_info` VALUES ('1', '党代会召开', 'admin', 'admin', '2017-08-28 17:32:53', null, '1d12222', null, '', null, null, 'Message', null, '', '1', '1', '2017-08-29 16:31:06', null);
INSERT INTO `msg_info` VALUES ('2', '人民万岁', 'admin', 'admin', '2017-08-10 17:54:50', null, '12222222', null, null, null, null, 'Message', null, '', '1', '1', '2017-08-28 19:09:21', null);
INSERT INTO `msg_info` VALUES ('3', '我爱北京天安门', null, null, '2017-08-28 22:03:31', null, '22222', null, null, null, null, 'Message', null, null, '1', '1', '2017-08-28 22:03:46', null);
INSERT INTO `msg_info` VALUES ('4', '让我们荡起双桨', null, null, '2017-08-23 22:04:15', null, '22222', null, null, null, null, 'Message', null, null, '1', '1', '2017-08-28 22:04:27', null);
INSERT INTO `msg_info` VALUES ('5', '钢铁是怎样炼成的', null, null, '2017-08-27 22:10:58', null, '222222', null, null, null, null, 'Message', null, null, '1', '1', '2017-08-28 22:11:11', null);
INSERT INTO `msg_info` VALUES ('6', '十万个冷笑话', null, null, '2017-08-29 19:56:06', null, null, null, null, null, null, 'Message', null, null, null, '0', '2017-08-29 19:56:06', null);
INSERT INTO `msg_info` VALUES ('7', '福禄娃篇', null, null, '2017-08-29 19:57:26', null, null, null, null, null, null, 'Message', null, null, null, '0', '2017-08-29 19:57:26', null);
INSERT INTO `msg_info` VALUES ('8', '匹诺曹篇', null, null, '2017-08-29 19:58:33', null, null, null, null, null, null, 'Message', null, null, null, '0', '2017-08-29 19:59:08', null);
INSERT INTO `msg_info` VALUES ('9', '哪吒篇', null, null, '2017-08-29 20:00:31', null, '22222222', null, null, null, null, 'Message', null, null, null, '0', '2017-08-29 20:00:31', null);
INSERT INTO `msg_info` VALUES ('10', '我的野兽女友', null, null, '2017-08-29 20:03:17', null, '小怪兽小怪兽', null, null, null, null, 'Message', null, null, null, '0', '2017-08-29 20:03:17', null);
INSERT INTO `msg_info` VALUES ('11', '时光鸡篇', null, null, '2017-08-29 20:04:26', null, '时光鸡篇时光鸡篇时光鸡篇时光鸡篇时光鸡篇时光鸡篇时光鸡篇时光鸡篇时光鸡篇时光鸡篇时光鸡篇', null, null, null, null, 'Message', null, null, null, '0', '2017-08-29 20:04:26', null);
-- ----------------------------
-- Records of saa_factor
-- ----------------------------
INSERT INTO `saa_factor` VALUES ('com_code', null, 'String', '0', '2017-09-14 18:21:55', null);
INSERT INTO `saa_factor` VALUES ('status', null, 'String', '0', '2017-09-15 13:47:44', null);
-- ----------------------------
-- Records of saa_factor_field
-- ----------------------------
INSERT INTO `saa_factor_field` VALUES ('1', 'com_code', 'POSTCODE', 'sys_user', '0', '2017-09-14 19:36:05', null);
INSERT INTO `saa_factor_field` VALUES ('2', 'status', 'STATUS', 'bpo_file', '0', '2017-09-15 13:48:05', null);
-- ----------------------------
-- Records of saa_role
-- ----------------------------
INSERT INTO `saa_role` VALUES ('admin', '管理员', null, null, '00000000', null, null, null, null, '1', null, null, '1', '2015-04-17 17:18:36', null);
INSERT INTO `saa_role` VALUES ('employee', '员工', null, null, '00000000', null, null, null, null, '1', null, null, '1', '2015-04-17 17:18:36', null);
INSERT INTO `saa_role` VALUES ('manager', '项目经理', null, null, '00000000', null, null, null, null, '1', null, null, '1', '2015-04-17 17:18:36', null);
-- ----------------------------
-- Records of saa_role_task
-- ----------------------------
INSERT INTO `saa_role_task` VALUES ('1', 'admin', 'platform', null, null, '1', '2017-09-26 17:18:25', null);
INSERT INTO `saa_role_task` VALUES ('2', 'admin', 'PLAT_USER', null, null, '1', '2015-04-23 16:22:03', null);
INSERT INTO `saa_role_task` VALUES ('3', 'admin', 'PLAT_USER_LIST', null, null, '1', '2015-04-23 16:22:03', null);
INSERT INTO `saa_role_task` VALUES ('4', 'admin', 'PLAT_USER_VIEW', null, null, '1', '2015-04-23 16:22:03', null);
INSERT INTO `saa_role_task` VALUES ('5', 'admin', 'PLAT_USER_EDIT', null, null, '1', '2015-04-23 16:22:03', null);
INSERT INTO `saa_role_task` VALUES ('6', 'admin', 'PLAT_USER_SAVE', null, null, '1', '2015-04-23 16:22:03', null);
INSERT INTO `saa_role_task` VALUES ('8', 'employee', 'platform', null, null, '1', '2017-09-26 17:25:44', null);
INSERT INTO `saa_role_task` VALUES ('10', 'manager', 'platform', null, null, '1', '2017-09-26 17:25:32', null);
-- ----------------------------
-- Records of saa_task
-- ----------------------------
INSERT INTO `saa_task` VALUES ('platform', '系统', 'platform', 'System', '其它配置', null, null, '/**', null, null, null, null, '1', 'test', null, '1', '2017-09-26 17:20:10', null);
INSERT INTO `saa_task` VALUES ('PLAT_PACKAGE', '系统管理', 'platform', 'Package', null, null, null, '/**', null, null, null, null, '1', null, null, '1', '2017-09-26 17:23:59', null);
INSERT INTO `saa_task` VALUES ('PLAT_USER', '用户', 'PLAT_PACKAGE', 'Module', '用户管理', null, null, '/sysuser/**', null, null, null, null, '1', null, null, '1', '2017-09-26 17:24:15', null);
INSERT INTO `saa_task` VALUES ('PLAT_USER_DELETE', '用户', 'PLAT_USER', 'Task', '用户删除', null, null, '/sysUser/delete**', null, null, null, null, '1', null, null, '1', '2017-09-26 17:24:56', null);
INSERT INTO `saa_task` VALUES ('PLAT_USER_EDIT', '用户', 'PLAT_USER', 'Task', '用户编辑', null, null, '/sysUser/edit/**', null, null, null, null, '1', null, null, '1', '2017-09-26 17:25:00', null);
INSERT INTO `saa_task` VALUES ('PLAT_USER_LIST', '用户', 'PLAT_USER', 'Task', '用户查看', null, null, '/sysUser/list', null, null, null, null, '1', null, null, '1', '2017-09-26 17:25:01', null);
INSERT INTO `saa_task` VALUES ('PLAT_USER_SAVE', '用户', 'PLAT_USER', 'Task', '用户保存', null, null, '/sysUser/save', null, null, null, null, '1', null, null, '1', '2017-09-26 17:25:02', null);
INSERT INTO `saa_task` VALUES ('PLAT_USER_SEARCH', '用户', 'PLAT_USER', 'Task', '用户查询', null, null, '/sysUser/search', null, null, null, null, '1', null, null, '1', '2017-09-26 17:25:03', null);
INSERT INTO `saa_task` VALUES ('PLAT_USER_VIEW', '用户', 'PLAT_USER', 'Task', '用户查询', null, null, '/sysUser/view/**', null, null, null, null, '1', null, null, '1', '2017-09-26 17:25:05', null);
-- ----------------------------
-- Records of saa_user_power
-- ----------------------------
INSERT INTO `saa_user_power` VALUES ('1', 'admin', 'com_code', 'in', '000000,000001', 'platform', '0', '2017-09-14 20:09:16', null);
INSERT INTO `saa_user_power` VALUES ('2', 'admin', 'status', '=', '01', 'platform', '0', '2017-09-15 17:26:22', null);
-- ----------------------------
-- Records of saa_user_role
-- ----------------------------
INSERT INTO `saa_user_role` VALUES ('1', 'admin', 'admin', '2014-11-06 00:00:00', '2114-11-06 00:00:00', null, null, '1', '2014-11-06 15:19:26', null);
INSERT INTO `saa_user_role` VALUES ('18', 'manager1', 'manager', '2014-11-06 00:00:00', '2114-11-06 00:00:00', null, null, '1', '2015-04-22 17:12:49', null);
INSERT INTO `saa_user_role` VALUES ('19', 'manager2', 'manager', '2014-11-06 00:00:00', '2114-11-06 00:00:00', null, null, '1', '2015-04-22 17:12:49', null);
INSERT INTO `saa_user_role` VALUES ('20', 'employee1', 'employee', '2014-11-06 00:00:00', '2114-11-06 00:00:00', null, null, '0', '2015-04-22 17:12:41', null);
INSERT INTO `saa_user_role` VALUES ('21', 'employee2', 'employee', '2014-11-06 00:00:00', '2114-11-06 00:00:00', null, null, '0', '2015-04-22 17:12:41', null);
INSERT INTO `saa_user_role` VALUES ('22', 'employee3', 'employee', '2014-11-06 00:00:00', '2114-11-06 00:00:00', null, null, '0', '2015-04-22 17:12:41', null);
INSERT INTO `saa_user_role` VALUES ('23', 'employee4', 'employee', '2014-11-06 00:00:00', '2114-11-06 00:00:00', null, null, '0', '2015-04-22 17:12:41', null);
INSERT INTO `saa_user_role` VALUES ('24', 'employee5', 'employee', '2014-11-06 00:00:00', '2114-11-06 00:00:00', null, null, '0', '2015-04-22 17:12:41', null);
-- ----------------------------
-- Records of sdd_code
-- ----------------------------
INSERT INTO `sdd_code` VALUES ('1', '1', 'mail.host', 'smtp.126.com', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('2', '1', 'mail.userName', 'jsptzsupport', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('3', '1', 'mail.password', 'jsptz1234', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('4', '1', 'mail.smtp.timeout', '25000', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('5', '1', 'mail.smtp.auth', 'true', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('6', '1', 'mail.sendFrom', 'jsptzsupport@126.com', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('7', '1', 'hibernate.dialect', 'org.hibernate.dialect.MySQLDialect', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('8', '1', 'cas.casserver', 'https://mycas.jsptz.com/casserver', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('9', '1', 'cas.webapp', 'http://localhost:8091/platform', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('10', '1', 'org.quartz.scheduler.instanceName', 'DefaultQuartzScheduler', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('11', '1', 'org.quartz.scheduler.rmi.export', 'false', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('12', '1', 'org.quartz.scheduler.rmi.proxy', 'false', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('13', '1', 'org.quartz.scheduler.wrapJobExecutionInUserTransaction', 'false', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('14', '1', 'org.quartz.threadPool.class', 'org.quartz.simpl.SimpleThreadPool', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('15', '1', 'org.quartz.threadPool.threadCount', '10', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('16', '1', 'org.quartz.threadPool.threadPriority', '5', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('17', '1', 'org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread', 'true', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('18', '1', 'org.quartz.jobStore.misfireThreshold', '60000', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('19', '1', 'org.quartz.jobStore.class', 'org.quartz.simpl.RAMJobStore', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('20', '1', 'rpc.platform.excportClassName', 'ins.framework.rpc.implement.kryo.KryoProxyFactoryBean', null, null, '1', null, '1', '2015-06-16 20:10:18', null);
INSERT INTO `sdd_code` VALUES ('21', '1', 'rpc.platform.urlPrefix', 'http://localhost:8091/platform-app/rpc/kryo', null, null, '1', null, '1', '2015-06-16 20:10:09', null);
INSERT INTO `sdd_code` VALUES ('22', '1', 'rpc.platform.connectTimeout', '60000', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('23', '1', 'rpc.platform.readTimeout', '120000', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('24', '1', 'rpc.platform.username', 'admin', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
INSERT INTO `sdd_code` VALUES ('25', '1', 'rpc.platform.password', 'sinosoft', null, null, '1', null, '1', '2014-06-13 15:21:53', null);
-- ----------------------------
-- Records of sdd_type
-- ----------------------------
INSERT INTO `sdd_type` VALUES ('1', 'App_Conf', '应用配置信息', '1', null, '1', '2014-06-13 14:55:17', null);
-- ----------------------------
-- Records of smc_menu
-- ----------------------------
-- ----------------------------
-- Records of smc_menu
-- ----------------------------
INSERT INTO `smc_menu` VALUES ('1', '1', '1', 'platform', '开发样例', null, null, null, null, '6', 'fa-folder', null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-20 13:44:34', null, null);
INSERT INTO `smc_menu` VALUES ('2', '1', '2', 'platform', '自定义标签', null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-18 11:30:18', null, null);
INSERT INTO `smc_menu` VALUES ('3', '2', '3', 'platform', '地址框', null, null, '/demo/tags/date_tag', null, '1', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-18 15:24:12', null, null);
INSERT INTO `smc_menu` VALUES ('4', '2', '3', 'platform', '分页列表', null, null, '/demo/table/table_page', null, '2', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-18 13:54:14', null, null);
INSERT INTO `smc_menu` VALUES ('9', '9', '1', 'platform', '系统管理', null, null, '', '', '4', 'fa-laptop', null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-20 13:41:52', null, null);
INSERT INTO `smc_menu` VALUES ('10', '9', '2', 'platform', '基础数据', null, null, '', '', '2', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2013-07-05 10:21:47', null, null);
INSERT INTO `smc_menu` VALUES ('11', '10', '3', 'platform', '用户管理', null, '', '/sysuser/user/list', '', '2', 'fa-user-circle-o', null, null, null, null, null, null, null, null, null, '1', null, null, '2', '2017-08-25 19:03:28', null, null);
INSERT INTO `smc_menu` VALUES ('116', '9', '2', 'platform', '权限管理', null, null, null, null, '2', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2017-09-18 13:39:23', null, null);
INSERT INTO `smc_menu` VALUES ('117', '116', '3', 'platform', '功能管理', null, null, '/saa/task/list', null, '1', 'fa-tasks', null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2017-09-18 13:44:29', null, null);
INSERT INTO `smc_menu` VALUES ('118', '116', '3', 'platform', '角色管理', null, null, '/saa/role/list', null, '2', 'fa-users', null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2017-09-18 13:50:14', null, null);
INSERT INTO `smc_menu` VALUES ('119', '116', '3', 'platform', '数据权限', null, null, '/saa/factor/list', null, '3', 'fa-superpowers', null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2017-09-18 13:55:05', null, null);
INSERT INTO `smc_menu` VALUES ('120', '9', '3', 'platform', '数据字典', null, null, null, null, '3', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2017-09-18 13:56:04', null, null);
INSERT INTO `smc_menu` VALUES ('121', '120', '3', 'platform', '基础数据', null, null, '/sdd/type/list', null, '1', 'fa-book', null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2017-09-18 14:44:45', null, null);
INSERT INTO `smc_menu` VALUES ('123', '120', '3', 'platform', '菜单管理', null, null, '/sys/menu/list', null, '3', 'fa-list-ol', null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2017-09-18 14:49:36', null, null);
INSERT INTO `smc_menu` VALUES ('124', '124', '1', 'platform', '监控平台', null, null, null, null, '5', 'fa-line-chart', null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-20 13:43:29', null, null);
INSERT INTO `smc_menu` VALUES ('125', '124', '2', 'platform', '服务管理', null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2017-12-20 14:05:03', null, null);
INSERT INTO `smc_menu` VALUES ('128', '125', '3', 'platform', '接口管理', null, null, '/zuul/intf/list', null, '2', 'fa-plug', null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-01-09 16:05:32', null, null);
INSERT INTO `smc_menu` VALUES ('129', '125', '3', 'platform', '限流方案', null, null, '/zuul/rtlimit/list', null, '3', 'fa-object-group', null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-01-09 16:05:39', null, null);
INSERT INTO `smc_menu` VALUES ('132', '125', '3', 'platform', '网关配置', null, null, '/gateway/user-list', null, '4', ' fa-magnet', null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2017-12-28 19:30:47', null, null);
INSERT INTO `smc_menu` VALUES ('133', '2', '3', 'platform', 'select2', null, null, '/select2/select', null, '1', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-20 13:43:07', null, null);
INSERT INTO `smc_menu` VALUES ('134', '2', '3', 'platform', 'autocomplete', null, null, '/autoCompleteDemo/autoCompleteDemo', null, '1', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-20 13:45:45', null, null);
INSERT INTO `smc_menu` VALUES ('135', '2', '3', 'platform', '概括', null, null, '/demo/general/general', null, '1', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-28 14:01:30', null, null);
INSERT INTO `smc_menu` VALUES ('136', '2', '3', 'platform', '图标', null, null, '/demo/icons/icons', null, '1', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-28 17:00:16', null, null);
INSERT INTO `smc_menu` VALUES ('137', '2', '3', 'platform', '按钮', null, null, '/demo/buttons/buttons', null, '1', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-28 18:04:17', null, null);
INSERT INTO `smc_menu` VALUES ('138', '2', '3', 'platform', '时间线', null, null, '/demo/timeline/timeline', null, '1', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-28 18:58:42', null, null);
INSERT INTO `smc_menu` VALUES ('139', '2', '3', 'platform', '模态框', null, null, '/demo/modals/modals', null, '1', null, null, null, null, null, null, null, null, null, null, '1', null, null, '1', '2018-12-28 19:10:38', null, null);
INSERT INTO `sys_application` VALUES ('1', 'platform', '平台管理系统', 'Platform Manage System', '平台系统', null, 'http://localhost:8091/platform', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `sys_trans_config` VALUES ('UserCode', '用户代码翻译', 'Sys_User', 'User_Code', 'User_Name', 'VALID_STATUS=?', '1', 'User_Code', null);

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '管理员', '1', 'sinosoft@sinosoft.com.cn', null, 'AB9B5A2BBE7E2F5D083892B263D9C340', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, '2015-01-01 00:00:00', '2115-01-01 00:00:00', null, '000000', '1', '0', '2017-12-28 14:33:33', null);
INSERT INTO `sys_user` VALUES ('2', 'employee1', '用户1', '1', 'sinosoft@sinosoft.com.cn', null, 'AB9B5A2BBE7E2F5D083892B263D9C340', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, '2015-01-01 00:00:00', '2115-01-01 00:00:00', null, '000001', '1', '0', '2017-12-28 14:33:33', null);
INSERT INTO `sys_user` VALUES ('3', 'employee2', '员工2', '1', 'sinosoft@sinosoft.com.cn', null, 'AB9B5A2BBE7E2F5D083892B263D9C340', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, '2015-01-01 00:00:00', '2115-01-01 00:00:00', null, null, '1', '0', '2017-12-28 14:33:34', null);
INSERT INTO `sys_user` VALUES ('4', 'manager1', '项目经理1', '1', 'sinosoft@sinosoft.com.cn', null, 'AB9B5A2BBE7E2F5D083892B263D9C340', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, '2015-01-01 00:00:00', '2115-01-01 00:00:00', null, null, '1', '0', '2017-12-28 14:33:34', null);
INSERT INTO `sys_user` VALUES ('5', 'manager2', '项目经理2', '1', 'sinosoft@sinosoft.com.cn', null, 'AB9B5A2BBE7E2F5D083892B263D9C340', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0', null, null, '2015-01-01 00:00:00', '2115-01-01 00:00:00', null, null, '1', '0', '2017-12-28 14:33:35', null);
INSERT INTO `sys_user` VALUES ('6', 'employee3', 'employee3', '1', '', null, '034FD2B7901A26AB19E74C3D4AFC8DFF', '', null, null, null, null, null, null, null, null, null, null, null, null, null, null, '1', null, null, '2017-05-23 08:00:00', '2017-05-24 08:00:00', null, null, '1', '0', '2017-12-28 14:33:37', null);
-- ----------------------------
-- Records of utiquartzconfig
-- ----------------------------
INSERT INTO `uti_quartz_config` VALUES ('18', 'jjjkk', 'jjj', 'admin', '0/10', '', '', '', '', '?', '', '0/10 * * * * ? *', 'ins.platform.quartz.service.myJob3', 'doJob2', '1', '1', '6', '2018-7-6 09:49:59', '2018-7-6 09:49:59');
INSERT INTO `uti_quartz_config` VALUES ('19', '10秒..111', '10秒1111', 'admin', '0/20', '', '', '', '', '?', '', '0/20 * * * * ? *', 'ins.platform.quartz.service.myJob4', 'doJob4', '1', '0','14', '2018-7-6 09:51:10', '2018-7-6 09:51:10');
-- ----------------------------
-- Records of sms_template
-- ----------------------------
INSERT INTO `sms_template` VALUES ('2020', '短信通知0', '2', '5', '您好，请凭取件码：${code}，至${address}取件，若有问题请咨询${phone}。', 1, '2018-09-21 16:29:26', '2018-09-17 15:53:46', '1');
