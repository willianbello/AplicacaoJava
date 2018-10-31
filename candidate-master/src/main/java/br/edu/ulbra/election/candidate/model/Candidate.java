package br.edu.ulbra.election.candidate.model;

import br.edu.ulbra.election.candidate.output.v1.PartyOutput;

import javax.persistence.*;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private Long numberElection;

    @Column(nullable = false)
    private Long electionId;

    @Column(nullable = false)
    private Long partyOutput;

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

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

    public Long getElectionId() { return electionId; }

    public void setElectionId(Long electionId) {
        this.electionId = electionId;
    }

    public Long getPartyOutput() { return partyOutput; }

    public void setPartyOutput(Long partyOutput) { this.partyOutput = partyOutput; }
}
