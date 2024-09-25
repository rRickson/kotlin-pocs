package com.github.rrickson.kotlinpocs.config

import com.github.benmanes.caffeine.cache.Caffeine
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.caffeine.CaffeineCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit


@EnableCaching
@Configuration
open class CaffeineConfig {


     fun caffeineBuilder():Caffeine<Any,Any>{
        return Caffeine.newBuilder()
            .expireAfterWrite(60, TimeUnit.MINUTES)
    }

    @Bean
    fun cacheManager(): CacheManager {
        val caffeineCacheManager = CaffeineCacheManager()
        caffeineCacheManager.setCaffeine(caffeineBuilder())
        return caffeineCacheManager
    }
}