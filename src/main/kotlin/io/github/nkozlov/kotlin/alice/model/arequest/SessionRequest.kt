package io.github.nkozlov.kotlin.alice.model.arequest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty


@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class SessionRequest(
    val new: Boolean,
    @JsonProperty("message_id") val messageId: Long,
    @JsonProperty("session_id") val sessionId: String,
    @JsonProperty("skill_id") val skillId: String,
    @JsonProperty("user_id") val userId: String
)
