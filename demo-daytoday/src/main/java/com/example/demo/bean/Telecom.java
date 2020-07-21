
package com.example.demo.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "use",
    "system",
    "value"
})
@Data
public class Telecom {

    @JsonProperty("use")
    public String use;
    @JsonProperty("system")
    public String system;
    @JsonProperty("value")
    public String value;

}
