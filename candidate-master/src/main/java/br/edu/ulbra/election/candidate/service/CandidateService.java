package br.edu.ulbra.election.candidate.service;

import br.edu.ulbra.election.candidate.exception.GenericOutputException;
import br.edu.ulbra.election.candidate.input.v1.CandidateInput;
import br.edu.ulbra.election.candidate.model.Candidate;
import br.edu.ulbra.election.candidate.output.v1.CandidateOutput;
import br.edu.ulbra.election.candidate.output.v1.GenericOutput;
import br.edu.ulbra.election.candidate.repository.CandidateRepository;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    private final ModelMapper modelMapper;

    private static final String MESSAGE_INVALID_ID = "Invalid id";
    private static final String MESSAGE_VOTER_NOT_FOUND = "Voter not found";

    @Autowired
    public CandidateService(CandidateRepository candidateRepository, ModelMapper modelMapper){

        this.candidateRepository = candidateRepository;
        this.modelMapper = modelMapper;

    }

    public List<CandidateOutput> getAll(){
        Type voterOutputListType = new TypeToken<List<CandidateOutput>>(){}.getType();
        return modelMapper.map(candidateRepository.findAll(), voterOutputListType);
    }

    public CandidateOutput create(CandidateInput candidateInput) {
        validateInput(candidateInput, false);
        Candidate candidate = modelMapper.map(candidateInput, Candidate.class);
        candidate = candidateRepository.save(candidate);
        return modelMapper.map(candidate, CandidateOutput.class);
    }

    public CandidateOutput getById(Long candidateId){
        if (candidateId == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }

        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        if (candidate == null){
            throw new GenericOutputException(MESSAGE_VOTER_NOT_FOUND);
        }

        return modelMapper.map(candidate, CandidateOutput.class);
    }

    public CandidateOutput update(Long candidateId, CandidateInput candidateInput) {
        if (candidateId == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }
        validateInput(candidateInput, true);

        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        if (candidate == null){
            throw new GenericOutputException(MESSAGE_VOTER_NOT_FOUND);
        }

        //candidate.setEmail(voterInput.getEmail());
        try {
            candidate.setName(candidateInput.getName());
            candidate.setNumber(candidateInput.getNumber());
            candidate.setElection_id(candidateInput.getElection_id());
            candidate.setParty_id(candidateInput.getParty_id());
        }catch (Exception e){
            System.out.println("Erro ao setar valores");
        }

        candidate = candidateRepository.save(candidate);
        return modelMapper.map(candidate, CandidateOutput.class);
    }

    public GenericOutput delete(Long candidateId) {
        if (candidateId == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }

        Candidate candidate = candidateRepository.findById(candidateId).orElse(null);
        if (candidate == null){
            throw new GenericOutputException(MESSAGE_VOTER_NOT_FOUND);
        }

        candidateRepository.delete(candidate);

        return new GenericOutput("Voter deleted");
    }

    private void validateInput(CandidateInput voterInput, boolean isUpdate){
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
