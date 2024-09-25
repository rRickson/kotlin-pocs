package com.github.rrickson.kotlinpocs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@SpringBootApplication
class Application

fun main(args:Array<String>) {
    runApplication<Application>(*args)
}