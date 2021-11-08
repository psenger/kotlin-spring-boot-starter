package org.cngr.webapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class StartUpApplication {
}

fun main(args: Array<String>) {
    runApplication<StartUpApplication>(*args)
}