package rpr.poc.swapiconcurrent.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

/**
 * The People Response VO
 */
@ApiModel("PersonResponse")
public class PeopleVo {

    private PeopleVo(final Builder builder) {
        this.name = builder.name;
        this.height = builder.height;
        this.mass = builder.mass;
    }

    @ApiParam(value = "Character Name")
    private String name;

    @ApiParam(value = "Height in cm")
    private Integer height;

    @ApiParam(value = "Mass in Kg")
    private Integer mass;

    @Override
    public String toString() {
        return "PeopleVo={name=['" + name + "'], height=[" + height + "], mass=[" + mass + "]}";
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

    /**
     * Inner class to implement Builder pattern.
     */
    public static final class Builder {
        private String name;
        private Integer height;
        private Integer mass;

        public Builder() {
        }

        public Builder withName(final String name) {
            this.name = name;
            return this;
        }

        public Builder withHeight(final Integer height) {
            this.height = height;
            return this;
        }

        public Builder withMass(final Integer mass) {
            this.mass = mass;
            return this;
        }

        public PeopleVo build() {
            return new PeopleVo(this);
        }
    }
}
