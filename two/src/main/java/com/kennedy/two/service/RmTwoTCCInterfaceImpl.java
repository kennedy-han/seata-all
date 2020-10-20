package com.kennedy.two.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName RmTwoTCCInterfaceImpl
 * @Description TODO
 * @Author kennedyhan
 * @Date 2020/10/20 0020 16:26
 * @Version 1.0
 **/
@Service
public class RmTwoTCCInterfaceImpl implements RmTwoTCCInterface {

    @Override
    @Transactional
    public String rm2(BusinessActionContext businessActionContext) {
        System.out.println("rm2 try");
//        System.out.println(1/0);

        return null;
    }

    @Override
    @Transactional
    public boolean rm2Commit(BusinessActionContext businessActionContext) {
        System.out.println("rm2 confirm");
        return true;
    }

    @Override
    @Transactional
    public boolean rm2Rollback(BusinessActionContext businessActionContext) {
        System.out.println("rm2 rollback");
        return true;
    }
}
