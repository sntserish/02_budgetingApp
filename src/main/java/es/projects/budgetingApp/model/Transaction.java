package es.projects.budgetingApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@NoArgsConstructor
@ToString(exclude = {"fund", "user"})
public class Transaction {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String transactionId;

    @ManyToOne
    @JoinColumn(name = "fund_id")
    private Fund fund;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Double transactionAmount;
    private LocalDateTime transactionDate;

    public Transaction(String transactionId, Fund fund, User user, Double transactionAmount, LocalDateTime transactionDate) {
        this.transactionId = transactionId;
        this.fund = fund;
        this.user = user;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public Transaction(Fund fund, Double transactionAmount, LocalDateTime transactionDate) {
        this.fund = fund;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
    }

    public Fund getFund() {
        return fund;
    }

    public void setFund(Fund fund) {
        this.fund = fund;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }

    //    @Override
//    public String toString() {
//        return "Transaction{" +
//                "id=" + transactionId +
//                ", fund=" + fund +
//                ", transactionAmount=" + transactionAmount +
//                ", transactionDate=" + transactionDate +
//                '}';
//    }
}
