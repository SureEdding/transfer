package org.suree.middleware.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class RedisClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisClient.class);

    public Boolean lock(String key, Integer expireTime) {
        try {
            Boolean lockResult = setnx(key, UUID.randomUUID(), expireTime);
            LOGGER.info("get lock for key={}, result={}, expireTime={}", key, lockResult, expireTime);
            return lockResult;
        } catch (Exception e) {
            LOGGER.error("error get lock for key={}, may have some problem with squirrel", key, e);
            //todo 锁降级
            return downGrade(key, expireTime);
        }
    }

    private Boolean downGrade(String key, int expireTime) {
        return true;
    }

    public Boolean release(String key) {
        try {
            Boolean result = delete(key);
            LOGGER.info("delete key={}, result={}", key, result);
            return result;
        } catch (Exception e) {
            LOGGER.error("error delete key={}, may have some problem with squirrel", key, e);
            return false;
        }
    }

    private Boolean setnx(String key, Object value, int expireTime) {
        return true;
    }

    private Boolean delete(String key) {
        return true;
    }

}
