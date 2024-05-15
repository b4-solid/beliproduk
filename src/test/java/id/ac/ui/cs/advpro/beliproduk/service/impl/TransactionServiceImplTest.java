package id.ac.ui.cs.advpro.beliproduk.service.impl;
import id.ac.ui.cs.advpro.beliproduk.models.TransactionModel;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TransactionServiceImplTest {

    @Autowired
    private TransactionServiceImpl transactionService;

    @BeforeEach
    public void setUp() {
        TransactionModel transaction = new TransactionModel(1, 1, new Date(), 100000);
        transactionService.addTransaction(transaction);
        System.out.println("yeah %s".formatted(transaction));
    }

    @AfterEach
    public void tearDown() {
        for (TransactionModel transaction : transactionService.findAllTransaction()) {
            transactionService.deleteTransaction(transaction.getId());
        }
    }

    @Test
    public void testFindAllTransactions() {
        Assertions.assertEquals(1, transactionService.findAllTransaction().size());
    }

    @Test
    public void testUpdateTransaction() {
        TransactionModel transaction = transactionService.findById(1L).get();
        transaction.setTotalAmount(200000);

        transactionService.updateTransaction(transaction);

        Assertions.assertEquals(200000, transactionService.findById(1L).get().getTotalAmount());
    }

    @Test
    public void testAddTransaction() {
        TransactionModel transaction = new TransactionModel(2, 2, new Date(), 200000);
        transactionService.addTransaction(transaction);

        Assertions.assertEquals(2, transactionService.findAllTransaction().size());
    }
}