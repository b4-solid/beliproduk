package id.ac.ui.cs.advpro.beliproduk.service.impl;
import id.ac.ui.cs.advpro.beliproduk.models.TransactionModel;
import id.ac.ui.cs.advpro.beliproduk.repository.TransactionRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TransactionServiceImplTest {
    @InjectMocks
    private TransactionServiceImpl service;

    @Mock
    private TransactionRepository repository;

    private TransactionModel transaction1;
    private TransactionModel transaction2;

    @BeforeEach
    public void setUp() {
        transaction1 = new TransactionModel();
        transaction1.setId(1);
        transaction1.setTransactionDate(new Date());
        transaction1.setUsername("username1");

        transaction2 = new TransactionModel();
        transaction2.setId(2);
        transaction2.setTransactionDate(new Date());
        transaction2.setUsername("username2");
    }

    @Test
    public void testFindAll() {
        when(repository.findAll()).thenReturn(Arrays.asList(transaction1, transaction1));
        List<TransactionModel> allRequests = service.findAllTransaction();

        assertEquals(2, allRequests.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        when(repository.findById(1L)).thenReturn(Optional.of(transaction1));
        Optional<TransactionModel> found = service.findById(1L);

        assertEquals(transaction1, found.get());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testAddTransaction() {
        when(repository.save(transaction1)).thenReturn(transaction1);
        TransactionModel saved = service.addTransaction(transaction1);

        assertEquals(transaction1, saved);
        verify(repository, times(1)).save(transaction1);
    }

    @Test
    public void testUpdateTransaction() {
        when(repository.save(transaction1)).thenReturn(transaction1);
        TransactionModel updated = service.updateTransaction(transaction1);

        assertEquals(transaction1, updated);
        verify(repository, times(1)).save(transaction1);
    }

    @Test
    public void testFindByUsername() {
        when(repository.findByUsername("username1")).thenReturn(Arrays.asList(transaction1));
        List<TransactionModel> found = service.findByUsername("username1");

        assertEquals(1, found.size());
        assertEquals(transaction1, found.get(0));
        verify(repository, times(1)).findByUsername("username1");
    }
}