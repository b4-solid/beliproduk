package id.ac.ui.cs.advpro.beliproduk.service.impl;
import id.ac.ui.cs.advpro.beliproduk.models.TransactionModel;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TransactionServiceImplTest {

    @Autowired
    private TransactionServiceImpl transactionService;

    @BeforeEach
    public void setUp() {
        TransactionModel transaction = new TransactionModel(1, "Alice", 1, new Date(), 100000);
        transactionService.updateTransaction(transaction);
    }

    @Test
    public void testAddTransaction() {
        TransactionModel transaction = new TransactionModel(2, "Bob", 2, new Date(), 200000);
        transactionService.addTransaction(transaction);
        Assertions.assertEquals(2, transactionService.findAllTransaction().size());
        transactionService.deleteTransaction(2L);
    }

    @Test
    public void testFindAllTransaction() {
        Assertions.assertEquals(1, transactionService.findAllTransaction().size());
    }

    @Test
    public void testFindById() {
        Assertions.assertEquals("Alice", transactionService.findById(1L).get().getUsername());
    }

    @Test
    public void testFindByUsername() {
        Assertions.assertEquals(1, transactionService.findByUsername("Alice").size());
    }

    @Test
    public void testUpdateTransaction() {
        TransactionModel transaction = transactionService.findById(1L).get();
        transaction.setTotalAmount(300000);
        transactionService.updateTransaction(transaction);
        Assertions.assertEquals(300000, transactionService.findById(1L).get().getTotalAmount());
    }
}