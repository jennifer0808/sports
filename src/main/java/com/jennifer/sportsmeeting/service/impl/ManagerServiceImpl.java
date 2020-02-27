package com.jennifer.sportsmeeting.service.impl;

import com.jennifer.sportsmeeting.bean.Manager;
import com.jennifer.sportsmeeting.exception.ManagerException;
import com.jennifer.sportsmeeting.mapper.ManagerMapper;
import com.jennifer.sportsmeeting.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service(value = "managerService")
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerMapper managerMapper;

    @Transactional(readOnly = true)
    @Override
    public Manager login(Manager manager) {
        Manager m=null;
        m=managerMapper.selectUserByManager(manager);
        if(m==null){
            throw new ManagerException(110,"该管理员用户不存在！");
        }
        return m;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public int updatePwdManager(Manager manager) {
        return 0;
    }


}
