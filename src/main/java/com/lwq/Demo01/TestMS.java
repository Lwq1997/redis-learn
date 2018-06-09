package com.lwq.Demo01;

import redis.clients.jedis.Jedis;

public class TestMS {
	public static void main(String[] args) {
		Jedis jedis_M = new Jedis("192.168.61.128",6379);
		Jedis jedis_S = new Jedis("192.168.61.128",6380);
		
		jedis_S.slaveof("192.168.61.128", 6379);
		
		jedis_M.set("class", "0527new");
		System.err.println(jedis_S.get("class"));;
	}
}
