package com.example.featureflag.change_swagger_example.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@Builder
@Data
@Validated
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "@type", visible = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class WoSwaggerFTFPTIXXX1 {

    @JsonProperty("businessId")
    private String businessId = null;

    @JsonProperty("newProp")
    private String newProp = null;
}
