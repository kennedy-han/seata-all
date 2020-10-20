package com.kennedy.two.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * @ClassName RmTwoTCCInterface
 * @Description TODO
 * @Author kennedyhan
 * @Date 2020/10/20 0020 16:25
 * @Version 1.0
 **/
@LocalTCC
public interface RmTwoTCCInterface {

    @TwoPhaseBusinessAction(name = "rm2TccAction" , commitMethod = "rm2Commit" ,rollbackMethod = "rm2Rollback")
    public String rm2(BusinessActionContext businessActionContext);

    public boolean rm2Commit(BusinessActionContext businessActionContext);

    public boolean rm2Rollback(BusinessActionContext businessActionContext);
}
