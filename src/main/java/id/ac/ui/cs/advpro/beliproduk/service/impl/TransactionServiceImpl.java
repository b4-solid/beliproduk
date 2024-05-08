package id.ac.ui.cs.advpro.beliproduk.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import id.ac.ui.cs.advpro.beliproduk.models.TransactionModel;
import id.ac.ui.cs.advpro.beliproduk.repository.TransactionRepository;
import id.ac.ui.cs.advpro.beliproduk.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{

    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    //C(reate)
    @Override
    public TransactionModel addTransaction(TransactionModel transaction) {
        return repository.save(transaction);
    };

    //R(ead)
    @Override
    public List<TransactionModel> findAllTransaction() {
        return repository.findAll();
    };

    @Override
    public Optional<TransactionModel> findById(Long id) {
        return repository.findById(id);
    };

    //U(pdate)
    @Override
    public TransactionModel updateTransaction(TransactionModel transaction) {
        return repository.save(transaction);
    };

    //D(elete)
    public void deleteTransaction(Long id) {
        repository.deleteById(id);
    };
}
