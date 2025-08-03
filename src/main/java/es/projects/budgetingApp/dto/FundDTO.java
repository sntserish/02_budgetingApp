package es.projects.budgetingApp.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
public class FundDTO {

    private Long fundId;
    private String fundName;
    private Double fundTargetAmount;
    private LocalDate fundTargetDate;
    private Long userId;

    public Long getFundId() {
        return fundId;
    }

    public void setFundId(Long fundId) {
        this.fundId = fundId;
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

    public LocalDate getFundTargetDate() {
        return fundTargetDate;
    }

    public void setFundTargetDate(LocalDate fundTargetDate) {
        this.fundTargetDate = fundTargetDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
