package io.github.nkozlov.kotlin.alice.model.arequest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Request(var command: String? = "") {
    @JsonProperty("original_utterance")
    var originalUtterance: String = ""
    var type: TypeRequest = TypeRequest.SIMPLE_UTTERANCE
}

enum class TypeRequest {
    @JsonProperty("SimpleUtterance")
    SIMPLE_UTTERANCE,
    @JsonProperty("ButtonPressed")
    BUTTON_PRESSED
}
