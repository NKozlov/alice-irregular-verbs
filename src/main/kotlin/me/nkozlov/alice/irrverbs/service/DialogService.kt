package me.nkozlov.alice.irrverbs.service

import io.github.nkozlov.kotlin.alice.model.AliceRequest
import io.github.nkozlov.kotlin.alice.model.AliceResponse
import io.github.nkozlov.kotlin.alice.model.ApiVersion
import io.github.nkozlov.kotlin.alice.model.aresponse.Response
import io.github.nkozlov.kotlin.alice.model.aresponse.SessionResponse
import org.springframework.stereotype.Service

@Service
class DialogService {

    fun createResponse(req: AliceRequest): AliceResponse {
        val sessionResponse = SessionResponse(
            sessionId = req.session.sessionId,
            messageId = req.session.messageId,
            userId = req.session.userId
        )
        val response = Response(
            text = "Hello, я навык, ты со мною повторишь неправильные глаголы английского языка",
            endSession = true
        )

        return AliceResponse(response, sessionResponse, ApiVersion.VERSION_1_0)
    }
}
