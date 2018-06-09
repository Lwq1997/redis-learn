package com.lwq.Demo02;

import redis.clients.jedis.Jedis;

public class JedisDemo01 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.61.128",6379);
        jedis.set("hello","world");
        String value = jedis.get("hello");
        System.out.println(value);
        System.out.println(jedis.incr("count"));
        jedis.hset("myhash","k1","v1");
        System.out.println(jedis.hget("myhash","k1"));

        jedis.rpush("mylist","1");
        jedis.rpush("mylist","2");
        jedis.rpush("mylist","3");

        System.out.println(jedis.lrange("mylist",0,-1));
    }
}
