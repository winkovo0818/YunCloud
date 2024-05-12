package com.cloud.project.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
@Component
public class RedisLock implements ILock{
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public boolean tryLock(String lockKey, long timeoutSec) {
        Boolean result = redisTemplate.opsForValue().setIfAbsent(lockKey, "LOCKED", timeoutSec, TimeUnit.SECONDS);
        return result != null && result;
    }

    @Override
    public void unlock(String lockKey) {
        redisTemplate.delete(lockKey);
    }
}
