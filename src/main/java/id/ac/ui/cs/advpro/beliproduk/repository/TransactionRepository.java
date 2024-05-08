package id.ac.ui.cs.advpro.beliproduk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import id.ac.ui.cs.advpro.beliproduk.models.TransactionModel;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long>{
}
