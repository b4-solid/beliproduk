package id.ac.ui.cs.advpro.beliproduk.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import id.ac.ui.cs.advpro.beliproduk.models.TransactionModel;
import id.ac.ui.cs.advpro.beliproduk.service.TransactionService;

public class TransactionControllerTest {
    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        TransactionModel transaction1 = new TransactionModel();
        transaction1.setId(1);
        transaction1.setTransactionDate(null);
        transaction1.setUsername("username1");

        TransactionModel transaction2 = new TransactionModel();
        transaction2.setId(2);
        transaction2.setTransactionDate(null);
        transaction2.setUsername("username2");

        when(transactionService.findAllTransaction()).thenReturn(Arrays.asList(transaction1, transaction2));
        when(transactionService.findById(1L)).thenReturn(Optional.of(transaction1));
        when(transactionService.findById(2L)).thenReturn(Optional.of(transaction2));
    }

    @Test
    public void testCreateTransaction() throws InterruptedException, ExecutionException{
        TransactionModel transaction = new TransactionModel();
        transaction.setId(1);
        transaction.setTransactionDate(null);
        transaction.setUsername("username1");

        when(transactionService.addTransaction(transaction)).thenReturn(transaction);

        CompletableFuture<ResponseEntity<TransactionModel>> result = transactionController.createTransaction(transaction);
        ResponseEntity<TransactionModel> response = result.get();

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(transaction, response.getBody());
    }

    @Test
    public void testFindById() throws InterruptedException, ExecutionException{
        CompletableFuture<ResponseEntity<TransactionModel>> result = transactionController.findById(1L);
        ResponseEntity<TransactionModel> response = result.get();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().getId());
    }

    @Test
    public void testFindByIdFailed() throws InterruptedException, ExecutionException{
        CompletableFuture<ResponseEntity<TransactionModel>> result = transactionController.findById(3L);
        ResponseEntity<TransactionModel> response = result.get();

        when(transactionService.findById(3L)).thenReturn(Optional.empty());

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testFindAllTransaction() throws InterruptedException, ExecutionException{
        CompletableFuture<ResponseEntity<List<TransactionModel>>> result = transactionController.findAllTransaction();
        ResponseEntity<List<TransactionModel>> response = result.get();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(2, response.getBody().size());
    }

    @Test
    public void testUpdateTransaction() throws InterruptedException, ExecutionException{
        TransactionModel transaction = new TransactionModel();
        transaction.setId(1);
        transaction.setTransactionDate(null);
        transaction.setUsername("username1");

        when(transactionService.updateTransaction(transaction)).thenReturn(transaction);

        CompletableFuture<ResponseEntity<TransactionModel>> result = transactionController.updateTransaction(1L, transaction);
        ResponseEntity<TransactionModel> response = result.get();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(transaction, response.getBody());
    }

    @Test
    public void testUpdateTransactionFailed() throws InterruptedException, ExecutionException{
        TransactionModel transaction = new TransactionModel();
        transaction.setId(3);
        transaction.setTransactionDate(null);
        transaction.setUsername("username3");

        when(transactionService.updateTransaction(transaction)).thenThrow(new IllegalArgumentException());

        CompletableFuture<ResponseEntity<TransactionModel>> result = transactionController.updateTransaction(3L, transaction);
        ResponseEntity<TransactionModel> response = result.get();

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testFindAllUserTransaction() throws InterruptedException, ExecutionException{
        TransactionModel transaction = new TransactionModel();
        transaction.setId(1);
        transaction.setTransactionDate(null);
        transaction.setUsername("username1");

        when(transactionService.findByUsername("username1")).thenReturn(Arrays.asList(transaction));

        CompletableFuture<ResponseEntity<List<TransactionModel>>> result = transactionController.findAllUserTransaction("username1");
        ResponseEntity<List<TransactionModel>> response = result.get();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }
}
