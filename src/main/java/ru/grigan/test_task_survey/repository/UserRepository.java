package ru.grigan.test_task_survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grigan.test_task_survey.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
