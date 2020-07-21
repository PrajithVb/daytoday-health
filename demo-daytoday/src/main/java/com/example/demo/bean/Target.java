
package com.example.demo.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "reference",
    "display"
})
@Data
public class Target {

    @JsonProperty("reference")
    public String reference;
    @JsonProperty("display")
    public String display;

}
