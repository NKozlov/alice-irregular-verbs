package io.github.nkozlov.kotlin.alice.model.arequest

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class Meta(var locale: String? = "ru-RU") {
    @JsonProperty("timezone")
    var timeZone: String? = null
    @JsonProperty("client_id")
    var clientId: String? = null
    var interfaces: UserInterface? = null

}

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserInterface(var screen: Any? = null) {
    @JsonProperty("account_linking")
    var accountLinking: Any? = null
    var payments: Any? = null
}
