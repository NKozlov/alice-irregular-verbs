package me.nkozlov.alice.irrverbs

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@EnableConfigurationProperties(RoutingConfiguration::class)
class AliceIrregularVerbsApplication

fun main(args: Array<String>) {
    runApplication<AliceIrregularVerbsApplication>(*args)
}
