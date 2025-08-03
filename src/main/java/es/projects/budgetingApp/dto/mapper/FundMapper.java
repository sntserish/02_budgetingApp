package es.projects.budgetingApp.dto.mapper;

import es.projects.budgetingApp.dto.FundDTO;
import es.projects.budgetingApp.model.Fund;
import org.springframework.stereotype.Component;

@Component
public class FundMapper {
    public FundDTO toDTO(Fund fund) {
        FundDTO dto = new FundDTO();
        dto.setFundId(fund.getFundId());
        dto.setFundName(fund.getFundName());
        dto.setFundTargetAmount(fund.getFundTargetAmount());
        dto.setFundTargetDate(fund.getFundTargetDate());
        dto.setUserId(fund.getUser().getUserId());
        return dto;
    }
}
