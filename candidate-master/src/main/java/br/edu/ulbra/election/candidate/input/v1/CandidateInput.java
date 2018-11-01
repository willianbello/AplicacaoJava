package br.edu.ulbra.election.candidate.input.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Candidate Input Information")
public class CandidateInput {

    @ApiModelProperty(example = "1", notes = "Candidate Party ID")
    private Long id;
    @ApiModelProperty(example = "John Doe", notes = "Candidate name")
    private String name;
    @ApiModelProperty(example = "5", notes = "Candidate Party ID")
    private Long party_id;
    @ApiModelProperty(example = "97654", notes = "Candidate Election Number")
    private Long number;
    @ApiModelProperty(example = "3", notes = "Candidate Election Id")
    private Long election_id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParty_id() {
        return party_id;
    }

    public void setParty_id(Long party_id) {
        this.party_id = party_id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getElection_id() {
        return election_id;
    }

    public void setElection_id(Long election_id) {
        this.election_id = election_id;
    }
}
