package ru.grigan.test_task_survey.service;

import org.springframework.stereotype.Service;
import ru.grigan.test_task_survey.domain.User;
import ru.grigan.test_task_survey.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User saveUser(User user) {
        return repository.save(user);
    }
}
