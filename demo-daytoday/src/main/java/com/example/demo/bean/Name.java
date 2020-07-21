
package com.example.demo.bean;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "use",
    "family",
    "given"
})
@Data
public class Name {

    @JsonProperty("use")
    public String use;
    @JsonProperty("family")
    public String family;
    @JsonProperty("given")
    public List<String> given = null;

}
