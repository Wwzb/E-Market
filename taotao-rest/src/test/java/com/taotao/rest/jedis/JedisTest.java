package com.taotao.rest.jedis;

import java.io.IOException;
import java.util.HashSet;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class JedisTest {
	@Test
	public void testJedisSingle() {
		//创建一个jedis的对象。
		Jedis jedis = new Jedis("192.168.18.136", 6379);
		//调用jedis对象的方法，方法名称和redis的命令一致。
		jedis.set("key1", "jedis test");
		String string = jedis.get("key1");
		System.out.println(string);
		//关闭jedis。
		jedis.close();
	}

	@Test
	public void testJedisCluster() throws IOException {
		HashSet<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.18.136", 7001));
		nodes.add(new HostAndPort("192.168.18.136", 7002));
		nodes.add(new HostAndPort("192.168.18.136", 7003));
		nodes.add(new HostAndPort("192.168.18.136", 7004));
		nodes.add(new HostAndPort("192.168.18.136", 7005));
		nodes.add(new HostAndPort("192.168.18.136", 7006));
		
		JedisCluster cluster = new JedisCluster(nodes);
		
		cluster.set("key1", "1000");
		String string = cluster.get("key1");
		System.out.println(string);
		
		cluster.close();
	}


}
