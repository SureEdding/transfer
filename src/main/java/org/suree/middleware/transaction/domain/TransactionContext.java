package org.suree.middleware.transaction.domain;

/**
 * 简易的分布式事务上下文
 * 分布式事务采用两步式提交
 * Try - Commit - Cancel
 * 正常应当由一个独立的中间件来进行管理
 * 简易版则以一个上下文实体 + 观察者模式来进行
 */
public class TransactionContext {

    //需要回滚
    private Boolean needRollback;

    /**
     * 转账进行到的步骤
     * 简易版写死，正常应当为注册制
     * 总体步骤为
     * 1、出账户prepared
     * 2、入账户prepared
     * 3、出账户committed
     * 4、入账户committed
     *
     * 其中一环出现失败，则向前依次回滚
     *
     */
    private Integer transactionsStep;


    public Boolean getNeedRollback() {
        return needRollback;
    }

    public void setNeedRollback(Boolean needRollback) {
        this.needRollback = needRollback;
    }

    public Integer getTransactionsStep() {
        return transactionsStep;
    }

    public void setTransactionsStep(Integer transactionsStep) {
        this.transactionsStep = transactionsStep;
    }
}
