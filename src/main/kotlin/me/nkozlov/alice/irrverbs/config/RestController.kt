package me.nkozlov.alice.irrverbs.config

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping(value = ["/test"])
class RestControllerAPIs {

    @GetMapping("/1")
    fun getCustomer(): Mono<String> {
        return Mono.just("Hello, man!")
    }
}
