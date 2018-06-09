package com.lwq.Demo01;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTrans {
	public static void main(String[] args) throws InterruptedException {
		TestTrans testTrans = new TestTrans();
		boolean res = testTrans.testMethod();
		System.err.println(res);
	}
	public static boolean testMethod() throws InterruptedException {
		Jedis jedis = new Jedis("192.168.61.128",6379);
		int balance;
		int debt;
		int amtToSubtract = 10; 
		
		jedis.watch("balance");
		Thread.sleep(7000);
		balance = Integer.parseInt(jedis.get("balance"));
		if(balance<amtToSubtract) {
			jedis.unwatch();
			System.err.println("modify");
			return false;
		}else {
			System.err.println("transation***");
			Transaction transaction = jedis.multi();
			transaction.decrBy("balance", amtToSubtract);
			transaction.incrBy("debt", amtToSubtract);
			transaction.exec();
			balance = Integer.parseInt(jedis.get("balance"));
			debt = Integer.parseInt(jedis.get("debt"));
			System.out.println(balance+"*************");
			System.out.println(debt+"*************");
			return true;
		}
	}
}


















