package br.edu.ulbra.election.party.api.v1;

import br.edu.ulbra.election.party.input.v1.PartyInput;
import br.edu.ulbra.election.party.output.v1.GenericOutput;
import br.edu.ulbra.election.party.output.v1.PartyOutput;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/party")
public class PartyApi {

    @GetMapping("/")
    @ApiOperation(value = "Get parties List")
    public List<PartyOutput> getAll(){
        return new ArrayList<>();
    }

    @GetMapping("/{partyId}")
    @ApiOperation(value = "Get party by Id")
    public PartyOutput getById(@PathVariable Long partyId){
        return new PartyOutput();
    }

    @PutMapping("/")
    @ApiOperation(value = "Create new party")
    public PartyOutput create(@RequestBody PartyInput partyInput){
        return new PartyOutput();
    }

    @PostMapping("/{partyId}")
    @ApiOperation(value = "Update party")
    public PartyOutput update(@PathVariable Long partyId, @RequestBody PartyInput partyInput){
        return new PartyOutput();
    }

    @DeleteMapping("/{partyId}")
    @ApiOperation(value = "Delete party")
    public GenericOutput delete(@PathVariable Long partyId){
        return new GenericOutput("OK");
    }
}
