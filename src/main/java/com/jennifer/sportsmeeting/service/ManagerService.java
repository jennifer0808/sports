package com.jennifer.sportsmeeting.service;

import com.jennifer.sportsmeeting.bean.Manager;

/**
 * 业务层
 */
public interface ManagerService {
    //登录(一个系统只有一个管理员）
    Manager login(Manager manager);
    int updatePwdManager(Manager manager);
}
