package br.edu.ulbra.election.party.service;

import br.edu.ulbra.election.party.exception.GenericOutputException;
import br.edu.ulbra.election.party.input.v1.PartyInput;
import br.edu.ulbra.election.party.model.Party;
import br.edu.ulbra.election.party.output.v1.PartyOutput;
import br.edu.ulbra.election.party.output.v1.GenericOutput;
import br.edu.ulbra.election.party.repository.PartyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class PartyService {

    private final PartyRepository partyRepository;

    private final ModelMapper modelMapper;

    private static final String MESSAGE_INVALID_ID = "Invalid id";
    private static final String MESSAGE_VOTER_NOT_FOUND = "Party not found";

    @Autowired
    public PartyService(PartyRepository partyRepository, ModelMapper modelMapper){

        this.partyRepository = partyRepository;
        this.modelMapper = modelMapper;

    }

    public List<PartyOutput> getAll(){
        Type partyOutputListType = new TypeToken<List<PartyOutput>>(){}.getType();
        return modelMapper.map(partyRepository.findAll(), partyOutputListType);
    }

    public PartyOutput create(PartyInput partyInput) {
        validateInput(partyInput, false);
        Party party = modelMapper.map(partyInput, Party.class);
        party = partyRepository.save(party);
        return modelMapper.map(party, PartyOutput.class);
    }

    public PartyOutput getById(Long id){
        if (id == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }

        Party party = partyRepository.findById(id).orElse(null);
        if (party == null){
            throw new GenericOutputException(MESSAGE_VOTER_NOT_FOUND);
        }

        return modelMapper.map(party, PartyOutput.class);
    }

    public PartyOutput update(Long id, PartyInput partyInput) {
        if (id == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }
        validateInput(partyInput, true);

        Party party = partyRepository.findById(id).orElse(null);
        if (party == null){
            throw new GenericOutputException(MESSAGE_VOTER_NOT_FOUND);
        }

        try {
            party.setName(partyInput.getName());
            party.setNumber(partyInput.getNumber());
            party.setId(partyInput.getId());
            party.setCode(partyInput.getCode());
        }catch (Exception e){
            System.out.println("Erro ao setar valores");
        }

        party = partyRepository.save(party);
        return modelMapper.map(party, PartyOutput.class);
    }

    public GenericOutput delete(Long id) {
        if (id == null){
            throw new GenericOutputException(MESSAGE_INVALID_ID);
        }

        Party party = partyRepository.findById(id).orElse(null);
        if (party == null){
            throw new GenericOutputException(MESSAGE_VOTER_NOT_FOUND);
        }

        partyRepository.delete(party);

        return new GenericOutput("Party deleted");
    }

    private void validateInput(PartyInput partyInput, boolean isUpdate){
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
