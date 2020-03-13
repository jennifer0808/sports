package com.jennifer.sportsmeeting.service.impl;

import com.jennifer.sportsmeeting.bean.Manager;
import com.jennifer.sportsmeeting.common.GlobalConstant;
import com.jennifer.sportsmeeting.exception.MyException;
import com.jennifer.sportsmeeting.mapper.ManagerMapper;
import com.jennifer.sportsmeeting.service.ManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Transactional(readOnly = true)
@Service(value = "managerService")
public class ManagerServiceImpl implements ManagerService {
    private final static Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);
    @Autowired
    private ManagerMapper managerMapper;

    @Transactional(readOnly = true)
    @Override
    public Manager login(Manager manager) throws MyException{
        Manager m = null;
        try {
            m = managerMapper.selectUserByManager(manager);
        } catch (Exception e) {
            GlobalConstant.ifFlag = true;
            logger.error("ManagerServiceImpl login():"+e.getMessage());
        }
        return m;
    }


    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public int updatePwdManager(Manager manager) {
        return 0;
    }


}
