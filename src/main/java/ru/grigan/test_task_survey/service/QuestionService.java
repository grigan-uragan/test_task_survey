package ru.grigan.test_task_survey.service;

import org.springframework.stereotype.Service;
import ru.grigan.test_task_survey.domain.Question;
import ru.grigan.test_task_survey.repository.QuestionRepository;

@Service
public class QuestionService {
    private final QuestionRepository repository;

    public QuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    public Question addQuestion(Question question) {
        return repository.save(question);
    }

    public void deleteQuestion(Question question) {
        repository.delete(question);
    }
}
