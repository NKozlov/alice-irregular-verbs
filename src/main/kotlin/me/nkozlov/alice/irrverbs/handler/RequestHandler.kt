package me.nkozlov.alice.irrverbs.handler

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.github.nkozlov.kotlin.alice.model.AliceRequest
import me.nkozlov.alice.irrverbs.service.DialogService
import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

private val logger = KotlinLogging.logger {}

@Component
class RequestHandler(private val dialogService: DialogService) {
    data class Content(val hello: String, val value2: String?)

    fun logRequest(req: ServerRequest): Mono<ServerResponse> {
        logger.debug("Call fun logRequest(req: ServerRequest = $req)")
        val contentMono = req.bodyToMono(String::class.java)
            .onErrorResume {
                Mono.error(it)
            }
//            .switchIfEmpty(Mono.just(Content("Default", "Lol2")))
            .map {
                logger.debug("Request body: $it")
                val tmpVal = it.toString()
                it
            }


        return ServerResponse.ok().body(
//            Mono.just("Service (POST) Response"), String::class.java
//            contentMono, Content::class.java
            contentMono, String::class.java
        )
    }

    fun handleRequest(req: ServerRequest): Mono<ServerResponse> {
        logger.debug("Call fun handleRequest(req: ServerRequest = $req)")
        val requestContent = req.bodyToMono(String::class.java)
            .onErrorResume { Mono.error(it) }
//            .switchIfEmpty(Mono.just())
            .map { reqJson ->
                logger.debug("Request body (JSON): ${reqJson.lines().map { line -> line.trim() }
                    .joinToString(separator = "")}")
                val aliceRequest = Jackson.mapper.readValue(reqJson, AliceRequest::class.java)
                logger.debug("AliceRequest entity: $aliceRequest")

                val aliceResponse = dialogService.createResponse(aliceRequest)

                logger.debug("AliceResponse entity: $aliceResponse")
                val resJson = Jackson.mapper.writeValueAsString(aliceResponse)
                logger.debug("Response body (JSON): $resJson")

                resJson
            }
        return ServerResponse.ok().body(
            requestContent, String::class.java
        )
    }
}

object Jackson {
    val mapper = jacksonObjectMapper()
}
