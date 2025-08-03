package es.projects.budgetingApp.service;

import es.projects.budgetingApp.dto.FundDTO;
import es.projects.budgetingApp.model.Fund;
import es.projects.budgetingApp.model.User;
import es.projects.budgetingApp.repository.FundRepository;
import es.projects.budgetingApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FundService {

    private final FundRepository fundRepository;
    private final UserRepository userRepository;

    @Autowired
    public FundService(FundRepository fundRepository, UserRepository userRepository) {
        this.fundRepository = fundRepository;
        this.userRepository = userRepository;
    }

    public List<Fund> getFunds(){
        return fundRepository.findAll();
    }

    public Fund createFund(Long userId, Fund fund){
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("User not found with ID" + userId));
        try{
            fund.setUser(user);
            fund.setFundCreatedAt(LocalDateTime.now());
            fund.setFundEditedAt(LocalDateTime.now());
            fund.setFundIsActive(true);
            fund.setFundCurrentAmount(0D);
            return fundRepository.save(fund);
        } catch (Exception e){
            throw new RuntimeException("Error occurred while creating user", e);
        }
    }

    public Optional<Fund> getFundById(Long id){
        Optional<Fund> optional = Optional.empty();
        if(fundRepository.findById(id).isPresent()){
            optional = fundRepository.findById(id);
        }
        return optional;
    }

    public List<Fund> getFundsByUserId(Long userId){
        if(userRepository.findById(userId).isPresent()){
            User user = userRepository.findById(userId).get();
            return fundRepository.findByUser(user);
        } else {
            throw new NoSuchElementException();
        }
    }

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
