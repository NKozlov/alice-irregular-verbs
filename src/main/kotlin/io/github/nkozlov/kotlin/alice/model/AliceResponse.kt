package io.github.nkozlov.kotlin.alice.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import io.github.nkozlov.kotlin.alice.model.aresponse.Response
import io.github.nkozlov.kotlin.alice.model.aresponse.SessionResponse

/**
 * See official Y.doc: [https://tech.yandex.ru/dialogs/alice/doc/protocol-docpage/]
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AliceResponse(
    val response: Response,
    val session: SessionResponse,
    val version: ApiVersion
)






