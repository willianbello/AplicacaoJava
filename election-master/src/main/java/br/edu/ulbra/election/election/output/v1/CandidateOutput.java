package br.edu.ulbra.election.election.output.v1;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Election Output Information")
public class CandidateOutput {

    @ApiModelProperty(example = "1", notes = "Election Unique Identification")
    private Long id;
    @ApiModelProperty(example = "John Doe", notes = "Election name")
    private String name;
    @ApiModelProperty(example = "77654", notes = "Election Election Number")
    private Long numberElection;
    @ApiModelProperty(notes = "Election Party Data")
    private PartyOutput partyOutput;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberElection() {
        return numberElection;
    }

    public void setNumberElection(Long numberElection) {
        this.numberElection = numberElection;
    }

    public PartyOutput getPartyOutput() {
        return partyOutput;
    }

    public void setPartyOutput(PartyOutput partyOutput) {
        this.partyOutput = partyOutput;
    }
}
