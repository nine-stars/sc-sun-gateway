package com.iyb.ak.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedissionConfig {

	@Autowired
	private RedisProperties redisProperties;

	@Bean
	public RedissonClient redissonClient() {
		Config config = new Config();
		if (redisProperties.getSentinel() != null) {
			//sentinel
			SentinelServersConfig sentinelServersConfig = config.useSentinelServers();
			sentinelServersConfig.setMasterName(redisProperties.getSentinel().getMaster());
			sentinelServersConfig.addSentinelAddress(redisProperties.getSentinel().getNodes().split(","));
			sentinelServersConfig.setDatabase(redisProperties.getDatabase());
			if (redisProperties.getPassword() != null) {
				sentinelServersConfig.setPassword(redisProperties.getPassword());
			}
			sentinelServersConfig.setTimeout(redisProperties.getTimeout());
		} else if (redisProperties.getCluster() != null) {
			//cluster
            ClusterServersConfig clusterServersConfig = config.useClusterServers();
            clusterServersConfig.addNodeAddress((String[]) redisProperties.getCluster().getNodes().toArray());
            clusterServersConfig.setTimeout(redisProperties.getTimeout());
            if(redisProperties.getPassword() != null) {
                clusterServersConfig.setPassword(redisProperties.getPassword());
            }
            clusterServersConfig.setTimeout(redisProperties.getTimeout());
		} else { //single server
			SingleServerConfig singleServerConfig = config.useSingleServer();
			singleServerConfig.setAddress(redisProperties.getHost() + ":" + redisProperties.getPort());
			singleServerConfig.setDatabase(redisProperties.getDatabase());
			if (redisProperties.getPassword() != null) {
				singleServerConfig.setPassword(redisProperties.getPassword());
			}
			singleServerConfig.setTimeout(redisProperties.getTimeout());
		}

		return Redisson.create(config);
	}
}
