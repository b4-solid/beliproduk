package id.ac.ui.cs.advpro.beliproduk.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;

import id.ac.ui.cs.advpro.beliproduk.models.TransactionModel;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceImplTest {

    @Mock
    TransactionServiceImpl transactionService;

    TransactionModel transaction;

    @BeforeEach
    void setUp() {
        this.transaction = new TransactionModel();
        this.transaction.setId(1);
        this.transaction.setTransactionDate(Calendar.getInstance().getTime());
    }

    @Test
    void testCreateReturnsProperly() {
        assertEquals(transaction, transactionService.addTransaction(transaction));
    }
}
