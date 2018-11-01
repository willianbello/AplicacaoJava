package br.edu.ulbra.election.candidate.model;

import javax.persistence.*;

@Entity
@Table (name="Candidate")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long number;

    @Column(unique = true, nullable = false)
    private Long election_id;

    @Column(unique = true, nullable = false)
    private Long party_id;

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
