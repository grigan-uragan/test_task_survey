package ru.grigan.test_task_survey.service;

import org.springframework.stereotype.Service;
import ru.grigan.test_task_survey.domain.Survey;
import ru.grigan.test_task_survey.repository.SurveyRepository;

import java.util.List;

@Service
public class SurveyService {
    private final SurveyRepository surveyRepository;

    public SurveyService(SurveyRepository surveyRepository) {
        this.surveyRepository = surveyRepository;
    }

    public List<Survey>getSurveyList() {
        return surveyRepository.findAll();
    }

    public void saveSurvey(Survey survey) {
        surveyRepository.save(survey);
    }

    public void deleteSurvey(Survey survey) {
        surveyRepository.delete(survey);
    }
}
