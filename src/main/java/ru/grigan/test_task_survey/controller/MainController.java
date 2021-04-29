package ru.grigan.test_task_survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.grigan.test_task_survey.domain.Answer;
import ru.grigan.test_task_survey.domain.Survey;
import ru.grigan.test_task_survey.domain.User;
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

    @GetMapping("/answers")
    public String showUserAnswers(@RequestParam("user_id") User user, Model model) {
        model.addAttribute("user", user);
        return "userAnswers";
    }
}
