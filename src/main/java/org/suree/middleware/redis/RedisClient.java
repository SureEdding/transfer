package org.suree.middleware.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class RedisClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisClient.class);

    public Boolean lock(String key, Integer expireTime, Boolean needDownGrade) {
        try {
            Boolean lockResult = setnx(key, UUID.randomUUID(), expireTime);
            LOGGER.info("get lock for key={}, result={}, expireTime={}, needDownGrade={}", key, lockResult, expireTime, needDownGrade);
            return lockResult;
        } catch (Exception e) {
            LOGGER.error("error get lock for key={}, may have some problem with squirrel", key, e);
            if (needDownGrade) {
                return true;
            } else {
                return true;
            }
        }
    }

    public Boolean delete(StoreKey key) {
        try {
            Boolean result = redisClient.delete(key);
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


}
