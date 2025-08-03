package es.projects.budgetingApp.service;

import com.fasterxml.uuid.Generators;
import es.projects.budgetingApp.model.Fund;
import es.projects.budgetingApp.model.Transaction;
import es.projects.budgetingApp.model.User;
import es.projects.budgetingApp.repository.FundRepository;
import es.projects.budgetingApp.repository.TransactionRepository;
import es.projects.budgetingApp.repository.UserRepository;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final FundRepository fundRepository;
    private final UserRepository userRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, FundRepository fundRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.fundRepository = fundRepository;
        this.userRepository = userRepository;
    }

    public Transaction createTransaction(Long userId, Long fundId, Transaction transaction){
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);

        // Set UserID
        transaction.setUser(user);

        Fund fund = fundRepository.findById(fundId).orElseThrow(NoSuchElementException::new);

        // Update fund current amount
        fund.setFundCurrentAmount(fund.getFundCurrentAmount() + transaction.getTransactionAmount());
        fundRepository.save(fund);

        transaction.setFund(fund);
        transaction.setTransactionDate(LocalDateTime.now());
        transaction.setTransactionId(uuidToBase64(Generators.timeBasedEpochGenerator().generate()));
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactions(){
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id){
        Optional<Transaction> optional = Optional.empty();
        if(transactionRepository.findById(id).isPresent()){
            optional = transactionRepository.findById(id);
        }
        return optional;
    }

    private static String uuidToBase64(UUID generatedUUID){
        Base64 base64 = new Base64();
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[16]);
        byteBuffer.putLong(generatedUUID.getMostSignificantBits());
        byteBuffer.putLong(generatedUUID.getLeastSignificantBits());
        return Base64.encodeBase64URLSafeString(byteBuffer.array());
    }
}
