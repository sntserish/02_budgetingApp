package es.projects.budgetingApp.model;

import es.projects.budgetingApp.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"user", "transaction"})
@Table(name = "funds")
public class Fund {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fundId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Category fundCategory;

    private String fundName;
    private Double fundTargetAmount;
    private Double fundCurrentAmount;
    private LocalDate fundTargetDate;
//    @JdbcTypeCode(SqlTypes.JSON)
//    @OneToMany(mappedBy = "fund")
//    private List<Transaction> transactionList;
    private Boolean fundIsActive;
    private LocalDateTime fundCreatedAt;
    private LocalDateTime fundEditedAt;

    @OneToMany(mappedBy = "fund", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactionList = new ArrayList<>();

    public Fund(User user, String fundName, Category fundCategory, Double fundTargetAmount, LocalDate fundTargetDate,
                List<Transaction> transactionList, Boolean fundIsActive, LocalDateTime fundCreatedAt, LocalDateTime fundEditedAt) {
        this.user = user;
        this.fundName = fundName;
        this.fundCategory = fundCategory;
        this.fundTargetAmount = fundTargetAmount;
        this.fundTargetDate = fundTargetDate;
        //this.transactionList = transactionList;
        this.fundIsActive = fundIsActive;
        this.fundCreatedAt = fundCreatedAt;
        this.fundEditedAt = fundEditedAt;
    }

    public Fund(User user, String fundName, Category fundCategory, Double fundTargetAmount, LocalDate fundTargetDate,
                List<Transaction> transactionList, Boolean fundIsActive) {
        this.user = user;
        this.fundName = fundName;
        this.fundCategory = fundCategory;
        this.fundTargetAmount = fundTargetAmount;
        this.fundTargetDate = fundTargetDate;
        //this.transactionList = transactionList;
        this.fundIsActive = fundIsActive;
    }

    public Fund(User user, String fundName, Category fundCategory, Double fundTargetAmount, LocalDate fundTargetDate, Boolean fundIsActive) {
        this.user = user;
        this.fundName = fundName;
        this.fundCategory = fundCategory;
        this.fundTargetAmount = fundTargetAmount;
        this.fundTargetDate = fundTargetDate;
        this.fundIsActive = fundIsActive;
    }

//    @Override
//    public String toString() {
//        return "Fund{" +
//                "fundId=" + fundId +
//                ", user='" + user + '\'' +
//                ", fundName='" + fundName + '\'' +
//                ", fundCategory=" + fundCategory +
//                ", fundTargetAmount=" + fundTargetAmount +
//                ", fundTargetDate=" + fundTargetDate +
////                ", transactionList=" + transactionList +
//                ", fundIsActive=" + fundIsActive +
//                ", fundCreatedAt=" + fundCreatedAt +
//                ", fundEditedAt=" + fundEditedAt +
//                '}';
//    }


    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getFundCategory() {
        return fundCategory;
    }

    public void setFundCategory(Category fundCategory) {
        this.fundCategory = fundCategory;
    }

    public String getFundName() {
        return fundName;
    }

    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public Double getFundTargetAmount() {
        return fundTargetAmount;
    }

    public void setFundTargetAmount(Double fundTargetAmount) {
        this.fundTargetAmount = fundTargetAmount;
    }

    public Double getFundCurrentAmount() {
        return fundCurrentAmount;
    }

    public void setFundCurrentAmount(Double fundCurrentAmount) {
        this.fundCurrentAmount = fundCurrentAmount;
    }

    public LocalDate getFundTargetDate() {
        return fundTargetDate;
    }

    public void setFundTargetDate(LocalDate fundTargetDate) {
        this.fundTargetDate = fundTargetDate;
    }

    public Boolean getFundIsActive() {
        return fundIsActive;
    }

    public void setFundIsActive(Boolean fundIsActive) {
        this.fundIsActive = fundIsActive;
    }

    public LocalDateTime getFundCreatedAt() {
        return fundCreatedAt;
    }

    public void setFundCreatedAt(LocalDateTime fundCreatedAt) {
        this.fundCreatedAt = fundCreatedAt;
    }

    public LocalDateTime getFundEditedAt() {
        return fundEditedAt;
    }

    public void setFundEditedAt(LocalDateTime fundEditedAt) {
        this.fundEditedAt = fundEditedAt;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
