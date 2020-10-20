package com.kennedy.three.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName RmThreeTCCInterfaceImpl
 * @Description TODO
 * @Author kennedyhan
 * @Date 2020/10/20 0020 16:37
 * @Version 1.0
 **/
@Service
public class RmThreeTCCInterfaceImpl implements RmThreeTCCInterface {
    @Override
    @Transactional
    public String rm3(BusinessActionContext businessActionContext) {
        System.out.println("rm3 try");
//        System.out.println(1/0);

        return null;
    }

    @Override
    @Transactional
    public boolean rm3Commit(BusinessActionContext businessActionContext) {
        System.out.println("rm3 confirm");
        return true;
    }

    @Override
    @Transactional
    public boolean rm3Rollback(BusinessActionContext businessActionContext) {
        System.out.println("rm3 rollback");
        return true;
    }
}
