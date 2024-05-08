package id.ac.ui.cs.advpro.beliproduk.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.advpro.beliproduk.models.TransactionModel;
import id.ac.ui.cs.advpro.beliproduk.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionModel addTransaction(@RequestBody TransactionModel transaction) {
        return transactionService.addTransaction(transaction);
    }
}
