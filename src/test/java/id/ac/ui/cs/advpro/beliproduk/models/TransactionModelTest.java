package id.ac.ui.cs.advpro.beliproduk.models;

import org.junit.jupiter.api.Test;

public class TransactionModelTest {
    @Test
    public void testModel() {
        TransactionModel transactionModel = new TransactionModel();
        transactionModel.setId(1);
        transactionModel.setTransactionDate(null);
        transactionModel.setUsername("username");
        transactionModel.setTotalAmount(1000000);
        transactionModel.setStatus("status");
        transactionModel.setVoucherId(1L);

        TransactionModel transactionModel2 = new TransactionModel(1L, "username", 1L, null, 1000000L);

        assert transactionModel.getId() == 1;
        assert transactionModel.getTransactionDate() == null;
        assert transactionModel.getUsername().equals("username");
        assert transactionModel.getTotalAmount() == 1000000;
        assert transactionModel.getStatus().equals("status");
        assert transactionModel.getVoucherId() == 1L;

        assert transactionModel2.getId() == 1;
        assert transactionModel2.getTransactionDate() == null;
        assert transactionModel2.getUsername().equals("username");
        assert transactionModel2.getTotalAmount() == 1000000;
        assert transactionModel2.getVoucherId() == 1L;

    }
}
