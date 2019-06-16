package io.github.nkozlov.kotlin.alice.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import io.github.nkozlov.kotlin.alice.model.arequest.Meta
import io.github.nkozlov.kotlin.alice.model.arequest.Request
import io.github.nkozlov.kotlin.alice.model.arequest.SessionRequest

/**
 * See official Y.doc: [https://tech.yandex.ru/dialogs/alice/doc/protocol-docpage/]
 */

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class AliceRequest(
    val meta: Meta,
    val request: Request,
    val session: SessionRequest,
    val version: ApiVersion
)
