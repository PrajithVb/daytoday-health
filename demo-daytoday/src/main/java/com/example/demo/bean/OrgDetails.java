
package com.example.demo.bean;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "resourceType",
    "id",
    "text",
    "name",
    "alias",
    "telecom",
    "address",
    "endpoint"
})
@Data
public class OrgDetails {

    @JsonProperty("resourceType")
    public String resourceType;
    @JsonProperty("id")
    public String id;
    @JsonProperty("text")
    public Text text;
    @JsonProperty("name")
    public String name;
    @JsonProperty("alias")
    public List<String> alias = null;
    @JsonProperty("telecom")
    public List<Telecom> telecom = null;
    @JsonProperty("address")
    public List<Address> address = null;
    @JsonProperty("endpoint")
    public List<Endpoint> endpoint = null;

}
