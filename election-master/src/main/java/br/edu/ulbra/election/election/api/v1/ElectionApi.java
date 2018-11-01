package br.edu.ulbra.election.election.api.v1;

import br.edu.ulbra.election.election.input.v1.ElectionInput;
import br.edu.ulbra.election.election.output.v1.ElectionOutput;
import br.edu.ulbra.election.election.output.v1.GenericOutput;
import br.edu.ulbra.election.election.service.ElectionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/election")
public class ElectionApi {

    private final ElectionService electionService;

    @Autowired
    public ElectionApi(ElectionService electionService){ this.electionService = electionService;}

    @GetMapping("/")
    @ApiOperation(value = "Get election List")
    public List<ElectionOutput> getAll(){
        return electionService.getAll();
        //return new ArrayList<>();
    }

    @GetMapping("/{year}")
    @ApiOperation(value = "Get election List by year")
    public ElectionOutput getByYear(@PathVariable Integer year){
        return electionService.getByYear(year);
        //return new ArrayList<>();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get election by Id")
    public ElectionOutput getById(@PathVariable Long id){
        return electionService.getById(id);
        //return new ElectionOutput();
    }

    @PutMapping("/")
    @ApiOperation(value = "Create new election")
    public ElectionOutput create(@RequestBody ElectionInput electionInput){
        return electionService.create(electionInput);
        //return new ElectionOutput();
    }

    @PostMapping("/{id}")
    @ApiOperation(value = "Update election")
    public ElectionOutput update(@PathVariable Long id, @RequestBody ElectionInput electionInput){
        return electionService.update(id, electionInput);
        //return new ElectionOutput();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete election")
    public GenericOutput delete(@PathVariable Long id){
        return electionService.delete(id);
        //return new GenericOutput("OK");
    }
}
