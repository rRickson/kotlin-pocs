package com.github.rrickson.kotlinpocs.service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.CacheManager
import org.springframework.stereotype.Service


@Service
class UserService {
    val log: org.slf4j.Logger? = LoggerFactory.getLogger(UserService::class.java)

    @Autowired
    private val cacheManager: CacheManager? = null

    fun getUser(userId: Long): String {

        return ""
    }

}