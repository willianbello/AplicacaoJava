package br.edu.ulbra.election.election.service;

import br.edu.ulbra.election.election.exception.GenericOutputException;
import br.edu.ulbra.election.election.input.v1.ElectionInput;
import br.edu.ulbra.election.election.model.Election;
import br.edu.ulbra.election.election.output.v1.ElectionOutput;
import br.edu.ulbra.election.election.output.v1.GenericOutput;
import br.edu.ulbra.election.election.repository.ElectionRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class ElectionService {

    private final ElectionRepository electionRepository;

    private final ModelMapper modelMapper;

    private static final String MESSAGE_INVALID_ID = "Invalid id";
    private static final String MESSAGE_ELECTION_NOT_FOUND = "Election not found";

    @Autowired
    public ElectionService(ElectionRepository electionRepository, ModelMapper modelMapper){

        this.electionRepository = electionRepository;
        this.modelMapper = modelMapper;

    }

    public List<ElectionOutput> getAll(){
        Type electionOutputListType = new TypeToken<List<ElectionOutput>>(){}.getType();
        return modelMapper.map(electionRepository.findAll(), electionOutputListType);
    }

    public ElectionOutput create(ElectionInput electionInput) {
        validateInput(electionInput, false);
        Election election = modelMapper.map(electionInput, Election.class);
        election = electionRepository.save(election);
        return modelMapper.map(election, ElectionOutput.class);
    }

    public ElectionOutput getByYear(Integer year){
        if (year == null){
            throw new GenericOutputException(MESSAGE_ELECTION_NOT_FOUND);
        }

        Election election = electionRepository.findByYear(year).orElse(null);

        if (election == null){
            throw new GenericOutputException(MESSAGE_ELECTION_NOT_FOUND);
        }

        return modelMapper.map(election, ElectionOutput.class);
    }

    public ElectionOutput getById(Long id){
        if (id == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }

        Election election = electionRepository.findById(id).orElse(null);
        if (election == null){
            throw new GenericOutputException(MESSAGE_ELECTION_NOT_FOUND);
        }

        return modelMapper.map(election, ElectionOutput.class);
    }

    public ElectionOutput update(Long id, ElectionInput electionInput) {
        if (id == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }
        validateInput(electionInput, true);

        Election election = electionRepository.findById(id).orElse(null);
        if (election == null){
            throw new GenericOutputException(MESSAGE_ELECTION_NOT_FOUND);
        }

        try {
            election.setDescription(electionInput.getDescription());
            election.setId(electionInput.getId());
            election.setStateCode(electionInput.getStateCode());
            election.setYear(electionInput.getYear());
        }catch (Exception e){
            System.out.println("Erro ao setar valores");
        }

        election = electionRepository.save(election);
        return modelMapper.map(election, ElectionOutput.class);
    }

    public GenericOutput delete(Long id) {
        if (id == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }

        Election election = electionRepository.findById(id).orElse(null);
        if (election == null){
            throw new GenericOutputException(MESSAGE_ELECTION_NOT_FOUND);
        }

        electionRepository.delete(election);

        return new GenericOutput("Election deleted");
    }

    private void validateInput(ElectionInput electionInput, boolean isUpdate){
        //if (StringUtils.isBlank(voterInput.getEmail())){
        //    throw new GenericOutputException("Invalid email");
        //}
        //if (StringUtils.isBlank(voterInput.getName())){
        //    throw new GenericOutputException("Invalid name");
        //}

       // } else {
            //if (!isUpdate) {
              //  throw new GenericOutputException("Password doesn't match");
            //}
        //}
    }

}
