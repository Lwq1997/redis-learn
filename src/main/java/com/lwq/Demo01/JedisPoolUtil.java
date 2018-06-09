package com.lwq.Demo01;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {

	private static volatile JedisPool jedisPool = null;
	
	private JedisPoolUtil() {};
	
	public static JedisPool getJedisPoolInstance() {
		if(null == jedisPool) {
			synchronized (JedisPoolUtil.class) {
				if(null == jedisPool) {
					JedisPoolConfig poolconfig = new JedisPoolConfig();
					poolconfig.setMaxIdle(32);
					poolconfig.setTestOnBorrow(true);
					jedisPool = new JedisPool(poolconfig,"192.168.61.128",6379);
				}
			}
		}
		return jedisPool;
	}
	
	public static void release(JedisPool jedisPool,Jedis jedis) {
		if(null != jedis) {
			jedisPool.returnResourceObject(jedis);
		}
	}
}
