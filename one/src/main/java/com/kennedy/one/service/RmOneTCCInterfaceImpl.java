package com.kennedy.one.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName RmOneTCCInterfaceImpl
 * @Description 测试 Seata TCC模式
 * @Author kennedyhan
 * @Date 2020/10/20 0020 16:16
 * @Version 1.0
 **/
@Service
public class RmOneTCCInterfaceImpl implements RmOneTCCInterface {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @Transactional
    public String rm1(BusinessActionContext businessActionContext) {
        // 查询事务记录表，xxxx
        System.out.println("rm1 try");
        rm2();
        rm3();
//        System.out.println(1/0);
        return null;
    }

    @Override
    @Transactional
    public boolean rm1Commit(BusinessActionContext businessActionContext) {
        System.out.println("rm1 confirm");
        return true;
    }

    @Override
    @Transactional
    public boolean rm1Rollback(BusinessActionContext businessActionContext) {
        System.out.println("rm1 rollback");
        return true;
    }

    private void rm2() {
        restTemplate.getForEntity("http://two/rm2-tcc", null);
    }

    private void rm3() {
        restTemplate.getForEntity("http://three/rm3-tcc", null);
    }
}
