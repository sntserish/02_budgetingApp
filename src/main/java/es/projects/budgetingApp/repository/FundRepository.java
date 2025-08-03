package es.projects.budgetingApp.repository;

import es.projects.budgetingApp.model.Fund;
import es.projects.budgetingApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FundRepository extends JpaRepository<Fund, Long> {
    public List<Fund> findByUser(User user);
}
