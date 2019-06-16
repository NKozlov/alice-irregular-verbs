package io.github.nkozlov.kotlin.alice.model.aresponse

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class SessionResponse(
    @JsonProperty("message_id") val messageId: Long,
    @JsonProperty("session_id") val sessionId: String,
    @JsonProperty("user_id") val userId: String
)
