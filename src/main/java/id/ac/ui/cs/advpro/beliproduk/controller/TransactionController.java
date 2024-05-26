package id.ac.ui.cs.advpro.beliproduk.controller;

import java.util.concurrent.CompletableFuture;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.ac.ui.cs.advpro.beliproduk.models.TransactionModel;
import id.ac.ui.cs.advpro.beliproduk.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    @Async
    public CompletableFuture<ResponseEntity<TransactionModel>> createTransaction(@RequestBody TransactionModel transaction) {
        return CompletableFuture.supplyAsync(() -> {
            transaction.setTransactionDate(new Date());
            TransactionModel savedTransaction = transactionService.addTransaction(transaction);
            return new ResponseEntity<>(savedTransaction, HttpStatus.CREATED);
        });
    }

    @GetMapping("/user/{username}")
    @Async
    public CompletableFuture<ResponseEntity<List<TransactionModel>>> findAllUserTransaction(@PathVariable String username) {
        return CompletableFuture.supplyAsync(() -> {
            return ResponseEntity.ok(transactionService.findByUsername(username));
        });
    }

    @GetMapping("/{transactionId}")
    @Async
    public CompletableFuture<ResponseEntity<TransactionModel>> findById(@PathVariable Long transactionId) {
        return CompletableFuture.supplyAsync(() -> {
            Optional<TransactionModel> request = transactionService.findById(transactionId);
            if (request.isPresent()) {
                return ResponseEntity.ok(request.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        });
    }


    @GetMapping
    @Async
    public CompletableFuture<ResponseEntity<List<TransactionModel>>> findAllTransaction() {
        return CompletableFuture.supplyAsync(() -> {
            return ResponseEntity.ok(transactionService.findAllTransaction());
        });
    }

    @PutMapping("/{transactionId}")
    @Async
    public CompletableFuture<ResponseEntity<TransactionModel>> updateTransaction(@PathVariable long transactionId, @RequestBody TransactionModel updatedTransaction) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                updatedTransaction.setId(transactionId);
                TransactionModel result = transactionService.updateTransaction(updatedTransaction);
                return ResponseEntity.ok(result);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.notFound().build();
            }
        });
    }
}
