package org.smartframework.cloud.examples.support.gateway.enums;

import org.smartframework.cloud.starter.redis.RedisKeyUtil;
import org.smartframework.cloud.starter.redis.enums.RedisKeyPrefix;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * gateway redis key前缀
 *
 * @author liyulin
 * @date 2020-04-19
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum GatewayRedisKeyPrefix {

	/** api meta */
	API_META(RedisKeyUtil.buildKey(RedisKeyPrefix.DATA.getKey(), "apimeta", RedisKeyPrefix.REDIS_KEY_SEPARATOR.getKey())),
	/** 权限 */
	AUTH(RedisKeyUtil.buildKey(RedisKeyPrefix.DATA.getKey(), "auth", RedisKeyPrefix.REDIS_KEY_SEPARATOR.getKey()));

	/** redis key prefix */
	private String key;

}