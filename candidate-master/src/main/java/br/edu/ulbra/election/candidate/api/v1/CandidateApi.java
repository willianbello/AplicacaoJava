package br.edu.ulbra.election.candidate.api.v1;

import br.edu.ulbra.election.candidate.input.v1.CandidateInput;
import br.edu.ulbra.election.candidate.output.v1.CandidateOutput;
import br.edu.ulbra.election.candidate.output.v1.GenericOutput;
import br.edu.ulbra.election.candidate.service.CandidateService;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/candidate")
public class CandidateApi {

    private final CandidateService candidateService;

    @Autowired
    public CandidateApi(CandidateService candidateService){ this.candidateService = candidateService; }

    @GetMapping("/")
    @ApiOperation(value = "Get candidates List")
    public List<CandidateOutput> getAll(){
        return candidateService.getAll();
        //return new ArrayList<>();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get candidate by Id")
    public CandidateOutput getById(@PathVariable Long id){
        return candidateService.getById(id);
        //return new CandidateOutput();
    }

    @PutMapping("/")
    @ApiOperation(value = "Create new candidate")
    public CandidateOutput create(@RequestBody CandidateInput candidateInput){
        return candidateService.create(candidateInput);
        //return new CandidateOutput();
    }

    @PostMapping("/{id}")
    @ApiOperation(value = "Update candidate")
    public CandidateOutput update(@PathVariable Long id, @RequestBody CandidateInput candidateInput){
        return candidateService.update(id, candidateInput);
        //return new CandidateOutput();
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete candidate")
    public GenericOutput delete(@PathVariable Long id){
        return candidateService.delete(id);
        //return new GenericOutput("OK");
    }
}
