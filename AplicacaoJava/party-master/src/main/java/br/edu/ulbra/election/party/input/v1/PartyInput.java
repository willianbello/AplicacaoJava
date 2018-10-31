package br.edu.ulbra.election.party.input.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Party Input Information")
public class PartyInput {

    @ApiModelProperty(example = "PJ", notes = "Party Code")
    private String code;
    @ApiModelProperty(example = "Party of Java", notes = "Party Name")
    private String name;
    @ApiModelProperty(example = "77", notes = "Party Number")
    private Integer number;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
