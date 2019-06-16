package me.nkozlov.alice.irrverbs.config

import me.nkozlov.alice.irrverbs.handler.RequestHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Mono

@Configuration
class RoutingConfiguration(private val requestHandler: RequestHandler) {

    @Bean
    fun apiRouter(): RouterFunction<ServerResponse> = router {

        ("/alice-skill").nest {
            GET("/info") { request ->
                ok().body(
                    Mono.just("It's Alica's skill 'Irregular verbs'. Developed by Nikita Kozlov."), String::class.java
                )
            }
            POST("/") { serverReq -> requestHandler.handleRequest(serverReq) }
        }

        GET("/test") { request -> ok().body(Mono.just("Hello, man!"), String::class.java) }
        GET("/") { request -> ok().body(Mono.just("Hello, man!"), String::class.java) }
    }

}
