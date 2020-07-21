
package com.example.demo.bean;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "use",
    "line",
    "city",
    "state",
    "postalCode"
})
@Data
public class Address {

    @JsonProperty("use")
    public String use;
    @JsonProperty("line")
    public List<String> line = null;
    @JsonProperty("city")
    public String city;
    @JsonProperty("state")
    public String state;
    @JsonProperty("postalCode")
    public String postalCode;

}
