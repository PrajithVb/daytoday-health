
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
    "identifier",
    "name",
    "telecom",
    "gender",
    "birthDate",
    "address",
    "active",
    "link",
    "deptId"
})
@Data
public class PersonDetails {

    @JsonProperty("resourceType")
    public String resourceType;
    @JsonProperty("id")
    public String id;
    @JsonProperty("text")
    public Text text;
    @JsonProperty("identifier")
    public List<Identifier> identifier = null;
    @JsonProperty("name")
    public List<Name> name = null;
    @JsonProperty("telecom")
    public List<Telecom> telecom = null;
    @JsonProperty("gender")
    public String gender;
    @JsonProperty("birthDate")
    public String birthDate;
    @JsonProperty("address")
    public List<Address> address = null;
    @JsonProperty("active")
    public Boolean active;
    @JsonProperty("link")
    public List<Link> link = null;
    public String deptId;

}
