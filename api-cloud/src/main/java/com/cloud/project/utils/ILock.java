package com.cloud.project.utils;

public interface ILock {
    /**
     * 尝试获取锁
     * @param timeoutSec 超时时间，单位秒
     * @return 是否获取成功 true-成功 false-失败
     */
    boolean tryLock(String lockKey, long timeoutSec);

    /**
     * 释放锁
     */
    void unlock(String lockKey);
}
