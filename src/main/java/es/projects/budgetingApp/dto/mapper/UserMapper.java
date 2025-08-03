package es.projects.budgetingApp.dto.mapper;

import es.projects.budgetingApp.dto.UserDTO;
import es.projects.budgetingApp.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setActiveStatus(user.getActiveStatus());
        return dto;
    }
}
