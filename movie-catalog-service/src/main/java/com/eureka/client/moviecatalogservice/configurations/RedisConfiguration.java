package com.eureka.client.moviecatalogservice.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfiguration {

  @Bean
  public StringRedisSerializer getRedisSerializer() {
    return new StringRedisSerializer();
  }

  @Bean
  public JedisConnectionFactory jedisCOnnectionFactory() {
    return new JedisConnectionFactory();
  }

  @Bean
  public RedisTemplate<String, Object> getRedisTemplate() {
    final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(jedisCOnnectionFactory());
    redisTemplate.setKeySerializer(getRedisSerializer());

    return redisTemplate;
  }

}
