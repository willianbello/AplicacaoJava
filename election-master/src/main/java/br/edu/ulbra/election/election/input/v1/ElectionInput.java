package br.edu.ulbra.election.election.input.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Election Input Information")
public class ElectionInput {

    @ApiModelProperty(example = "1", notes = "Election Id")
    private Long id;
    @ApiModelProperty(example = "2018", notes = "Election Year")
    private Integer year;
    @ApiModelProperty(example = "RS", notes = "State Code")
    private String state_code;
    @ApiModelProperty(example = "Senator", notes = "Election Description")
    private String description;

    public void setId(Long id) { this.id = id; }

    public Long getId() { return id; }

    public void setYear(Integer year) { this.year = year; }

    public Integer getYear() {
        return year;
    }

    public void setStateCode(String stateCode) {
        this.state_code = stateCode;
    }

    public String getStateCode() {
        return state_code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
