package id.ac.ui.cs.advpro.beliproduk.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class TransactionModel {

    @Id // tambahin ini kalo PK
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    @Setter
    @Getter
    private long id;

    @Column(name = "voucher_id")
    @Setter
    @Getter
    private long voucherId;

    @Column(name = "transaction_date")
    @NotNull
    @Setter
    @Getter
    private Date transactionDate;

    @Column(name = "total_amount")
    @NotNull
    @Setter
    @Getter
    private long totalAmount;

    public TransactionModel() {
    }

    public TransactionModel(long id, long voucherId, Date transactionDate, long totalAmount) {
        this.id = id;
        this.voucherId = voucherId;
        this.transactionDate = transactionDate;
        this.totalAmount = totalAmount;
    }
}
