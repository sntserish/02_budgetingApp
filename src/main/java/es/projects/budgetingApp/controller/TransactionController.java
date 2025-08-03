package es.projects.budgetingApp.controller;

import es.projects.budgetingApp.dto.TransactionDTO;
import es.projects.budgetingApp.dto.mapper.TransactionMapper;
import es.projects.budgetingApp.model.Transaction;
import es.projects.budgetingApp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "es02/budgetingApp/v1/users/{userId}/funds/{fundId}/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    TransactionMapper transactionMapper;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/")
    public String createTransaction(@PathVariable("userId") Long userId, @PathVariable("fundId") Long fundId, @RequestBody Transaction transaction){
        return transactionService.createTransaction(userId, fundId, transaction).toString();
    }


    @GetMapping(path = "/")
    public List<TransactionDTO> getTransactions(){
        return transactionService.getTransactions().stream().map(transactionMapper::toDTO).collect(Collectors.toList());
    }

    @GetMapping("/{transactionId}")
    public TransactionDTO getTransactionById(@PathVariable("transactionId") Long transactionId){
        return transactionService.getTransactionById(transactionId).map(transactionMapper::toDTO).orElseThrow(NoSuchElementException::new);
    }
}
