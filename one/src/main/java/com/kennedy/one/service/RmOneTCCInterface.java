package com.kennedy.one.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

/**
 * 测试 Seata TCC模式
 */
@LocalTCC
public interface RmOneTCCInterface {

    /**
     * rm1 指定 commit 和 rollback方法
     * @param businessActionContext
     * @return
     */
    @TwoPhaseBusinessAction(name = "rm1TccAction", commitMethod = "rm1Commit", rollbackMethod = "rm1Rollback")
    public String rm1(BusinessActionContext businessActionContext);

    public boolean rm1Commit(BusinessActionContext businessActionContext);

    public boolean rm1Rollback(BusinessActionContext businessActionContext);
}
