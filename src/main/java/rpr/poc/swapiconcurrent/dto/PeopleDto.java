package rpr.poc.swapiconcurrent.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

/**
 * The DTO for People response from Star Wars API.
 */
@JsonDeserialize(builder = PeopleDto.PeopleDtoBuilder.class)
public class PeopleDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("height")
    private Integer height;

    @JsonProperty("mass")
    private Integer mass;

    /**
     * Support to Jackson deserialization.
     */
    @JsonPOJOBuilder(withPrefix = "")
    public static final class PeopleDtoBuilder {
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(final Integer height) {
        this.height = height;
    }

    public Integer getMass() {
        return mass;
    }

    public void setMass(final Integer mass) {
        this.mass = mass;
    }
}
