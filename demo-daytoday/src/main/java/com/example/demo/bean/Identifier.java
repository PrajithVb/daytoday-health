
package com.example.demo.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "use",
    "type",
    "system",
    "value",
    "period",
    "assigner"
})
@Data
public class Identifier {

    @JsonProperty("use")
    public String use;
    @JsonProperty("type")
    public Type type;
    @JsonProperty("system")
    public String system;
    @JsonProperty("value")
    public String value;
    @JsonProperty("period")
    public Period period;
    @JsonProperty("assigner")
    public Assigner assigner;

}
