package id.ac.ui.cs.advpro.beliproduk.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import id.ac.ui.cs.advpro.beliproduk.models.TransactionModel;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {

    @Query("SELECT t FROM TransactionModel t WHERE t.username = :username")
    List<TransactionModel> findByUsername(String username);
}
