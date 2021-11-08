package com.ibm.cache;
import redis.clients.jedis.Jedis;

public class ConfigRedis {
	
	private static final String HOST = "redis-cache";
	private static final int    PORT = 6379;
	
	public static Jedis redisConnection() {
		return new Jedis(HOST, PORT);
	}
}
