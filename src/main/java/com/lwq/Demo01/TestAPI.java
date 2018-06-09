package com.lwq.Demo01;

import java.util.Set;

import redis.clients.jedis.Jedis;

public class TestAPI {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.61.128",6379);
//		jedis.flushAll();
		jedis.set("k1", "v1");
		System.err.println(jedis.get("k1"));
		
		Set<String> sets = jedis.keys("*");
		System.out.println(sets.size());
	}
}
