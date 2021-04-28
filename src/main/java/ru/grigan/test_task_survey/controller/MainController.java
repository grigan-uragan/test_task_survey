package ru.grigan.test_task_survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.grigan.test_task_survey.domain.Survey;
import ru.grigan.test_task_survey.service.SurveyService;

import java.util.List;

@Controller
public class MainController {

    private final SurveyService service;

    public MainController(SurveyService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getHelloPage(Model model) {
        List<Survey> surveyList = service.getSurveyList();
        model.addAttribute("surveyList", surveyList);
        return "hello";
    }

    @GetMapping("/quiz/{id}")
    public String getSurveyQuestion(@PathVariable("id") Survey survey, Model model) {
        model.addAttribute("survey", survey);
        return "questions";
    }
}
