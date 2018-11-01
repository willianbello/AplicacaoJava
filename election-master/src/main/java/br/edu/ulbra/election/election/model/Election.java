package br.edu.ulbra.election.election.model;

import javax.persistence.*;

@Entity
@Table (name="Election")
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private String state_code;

    @Column(unique = true)
    private String description;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Integer getYear() { return year; }

    public void setYear(Integer year) { this.year = year; }

    public String getStateCode() { return state_code; }

    public void setStateCode(String state_code) { this.state_code = state_code; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}

/*  id integer identity primary key,
  year integer(4) not null,
  state_code varchar(5) not null,
  description varchar(255) not null
    */
