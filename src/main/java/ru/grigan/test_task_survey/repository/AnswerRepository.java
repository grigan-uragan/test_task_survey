package ru.grigan.test_task_survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.grigan.test_task_survey.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
