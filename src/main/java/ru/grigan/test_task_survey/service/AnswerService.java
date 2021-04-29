package ru.grigan.test_task_survey.service;

import org.springframework.stereotype.Service;
import ru.grigan.test_task_survey.domain.Answer;
import ru.grigan.test_task_survey.repository.AnswerRepository;

@Service
public class AnswerService {
    private final AnswerRepository repository;

    public AnswerService(AnswerRepository repository) {
        this.repository = repository;
    }

    public void saveAnswer(Answer answer) {
        repository.save(answer);
    }
}
