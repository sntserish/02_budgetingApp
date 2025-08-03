package es.projects.budgetingApp.controller;

import es.projects.budgetingApp.dto.FundDTO;
import es.projects.budgetingApp.dto.mapper.FundMapper;
import es.projects.budgetingApp.service.FundService;
import es.projects.budgetingApp.model.Fund;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "es02/budgetingApp/v1/users/{userId}/funds")
public class FundController {

    private final FundService fundService;

    @Autowired
    FundMapper fundMapper;

    @Autowired
    public FundController(FundService fundService) {
        this.fundService = fundService;
    }

    @GetMapping(path = "/")
    public List<FundDTO> getFunds(){
        return fundService.getFunds().stream().map(fundMapper::toDTO).collect(Collectors.toList());
    }

    @PostMapping(path = "/")
    public String createFund(@PathVariable("userId") Long userId , @RequestBody Fund fund){
        return fundService.createFund(userId, fund).toString();
    }

    @GetMapping("/{fundId}")
    public FundDTO getFundById(@PathVariable("fundId") Long fundId){
        return fundService.getFundById(fundId).map(fundMapper::toDTO).orElseThrow(NoSuchElementException::new);
    }
}