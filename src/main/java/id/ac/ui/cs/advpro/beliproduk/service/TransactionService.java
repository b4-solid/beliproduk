package id.ac.ui.cs.advpro.beliproduk.service;

import java.util.List;
import java.util.Optional;

import id.ac.ui.cs.advpro.beliproduk.models.TransactionModel;

public interface TransactionService {

    //C(reate)
    TransactionModel addTransaction(TransactionModel transaction);

    //R(ead)
    List<TransactionModel> findAllTransaction();
    List<TransactionModel> findByUsername(String username);
    Optional<TransactionModel> findById(Long id);

    //U(pdate)
    TransactionModel updateTransaction(TransactionModel transaction);
}