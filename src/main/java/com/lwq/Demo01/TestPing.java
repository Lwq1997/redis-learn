package com.lwq.Demo01;
import redis.clients.jedis.Jedis;

public class TestPing {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("192.168.61.128",6379);
		System.out.println(jedis.ping());
	}

}
